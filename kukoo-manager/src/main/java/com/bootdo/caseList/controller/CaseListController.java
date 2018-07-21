package com.bootdo.caseList.controller;

import com.bootdo.caseList.domain.TtCase;
import com.bootdo.caseList.service.CaseListService;
import com.bootdo.common.config.Constant;
import com.bootdo.common.controller.BaseController;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;
import com.bootdo.timeline.domain.TtTimelineTempFile;
import com.bootdo.timeline.domain.TtTimelineTempLink;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * 时间轴模板环节列表
 *
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2017-10-05 17:11:16
 */

@Controller
@RequestMapping("/caselist")
public class CaseListController extends BaseController {
    @Autowired
    private CaseListService caseListService;

    /**
     * 进入时间轴模板环节列表主页面
     */
    @GetMapping("")
    @RequiresPermissions("caselist:list")
//    String tlTempLinkList(@PathVariable("id") String projectId,Model model) {
    String caseList() {
//        model.addAttribute("projectId", projectId);
        return "caselist/list";
    }

    /**
     * 加载环节列表中的表单
     */
    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("caselist:list")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        // 查询列表数据
        Query query = new Query(params);
        List<TtCase> ttCaseList = caseListService.list(query);
        int total = caseListService.count(query);
        PageUtils pageUtils = new PageUtils(ttCaseList, total);
        return pageUtils;
    }

    /**
     * 打开新增页面
     */
    @GetMapping("/add")
//    @GetMapping("/add/{id}")
    @RequiresPermissions("caselist:add")
//    String add(Model model,@PathVariable("id") String projectId) {
    String add() {
//        model.addAttribute("projectId", projectId);
        return "caselist/add";
    }

    /**
     * 保存新增
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("caselist:add")
    public R save(TtCase ttCase, HttpServletRequest request) {
        if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
            return R.error(1, "演示系统不允许修改,完整体验请部署程序");
        }
        if (caseListService.save(ttCase,request) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 打开编辑页面
     */
    @GetMapping("/edit/{id}")
    @RequiresPermissions("caselist:edit")
    String edit(@PathVariable("id") Long id, Model model) {
        TtCase ttCase = caseListService.get(id);
        model.addAttribute("ttCase", ttCase);
        return "caselist/edit";
    }

    /**
     * 保存修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("caselist:edit")
    public R update(TtCase ttCase,HttpServletRequest request) {
        if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
            return R.error(1, "演示系统不允许修改,完整体验请部署程序");
        }
        if (caseListService.update(ttCase,request) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("caselist:remove")
    public R remove(int id) {
        if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
            return R.error(1, "演示系统不允许修改,完整体验请部署程序");
        }
        if (caseListService.remove(id) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 批量删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("timeline:temp:batchRemove")
    public R remove(@RequestParam("ids[]") int[] ids) {
        if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
            return R.error(1, "演示系统不允许修改,完整体验请部署程序");
        }
        caseListService.batchRemove(ids);
        return R.ok();
    }
}