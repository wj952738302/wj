package com.jzfactr.jd.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.jzfactr.jd.bean.Clasz;
import com.jzfactr.jd.bean.Student;
import com.jzfactr.jd.dao.ClaszDAO;
import com.jzfactr.jd.dao.StudentDAO;
import com.jzfactr.jd.util.PaginNation;

public class StudentServiceImpl implements StudentService {
	
	private StudentDAO sDao;
	private ClaszDAO clsDao;
	public static final int PAGE_SIZE=5; 
	
	

	public StudentDAO getsDao() {
		return sDao;
	}

	public void setsDao(StudentDAO sDao) {
		this.sDao = sDao;
	}

	public ClaszDAO getClsDao() {
		return clsDao;
	}

	public void setClsDao(ClaszDAO clsDao) {
		this.clsDao = clsDao;
	}

	@Override
	public Map<Integer, String> getClaszNameWithId() {
		// TODO Auto-generated method stub
		Map<Integer,String> map=new LinkedHashMap<Integer, String>();
		//获取所有班级的数据
		List<Clasz> sList=clsDao.findAll();
		//将每个班级的id与name存入到map中
		for(Clasz cls:sList)
		{
			map.put(cls.getId(), cls.getName());
		}
		return map;
	}

	@Override
	public int[] countBySex(int claszId) {
		// TODO Auto-generated method stub
		return sDao.countBySex(claszId);
	}

	@Override
	public Clasz getClasz(int claszId) {
		Clasz cls=clsDao.findById(claszId);
		clsDao.reflush(cls);
		return cls;
	}

	@Override
	public void deleteStudent(int studId) {
		// TODO Auto-generated method stub
		sDao.deleteById(studId);

	}

	@Override
	public void add(Student s) {
		// TODO Auto-generated method stub
		sDao.save(s);

	}

	@Override
	public void updateStudent(Student stud) {
		// TODO Auto-generated method stub
		sDao.merge(stud);

	}

	@Override
	public List<Student> findByName(int clsId, String name) {
		// TODO Auto-generated method stub
		return sDao.findByName(clsId, name);
	}

	@Override
	public List<Student> findByPage(int clsId, int count, int currPage) {
		// TODO Auto-generated method stub
		PaginNation pagination =new PaginNation(count, PAGE_SIZE);
		pagination.setCurrPage(currPage);
		int startIndex=pagination.getStartIndex();
		int stopIndex=pagination.getStopIndex();
		return sDao.findByPage(clsId, startIndex, stopIndex);
	}
	
	public static void main(String[] args) {
		StudentService service=new StudentServiceImpl();
		Clasz cls=new Clasz();
		cls.setId(10);
		Student stu=new Student();
		
		stu.setName("qweqwe");
		stu.setSex(0);
		stu.setCode("34341");
		stu.setClasz(cls);
//		service.add(stu);
//		service.updateStudent(stu);
		System.out.println(service.findByPage(1, 1, 5));
	}

}
