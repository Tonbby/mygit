package com.tonbby.web;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Class clazz = this.getClass();
		//获取请求的方法
		String name = req.getParameter("method");
		if(name == null){
			name = "index";
		}
		System.out.println("baseServlet执行了");
		Method m;
		try {
			m = clazz.getMethod
					(name, HttpServletRequest.class,HttpServletResponse.class);
			String s = (String) m.invoke(this, req,resp);
			System.out.println(s);
			if(s!=null){
				req.getRequestDispatcher(s).forward(req, resp);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
	}
}
