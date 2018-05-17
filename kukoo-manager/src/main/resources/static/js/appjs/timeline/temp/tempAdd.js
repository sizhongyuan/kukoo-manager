$().ready(function() {
    validateRule();
});

$.validator.setDefaults({
	submitHandler : function() {
		save();
	}
});
$(document).ready(function() {
    var FieldCount=0;
    var addInput1 = $("#addInput");
    var inputFile = $("#inputFile");

    $(addInput1).click(function (e) {
        $(inputFile).append('' +
            '<div class="form-group">' +
            '<label class="col-sm-3">' +
            '<input id="ttTimelineTempFile['+ FieldCount +'].fileName" name="ttTimelineTempFile['+ FieldCount +'].fileName" class="form-control" type="text" placeholder="请输入附件名" required>' +
            '</label>' +
            '<div class="col-sm-7">' +
            '<input id="ttTimelineTempFile['+ FieldCount +'].fileId" name="ttTimelineTempFile['+ FieldCount +'].fileId" class="form-control" type="file" required>' +
            '</div>' +
            '<div class="col-sm-1">' +
            '<button type="button" class="btn btn-warning removeInput">' +
            '<i class="fa fa-remove" aria-hidden="true"></i>' +
            '</button>' +
            '</div>' +
            '</div>');
        FieldCount++;
        return false;
    });

    $("body").on("click",".removeInput", function(e){
        $(this).parent('div').parent('div').remove();
        return false;
    });
});

function save() {
	$.ajax({
		cache : true,
		type : "POST",
		url : "/timeline/temp/save",
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