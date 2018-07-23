package com.bootdo.accessories.service.impl;

import com.bootdo.accessories.dao.AccessoriesDao;
import com.bootdo.accessories.domain.AccessoriesDO;
import com.bootdo.accessories.service.AccessoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class AccessoriesServiceImpl implements AccessoriesService {

    @Autowired
    private AccessoriesDao accessoriesDao;

    @Override
    public AccessoriesDO get(String id) throws Exception {
        return accessoriesDao.get(id);
    }

    @Override
    public AccessoriesDO getByFileName(String fileName) throws Exception{
        return accessoriesDao.getByFileName(fileName);
    }

    @Override
    public List<AccessoriesDO> list(Map<String, Object> map) throws Exception {
        return accessoriesDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map) throws Exception {
        return accessoriesDao.count(map);
    }

    @Override
    public int save(AccessoriesDO accessoriesDO) throws Exception {
        return accessoriesDao.save(accessoriesDO);
    }

    @Override
    public int update(AccessoriesDO accessoriesDO) throws Exception {
        return accessoriesDao.update(accessoriesDO);
    }

    @Override
    public int remove(String id) throws Exception {
        return accessoriesDao.remove(id);
    }

    @Override
    public int batchRemove(String[] ids) throws Exception {
        return accessoriesDao.batchRemove(ids);
    }

    @Override
    public List<AccessoriesDO> listByIds(String[] ids) throws Exception {
        return accessoriesDao.listByIds(ids);
    }
}
