package com.bootdo.consult.model;

import java.io.Serializable;

/**
 * 咨询记录
 * Created by gang on 2018/5/20.
 */
public class Consult implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键ID
	private Integer id;
	//用户ID
	private String userId;
	//用户名
	private String userName;
	//手机号
	private String userTelephone;
	//咨询时间
	private String createTime;
	//顾问
	private String adviser;
	//咨询记录
	private String consultRecord;
	//咨询结果
	private String consultResult;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserTelephone() {
		return userTelephone;
	}

	public void setUserTelephone(String userTelephone) {
		this.userTelephone = userTelephone;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getAdviser() {
		return adviser;
	}

	public void setAdviser(String adviser) {
		this.adviser = adviser;
	}

	public String getConsultRecord() {
		return consultRecord;
	}

	public void setConsultRecord(String consultRecord) {
		this.consultRecord = consultRecord;
	}

	public String getConsultResult() {
		return consultResult;
	}

	public void setConsultResult(String consultResult) {
		this.consultResult = consultResult;
	}

	@Override
	public String toString() {
		return "Consult{" +
				"id='" + id + '\'' +
				", userId='" + userId + '\'' +
				", userName='" + userName + '\'' +
				", userTelephone='" + userTelephone + '\'' +
				", createTime='" + createTime + '\'' +
				", adviser='" + adviser + '\'' +
				", consultRecord='" + consultRecord + '\'' +
				", consultResult='" + consultResult + '\'' +
				'}';
	}
}
