package com.bootdo.system.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.bootdo.system.domain.EmpDO;

/**
 * 顾问dao接口
 * @author chenjianghe
 *
 */
@Mapper
public interface EmpDao {

	/**
	 * 保存顾问
	 * @param empDO
	 */
	public void save(EmpDO empDO);
	
	/**
	 * 根据顾问empId查询顾问
	 * @param empId 
	 * @return EmpDO 顾问对象
	 */
	public EmpDO getEmpByEmpId(@Param("empId") String empId);
	
	/**
	 * 根据条件查询顾问列表
	 * @param condition 
	 * @return EmpDO 顾问对象
	 */
	public List getEmpByCondition(String condition);
	
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
