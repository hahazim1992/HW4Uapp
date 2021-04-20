package com.example.hw4uapp;

import java.io.Serializable;

public class UserTc implements Serializable {
	
	private int _id;
	private String tcName;
	private String tcUsername;
	private String tcEmail;
	private String tcPassword;

	public UserTc() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public UserTc(String tcName, String tcUsername, String tcEmail, String tcPassword) {
		super();
		this.tcName = tcName;
		this.tcUsername = tcUsername;
		this.tcEmail = tcEmail;
		this.tcPassword = tcPassword;
	}

	public int get_id() {
		return _id;
	}

	public void set_id(int _id) {
		this._id = _id;
	}

	public String getTcName() {
		return tcName;
	}

	public void setTcName(String tcName) {
		this.tcName = tcName;
	}

	public String getTcUsername() {
		return tcUsername;
	}

	public void setTcUsername(String tcUsername) {
		this.tcUsername = tcUsername;
	}

	public String getTcEmail() {
		return tcEmail;
	}

	public void setTcEmail(String tcEmail) {
		this.tcEmail = tcEmail;
	}

	public String getTcPassword() {
		return tcPassword;
	}

	public void setTcPassword(String tcPassword) {
		this.tcPassword = tcPassword;
	}

}
