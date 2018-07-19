package com.bootdo.common.domain;

/**
 * 省份
 * @author chenjianghe
 *
 */
public class ProvinceDO {

	/**
	 * id
	 */
	private int id;
	
	/**
	 * 省份id
	 */
	private String provinceId;
	
	/**
	 * 省份
	 */
	private String province;
	
	/**
	 * 国家
	 */
	private String countryId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCountryId() {
		return countryId;
	}

	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}
	
}
