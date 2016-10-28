package com.jzfactr.jd.service;

import com.jzfactr.jd.bean.User;

/**
 * 登陆注册服务接口
 * @author jay 2016-08-25
 *
 */
public interface LoginServers {
	/**
	 * 注册用户
	 * @param user 注册的用户信息
	 * @return 0=注册成功，1=用户存在
	 */
	int register(User user);
	/**
	 * 登陆
	 * @param user 登陆的用户信息
	 * @return 0=注册成功，1=该用户不存在，2=该用户密码不正确
	 */
	int login(User user);
	/**
	 * 用户登录
	 * @param username 需要传入用户名
	 * @param password和密码
	 * @return 成功返回登陆用户对象
	 */
	User login(String username,String password);

}
