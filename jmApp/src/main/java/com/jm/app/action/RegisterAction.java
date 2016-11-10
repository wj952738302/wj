package com.jm.app.action;

import java.util.HashMap;
import java.util.Map;

import com.jm.app.bean.User;
import com.jm.app.service.RegisterService;
import com.jm.app.service.SmService;
import com.jm.app.util.RandomUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport {

private ActionContext context;
	
	private RegisterService registerService;
	
	private SmService smservice;
	
	private String tel;
	
	private String code;
	
	private String password;
	
	private Map<String,Boolean> dataMap;  
	
	private Map<String,Object> session;
	
	private Map<String,Object> request;
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		
		return "reg_success";
	}

	public String validateTel()
	{
		dataMap=new HashMap<String,Boolean>();
		if(registerService.validateTel(tel))
			dataMap.put("valid", true);
		else
			dataMap.put("valid", false);
		return SUCCESS;
	}

	public String createCode()
	{
		String newCode=RandomUtil.randomNum(4);
		context=ActionContext.getContext();
		session=(Map) context.getSession();
		session.put("code", newCode);
		session.put("tel", tel);
		System.out.println(newCode);
		System.out.println(tel);
		smservice.sendMessage(tel, newCode);
		return SUCCESS;
	}
	
	public String register()
	{
		context=ActionContext.getContext();
		session=(Map) context.getSession();
		String orgTel=(String)session.get("tel");
		String orgCode=(String)session.get("code");
		request=(Map)context.get("request");
		if(!orgTel.equals(tel))
		{
			request.put("error", 1); //手机号错误
			return "reg_failture";
		}
		if(!orgCode.equals(code))
		{
			request.put("error", 2); //验证码错误
			return "reg_failture";
		}
		request.put("success", 0); //注册成功 
		User user=new User();
		user.setTel(orgTel);
		user.setPassword(password);
		registerService.save(user);
		return "reg_success";
	
	}
	
	public Map<String, Boolean> getDataMap() {
		return dataMap;
	}

	public void setDataMap(Map<String, Boolean> dataMap) {
		this.dataMap = dataMap;
	}
	
	public RegisterService getRegisterService() {
		return registerService;
	}

	public void setRegisterService(RegisterService registerService) {
		this.registerService = registerService;
	}

	
	
	public SmService getSmservice() {
		return smservice;
	}

	public void setSmservice(SmService smservice) {
		this.smservice = smservice;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
