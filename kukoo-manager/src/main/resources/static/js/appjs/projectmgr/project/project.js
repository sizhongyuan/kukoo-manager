//一级项目Url
var projectUrl = "/projectmgr/project";
//二级项目Url
var subProjectUrl = "/projectmgr/subproject";
$(function() {
    load();
});
function load() {
    $('#exampleTable').bootstrapTable('destroy').bootstrapTable(
            {
                method : 'get', // 服务器数据的请求方式 get or post
                url : projectUrl + "/list", // 服务器数据的加载地址
                //	showRefresh : true,
                //	showToggle : true,
                //	showColumns : true,
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
                detailView: true,//父子表
                pageSize : 10, // 如果设置了分页，每页数据条数
                pageNumber : 1, // 如果设置了分布，首页页码
                pageList: [10, 25],
                //search : true, // 是否显示搜索框
                showColumns : false, // 是否显示内容下拉框（选择显示的列）
                sidePagination : "server", // 设置在哪里进行分页，可选值为"client" 或者 "server"
                queryParams : function(params) {
                    return {
                        //说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
                        limit : params.limit,
                        offset : params.offset,
                        projectName:$('#searchName').val()
                        // username:$('#searchName').val()
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
                        field : 'id',
                        title : '一级项目Id'
                    },

                    {
                        field : 'projectName',
                        title : '一级项目名称'
                        // ,
                        // formatter: function(value,row,index){
                        //     return '<a href="#" onclick="edit(\''+row.id+'\')">'+row.projectName+'</a>';
                        // }
                    },
                    {
                        field : 'country',
                        title : '国家'
                    },
                    {
                        field : 'projectType',
                        title : '项目类别'
                    },
                    {
                        field : 'immigrationMode',
                        title : '移民方式'
                    },
                    {
                        field : 'ifOpen',
                        title : '开放情况'
                    },
                    {
                        title : '操作',
                        field : 'operation',
                        align : 'center',
                        formatter : function(value, row, index) {
                            var a = '<a class="btn btn-primary btn-sm ' + sub_new_h + '" href="#" mce_href="#" title="二级项目新增" onclick="subAdd(\''
                                + row.id
                                + '\')"><i class="fa fa-plus"></i></a> ';
                            var e = '<a class="btn btn-primary btn-sm ' + s_edit_h + '" href="#" mce_href="#" title="编辑" onclick="edit(\''
                                + row.id
                                + '\')"><i class="fa fa-edit"></i></a> ';
                            var d = '<a class="btn btn-warning btn-sm ' + s_remove_h + '" href="#" title="删除"  mce_href="#" onclick="remove(\''
                                + row.id
                                + '\')"><i class="fa fa-remove"></i></a> ';

                            return a + e + d;
                        }
                    } ],
                //注册加载子表的事件。注意下这里的三个参数！
                onExpandRow: function (index, row, $detail) {
                    initSubTable(index, row, $detail);
                }
            });
}

//初始化二级项目列表
function initSubTable (index, row, $detail) {
    var projectId = row.id;
    var cur_table = $detail.html('<table></table>').find('table');
    $(cur_table).bootstrapTable({
        url: subProjectUrl + '/list',
        method: 'get',
        // ajaxOptions: { projectId: projectId },
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
                projectId : projectId
                // username:$('#searchName').val()
            };
        },
        columns: [{
            field : 'id',
            title : '二级项目编号'
        }, {
            field: 'subProjectName',
            title: '二级项目名称'
        }, {
            field: 'quota',
            title: '配额情况'
        }, {
            field: 'ifQuota',
            title: '是否抢名额'
        },{
            field: 'status',
            title: '项目状态'
        },{
            field : 'id',
            title : '时间轴模板',
            formatter: function(value,row,index){
                return '<a href="#" onclick="openTimeline(\''+row.id+'\')">'+'查看模板'+'</a>';
            }
        },{
            title : '操作',
            field : 'operation',
            align : 'center',
            formatter : function(value, row, index) {
                var e = '<a class="btn btn-primary btn-sm ' + sub_edit_h + '" href="#" mce_href="#" title="编辑" onclick="subEdit(\''
                    + row.id
                    + '\')"><i class="fa fa-edit"></i></a> ';
                var d = '<a class="btn btn-warning btn-sm ' + sub_remove_h + '" href="#" title="删除"  mce_href="#" onclick="subRemove(\''
                    + row.id
                    + '\')"><i class="fa fa-remove"></i></a> ';

                return e + d;
            }
        } ]

    });
};


function reLoad() {
    $('#exampleTable').bootstrapTable('refresh');
}

function add() {
    var fullOpen = layer.open({
        type : 2,
        title : '增加',
        maxmin : true,
        shadeClose : false, // 点击遮罩关闭层
        area : [ '800px', '520px' ],
        content : projectUrl + '/add' // iframe的url
    });
    layer.full(fullOpen);
}
function edit(id) {
    var fullOpen = layer.open({
        type : 2,
        title : '编辑',
        maxmin : true,
        shadeClose : false, // 点击遮罩关闭层
        area : [ '800px', '520px' ],
        content : projectUrl + '/edit/' + id // iframe的url
    });
    layer.full(fullOpen);
}
function remove(id) {
    layer.confirm('确定要删除选中的记录？', {
        btn : [ '确定', '取消' ]
    }, function() {
        $.ajax({
            url : projectUrl + "/remove",
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

//二级项目打开新增页面
function subAdd(projectId){
    var fullOpen = layer.open({
        type : 2,
        title : '增加',
        maxmin : true,
        shadeClose : false, // 点击遮罩关闭层
        area : [ '800px', '520px' ],
        content : subProjectUrl + '/add/' + projectId // iframe的url
    });
    layer.full(fullOpen);
}
function subEdit(id) {
    var fullOpen = layer.open({
        type : 2,
        title : '编辑',
        maxmin : true,
        shadeClose : false, // 点击遮罩关闭层
        area : [ '800px', '520px' ],
        content : subProjectUrl + '/edit/' + id // iframe的url
    });
    layer.full(fullOpen);
}
function subRemove(id) {
    layer.confirm('确定要删除选中的记录？', {
        btn : [ '确定', '取消' ]
    }, function() {
        $.ajax({
            url : subProjectUrl + "/remove",
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
function openTimeline(id){
    var fullOpen = layer.open({
        type : 2,
        title : '查看时间轴模板',
        maxmin : true,
        shadeClose : false, // 点击遮罩关闭层
        area : [ '800px', '520px' ],
        content : '/timeline/temp/'+ id // iframe的url
    });
    layer.full(fullOpen);
}
