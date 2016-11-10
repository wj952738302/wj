package com.jm.app.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.jm.app.bean.Project;
import com.jm.app.bean.Prorder;
import com.jm.app.dao.ProjectDAO;
import com.jm.app.dao.ProrderDAO;

public class MainServiceImpl implements MainService {
    
	private ProjectDAO proDao;
	
	private ProrderDAO orderDao;
	
	@Override
	public List<Project> getAll() {
		// TODO Auto-generated method stub
		return proDao.findAll();
	}

	@Override
	public Map<Integer, Integer> getSumByProId() {
		// TODO Auto-generated method stub
		return orderDao.sumInvestByProId();
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
	public List<Project> getAllWithSum() {

        List<Project> proList=getAll();
        Map<Integer,Integer> sumMap=getSumByProId();
        for(Project pro:proList)
        {
        	Integer sum=sumMap.get(pro.getId());
        	pro.setInvestSum(sum);
        	
        }
		return proList;
	}

	@Override
	public List<Prorder> getAssignOrders() {
		// TODO Auto-generated method stub
		return orderDao.getAssignedOrders();
	}

	@Override
	public List<Project> getCarousel() {
		// TODO Auto-generated method stub
		return proDao.findByCarousel();
	}

	@Override
	public List<Project> getAllByIn() {
		List<Project> proList=this.getAllWithSum();
		List<Project> proInList=new ArrayList<Project>();
		for(Project project:proList)
		{
			Date stopDate=project.getStop();
			Date now=new Date();
			if(stopDate.equals(now) || stopDate.after(now)){
				proInList.add(project);
			}
		}
		return proInList;
	}

	@Override
	public List<Project> getAllByEnd() {
	
		List<Project> proList=this.getAllWithSum();
		List<Project> proInList=new ArrayList<Project>();
		for(Project project:proList)
		{
			Date stopDate=project.getStop();
			Date now=new Date();
			if(stopDate.before(now)){
				proInList.add(project);
			}
		}
		return proInList;
	}

	

	
}
