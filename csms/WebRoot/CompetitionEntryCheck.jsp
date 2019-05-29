<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>报名查询</title>
<link rel="stylesheet" href="layui/css/layui.css">

<style>
</style>
</head>

<body>
	<div class="layui-card">
		<div class="layui-card-header">
			<h2>报名查询</h2>
		</div>
		<div class="layui-card-body">
			<div class="layui-row layui-form">
				<div class="layui-input-inline">
					<input type="text" placeholder="请输入查询条件" name="strwhere"
						autocomplete="off" class="layui-input">
				</div>
				<div class="layui-input-inline" style="margin-left: -10px;">
					<button type="button" class="layui-btn layui-btn" lay-submit
						lay-filter="search">查询</button>
				</div>
				<div class="layui-input-inline">
					<select name="collegeid" lay-filter="college">
						<option value="">选择或输入学院名称</option>
						<c:forEach items="${collegelist }" var="obj">
							<option value="${obj.collegeid }">${obj.collegename }</option>
						</c:forEach>
					</select>
				</div>
				<div class="layui-input-inline" id="select-class">
					<select name="classid" lay-search="">
						<option value="">直接选择或搜索选择</option>
						<c:forEach items="${classlist }" var="obj">
							<option value="${obj.classid }">${obj.classname }</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="layui-row layui-form">
				<table class="layui-table" id="basic-table"></table>
			</div>
		</div>
	</div>
	<%@include file="footer.jsp"%>
</body>
<script src="layui/layui.all.js"></script>

<script src="js/jquery-2.1.1.min.js" charset="utf-8"></script>
<script>
	layui.use([ 'form', 'table' ], function() {

		var url = "arrangeview.action?op=load";

		var form = layui.form, table = layui.table;
		form.on('select(college)', function(data) {
			alert(data.value)
		});

		//监听提交
		form.on('submit(search)', function(data) {
			layer.alert(JSON.stringify(data.field), {
				title : '最终的提交信息'
			})
			return false;
		});
		table.render({
			elem : '#basic-table',
			//height : 513,
			url : url // 数据接口
			,
			id : 'tableOne',
			page : true // 开启分页
			,
			limits : [ 5, 10, 15 ],

			cols : [ [ // 表头
			{
				field : 'userid',
				title : '学号',
				width : 70
			}, {
				field : '',
				title : '姓名',
				width : 100,
				templet : function(d) {
					if (d.username == null || d.username == "") {
						return d.teausername;
					} else {
						return d.username;
					}
				}
			}, {
				field : '',
				title : '班级',
				width : 150,
				templet : function(d) {
					if (d.classname == null || d.classname == "") {
						return "教师用户不分班级";
					} else {
						return d.classname;
					}
				}
			}, {
				field : '',
				title : '院系',
				width : 150,
				templet : function(d) {
					if (d.collegename == null || d.collegename == "") {
						return d.teacollegename;
					} else {
						return d.collegename;
					}
				}
			}, {
				field : 'proname',
				title : '项目名称',
				width : 150
			}, {
				field : 'arrname',
				title : '场次',
				width : 150
			}, {
				field : 'starttime',
				title : '开始时间',
				width : 150
			}, {
				field : 'endtime',
				title : '结束时间',
				width : 150
			}, {
				field : 'addr',
				title : '比赛地点',
				width : 150
			}, {
				field : '',
				title : '比赛级别',
				width : 150,
				templet : function(d) {
					if (d.leveltype == 1) {
						return "预赛";
					} else {
						return "决赛";
					}
				}
			}, {
				field : '',
				title : '比赛状态',
				width : 150,
				templet : function(d) {
					if (d.state == 0) {
						return "未开始";
					} else if (d.state == 1) {
						return "已结束";
					} else if (d.state == 2) {
						return "延时";
					} else {
						return "取消";
					}
				}
			} ] ]
		})
		$("#btn-search").click(function() {
			alert($("#strwhere").val());
			table.reload('tableOne', {
				method : 'post',
				where : {
					'strwhere' : $("#strwhere").val(),
					'collegeid' : send_name,
					'classid' : send_data,
				},
				page : {
					curr : 1
				}
			});
		})
	});
</script>

</html>