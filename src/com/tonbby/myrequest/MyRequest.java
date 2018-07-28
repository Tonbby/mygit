package com.tonbby.myrequest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletInputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class MyRequest implements HttpServletRequest {

	public Object getAttribute(String name) {
		// TODO Auto-generated method stub
		return  this.getAttribute(name);
	}

	public Enumeration getAttributeNames() {
		// TODO Auto-generated method stub
		return this.getAttributeNames();
	}

	public String getCharacterEncoding() {
		// TODO Auto-generated method stub
		return this.getCharacterEncoding();
	}

	public void setCharacterEncoding(String env) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		
	}

	public int getContentLength() {
		// TODO Auto-generated method stub
		return this.getContentLength();
	}

	public String getContentType() {
		// TODO Auto-generated method stub
		return this.getContentType();
	}

	public ServletInputStream getInputStream() throws IOException {
		// TODO Auto-generated method stub
		return this.getInputStream();
	}

	public String getParameter(String name) {
		
		String old = this.getParameter(name);
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

	public Enumeration getParameterNames() {
		// TODO Auto-generated method stub
		return this.getParameterNames();
	}

	public String[] getParameterValues(String name) {
		// TODO Auo-generated method stub
		return this.getParameterValues(name);
	}

	public Map getParameterMap() {
		// TODO Auto-generated method stub
		return this.getParameterMap();
	}

	public String getProtocol() {
		// TODO Auto-generated method stub
		return this.getProtocol();
	}

	public String getScheme() {
		// TODO Auto-generated method stub
		return this.getScheme();
	}

	public String getServerName() {
		// TODO Auto-generated method stub
		return this.getServerName();
	}

	public int getServerPort() {
		// TODO Auto-generated method stub
		return 0;
	}

	public BufferedReader getReader() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getRemoteAddr() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getRemoteHost() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setAttribute(String name, Object o) {
		// TODO Auto-generated method stub
		
	}

	public void removeAttribute(String name) {
		// TODO Auto-generated method stub
		
	}

	public Locale getLocale() {
		// TODO Auto-generated method stub
		return null;
	}

	public Enumeration getLocales() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isSecure() {
		// TODO Auto-generated method stub
		return false;
	}

	public RequestDispatcher getRequestDispatcher(String path) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getRealPath(String path) {
		// TODO Auto-generated method stub
		return null;
	}

	public int getRemotePort() {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getLocalName() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getLocalAddr() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getLocalPort() {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getAuthType() {
		// TODO Auto-generated method stub
		return null;
	}

	public Cookie[] getCookies() {
		// TODO Auto-generated method stub
		return null;
	}

	public long getDateHeader(String name) {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getHeader(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public Enumeration getHeaders(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public Enumeration getHeaderNames() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getIntHeader(String name) {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getMethod() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPathInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPathTranslated() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getContextPath() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getQueryString() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getRemoteUser() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isUserInRole(String role) {
		// TODO Auto-generated method stub
		return false;
	}

	public Principal getUserPrincipal() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getRequestedSessionId() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getRequestURI() {
		// TODO Auto-generated method stub
		return null;
	}

	public StringBuffer getRequestURL() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getServletPath() {
		// TODO Auto-generated method stub
		return null;
	}

	public HttpSession getSession(boolean create) {
		// TODO Auto-generated method stub
		return null;
	}

	public HttpSession getSession() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isRequestedSessionIdValid() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isRequestedSessionIdFromCookie() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isRequestedSessionIdFromURL() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isRequestedSessionIdFromUrl() {
		// TODO Auto-generated method stub
		return false;
	}

}
