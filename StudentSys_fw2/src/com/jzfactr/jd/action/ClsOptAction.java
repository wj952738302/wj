package com.jzfactr.jd.action;

import com.jzfactr.jd.bean.Clasz;
import com.jzfactr.jd.bean.Student;
import com.jzfactr.jd.service.ClaszService;
import com.jzfactr.jd.service.ClaszServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class ClsOptAction extends ActionSupport{
	
	private ClaszService service;
	private Clasz clasz=new Clasz();
	
	
	public ClaszService getService() {
		return service;
	}
	public void setService(ClaszService service) {
		this.service = service;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return super.execute();
	}
	/**
	 * 添加班级访问方法
	 * @return
	 */
	public String add()
	{
		service.add(clasz);
		return "success";
	}
	/**
	 * 删除班级的方法
	 * @return
	 */
	public String del()
	{
		service.delete(clasz.getId(),true);
		return "success";
	}
	public String edit()
	{
		service.update(clasz);
		return "success";
	}
	
	public Clasz getClasz() {
		return clasz;
	}
	public void setClasz(Clasz clasz) {
		this.clasz = clasz;
	}
	
}
