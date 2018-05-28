package com.bootdo.consult.controller;

import com.bootdo.common.annotation.Log;
import com.bootdo.common.config.Constant;
import com.bootdo.common.controller.BaseController;
import com.bootdo.common.utils.MD5Utils;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;
import com.bootdo.consult.model.Consult;
import com.bootdo.consult.service.ConsultService;
import com.bootdo.oa.domain.NotifyDO;
import com.bootdo.system.domain.UserDO;
import com.bootdo.system.service.UserService;
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
    @Autowired
    UserService userService;

    @GetMapping()
    @RequiresPermissions("consult:list")
    String consult() {
        return prefix + "/consult";
    }

//    @ApiOperation(value="获取咨询列表", notes="")
//    @ResponseBody
//    @GetMapping("/list")
//    @RequiresPermissions("consult:list")
//    public List<Consult> list() {
//        Map<String, Object> query = new HashMap<>(16);
//        List<Consult> consultList = consultService.list(query);
//        return consultList;
//    }

    @ApiOperation(value="获取咨询列表", notes="")
    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("consult:list")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        // 查询列表数据
        Query query = new Query(params);
        query.put("parentId","0");
        List<Consult> consultList = consultService.list(query);
        int total = consultService.count(query);
        PageUtils pageUtils = new PageUtils(consultList, total);
        return pageUtils;
    }

    @ResponseBody
    @GetMapping("/sublist/{parentId}")
    @RequiresPermissions("consult:list")
    public List<Consult> sublist(@PathVariable("parentId") Integer parentId) {
        Map<String, Object> query = new HashMap<>(16);
        System.out.println("parentId=="+parentId);
        query.put("parentId",parentId);
        List<Consult> consultList = consultService.list(query);
        return consultList;
    }

    @GetMapping("/add/{id}")
    @RequiresPermissions("consult:add")
    String add(@PathVariable("id") Integer id, Model model) {
        Consult consult = consultService.get(id);
        model.addAttribute("consult", consult);
        return  prefix + "/add";
    }

    @GetMapping("/addConsultUser")
    @RequiresPermissions("consult:add")
    String addConsultUser(Model model) {
        Consult consult = new Consult();
        consult.setParentId(0);//parentId
        consult.setAdviser(super.getUsername());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = sdf.format(new Date());
        consult.setCreateTime(dateStr);
        model.addAttribute("consult", consult);
        return  prefix + "/addConsultUser";
    }

    @RequiresPermissions("sys:user:add")
    @Log("快速注册账号")
    @PostMapping("/registerUser")
    @ResponseBody
    R registerUser(UserDO user) {
        user.setPassword(MD5Utils.encrypt(user.getUsername(), user.getPassword()));
        if (userService.save(user) > 0) {

            Consult consult = new Consult();
            consult.setAdviser(super.getUsername());
            consult.setUserId(String.valueOf(user.getUserId()));
            consult.setUserName(user.getUsername());
            consult.setParentId(0);

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateStr = sdf.format(new Date());
            consult.setCreateTime(dateStr);
            consultService.save(consult);
            return R.ok();
        }
        return R.error();
    }

    @GetMapping("/edit/{id}")
    @RequiresPermissions("consult:edit")
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
    @RequiresPermissions("consult:add")
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
    @RequiresPermissions("consult:edit")
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
    @RequiresPermissions("consult:remove")
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
    @RequiresPermissions("consult:batchRemove")
    public R remove(@RequestParam("ids[]") Integer[] ids) {
        consultService.batchRemove(ids);
        return R.ok();
    }
}
