package com.jm.app.service;

import java.util.Map;

import com.jm.app.bean.Project;
import com.jm.app.dao.ProjectDAO;
import com.jm.app.dao.ProrderDAO;

public class DetailServiceImpl implements DetailService {

	private ProjectDAO proDao;
	
	private ProrderDAO orderDao;
	
	@Override
	public Project getProject(int proId) {
		// TODO Auto-generated method stub
		return proDao.findById(proId);
	}

	
	
	public ProjectDAO getProDao() {
		return proDao;
	}

	public void setProDao(ProjectDAO proDao) {
		this.proDao = proDao;
	}



	public ProrderDAO getOrderDao() {
		return orderDao;
	}



	public void setOrderDao(ProrderDAO orderDao) {
		this.orderDao = orderDao;
	}



	@Override
	public Project getProjectWithSum(int proId) {
		
		Map<Integer,Integer> sumMap=orderDao.sumInvestByProId();
		Project project=proDao.findById(proId);
		project.setInvestSum(sumMap.get(proId));
		return project;
	}

	
}
