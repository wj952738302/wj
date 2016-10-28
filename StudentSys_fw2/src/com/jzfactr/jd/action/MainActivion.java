package com.jzfactr.jd.action;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.jzfactr.jd.bean.Clasz;
import com.jzfactr.jd.bean.Student;
import com.jzfactr.jd.service.StudentService;
import com.jzfactr.jd.service.StudentServiceImpl;
import com.jzfactr.jd.util.PaginNation;
import com.opensymphony.xwork2.ActionSupport;

public class MainActivion extends ActionSupport {
	
	private Integer clsId;
	
	private StudentService service;
	
	private HttpServletRequest request;
	
	private Integer pageNum;
	
	private String findName;
	private Integer pageCount;
	private int[] count;
	
//	private static final int PAGE_SIZE=5;
	
	private Map<Integer, String> nameMap;//班级信息

	@Override
	public String execute() throws Exception {
		request = ServletActionContext.getRequest();
		
		nameMap=service.getClaszNameWithId();
		
		if(clsId==null)
		{
			for(Entry<Integer,String>entry:nameMap.entrySet())
			{
				clsId=entry.getKey();
				break;
			}
		}
		// 获取男女人数的统计数据
		int[] count = service.countBySex(clsId);
		// 获取班级的信息
		Clasz cls = service.getClasz(clsId);
		//分页
		if(pageNum==null)
			pageNum=1;
		int studCount=cls.getStudents().size();
		int pageSize=StudentServiceImpl.PAGE_SIZE;
		if(studCount>pageSize)
		{
			List<Student> sList=service.findByPage(clsId, studCount, pageNum);
			cls.setStudents(new LinkedHashSet<Student>(sList));
//			System.out.println(sList);
		}
		if(findName!=null && !findName.equals(""))
		{
			List<Student> studList=service.findByName(clsId,findName);
			cls.setStudents(new LinkedHashSet<Student>(studList));
		}
		PaginNation page=new PaginNation(studCount,pageSize);
		pageCount=page.getPageCount();
		
		//给request作用域设置值
//		request.setAttribute("nameMap", nameMap);
		request.setAttribute("count", count);
		request.setAttribute("cls", cls);
		request.setAttribute("pageCount", page.getPageCount());
		request.setAttribute("pageNum", pageNum);
		return super.execute();
	}
	
	

	public Integer getClsId() {
		return clsId;
	}

	public void setClsId(Integer clsId) {
		this.clsId = clsId;
	}

	public StudentService getService() {
		return service;
	}

	public void setService(StudentService service) {
		this.service = service;
	}
	public Integer getPageNum() {
		return pageNum;
	}



	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}



	public String getFindName() {
		return findName;
	}



	public void setFindName(String findName) {
		this.findName = findName;
	}



	public Map<Integer, String> getNameMap() {
		return nameMap;
	}



	public void setNameMap(Map<Integer, String> nameMap) {
		this.nameMap = nameMap;
	}



	public Integer getPageCount() {
		return pageCount;
	}



	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}



	public int[] getCount() {
		return count;
	}



	public void setCount(int[] count) {
		this.count = count;
	}



	

}
