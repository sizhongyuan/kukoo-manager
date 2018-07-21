package com.bootdo.common.domain;

/**
 * 城市
 * @author chenjianghe
 *
 */
public class CityDO {

	/**
	 * id
	 */
	private int id;
	
	/**
	 * 城市id
	 */
	private String cityId;
	
	/**
	 * 城市
	 */
	private String city;
	
	/**
	 * 省id
	 */
	private String provinceId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}
	
}
