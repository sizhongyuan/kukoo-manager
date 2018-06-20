package com.bootdo.projectmgr.controller;

import com.bootdo.common.config.Constant;
import com.bootdo.common.controller.BaseController;
import com.bootdo.common.domain.DictDO;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;
import com.bootdo.oa.domain.NotifyDO;
import com.bootdo.projectmgr.domain.ProjectDO;
import com.bootdo.projectmgr.service.ProjectService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 一级项目列表
 *
 * @author szy
 * @date 2018-05-13 21:08:35
 */

@Controller
@RequestMapping("/projectmgr/project")
public class ProjectController extends BaseController {

    @Autowired
    private ProjectService projectService;

    @GetMapping()
    @RequiresPermissions("projectmgr:project:project")
    String projectmgrProject() {
        return "projectmgr/project/project";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("projectmgr:project:project")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        // 查询列表数据
        Query query = new Query(params);
        List<ProjectDO> list = projectService.list(query);
        int total = projectService.count(query);
        PageUtils pageUtils = new PageUtils(list, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("projectmgr:project:add")
    String add() {
        return "projectmgr/project/add";
    }


    /**
     * 进入编辑页面
     *
     * */
    @GetMapping("/edit/{id}")
    @RequiresPermissions("projectmgr:project:edit")
    String edit(@PathVariable("id") String id, Model model) {
        ProjectDO projectDO = projectService.get(id);
        model.addAttribute("projectDO", projectDO);
        return "projectmgr/project/edit";
    }


    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("projectmgr:project:add")
    public R save(ProjectDO projectDO) {


        Integer sequence = projectService.getSequence();
        String sequenceStr = sequence.toString();
        for(;sequenceStr.length() < 7 ;){
            sequenceStr = "0"+sequenceStr;
        }
        sequenceStr = "P"+sequenceStr;
        projectDO.setId(sequenceStr);
        projectDO.setCreateTime(new Date());
        projectDO.setDeleted("0");

        //不知道需不需要保存操作人
        if (projectService.save(projectDO) > 0) {
            return R.ok();
        }else{
            return R.error();
        }
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("projectmgr:project:edit")
    public R update(ProjectDO projectDO) {
        //不知道需不需要保存操作人
        if (projectService.update(projectDO) > 0) {
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
    @RequiresPermissions("projectmgr:project:remove")
    public R remove(String id) {

        if (projectService.remove(id) > 0) {
            return R.ok();
        }else{
            return R.error();
        }

    }


}
