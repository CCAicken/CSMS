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

body {
	background-color: rgb(209, 207, 207);
	overflow: hidden;
	overflow-y: scroll;
}

body::-webkit-scrollbar {
	display: none;
}
</style>
</head>

<body>
	<div class="layui-card">
		<div class="layui-card-header">
			<div class="layui-row">
				<span class="layui-breadcrumb"> <a href="home.jsp">首页</a> <a
					href="projectSignUp.jsp">比赛项目查看</a> <a><cite>比赛报名</cite></a></span>
			</div>
		</div>
		<div class="layui-card-header text-center">
			<div class="layui-row text-center">
				<h1>比赛报名</h1>
			</div>
		</div>
		<div class="layui-card-body">
			<form id="info" method="post">
				<div class="layui-form-item">
					<div class="layui-input-inline">
						<input type="text" id="userid" placeholder="请输入学号/工号"
							autocomplete="off" class="layui-input">
					</div>
					<div class="layui-input-inline" style="margin-left: -10px;">
						<input type="text" id="username" placeholder="请输入姓名"
							autocomplete="off" class="layui-input">
					</div>
					<div class="layui-input-inline" style="margin-left: -10px;">
						<button type="button" id="btn1" class="layui-btn layui-btn">确认</button>
					</div>
				</div>
				<!--  姓名：<input type="text" id="user"> 班级：<input type="text"
					id="greed"> 年龄：<input type="text" id="age"> <input
					type="button" id="btn1" value="添加">-->
			</form>
			<table id="tab" class="layui-table">
				<colgroup>
					<col width="40%">
					<col width="40%">
					<col width="20%">
				</colgroup>
				<tr id="t1">
					<td>姓名</td>  
					<td>班级</td>  
					<td>是否删除</td>
				</tr>
			</table>

		</div>
		<%@include file="footer.jsp"%>
</body>
<script src="layui/layui.js"></script>
<script src="js/jquery-2.1.1.min.js"></script>
<script type="text/javascript">
    $(document).ready(
        function () {
        $("#btn1").click(
            function () {
                //创建tr节点
                var $tr = $("<tr></tr>");
                //遍历获取输入的内容
                $("#info input:text").each(
                        function (index,
                            domEle) {
                            //添加td节点
                            var $td = $("<td></td>");
                            //将内容循环添加到创建好的TD中
                            $td.append($(
                                domEle).val());
                                //将td添加到创建好的TR 中
                                $td.appendTo($tr);
                            });
                            //创建TD--删除
                            var $td = $("<td><button type='button' class='layui-btn layui-btn-primary layui-btn-sm del'><i class='layui-icon'>&#xe640;</i></button></td>");
                            //将内容循环添加到创建好的TD中
                            $td.appendTo($tr);
                            $tr.appendTo("#tab");

                            //执行删除操作
                            $(".del").click(function () {
                                //alert("@@@@@@@@@@@@");
                                $(this).parent().parent().remove();
                            });
                        });

            });
</script>
</html>