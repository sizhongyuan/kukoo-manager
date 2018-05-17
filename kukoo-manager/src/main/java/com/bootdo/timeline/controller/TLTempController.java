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
@RequestMapping("/TL/temp")
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
//
//    @GetMapping("/edit/{id}")
//    @RequiresPermissions("oa:notify:edit")
//    String edit(@PathVariable("id") Long id, Model model) {
//        NotifyDO notify = notifyService.get(id);
//        List<DictDO> dictDOS = dictService.listByType("oa_notify_type");
//        String type = notify.getType();
//        for (DictDO dictDO:dictDOS){
//            if(type.equals(dictDO.getValue())){
//                dictDO.setRemarks("checked");
//            }
//        }
//        model.addAttribute("oaNotifyTypes",dictDOS);
//        model.addAttribute("notify", notify);
//        return "oa/notify/edit";
//    }

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

//    /**
//     * 修改
//     */
//    @ResponseBody
//    @RequestMapping("/update")
//    @RequiresPermissions("oa:notify:edit")
//    public R update(NotifyDO notify) {
//        if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
//            return R.error(1, "演示系统不允许修改,完整体验请部署程序");
//        }
//        notifyService.update(notify);
//        return R.ok();
//    }
//
//    /**
//     * 删除
//     */
//    @PostMapping("/remove")
//    @ResponseBody
//    @RequiresPermissions("oa:notify:remove")
//    public R remove(Long id) {
//        if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
//            return R.error(1, "演示系统不允许修改,完整体验请部署程序");
//        }
//        if (notifyService.remove(id) > 0) {
//            return R.ok();
//        }
//        return R.error();
//    }
//
//    /**
//     * 删除
//     */
//    @PostMapping("/batchRemove")
//    @ResponseBody
//    @RequiresPermissions("oa:notify:batchRemove")
//    public R remove(@RequestParam("ids[]") Long[] ids) {
//        if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
//            return R.error(1, "演示系统不允许修改,完整体验请部署程序");
//        }
//        notifyService.batchRemove(ids);
//        return R.ok();
//    }
//
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