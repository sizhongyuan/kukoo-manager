package com.bootdo.consult.controller;

import com.bootdo.common.controller.BaseController;
import com.bootdo.common.utils.R;
import com.bootdo.consult.model.Consult;
import com.bootdo.consult.service.ConsultService;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by gang on 2018/5/19.
 */
@RequestMapping("/consult")
@Controller
public class ConsultController extends BaseController{
    private String prefix = "consult";
    @Autowired
    private ConsultService consultService;

    @GetMapping()
    @RequiresPermissions("consult:sysConsult:sysConsult")
    String consult() {
        return prefix + "/consult";
    }

    @ApiOperation(value="获取咨询列表", notes="")
    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("consult:sysConsult:sysConsult")
    public List<Consult> list() {
        Map<String, Object> query = new HashMap<>(16);
        List<Consult> consultList = consultService.list(query);
        return consultList;
    }

    @GetMapping("/add/{id}")
    @RequiresPermissions("consult:sysConsult:add")
    String add(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("id", id);
        return  prefix + "/add";
    }

    @GetMapping("/edit/{id}")
    @RequiresPermissions("consult:sysConsult:edit")
    String edit(@PathVariable("id") Integer id, Model model) {
        Consult consult = consultService.get(id);
        model.addAttribute("consult", consult);
        return  prefix + "/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("consult:sysConsult:add")
    public R save(Consult consult) {
        consult.setAdviser(super.getUsername());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = sdf.format(new Date());
        consult.setCreateTime(dateStr);
        String userId = "userID";//根据用户名查询用户表得到
        consult.setUserId(userId);
        if (consultService.save(consult) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("consult:sysConsult:edit")
    public R update(Consult consult) {
        if (consultService.update(consult) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("consult:sysConsult:remove")
    public R remove(Integer id) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", id);
        if (consultService.remove(id) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("consult:sysConsult:batchRemove")
    public R remove(@RequestParam("ids[]") Integer[] ids) {
        consultService.batchRemove(ids);
        return R.ok();
    }
}
