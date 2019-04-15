<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>比赛项目</title>
    
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
			<h2>比赛项目</h2>
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
						</div>
					</div>
				</div>
				<div class="">
					<table class="table table-bordered table-hover" id="table">
						<thead>
							<!--  <th class="text-center"><input type="checkbox" class="js-checkbox-all" /></th>-->
							<th class="text-center"><nobr>序号</nobr></th>
							<th class="text-center"><nobr>项目名称</nobr></th>
							<th class="text-center"><nobr>当前报名人数</nobr></th>
							<th class="text-center"><nobr>人数限制</nobr></th>
							<th class="text-center"><nobr>项目类型</nobr></th>
							<th class="text-center"><nobr>操作</nobr></th>
						</thead>
						<tbody>
						<c:forEach items="${projectList }" var="proList" varStatus="status">
							<tr>
								<td class="text-center"><nobr>${status.index+1}</nobr></td>
								<td class="text-center"><nobr>${proList.proname }</nobr></td>
								<td class="text-center"><nobr>${proList.currentnum }</nobr></td>
								<td class="text-center"><nobr>${proList.scenelimit }</nobr></td>
								<c:if test="${proList.protype==1 }">
								<td class="text-center"><nobr>学生个人赛<br></td>
								</c:if>
								<c:if test="${proList.protype==2 }">
								<td class="text-center"><nobr>学生团体赛<br></td>
								</c:if>
								<c:if test="${proList.protype==3 }">
								<td class="text-center"><nobr>教师个人赛<br></td>
								</c:if>
								<c:if test="${proList.protype==4 }">
								<td class="text-center"><nobr>教师团体赛<br></td>
								</c:if>
								<td class="text-center">
									<input type="hidden" value="${proList.proid }" />
									<button class="btn btn-default btn-sm btn-warning sure"
										style="height:28px" id="btnSubmit">
<!-- 										<span class="glyphicon glyphicon-search">确认报名</span> -->
										<span>确认报名</span>
									</button>
								</td>
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
<script src="js/projectRegistration.js"></script>
<script>
// 	$(".paging").pagination({
// 		pageCount : 10, //$("#intPageCount").val(), //总页数
// 		jump : true,
// 		mode : 'fixed', //固定页码数量
// 		coping : true,
// 		homePage : '首页',
// 		endPage : '尾页',
// 		prevContent : '上页',
// 		nextContent : '下页',
// 		callback : function(api) {
// 			$.ajax({
// 				type : 'Post',
// 				url : 'salesTaskStatistics.aspx',
// 				data : {
// 					page : api.getCurrent(), //页码
// 					op : "paging"
// 				},
// 				dataType : 'text',
// 				success : function(data) {
// 					$("#table tr:not(:first)").remove(); //清空table处首行
// 					$("#table").append(data); //加载table
// 					$("#intPageCount").remove();
// 				}
// 			});
// 		}
// 	});
</script>
</html>
