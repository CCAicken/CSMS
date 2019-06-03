<%@page import="java.util.ArrayList"%>
<%@page import="javax.xml.bind.ParseConversionEvent"%>
<%@page import="java.util.List"%>
<%@page import="model.Scene"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>比賽安排查看</title>
    
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
			<h2>比賽安排查看</h2>
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
								<th class="text-center"><nobr>学号/工号</nobr></th>
								<th class="text-center"><nobr>参赛者</nobr></th>
								<th class="text-center"><nobr>性别</nobr></th>
								<th class="text-center"><nobr>项目名称</nobr></th>
								<th class="text-center"><nobr>场次名称</nobr></th>
								<th class="text-center"><nobr>开始时间</nobr></th>
								<th class="text-center"><nobr>结束时间</nobr></th>
								<th class="text-center"><nobr>比赛地点</nobr></th>
								<th class="text-center"><nobr>比赛级别</nobr></th>
								<th class="text-center"><nobr>比赛状态</nobr></th>
								<th class="text-center"><nobr>操作</nobr></th>
							</tr>
						</thead>
						<tbody>
						 	<tr>
								<td class="text-center"><nobr></nobr>1</td>
								<td class="text-center"><nobr></nobr>16520400013</td>
								<td class="text-center"><nobr></nobr>贾贾</td>
								<td class="text-center"><nobr></nobr>女</td>
								<td class="text-center"><nobr></nobr>100m短跑</td>
								<td class="text-center"><nobr></nobr>100m短跑校内第一场</td>
								<td class="text-center"><nobr></nobr>2019-05-29 14:00:00</td>
								<td class="text-center"><nobr></nobr>2019-05-29 14:15:00</td>
								<td class="text-center"><nobr></nobr>田径场跑道主席台前</td>
								<td class="text-center"><nobr></nobr>预赛</td>
								<td class="text-center"><nobr>未比赛</nobr></td>
								<td class="text-center">
								<button class="btn btn-default btn-sm btn-warning sure">
									<span class="glyphicon glyphicon-search">开始</span>
								</button>
								</td>
							</tr>
						 	<tr>
								<td class="text-center"><nobr></nobr>2</td>
								<td class="text-center"><nobr></nobr>16520400014</td>
								<td class="text-center"><nobr></nobr>贾三</td>
								<td class="text-center"><nobr></nobr>男</td>
								<td class="text-center"><nobr></nobr>跳高</td>
								<td class="text-center"><nobr></nobr>跳高校内第一场</td>
								<td class="text-center"><nobr></nobr>2019-05-29 14:00:00</td>
								<td class="text-center"><nobr></nobr>2019-05-29 14:15:00</td>
								<td class="text-center"><nobr></nobr>田径场跳高地</td>
								<td class="text-center"><nobr></nobr>预赛</td>
								<td class="text-center"><nobr>比赛中</nobr></td>
								<td class="text-center">
								<button class="btn btn-default btn-sm btn-warning sure">
									<span class="glyphicon glyphicon-search">录入成绩</span>
								</button>
								</td>
							</tr>
						</tbody>
						<%-- <tbody>
						<%
							List<Scene> lists = (List<Scene>) request.getAttribute("scenelist");
							for(Scene scene:lists){
								int i=1;
						 %>
						 	<tr>
								<td class="text-center"><nobr></nobr><%=i %></td>
								<td class="text-center"><nobr></nobr><%=scene.getArrange().getProject().getProname() %></td>
								<td class="text-center"><nobr></nobr><%=scene.getArrange().getArrname() %></td>
								<td class="text-center"><nobr></nobr><%=scene.getArrange().getStarttime() %></td>
								<td class="text-center"><nobr></nobr><%=scene.getArrange().getEndtime() %></td>
								<td class="text-center"><nobr></nobr><%=scene.getArrange().getAddr() %></td>
								<%if(scene.getArrange().getLeveltype()==1){ %>
								<td class="text-center"><nobr></nobr>預賽</td>
								<%} %>
								<%if(scene.getArrange().getLeveltype()==2){ %>
								<td class="text-center"><nobr></nobr>決賽</td>
								<%} %>
								<%if(scene.getArrange().getState()==0){ %>
								<td class="text-center"><nobr></nobr>未比賽</td>
								<%} %>
								<%if(scene.getArrange().getState()==1){ %>
								<td class="text-center"><nobr></nobr>比賽中</td>
								<%} %>
								<%if(scene.getArrange().getState()==2){ %>
								<td class="text-center"><nobr></nobr>比賽完成</td>
								<%} %>
							</tr>
						 <%
						 	i++;
						 } %>
						</tbody> --%>
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
