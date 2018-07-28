package com.tonbby.service.impl;

import java.sql.SQLException;

import com.tonbby.dao.UserDao;
import com.tonbby.dao.impl.UserDaoImpl;
import com.tonbby.domain.User;
import com.tonbby.service.UserService;
import com.tonbby.utils.MailUtils;

public class UserServiceImpl implements UserService{

	public void regist(User user) throws Exception {
		UserDao dao= new UserDaoImpl();
		dao.add(user);
		
		//发送邮件,email是收件人的地址，后面那个是邮件的内容。
		if(user.getEmail() != null){
			String emailMsg = "恭喜帅气的你成为我们中的一员，未来让我们一起谱写，点此开启新的征程吧"
					+ "~~<a href='http://localhost:8080/first_project/user?method=active&code="
					+user.getCode()+"'>★</a>";
			MailUtils.sendMail(user.getEmail(),emailMsg );
		}
		
		
	}

	

	public User active(String code) throws Exception {
		//通过激活码获取一个用户。用户有可能为空
		//若不为空，修改state，将0改成1
		UserDao dao= new UserDaoImpl();
		User user = dao.getByCode(code);
		if(user == null){
			System.out.println("111111111");
			return null;
		}else{
			dao.update(user);
			return user;
		}
	
		
	}

	public User login(String username, String password) throws Exception {
		//用户登录
		UserDao ud = new UserDaoImpl();
		return ud.getByUserNameandPwd(username,password);
	}

}
