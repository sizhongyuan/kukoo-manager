var FieldCount = 0;

$().ready(function() {
    validateRule();
    loadFile();
});

$.validator.setDefaults({
	submitHandler : function() {
	    var orderbyList = $(".getOrderby");
	    var arr = orderbyList.sort();
	    for (var i=0;i<arr.length-1;i++){
            for (var j=i+1;j<arr.length;j++){
                if(arr[i].value==arr[j].value){
                    parent.layer.alert("不能出现相同排序码");
                    return false;
                }
            }
        }
		update();
	}
});

function update() {
	$.ajax({
		cache : true,
		type : "POST",
		url : "/timeline/temp/updateOrderby",
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
            orderby : {
                digits : true
            }
        },
        messages : {
            orderby : {
                required : icon + "请输入排序顺序"
            }
        }
    })
}

function loadFile() {
    if(tempOrderbyList != "" && tempOrderbyList != null && tempOrderbyList != undefined){

        for(var i = 0;i<tempOrderbyList.length;i++){
            $(inputOrderby).append('' +
                '<div class="form-group">' +
                '<input id="orderbyList['+ i +'].id" name="tempId" value="'+ tempOrderbyList[i].id +'" class="form-control" type="hidden">' +
                    '<label class="col-sm-2 control-label">排序*</label>' +
                    '<div class="col-sm-3">' +
                        '<input id="orderbyList['+ i +'].orderby" name="orderby" value="'+ tempOrderbyList[i].orderby +'" class="form-control getOrderby" type="text" required>' +
                    '</div>' +
                    '<label class="col-sm-2 control-label">环节名称*</label>' +
                    '<div class="col-sm-3">' +
                        '<input value="'+ tempOrderbyList[i].linkName +'" class="form-control" type="text" readonly="readonly">' +
                    '</div>' +
                '</div>');
        }
    }
}