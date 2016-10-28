package com.jzfactr.jd.service;

import java.util.List;
import java.util.Map;

import com.jzfactr.jd.bean.Clasz;
import com.jzfactr.jd.bean.Student;

/**
 * @author jay 2016-09-05
 * 学生业务逻辑处理接口
 */
public interface StudentService {
	/**
	 * 获取所有班级的名称和ID
	 * @return 
	 */
	Map<Integer, String> getClaszNameWithId();
	/**
	 * 统计某个班级的男女生人数
	 * @param claszId 班级的id
	 * @return 数组下标0=女，1=男
	 */
	int[] countBySex(int claszId);
	/**
	 * 通过班级的id获取某个班级对象
	 * @param claszId 班级的id
	 * @return 班级的对象
	 */
	Clasz getClasz(int claszId);
	/**
	 * 删除一个学生
	 * @param id
	 */
	void deleteStudent(int studId);
	/**
	 * 添加一个学生
	 * @param stud 学生
	 */
	void add(Student s);
	/**
	 * 更改学生信息
	 * @param user
	 */
	void updateStudent(Student stud);
	/**
	 * 通过学生的名字进行模糊查询
	 * @param name 学生的模糊姓名
	 * @return 查询到的学生
	 */
	List<Student> findByName(int clsId,String name);
	
	/**
	 * 获取当前页的学生信息
	 * @param clsId 班级id
	 * @param count 总记录数
	 * @param currPage 当前页
	 * @param name
	 * @return
	 */
	List<Student> findByPage(int clsId,int count,int currPage);
	

}
