package com.bootdo.system.domain;

/**
 * 顾问关联客户
 * @author chenjianghe
 *
 */
public class EmpRefClientDO {

	/**
	 * 主键id
	 */
	private Long id;
	/**
	 * 顾问id
	 */
	private String empId;
	
	/**
	 * 客户id
	 */
	private String clientId;
	
	/**
	 * 删除标识
	 */
	private String deleted;

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getDeleted() {
		return deleted;
	}

	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
