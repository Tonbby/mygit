package com.tonbby.web;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;

import com.tonbby.constant.Constant;
import com.tonbby.domain.User;
import com.tonbby.domain.UserMapping;
import com.tonbby.myconventer.MyConventer;
import com.tonbby.myrequest.MyRequestWrapper;
import com.tonbby.service.UserService;
import com.tonbby.service.impl.UserServiceImpl;
import com.tonbby.utils.MD5Utils;
import com.tonbby.utils.UUIDUtils;

public class UserServlet extends BaseServlet {

	
	/**
	 * 注册
	 * */
	public String registUI(HttpServletRequest req,HttpServletResponse resp){
		System.out.println("registUI方法执行了");
		
		return "/jsp/register.jsp";
	}
	public String regist(HttpServletRequest request,HttpServletResponse response) throws Exception{
		//封装数据
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html,charset=utf-8");
		User user = new User();
		
		ConvertUtils.register(new MyConventer(), Date.class);
		
	//	BeanUtils.populate(user, request.getParameterMap());
		MyRequestWrapper r = new MyRequestWrapper(request);
		user = UserMapping.Mapping(user, r);
	
		
	//	System.out.println(user.getName());
		
		user.setUid(UUIDUtils.getId());
		user.setCode(UUIDUtils.getCode());
		user.setPassword(MD5Utils.md5(user.getPassword()));
		//使用service完成注册
		UserService us = new UserServiceImpl();
		us.regist(user);
		
		
	
		//页面请求转发
//		response.setContentType("text/html;charset=utf-8");
//		request.setCharacterEncoding("utf-8");
		if(user==null){
			//通过激活码没有找到用户
			request.setAttribute("msg", "啊咧~~嘤嘤嘤~~注册失败");
		}else if(user.getEmail()!=null){
			//添加信息
			request.setAttribute("msg", "注册成功~~快去激活吧~~");
		}else{
			request.setAttribute("msg", "注册失败~~邮箱地址没输入好~~");
		}
		return "jsp/msg.jsp";
		
	}
	
	/**
	 * 激活邮件
	 * @throws Exception 
	 * */
	public String active(HttpServletRequest request,HttpServletResponse response) throws Exception{
		System.out.println("喵喵喵？");
		String code = (String) request.getParameter("code");
		System.out.println(code);
		//使用service完成激活
		UserService us = new UserServiceImpl();
		System.out.println("..");
		User user = us.active(code);
		System.out.println("....");
		if(user == null){
			System.out.println("kong");
			request.setAttribute("msg", "用户不存在");
		
		}else{
			request.setAttribute("msg", "激活成功");
		}
		
		return "jsp/msg.jsp";
		
	}
	/**
	 * 登录
	 * */
	public String loginUI(HttpServletRequest req,HttpServletResponse resp){
		System.out.println("loginUI方法执行了");
		
		return "/jsp/login.jsp";
	}
	public String login(HttpServletRequest req,HttpServletResponse resp) throws Exception{
		UserService us = new UserServiceImpl();
		MyRequestWrapper r = new MyRequestWrapper(req);
		String username = r.getParameter("username");
		String password = r.getParameter("password");
		password = MD5Utils.md5(password);
		System.out.println(password);
		User user = us.login(username,password);

		if(user == null){
			//用户名密码不匹配
			req.setAttribute("msg", "用户名密码不匹配");
			System.out.println("不匹配");
			return "/jsp/login.jsp";
		}else{
			//继续判断用户的状态是否激活
			//比较的时候应该把常量放在前面
			if(Constant.USER_IS_ACTIVE != user.getState()){
				req.setAttribute("msg", "  用户未激活");
				return "/jsp/msg.jsp";
			}
		}
		//将user放在session中重定向
		req.getSession().setAttribute("user", user);
		resp.sendRedirect(req.getContextPath()+"/index"); // /store
		
		return null;
		
	}
	public String logout(HttpServletRequest req,HttpServletResponse resp){
	//干掉session
		req.getSession().invalidate();
		
		return "/jsp/index.jsp";
	}
}
