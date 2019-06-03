<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%@ include file="importhead.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>学生个人成绩查看页面</title>

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
			<h2>学生个人成绩查看页面</h2>
		</div>
		<div class="panel-body" id="panelbody">
			<div class="container-fluid big-box">
				<div class="panel panel-default" id="teapanelbox">
					<div class="pane input-group" id="panel-head">
						<div class="input-group" id="inputgroups">
							<select class="selectpicker selectcollegeId" data-width="auto"
								id="selectcollegeId">
								<option value="0" selected="selected">-查询所有分院-</option>
								<c:forEach items="${collegelist}" var="collegeobj">
									<option value="${collegeobj.collegeid}">${collegeobj.collegename}</option>
								</c:forEach>
							</select> &nbsp <select class="selectpicker" id="chooseStuPro">

								<option value="0" selected="selected">-查询全部专业-</option>

								<c:forEach items="${majorlist}" var="majorobj">
									<option value="${majorobj.majorid}">${majorobj.majorname}</option>
								</c:forEach>

							</select>&nbsp <select class="selectpicker" data-live-search="true"
								id="chooseStuPro">

								<option value="0" selected="selected">-查询全部班级-</option>
								<c:forEach items="${classlist}" var="classobj">
									<option value="${classobj.classid}">${classobj.classname}</option>
								</c:forEach>


							</select> <input type="text" class="form-control" placeholder="请输入查询条件"
								id="inputsearch" value="" /> <span class="input-group-btn">
								<button class="btn btn-info" type="button" id="btn-search"
									style="height:34px">
									<span class="glyphicon glyphicon-search" id="search">查询</span>
								</button>
							</span>
							<!-- selectpicker"  -->
						</div>
					</div>
				</div>
				<div class="">
					<table class="table table-bordered table-hover">
						<thead>
							<!--<th class="text-center"><input type="checkbox"
								class="js-checkbox-all" /></th> -->
							<th class="text-center"><nobr>序号</nobr></th>
							<th class="text-center"><nobr>姓名</nobr></th>
							<th class="text-center"><nobr>学号</nobr></th>
							<th class="text-center"><nobr>学院名称</nobr></th>
							<th class="text-center"><nobr>专业名称</nobr></th>
							<th class="text-center"><nobr>班级名称</nobr></th>
							<th class="text-center"><nobr>分数</nobr></th>
							<th class="text-center"><nobr>操作</nobr></th>
						</thead>
						<tbody>
						<c:forEach items="${scorestudent }" var="obj" varStatus="hx">
						<tr>
								<!-- <td class="text-center"><input type="checkbox" /></td> -->
								<td class="text-center"><nobr>${hx.index+1 }</nobr></td>
								<td class="text-center"><nobr>${obj.username }</nobr></td>
								<td class="text-center"><nobr>${obj.userid }</nobr></td>
								<td class="text-center"><nobr>${obj.collegename }</nobr></td>
								<td class="text-center"><nobr>${obj.majorname }</nobr></td>
								<td class="text-center"><nobr>${obj.classname }</nobr></td>
								<td class="text-center"><nobr>${obj.scorenumber }</nobr></td>
								<td class="text-center">
									<a href="scoredetail.do?op=user&id=${obj. userid}">
										<button class="btn btn-default btn-sm btn-warning"
											style="height:28px" values="${obj. userid}">
											<span class="glyphicon glyphicon-search" id="search">查看详情</span>
										</button>
									</a>
								</td>
							</tr>
						</c:forEach>
							
<!-- test -->
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
