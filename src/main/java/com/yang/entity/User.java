package com.yang.entity;

import java.io.Serializable;

/**
 * @author Yyang
 * @create 2017/10/23.
 */
public class User implements Serializable {

	private Integer userId;

	/** 手机号 */
	private String userNumber;

	/** 密码 */
	private String password;

	/** 用户昵称 */
	private String userName;

	/** 用户头像 */
	private String userPhoto;

	@Override
	public String toString() {
		return "User{" +
				"userId=" + userId +
				", userNumber='" + userNumber + '\'' +
				", password='" + password + '\'' +
				", userName='" + userName + '\'' +
				", userPhoto='" + userPhoto + '\'' +
				'}';
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserNumber() {
		return userNumber;
	}

	public void setUserNumber(String userNumber) {
		this.userNumber = userNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPhoto() {
		return userPhoto;
	}

	public void setUserPhoto(String userPhoto) {
		this.userPhoto = userPhoto;
	}

}
