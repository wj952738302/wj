package com.jzfactr.jd.action;

import java.util.Iterator;

import com.jzfactr.jd.bean.Clasz;
import com.jzfactr.jd.bean.Student;
import com.jzfactr.jd.service.StudentService;
import com.jzfactr.jd.service.StudentServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class StudOptAction extends ActionSupport {
	
	private StudentService service;
	private Student student=new Student();
	private Integer claszId;

	public StudentService getService() {
		return service;
	}
	public void setService(StudentService service) {
		this.service = service;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return super.execute();
	}
	/**
	 * 添加學生訪問方法
	 * @return
	 */
	public String add()
	{
		Clasz clasz=new Clasz();
		clasz.setId(claszId);
		student.setClasz(clasz);
		service.add(student);
		return "success";
	}
	/**
	 * 刪除學生訪問方法
	 * @return
	 */
	public String del()
	{
		Clasz cls=service.getClasz(claszId);
		Iterator<Student> it=cls.getStudents().iterator();
		while(it.hasNext())
		{
			Student s=it.next();
			if(s.getId().equals(student.getId()))
			{
				it.remove();
				service.deleteStudent(s.getId());
			}
		}
		return "success";
	}
	/**
	 * 修改學生的方法
	 * @return
	 */
	public String edit()
	{
		Clasz cls=new Clasz();
		cls.setId(claszId);
		student.setClasz(cls);
		service.updateStudent(student);
		return "success";
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Integer getClaszId() {
		return claszId;
	}
	public void setClaszId(Integer claszId) {
		this.claszId = claszId;
	}
	

}
