package com.www.pojo;

import java.io.Serializable;

public class User implements Serializable{

	private static final long serialVersionUID = -3016686511685279164L;

	private String userName;
	private String workcode;
	private int status;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getWorkcode() {
		return workcode;
	}
	public void setWorkcode(String workcode) {
		this.workcode = workcode;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
	
	
	
	
}
