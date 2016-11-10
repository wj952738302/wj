package com.jm.app.action;

import java.util.List;
import java.util.Map;

import com.jm.app.bean.Project;
import com.jm.app.service.ProjectService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ProjectAction extends ActionSupport {

	private ActionContext context;
	
	private Map<String,Object> request;
	
	private ProjectService proService;
	
	private Integer type; //项目类型
	
	private Integer status; //项目状态
	
	private List<Project> proList; //查询项目结果
	
	@Override
	public String execute() throws Exception {

		context=ActionContext.getContext();
		request=(Map) context.get("request");
        proList=proService.getProByType(type, status);
        request.put("proList", proList);
		return super.execute();
	} 

	public ProjectService getProService() {
		return proService;
	}

	public void setProService(ProjectService proService) {
		this.proService = proService;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public List<Project> getProList() {
		return proList;
	}

	public void setProList(List<Project> proList) {
		this.proList = proList;
	}
	
	
}
