package com.bootdo.timeline.domain;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * 通知通告
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2017-10-05 17:11:16
 */
public class TtTimelineTempLink implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键
	private int id;
	//关联的项目ID
	private String projectId;
	//环节名称
	private String linkName;
	//环节时限
	private String linkLimit;
	//简介
	private String linkDes;
	//详细信息
	private String linkDetails;
	//排序字段
	private String orderby;
	//创建时间
	private Date createTime;
	//创建人
	private String createUserId;
	//删除标识
	private int deleted;
	//最后一次更新人
	private String lastUpdateUserId;
	//最后一次更新时间
	private Date lastUpdateTime;
	//备注
	private String remark;
	
	private Long[] userIds;

	private List<TtTimelineTempFile> ttTimelineTempFile;

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
	 * 设置：关联的项目ID
	 */
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	/**
	 * 获取：关联的项目ID
	 */
	public String getProjectId() {
		return projectId;
	}
	/**
	 * 设置：环节名称
	 */
	public void setLinkName(String linkName) {
		this.linkName = linkName;
	}
	/**
	 * 获取：环节名称
	 */
	public String getLinkName() {
		return linkName;
	}
	/**
	 * 设置：环节时限
	 */
	public void setLinkLimit(String linkLimit) {
		this.linkLimit = linkLimit;
	}
	/**
	 * 获取：环节时限
	 */
	public String getLinkLimit() {
		return linkLimit;
	}
	/**
	 * 设置：简介
	 */
	public void setLinkDes(String linkDes) {
		this.linkDes = linkDes;
	}
	/**
	 * 获取：简介
	 */
	public String getLinkDes() {
		return linkDes;
	}
	/**
	 * 设置：详细信息
	 */
	public void setLinkDetails(String linkDetails) {
		this.linkDetails = linkDetails;
	}
	/**
	 * 获取：详细信息
	 */
	public String getLinkDetails() {
		return linkDetails;
	}
	/**
	 * 设置：排序字段
	 */
	public void setOrderby(String orderby) {
		this.orderby = orderby;
	}
	/**
	 * 获取：排序字段
	 */
	public String getOrderby() {
		return orderby;
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
	/**
	 * 设置：创建人
	 */
	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}
	/**
	 * 获取：创建人
	 */
	public String getCreateUserId() {
		return createUserId;
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
	 * 设置：最后一次更新人
	 */
	public void setLastUpdateUserId(String lastUpdateUserId) {
		this.lastUpdateUserId = lastUpdateUserId;
	}
	/**
	 * 获取：最后一次更新人
	 */
	public String getLastUpdateUserId() {
		return lastUpdateUserId;
	}
	/**
	 * 设置：最后一次更新时间
	 */
	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	/**
	 * 获取：最后一次更新时间
	 */
	public Date getLastUpdateTime() {
		return lastUpdateTime;
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
	public Long[] getUserIds() {
		return userIds;
	}
	public void setUserIds(Long[] userIds) {
		this.userIds = userIds;
	}
	public List<TtTimelineTempFile> getTtTimelineTempFile() {
		return ttTimelineTempFile;
	}
	public void setTtTimelineTempFile(List<TtTimelineTempFile> ttTimelineTempFile) {
		this.ttTimelineTempFile = ttTimelineTempFile;
	}

	@Override
	public String toString() {
		return "ttTimelineTempLink{" +
				"id=" + id +
				", projectId='" + projectId + '\'' +
				", linkName='" + linkName + '\'' +
				", linkLimit='" + linkLimit + '\'' +
				", linkDes='" + linkDes + '\'' +
				", linkDetails='" + linkDetails + '\'' +
				", orderby=" + orderby +
				", createTime=" + createTime +
				", createUserId='" + createUserId + '\'' +
				", deleted=" + deleted +
				", lastUpdateUserId='" + lastUpdateUserId + '\'' +
				", lastUpdateTime='" + lastUpdateTime + '\'' +
				", remark='" + remark + '\'' +
				", userIds=" + Arrays.toString(userIds) + '\'' +
				", ttTimelineTempFile=" + ttTimelineTempFile +
				'}';
	}
}