// 以下为官方示例
$().ready(function() {
	loadAccountType();
	loadGender();
	loadStatus();
	loadIntentionCountry();
	loadIntention();
//	loadRole();
//	loadLicensCase();
//	loadInstitutions()
//	loadTime();
	validateRule();
	loadCountry();
	// $("#signupForm").validate();
});

$.validator.setDefaults({
	submitHandler : function() {
		update();
	}
});
function update() {
//	$("#roleIds").val(getCheckedRoles());
	//$("#roleIds").val($("#roleIds").val().join(','));
	var location;
	if($("#country").val() == "100000"){
		location = $("#countryName").val() + "-" + $("#provinceName").val() + "-" + $("#cityName").val();
	}else{
		location = $("#countryName").val() + "-" + $("#foreignCity").val();
	}
	$("#liveAddress").val(location);
	
	var intentionCountry = $("#intention_country").val() + "-" + $("#intention_city").val();
	$("#intentionCountry").val(intentionCountry);
	$("#name").val($("#cnname").val());
	$.ajax({
		cache : true,
		type : "POST",
		url : "/sys/client/update",
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
			weChat : {
				required : true,
				number:true
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
//			mobileForeign : icon + "请输入客户的国外手机号",
			clientStatus : icon + "请输入客户的状态",
			liveAddress : icon + "请输入客户的现居住地",
			weChat : icon + "请输入客户的微信"
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
			$("#sex").append(html);
			$("#sex").val($("#Tsex").val()).trigger("chosen:updated");
			$("#sex").chosen({
				maxHeight : 200,
				width : "100%",
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
			//加载数据
			for (var i = 0; i < data.length; i++) {
				html += '<option value="' + data[i].roleId + '">' + data[i].roleName + '</option>'
			}
			var roleIds = $("#Trole").val().split(',');
			for (i = 0; i < roleIds.length; i++) {  
		        value = roleIds[i];  
		        $("#roleIds" + " option[value='" + value + "']").attr('selected', 'selected');  
		    }
			$("#roleIds").trigger("chosen:updated");  
			$("#roleIds").append(html);
			$("#roleIds").chosen({
				maxHeight : 200,
				width : "100%"
			});
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
//				html += '<option value="' + data[i].value + '">' + data[i].name + '</option>'
				html += "<option value=''>--选择状态--</option>" +
						"<option value='注册'>注册</option>" +
						"<option value='评估'>评估</option>" +
						"<option value='签约（未付款）'>签约（未付款）</option>" +
						"<option value='签约'>签约</option>" +
						"<option value='完成'>完成</option>" +
						"<option value='终止'>终止</option>";
			}
			
			$("#clientStatus").append(html);
			$("#clientStatus").val($("#TclientStatus").val()).trigger("chosen:updated");
			$("#clientStatus").chosen({
				maxHeight : 200,
				width : "100%"
			});
			//点击事件
			$('#clientStatus').on('change', function(e, params) {
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

//意向
function loadIntention(){
	var html = "";
	$.ajax({
		url : '/common/dict/list/sys_user_status',
		success : function(data) {
			//加载数据
			for (var i = 0; i < data.length; i++) {
//				html += '<option value="' + data[i].value + '">' + data[i].name + '</option>'
				html += "<option value=''>--选择意向--</option>" +
						"<option value='想移民'>想移民</option>" +
						"<option value='申请中'>申请中</option>" +
						"<option value='已移民'>已移民</option>" +
						"<option value='保密'>保密</option>";
			}
			$("#intention").append(html);
			$("#intention").val($("#Tintention").val()).trigger("chosen:updated");
			$("#intention").chosen({
				maxHeight : 200,
				width : "100%"
			});
			//点击事件
			$('#intention').on('change', function(e, params) {
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
	laydate.render({
		  elem: '#laborLimit', //指定元素
		  type: 'datetime',
		  value: new Date($("#TlaborLimit").val())
	});
	laydate.render({
		  elem: '#birthday', //指定元素
		  value: new Date($("#Tbirthday").val())
	});
}
//意向国家
function loadIntentionCountry(){
	//意向国家
	var intentionCountry = $("#intentionCountry").val();
	var intentionCountrys = intentionCountry.split("-");
//	alert(intentionCountry);
////	$("#intention_country").val(intentionCountrys[0]).trigger("chosen:updated");
////	$("#intention_country").chosen({
////		maxHeight : 200,
////		width : "100%",
////	});
//	var html = "";
//	html += "<option value=''>--意向国家--</option>" +
//			"<option value='加拿大'>加拿大</option>" +
//			"<option value='美国'>美国</option>" +
//			"<option value='澳大利亚'>澳大利亚</option>" +
//			"<option value='新西兰'>新西兰</option>" +
//			"<option value='葡萄牙'>葡萄牙</option>" +
//			"<option value='西班牙'>西班牙</option>" +
//			"<option value='瑞士'>瑞士</option>" +
//			"<option value='英国'>英国</option>";
//	
//	$("#intention_country").append(html);
//	$("#Tintention_country").val(intentionCountrys[0]);
//	$("#intention_country").val($("#Tintention_country").val()).trigger("chosen:updated");
	var html = "";
	$("#Tintention_country").val(intentionCountrys[0]);
	$("#intention_city").val(intentionCountrys[1]);
	$.ajax({
		url : '/common/dict/list/sys_user_status',
		success : function(data) {
			//加载数据
			for (var i = 0; i < data.length; i++) {
//				html += '<option value="' + data[i].value + '">' + data[i].name + '</option>'
				html += "<option value=''>--意向国家--</option>" +
						"<option value='加拿大'>加拿大</option>" +
						"<option value='美国'>美国</option>" +
						"<option value='澳大利亚'>澳大利亚</option>" +
						"<option value='新西兰'>新西兰</option>" +
						"<option value='葡萄牙'>葡萄牙</option>" +
						"<option value='西班牙'>西班牙</option>" +
						"<option value='瑞士'>瑞士</option>" +
						"<option value='英国'>英国</option>";
			}
			$("#intention_country").append(html);
			$("#intention_country").val($("#Tintention_country").val()).trigger("chosen:updated");
			$("#intention_country").chosen({
				maxHeight : 200,
				width : "100%"
			});
			//点击事件
			$('#intention_country').on('change', function(e, params) {
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
//现居住地
function loadCountry(){
	var liveAddress = $("#liveAddress").val();
	var liveAddresss = liveAddress.split("-");
	$("#countryName").val(liveAddresss[0]);
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
            $("#country").val($("#countryName").val()).trigger("chosen:updated");
            var countryValue = $("#countryName").val();
            var url = '/common/sysLocation/province';
            $.get(url,{
                sort : 'sort',
                order : 'asc',
                countryId:countryValue
            },function(data){
                var ahtml="";
                if(countryValue == '100000'){
                	$("#provinceName").val(liveAddresss[1]);
                	$("#cityName").val(liveAddresss[2]);
                    for (var i = 0; i < data.length; i++) {
                        ahtml += '<option value="' + data[i].provinceId + '">' + data[i].province + '</option>'
                    }
                    $("#province").empty();
                    $("#province").append('<option value=""> --请选择省份--</option>');
                    $("#province").append(ahtml);
                    $("#province").val($("#provinceName").val()).trigger("chosen:updated");
                    $("#province").trigger("chosen:updated");
                    $("#provinceDiv").show();
                    $("#cityDiv").show();
                    $("#foreignCityDiv").hide();
                    $("#foreignCity").val("");
                }else{
                    //如果选择了其他，则需要手动输入
                	$("#foreignCity").val(liveAddresss[1]);
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
            
            var provinceValue = $("#provinceName").val();
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
                $("#city").val($("#cityName").val()).trigger("chosen:updated");
                $("#city").trigger("chosen:updated");
            });
            
            
            //初始化下拉框样式
            $("#city").chosen();
            $("#province").chosen();
            $("#country").chosen();
            
          //国家联动省份
            $("#country").bind("change",function(){
                var value = $(this).val();
                $("#countryName").val(value);
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
                $("#provinceName").val(value);
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
                $("#cityName").val(value);
              //省份转汉字
//                var nameUrl = '/common/sysLocation/cityName';
//                $.get(nameUrl,{
//                		cityId:value
//                },function(data){
//                		$("#cityName").val(data);
//                });
                
            });
        }
    });
}


