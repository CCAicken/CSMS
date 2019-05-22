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
            <h2>標題</h2>
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
            <table class="layui-table">
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
            </table>
        </div>
    </div>
</body>
<script src="layui/layui.js"></script>

</html>