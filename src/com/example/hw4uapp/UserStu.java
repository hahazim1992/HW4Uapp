package com.example.hw4uapp;

import java.io.Serializable;

public class UserStu implements Serializable {

	private int _id;
	private String stName;
	private String stUsername;
	private String stEmail;
	private String stPassword;
	
	public UserStu() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public UserStu(String stName, String stUsername, String stEmail, String stPassword) {
		super();
		this.stName = stName;
		this.stUsername = stUsername;
		this.stEmail = stEmail;
		this.stPassword = stPassword;
	}

	public int get_id() {
		return _id;
	}

	public void set_id(int _id) {
		this._id = _id;
	}

	public String getStName() {
		return stName;
	}

	public void setStName(String stName) {
		this.stName = stName;
	}

	public String getStUsername() {
		return stUsername;
	}

	public void setStUsername(String stUsername) {
		this.stUsername = stUsername;
	}

	public String getStEmail() {
		return stEmail;
	}

	public void setStEmail(String stEmail) {
		this.stEmail = stEmail;
	}

	public String getStPassword() {
		return stPassword;
	}

	public void setStPassword(String stPassword) {
		this.stPassword = stPassword;
	}
}

