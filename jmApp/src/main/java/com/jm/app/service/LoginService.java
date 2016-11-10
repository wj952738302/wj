package com.jm.app.service;

import com.jm.app.bean.User;

public interface LoginService {
	
	/**
	 * 通过电话获得用户信息
	 * @param tel
	 * @return
	 */
	public User getUserByTel(String tel);
	
	

}
