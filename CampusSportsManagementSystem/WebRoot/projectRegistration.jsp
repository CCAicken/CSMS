<%@page import="business.factory.DAOFactory"%>
<%@page import="business.dao.*"%>
<%@page import="model.*"%>
<%@page import="model.Student"%>
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
<%
/* Student stu = null;
		Teacher tea = null;
		int usertype = (Integer)session.getAttribute("usertype");//获取用户类型
		int userid;
		
		ProjectDAO pdao = DAOFactory.getProjectDAO();
		
		List<Project> projectList = null;
		if(usertype==1 || usertype==2){
			projectList = pdao.selectByType(usertype);//教师和学生只能查看自己能报名的项目
			if(usertype==1){
				stu = (Student)session.getAttribute("loginuser");
			}else{
				tea = (Teacher)session.getAttribute("loginuser");
			}
		}
		else{
			projectList = pdao.select();//组委会可以查看所有报名项目
		}
		request.setAttribute("projectList", projectList); */
 %>
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
							
						<button class="btn btn-info" type="button" id="btn-search"
							style="height:34px;margin-left:10px;" data-toggle="modal" data-target="#myModal">
							<span class="glyphicon glyphicon-add" id="search">添加</span>
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
							<th class="text-center"><nobr>学院人数限制</nobr></th>
							<th class="text-center"><nobr>总人数限制</nobr></th>
							<th class="text-center"><nobr>项目类型</nobr></th>
							<th class="text-center"><nobr>操作</nobr></th>
						</thead>
						<tbody>
							<tr>
								<td class="text-center"><nobr>1</nobr></td>
								<td class="text-center"><nobr>4*100（女生）</nobr></td>
								<td class="text-center"><nobr>4</nobr></td>
								<td class="text-center"><nobr>12</nobr></td>
								<td class="text-center"><nobr>48</nobr></td>
								<td class="text-center"><nobr>学生个人赛<br></td>
								<td style="display:none">${proList.proid }</td>
								<td class="text-center">
									<button class="btn btn-default btn-sm btn-warning sure"
										style="height:28px" id="btnSubmit">
										<span>删除</span>
									</button>
								</td>
							</tr>
						</tbody>
						<%-- <tbody>
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
								<td style="display:none">${proList.proid }</td>
								<td class="text-center">
									<button class="btn btn-default btn-sm btn-warning sure"
										style="height:28px" id="btnSubmit">
										<span>确认报名</span>
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
									<td id="regLable"><label class="control-label">当前报名人数:</label>
									</td>
									<td><input type="numbr" class="form-control input-sm input"
										id="username" name="username" placeholder="请输入场次名称" /> <span
										id="validateName"></span></td>
								</tr>
								<tr>
									<td id="regLable"><label class="control-label">学院人数限制:</label>
									</td>
									<td><input type="number" class="form-control input-sm input"
										id="username" name="username" placeholder="请选择开始时间" /> <span
										id="validateName"></span></td>
								</tr>
								<tr>
									<td id="regLable"><label class="control-label">总人数限制:</label>
									</td>
									<td><input type="number" class="form-control input-sm input"
										id="username" name="username" placeholder="请选择结束时间" /> <span
										id="validateName"></span></td>
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
				<!-- /.modal-content -->
			</div>
			<!-- /.modal -->
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
