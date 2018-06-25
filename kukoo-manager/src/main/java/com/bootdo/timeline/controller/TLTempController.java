package com.bootdo.timeline.controller;

import com.bootdo.common.config.Constant;
import com.bootdo.common.controller.BaseController;
import com.bootdo.common.domain.DictDO;
import com.bootdo.common.service.DictService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;
import com.bootdo.oa.domain.NotifyDO;
import com.bootdo.oa.domain.NotifyRecordDO;
import com.bootdo.oa.service.NotifyRecordService;
import com.bootdo.oa.service.NotifyService;
import com.bootdo.timeline.domain.TtTimelineTempFile;
import com.bootdo.timeline.domain.TtTimelineTempLink;
import com.bootdo.timeline.service.TLTempService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
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
//    @Autowired
//    private NotifyRecordService notifyRecordService;
//    @Autowired
//    private DictService dictService;

    @GetMapping()
    @RequiresPermissions("timeline:temp:link")
    String tlTempLinkList() {
        return "timeline/temp/link";
    }

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

    @GetMapping("/add")
    @RequiresPermissions("timeline:temp:add")
    String add() {
        return "timeline/temp/add";
    }

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
     * 排序
     */
    @GetMapping("/orderby")
    @RequiresPermissions("timeline:temp:orderby")
    String orderby(Model model) {
        List<TtTimelineTempLink> tempOrderbyList = tlTempService.getOrderby();
        model.addAttribute("tempOrderbyList", tempOrderbyList);
        return "timeline/temp/orderby";
    }

    /**
     * 保存
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
     * 更改排序
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

//    @ResponseBody
//    @GetMapping("/message")
//    PageUtils message() {
//        Map<String, Object> params = new HashMap<>(16);
//        params.put("offset", 0);
//        params.put("limit", 3);
//        Query query = new Query(params);
//        query.put("userId", getUserId());
//        query.put("isRead",Constant.OA_NOTIFY_READ_NO);
//        return notifyService.selfList(query);
//    }
//
//    @GetMapping("/selfNotify")
//    String selefNotify() {
//        return "oa/notify/selfNotify";
//    }
//
//    @ResponseBody
//    @GetMapping("/selfList")
//    PageUtils selfList(@RequestParam Map<String, Object> params) {
//        Query query = new Query(params);
//        query.put("userId", getUserId());
//
//        return notifyService.selfList(query);
//    }
//
//    @GetMapping("/read/{id}")
//    @RequiresPermissions("oa:notify:edit")
//    String read(@PathVariable("id") Long id, Model model) {
//        NotifyDO notify = notifyService.get(id);
//        //更改阅读状态
//        NotifyRecordDO notifyRecordDO = new NotifyRecordDO();
//        notifyRecordDO.setNotifyId(id);
//        notifyRecordDO.setUserId(getUserId());
//        notifyRecordDO.setReadDate(new Date());
//        notifyRecordDO.setIsRead(Constant.OA_NOTIFY_READ_YES);
//        notifyRecordService.changeRead(notifyRecordDO);
//        model.addAttribute("notify", notify);
//        return "oa/notify/read";
//    }



}