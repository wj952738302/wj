package com.jzfactr.jd.action;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.jzfactr.jd.bean.Black;
import com.jzfactr.jd.service.BlackService;
import com.jzfactr.jd.service.BlackServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class BlackAction extends ActionSupport implements ServletRequestAware{
	
	private BlackService service;
	private HttpServletRequest request;
	private File img_file;
	
	
	public BlackService getService() {
		return service;
	}


	public void setService(BlackService service) {
		this.service = service;
	}


	public String uploadImage()
	{
		request=ServletActionContext.getRequest();
		String contextPathString=request.getSession().getServletContext().getRealPath("/");
		File parentfile=new File(contextPathString+"/head_img","header.jpg");
		try {
			FileUtils.copyFile(img_file, parentfile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";
	}


	@Override
	public String execute() throws Exception {
		request=ServletActionContext.getRequest();
		List<Black> bList=service.getAll();
		request.setAttribute("List", bList);
		return super.execute();
	}


	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		this.request=arg0;
		
	}


	public File getImg_file() {
		return img_file;
	}


	public void setImg_file(File img_file) {
		this.img_file = img_file;
	}
	

}
