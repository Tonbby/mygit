package com.tonbby.myrequest;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestWrapper;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyRequestWrapper extends ServletRequestWrapper{

	public MyRequestWrapper(ServletRequest request) {
		super(request);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String getParameter(String name) {
		String old = super.getParameter(name);
        String n = null; //n存放编码后的字符串
        if (old!= null && !old.equals("")) {
            try {
                n = new String(old.getBytes("ISO-8859-1"),"UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        System.out.println("我执行了吗");
        return n;

	}
	@Override
    public String[] getParameterValues(String name) {
        String[] old_valueArray = super.getParameterValues(name);
        String[] new_valueArray = null;
        if (old_valueArray != null && old_valueArray.length > 0) {
            new_valueArray = new String[old_valueArray.length];
            for (int i = 0; i < old_valueArray.length; i++) {
                String tempValue = old_valueArray[i];
                if (tempValue != null && !tempValue.equals("")) {
                    try {
                        tempValue = new String(tempValue
                                .getBytes("ISO-8859-1"), "UTF-8");
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                    new_valueArray[i] = tempValue;
                }
            }
        }
        return new_valueArray;
    }
//	@Override
//	public Map getParameterMap() {
//		// TODO Auto-generated method stub
//		Map old =  super.getParameterMap();
//		Map n = new HashMap();
//		n.putAll(old);
//		for (Object value : n.values()) {  
//			  
//			try {
//				value = new String(((String) value)
//				        .getBytes("ISO-8859-1"), "UTF-8");
//			} catch (UnsupportedEncodingException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//
//		return n;
//	}
	public void doFilter(ServletRequest req, ServletResponse res,
            FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        String method = request.getMethod();
        if (method.equals("GET")) {
            // GET请求，重写request.getParameter方法。
            request = (HttpServletRequest) new MyRequestWrapper(request);
        } else {
            // struts.i18n.encoding和request.setCharacterEncoding("UTF-8")只针对POST请求有效。有GET请求无效。
            request.setCharacterEncoding("UTF-8");
        }
      //  request = (HttpServletRequest) new MyRequestWrapper(request);

        response.setCharacterEncoding("UTF-8");
        chain.doFilter(request, response);
    }

}
