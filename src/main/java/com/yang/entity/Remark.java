package com.yang.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Yyang
 * @create 2017/10/31.
 */
public class Remark implements Serializable {
	int remarkId;

	/**
	 * 评论内容
	 */
	String remarkContent;

	/**
	 * 评论时间
	 */
	Date remarkTime;

	/**
	 * 评论时间
	 */
	String remarkData;

	/**
	 * 评论用户
	 */
	String userName;

	/**
	 * 用户头像
	 */
	String userPhoto;

	/**
	 * 电影名
	 */
	String titleCn;
	/**
	 * 电影海报
	 */
	String img;

	@Override
	public String toString() {
		return "Remark{" +
				"remarkId=" + remarkId +
				", remarkContent='" + remarkContent + '\'' +
				", remarkTime=" + remarkTime +
				'}';
	}

	public int getRemarkId() {
		return remarkId;
	}

	public void setRemarkId(int remarkId) {
		this.remarkId = remarkId;
	}

	public String getRemarkContent() {
		return remarkContent;
	}

	public void setRemarkContent(String remarkContent) {
		this.remarkContent = remarkContent;
	}

	public Date getRemarkTime() {
		return remarkTime;
	}

	public void setRemarkTime(Date remarkTime) {
		this.remarkTime = remarkTime;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRemarkData() {
		return remarkData;
	}

	public void setRemarkData(String remarkData) {
		this.remarkData = remarkData;
	}

	public String getUserPhoto() {
		return userPhoto;
	}

	public void setUserPhoto(String userPhoto) {
		this.userPhoto = userPhoto;
	}

	public String getTitleCn() {
		return titleCn;
	}

	public void setTitleCn(String titleCn) {
		this.titleCn = titleCn;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}
}
