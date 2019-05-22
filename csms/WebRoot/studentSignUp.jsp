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
            <table class="layui-hide" id="test"></table>
            <button class="layui-btn">确认报名</button>
        </div>
    </div>
</body>
<script src="layui/layui.js"></script>
<script>
    layui.use('table', function () {
        var table = layui.table;

        table.render({
            elem: '#test'
            , url: '/demo/table/user/'
            , cols: [[
                { type: 'checkbox' }
                , { field: 'id', minWidth: 100, title: '学号' }
                , { field: 'username', minWidth: 200, title: '姓名' }
                , { field: 'sex', minWidth: 100, title: '性别' }
                , { field: 'city', minWidth: 200, title: '班级' }
                , { field: 'city', minWidth: 200, title: '学院' }
            ]]
            , page: true
        });
    });
</script>

</html>