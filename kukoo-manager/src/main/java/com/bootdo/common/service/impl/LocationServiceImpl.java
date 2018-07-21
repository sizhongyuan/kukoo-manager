package com.bootdo.common.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootdo.common.dao.LocationDao;
import com.bootdo.common.domain.CityDO;
import com.bootdo.common.domain.CountryDO;
import com.bootdo.common.domain.ProvinceDO;
import com.bootdo.common.service.LocationService;

/**
 * 国家省市service
 * @author chenjianghe
 *
 */
@Service
public class LocationServiceImpl implements LocationService{

	@Autowired
	private LocationDao locationDao;
	/**
	 * 查询国家
	 * @return
	 */
	@Override
	public List<CountryDO> countris() {
		// TODO Auto-generated method stub
		return locationDao.countris();
	}

	/**
	 * 根据国家查询省份
	 * @param countryId
	 * @return
	 */
	@Override
	public List<ProvinceDO> provinces(String countryId) {
		// TODO Auto-generated method stub
		return locationDao.provinces(countryId);
	}

	/**
	 * 根据省份查询地市
	 * @param provinceId
	 * @return
	 */
	@Override
	public List<CityDO> cities(String provinceId) {
		// TODO Auto-generated method stub
		return locationDao.cities(provinceId);
	}
	
	/**
	 * 根据国家id查询国家名称
	 * @param countryId
	 * @return
	 */
	@Override
	public String getCountryName(String countryId) {
		return locationDao.getCountryName(countryId);
	}
	
	/**
	 * 根据省份id查询省份名称
	 * @param provinceId
	 * @return
	 */
	@Override
	public String getProvinceName(String provinceId) {
		return locationDao.getProvinceName(provinceId);
	}
	
	/**
	 * 根据城市id查询城市名称
	 * @param cityId
	 * @return
	 */
	public String getCityName(String cityId) {
		return locationDao.getCityName(cityId);
	}

}
