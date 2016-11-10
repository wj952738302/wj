package com.jm.app.service;

import java.util.List;
import java.util.Map;

import com.jm.app.bean.Prorder;
import com.jm.app.bean.User;

public interface UserService {

	/**
	 * 根据项目类型进行统计
	 * @return 第0行为财富项目 第1行为娱乐项目
	 *         下标0-项目个数 下标1-总金额
	 */
	int[][] getSumbyType(String tel);
	/**
	 * 根据项目是否结算进行统计
	 * @param tel 用户的手机号
	 * @return 第0行为未结束的项目 第1行为已结算的项目
	 *         下标0-项目个数 下标1-总金额
	 */
	int[][] getSumByEnd(String tel);
	/**
	 * 获取是否项目结束的订单
	 * @param isEnd true-结束 false-未结束
	 * @return
	 */
	List<Prorder> getProrderByEnd(String tel,boolean isEnd);
	/**
	 * 获取用户不同状态的订单
	 * @param tel 手机号
	 *        status 订单状态    0-转化中  1-转让中         2-已转化
     *                        3-已转让  4-管理员确认  5-管理员已确认
	 * @return key-订单状态 value-订单集合
	 */
	Map<Integer,List<Prorder>> getProrderByStatus(String tel);
	/**
	 * 获取全部订单
	 * @param tel 手机号
	 * @return
	 */
	List<Prorder> getAllProder(String tel);
	/**
	 * 更新用户的头像图片路径
	 * @param user
	 */
	void updateUserPic(int id,String pic);
	/**
	 * 更新用户信息
	 * @param user
	 */
	void updateUser(int id,String name,int sex);
	/**
	 * 更新用户信息
	 * @param user
	 */
	void updateUser(User user);
	/**
	 * 通过id获取user对象
	 * @param id
	 */
	User getUser(int id);
}
