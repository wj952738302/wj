																																																																																																																																																																																																																																																																																package com.jzfactr.jd.action;

import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.jzfactr.jd.bean.Black;
import com.jzfactr.jd.service.BlackService;
import com.jzfactr.jd.service.BlackServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class BlackOptAction extends ActionSupport{
	
	private BlackService service;
	private Black black;
	private String opt;
	private String bname;
	
	

	public BlackService getService() {
		return service;
	}

	public void setService(BlackService service) {
		this.service = service;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		black=service.findByName(bname);
		if(black==null && opt.equals("0"))
		{
			black=new Black();
			black.setUsername(bname);
			black.setIncludeDate(new Timestamp(new Date().getTime()));
			if(black.getUsername().equals(""))
				return "back";
			service.saveBlack(black);
		}
		if(black!=null)
		{
			if(opt!=null && opt.equals("0"))
				black.setRemoved(0);
			black.setIncludeDate(new Timestamp(new Date().getTime()));
			if(opt!=null && opt.equals("1"))
				black.setRemoved(1);
			black.setIncludeDate(new Timestamp(new Date().getTime()));
			service.updateBlack(black);
			
		}
		return "back";
	}

	public String getOpt() {
		return opt;
	}

	public void setOpt(String opt) {
		this.opt = opt;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}
	
	

}
