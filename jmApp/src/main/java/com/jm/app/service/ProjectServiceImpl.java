package com.jm.app.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.jm.app.bean.Project;
import com.jm.app.dao.ProjectDAO;

public class ProjectServiceImpl implements ProjectService {

	private ProjectDAO proDao;
	
	@Override
	public List<Project> getProByType(Integer type,Integer status) {
		
	     List<Project> aList=proDao.findAll();
	     if(type!=null)
	     {
	    	 List<Project> typeList=new ArrayList<Project>();
	 	     for(Project pro:aList)
	 	     {
	 	    	 if(pro.getType()==type)
	 	    		 typeList.add(pro);
	 	     }
	 	     aList=typeList;
	     }
	     if(status!=null)
	     {
	    	 List<Project> statusList=new ArrayList<Project>();
	    	 for(Project pro:aList)
	    	 {
	    		 Date startDate=pro.getStart();
	    		 Date stopDate=pro.getStop();
	    		 Date now=new Date();
	    		 switch(status){
	    		    case 0:
	    		    	if(now.before(startDate))
	    		    		statusList.add(pro);
	    		        break;
	    		    case 1:
	    		    	if(now.after(startDate) && now.before(stopDate))
	    		    		statusList.add(pro);
	    		    	break;
	    		    case 2:
	    		    	if(now.after(stopDate))
	    		    		statusList.add(pro);
	    		    	break;
	    		    case 3:
	    		    	Calendar cal=Calendar.getInstance();
	    		    	cal.setTime(startDate);
	    		    	cal.add(Calendar.MONTH, pro.getPeriod());
	    		    	if(cal.getTime().before(now))
	    		    		statusList.add(pro);
	    		    	break;
	    		 }
	    	 }
	    	 aList=statusList;
	     }
		 return aList;
	}

	public ProjectDAO getProDao() {
		return proDao;
	}

	public void setProDao(ProjectDAO proDao) {
		this.proDao = proDao;
	}

	
}
