$().ready(function() {
	loadAccountType();
	loadGender();
	loadStatus();
	loadRole();
	loadLicensCase();
	loadTime();
	validateRule();
});

$.validator.setDefaults({
	submitHandler : function() {
		save();
	}
});
function getCheckedRoles() {
	var adIds = "";
	$("input:checkbox[name=role]:checked").each(function(i) {
		if (0 == i) {
			adIds = $(this).val();
		} else {
			adIds += ("," + $(this).val());
		}
	});
	return adIds;
}
function save() {
	$("#roleIds").val($("#roleIds").val().join(','));
	$.ajax({
		cache : true,
		type : "POST",
		url : "/sys/user/save",
		data : $('#signupForm').serialize(),// 你的formid
		async : false,
		error : function(request) {
			parent.layer.alert("Connection error");
		},
		success : function(data) {
			if (data.code == 0) {
				parent.layer.msg("操作成功");
				parent.reLoad();
				var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
				parent.layer.close(index);

			} else {
				parent.layer.alert(data.msg)
			}

		}
	});

}
function validateRule() {
	var icon = "<i class='fa fa-times-circle'></i> ";
	$("#signupForm").validate({
		rules : {
			name : {
				required : true
			},
			username : {
				required : true,
				minlength : 2,
				remote : {
					url : "/sys/user/exit", // 后台处理程序
					type : "post", // 数据发送方式
					dataType : "json", // 接受数据格式
					data : { // 要传递的数据
						username : function() {
							return $("#username").val();
						}
					}
				}
			},
			password : {
				required : true,
				minlength : 6
			},
			confirm_password : {
				required : true,
				minlength : 6,
				equalTo : "#password"
			},
			email : {
				required : true,
				email : true
			},
			topic : {
				required : "#newsletter:checked",
				minlength : 2
			},
			agree : "required"
		},
		messages : {

			name : {
				required : icon + "请输入姓名"
			},
			username : {
				required : icon + "请输入您的用户名",
				minlength : icon + "用户名必须两个字符以上",
				remote : icon + "用户名已经存在"
			},
			password : {
				required : icon + "请输入您的密码",
				minlength : icon + "密码必须6个字符以上"
			},
			confirm_password : {
				required : icon + "请再次输入密码",
				minlength : icon + "密码必须6个字符以上",
				equalTo : icon + "两次输入的密码不一致"
			},
			email : icon + "请输入您的E-mail",
		}
	})
}

var openDept = function(){
	layer.open({
		type:2,
		title:"选择部门",
		area : [ '300px', '450px' ],
		content:"/system/sysDept/treeView"
	})
}
function loadDept( deptId,deptName){
	$("#deptId").val(deptId);
	$("#deptName").val(deptName);
}

//账号类型
function loadAccountType(){
	var html = "";
	$.ajax({
		url : '/common/dict/list/sys_user_accountType',
		success : function(data) {
			//加载数据
			for (var i = 0; i < data.length; i++) {
				if(data[i].value == '1'){
					html += '<option selected value="' + data[i].value + '">' + data[i].name + '</option>'
				}else{
					html += '<option value="' + data[i].value + '">' + data[i].name + '</option>'
				}
				
			}
			$("#accountType").append(html);
			$("#accountType").chosen({
				maxHeight : 200,
				width : "100%"
			});
			//点击事件
			$('#accountType').on('change', function(e, params) {
				var opt = {
					query : {
						type : params.selected,
					}
				}
				$('#exampleTable').bootstrapTable('refresh', opt);
			});
		}
	});
}
//性别
function loadGender(){
	var html = "";
	$.ajax({
		url : '/common/dict/list/sys_user_gender',
		success : function(data) {
			//加载数据
			for (var i = 0; i < data.length; i++) {
				html += '<option value="' + data[i].value + '">' + data[i].name + '</option>'
			}
			$("#gender").append(html);
			$("#gender").chosen({
				maxHeight : 200,
				width : "100%"
			});
			//点击事件
			$('#gender').on('change', function(e, params) {
				console.log(params.selected);
				var opt = {
					query : {
						type : params.selected,
					}
				}
				$('#exampleTable').bootstrapTable('refresh', opt);
			});
		}
	});
}


