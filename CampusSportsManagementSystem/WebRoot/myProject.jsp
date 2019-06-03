<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>我的比赛项目</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/ml.css" />
<link rel="stylesheet" href="css/lgd.css" />
<link rel="stylesheet" href="css/style.css" />
<link rel="stylesheet" href="css/square/_all.css" />
<link rel="stylesheet" href="css/bootstrap-select.css" />
<!--图标样式-->
<link rel="stylesheet" href="css/iconfont.css" />
<link rel="stylesheet" href="css/xcConfirm.css" />
<!--分页样式-->
<link rel="stylesheet" href="css/pagination.css" />

</head>

<body>
	<div class="panel panel-default" id="panel" style="margin-top: -20px">
		<div class="panel-head">
			<h2>我的比赛项目</h2>
		</div>
		<div class="panel-body" id="panelbody">
			<div class="container-fluid big-box">
				<div class="panel panel-default" id="teapanelbox">
					<div class="pane input-group" id="panel-head">
						<div class="input-group" id="inputgroups">
							<input type="text" class="form-control" placeholder="请输入查询条件" id="inputsearch" value="" /> <span class="input-group-btn">
							<button class="btn btn-info" type="button" id="btn-search" style="height:34px">
								<span class="glyphicon glyphicon-search" id="search">查询</span>
							</button>
							<!-- selectpicker"  -->
						</div>
					</div>
				</div>
				<div class="">
					<table class="table table-bordered table-hover">
						<thead>
							<tr>
								<th class="text-center"><nobr>序号</nobr></th>
								<th class="text-center"><nobr>项目名称</nobr></th>
								<th class="text-center"><nobr>场次安排</nobr></th>
								<th class="text-center"><nobr>开始时间</nobr></th>
								<th class="text-center"><nobr>结束时间</nobr></th>
								<th class="text-center"><nobr>比赛地点</nobr></th>
								<c:if test="${usertype == 1 }">
								<th class="text-center"><nobr>班级</nobr></th>
								<th class="text-center"><nobr>專業</nobr></th>
								</c:if>
								<th class="text-center"><nobr>学院</nobr></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${scenelist }" var="list" varStatus="status">
							<tr>
								<td class="text-center"><nobr>${status.index+1 }</nobr></td>
								<td class="text-center"><nobr>${list.arrange.project.proname }</nobr></td>
								<td class="text-center"><nobr>${list.arrange.arrname }</nobr></td>
								<td class="text-center"><nobr>${list.arrange.starttime }</nobr></td>
								<td class="text-center"><nobr>${list.arrange.endtime }</nobr></td>
								<td class="text-center"><nobr>${list.arrange.addr }</nobr></td>
								<c:if test="${list.roleid == 1 }">
								<td class="text-center"><nobr>${list.match.student.classes.classname }</nobr></td>
								<td class="text-center"><nobr>${list.match.student.classes.major.majorname }</nobr></td>
								<td class="text-center"><nobr>${list.match.student.classes.major.college.collegename }</nobr></td>
								</c:if>
								<c:if test="${list.roleid != 1 }">
								<td class="text-center"><nobr>${list.match.teacher.college.collegename }</nobr></td>
								</c:if>
							</tr>
							</c:forEach>
							<c:forEach items="${proList }" var="pro" varStatus="status">
							<tr>
								<td class="text-center"><nobr>${listSize+status.index+1 }</nobr></td>
								<td class="text-center"><nobr>${pro.proname }</nobr></td>
								<td class="text-center"><nobr>未安排</nobr></td>
								<td class="text-center"><nobr>未安排</nobr></td>
								<td class="text-center"><nobr>未安排</nobr></td>
								<td class="text-center"><nobr>未安排</nobr></td>
								<c:if test="${usertype == 1 }">
								<td class="text-center"><nobr>${loginuser.classes.classname }</nobr></td>
								<td class="text-center"><nobr>${loginuser.classes.major.majorname }</nobr></td>
								<td class="text-center"><nobr>${loginuser.classes.major.college.collegename }</nobr></td>
								</c:if>
								<c:if test="${usertype == 2 }">
								<td class="text-center"><nobr>${loginuser.college.collegename }</nobr></td>
								</c:if>
							</tr>
							</c:forEach>
						</tbody>
					</table>
					
				</div>
			</div>
		</div>
		<div class="copyright float-right page-box">
			<div class="dataTables_paginate paging_full_numbers"
				id="datatables_paginate">
				<div class="m-style paging"></div>
			</div>
		</div>
</body>
<script src="js/jquery-3.3.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/icheck.min.js"></script>
<script src="js/ml.js"></script>
<!--bootstrap下拉js-->
<script src="js/bootstrap-select.js"></script>
<script src="js/jquery.validate.min.js"></script>
<!--分页js-->
<script src="js/jquery.pagination.js"></script>
<script src="js/stuLIst.js"></script>
<script src="js/xcConfirm.js"></script>
<script>
	$(".paging").pagination({
		pageCount : 10, //$("#intPageCount").val(), //总页数
		jump : true,
		mode : 'fixed', //固定页码数量
		coping : true,
		homePage : '首页',
		endPage : '尾页',
		prevContent : '上页',
		nextContent : '下页',
		callback : function(api) {
			$.ajax({
				type : 'Post',
				url : 'salesTaskStatistics.aspx',
				data : {
					page : api.getCurrent(), //页码
					op : "paging"
				},
				dataType : 'text',
				success : function(data) {
					$("#table tr:not(:first)").remove(); //清空table处首行
					$("#table").append(data); //加载table
					$("#intPageCount").remove();
				}
			});
		}
	});
</script>
</html>
