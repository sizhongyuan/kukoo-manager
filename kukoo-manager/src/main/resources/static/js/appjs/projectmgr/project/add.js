$().ready(function() {
    loadType();
    validateRule();
});

$.validator.setDefaults({
    submitHandler : function() {
        save();
    }
});
function save() {
    $.ajax({
        cache : true,
        type : "POST",
        url : "/projectmgr/project/save",
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
                required : icon + "请输入姓名"
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

            $("#country").bind("change",function(){
                var value = $(this).val();
                console.log("==="+value);
                var url = '/common/dict/list/'+value;
                $.get(url,{
                    sort : 'sort',
                    order : 'asc'
                },function(data){
                    console.log("==="+data);
                    var ahtml="";
                    if(data != '' && data.length>0){
                        for (var i = 0; i < data.length; i++) {
                            ahtml += '<option value="' + data[i].value + '">' + data[i].name + '</option>'
                        }
                        $("#projectType").empty();
                        $("#projectType").append('<option value=""> --请先选择国家--</option>');
                        $("#projectType").append(ahtml);

                        $("#projectType").trigger("chosen:updated");

                        $("#projectTypeDiv").show();
                        $("#projectTypeOtherDiv").hide();
                    }else{
                        //如果选择了其他，则需要手动输入
                        $("#projectTypeDiv").hide();
                        $("#projectTypeOtherDiv").show();
                    }
                });

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
        }
    });


}

var openUser = function(){
    layer.open({
        type:2,
        title:"选择人员",
        area : [ '300px', '450px' ],
        content:"/sys/user/treeView"
    })
}

function loadUser(userIds,userNames){
    $("#userIds").val(userIds);
    $("#userNames").val(userNames);
}