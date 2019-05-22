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
                    <h1>学院成绩查看页面</h1>
                </div>
            </div>
            <div class="layui-card-body">
                <div class="layui-row layui-form">
                    <div class="layui-input-inline">
                        <select name="modules" lay-verify="required" lay-search>
                                <option value="">选择或输入学院名称</option>
                                <option value="1">信息工程学院</option>
                                <option value="2">人文学院</option>
                                <option value="3">建筑工程学院</option>
                            </select>
                    </div>
                    <!-- <div class="layui-input-inline">
                        <input class="layui-input" type="text" placeholder="请输入学院名称" />
                    </div>
                    <div class="layui-input-inline">
                        <button class="layui-btn">查询</button>
                    </div> -->
                </div>
                <div class="layui-row">
                    <table class="layui-table">
                        <thead>
                            <!--<th class="text-center"><input type="checkbox"
								class="js-checkbox-all" /></th>-->
                            <th class="text-center">
                                <nobr>序号</nobr>
                            </th>
                            <th class="text-center">
                                <nobr>学院名称</nobr>
                            </th>
                            <th class="text-center">
                                <nobr>平均成绩</nobr>
                            </th>
                            <th class="text-center">
                                <nobr>操作</nobr>
                            </th>
                        </thead>
                        <tbody id="scoretable_tbody">
                            <c:forEach items="" var="obj" varStatus="xh">
                                <tr>
                                    <!-- <td class="text-center"><input type="checkbox" /></td> -->
                                    <td class="text-center">
                                        <nobr>1</nobr>
                                    </td>
                                    <td class="text-center">
                                        <nobr>信息工程学院</nobr>
                                    </td>
                                    <td class="text-center">
                                        <nobr>99</nobr>
                                    </td>
                                    <td class="text-center">
                                        <button class="layui-btn layui-btn-sm layui-bg-green">查看详情</button>
                                    </td>
                                </tr>
                                <tr>
                                    <!-- <td class="text-center"><input type="checkbox" /></td> -->
                                    <td class="text-center">
                                        <nobr>2</nobr>
                                    </td>
                                    <td class="text-center">
                                        <nobr>信息工程学院</nobr>
                                    </td>
                                    <td class="text-center">
                                        <nobr>99</nobr>
                                    </td>
                                    <td class="text-center">
                                        <button class="layui-btn layui-btn-sm layui-bg-green">查看详情</button>
                                    </td>
                                </tr>
                                <tr>
                                    <!-- <td class="text-center"><input type="checkbox" /></td> -->
                                    <td class="text-center">
                                        <nobr>2</nobr>
                                    </td>
                                    <td class="text-center">
                                        <nobr>信息工程学院</nobr>
                                    </td>
                                    <td class="text-center">
                                        <nobr>99</nobr>
                                    </td>
                                    <td class="text-center">
                                        <button class="layui-btn layui-btn-sm layui-bg-green">查看详情</button>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</body>
<script src="layui/layui.all.js"></script>

</html>