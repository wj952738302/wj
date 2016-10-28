package com.jzfactr.jd.intercepter;

import java.util.Map;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;

import com.jzfactr.jd.bean.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AutoInterceper extends AbstractInterceptor{
	

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {

		HttpServletRequest request=ServletActionContext.getRequest();
		//引入cookie数组
		Cookie[] cookies=request.getCookies();
		if(cookies!=null && cookies.length>0)
		{
			for(Cookie cookie:cookies)
			{
				if(cookie.getName().equals("user"))
				{
					String value=cookie.getValue();
					String[] nv=value.split(",");
					User user=new User();
					user.setName(nv[0]);
					user.setPassword(nv[1]);
					HttpSession session=request.getSession();
					session.setAttribute("user", user);
					//不拦截jsp，
//					if(request.getServletPath().equals("/index.jsp"))
//					{
//						//获取服务地址
//						String path = request.getContextPath();
//					    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
//						return "mainAction";
//					}
						
				}
			}
		}
		return arg0.invoke();
	}

	
}
