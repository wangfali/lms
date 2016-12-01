package com.briup.web.test;

import org.junit.Before;
import org.junit.Test;

import com.briup.web.Util.entity.Gender;
import com.briup.web.dao.UserDao;
import com.briup.web.dao.impl.UserDaoImpl;
import com.briup.web.entity.User;

/**
 * 测试数据DAO层的代码
 * @author wangfali
 *@version 1.0
 *@date 2016年11月30日
 */
public class TestDao {
	UserDao operate=null;//创建接口对象
	@Before
	public void init(){//在这个方法中给对象赋值
		operate=new UserDaoImpl();
	}
	/**
	 * 测试添加用户
	 */
	@Test
	public void testAddUser(){
		User user = new User();
		user.setIdString("123");
		user.setEmailString("wdsxc");
		user.setNameString("dsd");
		user.setPhoneString("weds");
		user.setQqString("ewdsz");
		user.setSex(Gender.man);
		operate.addUser(user);
	}
	/**
	 * 测试更新对象
	 *//*
	@Test
	public void testUpdateUser(){
		User user = new User();
		user.setIdString("123");
		user.setEmailString("wdsxc");
		user.setNameString("d");
		user.setPhoneString("w");
		user.setQqString("ew");
		user.setSex(Gender.man);
		operate.updateUser(user);
	}
	*//**
	 * 测试查询所有的对象
	 *//*
	@Test
	public void testFindAll(){
		 operate.findAll();
	}
	*//**
	 * 测试通过id查找对象的方法
	 *//*
	@Test
	public void testFindById(){
		operate.findById("123");
	}
	*//**
	 * 测试通过姓名查找是否存在同名对象
	 *//*
	@Test
	public void testCheckName(){
		operate.checkUser("w");
	}
	*//**
	 * 测试删除对象
	 *//*
	@Test
	public void testdeleteUser(){
		operate.deleteUser("123");
	}*/
}
