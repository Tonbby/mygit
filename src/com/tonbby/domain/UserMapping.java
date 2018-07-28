package com.tonbby.domain;

import com.tonbby.myrequest.MyRequestWrapper;

public class UserMapping {

	public static User Mapping(User user,MyRequestWrapper r){
		user.setName(r.getParameter("name"));
		user.setUsername(r.getParameter("username"));
		user.setBirthday(r.getParameter("birthday"));
		user.setCode(r.getParameter("code"));
		user.setEmail(r.getParameter("email"));
		user.setPassword(r.getParameter("password"));
		user.setSex(r.getParameter("sex"));
		//Integer i = Integer.valueOf(r.getParameter("state"));
		//user.setState(i);
		user.setTelephone(r.getParameter("telephone"));
		user.setUid(r.getParameter("uid"));
		return user;
	}
}
