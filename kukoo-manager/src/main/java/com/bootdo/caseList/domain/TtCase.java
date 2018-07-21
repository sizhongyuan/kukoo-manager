package com.bootdo.caseList.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * case列表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2017-10-05 17:11:16
 */
public class TtCase implements Serializable {
	//主键
	private int id;
	//case名称
	private String caseName;
	//合同号
	private String contractNumber;
	//主申请人ID
	private String mainApplicantId;
	//主申请人
	private String mainApplicantName;
	//副申请人ID
	private String deputyApplicantId;
	//副申请人
	private String deputyApplicantName;
	//一级项目ID
	private String projectId;
	//一级项目名称
	private String projectName;
	//二级项目ID
	private String subProjectId;
	//二级项目名称
	private String subProjectName;
	//顾问ID
	private String adviserId;
	//顾问姓名
	private String adviserName;
	//移民局官网账户
	private String immigrationAccount;
	//代收名额费
	private String registrationFee;
	//备注
	private String remark;
	//删除标识
	private int deleted;
	//创建时间
	private Date createTime;

	/**
	 * 设置：主键
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * 获取：主键
	 */
	public int getId() {
		return id;
	}
	/**
	 * 设置：case名称
	 */
	public void setCaseName(String caseName) {
		this.caseName = caseName;
	}
	/**
	 * 获取：case名称
	 */
	public String getCaseName() {
		return caseName;
	}
	/**
	 * 设置：合同号
	 */
	public void setContractNumber(String contractNumber) {
		this.contractNumber = contractNumber;
	}
	/**
	 * 获取：合同号
	 */
	public String getContractNumber() {
		return contractNumber;
	}
	/**
	 * 设置：主申请人ID
	 */
	public void setMainApplicantId(String mainApplicantId) {
		this.mainApplicantId = mainApplicantId;
	}
	/**
	 * 获取：主申请人ID
	 */
	public String getMainApplicantId() {
		return mainApplicantId;
	}
	/**
	 * 设置：主申请人
	 */
	public void setMainApplicantName(String mainApplicantName) {
		this.mainApplicantName = mainApplicantName;
	}
	/**
	 * 获取：主申请人
	 */
	public String getMainApplicantName() {
		return mainApplicantName;
	}
	/**
	 * 设置：副申请人ID
	 */
	public void setDeputyApplicantId(String deputyApplicantId) {
		this.deputyApplicantId = deputyApplicantId;
	}
	/**
	 * 获取：副申请人ID
	 */
	public String getDeputyApplicantId() {
		return deputyApplicantId;
	}
	/**
	 * 设置：副申请人
	 */
	public void setDeputyApplicantName(String deputyApplicantName) {
		this.deputyApplicantName = deputyApplicantName;
	}
	/**
	 * 获取：副申请人
	 */
	public String getDeputyApplicantName() {
		return deputyApplicantName;
	}
	/**
	 * 设置：一级项目ID
	 */
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	/**
	 * 获取：一级项目ID
	 */
	public String getProjectId() {
		return projectId;
	}
	/**
	 * 设置：一级项目名称
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	/**
	 * 获取：一级项目名称
	 */
	public String getProjectName() {
		return projectName;
	}
	/**
	 * 设置：二级项目ID
	 */
	public void setSubProjectId(String subProjectId) {
		this.subProjectId = subProjectId;
	}
	/**
	 * 获取：二级项目ID
	 */
	public String getSubProjectId() {
		return subProjectId;
	}
	/**
	 * 设置：二级项目名称
	 */
	public void setSubProjectName(String subProjectName) {
		this.subProjectName = subProjectName;
	}
	/**
	 * 获取：二级项目名称
	 */
	public String getSubProjectName() {
		return subProjectName;
	}
	/**
	 * 设置：顾问ID
	 */
	public void setAdviserId(String adviserId) {
		this.adviserId = adviserId;
	}
	/**
	 * 获取：顾问ID
	 */
	public String getAdviserId() {
		return adviserId;
	}
	/**
	 * 获取：顾问姓名
	 */
	public String getAdviserName() {
		return adviserName;
	}
	/**
	 * 设置：顾问姓名
	 */
	public void setAdviserName(String adviserName) {
		this.adviserName = adviserName;
	}
	/**
	 * 获取：移民局官网账户
	 */
	public String getImmigrationAccount() {
		return immigrationAccount;
	}
	/**
	 * 设置：移民局官网账户
	 */
	public void setImmigrationAccount(String immigrationAccount) {
		this.immigrationAccount = immigrationAccount;
	}
	/**
	 * 获取：代收名额费
	 */
	public String getRegistrationFee() {
		return registrationFee;
	}
	/**
	 * 设置：代收名额费
	 */
	public void setRegistrationFee(String registrationFee) {
		this.registrationFee = registrationFee;
	}
	/**
	 * 设置：备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：备注
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 设置：删除标识
	 */
	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}
	/**
	 * 获取：删除标识
	 */
	public int getDeleted() {
		return deleted;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
}