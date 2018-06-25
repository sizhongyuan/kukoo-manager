package com.bootdo.timeline.dao;

import com.bootdo.oa.domain.NotifyDO;
import com.bootdo.oa.domain.NotifyDTO;
import com.bootdo.timeline.domain.TtTimelineTempFile;
import com.bootdo.timeline.domain.TtTimelineTempLink;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

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
@Repository
public interface TLTempDao {

	TtTimelineTempLink get(Long id);

	List<TtTimelineTempLink> getOrderby();

	List<TtTimelineTempFile> queryFile(long id);

	List<TtTimelineTempLink> list(Map<String, Object> map);

	int count(Map<String, Object> map);

	int save(TtTimelineTempLink ttTimelineTempLink);

	Integer maxOrderby();

	int saveFile(List<TtTimelineTempFile> ttTimelineTempFileList);

	int saveOrderby(TtTimelineTempLink ttTimelineTempLink);

	int update(TtTimelineTempLink ttTimelineTempLink);

	int deleteFile(int id);

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
