package com.bootdo.timeline.dao;

import com.bootdo.oa.domain.NotifyDO;
import com.bootdo.oa.domain.NotifyDTO;
import com.bootdo.timeline.domain.TtTimelineTempFile;
import com.bootdo.timeline.domain.TtTimelineTempLink;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 通知通告
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2017-10-05 17:11:16
 */
@Mapper
public interface TLTempDao {

//	NotifyDO get(Long id);

	List<TtTimelineTempLink> list(Map<String, Object> map);

	int count(Map<String, Object> map);

	int save(TtTimelineTempLink ttTimelineTempLink);

	int saveFile(List<TtTimelineTempFile> ttTimelineTempFileList);

//	int update(NotifyDO notify);

	int remove(int id);

	int batchRemove(int[] ids);

	int removeFile(int id);

	int batchRemoveFile(int[] ids);

//	List<NotifyDO> listByIds(Long[] ids);
//
//	int countDTO(Map<String, Object> map);
//
//	List<NotifyDTO> listDTO(Map<String, Object> map);
}
