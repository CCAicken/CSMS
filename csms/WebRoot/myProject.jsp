<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>我的比赛项目</title>
<link rel="stylesheet" href="layui/css/layui.css">
<style>
</style>
</head>

<body>
	<div class="layui-card">
		<div class="layui-card-header">
			<h2>我的比赛项目</h2>
		</div>
		<div class="layui-card-body">
			<table class="layui-table">
				<colgroup>
					<col width="70">
					<col width="200">
					<col width="150">
					<col width="150">
					<col width="150">
					<col width="150">
					<col width="150">
					<col width="150">
				</colgroup>
				<thead>
					<tr>
						<th>序号</th>
						<th>项目名称</th>
						<th>场次</th>
						<th>开始时间</th>
						<th>结束时间</th>
						<th>比赛地点</th>
						<th>比赛级别</th>
						<th>比赛状态</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach items="${scenlist }" var="obj" varStatus="xh">
						<tr>
							<td>${xh.index+1 }</td>
							<td>${obj.proname }</td>
							<td>${obj.arrname }</td>
							<td>${obj.starttime }</td>
							<td>${obj.endtime }</td>
							<td>${obj.addr }</td>
							<c:if test="${obj.leveltype==1 }">
								<td>预赛</td>
							</c:if>
							<c:if test="${obj.leveltype==2 }">
								<td>决赛</td>
							</c:if>

							<c:if test="${obj.state == 0 }">
								<td>未比赛</td>
							</c:if>
							<c:if test="${obj.state == 1 }">
								<td>已结束</td>
							</c:if>
							<c:if test="${obj.state == 2 }">
								<td>延时</td>
							</c:if>
							<c:if test="${obj.state == 3 }">
								<td>取消</td>
							</c:if>

						</tr>
					</c:forEach>

				</tbody>
			</table>
		</div>
	</div>
	<%@include file="footer.jsp"%>
</body>
<script src="layui/layui.js"></script>

</html>