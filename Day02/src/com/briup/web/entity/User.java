package com.briup.web.entity;

import com.briup.web.Util.entity.Gender;

/**
 * 使用三层构架对通讯录进行改编  实体类  遵循javabean规则  无参构造函数  属性私有  提供getter setter方法
 * @author wangfali
 *@version 1.0
 *@date 2016年11月30日
 */
public class User {
	private String nameString;
	private String phoneString;
	private Gender sex;
	private String qqString;
	private String emailString;
	private String idString;
	public String getIdString() {
		return idString;
	}
	public void setIdString(String idString) {
		this.idString = idString;
	}
	public String getNameString() {
		return nameString;
	}
	public void setNameString(String nameString) {
		this.nameString = nameString;
	}
	public String getPhoneString() {
		return phoneString;
	}
	public void setPhoneString(String phoneString) {
		this.phoneString = phoneString;
	}
	public Gender getSex() {
		return sex;
	}
	public void setSex(Gender sex) {
		this.sex = sex;
	}
	public String getQqString() {
		return qqString;
	}
	public void setQqString(String qqString) {
		this.qqString = qqString;
	}
	public String getEmailString() {
		return emailString;
	}
	public void setEmailString(String emailString) {
		this.emailString = emailString;
	}
	/**
	 * 无参构造函数
	 */
	public User() {
	}
	/**
	 * @param nameString 姓名
	 * @param phoneString 电话
	 * @param sex 性别
	 * @param qqString qq
	 * @param emailString 邮箱
	 * @param idString 编号
	 */
	public User(String nameString, String phoneString, Gender sex,
			String qqString, String emailString, String idString) {
		this.nameString = nameString;
		this.phoneString = phoneString;
		this.sex = sex;
		this.qqString = qqString;
		this.emailString = emailString;
		this.idString = idString;
	}
	@Override
	public String toString() {
		return "User [nameString=" + nameString + ", phoneString="
				+ phoneString + ", sex=" + sex + ", qqString=" + qqString
				+ ", emailString=" + emailString + ", idString=" + idString
				+ "]";
	}
	
}

