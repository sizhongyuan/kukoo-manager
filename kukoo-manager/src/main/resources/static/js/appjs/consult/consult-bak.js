
var prefix = "/consult"
$(function() {
	load();
});

function load() {
	$('#exampleTable')
		.bootstrapTreeTable(
			{
				id : 'id',
				code : 'id',
				type : "GET", // 请求数据的ajax类型
				url : prefix + '/list', // 请求数据的ajax的url
				ajaxParams : {}, // 请求数据的ajax的data属性
				expandColumn : '1', // 在哪一列上面显示展开按钮
				striped : true, // 是否各行渐变色
				bordered : true, // 是否显示边框
				expandAll : false, // 是否全部展开
				pagination : true, // 设置为true会在底部显示分页条
				// queryParamsType : "limit",
				// //设置为limit则会发送符合RESTFull格式的参数
				singleSelect : false, // 设置为true将禁止多选
				pageSize : 10, // 如果设置了分页，每页数据条数
				pageNumber : 1, // 如果设置了分布，首页页码
				search : true, // 是否显示搜索框
				showColumns : true, // 是否显示内容下拉框（选择显示的列）
				sidePagination : "client", // 设置在哪里进行分页，可选值为"client" 或者
				// toolbar : '#exampleToolbar',
				columns : [
					{ // 列配置项
						// 数据类型，详细参数配置参见文档http://bootstrap-table.wenzhixin.net.cn/zh-cn/documentation/
						checkbox : true
						// 列表中显示复选框
					},
					{
						title : '编号',
						field : 'id',
						visible :false
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
					{
						field : 'adviser',
						title : '顾问',
						align : 'center',
						valign : 'center',
					},
					{
						field : 'createTime',
						title : '咨询时间',
						align : 'center',
						valign : 'center',
					},
					{
						field : 'consultRecord',
						title : '咨询记录',
						align : 'center',
						valign : 'center',
					},
					{
						field : 'consultResult',
						title : '咨询结果',
						align : 'center',
						valign : 'center',
					},
					//{
					//	field : 'delFlag',
					//	title : '状态',
					//	align : 'center',
                     //   valign : 'center',
					//	formatter : function(item, index) {
					//		if (item.delFlag == '0') {
					//			return '<span class="label label-danger">禁用</span>';
					//		} else if (item.delFlag == '1') {
					//			return '<span class="label label-primary">正常</span>';
					//		}
					//	}
					//},
					{
						title : '操作',
						field : 'id',
						align : 'center',
                        valign : 'center',
						formatter : function(item, index) {
							var e = '<a class="btn btn-primary btn-sm ' + s_edit_h + '" href="#" mce_href="#" title="编辑" onclick="edit(\''
								+ item.id
								+ '\')"><i class="fa fa-edit"></i></a> ';
							var a = '<a class="btn btn-primary btn-sm ' + s_add_h + '" href="#" title="增加下級"  mce_href="#" onclick="add(\''
								+ item.id
								+ '\')"><i class="fa fa-plus"></i></a> ';
							var d = '<a class="btn btn-warning btn-sm ' + s_remove_h + '" href="#" title="删除"  mce_href="#" onclick="removeone(\''
								+ item.id
								+ '\')"><i class="fa fa-remove"></i></a> ';
							var f = '<a class="btn btn-success btn-sm＂ href="#" title="备用"  mce_href="#" onclick="resetPwd(\''
								+ item.id
								+ '\')"><i class="fa fa-key"></i></a> ';
							return e + a + d;
						}
					} ]
			});
}
function reLoad() {
	load();
}
function add(pId) {
	layer.open({
		type : 2,
		title : '增加',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '800px', '520px' ],
		content : prefix + '/add/' + pId
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
function removeone(id) {
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

