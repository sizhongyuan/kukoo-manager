package com.bootdo.system.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 顾问model
 * @author chenjianghe
 *
 */
public class EmpDO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	//顾问id
	private String empId;
	//注册时间
	private Date registTime;
	//账号类型 
	private String accountType;
	//头像
	private String headImg;
	//性别
	private String gender;
	//所在地
	private String location;
	//角色
	private String role;
	//状态
	private String status;
	//昵称
	private String nickname;
	//中文姓名
	private String cnname;
	//英文姓名
	private String enname;
	//所在机构
	private String institutions;
	//手机号码国内
	private String mobileInland;
	//手机号码国外
	private String mobileForeign;
	//邮箱
	private String email;
	//微信
	private String weChat;
	//其他
	private String other;
	//专业范围
	private String majorRange;
	//级别
	private String level;
	//负责人数
	private String peopleNumber;
	//负责case数
	private String caseNumber;
	//咨询人数
	private String consultNumber;
	//从业年限
	private String workyear;
	//持牌情况
	private String licensCase;
	//基本工资
	private String baseSalary;
	//社保标准
	private String socialSecurity;
	//公司社保成本
	private String companySecurity;
	//加入时间
	private Date joinTime;
	//离开时间
	private Date leaveTime;
	//合同
	private String contract;
	//劳动关系期限
	private Date laborLimit;
	//证件号码
	private String IDNumber;
	//血型
	private String bloodType;
	//籍贯
	private String nativePlace;
	//出生日期
	private Date birthday;
	//紧急联系人信息
	private String emergencyContact;
	//备注
	private String remark;
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public Date getRegistTime() {
		return registTime;
	}
	public void setRegistTime(Date registTime) {
		this.registTime = registTime;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getHeadImg() {
		return headImg;
	}
	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getCnname() {
		return cnname;
	}
	public void setCnname(String cnname) {
		this.cnname = cnname;
	}
	public String getEnname() {
		return enname;
	}
	public void setEnname(String enname) {
		this.enname = enname;
	}
	public String getInstitutions() {
		return institutions;
	}
	public void setInstitutions(String institutions) {
		this.institutions = institutions;
	}
	public String getMobileInland() {
		return mobileInland;
	}
	public void setMobileInland(String mobileInland) {
		this.mobileInland = mobileInland;
	}
	public String getMobileForeign() {
		return mobileForeign;
	}
	public void setMobileForeign(String mobileForeign) {
		this.mobileForeign = mobileForeign;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getWeChat() {
		return weChat;
	}
	public void setWeChat(String weChat) {
		this.weChat = weChat;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	public String getMajorRange() {
		return majorRange;
	}
	public void setMajorRange(String majorRange) {
		this.majorRange = majorRange;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getPeopleNumber() {
		return peopleNumber;
	}
	public void setPeopleNumber(String peopleNumber) {
		this.peopleNumber = peopleNumber;
	}
	public String getCaseNumber() {
		return caseNumber;
	}
	public void setCaseNumber(String caseNumber) {
		this.caseNumber = caseNumber;
	}
	public String getConsultNumber() {
		return consultNumber;
	}
	public void setConsultNumber(String consultNumber) {
		this.consultNumber = consultNumber;
	}
	public String getWorkyear() {
		return workyear;
	}
	public void setWorkyear(String workyear) {
		this.workyear = workyear;
	}
	public String getLicensCase() {
		return licensCase;
	}
	public void setLicensCase(String licensCase) {
		this.licensCase = licensCase;
	}
	public String getBaseSalary() {
		return baseSalary;
	}
	public void setBaseSalary(String baseSalary) {
		this.baseSalary = baseSalary;
	}
	public String getSocialSecurity() {
		return socialSecurity;
	}
	public void setSocialSecurity(String socialSecurity) {
		this.socialSecurity = socialSecurity;
	}
	public String getCompanySecurity() {
		return companySecurity;
	}
	public void setCompanySecurity(String companySecurity) {
		this.companySecurity = companySecurity;
	}
	public Date getJoinTime() {
		return joinTime;
	}
	public void setJoinTime(Date joinTime) {
		this.joinTime = joinTime;
	}
	public Date getLeaveTime() {
		return leaveTime;
	}
	public void setLeaveTime(Date leaveTime) {
		this.leaveTime = leaveTime;
	}
	public String getContract() {
		return contract;
	}
	public void setContract(String contract) {
		this.contract = contract;
	}
	public Date getLaborLimit() {
		return laborLimit;
	}
	public void setLaborLimit(Date laborLimit) {
		this.laborLimit = laborLimit;
	}
	public String getIDNumber() {
		return IDNumber;
	}
	public void setIDNumber(String iDNumber) {
		IDNumber = iDNumber;
	}
	public String getBloodType() {
		return bloodType;
	}
	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}
	public String getNativePlace() {
		return nativePlace;
	}
	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getEmergencyContact() {
		return emergencyContact;
	}
	public void setEmergencyContact(String emergencyContact) {
		this.emergencyContact = emergencyContact;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}
