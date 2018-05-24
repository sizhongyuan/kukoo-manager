package com.bootdo.consult.service;

import com.bootdo.consult.model.Consult;

import java.util.List;
import java.util.Map;

/**
 * 咨询记录
 * Created by gang on 2018/5/20.
 */
public interface ConsultService {

	Consult get(Integer id);

	List<Consult> list(Map<String, Object> map);

	int count(Map<String, Object> map);

	int save(Consult consult);

	int update(Consult consult);

	int remove(Integer id);

	int batchRemove(Integer[] ids);
}
