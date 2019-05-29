<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>学院成绩查看页面</title>
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
                    <div id="college">
                        <select name="modules" lay-verify="required" v-for="obj in collist" lay-search>
                                <option value="{{obj.collegeid}}">{{obj.collegename}}</option>
                            </select>
                            </div>
                    </div>
                    <!-- <div class="layui-input-inline">
                        <input class="layui-input" type="text" placeholder="请输入学院名称" />
                    </div>
                    <div class="layui-input-inline">
                        <button class="layui-btn">查询</button>
                    </div> -->
                </div>
                <div class="layui-row">
                	<table class="layui-table" id="scoretable" lay-filter="demo"></table>
                    <%-- <table class="layui-table">
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
                    </table> --%>
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
            url: 'getscore.action?op=college',
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
                },{
                	align:'center',
                    field: 'scorenumber',
                    title: '平均成绩',
                    width: 100
                },{
                	align:'center',
                    field: '',
                    title: '操作',
                    width: 120,
					toolbar:'#barDemo'
                },{
                    field: 'collegeid',
                    title: '学院id',
                    hide:true
                }]
            ]
        });
    });
    //查看详情点击事件
    $(document).on('click', ".query", function() {
	    var collegeid = $(this).parent().parent().next().children().text().trim();
		window.location.href="getscore.action?op=collegedetail&collegeid="+collegeid;
	});
</script>
</html>