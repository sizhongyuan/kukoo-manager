package com.bootdo.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bootdo.system.dao.EmpDao;
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

}
