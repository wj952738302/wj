package com.jzfactr.jd.intercepter;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.jzfactr.jd.bean.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * @author jay 2016-10-17
 * 自定义过滤器，进行登陆验证
 */
public class LoginIntercepter extends AbstractInterceptor{
	
	

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		ActionContext context=arg0.getInvocationContext();
//		Map session=context.getSession();
//		User user=(User) session.get("user");
		HttpSession session=ServletActionContext.getRequest().getSession();
		User user=(User) session.getAttribute("user");
		if(user!=null)
			return arg0.invoke();//放行
		return "login";//到登陆
	}

}
