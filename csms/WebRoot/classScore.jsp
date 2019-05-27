<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="layui/css/layui.css" rel="stylesheet" type="text/css" />
    <style>
        .text-center {
            text-align: center;
        }
    </style>
    <title>Document</title>
</head>

<body>
    <div class="layui-container">
        <div calss="layui-card">
            <div class="layui-card-header layui-bg-gray text-center" style="height: 80px;">
                <div class="layui-row">
                    <h1>班级成绩查看页面</h1>
                </div>
            </div>
            <div class="layui-card-body">
                <div class="layui-row layui-form">
                    <div class="layui-inline">
                        <div class="layui-input-inline">
                            <select name="modules" lay-verify="required" lay-search>
                                            <option value="">选择或输入学院名称</option>
                                            <option value="1">信息工程学院</option>
                                            <option value="2">人文学院</option>
                                            <option value="3">建筑工程学院</option>
                                        </select>
                        </div>
                    </div>
                    <div class="layui-inline">
                        <div class="layui-input-inline">
                            <select name="modules" lay-verify="required" lay-search>
                                    <option value="">选择或输入专业名称</option>
                                    <option value="1">计算机科学与技术</option>
                                    <option value="2">软件工程</option>
                                    <option value="3">计算机网络</option>
                                </select>
                        </div>
                    </div>
                    <div class="layui-inline">
                        <div class="layui-input-inline">
                            <select name="modules" lay-verify="required" lay-search>
                                    <option value="">选择或输入班级名称</option>
                                    <option value="1">2016计算机科学与技术2班</option>
                                    <option value="2">2017软件工程1班</option>
                                    <option value="3">2016计算机网络1班</option>
                                </select>
                        </div>
                    </div>
                </div>
                <div class="layui-row">
                    <table class="layui-table" id="scoretable" lay-filter="demo"></table>
                </div>
            </div>
        </div>
    </div>
    <%@include file="footer.jsp" %>
</body>
<script src="layui/layui.all.js"></script>
<script src="js/jquery-2.1.1.min.js" charset="utf-8"></script>
<script id="barDemo" type="text/html">
    <button class="layui-btn layui-btn-sm layui-bg-green query">查看详情</button>
</script>
<script type="text/javascript">
    layui.use(['table', 'laydate', 'layer', 'jquery'], function() {
        var table = layui.table;
        var $ = layui.jquery;
        var laydate = layui.laydate;
        var layer = layui.layer;

        table.render({
            elem: '#scoretable',
            height: '800px', //高度最大化减去差值,
            url: 'getscore.action?op=class',
            page: true,
            even: true,
            limit:5,
            limits:[5,10,15],
            skin: "nob",
            cellMinWidth: 35, //全局定义常规单元格的最小宽度，layui 2.2.1 新增
                //,toolbar: '#toolbarDemo'
            title: '用户数据表',
            cols: [
                [{
                	align:'center',
                    field: '',
                    width: 100,
                    title: '序号',
                    type:'numbers'
                }, {
                	align:'center',
                    field: 'collegename',
                    width: 150,
                    title: '学院名称',
                }, {
                	align:'center',
                    field: 'majorname',
                    width: 250,
                    title: '专业名称',
                }, {
                    field: 'classname',
                    title: '班级名称',
                    width: 250,
                },{
                	align:'center',
                    field: 'scorenumber',
                    title: '班级成绩',
                    width: 100
                },{
                	align:'center',
                    field: '',
                    title: '操作',
                    width: 120,
					toolbar:'#barDemo'
                },{
                    field: 'classid',
                    title: '班级id',
                    hide:true
                }]
            ]
        });
    });
    //查看详情点击事件
    $(document).on('click', ".query", function() {
	    var classid = $(this).parent().parent().next().children().text().trim();
		window.location.href="getscore.action?op=classdetail&classid="+classid;
	});
</script>
</html>