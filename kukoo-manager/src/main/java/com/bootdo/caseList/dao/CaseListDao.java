package com.bootdo.caseList.dao;

import com.bootdo.caseList.domain.TtCase;
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
public interface CaseListDao {

	TtCase get(Long id);

//	List<TtTimelineTempLink> getOrderby(String projectId);

	List<TtCase> list(Map<String, Object> map);

	int count(Map<String, Object> map);

	int save(TtCase ttCase);

//	Integer maxOrderby();
//
//	int saveFile(List<TtTimelineTempFile> ttTimelineTempFileList);
//
//	int saveOrderby(TtTimelineTempLink ttTimelineTempLink);

	int update(TtCase ttCase);

//	int deleteFile(int id);

	int remove(int id);

	int batchRemove(int[] ids);

}
