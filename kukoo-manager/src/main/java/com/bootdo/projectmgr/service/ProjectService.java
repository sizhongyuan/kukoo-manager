package com.bootdo.projectmgr.service;

import com.bootdo.common.utils.PageUtils;
import com.bootdo.projectmgr.domain.ProjectDO;

import java.util.List;
import java.util.Map;

/**
 * 一级项目管理
 *
 * @author szy
 * @date 2018-05-10 22:34:00
 */
public interface ProjectService {

    ProjectDO get(String id) throws Exception;

    List<ProjectDO> list(Map<String, Object> map) throws Exception;

    int count(Map<String, Object> map) throws Exception;

    int save(ProjectDO projectDO) throws Exception;

    int update(ProjectDO projectDO) throws Exception;

    int remove(String id) throws Exception;

    int batchRemove(String[] ids) throws Exception;

    /**
     * 获取project序列
     * @return int
     * */
    int getSequence() throws Exception;
}
