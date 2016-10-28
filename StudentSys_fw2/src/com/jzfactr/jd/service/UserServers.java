package com.jzfactr.jd.service;

import java.util.List;

import com.jzfactr.jd.bean.User;


/**
 * @author jay 
 * 用户信息查看
 */
public interface UserServers {
	/**
	 * 查询所有用户信息
	 * @return
	 */
	List findAll();
	/**
	 * 查询黑名单用户信息
	 * @return
	 */
	List findBlackList();
	/**
	 * 更新黑名单信息
	 * @param user
	 */
	void updateStatus(User user);
	/**
	 * 根据Id查询用户信息
	 * @param id
	 * @return
	 */
	User findById(int id);
	/**
	 * 根据Name查询用户信息
	 * @param name
	 * @return
	 */
	User findByName(String name);
	/**
	 * 更新
	 * @param user
	 */
	void updateServes(User user);
	/**
	 * 删除用户信息
	 * @param id
	 */
	void deleteUser(int id);
	/**
	 * 添加用户信息
	 * @param user
	 */
	void addUser(User user);

}
