package com.jzfactr.jd.action;

import com.jzfactr.jd.bean.User;
import com.jzfactr.jd.service.LoginServers;
import com.jzfactr.jd.service.LoginServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author jay 2016-10-13
 * 
 */
public class RegisterAction extends ActionSupport {
	private LoginServers service;
	
	private String email;//邮箱地址
	private String username;//注册用户名
	private String password;//注册密码
	private String password2;//确认密码
	private int reg_res;//注册结果
	
	

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("email="+email+",username="+username+",password="+password);
		User user=new User();
		user.setEmail(email);
		user.setName(username);
		user.setPassword(password);
		reg_res=service.register(user);
		
		return super.execute();
	}
	
	

	public LoginServers getService() {
		return service;
	}

	public void setService(LoginServers service) {
		this.service = service;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getReg_res() {
		return reg_res;
	}

	public void setReg_res(int reg_res) {
		this.reg_res = reg_res;
	}



	public String getPassword2() {
		return password2;
	}



	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	
	

}
