$().ready(function() {
	loadType();
	validateRule();
});

$.validator.setDefaults({
	submitHandler : function() {
		update();
	}
});
function update() {
	$.ajax({
		cache : true,
		type : "POST",
		url : "/projectmgr/project/update",
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
			}
		},
		messages : {
			name : {
				required : icon + "请输入名字"
			}
		}
	})
}

function loadType(){
    var html = "";

    //加载国家字典值 和 项目类型二级联动
    $.ajax({
        url : '/common/dict/list/country',
        data:{
            sort : 'sort',
            order : 'asc'
        },
        success : function(data) {
            //加载数据
            for (var i = 0; i < data.length; i++) {
                html += '<option value="' + data[i].value + '">' + data[i].name + '</option>'
            }
            $("#country").append(html);
            //初始化下拉框样式
            $("#projectType").chosen();
            $("#country").chosen();
			//初始化国家下拉框的值
            $("#country").val($("#Tcountry").val());
            $("#country").trigger("chosen:updated");
            //初始化项目下拉框的值
			if($("#TprojectType").val() != ""){
				//获取项目类型下拉框值
                queryProjectType($("#Tcountry").val(),$("#TprojectType").val());


			}
            $("#country").bind("change",function(){
                queryProjectType($(this).val(),'');
            });
        }
    });

    //加载移民方式字典值
    $.ajax({
        url : '/common/dict/list/immigrationMode',
        data:{
            sort : 'sort',
            order : 'asc'
        },
        success : function(data) {
            var html_immigrationMode = "";
            //加载数据
            for (var i = 0; i < data.length; i++) {
                html_immigrationMode += '<option value="' + data[i].value + '">' + data[i].name + '</option>'
            }
            $("#immigrationMode").append(html_immigrationMode);
            //初始化下拉框样式
            $("#immigrationMode").chosen();

            $("#immigrationMode").val($("#TimmigrationMode").val());
            $("#immigrationMode").trigger("chosen:updated");
        }
    });
    //加载开放情况字典值
    $.ajax({
        url : '/common/dict/list/ifOpen',
        data:{
            sort : 'sort',
            order : 'asc'
        },
        success : function(data) {
            var html_ifOpen = "";
            //加载数据
            for (var i = 0; i < data.length; i++) {
                html_ifOpen += '<option value="' + data[i].value + '">' + data[i].name + '</option>'
            }
            $("#ifOpen").append(html_ifOpen);
            //初始化下拉框样式
            $("#ifOpen").chosen();

            $("#ifOpen").val($("#TifOpen").val());
            $("#ifOpen").trigger("chosen:updated");
        }
    });
}

function queryProjectType(country_value,projectType_value){
    var url1 = '/common/dict/list/'+country_value;
    $.get(url1,{
        sort : 'sort',
        order : 'asc'
    },function(data){
        var ahtml="";
        if(data != '' && data.length>0){
            for (var i = 0; i < data.length; i++) {
                ahtml += '<option value="' + data[i].value + '">' + data[i].name + '</option>'
            }
            $("#projectType").empty();
            $("#projectType").append('<option value=""> --请先选择国家--</option>');
            $("#projectType").append(ahtml);

            $("#projectType").trigger("chosen:updated");
            if(projectType_value != ""){
                $("#projectType").val(projectType_value);
                $("#projectType").trigger("chosen:updated");
			}

            $("#projectTypeDiv").show();
            $("#projectTypeOtherDiv").hide();
        }else{
            //如果选择了其他，则需要手动输入
            $("#projectTypeDiv").hide();
            $("#projectTypeOtherDiv").show();
        }
    });


}