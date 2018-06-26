package com.bootdo.timeline.service.impl;

import com.bootdo.timeline.dao.TLTempDao;
import com.bootdo.timeline.domain.TtTimelineTempFile;
import com.bootdo.timeline.domain.TtTimelineTempLink;
import com.bootdo.timeline.service.TLTempService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

import javax.servlet.http.HttpServletRequest;

import static com.bootdo.common.utils.ShiroUtils.getUser;

@Service
public class TLTempServiceImpl implements TLTempService {
    @Autowired
    private TLTempDao tlTempDao;

    @Override
    public TtTimelineTempLink get(Long id) {
        TtTimelineTempLink ttTimelineTempLink = tlTempDao.get(id);
        return ttTimelineTempLink;
    }

    @Override
    public List<TtTimelineTempLink> getOrderby(String projectId) {
        List<TtTimelineTempLink> tempOrderbyList = tlTempDao.getOrderby(projectId);
        return tempOrderbyList;
    }

    @Override
    public List<TtTimelineTempFile> queryFile(Long tempId) {
        List<TtTimelineTempFile> tempFileList = tlTempDao.queryFile(tempId);
        return tempFileList;
    }

    @Override
    public List<TtTimelineTempLink> list(Map<String, Object> map) {
        List<TtTimelineTempLink> ttTimelineTempLinkList = tlTempDao.list(map);
        return ttTimelineTempLinkList;
    }

    @Override
    public int count(Map<String, Object> map) {
        return tlTempDao.count(map);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int save(TtTimelineTempLink ttTimelineTempLink,HttpServletRequest request) {
        List<TtTimelineTempFile> tempFileList = ttTimelineTempLink.getTtTimelineTempFile();

        Integer orderby = tlTempDao.maxOrderby();
        if(orderby == null){
            orderby = 1;
        }else{
            orderby = orderby + 1;
        }
        ttTimelineTempLink.setOrderby(orderby.toString());

        ttTimelineTempLink.setCreateTime(new Date());
        ttTimelineTempLink.setCreateUserId(getUser().getUsername());
        int r = tlTempDao.save(ttTimelineTempLink);
        int r2 = 1;
        if(tempFileList != null){
            List<TtTimelineTempFile> ttTimelineTempFileList =  new ArrayList<TtTimelineTempFile>();
            for (int i=0;i < tempFileList.size(); i++){
                if (tempFileList.get(i).getFileName() != null && tempFileList.get(i).getFileName() != ""){
                    tempFileList.get(i).setCreateTime(new Date());
                    tempFileList.get(i).setTempId(ttTimelineTempLink.getId());
                    ttTimelineTempFileList.add(tempFileList.get(i));
                }
            }
            r2 = tlTempDao.saveFile(ttTimelineTempFileList);
        }
        if (r > 0 && r2 > 0){
            return 1;
        }else {
            return 0;
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int update(TtTimelineTempLink ttTimelineTempLink,HttpServletRequest request) {
        List<TtTimelineTempFile> tempFileList = ttTimelineTempLink.getTtTimelineTempFile();

        ttTimelineTempLink.setLastUpdateTime(new Date());
        ttTimelineTempLink.setLastUpdateUserId(getUser().getUsername());
        int r = tlTempDao.update(ttTimelineTempLink);
        int r2 = 1;
        if(tempFileList != null){
            tlTempDao.deleteFile(ttTimelineTempLink.getId());
            List<TtTimelineTempFile> ttTimelineTempFileList =  new ArrayList<TtTimelineTempFile>();
            for (int i=0;i < tempFileList.size(); i++){
                if (tempFileList.get(i).getFileName() != null && tempFileList.get(i).getFileName() != ""){
                    tempFileList.get(i).setCreateTime(new Date());
                    tempFileList.get(i).setTempId(ttTimelineTempLink.getId());
                    ttTimelineTempFileList.add(tempFileList.get(i));
                }
            }
            r2 = tlTempDao.saveFile(ttTimelineTempFileList);
        }
        if (r > 0 && r2 > 0){
            return 1;
        }else {
            return 0;
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateOrderby(HttpServletRequest request) {
        String[] ids = request.getParameterValues("tempId");
        String[] orderbies = request.getParameterValues("orderby");
        int r = 1;
        for (int i=0;i < ids.length; i++){
            TtTimelineTempLink ttTimelineTempLink = new TtTimelineTempLink();
            ttTimelineTempLink.setId(Integer.valueOf(ids[i]));
            ttTimelineTempLink.setOrderby(orderbies[i]);
            tlTempDao.saveOrderby(ttTimelineTempLink);
        }
        return r;
    }

    @Transactional
    @Override
    public int remove(int id) {
        tlTempDao.removeFile(id);
        return tlTempDao.remove(id);
    }

    @Transactional
    @Override
    public int batchRemove(int[] ids) {
        tlTempDao.batchRemoveFile(ids);
        return tlTempDao.batchRemove(ids);
    }

}
