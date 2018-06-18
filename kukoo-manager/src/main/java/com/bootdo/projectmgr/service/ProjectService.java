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

    ProjectDO get(String id);

    List<ProjectDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(ProjectDO projectDO);

    int update(ProjectDO projectDO);

    int remove(String id);

    int batchRemove(String[] ids);

    /**
     * 获取project序列
     * @return int
     * */
    int getSequence();
}
