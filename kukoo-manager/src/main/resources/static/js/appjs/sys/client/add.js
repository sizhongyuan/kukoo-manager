$().ready(function() {
	loadAccountType();
	loadGender();
//	loadStatus();
//	loadRole();
//	loadLicensCase();
//	loadInstitutions();
//	loadTime();
	loadCountry();
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
//	var roleIdArray = $("#roleIdsSelect").val();
//	$("#roleIds").val(roleIdArray.join(","));
//	$("#name").val($("#cnname").val());
	var location;
	if($("#country").val() == "100000"){
		location = $("#countryName").val() + "-" + $("#provinceName").val() + "-" + $("#cityName").val();
	}else{
		location = $("#countryName").val() + "-" + $("#foreignCity").val();
	}
	$("#liveAddress").val(location);
	
	var intentionCountry = $("#intention_country").val() + "-" + $("#intention_city").val();
	$("#intentionCountry").val(intentionCountry);
	$.ajax({
		cache : true,
		type : "POST",
		url : "/sys/client/save",
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

jQuery.validator.addMethod("isMobile", function(value, element) {
    var length = value.length;
    var mobile = /^1[34578]\d{9}$/;/*/^1(3|4|5|7|8)\d{9}$/*/
    return this.optional(element) || (length == 11 && mobile.test(value));
}, "请正确填写您的手机号码");

function validateRule() {
	var icon = "<i class='fa fa-times-circle'></i> ";
	$("#signupForm").validate({
		//ignore: ":hidden:not(select)",
		rules : {
//			cnname : {
//				required : true
//			},
//			username : {
//				required : true,
//				minlength : 2,
//				remote : {
//					url : "/sys/user/exit", // 后台处理程序
//					type : "post", // 数据发送方式
//					dataType : "json", // 接受数据格式
//					data : { // 要传递的数据
//						username : function() {
//							return $("#username").val();
//						}
//					}
//				}
//			},
//			password : {
//				required : true,
//				minlength : 6
//			},
//			confirm_password : {
//				required : true,
//				minlength : 6,
//				equalTo : "#password"
//			},
			email : {
				required : true,
				email : true
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
			clientStatus :{
				required : true,
			},
			intention :{
				required : true,
			},
			accountType :{
				required : true,
			},
			sex :{
				required : true,
			},
			liveAddress :{
				required : true,
			},
			mobileInland : {
				required : true,
				minlength : 11,
				isMobile:true
			},
//			mobileForeign : {
//				required : true,
//				number:true
//			},
			wechar : {
				required : true
//				number:true
			}
//			topic : {
//				required : "#newsletter:checked",
//				minlength : 2
//			},
////			gender : {
////				required : true,
////				gender : true
////			},
//			agree : "required"
		},
		messages : {

//			name : {
//				required : icon + "请输入姓名"
//			},
//			username : {
//				required : icon + "请输入您的用户名",
//				minlength : icon + "用户名必须两个字符以上",
//				remote : icon + "用户名已经存在"
//			},
//			password : {
//				required : icon + "请输入您的密码",
//				minlength : icon + "密码必须6个字符以上"
//			},
//			confirm_password : {
//				required : icon + "请再次输入密码",
//				minlength : icon + "密码必须6个字符以上",
//				equalTo : icon + "两次输入的密码不一致"
//			},
			accountType:{
				required : icon + "请选择账号类型"
			},
			sex:{
				required : icon + "请选择性别"
			},
			email : icon + "请输入客户的E-mail",
			nickname : icon + "请输入客户的昵称",
			cnname : icon + "请输入客户的中文姓名",
			enname : icon + "请输入客户的英文姓名",
			mobileInland : icon + "请输入客户的国内手机号",
			mobileForeign : icon + "请输入客户的国外手机号",
			clientStatus : icon + "请输入客户的状态",
			liveAddress : icon + "请输入客户的现居住地",
			wechar : icon + "请输入客户的微信"
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
			$("#sex").append(html);
			$("#sex").chosen({
				maxHeight : 200,
				width : "100%"
			});
			//点击事件
			$('#sex').on('change', function(e, params) {
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
			$("#roleIdsSelect").append(html);
			$("#roleIdsSelect").chosen({
				maxHeight : 200,
				width : "100%"
			});
			//点击事件
			$('#roleIdsSelect').on('change', function(e, params) {
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
//所在机构
function loadInstitutions(){
	var html = "";
	$.ajax({
		url : '/common/dict/list/sys_user_institutions',
		success : function(data) {
			//加载数据
			for (var i = 0; i < data.length; i++) {
				if(data[i].value == '1'){
					html += '<option value="' + data[i].value + '">' + data[i].name + '</option>'
				}else{
					html += '<option value="' + data[i].value + '">' + data[i].name + '</option>'
				}
				
			}
			$("#institutions").append(html);
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
            //初始化下拉框样式
            $("#city").chosen();
            $("#province").chosen();
            $("#country").chosen();
            
          //国家联动省份
            $("#country").bind("change",function(){
                var value = $(this).val();
                //国家转汉字
                var nameUrl = '/common/sysLocation/countryName';
                $.get(nameUrl,{
                		countryId:value
                },function(data){
//                		$("#countryName").val(data);
                	$("#countryName").val(value);
                });
                
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
              //省份转汉字
                var nameUrl = '/common/sysLocation/provinceName';
                $.get(nameUrl,{
                		provinceId:value
                },function(data){
//                		$("#provinceName").val(data);
                		$("#provinceName").val(value);
                });
                
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
            
          //省份联动城市
            $("#city").bind("change",function(){
                var value = $(this).val();
              //省份转汉字
                var nameUrl = '/common/sysLocation/cityName';
                $.get(nameUrl,{
                		cityId:value
                },function(data){
//                		$("#cityName").val(data);
                	$("#cityName").val(value);
                });
                
            });
        }
    });
}

function loadTime(){
	laydate.render({
		  elem: '#joinTime', //指定元素
		  type: 'datetime'
	});
	laydate.render({
		  elem: '#leaveTime', //指定元素
		  type: 'datetime'
	});
	laydate.render({
		  elem: '#laborLimit', //指定元素
		  type: 'datetime'
	});
	laydate.render({
		  elem: '#birthday' //指定元素
	});
}

