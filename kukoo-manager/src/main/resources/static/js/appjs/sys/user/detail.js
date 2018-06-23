// 以下为官方示例
$().ready(function() {
	loadAccountType();
	loadGender();
	loadStatus();
	loadRole();
	loadLicensCase();
	validateRule();
	// $("#signupForm").validate();
});

$.validator.setDefaults({
	submitHandler : function() {
		update();
	}
});
function update() {
//	$("#roleIds").val(getCheckedRoles());
	$("#roleIds").val($("#roleIds").val().join(','));
	$.ajax({
		cache : true,
		type : "POST",
		url : "/sys/user/update",
		data : $('#signupForm').serialize(),// 你的formid
		async : false,
		error : function(request) {
			alert("Connection error");
		},
		success : function(data) {
			if (data.code == 0) {
				parent.layer.msg(data.msg);
				parent.reLoad();
				var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
				parent.layer.close(index);

			} else {
				parent.layer.msg(data.msg);
			}

		}
	});

}
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
function setCheckedRoles() {
	var roleIds = $("#roleIds").val();
	alert(roleIds);
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
function validateRule() {
	var icon = "<i class='fa fa-times-circle'></i> ";
	$("#signupForm").validate({
		rules : {
			name : {
				required : true
			},
			username : {
				required : true,
				minlength : 2
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
				minlength : icon + "用户名必须两个字符以上"
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
			$("#gender").val($("#Tgender").val()).trigger("chosen:updated");
			$("#gender").chosen({
				maxHeight : 200,
				width : "100%",
			});
//			$(".chosen-select").val($("#Tgender").val());
//			$(".chosen-select").trigger("chosen:updated");  
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
			//加载数据
			for (var i = 0; i < data.length; i++) {
				html += '<option value="' + data[i].roleId + '">' + data[i].roleName + '</option>'
			}
			$("#roleIds").append(html);
			var roleIds = $("#Trole").val().split(',');
			
			for (i = 0; i < roleIds.length; i++) {  
		        value = roleIds[i];  
		        $("#roleIds" + " option[value='" + value + "']").attr('selected', 'selected');  
		    }
			$("#roleIdst").trigger("chosen:updated");  
			$("#roleIds").chosen({
				maxHeight : 200,
				width : "100%"
			});
			
			//点击事件
			$('#roleIds').on('change', function(e, params) {
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

//账号类型
function loadAccountType(){
	var html = "";
	$.ajax({
		url : '/common/dict/list/sys_user_accountType',
		success : function(data) {
			//加载数据
			for (var i = 0; i < data.length; i++) {
				html += '<option value="' + data[i].value + '">' + data[i].name + '</option>'
			}
			$("#accountType").append(html);
			$("#accountType").val($("#TaccountType").val()).trigger("chosen:updated");
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
//状态
function loadStatus(){
	var html = "";
	$.ajax({
		url : '/common/dict/list/sys_user_status',
		success : function(data) {
			//加载数据
			for (var i = 0; i < data.length; i++) {
				html += '<option value="' + data[i].value + '">' + data[i].name + '</option>'
			}
			$("#status").append(html);
			$("#status").val($("#Tstatus").val()).trigger("chosen:updated");
			$("#status").chosen({
				maxHeight : 200,
				width : "100%"
			});
			//点击事件
			$('#status').on('change', function(e, params) {
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
				html += '<option value="' + data[i].value + '">' + data[i].name + '</option>'
			}
			$("#licensCase").append(html);
			$("#licensCase").val($("#TlicensCase").val()).trigger("chosen:updated");
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