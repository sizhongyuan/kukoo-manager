package com.bootdo.system.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bootdo.system.dao.EmpDao;
import com.bootdo.system.dao.UserDao;
import com.bootdo.system.domain.EmpDO;
import com.bootdo.system.service.EmpService;

/**
 * 顾问service实现类
 * @author chenjianghe
 *
 */
@Service
public class EmpServiceImpl implements EmpService{
	
	@Autowired
	private EmpDao empMapper;
	
	

	/**
	 * 保存顾问
	 * @param empDO
	 */
	@Override
	@Transactional
	public void save(EmpDO empDO) {
		// TODO Auto-generated method stub
		empMapper.save(empDO);
	}

	/**
	 * 根据顾问手机号查询用户对象
	 * @param empId 手机号
	 * @return EmpDO 顾问对象
	 */
	@Override
	@Transactional
	public EmpDO getEmpByEmpId(String empId) {
		// TODO Auto-generated method stub
		return empMapper.getEmpByEmpId(empId);
	}

	/**
	 * 修改顾问
	 * @param empDO 顾问对象
	 */
	@Override
	@Transactional
	public void update(EmpDO empDO) {
		// TODO Auto-generated method stub
		empMapper.update(empDO);
	}

	/**
	 * 根据empId删除顾问
	 * @param empId
	 */
	@Override
	@Transactional
	public void deleteByEmpId(String empId) {
		// TODO Auto-generated method stub
		empMapper.deleteByEmpId(empId);
	}

	/**
	 * 查询顾问列表
	 * @return
	 */
	@Override
	public List list(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return empMapper.list(map);
	}
	
	/**
	 * 查询列表总数
	 * @return
	 */
	@Override
	public int count(Map<String, Object> map) {
		return empMapper.count(map);
	}

	/**
	 * 查询顾问关联客户
	 * @return
	 */
	@Override
	public List clientList(Map<String, Object> map) { 
		// TODO Auto-generated method stub
		return empMapper.clientList(map);
	}
	
	/**
	 * 查询顾问关联客户总数
	 * @return
	 */
	@Override
	public int clientCount(Map<String, Object> map) {
		return empMapper.clientCount(map);
	}
	
	/**
	 * 解除关联
	 */
	public void removeRef(Long id) {
		empMapper.removeRef(id);
	}

}
