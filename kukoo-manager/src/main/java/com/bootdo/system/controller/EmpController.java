package com.bootdo.system.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootdo.common.controller.BaseController;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;
import com.bootdo.system.domain.ClientDO;
import com.bootdo.system.domain.RoleDO;
import com.bootdo.system.domain.UserDO;
import com.bootdo.system.service.EmpService;
import com.bootdo.system.service.RoleService;
import com.bootdo.system.service.UserService;

@RequestMapping("/sys/emp")
@Controller
public class EmpController extends BaseController{
	private String prefix="system/emp"  ;
	
	@Autowired
	EmpService empService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	RoleService roleService;
	
	@RequiresPermissions("sys:emp:emp")
	@GetMapping("")
	String user(Model model) {
		String roleIdStr = "";
		String userId = getUserId();
		List<RoleDO> list = roleService.userRefRole(userId);
		if(list != null && list.size() > 0) {
			for(int i=0;i<list.size();i++) {
				if("".equals(roleIdStr)) {
					roleIdStr = list.get(i).getRoleId() + "";
				}else {
					roleIdStr = list.get(i).getRoleId() + "" + "," + roleIdStr;
				}
			}
		}
		model.addAttribute("roleIdStr", roleIdStr);
		model.addAttribute("userId", userId);
		return prefix + "/emp";
	}
	
	/**
	 * 展示顾问列表
	 * @param params
	 * @return
	 */
	@GetMapping("/list")
	@ResponseBody
	PageUtils list(@RequestParam Map<String, Object> params) {
		String roleIdStr = "";
		String userId = getUserId();
		List<RoleDO> list = roleService.userRefRole(userId);
		if(list != null && list.size() > 0) {
			for(int i=0;i<list.size();i++) {
				if("".equals(roleIdStr)) {
					roleIdStr = list.get(i).getRoleId() + "";
				}else {
					roleIdStr = list.get(i).getRoleId() + "" + "," + roleIdStr;
				}
			}
		}
		
		PageUtils pageUtil = null;
		//超级用户查询所有顾问
		if(roleIdStr.contains("1")) {
			// 查询列表数据
			Query query = new Query(params);
			List<UserDO> sysUserList = empService.list(query);
			int total = empService.count(params);
			pageUtil = new PageUtils(sysUserList, total);
			return pageUtil;
		}else if(roleIdStr.contains("60")) {//顾问角色查询顾问关联的客户
			// 查询列表数据
			params.put("userId", userId);
			Query query = new Query(params);
			List<ClientDO> clientList = empService.clientList(query);
			int total = empService.clientCount(query);
			pageUtil = new PageUtils(clientList, total);
			return pageUtil;
		}
		return pageUtil;
	}
	
	/**
	 * 展示顾问关联客户
	 * @param params
	 * @return
	 */
	@GetMapping("/client/list")
	@ResponseBody
	PageUtils clientList(@RequestParam Map<String, Object> params) {
		// 查询列表数据
		Query query = new Query(params);
		List<ClientDO> clientList = empService.clientList(query);
		int total = empService.clientCount(query);
		PageUtils pageUtil = new PageUtils(clientList, total);
		return pageUtil;
	}
	
	/**
	 * 解除关联
	 * @param params
	 * @return
	 */
	@PostMapping("/remove")
	@ResponseBody
	R removeRef(Long id) {
		empService.removeRef(id);
		return R.ok();
	}
	
	
	
}
