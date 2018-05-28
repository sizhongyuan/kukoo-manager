
var prefix = "/consult"
$(function() {
	load();
});

function load() {
	$('#exampleTable')
		.bootstrapTable(
			{
				id : 'id',
				code : 'id',
				parentCode : 'parentId',
				method : 'get', // 服务器数据的请求方式 get or post
				url : prefix + "/list", // 服务器数据的加载地址
				//	showRefresh : true,
				//	showToggle : true,
				//	showColumns : true,
				iconSize : 'outline',
				toolbar : '#exampleToolbar',
				ajaxParams : {}, // 请求数据的ajax的data属性
				expandColumn : '2', // 在哪一列上面显示展开按钮
				expandAll : false, // 是否全部展开
				detailView: true,//父子表
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
				//search : true, // 是否显示搜索框
				showColumns : false, // 是否显示内容下拉框（选择显示的列）
				sidePagination : "server", // 设置在哪里进行分页，可选值为"client" 或者 "server"
				queryParams : function(params) {
					return {
						//说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
						limit : params.limit,
						offset : params.offset,
						userId:$('#searchName').val(),
					    userName:$('#searchName').val(),
						userTelephone:$('#searchName').val()
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
						visible :false,
						field : 'id',
						title : '编号'
					},

					{
						field : 'userId',
						title : '用户ID',
						valign : 'center',
						witth :20
					},
					{
						field : 'userName',
						title : '用户名',
						align : 'center',
						valign : 'center',
					},
					{
						field : 'userTelephone',
						title : '手机',
						align : 'center',
						valign : 'center',
					},
					//{
					//	field : 'adviser',
					//	title : '顾问',
					//	align : 'center',
					//	valign : 'center',
					//},
					//{
					//	field : 'createTime',
					//	title : '咨询时间',
					//	align : 'center',
					//	valign : 'center',
					//},
					//{
					//	field : 'consultRecord',
					//	title : '咨询记录',
					//	align : 'center',
					//	valign : 'center',
					//},
					//{
					//	field : 'consultResult',
					//	title : '咨询结果',
					//	align : 'center',
					//	valign : 'center',
					//},
					{
						visible : false,
						field : 'delFlag',
						title : '删除标记'
					},
					{
						title : '操作',
						field : 'operation',
						align : 'center',
						formatter : function(value, row, index) {
							var e = '<a class="btn btn-primary btn-sm ' + s_edit_h + '" href="#" mce_href="#" title="编辑" onclick="edit(\''
								+ row.id
								+ '\')"><i class="fa fa-edit"></i></a> ';
							var a = '<a class="btn btn-primary btn-sm ' + s_add_h + '" href="#" title="增加下級"  mce_href="#" onclick="add(\''
								+ row.id
								+ '\')"><i class="fa fa-plus"></i></a> ';
							var d = '<a class="btn btn-warning btn-sm ' + s_remove_h + '" href="#" title="删除"  mce_href="#" onclick="remove(\''
								+ row.id
								+ '\')"><i class="fa fa-remove"></i></a> ';
							var f = '<a class="btn btn-success btn-sm" href="#" title="备用"  mce_href="#" onclick="resetPwd(\''
								+ row.id
								+ '\')"><i class="fa fa-key"></i></a> ';
							return a + d;
						}
					} ],
				//注册加载子表的事件。注意下这里的三个参数！
				onExpandRow: function (index, row, $detail) {
					//alert(index+"--"+row.id+"--"+$detail);
					InitSubTable(index, row, $detail);
				}
			});
}
function reLoad() {
	$('#exampleTable').bootstrapTable('refresh');
}
function add(id) {
	layer.open({
		type : 2,
		title : '增加',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '800px', '520px' ],
		content : prefix + '/add/'+id // iframe的url
	});
}
function addConsultUser() {
	layer.open({
		type : 2,
		title : '增加',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '800px', '520px' ],
		content : prefix + '/addConsultUser' // iframe的url
	});
}
function registerUser() {
	layer.open({
		type : 2,
		title : '快速注册账号',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '800px', '520px' ],
		content : '/sys/user/add/' // iframe的url
	});
}

function edit(id) {
	layer.open({
		type : 2,
		title : '编辑',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '800px', '520px' ],
		content : prefix + '/edit/' + id // iframe的url
	});
}
function remove(id) {
	layer.confirm('确定要删除选中的记录？', {
		btn : [ '确定', '取消' ]
	}, function() {
		$.ajax({
			url : prefix + "/remove",
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

function resetPwd(id) {
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
			ids[i] = row['id'];
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

//下面就是子表的结构 初始化
var $child_table;
window.InitSubTable = function (index, row, $detail) {
	var parentId = row.id;
	//alert(parentId);
	var cur_table = $detail.html('<table></table>').find('table');
	$(cur_table).bootstrapTable({
		url : prefix + "/sublist/"+parentId, // 服务器数据的加载地址
		method: 'get',
		//queryParams: { parentId: parentId },
		//queryParams : function(params) {
		//	return {
		//		//说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
		//		//limit : params.limit,
		//		//offset : params.offset,
		//		parentId: parentId
		//		// name:$('#searchName').val(),
		//		// username:$('#searchName').val()
		//	};
		//},
		//ajaxOptions: { parentId: parentId },
		clickToSelect: true,
		//detailView: true,//父子表
		uniqueId: "id",
		pageSize: 10,
		pageList: [10, 25],
		columns: [
		//	{
		//	checkbox: true
		//},
			{
			field: 'adviser',
			title: '顾问'
		}, {
			field: 'createTime',
			title: '咨询时间'
		}, {
			field: 'consultRecord',
			title: '咨询记录'
		}, {
			field: 'consultResult',
			title: '咨询结果'
		},{
			title : '操作',
			field : 'operation',
			align : 'center',
			formatter : function(value, row, index) {
				var e = '<a class="btn btn-primary btn-sm ' + s_edit_h + '" href="#" mce_href="#" title="编辑" onclick="edit(\''
					+ row.id
					+ '\')"><i class="fa fa-edit"></i></a> ';
				var a = '<a class="btn btn-primary btn-sm ' + s_add_h + '" href="#" title="增加下級"  mce_href="#" onclick="add(\''
					+ row.id
					+ '\')"><i class="fa fa-plus"></i></a> ';
				var d = '<a class="btn btn-warning btn-sm ' + s_remove_h + '" href="#" title="删除"  mce_href="#" onclick="remove(\''
					+ row.id
					+ '\')"><i class="fa fa-remove"></i></a> ';
				var f = '<a class="btn btn-success btn-sm" href="#" title="备用"  mce_href="#" onclick="resetPwd(\''
					+ row.id
					+ '\')"><i class="fa fa-key"></i></a> ';
				return e + d;
			}
		} ]

	});
};