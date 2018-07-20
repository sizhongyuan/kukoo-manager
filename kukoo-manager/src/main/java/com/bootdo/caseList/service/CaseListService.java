package com.bootdo.caseList.service;

import com.bootdo.caseList.domain.TtCase;
import com.bootdo.timeline.domain.TtTimelineTempFile;
import com.bootdo.timeline.domain.TtTimelineTempLink;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * 通知通告
 *
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2017-10-05 17:11:16
 */
public interface CaseListService {

    /**
     * 根据id查询时间轴信息
     */
    TtCase get(Long id);

    /**
     * 根据projectId查询排序列表
     */
//    List<TtTimelineTempLink> getOrderby(String projectId);

    /**
     * 出时间轴列表
     */
    List<TtCase> list(Map<String, Object> map);

    /**
     * 时间轴列表总条数
     */
    int count(Map<String, Object> map);

    /**
     * 保存新增
     */
    int save(TtCase ttCase, HttpServletRequest request);

    /**
     * 保存修改
     */
    int update(TtCase ttCase, HttpServletRequest request);

    /**
     * 更新排序
     */
//    int updateOrderby(HttpServletRequest request);

    /**
     * 删除
     */
    int remove(int id);

    /**
     * 批量删除
     */
    int batchRemove(int[] ids);

}
