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
                    <table class="layui-table" id="scoretable">

                    </table>
                </div>
            </div>
        </div>
    </div>
    <%@include file="footer.jsp" %>
</body>
<script src="layui/layui.all.js"></script>
<script id="barDemo" type="text/html">
    <button class="layui-btn  layui-btn-sm layui-bg-green">查看详情</button>
</script>
<script type="text/javascript">
    layui.use(['table', 'laydate', 'form', 'jquery'], function() {
        var table = layui.table;
        var $ = layui.jquery;
        var laydate = layui.laydate;
        var form = layui.form;

        table.render({
            elem: '#scoretable',
            height: '800px', //高度最大化减去差值,
            url: 'getclass.action',
            page: true //开启分页
                ,
            even: true //每行颜色分隔
                ,
                limit:2,
                limits:[2,3,5,7],
            skin: "nob",
            cellMinWidth: 35 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
                //,toolbar: '#toolbarDemo'
                ,
            title: '用户数据表',
            cols: [
                [{
                    field: '',
                    width: 35,
                    title: '序号',
                    type:numbers,
                }, {
                    field: '',
                    width: 250,
                    title: '',
                    templet: function(d) {
                        return d.collegename
                    }
                }, {
                    field: '',
                    width: 250,
                    title: '',
                    templet: function(d) {
                        return d.majorname
                    }
                }, {
                    field: 'd.classname',
                    title: '',
                    width: 250,
                    sort: true
                }, {
                    fixed: 'right',
                    title: '操作',
                    toolbar: '#barDemo',
                    width: 120
                }]
            ]
        });

        //监听工具条
        table.on('tool(test)', function(obj) {
            var data = obj.data;
            if (obj.event === 'edit') {
                layer.alert('编辑行：<br>' + JSON.stringify(data))
            } else if (obj.event === 'del') {
                layer.confirm('真的删除行么', function(index) {
                    obj.del();
                    layer.close(index);
                });
            }
        });

    });
</script>
</html>