package com.bootdo.projectmgr.dao;

import com.bootdo.projectmgr.domain.SubProjectDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 二级项目管理DAO层
 * @author szy
 * @date 2018-05-10 22:31:49
 */
@Mapper
@Repository
public interface SubProjectDao {
    /**
     * 根据id获取对应一级项目对象
     * @param id
     * @return ProjectDO
     * */
    SubProjectDO get(@Param("id") String id)throws Exception ;
    /**
     * 根据条件获取一级项目对象列表
     * @param map
     * @return List<ProjectDO>
     * */
    List<SubProjectDO> list(Map<String, Object> map) throws Exception ;
    /**
     * 根据条件获取一级项目对象列表数量
     * @param map
     * @return int
     * */
    int count(Map<String, Object> map) throws Exception ;
    /**
     * 保存一级项目对象
     * @param subProjectDO
     * @return int
     * */
    int save(SubProjectDO subProjectDO) throws Exception ;
    /**
     * 更新一级项目对象
     * @param subProjectDO
     * @return int
     * */
    int update(SubProjectDO subProjectDO) throws Exception ;
    /**
     * 根据id删除一级项目对象
     * @param id
     * @return int
     * */
    int remove(@Param("id") String id) throws Exception ;
    /**
     * 根据id批量删除一级项目对象
     * @param ids
     * @return int
     * */
    int batchRemove(String[] ids) throws Exception ;
    /**
     * 根据id批量查询一级项目对象
     * @param ids
     * @return List<ProjectDO>
     * */
    List<SubProjectDO> listByIds(String[] ids) throws Exception ;

    /**
     * 获取project序列
     * @return int
     * */
    int getSequence() throws Exception ;
    /**
     * 根据一级项目id 删除对应的二级项目
     * @return int
     * */
    int removeByProjectId(String projectId) throws Exception;

}
