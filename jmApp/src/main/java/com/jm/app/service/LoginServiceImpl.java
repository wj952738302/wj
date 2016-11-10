package com.jm.app.service;



import java.util.List;

import com.jm.app.bean.User;
import com.jm.app.dao.UserDAO;

public class LoginServiceImpl implements LoginService {

	private UserDAO userDao;
	
	@Override
	public User getUserByTel(String tel) {

		List<User> userList=userDao.findByTel(tel);
		
		if(userList!=null && userList.size()>0)
			return userList.get(0);
		
		return null;
	}

	

	public UserDAO getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}

	
}
