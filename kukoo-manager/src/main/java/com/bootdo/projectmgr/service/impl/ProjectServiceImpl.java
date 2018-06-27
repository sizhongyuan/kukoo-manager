package com.bootdo.projectmgr.service.impl;

import com.bootdo.projectmgr.dao.ProjectDao;
import com.bootdo.projectmgr.domain.ProjectDO;
import com.bootdo.projectmgr.service.ProjectService;
import com.bootdo.projectmgr.service.SubProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectDao projectDao;
    @Autowired
    private SubProjectService subProjectService;

    @Override
    public ProjectDO get(String id) throws Exception{
        ProjectDO projectDO = projectDao.get(id);
        return projectDO;
    }

    @Override
    public List<ProjectDO> list(Map<String, Object> map) throws Exception{
        List<ProjectDO> list = projectDao.list(map);
        return list;
    }

    @Override
    public int count(Map<String, Object> map) throws Exception{

        return projectDao.count(map);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int save(ProjectDO projectDO) throws Exception{

        return projectDao.save(projectDO);
    }

    @Override
    public int update(ProjectDO projectDO) throws Exception{
        return projectDao.update(projectDO);
    }

    @Transactional
    @Override
    public int remove(String id) throws Exception{
        //先删除二级项目模板
        subProjectService.removeByProjectId(id);
        //再删除一级项目模板
        return projectDao.remove(id);
    }

    @Transactional
    @Override
    public int batchRemove(String[] ids) throws Exception{
        return projectDao.batchRemove(ids);
    }

    /**
     * 获取project序列
     * @return int
     * */
    @Override
    public int getSequence() throws Exception{
        return projectDao.getSequence();
    }
}
