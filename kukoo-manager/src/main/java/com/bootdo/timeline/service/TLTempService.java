package com.bootdo.timeline.service;

import com.bootdo.common.utils.PageUtils;
import com.bootdo.oa.domain.NotifyDO;
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
public interface TLTempService {

//    NotifyDO get(Long id);

    List<TtTimelineTempLink> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(TtTimelineTempLink ttTimelineTempLink,HttpServletRequest request);

//    int update(NotifyDO notify);

    int remove(int id);

    int batchRemove(int[] ids);

////	Map<String, Object> message(Long userId);
//
//    PageUtils selfList(Map<String, Object> map);
}
