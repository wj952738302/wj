package com.jm.app.action;

import java.util.Map;

import com.jm.app.bean.Project;
import com.jm.app.service.DetailService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DetailAction extends ActionSupport {
	
    private ActionContext context;
	
	private Integer proId;
	
	private DetailService detailService;
	
	private Map<String,Object> request;
	
	
	@Override
	public String execute() throws Exception {
		
		context=ActionContext.getContext();
		request=(Map) context.get("request");
		
		Project pro=detailService.getProject(proId);
		request.put("project", pro);
		return super.execute();
	}

	public Integer getProId() {
		return proId;
	}

	public void setProId(Integer proId) {
		this.proId = proId;
	}

	public DetailService getDetailService() {
		return detailService;
	}

	public void setDetailService(DetailService detailService) {
		this.detailService = detailService;
	}

	
}
