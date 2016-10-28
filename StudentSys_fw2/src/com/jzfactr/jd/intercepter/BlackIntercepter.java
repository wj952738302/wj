package com.jzfactr.jd.intercepter;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.jzfactr.jd.bean.Black;
import com.jzfactr.jd.bean.User;
import com.jzfactr.jd.service.BlackService;
import com.jzfactr.jd.service.BlackServiceImpl;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class BlackIntercepter extends AbstractInterceptor{
	private BlackService service;
	public BlackService getService() {
		return service;
	}

	public void setService(BlackService service) {
		this.service = service;
	}

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session=ServletActionContext.getRequest().getSession();
		//获取登陆用户信息
				User user=(User)session.getAttribute("user");
				//BlackService service=new BlackServiceImpl();
				//获取黑名单的用户
				List<Black> blackList =service.getInTable();
				//比較用戶是否在黑名單
				for(Black black:blackList)
				{
					if(user.getName().equals(black.getUsername()))
					{

						return "error";
					}
				}
		         return arg0.invoke();
	}

	
	
	

}
