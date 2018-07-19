var prefix = "/sys/emp"
var clientUrl = "/sys/emp/client"
$(function() {
	var deptId = '';
	if(roleIdStr.indexOf("1") != -1){
		load(deptId);
		return true;
	}else if(roleIdStr.indexOf("60") != -1){
		loadClient();
		return true;
	}
});

function loadClient(){
	$('#exampleTable')
	.bootstrapTable(
		{
			url: clientUrl + '/list',
	        method: 'get',
	        clickToSelect: true,
	        uniqueId: "id",
	        striped : true, // 设置为true会有隔行变色效果
	        dataType : "json", // 服务器返回的数据类型
	        pagination : true,
	        pageSize: 10,// 如果设置了分页，每页数据条数
	        pageNumber : 1, // 如果设置了分布，首页页码
	        sidePagination : "server", // 设置在哪里进行分页，可选值为"client" 或者 "server"
	        queryParams : function(params) {
	            return {
	                //说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
	                limit : params.limit,
	                offset : params.offset,
	                searchCondition : $('#searchCondition').val(),
	                empId : userId
	            };
	        },
			columns: [{
	            field : 'username',
	            title : '姓名'
	        }, {
	            field: 'sex',
	            title: '性别'
	        },{
	            field: 'mobileInland',
	            title: '国内手机号'
	        }, {
	            field: 'mobileForeign',
	            title: '国外手机号'
	        },{
	            field: 'email',
	            title: '邮箱'
	        },{
	            field: 'wechar',
	            title: '微信'
	        },{
	            field: 'clientStatus',
	            title: '状态'
	        },{
	            field: 'intention',
	            title: '意向'
	        },{
	            title : '操作',
	            field : 'operation',
	            align : 'center',
	            formatter : function(value, row, index) {
	                var d = '<a class="btn btn-warning btn-sm" href="#" title="解除关联"  mce_href="#" onclick="removeRef(\''
	                    + row.clientId
	                    + '\')">解除关联</a> ';

	                return d;
	            }
	        } ]
		});
}

function load(deptId) {
	$('#exampleTable')
		.bootstrapTable(
			{
				method : 'get', // 服务器数据的请求方式 get or post
				url : prefix + "/list", // 服务器数据的加载地址
				iconSize : 'outline',
				toolbar : '#exampleToolbar',
				striped : true, // 设置为true会有隔行变色效果
				parentCode: 'parentId',
				dataType : "json", // 服务器返回的数据类型
				pagination : true, // 设置为true会在底部显示分页条
				detailView: true,//父子表
				singleSelect : false, // 设置为true将禁止多选
				pageSize : 10, // 如果设置了分页，每页数据条数
				pageNumber : 1, // 如果设置了分布，首页页码
				showColumns : false, // 是否显示内容下拉框（选择显示的列）
				sidePagination : "server", // 设置在哪里进行分页，可选值为"client" 或者
				queryParams : function(params) {
					return {
						// 说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
						limit : params.limit,
						offset : params.offset,
						searchCondition : $('#searchCondition').val(),
						role : $('#roleId').val(),
						deptId : deptId
					};
				},
				columns : [
					{
						field : 'headImg', // 列字段名
						title : '头像', // 列标题
						align : 'center',
						formatter:function(value,row,index){
							var url = row.headImg;
							var s = '<a class = "view"  href="javascript:void(0)" onclick="detail('+row.userId+')"><img style="width:20px;height:20px;border-radius:20px;"  src="/img/user.png" /></a>';
							return s;
						}
					},
					{
						field : 'name',
						title : '姓名',
					},
					{
						field : 'mobileInland',
						title : '手机号'
					},
					{
						field : 'gmtCreate',
						title : '注册时间'
					},
					{
						field : 'email',
						title : '邮箱'
					},
					{
						field : 'status',
						title : '状态',
						align : 'center',
						formatter : function(value, row, index) {
							if (value == '6') {
								return '<span class="label label-warning">合作暂停</span>';
							} else if (value == '5') {
								return '<span class="label label-primary">合作中</span>';
							} else if (value == '4') {
								return '<span class="label label-danger">合作终止</span>';
							} else if (value == '3') {
								return '<span class="label label-danger">离职</span>';
							} else if (value == '2') {
								return '<span class="label label-warning">休假</span>';
							} else if (value == '1') {
								return '<span class="label label-primary">在职</span>';
							}
						}
					},
					],
					//注册加载子表的事件。注意下这里的三个参数！
				    onExpandRow: function (index, row, $detail) {
				        initClientTable(index, row, $detail);
				    }
			});
		
}

//初始化二级项目列表
function initClientTable (index, row, $detail) {
    var empId = row.userId;
    console.log(empId);
    var cur_table = $detail.html('<table></table>').find('table');
    $(cur_table).bootstrapTable({
        url: clientUrl + '/list',
        method: 'get',
        clickToSelect: true,
        uniqueId: "id",
        striped : true, // 设置为true会有隔行变色效果
        dataType : "json", // 服务器返回的数据类型
        pagination : true,
        pageSize: 10,// 如果设置了分页，每页数据条数
        pageNumber : 1, // 如果设置了分布，首页页码
        sidePagination : "server", // 设置在哪里进行分页，可选值为"client" 或者 "server"
        queryParams : function(params) {
            return {
                //说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
                limit : params.limit,
                offset : params.offset,
                empId : empId
            };
        },
        columns: [{
            field : 'username',
            title : '姓名'
        }, {
            field: 'sex',
            title: '性别'
        },{
            field: 'mobileInland',
            title: '国内手机号'
        }, {
            field: 'mobileForeign',
            title: '国外手机号'
        },{
            field: 'email',
            title: '邮箱'
        },{
            field: 'wechar',
            title: '微信'
        },{
            field: 'clientStatus',
            title: '状态'
        },{
            field: 'intention',
            title: '意向'
        },{
            title : '操作',
            field : 'operation',
            align : 'center',
            formatter : function(value, row, index) {
                var d = '<a class="btn btn-warning btn-sm" href="#" title="解除关联"  mce_href="#" onclick="removeRef(\''
                    + row.clientId
                    + '\')">解除关联</a> ';

                return d;
            }
        } ]

    });
};

function removeRef(id){
	layer.confirm('确定要解除关联？', {
		btn : [ '确定', '取消' ]
	}, function() {
		$.ajax({
			url : "/sys/emp/remove",
			type : "post",
			data : {
				'id' : id
			},
			success : function(r) {
				if (r.code == 0) {
					layer.msg(r.msg);
					reLoad();
				} else {
					layer.msg(r.msg);
				}
			}
		});
	})
}
//查询
function reLoad() {
	$('#exampleTable').bootstrapTable('refresh');
}
//回车搜索
function getKey(){  
	reLoad();     
} 