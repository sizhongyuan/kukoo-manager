package com.bootdo.projectmgr.controller;

import com.bootdo.common.controller.BaseController;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;
import com.bootdo.projectmgr.domain.ProjectDO;
import com.bootdo.projectmgr.domain.SubProjectDO;
import com.bootdo.projectmgr.service.ProjectService;
import com.bootdo.projectmgr.service.SubProjectService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 二级项目列表
 *
 * @author szy
 * @date 2018-05-13 21:08:35
 */

@Controller
@RequestMapping("/projectmgr/subproject")
public class SubProjectController extends BaseController {

    @Autowired
    private SubProjectService subProjectService;

    @Autowired
    private ProjectService projectService;

    /**
     * 二级项目列表数据
     * 权限跟一级项目列表一样
     * */
    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("projectmgr:project:project")
    public PageUtils list(@RequestParam Map<String, Object> params) throws Exception {
        // 查询列表数据
        Query query = new Query(params);
        List<SubProjectDO> list = subProjectService.list(query);
        int total = subProjectService.count(query);
        PageUtils pageUtils = new PageUtils(list, total);
        return pageUtils;
    }

    @GetMapping("/add/{projectId}")
    @RequiresPermissions("projectmgr:subproject:add")
    String add(@PathVariable("projectId") String projectId, Model model) {
        //根据一级项目id,获取名称
        ProjectDO projectDO = projectService.get(projectId);
        model.addAttribute("projectDO", projectDO);

        return "projectmgr/subproject/add";
    }
    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("projectmgr:subproject:add")
    public R save(SubProjectDO subProjectDO) throws Exception {

        //获取一级项目id  根据id 查找所有的二级项目，然后比较id找出最大的+1
        String projectId = subProjectDO.getProjectId();
        String id = subProjectService.getSubProjectId(projectId);

        subProjectDO.setId(id);
        subProjectDO.setCreateTime(new Date());
        subProjectDO.setDeleted("0");

        //不知道需不需要保存操作人
        if (subProjectService.save(subProjectDO) > 0) {
            return R.ok();
        }else{
            return R.error();
        }
    }

    /**
     * 进入编辑页面
     *
     * */
    @GetMapping("/edit/{id}")
    @RequiresPermissions("projectmgr:subproject:edit")
    String edit(@PathVariable("id") String id, Model model) throws Exception {
        //获取二级项目信息
        SubProjectDO subProjectDO = subProjectService.get(id);
        //根据一级项目id,获取名称
        ProjectDO projectDO = projectService.get(subProjectDO.getProjectId());
        model.addAttribute("projectDO", projectDO);
        model.addAttribute("subProjectDO", subProjectDO);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String startTimeStr = formatter.format(subProjectDO.getStartTime());
        String endTimeStr = formatter.format(subProjectDO.getEndTime());
        model.addAttribute("startTimeStr", startTimeStr);
        model.addAttribute("endTimeStr", endTimeStr);
        return "projectmgr/subproject/edit";
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("projectmgr:subproject:edit")
    public R update(SubProjectDO subProjectDO) throws Exception{
        //不知道需不需要保存操作人
        if (subProjectService.update(subProjectDO) > 0) {
            return R.ok();
        }else{
            return R.error();
        }
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("projectmgr:subproject:remove")
    public R remove(String id) throws Exception{

        if (subProjectService.remove(id) > 0) {
            return R.ok();
        }else{
            return R.error();
        }
    }
}
