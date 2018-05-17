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
public class TtTimelineTempFile implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键
	private int id;
	//关联的模板id
	private int tempId;
	//附件名
	private String fileName;
	//关联的附件id
	private String fileId;
	//创建时间
	private Date createTime;
	//删除标识
	private int deleted;

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
	 * 设置：关联的模板id
	 */
	public void setTempId(int tempId) {
		this.tempId = tempId;
	}
	/**
	 * 获取：关联的模板id
	 */
	public int getTempId() {
		return tempId;
	}
	/**
	 * 设置：附件名
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	/**
	 * 获取：附件名
	 */
	public String getFileName() {
		return fileName;
	}
	/**
	 * 设置：关联的附件id
	 */
	public void setFileId(String fileId) {
		this.fileId = fileId;
	}
	/**
	 * 获取：关联的附件id
	 */
	public String getFileId() {
		return fileId;
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
}