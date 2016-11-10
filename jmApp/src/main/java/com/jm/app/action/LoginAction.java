package com.jm.app.action;

import java.util.Map;

import com.jm.app.bean.User;
import com.jm.app.service.LoginService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {

	private ActionContext context;
	
	private LoginService loginService;
	
	private String tel;
	
	private String password;
	
    private Map<String,Object> session;
	
	private Map<String,Object> request;
	
	@Override
	public String execute() throws Exception {
		
		context=ActionContext.getContext();
		session=(Map) context.getSession();
		request=(Map) context.get("request");
		User user=loginService.getUserByTel(tel);
		if(user==null)
		{
			request.put("success", 1); //该手机号未注册
			return "login_failture";
		}
		if(!user.getPassword().equals(password))
		{
			request.put("success", 2); //用户密码错误
			return "login_failture";
		}
		session.put("user", user);
		return "login_success";
	}

	public LoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
