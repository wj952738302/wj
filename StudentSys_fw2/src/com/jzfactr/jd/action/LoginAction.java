package com.jzfactr.jd.action;

import java.io.Serializable;
import java.sql.Connection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.naming.NamingException;
import javax.naming.Reference;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Cache;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionBuilder;
import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;
import org.hibernate.StatelessSessionBuilder;
import org.hibernate.TypeHelper;
import org.hibernate.engine.spi.FilterDefinition;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.metadata.CollectionMetadata;
import org.hibernate.stat.Statistics;

import com.jzfactr.jd.bean.Clasz;
import com.jzfactr.jd.bean.Student;
import com.jzfactr.jd.bean.User;
import com.jzfactr.jd.service.LoginServers;
import com.jzfactr.jd.service.LoginServiceImpl;
import com.jzfactr.jd.service.StudentService;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware{
	private LoginServers service;
	
	private String username1;//登陆用户名
	private String password1;//登陆密码
	private int log_res;//登陆
	private User user=new User();
	private Integer auto_load;//自动登陆参数 
	private Map session;
	
	
	public LoginServers getService() {
		return service;
	}


	public void setService(LoginServers service) {
		this.service = service;
	}


	@Override
	public String execute() throws Exception {
		if(auto_load!=null && auto_load==1)
		{
			//设置cookie
			Cookie cookie=new Cookie("user", user.getName()+","+user.getPassword());
			cookie.setMaxAge(60);
			cookie.setPath("/StudentSys_fw2");
			HttpServletResponse response = ServletActionContext.getResponse();
			response.addCookie(cookie);

		}
		log_res=service.login(user);
		if(log_res==0)
		{
			if(user.getName().equals("admin"))
			{
				session.put("user", user);
				return "log2";
			}else{
				session.put("user", user);
				return "log0";
			}
			
		}else {
			return "input";
		}
		
	}
	
	
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public String getUsername1() {
		return username1;
	}
	public void setUsername1(String username) {
		this.username1 = username;
	}
	public String getPassword1() {
		return password1;
	}
	public void setPassword1(String password) {
		this.password1 = password;
	}


	public int getLog_res() {
		return log_res;
	}


	public void setLog_res(int log_res) {
		this.log_res = log_res;
	}


	public Map getSession() {
		return session;
	}


	public void setSession(Map session) {
		this.session = session;
	}


	public Integer getAuto_load() {
		return auto_load;
	}


	public void setAuto_load(Integer auto_load) {
		this.auto_load = auto_load;
	}

	
	
	

}
