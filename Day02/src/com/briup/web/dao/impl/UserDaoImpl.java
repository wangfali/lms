package com.briup.web.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;

import com.briup.web.Util.entity.Gender;
import com.briup.web.Util.xml.XmlUtil;
import com.briup.web.dao.UserDao;
import com.briup.web.entity.User;

/**
 * 数据交互接口的实现
 * @author wangfali
 *@version 1.0
 *@date 2016年11月30日
 */
public class UserDaoImpl implements UserDao{
	@Override
	public void addUser(User user) {
		//将文档读取出来
		Document document = XmlUtil.getDocument();
		//向文档添加内容
		Element rootElement = document.getRootElement();
		Element element = rootElement.addElement("Contact");
		element.addAttribute("idString", user.getIdString());
		element.addAttribute("nameString", user.getNameString());
		element.addAttribute("emailString",user.getNameString());
		element.addAttribute("phoneString", user.getPhoneString());
		element.addAttribute("qqString", user.getQqString());
		//判断性别之后才能将其性别存入
		if (user.getSex().toString().equals("man")) {
			element.addAttribute("sex", "男");
		} else {
			element.addAttribute("sex", "女");
		}
		//将文档保存进文件
		XmlUtil.xmlwrite(document);
	}
	@Override
	public void deleteUser(String idString) {
		//将文档读取出来
		Document document = XmlUtil.getDocument();
		Element rootElement = document.getRootElement();
		Element node = (Element)rootElement.selectSingleNode("//Contact[@idString='"+idString+"']");
		//自杀
		node.detach();
		//将文档保存进入文件
		XmlUtil.xmlwrite(document);
	}

	@Override
	public void updateUser(User user) {
		//将文档读取出来
		Document document = XmlUtil.getDocument();
		//找到对应的对象并将其更新
		Element rootElement = document.getRootElement();
		Element node = (Element)rootElement.selectSingleNode("//Contact[@idString='"+user.getIdString()+"']");
		//将对象进行更新(覆盖)
		node.addAttribute("nameString", user.getNameString());
		node.addAttribute("emailString",user.getNameString());
		node.addAttribute("phoneString", user.getPhoneString());
		node.addAttribute("qqString", user.getQqString());
		//判断性别之后才能将其性别存入
		if (user.getSex().toString().equals("man")) {
			node.addAttribute("sex", "男");
		} else {
			node.addAttribute("sex", "女");
		}
		//将文档保存进文件
		XmlUtil.xmlwrite(document);
		
	}

	@Override
	public List<User> findAll() {
		// 通过集合将查询到的信息返回
		List<User> list = new ArrayList<User>();
		//将文档读取出来
		Document document = XmlUtil.getDocument();
		Element rootElement = document.getRootElement();
		//逐个读取文档对象并进行封装
		@SuppressWarnings("unchecked")
		List<Element> nodes = (List<Element>)rootElement.selectNodes("//Contact");
		for (Element element : nodes) {
			String idString = element.attributeValue("idString");
			String nameString = element.attributeValue("nameString");
			String phoneString = element.attributeValue("phoneString");
			String emailString = element.attributeValue("emailString");
			String sex = element.attributeValue("sex");
			String qqString = element.attributeValue("qqString");
			Gender sex1=null;
			//将性别进行判断
			if("男".equals(sex)){	
				sex1=Gender.man;
			}else{
				sex1=Gender.woman;
			}
			list.add(new User(nameString, phoneString, sex1, qqString, emailString, idString));
		}
		return list;
	}

	@Override
	public User findById(String idString) {
		//将文档读取出来
		Document document = XmlUtil.getDocument();
		//查找到相应的对象
		Element rootElement = document.getRootElement();
		Element node =(Element)rootElement.selectSingleNode("//Contact[@idString='"+idString+"']");
		//将读取到的对象进行封装
		String nameString = node.attributeValue("nameString");
		String emailString = node.attributeValue("emailString");
		String phoneString = node.attributeValue("phoneString");
		String qqString = node.attributeValue("qqString");
		String sex = node.attributeValue("sex");
		Gender sex1=null;
		//将性别进行判断
		if("男".equals(sex)){	
			sex1=Gender.man;
		}else{
			sex1=Gender.woman;
		}
		return new User(nameString, phoneString, sex1, qqString, emailString, idString);
	}

	@Override
	public boolean checkUser(String nameString) {
		//将文档读取
		Document document = XmlUtil.getDocument();
		//判断是否存在该对象
		Element rootElement = document.getRootElement();
		Element node =(Element)rootElement.selectSingleNode("//Contact[@nameString='"+nameString+"']");
		if(node==null){
			return false;
		}else {
			return true;
		}
	}

}
