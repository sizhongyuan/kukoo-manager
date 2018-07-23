package com.bootdo.projectmgr.service;

import com.bootdo.projectmgr.domain.SubProjectDO;

import java.util.List;
import java.util.Map;

/**
 * 二级项目管理
 *
 * @author szy
 * @date 2018-05-10 22:34:00
 */
public interface SubProjectService {

    SubProjectDO get(String id) throws Exception ;

    List<SubProjectDO> list(Map<String, Object> map) throws Exception ;

    int count(Map<String, Object> map) throws Exception ;

    int save(SubProjectDO subProjectDO) throws Exception ;

    int update(SubProjectDO subProjectDO) throws Exception ;

    int remove(String id) throws Exception ;

    int batchRemove(String[] ids) throws Exception ;

    /**
     * 获取project序列
     * @return int
     * */
    int getSequence() throws Exception ;
    /**
     * 根据一级项目id 获取二级项目id
     * @return int
     * */
    String getSubProjectId(String projectId) throws Exception;
    /**
     * 根据一级项目id 删除对应的二级项目
     * @return int
     * */
    int removeByProjectId(String projectId) throws Exception;

}
