<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>文章内容</title>
    <link rel="stylesheet" href="layui/css/layui.css">
    <style>
        /* table{
            text-align: center;
        } */
    </style>
</head>

<body>
    <div class="layui-card">
        <div class="layui-card-header">
            <h2>标题</h2>
        </div>
        <div class="layui-card-body">
            <div class="layui-form-item">
                <div class="layui-input-inline">
                    <input type="password" name="password" required lay-verify="required" placeholder="请输入查询条件"
                        autocomplete="off" class="layui-input">
                </div>
                <div class="layui-input-inline" style="margin-left: -10px;">
                    <button type="button" class="layui-btn layui-btn">查询</button>
                </div>
            </div>
            <table class="layui-table" id="projectlist" lay-filter="test" width="100%"></table>
            <!-- <table class="layui-table">
                <colgroup>
                    <col width="70">
                    <col width="200">
                    <col width="150">
                    <col width="150">
                    <col width="150">
                    <col width="150">
                </colgroup>
                <thead>
                    <tr>
                        <th>序号</th>
                        <th>项目名称</th>
                        <th>当前报名人数</th>
                        <th>人数限制</th>
                        <th>项目类型</th>
                        <th>操作</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>1</td>
                        <td>1000米</td>
                        <td>5</td>
                        <td>8</td>
                        <td>学生个人赛</td>
                        <td>
                            <button type="button" 	class="layui-btn layui-btn-xs">报名</button>
                        </td>
                    </tr>
                    <tr>
                            <td>2</td>
                            <td>三级跳</td>
                            <td>5</td>
                            <td>8</td>
                            <td>学生个人赛</td>
                            <td>
                                <button type="button" 	class="layui-btn layui-btn-xs">报名</button>
                            </td>
                        </tr>
                </tbody>
            </table> -->
        </div>
    </div>
    <%@include file="footer.jsp" %>
</body>
<script src="layui/layui.js"></script>
<script src="js/jquery-2.1.1.min.js" charset="utf-8"></script>
<script id="barDemo" type="text/html">
  <button type="button" lay-event="add" class="layui-btn layui-btn-xs">前往报名</button>
</script>
<script>
layui.use(['element', 'carousel', 'table'], function() {
        var element = layui.element;
        var carousel = layui.carousel;
        //导航栏点击
        element.on('nav(filter)', function(elem) {
            console.log(elem); //得到当前点击的DOM对象
        });
        var table = layui.table;
        table.render({
            elem: '#projectlist',
            height: 500,
            url: 'getproject.action', //数据接口
            cols: [
                [ //表头
                    {
                        field: '',
                        title: '序号',
                        width: 100,
                        type:'numbers'
                    }, {
                        field: 'proname',
                        title: '项目名称',
                        width: 300
                    }, {
                        field: '',
                        title: '(当前报名人数/人数限制)',
                        width: 200,
                        templet:function(data){
                         return "<a href=''>("+data.scenelimit+"/"+data.totallimit+")</a>"
                        }
                        //sort: true //是否排序
                    }, {
                        field: 'protype',
                        title: '项目类型',
                        width: 140,
						templet:function(data){
							if(data.protype == 1){
								return "<a href=''>学生个人赛</a>"
							}else if(data.protype == 2){
								return "<a href=''>学生团体赛</a>"
							}else if(data.protype == 3){
								return "<a href=''>教师个人赛</a>"
							}else if(data.protype == 4){
								return "<a href=''>教师团体赛</a>"
							}
						}
                    }, {
                        field: '',
                        title: '操作',
                        width: 140,
                        toolbar: '#barDemo'
                    }
                ]
            ],
            page: true, //开启分页
            even: true, //每行颜色分隔
            skin: 'nob', //无边框
            limit: 10,
            limits: [5, 10, 15]
                /* first:true,
                last:true, */
        });
        //监听工具条
        table.on('tool(demo)', function(obj) {
            var data = obj.data;
            if (obj.event === 'add') {
                layer.alert('报名')
            }
        });
    });
</script>
</html>