//角色
function loadRole(){
	var html = "";
	$.ajax({
		url : '/sys/role/list',
		success : function(data) {
			console.log(data);
			//加载数据
			for (var i = 0; i < data.length; i++) {
				html += '<option value="' + data[i].roleId + '">' + data[i].roleName + '</option>'
			}
			$("#roleIds").append(html);
			$("#roleIds").chosen({
				maxHeight : 200,
				width : "100%"
			});
			//点击事件
			$('#roleIds').on('change', function(e, params) {
				console.log($('#roleIds').val());
				var opt = {
					query : {
						type : params.selected,
					}
				}
				$('#exampleTable').bootstrapTable('refresh', opt);
			});
		}
	});
}
////角色
//function loadRole(){
//	var html = "";
//	$.ajax({
//		url : '/common/dict/list/sys_user_role',
//		success : function(data) {
//			//加载数据
//			for (var i = 0; i < data.length; i++) {
//				if(data[i].value == '1'){
//					html += '<option value="' + data[i].value + '">' + data[i].name + '</option>'
//				}else{
//					html += '<option value="' + data[i].value + '">' + data[i].name + '</option>'
//				}
//				
//			}
//			$("#role").append(html);
//			$("#role").chosen({
//				maxHeight : 200,
//				width : "100%"
//			});
//			//点击事件
//			$('#role').on('change', function(e, params) {
//				console.log(params.selected);
//				var opt = {
//					query : {
//						type : params.selected,
//					}
//				}
//				$('#exampleTable').bootstrapTable('refresh', opt);
//			});
//		}
//	});
//}
//状态
function loadStatus(){
	var html = "";
	$.ajax({
		url : '/common/dict/list/sys_user_status',
		success : function(data) {
			//加载数据
			for (var i = 0; i < data.length; i++) {
				if(data[i].value == '1'){
					html += '<option value="' + data[i].value + '">' + data[i].name + '</option>'
				}else{
					html += '<option value="' + data[i].value + '">' + data[i].name + '</option>'
				}
				
			}
			$("#status").append(html);
			$("#status").chosen({
				maxHeight : 200,
				width : "100%"
			});
			//点击事件
			$('#status').on('change', function(e, params) {
				console.log(params.selected);
				var opt = {
					query : {
						type : params.selected,
					}
				}
				$('#exampleTable').bootstrapTable('refresh', opt);
			});
		}
	});
}
//持牌情况 
function loadLicensCase(){
	var html = "";
	$.ajax({
		url : '/common/dict/list/sys_user_licensCase',
		success : function(data) {
			//加载数据
			for (var i = 0; i < data.length; i++) {
				if(data[i].value == '1'){
					html += '<option value="' + data[i].value + '">' + data[i].name + '</option>'
				}else{
					html += '<option value="' + data[i].value + '">' + data[i].name + '</option>'
				}
				
			}
			$("#licensCase").append(html);
			$("#licensCase").chosen({
				maxHeight : 200,
				width : "100%"
			});
			//点击事件
			$('#licensCase').on('change', function(e, params) {
				console.log(params.selected);
				var opt = {
					query : {
						type : params.selected,
					}
				}
				$('#exampleTable').bootstrapTable('refresh', opt);
			});
		}
	});
}

function loadTime(){
	$("#joinTime").datetimepicker({
		   showSecond: true,
		   //showMillisec: true,
		   dateFormat: "yy-mm-dd",
		   timeFormat: 'hh:mm:ss'
	});
	$("#leaveTime").datetimepicker({
		   showSecond: true,
		   //showMillisec: true,
		   dateFormat: "yy-mm-dd",
		   timeFormat: 'hh:mm:ss'
	});
	$("#birthday").datepicker({
		dateFormat: "yy-mm-dd"
	});
	$("#laborLimit").datepicker({
		dateFormat: "yy-mm-dd"
	});
}
