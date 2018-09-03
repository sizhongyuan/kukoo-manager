var prefix = "/sys/client"
$(function() {
	var deptId = '';
	//getTreeData();
	load(deptId);
	loadRole();
});

function load(deptId) {
	$('#exampleTable')
		.bootstrapTable(
			{
				method : 'get', // 服务器数据的请求方式 get or post
				url : prefix + "/list", // 服务器数据的加载地址
				// showRefresh : true,
				// showToggle : true,
				// showColumns : true,
				iconSize : 'outline',
				toolbar : '#exampleToolbar',
				striped : true, // 设置为true会有隔行变色效果
				dataType : "json", // 服务器返回的数据类型
				pagination : true, // 设置为true会在底部显示分页条
				// queryParamsType : "limit",
				// //设置为limit则会发送符合RESTFull格式的参数
				singleSelect : false, // 设置为true将禁止多选
				// contentType : "application/x-www-form-urlencoded",
				// //发送到服务器的数据编码类型
				pageSize : 10, // 如果设置了分页，每页数据条数
				pageNumber : 1, // 如果设置了分布，首页页码
				// search : true, // 是否显示搜索框
				showColumns : false, // 是否显示内容下拉框（选择显示的列）
				sidePagination : "server", // 设置在哪里进行分页，可选值为"client" 或者
				// "server"
				queryParams : function(params) {
					return {
						// 说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
						limit : params.limit,
						offset : params.offset,
						searchCondition : $('#searchCondition').val(),
//						role : $('#roleId').val(),
//						deptId : deptId
					};
				},
				// //请求服务器数据时，你可以通过重写参数的方式添加一些额外的参数，例如 toolbar 中的参数 如果
				// queryParamsType = 'limit' ,返回参数必须包含
				// limit, offset, search, sort, order 否则, 需要包含:
				// pageSize, pageNumber, searchText, sortName,
				// sortOrder.
				// 返回false将会终止请求
				columns : [
					{
						checkbox : true
					},
					{
						field : 'clientPhoto', // 列字段名
						title : '头像', // 列标题
						align : 'center',
						formatter:function(value,row,index){
							var url = row.clientPhoto;
							var s = '<a class = "view"  href="javascript:void(0)" onclick="detail(\''
								+ row.clientId
								+ '\')"><img style="width:20px;height:20px;border-radius:20px;"  src="/img/user.png" /></a>';
							return s;
						}
					},
//					{
//						field : 'userId', // 列字段名
//						title : '序号' // 列标题
//					},
					{
						field : 'cnname',
						title : '中文姓名',
						formatter:function(value,row,index){
							var url = row.cnname;
							var s = '<a class = "view"  href="javascript:void(0)" onclick="detail(\''
								+ row.clientId
								+ '\')">'+row.cnname+'</a>';
							return s;
						}
					},
					{
						field : 'enname',
						title : '英文姓名',
//						formatter:function(value,row,index){
//							var url = row.cnname;
//							var s = '<a class = "view"  href="javascript:void(0)" onclick="detail(\''
//								+ row.clientId
//								+ '\')">'+row.enname+'</a>';
//							return s;
//						}
					},
					{
						field : 'registTime',
						title : '注册时间'
					},
					{
						field : 'mobileInland',
						title : '国内手机号码'
					},
					{
						field : 'mobileForeign',
						title : '国外手机号码'
					},
					{
						field : 'email',
						title : '邮箱'
					},
					{
						field : 'clientStatus',
						title : '状态',
						align : 'center',
						formatter : function(value, row, index) {
							if (value == '终止') {
								return '<span class="label label-warning">终止</span>';
							} else if (value == '完成') {
								return '<span class="label label-primary">完成</span>';
							} else if (value == '签约') {
								return '<span class="label label-danger">签约</span>';
							} else if (value == '签约（未付款）') {
								return '<span class="label label-primary">签约（未付款）</span>';
							} else if (value == '评估') {
								return '<span class="label label-warning">评估</span>';
							} else if (value == '注册') {
								return '<span class="label label-primary">注册</span>';
							}
						}
					},
					{
						field : 'intention',
						title : '意向',
						/*formatter : function(value, row, index) {
							if (value == '4') {
								return '<span class="label label-primary">保密</span>';
							} else if (value == '3') {
								return '<span class="label label-primary">已移民</span>';
							} else if (value == '2') {
								return '<span class="label label-primary">申请中</span>';
							} else if (value == '1') {
								return '<span class="label label-primary">想移民</span>';
							}
						}*/
					},
					{
						field : 'nickname',
						title : '昵称',
//						formatter : function(value, row, index) {
//							return '<a href="">'+value+'</a>';
//						}
					},
					{
						field : 'spouse',
						title : '配偶',
//						formatter : function(value, row, index) {
//							return '<a href="">spouse</a>';
//						}
					},
					{
						field : 'advisoryTime',
						title : '咨询日期'
					},
					{
						title : '操作',
						field : 'clientId',
						align : 'center',
						formatter : function(value, row, index) {
							var e = '<a  class="btn btn-primary btn-sm ' + s_edit_h + '" href="#" mce_href="#" title="编辑" onclick="edit(\''
								+ row.clientId
								+ '\')"><i class="fa fa-edit "></i></a> ';
							var d = '<a class="btn btn-warning btn-sm ' + s_remove_h + '" href="#" title="删除"  mce_href="#" onclick="remove(\''
								+ row.clientId
								+ '\')"><i class="fa fa-remove"></i></a> ';
							var f = '<a class="btn btn-success btn-sm ' + s_resetPwd_h + '" href="#" title="重置密码"  mce_href="#" onclick="resetPwd(\''
								+ row.clientId
								+ '\')"><i class="fa fa-key"></i></a> ';
							return e + d + f;
						}
					} ]
			});
}
//查询
function reLoad() {
	$('#exampleTable').bootstrapTable('refresh');
}
//回车搜索
function getKey(){  
	reLoad();     
} 

