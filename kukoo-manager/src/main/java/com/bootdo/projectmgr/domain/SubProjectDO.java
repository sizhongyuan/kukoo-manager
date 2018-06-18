package com.bootdo.projectmgr.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 二级项目管理
 *
 * @author szy
 * @date 2018-05-09 20:26:14
 */
public class SubProjectDO implements Serializable {

    /**
     * 二级项目id
     * */
    private String id;
    /**
     * 注册时间
     * */
    private Date createTime;
    /**
     * 二级项目名称
     * */
    private String subProjectName;
    /**
     * 所属一级项目Id
     * */
    private String projectId;
    /**
     * 配额情况
     * */
    private String quota;
    /**
     * 是否抢名额
     * */
    private String ifQuota;
    /**
     * 项目状态
     * */
    private String status;
    /**
     * 政策开始日期
     * */
    private Date startTime;
    /**
     * 政策结束日期
     * */
    private Date endTime;
    /**
     * 政策细节
     * */
    private String policy;
    /**
     * 备注
     * */
    private String remark;
    /**
     * 删除标识 0,正常；1,已删除
     * */
    private String deleted;

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getSubProjectName() {
        return subProjectName;
    }

    public void setSubProjectName(String subProjectName) {
        this.subProjectName = subProjectName;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getQuota() {
        return quota;
    }

    public void setQuota(String quota) {
        this.quota = quota;
    }

    public String getIfQuota() {
        return ifQuota;
    }

    public void setIfQuota(String ifQuota) {
        this.ifQuota = ifQuota;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getPolicy() {
        return policy;
    }

    public void setPolicy(String policy) {
        this.policy = policy;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
