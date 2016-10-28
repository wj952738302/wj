package com.jzfactr.jd.service;

import java.util.Map;

import com.jzfactr.jd.bean.Clasz;

/**
 * @author jay 2016-09-08
 * 班级业务逻辑处理接口
 */
public interface ClaszService {
	/**
	 * 获取所有班级的名称和id
	 * @return
	 */
	Map<Integer, String> getClaszNameWithId();
	/**
	 * 添加一个班级
	 * @param c 班级
	 */
	void add(Clasz c);
	/**
	 * 通过班级的id删除班级
	 * @param claszid 班级的id
	 * @param b 
	 * @param isDelStud 时候可以关联删除学生true=可以
	 * @return 是否删除成功true=成功
	 */
	void delete(int claszid, boolean isDelId);
	/**
	 * 更改班级的信息
	 * @param cls
	 */
	void update(Clasz cls);

}
