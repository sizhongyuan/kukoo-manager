package com.bootdo.projectmgr.service.impl;

import com.bootdo.projectmgr.dao.ProjectDao;
import com.bootdo.projectmgr.domain.ProjectDO;
import com.bootdo.projectmgr.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectDao projectDao;

    @Override
    public ProjectDO get(String id) {
        ProjectDO projectDO = projectDao.get(id);
        return projectDO;
    }

    @Override
    public List<ProjectDO> list(Map<String, Object> map) {
        List<ProjectDO> list = projectDao.list(map);
        return list;
    }

    @Override
    public int count(Map<String, Object> map) {

        return projectDao.count(map);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int save(ProjectDO projectDO) {

        return projectDao.save(projectDO);
    }

    @Override
    public int update(ProjectDO projectDO) {
        return projectDao.update(projectDO);
    }

    @Transactional
    @Override
    public int remove(String id) {
        return projectDao.remove(id);
    }

    @Transactional
    @Override
    public int batchRemove(String[] ids) {
        return projectDao.batchRemove(ids);
    }

    /**
     * 获取project序列
     * @return int
     * */
    @Override
    public int getSequence(){
        return projectDao.getSequence();
    }
}
