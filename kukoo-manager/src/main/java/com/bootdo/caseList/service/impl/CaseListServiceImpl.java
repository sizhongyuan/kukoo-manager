package com.bootdo.caseList.service.impl;

import com.bootdo.caseList.dao.CaseListDao;
import com.bootdo.caseList.domain.TtCase;
import com.bootdo.caseList.service.CaseListService;
import com.bootdo.timeline.domain.TtTimelineTempFile;
import com.bootdo.timeline.domain.TtTimelineTempLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class CaseListServiceImpl implements CaseListService {
    @Autowired
    private CaseListDao caseListDao;

    @Override
    public TtCase get(Long id) {
        TtCase ttCase = caseListDao.get(id);
        return ttCase;
    }

//    @Override
//    public List<TtTimelineTempLink> getOrderby(String projectId) {
//        List<TtTimelineTempLink> tempOrderbyList = tlTempDao.getOrderby(projectId);
//        return tempOrderbyList;
//    }

    @Override
    public List<TtCase> list(Map<String, Object> map) {
        List<TtCase> ttCaseList = caseListDao.list(map);
        return ttCaseList;
    }

    @Override
    public int count(Map<String, Object> map) {
        return caseListDao.count(map);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int save(TtCase ttCase, HttpServletRequest request) {
        ttCase.setCreateTime(new Date());
//        ttTimelineTempLink.setCreateUserId(getUser().getUsername());
        int r = caseListDao.save(ttCase);
        if (r > 0){
            return 1;
        }else {
            return 0;
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int update(TtCase ttCase,HttpServletRequest request) {
//        ttTimelineTempLink.setLastUpdateTime(new Date());
//        ttTimelineTempLink.setLastUpdateUserId(getUser().getUsername());
        int r = caseListDao.update(ttCase);
        if (r > 0){
            return 1;
        }else {
            return 0;
        }
    }

    @Transactional
    @Override
    public int remove(int id) {
        return caseListDao.remove(id);
    }

    @Transactional
    @Override
    public int batchRemove(int[] ids) {
        return caseListDao.batchRemove(ids);
    }

}
