package com.jzfactr.jd.service;

import com.jzfactr.jd.bean.User;
import com.jzfactr.jd.dao.BlackDAO;
import com.jzfactr.jd.dao.UserDAO;

/**
 * 登陆注册实现类
 * @author jay 2016-08-25
 *
 */
public class LoginServiceImpl implements LoginServers{
	
	private UserDAO userDao;
	
	

	public UserDAO getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}

	@Override
	public int register(User user) {
		// TODO Auto-generated method stub
		//判断该用户是否存在
		User us=userDao.findByname2(user.getName());
		if(us==null)
		{
			//插入数据
			userDao.save(user);
			return 0;
		}
		System.out.println("该用户"+user.getName()+"已经存在");
		return 1;
	}

	@Override
	public int login(User user) {
		// TODO Auto-generated method stub
		//判断用户是否存在
		User us=userDao.findByname2(user.getName());
		if(us==null)
		{
			System.out.println("该用户"+user.getName()+"不存在");
			return 1;
		}else
		{
			//判断用户密码是否相同
			if(us.getPassword().equals(user.getPassword()))
			{
				return 0;
			}else
			{
				System.out.println("该用户的密码不正确");
				return 2;
			}
		}
		
	}

	@Override
	public User login(String username, String password) {
		// TODO Auto-generated method stub
		
		return null;
	}

}