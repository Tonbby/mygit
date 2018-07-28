package com.tonbby.web;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;

import com.tonbby.domain.User;
import com.tonbby.domain.UserMapping;
import com.tonbby.myconventer.MyConventer;
import com.tonbby.myrequest.MyRequestWrapper;

public class TestServlet extends BaseServlet {

	public String test(HttpServletRequest request,HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("UTF-8");
		//request.setCharacterEncoding("utf-8");
		//HttpServletRequest r = new MyRequestWrapper(request);
//		MyRequestWrapper r = new MyRequestWrapper(request);
//		User user = new User();
//
//		user = UserMapping.Mapping(user, r);
	//	String n = r.getParameter("name");
		//String u = r.getParameter("username");
//		Map<String,Object> arr = r.getParameterMap();
	//	System.out.println(arr.get("name")+""+arr.get("username"));
		//System.out.println(n+u);
	//	ConvertUtils.register(new MyConventer(), Date.class);
		//Date值为空时，会出现No value specified for 'java.sql.Date'异常
	//	BeanUtils.populate(user, r.getParameterMap());
	//	n = new String(n.getBytes("ISO-8859-1"), "UTF-8");
	//	u = new String(u.getBytes("ISO-8859-1"), "UTF-8");
		//new_value = new String(old_value.getBytes("ISO-8859-1"),   "UTF-8");          
		//System.out.println(user.getName()+user.getCode()+user.getUsername());
		request.setAttribute("msg", "哈哈哈啊哈");
		return "/jsp/msg.jsp";
	}
}
