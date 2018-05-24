package com.bootdo.projectmgr.dao;

import com.bootdo.projectmgr.domain.ProjectDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 一级项目管理DAO层
 * @author szy
 * @date 2018-05-10 22:31:49
 */
@Mapper
public interface ProjectDao {

    /**
     * 根据id获取对应一级项目对象
     * @param id
     * @return ProjectDO
     * */
    ProjectDO get(@Param("id") int id);
    /**
     * 根据条件获取一级项目对象列表
     * @param map
     * @return List<ProjectDO>
     * */
    List<ProjectDO> list(Map<String, Object> map);
    /**
     * 根据条件获取一级项目对象列表数量
     * @param map
     * @return int
     * */
    int count(Map<String, Object> map);
    /**
     * 保存一级项目对象
     * @param projectDO
     * @return int
     * */
    int save(ProjectDO projectDO);
    /**
     * 更新一级项目对象
     * @param projectDO
     * @return int
     * */
    int update(ProjectDO projectDO);
    /**
     * 根据id删除一级项目对象
     * @param id
     * @return int
     * */
    int remove(@Param("id") int id);
    /**
     * 根据id批量删除一级项目对象
     * @param ids
     * @return int
     * */
    int batchRemove(String[] ids);
    /**
     * 根据id批量查询一级项目对象
     * @param ids
     * @return List<ProjectDO>
     * */
    List<ProjectDO> listByIds(String[] ids);

}
