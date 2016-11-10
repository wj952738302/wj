package com.jm.app.service;

import java.util.List;
import java.util.Map;

import com.jm.app.bean.Project;
import com.jm.app.bean.Prorder;

public interface MainService {
    /**
     * 获取所有项目
     * @return
     */
	List<Project> getAll();
	/**
	 * 统计每个项目目前投资的金额
	 * @return
	 */
	Map<Integer,Integer> getSumByProId();
	/**
	 * 获取所有的项目（带已投资的统计金额)
	 * @return
	 */
	List<Project> getAllWithSum();
	/**
	 * 获取转让的所有订单
	 * @return
	 */
	List<Prorder> getAssignOrders();
	/**
	 * 获取被轮播的项目
	 * @return
	 */
	List<Project> getCarousel();
	
	/**
	 * 获取所有众筹中的项目
	 * @return
	 */
	List<Project> getAllByIn();
	/**
	 * 获取所有众筹结束的项目
	 * @return
	 */
	List<Project> getAllByEnd();
	
}
