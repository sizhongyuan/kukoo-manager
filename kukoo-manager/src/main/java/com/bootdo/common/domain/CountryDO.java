package com.bootdo.common.domain;

/**
 * 国家
 * @author chenjianghe
 *
 */
public class CountryDO {

	/**
	 * id
	 */
	private int id;
	
	/**
	 * 国家id
	 */
	private String countryId;
	
	/**
	 * 国家name
	 */
	private String country;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCountryId() {
		return countryId;
	}

	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
}
