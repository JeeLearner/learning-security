package com.learn.exception;

/**
 * 3.6.4 自定义异常
 * 针对网页请求返回500页面
 * 针对http请求返回异常json信息
 * @author qilongfei
 *
 */
public class UserNotExistException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	private String id;
	
	public UserNotExistException(String id) {
		super("user not exist");
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
