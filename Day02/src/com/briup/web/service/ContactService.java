package com.briup.web.service;

import java.util.List;

import com.briup.web.entity.User;
import com.briup.web.exception.NameRepeatException;

/**
 * 业务层处理接口
 * @author wangfali
 *@version 1.0
 *@date 2016年11月30日
 */
public interface ContactService {
	/**
	 * 添加用户 抛出姓名重复异常
	 * @param user 用户对象
	 */
	void addUser(User user)throws NameRepeatException;
	/**
	 * 删除用户
	 *@return void
	 *@param idString 用户的编号
	 *
	 */
	void deleteUser(String idString);
	/**
	 * 更新用户
	 *@return void
	 *@param user 新的用户对象
	 *
	 */
	void updateUser(User user);
	/**
	 * 查循所有的对象
	 *@return List<User>
	 */
	List<User> findAll();
	/**
	 * 通过用户编号查找用户
	 *@return User
	 *@param idString 用户编号
	 */
	User findById(String idString);
}
