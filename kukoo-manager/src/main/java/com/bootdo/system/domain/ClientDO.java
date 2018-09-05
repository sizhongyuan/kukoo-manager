package com.bootdo.system.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * 客户表
 * @author zhaobowen
 *
 */
public class ClientDO implements Serializable {
    //用户ID号 	系统生成（规则：U+7位数，如 U0000001。按顺序下排）
    private String clientId;
    //注册时间		系统生成
  	private Date registTime;
  	//账号类型 		用户账号\业务人员账号
  	private String accountType;
  	//头像		
  	private String clientPhoto;
  	//性别		男、女
    private String sex;
    //现居住地
    private String liveAddress;
    //状态  	1：注册、2：评估、3：签约（未付款）、4：签约、5：完成、6：终止
    private String clientStatus;
    //意向	1：想移民、2：申请中、3：已移民、4：保密
    private String intention;
    //意向国家	国家等，城市可选加备注
    private String intentionCountry;
    //昵称
  	private String nickname;
  	//中文姓名
  	private String cnname;
  	//英文姓名
  	private String enname;
  	//配偶
  	private String spouse;
  	//手机号码国内
  	private String mobileInland;
  	//手机号码国外
  	private String mobileForeign;
  	//邮箱
    private String email;
    //微信号
    private String wechar;
    //其他_联系方式
    private String otherContact;
    //评估记录
    private String assessNotes;
    //咨询日期
    private Date advisoryTime;
    //咨询顾问
    private String advisoryConsultant;
    //咨询记录
    private String advisoryNotes;
    //咨询结果
    private String advisoryResult;
    //备注
  	private String remark;
  	// 用户名
    private String username;
  	// 密码
    private String password;
    // 状态 0:正常，1:禁用
    private Integer status;
    //修改日期
    private Date updateTime;
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
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
	public String getClientPhoto() {
		return clientPhoto;
	}
	public void setClientPhoto(String clientPhoto) {
		this.clientPhoto = clientPhoto;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getLiveAddress() {
		return liveAddress;
	}
	public void setLiveAddress(String liveAddress) {
		this.liveAddress = liveAddress;
	}
	public String getClientStatus() {
		return clientStatus;
	}
	public void setClientStatus(String clientStatus) {
		this.clientStatus = clientStatus;
	}
	public String getIntention() {
		return intention;
	}
	public void setIntention(String intention) {
		this.intention = intention;
	}
	public String getIntentionCountry() {
		return intentionCountry;
	}
	public void setIntentionCountry(String intentionCountry) {
		this.intentionCountry = intentionCountry;
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
	public String getSpouse() {
		return spouse;
	}
	public void setSpouse(String spouse) {
		this.spouse = spouse;
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
	public String getWechar() {
		return wechar;
	}
	public void setWechar(String wechar) {
		this.wechar = wechar;
	}
	public String getOtherContact() {
		return otherContact;
	}
	public void setOtherContact(String otherContact) {
		this.otherContact = otherContact;
	}
	public String getAssessNotes() {
		return assessNotes;
	}
	public void setAssessNotes(String assessNotes) {
		this.assessNotes = assessNotes;
	}
	public Date getAdvisoryTime() {
		return advisoryTime;
	}
	public void setAdvisoryTime(Date advisoryTime) {
		this.advisoryTime = advisoryTime;
	}
	public String getAdvisoryConsultant() {
		return advisoryConsultant;
	}
	public void setAdvisoryConsultant(String advisoryConsultant) {
		this.advisoryConsultant = advisoryConsultant;
	}
	public String getAdvisoryNotes() {
		return advisoryNotes;
	}
	public void setAdvisoryNotes(String advisoryNotes) {
		this.advisoryNotes = advisoryNotes;
	}
	public String getAdvisoryResult() {
		return advisoryResult;
	}
	public void setAdvisoryResult(String advisoryResult) {
		this.advisoryResult = advisoryResult;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
    
    
    
    
    
    
    
    
    
    
    
    
    
}
