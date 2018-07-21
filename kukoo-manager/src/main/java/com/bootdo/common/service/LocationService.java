package com.bootdo.common.service;

import java.util.List;

import com.bootdo.common.domain.CityDO;
import com.bootdo.common.domain.CountryDO;
import com.bootdo.common.domain.ProvinceDO;

/**
 * 国家省市service
 * @author chenjianghe
 *
 */
public interface LocationService {

	/**
	 * 查询国家
	 * @return
	 */
	public List<CountryDO> countris();
	
	/**
	 * 根据国家查询省份
	 * @param countryId
	 * @return
	 */
	public List<ProvinceDO> provinces(String countryId);
	
	/**
	 * 根据省份查询地市
	 * @param provinceId
	 * @return
	 */
	public List<CityDO> cities(String provinceId);
	
	/**
	 * 根据国家id查询国家名称
	 * @param countryId
	 * @return
	 */
	public String getCountryName(String countryId);
	
	/**
	 * 根据省份id查询省份名称
	 * @param provinceId
	 * @return
	 */
	public String getProvinceName(String provinceId);
	
	/**
	 * 根据城市id查询城市名称
	 * @param cityId
	 * @return
	 */
	public String getCityName(String cityId);
}
