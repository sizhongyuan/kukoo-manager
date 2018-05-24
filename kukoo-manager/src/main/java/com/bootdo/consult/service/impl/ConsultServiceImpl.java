package com.bootdo.consult.service.impl;

import com.bootdo.consult.dao.ConsultDao;
import com.bootdo.consult.model.Consult;
import com.bootdo.consult.service.ConsultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 咨询记录
 * Created by gang on 2018/5/20.
 */
@Service
public class ConsultServiceImpl implements ConsultService{

    @Autowired
    private ConsultDao consultDao;

    @Override
    public Consult get(Integer id) {
        return consultDao.get(id);
    }

    @Override
    public List<Consult> list(Map<String, Object> map) {
        return consultDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return consultDao.count(map);
    }

    @Override
    public int save(Consult consult) {
        return consultDao.save(consult);
    }

    @Override
    public int update(Consult consult) {
        return consultDao.update(consult);
    }

    @Override
    public int remove(Integer id) {
        return consultDao.remove(id);
    }

    @Override
    public int batchRemove(Integer[] ids) {
        return consultDao.batchRemove(ids);
    }
}
