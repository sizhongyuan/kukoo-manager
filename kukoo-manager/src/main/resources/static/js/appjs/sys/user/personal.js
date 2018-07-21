var prefix = "/sys/user"
$(function () {
//    laydate({
//        elem : '#birth'
//    });
	loadCountry();
	loadTime();
	loadGender();
});
/**
 * 基本信息提交
 */
$("#base_save").click(function () {
    var hobbyStr = getHobbyStr();
    $("#hobby").val(hobbyStr);
    if($("#basicInfoForm").valid()){
            $.ajax({
                cache : true,
                type : "POST",
                url :"/sys/user/updatePeronal",
                data : $('#basicInfoForm').serialize(),
                async : false,
                error : function(request) {
                    laryer.alert("Connection error");
                },
                success : function(data) {
                    if (data.code == 0) {
                        parent.layer.msg("更新成功");
                        var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
        					parent.layer.close(index);
                    } else {
                        parent.layer.alert(data.msg)
                    }
                }
            });
        }

});
$("#pwd_save").click(function () {
    if($("#modifyPwd").valid()){
        $.ajax({
            cache : true,
            type : "POST",
            url :"/sys/user/resetPwd",
            data : $('#modifyPwd').serialize(),
            async : false,
            error : function(request) {
                parent.laryer.alert("Connection error");
            },
            success : function(data) {
                if (data.code == 0) {
                    parent.layer.alert("更新密码成功");
                    $("#photo_info").click();
                    var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
    					parent.layer.close(index);
                } else {
                    parent.layer.alert(data.msg)
                }
            }
        });
    }
});
function getHobbyStr(){
    var hobbyStr ="";
    $(".hobby").each(function () {
        if($(this).is(":checked")){
            hobbyStr+=$(this).val()+";";
        }
    });
   return hobbyStr;
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

function loadTime(){
	laydate.render({
		  elem: '#birthday', //指定元素
		  value: new Date($("#Tbirthday").val())
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