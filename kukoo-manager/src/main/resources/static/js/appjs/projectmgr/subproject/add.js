var subProjectUrl = "/projectmgr/subproject";
$().ready(function() {
    loadType();
    validateRule();

});

$.validator.setDefaults({
    submitHandler : function() {
        save();
    }
});
function validateRule() {
    var icon = "<i class='fa fa-times-circle'></i> ";
    $("#signupForm").validate({
        rules : {
            subProjectName : {
                required : true
            }
        },
        messages : {
            subProjectName : {
                required : icon + "请输入二级项目名称"
            }
        }
    })
}
function loadType(){
    //加载 是否抢名额 字典值
    $.ajax({
        url : '/common/dict/list/subproject_ifQuota',
        data:{
            sort : 'sort',
            order : 'asc'
        },
        success : function(data) {
            var html_ifQuota = "";
            //加载数据
            for (var i = 0; i < data.length; i++) {
                html_ifQuota += '<option value="' + data[i].value + '">' + data[i].name + '</option>'
            }
            $("#ifQuota").append(html_ifQuota);
            //初始化下拉框样式
            $("#ifQuota").chosen();
        }
    });
    //加载 项目状态 字典值
    $.ajax({
        url : '/common/dict/list/subproject_status',
        data:{
            sort : 'sort',
            order : 'asc'
        },
        success : function(data) {
            var html_status = "";
            //加载数据
            for (var i = 0; i < data.length; i++) {
                html_status += '<option value="' + data[i].value + '">' + data[i].name + '</option>'
            }
            $("#status").append(html_status);
            //初始化下拉框样式
            $("#status").chosen();
        }
    });
    laydate.render({
        elem: '#startTime'
        ,type: 'date'
    });
    laydate.render({
        elem: '#endTime'
        ,type: 'date'
    });

}
function save() {
    $.ajax({
        cache : true,
        type : "POST",
        url : subProjectUrl+"/save",
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