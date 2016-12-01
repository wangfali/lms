package com.briup.web.exception;
/**
 * 用户名称相同的异常
 * @author wangfali
 *@version 1.0
 *@date 2016年11月30日
 */
public class NameRepeatException extends Exception{
	private static final long serialVersionUID = 1L;
	public NameRepeatException( String msg){
		super(msg);//调用父类的报错机制
	}
	
}
