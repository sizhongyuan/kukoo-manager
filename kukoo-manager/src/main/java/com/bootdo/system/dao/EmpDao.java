package com.bootdo.system.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.bootdo.system.domain.EmpDO;
import com.bootdo.system.domain.UserDO;

/**
 * 顾问dao接口
 * @author chenjianghe
 *
 */
@Mapper
public interface EmpDao {
	
	/**
	 * 查询顾问
	 * @return
	 */
	public List<UserDO> list(Map<String, Object> map);

	/**
	 * 查询总数
	 * @return
	 */
	public int count(Map<String, Object> map);
	
	/**
	 * 查询顾问关联客户
	 * @return
	 */
	public List clientList(Map<String, Object> map);
	
	/**
	 * 查询顾问关联客户总数
	 * @return
	 */
	public int clientCount(Map<String, Object> map);
	
	/**
	 * 解除关联
	 */
	public void removeRef(Long id);
	
	
	
	
	
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
