package com.example.hw4uapp;

import java.io.Serializable;

public class UserHw implements Serializable{
	
	private int _id;
	private String hwName;
	private String hwIns;
	private String hwClass;
	private String hwDue;
	private String hwStatus;
	private String hwTeacher;
	
	public UserHw() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public UserHw(String hwName, String hwIns, String hwClass, String hwDue) {
		super();
		this.hwName = hwName;
		this.hwIns = hwIns;
		this.hwClass = hwClass;
		this.hwDue = hwDue;
		this.hwStatus = hwStatus;
		this.hwTeacher = hwTeacher;
	}

	public int get_id() {
		return _id;
	}

	public void set_id(int _id) {
		this._id = _id;
	}

	public String getHwName() {
		return hwName;
	}

	public void setHwName(String hwName) {
		this.hwName = hwName;
	}

	public String getHwIns() {
		return hwIns;
	}

	public void setHwIns(String hwIns) {
		this.hwIns = hwIns;
	}

	public String getHwClass() {
		return hwClass;
	}

	public void setHwClass(String hwClass) {
		this.hwClass = hwClass;
	}

	public String getHwDue() {
		return hwDue;
	}

	public void setHwDue(String hwDue) {
		this.hwDue = hwDue;
	}

	public String getHwStatus() {
		return hwStatus;
	}

	public void setHwStatus(String hwStatus) {
		this.hwStatus = hwStatus;
	}

	public String getHwTeacher() {
		return hwTeacher;
	}

	public void setHwTeacher(String hwTeacher) {
		this.hwTeacher = hwTeacher;
	}

}
