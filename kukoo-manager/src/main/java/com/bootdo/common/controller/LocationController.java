package com.bootdo.common.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootdo.common.domain.CityDO;
import com.bootdo.common.domain.CountryDO;
import com.bootdo.common.domain.DictDO;
import com.bootdo.common.domain.ProvinceDO;
import com.bootdo.common.service.LocationService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;

@Controller
@RequestMapping("/common/sysLocation")
public class LocationController {

	String prefix = "common/generator";
	
	@Autowired
	private LocationService locationService;
	
	@ResponseBody
	@GetMapping("/country")
	public List<CountryDO> country(@RequestParam Map<String, Object> params) {
		//查询国家
		List<CountryDO> countryList = locationService.countris();
		return countryList;
	}
	
	@ResponseBody
	@GetMapping("/province")
	public List<ProvinceDO> province(@RequestParam Map<String, Object> params) {
		//查询省份
		List<ProvinceDO> provinceList = locationService.provinces(params.get("countryId")+"");
		return provinceList;
	}
	
	@ResponseBody
	@GetMapping("/city")
	public List<CityDO> city(@RequestParam Map<String, Object> params) {
		//查询国家
		List<CityDO> cityList = locationService.cities(params.get("provinceId")+"");
		return cityList;
	}
	
	@ResponseBody
	@GetMapping("/countryName")
	public String countryName(@RequestParam Map<String, Object> params) {
		//根据id查询国家名称
		String countryId = (String)params.get("countryId");
		return locationService.getCountryName(countryId);
	}
	
	@ResponseBody
	@GetMapping("/provinceName")
	public String provinceName(@RequestParam Map<String, Object> params) {
		//根据id查询省份名称
		String provinceId = (String)params.get("provinceId");
		return locationService.getProvinceName(provinceId);
	}
	
	@ResponseBody
	@GetMapping("/cityName")
	public String cityName(@RequestParam Map<String, Object> params) {
		//根据id查询城市名称
		String cityId = (String)params.get("cityId");
		return locationService.getCityName(cityId);
	}
	
}
