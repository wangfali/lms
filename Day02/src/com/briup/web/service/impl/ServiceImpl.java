package com.briup.web.service.impl;

import java.util.List;

import com.briup.web.dao.impl.UserDaoImpl;
import com.briup.web.entity.User;
import com.briup.web.exception.NameRepeatException;
import com.briup.web.service.ContactService;

/**
 * 业务层的实现类
 * 
 * @author wangfali
 * @version 1.0
 * @date 2016年11月30日
 */
public class ServiceImpl implements ContactService {

	@Override
	public void addUser(User user) throws NameRepeatException {
		// 判断对象的名称是否存在
		UserDaoImpl daoImpl = new UserDaoImpl();
		boolean checkUser = daoImpl.checkUser(user.getNameString());
		if (checkUser==false) {
			daoImpl.addUser(user);
		} else {
			throw new NameRepeatException("用户名称重复！");
		}
	}

	@Override
	public void deleteUser(String idString) {
		// 直接调用删除的方法
		UserDaoImpl daoImpl = new UserDaoImpl();
		daoImpl.deleteUser(idString);

	}

	@Override
	public void updateUser(User user){
		// 直接调用更新的方法
		new UserDaoImpl().updateUser(user);
	}

	@Override
	public List<User> findAll() {
		// 直接调用查询所有方法
		return new UserDaoImpl().findAll();
	}

	@Override
	public User findById(String idString) {
		// 直接调用通过id查找的方法
		return new UserDaoImpl().findById(idString);
	}
}
