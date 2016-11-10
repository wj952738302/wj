package com.jm.app.action;

import java.util.List;
import java.util.Map;

import com.jm.app.bean.Project;
import com.jm.app.bean.Prorder;
import com.jm.app.service.MainService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class MainAction extends ActionSupport {

	private ActionContext context;
	
	private MainService mainService;
	
	private Map<String,Object> request;
	
	@Override
	public String execute() throws Exception {
		
		context=ActionContext.getContext();
		request=(Map) context.get("request");
		
		List<Project> proInList=mainService.getAllByIn();
		request.put("proInList", proInList);
		List<Prorder> orderList=mainService.getAssignOrders();
		request.put("orderList", orderList);
		List<Project> carList=mainService.getCarousel();
		request.put("carList", carList);
		List<Project> proEndList=mainService.getAllByEnd();
		request.put("proEndList", proEndList);
		return super.execute();
	}

	public MainService getMainService() {
		return mainService;
	}

	public void setMainService(MainService mainService) {
		this.mainService = mainService;
	}

	public Map getRequest() {
		return request;
	}

	public void setRequest(Map<String,Object> request) {
		this.request = request;
	}

	
	
	
	
}
