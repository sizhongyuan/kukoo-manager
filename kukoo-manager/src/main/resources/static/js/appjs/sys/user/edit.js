// 以下为官方示例
$().ready(function() {
	loadAccountType();
	loadGender();
	loadStatus();
	loadRole();
	loadLicensCase();
	loadInstitutions()
	loadTime();
	validateRule();
	loadCountry();
	// $("#signupForm").validate();
	var mobileForeign = $("#mobileForeign").val();
	if(mobileForeign !== "" && mobileForeign !== undefined && mobileForeign !== null){
		$("#mobileInland").attr("required",false);
	}
	var mobileInland = $("#mobileInland").val();
	if(mobileInland !== "" && mobileInland !== undefined && mobileInland !== null){
		$("#mobileForeign").attr("required",false);
	}
});

$.validator.setDefaults({
	submitHandler : function() {
		update();
	}
});
function update() {
	console.log($("#contract").val());
//	$("#roleIds").val(getCheckedRoles());
	//$("#roleIds").val($("#roleIds").val().join(','));
	$("#name").val($("#cnname").val());
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
			console.log(data);
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

jQuery.validator.addMethod("isMobile", function(value, element) {
    var length = value.length;
    var mobile = /^1[34578]\d{9}$/;/*/^1(3|4|5|7|8)\d{9}$/*/
    return this.optional(element) || (length == 11 && mobile.test(value));
}, "请正确填写您的手机号码");

jQuery.validator.addMethod("bloodType", function(value, element) {
    if(value != 'A' && value != 'B' && value != 'O' && value != 'AB'){
    		return false;
    }else{
    		return true;
    }
}, "请正确填写您的血型");

function validateRule() {
	var icon = "<i class='fa fa-times-circle'></i> ";
	$("#signupForm").validate({
		//ignore: ":hidden:not(select)",
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
			nickname :{
				required : true,
			},
			cnname : {
				required : true,
			},
			enname : {
				required : true,
			},
//			mobileInland : {
//				required : true,
//				minlength : 11,
//				isMobile:true
//			},
//			mobileForeign : {
//				required : true,
//				number:true
//			},
			majorRange : {
				required : true,
			},
			level : {
				required : true,
				number:true
			},
			workyear : {
				required : true,
				number:true
			},
			baseSalary : {
				required : true,
				number:true
			},
			socialSecurity : {
				required : true,
				number:true
			},
			companySecurity : {
				required : true,
				number:true
			},
			joinTime : {
				required : true,
				date:true
			},
//			laborLimit : {
//				required : true,
//				date:true
//			},
			IDNumber : {
				required : true,
				number:true
			},
			bloodType : {
				required : true,
				bloodType:true
			},
			nativePlace : {
				required : true,
			},
			birthday: {
				required : true,
				date:true
			},
			emergencyContact: {
				required : true,
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
			nickname : icon + "请输入您的昵称",
			cnname : icon + "请输入您的中文姓名",
			enname : icon + "请输入您的英文姓名",
//			mobileInland : icon + "请输入您的国内手机号",
//			mobileForeign : icon + "请输入您的国外手机号",
			majorRange : icon + "请输入您的专业范围",
			level : icon + "请输入您的级别",
			workyear : icon + "请输入您的从业年限",
			baseSalary : icon + "请输入您的基本工资",
			socialSecurity: icon + "请输入您的社保标准",
			companySecurity : icon + "请输入您的公司社保成本",
			joinTime : icon + "请输入您加入的时间",
//			laborLimit : icon + "请输入您的劳动关系期限",
			IDNumber : icon + "请输入您的证件号",
			bloodType : icon + "请输入您的血型",
			nativePlace : icon + "请输入您的籍贯",
			birthday : icon + "请输入您的出生日期",
			emergencyContact : icon + "请输入您紧急联系人信息",
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
			var roleIds = $("#Trole").val().replace("[","");
			roleIds = roleIds.replace("]","");
			roleIds = roleIds.trim().replace(/\s/g,"")
			$("#roleIds").append(html);
			$("#roleIds").chosen({
				maxHeight : 200,
				width : "100%"
			});
			$("#roleIds").val(roleIds.split(",")).trigger("chosen:updated");
			//点击事件
			$('#roleIds').on('change', function(e, params) {
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
			$(".chosen-select").val($("#TaccountType").val()).trigger("chosen:updated"); 
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

//所在机构
function loadInstitutions(){
	var html = "";
	$.ajax({
		url : '/common/dict/list/sys_user_institutions',
		success : function(data) {
			//加载数据
			for (var i = 0; i < data.length; i++) {
				html += '<option value="' + data[i].value + '">' + data[i].name + '</option>'
			}
			$("#institutions").append(html);
			$("#institutions").val($("#Tinstitutions").val()).trigger("chosen:updated");
			$("#institutions").chosen({
				maxHeight : 200,
				width : "100%"
			});
			//点击事件
			$('#institutions').on('change', function(e, params) {
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
	laydate.render({
		  elem: '#joinTime', //指定元素
		  type: 'datetime',
		  value: new Date($("#TjoinTime").val())
	});
	laydate.render({
		  elem: '#leaveTime', //指定元素
		  type: 'datetime',
		  value: new Date($("#TleaveTime").val())
	});
//	laydate.render({
//		  elem: '#laborLimit', //指定元素
//		  type: 'datetime',
//		  value: new Date($("#TlaborLimit").val())
//	});
	laydate.render({
		  elem: '#birthday', //指定元素
		  value: new Date($("#Tbirthday").val())
	});
}

//国家
function loadCountry(){
	var html = "";
    //加载国家字典值 和 项目类型二级联动
    $.ajax({
        url : '/common/sysLocation/country',
        data:{
            sort : 'sort',
            order : 'asc'
        },
        success : function(data) {
            //加载数据
            for (var i = 0; i < data.length; i++) {
            		html += '<option value="' + data[i].countryId + '">' + data[i].country + '</option>'
            }
            $("#country").append(html);
            $("#country").val($("#Tcountry").val()).trigger("chosen:updated");
            
            var countryValue = $("#Tcountry").val();
            var url = '/common/sysLocation/province';
            $.get(url,{
                sort : 'sort',
                order : 'asc',
                countryId:countryValue
            },function(data){
                var ahtml="";
                if(countryValue == '100000'){
                    for (var i = 0; i < data.length; i++) {
                        ahtml += '<option value="' + data[i].provinceId + '">' + data[i].province + '</option>'
                    }
                    $("#province").empty();
                    $("#province").append('<option value=""> --请选择省份--</option>');
                    $("#province").append(ahtml);
                    $("#province").val($("#Tprovince").val()).trigger("chosen:updated");
                    
                    $("#province").trigger("chosen:updated");

                    $("#provinceDiv").show();
                    $("#cityDiv").show();
                    $("#foreignCityDiv").hide();
                    $("#foreignCity").val("");
                }else{
                    //如果选择了其他，则需要手动输入
                    $("#provinceDiv").hide();
                    $("#cityDiv").hide();
                    $("#province").empty();
                    $("#province").append('<option value=""> --请选择省份--</option>');
                    $("#province").val("");
                    $("#city").empty();
                    $("#city").append('<option value=""> --请选择城市--</option>');
                    $("#city").val("");
                    $("#foreignCityDiv").show();
                }
            });
            
            var provinceValue = $("#Tprovince").val();
            var url = '/common/sysLocation/city';
            $.get(url,{
                sort : 'sort',
                order : 'asc',
                provinceId:provinceValue
            },function(data){
                var bhtml="";
                for (var i = 0; i < data.length; i++) {
                    bhtml += '<option value="' + data[i].cityId + '">' + data[i].city + '</option>'
                }
                $("#city").empty();
                $("#city").append('<option value=""> --请选择城市--</option>');
                $("#city").append(bhtml);
                $("#city").val($("#Tcity").val()).trigger("chosen:updated");

                $("#city").trigger("chosen:updated");
            });
            
            
            //初始化下拉框样式
            $("#city").chosen();
            $("#province").chosen();
            $("#country").chosen();
            
          //国家联动省份
            $("#country").bind("change",function(){
                var value = $(this).val();
                var url = '/common/sysLocation/province';
                $.get(url,{
                    sort : 'sort',
                    order : 'asc',
                    countryId:value
                },function(data){
                    var ahtml="";
                    if(value == '100000'){
                        for (var i = 0; i < data.length; i++) {
                            ahtml += '<option value="' + data[i].provinceId + '">' + data[i].province + '</option>'
                        }
                        $("#province").empty();
                        $("#province").append('<option value=""> --请选择省份--</option>');
                        $("#province").append(ahtml);
                        
                        $("#city").empty();
                        $("#city").append('<option value=""> --请选择城市--</option>');
                        
                        $("#province").trigger("chosen:updated");
                        $("#city").trigger("chosen:updated");

                        $("#provinceDiv").show();
                        $("#cityDiv").show();
                        $("#foreignCityDiv").hide();
                        $("#foreignCity").val("");
                    }else{
                        //如果选择了其他，则需要手动输入
                        $("#provinceDiv").hide();
                        $("#cityDiv").hide();
                        $("#province").empty();
                        $("#province").append('<option value=""> --请选择省份--</option>');
                        $("#province").val("");
                        $("#city").empty();
                        $("#city").append('<option value=""> --请选择城市--</option>');
                        $("#city").val("");
                        $("#foreignCityDiv").show();
                    }
                });
            });
            
          //省份联动城市
            $("#province").bind("change",function(){
                var value = $(this).val();
                var url = '/common/sysLocation/city';
                $.get(url,{
                    sort : 'sort',
                    order : 'asc',
                    provinceId:value
                },function(data){
                    var bhtml="";
                    for (var i = 0; i < data.length; i++) {
                        bhtml += '<option value="' + data[i].cityId + '">' + data[i].city + '</option>'
                    }
                    $("#city").empty();
                    $("#city").append('<option value=""> --请选择城市--</option>');
                    $("#city").append(bhtml);

                    $("#city").trigger("chosen:updated");
                });
            });
        }
    });
}

//手机号校验事件
$("#mobileInland").bind("change",function(){
	var value = $(this).val();
	if(value !== "" && value !== undefined && value !== null){
		$("#mobileForeign").attr("required",false);
	}else{
		$("#mobileForeign").attr("required",true);
	}
})
$("#mobileForeign").bind("change",function(){
	var value = $(this).val();
	if(value !== "" && value !== undefined && value !== null){
		$("#mobileInland").attr("required",false);
	}else{
		$("#mobileInland").attr("required",true);
	}
})