//var layerIndex;
//var layerInitWidth;
//var layerInitHeight;
//function add() {
//	// iframe层
//	layer.open({
//		type : 2,
//		title : '增加用户',
//		maxmin : true,
//		shadeClose : false, // 点击遮罩关闭层
//		area : [ '100%','100%'],
//		content : prefix + '/add',
//		success:function(layero,index){
//			layer.full(index);
//			//获取当前弹出窗口的索引及初始大小
//            layerIndex      = index;
//            layerInitWidth  = $("#layui-layer"+layerIndex).width();
//            layerInitHeight = $("#layui-layer"+layerIndex).height();
//            //utils.resizeLayer(layerIndex,layerInitWidth,layerInitHeight);
//            form.render(null, 'form-edit');
//		}
//	});
//}
function add() {
	// iframe层
	layer.open({
		id : 'addClient',
		type : 2,
		title : '增加客户',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '100%','100%'],
		content : prefix + '/add',
		success:function(layero,index){
			layer.full(index);
		}
	});
}
$(window).resize(function() {
    $('#addUser').parent().css({"width":"100%","height":"100%"});
    $('#editUser').parent().css({"width":"100%","height":"100%"});
    $('#detailUser').parent().css({"width":"100%","height":"100%"});
    $('.chosen-container').css({"width":"100%"});
});
function remove(clientId) {
	layer.confirm('确定要删除选中的记录？', {
		btn : [ '确定', '取消' ]
	}, function() {
		$.ajax({
			url : "/sys/client/remove",
			type : "post",
			data : {
				'clientId' : clientId
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
function edit(id) {
//	layer.open({
//		type : 2,
//		title : '用户修改',
//		maxmin : true,
//		shadeClose : false,
//		area : [ '800px', '520px' ],
//		content : prefix + '/edit/' + id // iframe的url
//	});
	layer.open({
		id : 'editClient',
		type : 2,
		title : '客户修改',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '100%','100%'],
		content : prefix + '/edit/' + id, // iframe的url
		success:function(layero,index){
			layer.full(index);
		}
	});
}
function detail(id) {
	layer.open({
		id : 'detailUser',
		type : 2,
		title : '客户详情',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '100%','100%'],
		content : prefix + '/detail/' + id, // iframe的url
		success:function(layero,index){
			layer.full(index);
		}
	});
}
function resetPwd(id) {
	console.log(id);
	layer.open({
		type : 2,
		title : '重置密码',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '400px', '260px' ],
		content : prefix + '/resetPwd/' + id // iframe的url
	});
}
function batchRemove() {
	var rows = $('#exampleTable').bootstrapTable('getSelections'); // 返回所有选择的行，当没有选择的记录时，返回一个空数组
	if (rows.length == 0) {
		layer.msg("请选择要删除的数据");
		return;
	}
	layer.confirm("确认要删除选中的'" + rows.length + "'条数据吗?", {
		btn : [ '确定', '取消' ]
	// 按钮
	}, function() {
		var ids = new Array();
		// 遍历所有选择的行数据，取每条数据对应的ID
		$.each(rows, function(i, row) {
			ids[i] = row['userId'];
		});
		$.ajax({
			type : 'POST',
			data : {
				"ids" : ids
			},
			url : prefix + '/batchRemove',
			success : function(r) {
				if (r.code == 0) {
					layer.msg(r.msg);
					reLoad();
				} else {
					layer.msg(r.msg);
				}
			}
		});
	}, function() {});
}
function getTreeData() {
	$.ajax({
		type : "GET",
		url : "/system/sysDept/tree",
		success : function(tree) {
			loadTree(tree);
		}
	});
}
function loadTree(tree) {
	$('#jstree').jstree({
		'core' : {
			'data' : tree
		},
		"plugins" : [ "search" ]
	});
	$('#jstree').jstree().open_all();
}
$('#jstree').on("changed.jstree", function(e, data) {
	if (data.selected == -1) {
		var opt = {
			query : {
				deptId : '',
			}
		}
		$('#exampleTable').bootstrapTable('refresh', opt);
	} else {
		var opt = {
			query : {
				deptId : data.selected[0],
			}
		}
		$('#exampleTable').bootstrapTable('refresh',opt);
	}

});

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
			$("#roleId").append(html);
			$("#roleId").chosen({
				maxHeight : 200,
				width : "100%"
			});
			//点击事件
			$('#roleId').on('change', function(e, params) {
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