package com.bootdo.system.service;

import java.util.List;
import java.util.Map;

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
	 * 查询顾问列表
	 * @return
	 */
	public List list(Map<String, Object> map);
	
	/**
	 * 查询列表总数
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
