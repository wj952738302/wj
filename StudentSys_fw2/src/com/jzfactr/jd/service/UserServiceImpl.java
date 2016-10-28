package com.jzfactr.jd.service;

import java.util.List;

import com.jzfactr.jd.bean.User;
import com.jzfactr.jd.dao.UserDAO;

public class UserServiceImpl implements UserServers {
	private UserDAO userDao;
	

	public UserDAO getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}

	@Override
	//1
	public List findAll() {
		// TODO Auto-generated method stub
		return userDao.findAll();
	}

	@Override
	//2
	public List findBlackList() {
		// TODO Auto-generated method stub
		return userDao.findBlackList();
	}

	@Override
	//3
	public void updateStatus(User user) {
		// TODO Auto-generated method stub
		userDao.attachDirty(user);

	}

	@Override
	//4
	public User findById(int id) {
		// TODO Auto-generated method stub
		return userDao.findById(id);
	}

	@Override
	//5
	public User findByName(String name) {
		// TODO Auto-generated method stub
		return userDao.findByname2(name);
	}

	@Override
	//6
	public void updateServes(User user) {
		// TODO Auto-generated method stub
		userDao.attachDirty(user);

	}

	@Override
	//7
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		userDao.delete(id);

	}

	@Override
	//8
	public void addUser(User user) {
		// TODO Auto-generated method stub
		userDao.save(user);

	}
	public static void main(String[] args) {
		UserServiceImpl u=new UserServiceImpl();
		//1
//		System.out.println(u.findAll());
		//2
//		System.out.println(u.findBlackList());
		//3
//		User us=u.findById(5);
//		us.setServer(1);
//		u.updateStatus(us);
		//4
//		System.out.println(u.findById(5));
		//5
//		System.out.println(u.findByName("q"));
		//6
//		User us=u.findById(17);
//		us.setName("1231");
//		u.updateServes(us);
		//7
//		u.deleteUser(25);
		//8
		User user=new User();
		user.setName("qwe");
		user.setPassword("123");
		user.setEmail("qwe@qq.com");
		user.setServer(1);
		u.addUser(user);
		
	}

}
