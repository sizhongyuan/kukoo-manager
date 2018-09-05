package com.bootdo.system.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.bootdo.system.domain.ClientDO;

/**
 * 
 * @author zbw
 *
 */
@Mapper
public interface ClientDao {

	ClientDO get(String clientId);
	
	List<ClientDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(ClientDO client);
	
	int update(ClientDO client);
	
	int remove(String clientId);
	
	int batchRemove(Long[] userIds);
	
	Long[] listAllDept();
	
	int getClientSecquence();
}
