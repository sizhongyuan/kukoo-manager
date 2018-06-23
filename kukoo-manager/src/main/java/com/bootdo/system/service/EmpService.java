package com.bootdo.system.service;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.bootdo.system.domain.EmpDO;

/**
 * 顾问service接口
 * @author chenjianghe
 *
 */
@Service
public interface EmpService {
	
	/**
	 * 保存顾问
	 * @param empDO
	 */
	public void save(EmpDO empDO);
	
	/**
	 * 根据顾问手机号查询用户对象
	 * @param empId 手机号
	 * @return EmpDO 顾问对象
	 */
	public EmpDO getEmpByEmpId(@Param("empId") String empId);
	
	/**
	 * 修改顾问
	 * @param empDO 顾问对象
	 */
	public void update(EmpDO empDO);
	
	/**
	 * 根据empId删除顾问
	 * @param empId
	 */
	public void deleteByEmpId(@Param("empId") String empId);

}
