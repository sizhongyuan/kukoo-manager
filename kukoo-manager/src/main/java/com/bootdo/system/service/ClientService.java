package com.bootdo.system.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.bootdo.system.vo.UserVO;

import org.springframework.stereotype.Service;

import com.bootdo.common.domain.Tree;
import com.bootdo.system.domain.ClientDO;
import com.bootdo.system.domain.DeptDO;
import com.bootdo.system.domain.UserDO;

import org.springframework.web.multipart.MultipartFile;

@Service
public interface ClientService {
	ClientDO get(String id);

	List<ClientDO> list(Map<String, Object> map);

	int count(Map<String, Object> map);

	int save(ClientDO clientDO);

	int update(ClientDO clientDO);

	int remove(String clientId);

	int batchremove(Long[] userIds);

	boolean exit(Map<String, Object> params);

	Set<String> listRoles(Long userId);

	int resetPwd(UserVO userVO,UserDO userDO) throws Exception;
	int adminResetPwd(UserVO userVO) throws Exception;
	Tree<DeptDO> getTree();
	
	/**
	 * 获取客户序列
	 * @return
	 */
    public int getClientSecquence();

	/**
	 * 更新个人信息
	 * @param userDO
	 * @return
	 */
	int updatePersonal(ClientDO clientDO);

	/**
	 * 更新个人图片
	 * @param file 图片
	 * @param avatar_data 裁剪信息
	 * @param userId 用户ID
	 * @throws Exception
	 */
    Map<String, Object> updatePersonalImg(MultipartFile file, String avatar_data, Long userId) throws Exception;
}
