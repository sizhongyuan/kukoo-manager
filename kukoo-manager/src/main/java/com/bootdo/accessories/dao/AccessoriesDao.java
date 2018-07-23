package com.bootdo.accessories.dao;

import com.bootdo.accessories.domain.AccessoriesDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 文件管理DAO层
 * @author szy
 * @date 2018-05-10 22:31:49
 */
@Mapper
@Repository
public interface AccessoriesDao {
    /**
     * 根据id获取文件对象
     * @param id
     * @return AccessoriesDO
     * */
    AccessoriesDO get(@Param("id") String id) throws Exception;
    /**
     * 根据fileName获取文件对象
     * @param fileName
     * @return AccessoriesDO
     * */
    AccessoriesDO getByFileName(@Param("fileName") String fileName) throws Exception;
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
    int remove(@Param("id") String id) throws Exception;
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
