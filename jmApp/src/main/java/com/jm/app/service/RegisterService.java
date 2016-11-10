package com.jm.app.service;

import com.jm.app.bean.User;

/**
 * 用户注册服务接口
 * @author songwp 2016-10-03
 *
 */
public interface RegisterService {
	
	/**
	 * 验证新用户的手机号是否已经注册
	 * @param tel
	 * @return true-未注册使用              false-已注册使用 
	 *       
	 */
	public boolean validateTel(String tel);
	/**
	 * 保存用户信息
	 * @param user
	 */
	public void save(User user);

}
