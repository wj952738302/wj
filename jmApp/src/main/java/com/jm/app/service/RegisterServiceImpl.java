package com.jm.app.service;

import com.jm.app.bean.User;
import com.jm.app.dao.UserDAO;

public class RegisterServiceImpl implements RegisterService {

	private UserDAO userDao;
	
	@Override
	public boolean validateTel(String tel) {
		// TODO Auto-generated method stub
		return userDao.validateTel(tel);
	}

	public UserDAO getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		this.userDao.save(user);
	}

	
}
