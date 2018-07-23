package com.bootdo.accessories.service;

import com.bootdo.accessories.domain.AccessoriesDO;

import java.util.List;
import java.util.Map;

/**
 * 文件管理service层
 *
 * @author szy
 * @date 2018-05-10 22:34:00
 */
public interface AccessoriesService {

    /**
     * 根据id获取文件对象
     * @param id
     * @return AccessoriesDO
     * */
    AccessoriesDO get(String id) throws Exception;
    /**
     * 根据fileName获取文件对象
     * @param fileName
     * @return AccessoriesDO
     * */
    AccessoriesDO getByFileName(String fileName) throws Exception;
    /**
     * 根据条件获取文件对象列表
     * @param map
     * @return List<AccessoriesDO>
     * */
    List<AccessoriesDO> list(Map<String, Object> map) throws Exception;
    /**
     * 根据条件获取文件对象列表数量
     * @param map
     * @return int
     * */
    int count(Map<String, Object> map) throws Exception;
    /**
     * 保存文件对象
     * @param accessoriesDO
     * @return int
     * */
    int save(AccessoriesDO accessoriesDO) throws Exception;
    /**
     * 更新文件对象
     * @param accessoriesDO
     * @return int
     * */
    int update(AccessoriesDO accessoriesDO) throws Exception;
    /**
     * 根据id删除一级项目对象
     * @param id
     * @return int
     * */
    int remove(String id) throws Exception;
    /**
     * 根据id批量删除文件对象
     * @param ids
     * @return int
     * */
    int batchRemove(String[] ids) throws Exception;
    /**
     * 根据id批量查询文件对象
     * @param ids
     * @return List<ProjectDO>
     * */
    List<AccessoriesDO> listByIds(String[] ids) throws Exception;
}
