package com.bootdo.projectmgr.service.impl;

import com.bootdo.projectmgr.dao.SubProjectDao;
import com.bootdo.projectmgr.domain.SubProjectDO;
import com.bootdo.projectmgr.service.SubProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SubProjectServiceImpl implements SubProjectService {

    @Autowired
    private SubProjectDao subProjectDao;

    @Override
    public SubProjectDO get(String id) throws Exception  {
        return subProjectDao.get(id);
    }

    @Override
    public List<SubProjectDO> list(Map<String, Object> map) throws Exception  {
        return subProjectDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map) throws Exception  {
        return subProjectDao.count(map);
    }

    @Override
    public int save(SubProjectDO subProjectDO) throws Exception  {
        return subProjectDao.save(subProjectDO);
    }

    @Override
    public int update(SubProjectDO subProjectDO) throws Exception  {
        return subProjectDao.update(subProjectDO);
    }

    @Override
    public int remove(String id) throws Exception  {
        return subProjectDao.remove(id);
    }

    @Override
    public int batchRemove(String[] ids) throws Exception  {
        return subProjectDao.batchRemove(ids);
    }

    @Override
    public int getSequence() throws Exception  {
        return subProjectDao.getSequence();
    }

    @Override
    public String getSubProjectId(String projectId) throws Exception {
        String subProjectId;
        Map<String,Object> map = new HashMap<>();
        map.put("projectId",projectId);
        List<SubProjectDO> list = subProjectDao.list(map);
        if(list != null && list.size() > 0){
            SubProjectDO subDO = list.get(0);
            String maxSubProjectId = subDO.getId();
            String[] maxSubProjectIds = maxSubProjectId.split("-");
            Integer i = new Integer(maxSubProjectIds[1]);
            String subId = i.toString();
            if(subId.length()<1){
                subId = "0"+subId;
            }
            subProjectId = projectId + "-" + subId;

        }else{
            subProjectId = projectId + "-01";
        }
        return subProjectId;
    }
}
