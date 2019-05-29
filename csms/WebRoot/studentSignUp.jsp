<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>学生报名</title>
    <link rel="stylesheet" href="layui/css/layui.css">
    <style>
        table {
            text-align: center;
        }
    </style>
</head>

<body>
    <div class="layui-card">
        <div class="layui-card-header">
            <h2>学生报名</h2>
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
            <table class="layui-table" id="userlist" lay-filter="test" width="100%"></table>
            <button class="layui-btn">确认报名</button>
        </div>
    </div>
    <%@include file="footer.jsp" %>
</body>
<script src="layui/layui.js"></script>
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
            elem: '#userlist',
            height: 500,
            url: 'entry.action', //数据接口
            cols: [
                [ //表头
                	{ type: 'checkbox' },
                    {
                        field: 'userid',
                        title: '学号/工号',
                        width: 100,
                    },{
                    	field: 'username',
                        title: '姓名',
                        width: 100,
                        hide:true,
                    },
                     {
                        field: 'agend',
                        title: '性别',
                        width: 70
                    }, {
                        field: 'collegename',
                        title: '学院',
                        width: 150
                        //sort: true //是否排序
                    }, {
                        field: '',
                        title: '班级',
                        width: 200,
						templet:function(data){
							if(data.classname == ""||data.classname==null){
								return "";
							}else{
								return data.classname;
							}
						}
                    }
                ]
            ],
            page: true, //开启分页
            even: false, //每行颜色分隔
            //skin: 'nob', //无边框
            limit: 10,
            limits: [1, 10, 15,20]
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