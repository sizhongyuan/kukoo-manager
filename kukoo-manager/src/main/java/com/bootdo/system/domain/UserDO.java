package com.bootdo.system.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class UserDO implements Serializable {
    private static final long serialVersionUID = 1L;
    //
    private String userId;
    // 用户名
    private String username;
    // 用户真实姓名
    private String name;
    // 密码
    private String password;
    // 部门
    private Long deptId;
    private String deptName;
    // 邮箱
    private String email;
    // 手机号
    private String mobile;
    // 状态 0:禁用，1:正常
    private Integer status;
    // 创建用户id
    private Long userIdCreate;
    // 创建时间
    private Date gmtCreate;
    // 修改时间
    private Date gmtModified;
    //角色
    private List<Long> roleIds;
    //性别
    private Long sex;
    //出身日期
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birth;
    //图片ID
    private Long picId;
    //现居住地
    private String liveAddress;
    //爱好
    private String hobby;
    //所在地区
    private String district;
    
    
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
  	//国家
  	private String country;
  	 //省份
    private String province;
    //所在城市
    private String city;
    //国外城市
    private String foreignCity;
  	//角色
  	private String role;
//  	//状态
//  	private String status;
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
//  	//邮箱
//  	private String email;
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
  	//删除标识
  	private String deleted;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getUserIdCreate() {
        return userIdCreate;
    }

    public void setUserIdCreate(Long userIdCreate) {
        this.userIdCreate = userIdCreate;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public List<Long> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(List<Long> roleIds) {
        this.roleIds = roleIds;
    }

    public Long getSex() {
        return sex;
    }

    public void setSex(Long sex) {
        this.sex = sex;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Long getPicId() {
        return picId;
    }

    public void setPicId(Long picId) {
        this.picId = picId;
    }

    public String getLiveAddress() {
        return liveAddress;
    }

    public void setLiveAddress(String liveAddress) {
        this.liveAddress = liveAddress;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    @Override
    public String toString() {
        return "UserDO{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", deptId=" + deptId +
                ", deptName='" + deptName + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", status=" + status +
                ", userIdCreate=" + userIdCreate +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", roleIds=" + roleIds +
                ", sex=" + sex +
                ", birth=" + birth +
                ", picId=" + picId +
                ", liveAddress='" + liveAddress + '\'' +
                ", hobby='" + hobby + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", registTime='" + registTime + '\'' +
                ", accountType='" + accountType + '\'' +
                ", headImg='" + headImg + '\'' +
                ", gender='" + gender + '\'' +
                ", location='" + location + '\'' +
                ", role='" + role + '\'' +
                ", nickname='" + nickname + '\'' +
                ", cnname='" + cnname + '\'' +
                ", enname='" + enname + '\'' +
                ", institutions='" + institutions + '\'' +
                ", mobileInland='" + mobileInland + '\'' +
                ", mobileForeign='" + mobileForeign + '\'' +
                ", weChat='" + weChat + '\'' +
                ", other='" + other + '\'' +
                ", majorRange='" + majorRange + '\'' +
                ", level='" + level + '\'' +
                ", peopleNumber='" + peopleNumber + '\'' +
                ", caseNumber='" + caseNumber + '\'' +
                ", consultNumber='" + consultNumber + '\'' +
                ", workyear='" + workyear + '\'' +
                ", licensCase='" + licensCase + '\'' +
                ", baseSalary='" + baseSalary + '\'' +
                ", socialSecurity='" + socialSecurity + '\'' +
                ", companySecurity='" + companySecurity + '\'' +
                ", joinTime='" + joinTime + '\'' +
                ", leaveTime='" + leaveTime + '\'' +
                ", contract='" + contract + '\'' +
                ", laborLimit='" + laborLimit + '\'' +
                ", IDNumber='" + IDNumber + '\'' +
                ", bloodType='" + bloodType + '\'' +
                ", nativePlace='" + nativePlace + '\'' +
                ", birthday='" + birthday + '\'' +
                ", emergencyContact='" + emergencyContact + '\'' +
                ", remark='" + remark + '\'' +
                ", country='" + country + '\'' +
                ", foreignCity='" + foreignCity + '\'' +
                ", deleted='" + deleted + '\'' +
                '}';
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

	public String getDeleted() {
		return deleted;
	}

	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getForeignCity() {
		return foreignCity;
	}

	public void setForeignCity(String foreignCity) {
		this.foreignCity = foreignCity;
	}

}
