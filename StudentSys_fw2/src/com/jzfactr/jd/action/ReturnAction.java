package com.jzfactr.jd.action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class ReturnAction extends ActionSupport{
//	private HttpServletRequest request;

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		//删除session中的user对象
		HttpSession session=ServletActionContext.getRequest().getSession();
//				HttpSession session=request.getSession();
				session.removeAttribute("user");
				//删除cookie中的user对象
				Cookie cookie = new Cookie("user", null); 
				cookie.setPath("/");
				cookie.setMaxAge(0);
//				request.addCookie(cookie); 
				//从定向到登陆页面
				return "return";
		
		
	}
	
	

}
