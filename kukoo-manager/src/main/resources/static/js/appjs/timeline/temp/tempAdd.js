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
    var addInput = $("#addInput");
    var inputFile = $("#inputFile");

    $(addInput).click(function (e) {
        $(inputFile).append('' +
            '<div class="form-group">' +
            '<label class="col-sm-3">' +
            '<input id="fileName'+FieldCount+'" name="fileId'+ FieldCount +'" class="form-control" type="text" placeholder="请输入附件名" required>' +
            '</label>' +
            '<div class="col-sm-1">' +
            "<button type='button' class='btn  btn-primary' onclick='uploadFile("+FieldCount+")' >附件上传</button>"+
            '<input id="fileId'+FieldCount+'" name="ttTimelineTempFile['+ FieldCount +'].fileId" style="display: none" type="file" required>' +
            '</div>' +
            '<div class="col-sm-6">' +
            '<span id = "fileShow'+FieldCount+'" class="form-control"></span>' +
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

function uploadFile(index){
    //给附件绑定事件
    $("#fileId"+index).fileupload({
        dataType: 'json',
        url: "/accessories/uploadFilesMethod?appCode=timeline",//文件的后台接受地址,appCode代表各自模块文件夹名
        //设置进度条
        progressall: function (e, data) {
            var progress = parseInt(data.loaded / data.total * 100);
            // console.log(progress);
            // $('#progress .bar').css(
            //     'width',
            //     progress + '%'
            // );
        },
        //上传完成之后的操作
        done: function (e, data){
            if(data.result.status == '201'){
                //获取对应input的name
                var inputName = data.result.data[0].inputName;
                //获取对应上传文件名称
                var fileName = data.result.data[0].fileName;
                //获取对应上传文件时间戳，唯一标识
                var saveName = data.result.data[0].saveName;
                var downLoadUrl = '/accessories/downLoadFilesMethod?fileName='+saveName;

                $("#fileShow"+index).append('<a href="'+downLoadUrl+'">'+fileName+'</a>');

            }else{
                parent.layer.alert(data.result.error);
            }
        }
    });
    $("#fileId"+index).click();

}


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