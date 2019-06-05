<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
body {
    background-color: rgb(209, 207, 207);
    overflow: hidden;
      overflow-y: scroll;
    
}

body::-webkit-scrollbar {
        display: none;
    }
</style>
<title>项目成绩查看页面</title>
</head>

<body>
	<div class="layui-container">
		<div class="layui-card">
			<div class="layui-card-header">
				<div class="layui-row">
					<span class="layui-breadcrumb"> <a href="home.jsp">首页</a> <a><cite>项目成绩</cite></a>
					</span>
				</div>
			</div>
			<div class="layui-card-header text-center">
				<div class="layui-row">
					<h1>项目成绩查看页面</h1>
				</div>
			</div>
			<div class="layui-card-body">
				<div class="layui-row layui-form">
					<div class="layui-input-inline">
						<select name="college" id="college" lay-filter="college"
							lay-verify="required" lay-search="">
							<option value="0">请选择或输入学院名称</option>
							<c:forEach items="${listcollege}" var="obj">
								<option value="${obj.collegeid }">${obj.collegename }</option>
							</c:forEach>
						</select>
					</div>
					<div class="layui-input-inline">
						<select name="userselect" id="userselect" lay-filter="userselect">
							<option value="0">请选择参赛者身份</option>
							<option value="student">学生</option>
							<option value="teacher">教师</option>
						</select>
					</div>
					<div class="layui-input-inline" style="margin-left: -10px;">
						<button type="button" class="layui-btn layui-btn" lay-submit
							lay-filter="search">查询</button>
					</div>
				</div>
				<div class="layui-row">
					<table class="layui-table" id="scoretable" lay-filter="demo"></table>
				</div>
			</div>
		</div>
	</div>
	<%@include file="footer.jsp"%>
</body>
<script src="layui/layui.js"></script>
<script type="text/html" id="toolbarDemo">
  <div class="layui-btn-container">
  </div>
</script>
<script src="js/jquery-2.1.1.min.js" charset="utf-8"></script>
<script type="text/javascript">
	layui.use([ 'table', 'laydate', 'layer', 'jquery', 'form', 'element' ],
			function() {
				var table = layui.table;
				var $ = layui.jquery;
				var laydate = layui.laydate;
				var layer = layui.layer;
				var form = layui.form;
				var element = layui.element;
				//页面加载获取动态表格数据
				table.render({
					id : 'tableOne',
					elem : '#scoretable',
			toolbar : '#toolbarDemo',
					height : 'full-200', //高度最大化减去差值,
					url : 'getprojectscore.action?user='
							+ $("#userselect").val(),
					page : true,
					even : true,
					limit : 10,
					limits : [ 10, 15, 20 ],
					skin : "nob",
					cellMinWidth : 35, //全局定义常规单元格的最小宽度，layui 2.2.1 新增
					//,toolbar: '#toolbarDemo'
					title : '用户数据表',
					cols : [ [ {
						align : 'center',
						field : '',
						width : 100,
						title : '序号',
						type : 'numbers'
					}, {
						align : 'center',
						field : 'proname',
						width : 250,
						title : '项目名称',
						sort : true
					}, {
						align : 'center',
						field : '',
						width : 200,
						title : '参赛者',
						templet : function(data) {
							if (data.protype == 1 || data.protype == 2) {
								return data.username
							} else {
								return data.teausername
							}
						}
					}, {
						align : 'center',
						field : '',
						title : '学院名称',
						width : 208,
						sort : true,
						templet : function(data) {
							if (data.protype == 1 || data.protype == 2) {
								return data.collegename
							} else {
								return data.teacollegename
							}
						}
					}, {
						align : 'center',
						field : '',
						title : '参赛者身份',
						width : 150,
						templet : function(data) {
							if (data.protype == 1 || data.protype == 2) {
								return "学生"
							} else {
								return "教师"
							}
						}
					}, {
						align : 'center',
						field : 'scorenumber',
						title : '成绩',
						width : 200,
						sort : true
					} ] ]
				});
				//查询提交
				form.on('submit(search)', function(data) {
					table.reload('tableOne', {
						method : 'post',
						where : {
							'collegeid' : data.field.college,
							'usertype' : data.field.userselect
						},
						page : {
							curr : 1
						}
					});

					return false;
				});
			});
</script>
</html>
