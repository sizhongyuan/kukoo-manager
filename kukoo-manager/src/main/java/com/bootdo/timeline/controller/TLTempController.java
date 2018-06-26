package com.bootdo.timeline.controller;

import com.bootdo.common.config.Constant;
import com.bootdo.common.controller.BaseController;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;
import com.bootdo.timeline.domain.TtTimelineTempFile;
import com.bootdo.timeline.domain.TtTimelineTempLink;
import com.bootdo.timeline.service.TLTempService;
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
@RequestMapping("/timeline/temp")
public class TLTempController extends BaseController {
    @Autowired
    private TLTempService tlTempService;

    /**
     * 进入时间轴模板环节列表主页面
     */
    @GetMapping("/{id}")
    @RequiresPermissions("timeline:temp:link")
    String tlTempLinkList(@PathVariable("id") String projectId,Model model) {
        model.addAttribute("projectId", projectId);
        return "timeline/temp/link";
    }

    /**
     * 加载环节列表中的表单
     */
    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("timeline:temp:link")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        // 查询列表数据
        Query query = new Query(params);
        List<TtTimelineTempLink> ttTimelineTempLinkList = tlTempService.list(query);
        int total = tlTempService.count(query);
        PageUtils pageUtils = new PageUtils(ttTimelineTempLinkList, total);
        return pageUtils;
    }

    /**
     * 打开新增页面
     */
    @GetMapping("/add/{id}")
    @RequiresPermissions("timeline:temp:add")
    String add(Model model,@PathVariable("id") String projectId) {
        model.addAttribute("projectId", projectId);
        return "timeline/temp/add";
    }

    /**
     * 保存新增
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("timeline:temp:add")
    public R save(TtTimelineTempLink ttTimelineTempLink,HttpServletRequest request) {
        if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
            return R.error(1, "演示系统不允许修改,完整体验请部署程序");
        }
        if (tlTempService.save(ttTimelineTempLink,request) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 打开排序页面
     */
    @GetMapping("/orderby/{id}")
    @RequiresPermissions("timeline:temp:orderby")
    String orderby(Model model,@PathVariable("id") String projectId) {
        List<TtTimelineTempLink> tempOrderbyList = tlTempService.getOrderby(projectId);
        model.addAttribute("tempOrderbyList", tempOrderbyList);
        return "timeline/temp/orderby";
    }

    /**
     * 保存更改排序
     */
    @ResponseBody
    @RequestMapping("/updateOrderby")
    @RequiresPermissions("timeline:temp:orderby")
    public R updateOrderby(TtTimelineTempLink ttTimelineTempLink,HttpServletRequest request) {
        if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
            return R.error(1, "演示系统不允许修改,完整体验请部署程序");
        }
        if (tlTempService.updateOrderby(request) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 打开编辑页面
     */
    @GetMapping("/edit/{id}")
    @RequiresPermissions("timeline:temp:edit")
    String edit(@PathVariable("id") Long id, Model model) {
        TtTimelineTempLink ttTimelineTempLink = tlTempService.get(id);
        List<TtTimelineTempFile> tempFileList = tlTempService.queryFile(id);
        model.addAttribute("ttTimelineTempLink", ttTimelineTempLink);
        model.addAttribute("tempFileList", tempFileList);
        return "timeline/temp/edit";
    }

    /**
     * 保存修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("timeline:temp:edit")
    public R update(TtTimelineTempLink ttTimelineTempLink,HttpServletRequest request) {
        if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
            return R.error(1, "演示系统不允许修改,完整体验请部署程序");
        }
        if (tlTempService.update(ttTimelineTempLink,request) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("timeline:temp:remove")
    public R remove(int id) {
        if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
            return R.error(1, "演示系统不允许修改,完整体验请部署程序");
        }
        if (tlTempService.remove(id) > 0) {
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
        tlTempService.batchRemove(ids);
        return R.ok();
    }
}