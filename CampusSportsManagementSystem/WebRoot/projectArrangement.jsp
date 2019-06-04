<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ include file="importhead.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>比赛项目安排</title>
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
			<h2>比赛项目安排</h2>
		</div>
		<div class="panel-body" id="panelbody">
			<div class="container-fluid big-box">
				<div class="panel panel-default" id="teapanelbox">
					<div class="pane input-group" id="panel-head">
						<div class="input-group" id="inputgroups">
							<input type="text" class="form-control" placeholder="请输入查询条件"
								id="inputsearch" value="" /> <span class="input-group-btn">
								<button class="btn btn-info" type="button" id="btn-search"
									style="height:34px">
									<span class="glyphicon glyphicon-search" id="search">查询</span>
								</button> <!-- selectpicker"  -->
						<button class="btn btn-info" type="button" id="btn-search"
							style="height:34px;margin-left:10px;" data-toggle="modal" data-target="#myModal">
							<span class="glyphicon glyphicon-add" id="search">添加</span>
						</button></span>
						</div>
					</div>
				</div>
				<div class="">
					<table class="table table-bordered table-hover">
						<thead>
							<tr>
								<th class="text-center"><nobr>序号</nobr></th>
								<th class="text-center"><nobr>项目名称</nobr></th>
								<th class="text-center"><nobr>场次名称</nobr></th>
								<th class="text-center"><nobr>开始时间</nobr></th>
								<th class="text-center"><nobr>结束时间</nobr></th>
								<th class="text-center"><nobr>比赛地点</nobr></th>
								<th class="text-center"><nobr>比赛级别</nobr></th>
								<th class="text-center"><nobr>操作</nobr></th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td class="text-center"><nobr>1</nobr></td>
								<td class="text-center"><nobr>4*100(女生组)</nobr></td>
								<td class="text-center"><nobr>2019-05-19接力第二场</nobr></td>
								<td class="text-center"><nobr>2019-05-19 14:00:00</nobr></td>
								<td class="text-center"><nobr>2019-05-19 14:15:00</nobr></td>
								<td class="text-center"><nobr>田径场跑道</nobr></td>
								<td class="text-center"><nobr>预赛</nobr></td>
								<td class="text-center">
									<button class="btn btn-default btn-sm btn-warning"
										style="height:28px">
										<span class="glyphicon glyphicon-delete" id="search">删除</span>
									</button>
								</td>
							</tr>
						</tbody>
						<%-- <tbody>
						<c:forEach items="${arrList }" var="obj" varStatus="status">
							<tr>
								<td class="text-center"><nobr>${status.index +1 }</nobr></td>
								<td class="text-center"><nobr>${obj.project.proname }</nobr></td>
								<td class="text-center"><nobr>${obj.arrname }</nobr></td>
								<td class="text-center"><nobr>${obj.starttime }</nobr></td>
								<td class="text-center"><nobr>${obj.endtime }</nobr></td>
								<td class="text-center"><nobr>${obj.addr }</nobr></td>
								<c:if test="${obj.leveltype==1 }">
								<td class="text-center"><nobr>预赛</nobr></td>
								</c:if>
								<c:if test="${obj.leveltype==2 }">
								<td class="text-center"><nobr>决赛</nobr></td>
								</c:if>
								<td class="text-center">
									<button class="btn btn-default btn-sm btn-warning"
										style="height:28px">
										<span class="glyphicon glyphicon-search" id="search">编辑</span>
									</button>
								</td>
							</tr>
						</c:forEach>
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
		<!-- 添加模态框 -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">添加场次信息</h4>
					</div>
					<div class="modal-body">
						<table class="table table-hover">
							<tbody>
								<tr>
									<td id="regLable"><label class="control-label">项目名称:</label>
									</td>
									<td><select id="select" name="select"
										class="selectpicker show-tick form-control">
											<option value="">1000m长跑</option>
											<option value="">100m短跑</option>
									</select></td>
								</tr>
								<tr>
									<td id="regLable"><label class="control-label">场次名称:</label>
									</td>
									<td><input type="text" class="form-control input-sm input"
										id="username" name="username" placeholder="请输入场次名称" /> <span
										id="validateName"></span></td>
								</tr>
								<tr>
									<td id="regLable"><label class="control-label">开始时间:</label>
									</td>
									<td>
									<input type="text" name="starttime" id="starttime" readOnly="true" value=""/>
						            <img onClick="WdatePicker({el:$dp.$('starttime'),dateFmt:'yyyy-MM-dd HH:mm:ss'})" src="lib/My97DatePicker/skin/datePicker.gif" _fcksavedurl="lib/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle"> 
						            </td>
								</tr>
								<tr>
									<td id="regLable"><label class="control-label">结束时间:</label>
									</td>
									<td>
									<input type="text" name="endtime" id="endtime" readOnly="true" value=""/>
						            <img onClick="WdatePicker({el:$dp.$('endtime'),dateFmt:'yyyy-MM-dd HH:mm:ss'})" src="lib/My97DatePicker/skin/datePicker.gif" _fcksavedurl="lib/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle"> 
						            </td>
								</tr>
								<tr>
									<td id="regLable"><label class="control-label">比赛地点:</label>
									</td>
									<td><textarea class="form-control input-sm input"
											id="username" name="username" placeholder="请输入比赛地点"></textarea>
									</td>
								</tr>
								<tr>
									<td id="regLable"><label class="control-label">比赛级别:</label>
									</td>
									<td><select id="select" name="select"
										class="selectpicker show-tick form-control">
											<option value="">预赛</option>
											<option value="">决赛</option>
									</select></td>
								</tr>
							</tbody>
						</table>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						<button type="button" class="btn btn-primary">确定</button>
					</div>
				</div>
			</div>
		</div>
</body>
<script src="js/jquery-3.3.1.min.js"></script>
    <script language="javascript" type="text/javascript" src="lib/My97DatePicker/WdatePicker.js"></script>   
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
<script src="js/bootstrap-datetimepicker.min.js"></script>
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
	$(".form_datetime").datetimepicker({locale: 'zh-cn',viewMode: 'days',format: 'YYYY/MM/DD'});
	$(".form_datetime").datetimepicker().on('changeDate', function(ev){
	var that = this;
	    if (ev.date.valueOf() < date-start-display.valueOf()){
	        that.val(ev.date.valueOf());
	    }
	});
</script>
</html>
