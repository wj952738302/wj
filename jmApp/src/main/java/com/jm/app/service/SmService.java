package com.jm.app.service;

public interface SmService {
	
	/**
	 * 发送短信
	 * @param tel 手机号码
	 * @param content 发送内容
	 */
	void sendMessage(String tel,String content);

}
