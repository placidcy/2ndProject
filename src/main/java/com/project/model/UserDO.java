package com.project.model;

import com.project.exception.WrongIdPasswordException;

public class UserDO {

	private String user_id;	
	private String name;
	private String nickname;
	private String email;
	private String password;
	private String oldPasswd;
	private String newPasswd;
	private String confirmNewPasswd;
	private String created_date;
	private boolean rememberId;
	
	public UserDO() {
	}
	
	public UserDO(String user_id, String name, String nickname, String email, String password, String created_date) {
		this.user_id = user_id;
		this.name = name;
		this.nickname = nickname;
		this.email = email;
		this.password = password;
		this.created_date = created_date;
	}
	
	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getCreated_date() {
		return created_date;
	}
	public void setCreated_date(String created_date) {
		this.created_date = created_date;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public void changePassword(String oldPassword, String newPassword) {
		if(!this.password.equals(oldPassword)) {
			throw new WrongIdPasswordException();
		}
		
		this.password = newPassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isRememberId() {
		return rememberId;
	}

	public void setRememberId(boolean rememberId) {
		this.rememberId = rememberId;
	}

	public String getOldPasswd() {
		return oldPasswd;
	}

	public void setOldPasswd(String oldPasswd) {
		this.oldPasswd = oldPasswd;
	}

	public String getNewPasswd() {
		return newPasswd;
	}

	public void setNewPasswd(String newPasswd) {
		this.newPasswd = newPasswd;
	}

	public String getConfirmNewPasswd() {
		return confirmNewPasswd;
	}

	public void setConfirmNewPasswd(String confirmNewPasswd) {
		this.confirmNewPasswd = confirmNewPasswd;
	}
	
	
}
