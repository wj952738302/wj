package com.jm.app.service;

import com.jm.app.bean.Project;

public interface DetailService {
	
	/**
	 * 通过id获取项目
	 * @param proId 项目id
	 * @return
	 */
	Project getProject(int proId);

	/**
	 * 带有筹集金额统计的项目对象
	 * @param proId 项目id
	 * @return
	 */
	Project getProjectWithSum(int proId);
	
}
