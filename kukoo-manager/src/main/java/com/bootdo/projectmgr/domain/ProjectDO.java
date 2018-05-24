package com.bootdo.projectmgr.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 一级项目管理
 *
 * @author szy
 * @date 2018-05-09 20:26:14
 */
public class ProjectDO implements Serializable {
    /**
     * 一级项目id
     * */
    private int id;
    /**
     * 注册时间
     * */
    private Date createTime;
    /**
     * 一级项目名称
     * */
    private String projectName;
    /**
     * 国家
     * */
    private String country;
    /**
     * 项目类别
     * */
    private String projectType;
    /**
     * 项目类别-其他
     * */
    private String projectTypeOther;
    /**
     * 移民方式
     * */
    private String immigrationMode;
    /**
     * 开放情况
     * */
    private String ifOpen;
    /**
     * 项目简介
     * */
    private String introduction;
    /**
     * 政策解读
     * */
    private String policyInterpretation;
    /**
     * 申请流程
     * */
    private String applicationProcess;
    /**
     * 申请条件
     * */
    private String applicationRequirement;
    /**
     * 材料清单
     * */
    private String material;
    /**
     * 费用详情
     * */
    private String costDetail;
    /**
     * 资金要求
     * */
    private String funding;
    /**
     * 处理周期
     * */
    private String processingeriod;
    /**
     * 居住要求
     * */
    private String residenceRequirement;
    /**
     * 签证类别
     * */
    private String visaType;
    /**
     * 移民局官网
     * */
    private String cicnews;
    /**
     * 具体项目打分表链接
     * */
    private String gradeUrl;
    /**
     * 备注
     * */
    private String remark;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public String getProjectTypeOther() {
        return projectTypeOther;
    }

    public void setProjectTypeOther(String projectTypeOther) {
        this.projectTypeOther = projectTypeOther;
    }

    public String getImmigrationMode() {
        return immigrationMode;
    }

    public void setImmigrationMode(String immigrationMode) {
        this.immigrationMode = immigrationMode;
    }

    public String getIfOpen() {
        return ifOpen;
    }

    public void setIfOpen(String ifOpen) {
        this.ifOpen = ifOpen;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getPolicyInterpretation() {
        return policyInterpretation;
    }

    public void setPolicyInterpretation(String policyInterpretation) {
        this.policyInterpretation = policyInterpretation;
    }

    public String getApplicationProcess() {
        return applicationProcess;
    }

    public void setApplicationProcess(String applicationProcess) {
        this.applicationProcess = applicationProcess;
    }

    public String getApplicationRequirement() {
        return applicationRequirement;
    }

    public void setApplicationRequirement(String applicationRequirement) {
        this.applicationRequirement = applicationRequirement;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getCostDetail() {
        return costDetail;
    }

    public void setCostDetail(String costDetail) {
        this.costDetail = costDetail;
    }

    public String getFunding() {
        return funding;
    }

    public void setFunding(String funding) {
        this.funding = funding;
    }

    public String getProcessingeriod() {
        return processingeriod;
    }

    public void setProcessingeriod(String processingeriod) {
        this.processingeriod = processingeriod;
    }

    public String getResidenceRequirement() {
        return residenceRequirement;
    }

    public void setResidenceRequirement(String residenceRequirement) {
        this.residenceRequirement = residenceRequirement;
    }

    public String getVisaType() {
        return visaType;
    }

    public void setVisaType(String visaType) {
        this.visaType = visaType;
    }

    public String getCicnews() {
        return cicnews;
    }

    public void setCicnews(String cicnews) {
        this.cicnews = cicnews;
    }

    public String getGradeUrl() {
        return gradeUrl;
    }

    public void setGradeUrl(String gradeUrl) {
        this.gradeUrl = gradeUrl;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
