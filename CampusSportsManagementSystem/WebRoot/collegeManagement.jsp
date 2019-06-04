<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%@ include file="importhead.jsp"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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

<title>学院管理页面</title>

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
			<h2>学院管理</h2>
		</div>
		<div class="panel-body" id="panelbody">
			<div class="container-fluid big-box">
				<div class="panel panel-default" id="teapanelbox">
					<div class="pane input-group" id="panel-head">
						<div class="input-group" id="inputgroups">
							<select class="selectpicker selectcollegeId" data-width="auto"
								id="selectcollegeId">
								<option value="0">-查询所有分院-</option>
								<c:forEach items="${collegelist}" var="collegeobj">
									<option value="${collegeobj.collegeid}">${collegeobj.collegename}</option>
								</c:forEach>
							</select> 
							<input type="text" class="form-control" placeholder="请输入查询条件" id="inputsearch" value="" /> 
							<span class="input-group-btn">
								<button class="btn btn-info" type="button" id="btn-search"
									style="height:34px">
									<span class="glyphicon glyphicon-search" id="search">查询</span>
								</button>
								<button class="btn btn-info" type="button" id="btn-search"
									style="height:34px;margin-left:10px;" data-toggle="modal" data-target="#myModal">
									<span class="glyphicon glyphicon-add" id="search">添加</span>
								</button>
							</span>
						</div>
					</div>
				</div>
				<div class="">
					<table class="table table-bordered table-hover" id="scoretable">
						<thead>
							<!--<th class="text-center"><input type="checkbox"
								class="js-checkbox-all" /></th>-->
							<th class="text-center"><nobr>序号</nobr></th>
							<th class="text-center"><nobr>学院名称</nobr></th>
							<th class="text-center"><nobr>操作</nobr></th>
						</thead>
						<tbody>
							<tr>
								<!--<td class="text-center"><input type="checkbox" /></td> -->
								<td class="text-center"><nobr>1</nobr></td>
								<td class="text-center"><nobr>信息工程学院</nobr></td>
								<td class="text-center">
									<button class="btn btn-default btn-sm btn-warning"
										style="height:28px" value="${obj.classid }">
										<span class="glyphicon glyphicon-del" id="search">删除</span>
									</button>
								</td>
							</tr>
							<tr>
								<!--<td class="text-center"><input type="checkbox" /></td> -->
								<td class="text-center"><nobr>2</nobr></td>
								<td class="text-center"><nobr>建筑工程学院</nobr></td>
								<td class="text-center">
									<button class="btn btn-default btn-sm btn-warning"
										style="height:28px" value="${obj.classid }">
										<span class="glyphicon glyphicon-del" id="search">删除</span>
									</button>
								</td>
							</tr>
						</tbody>
						<%-- <tbody id="scoretable_tbody">
							<c:forEach items="${scorecollege }" var="obj" varStatus="xh">
								<tr>
									<!-- <td class="text-center"><input type="checkbox" /></td> -->
									<td class="text-center"><nobr>${xh.index+1}</nobr></td>
									<td class="text-center"><nobr>${obj.collegename }</nobr></td>
									<td class="text-center"><nobr>${obj.scorenumber }</nobr></td>
									<td class="text-center">
										<button class="btn btn-default btn-sm btn-warning details"
											style="height:28px" value="${obj.collegeid}" id="">
											<span class="glyphicon glyphicon-search">查看详情</span>
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
		<input type="hidden" id="pageAmount" value="${pageAmount }"/>
		<!-- 添加模态框 -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">添加学院信息</h4>
					</div>
					<div class="modal-body">
						<table class="table table-hover">
							<tbody>
								<!-- <tr>
									<td id="regLable"><label class="control-label">项目名称:</label>
									</td>
									<td><select id="select" name="select"
										class="selectpicker show-tick form-control">
											<option value="">1000m长跑</option>
											<option value="">100m短跑</option>
									</select></td>
								</tr> -->
								<tr>
									<td id="regLable"><label class="control-label">学院名称:</label>
									</td>
									<td><input type="text" class="form-control input-sm input"
										id="username" name="username" placeholder="请输入学院名称" /> <span
										id="validateName"></span></td>
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
	//查询点击事件
	$("#search").click(function() {
		var opretion = $("#inputsearch").val();
		//alert(opretion);
		$.ajax({
			type : 'get',
			url : "collegechievement.do",
			data : {
				opretion : opretion,
				action : 'search',
				type:'search'
			},
			dataType : "json",
			success : function(data) {
				//alert(records.collegeid);
				//alert(data.records[0].scorenumber);
				setContent(data.records);
			},
			error : function(jqXHR, textStatus, errorThrown) {
			window.wxc.xcConfirm(textStatus+"后台错误", window.wxc.xcConfirm.typeEnum.error)
				/*弹出jqXHR对象的信息
				alert(jqXHR.responseText);
				alert(jqXHR.status);
				alert(jqXHR.readyState);
				alert(jqXHR.statusText);
				/*弹出其他两个参数的信息
				alert(textStatus);
				alert(errorThrown);*/
			}
		});
	})
	
	  $("#scoretable").delegate('.details', //为符合条件的现有标签和未来标签都绑定事件
                 'click', function () {
                     var id = $(this).val();
                     window.location.href="scoredetail.do?op=college&id="+id;
             });
	$("#selectcollegeId").change(function() {
		var collegeId = $("#selectcollegeId").find("option:selected").val();
		//alert(collegeId);
		$.ajax({
			type : 'get',
			url : "collegechievement.do",
			data : {
				opretion : collegeId,
				action : 'search',
			},
			dataType : "json",
			success : function(data) {
				//alert(records.collegeid);
				//alert(data.records[0].scorenumber);
				setContent(data.records);
			},
			error : function(jqXHR, textStatus, errorThrown) {
			window.wxc.xcConfirm(textStatus+"后台错误", window.wxc.xcConfirm.typeEnum.error)
				/*弹出jqXHR对象的信息
				alert(jqXHR.responseText);
				alert(jqXHR.status);
				alert(jqXHR.readyState);
				alert(jqXHR.statusText);
				/*弹出其他两个参数的信息
				alert(textStatus);
				alert(errorThrown);*/
			}
		});
	})
	$(".paging").pagination({
		pageCount : $("#pageAmount").val(), //$("#intPageCount").val(), //总页数
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
				url : "collegechievement.do",
				data : {
					page : api.getCurrent(), //页码
					type : "paging"
				},
				dataType : 'json',
				success : function(data) {
					setContent(data.records);
				}
			});
		}
	});

	function setContent(contents) {//将json数据解析并输出到页面上
		var size = contents.length;
		//var p = document.getElementById("scoretable").parentNode;//先将之前的删除
		$("#scoretable_tbody").remove();
		//p.removeChild(document.getElementById("scoretable_tbody"));
		var tbody = document.createElement("tbody");
		tbody.setAttribute("id", "scoretable_tbody");
		for (var i = 0; i < size; i++) {
			var nextNode = contents[i].collegename;//代表的是json格式数据的第i个元素的id
			var nextNode2 = contents[i].scorenumber;//第i个元素的姓名
			var nextNode3 = contents[i].collegeid;
			//<td class="text-center"><input type="checkbox" /></td>

			var tr = document.createElement("tr");
			
			var td0 = document.createElement("td");
			td0.setAttribute("class", "text-center");
			var text0 = document.createTextNode(i + 1);

			var td1 = document.createElement("td");
			td1.setAttribute("class", "text-center");
			var text1 = document.createTextNode(nextNode);

			var td2 = document.createElement("td");
			td2.setAttribute("class", "text-center");
			var text2 = document.createTextNode(nextNode2);
			
			var td3 = document.createElement("td");
			td3.setAttribute("class", "text-center");
			var button = document.createElement("button");
			button.setAttribute("class","btn btn-default btn-sm btn-warning details");
			button.setAttribute("style","height:28px");
			button.setAttribute("value",nextNode3);
			var span = document.createElement("span");
			span.setAttribute("class","glyphicon glyphicon-search");
			var textsearch=document.createTextNode("查看详情");
			
			
			//<button class="btn btn-default btn-sm btn-warning details"
										//	style="height:28px" value="${obj.collegeid}" id="">
										//	<span class="glyphicon glyphicon-search">查看详情</span>
										//</button>
			td0.appendChild(text0);
			tr.append(td0);

			td1.appendChild(text1);
			tr.appendChild(td1);

			td2.appendChild(text2);
			tr.append(td2);
			
			span.appendChild(textsearch);
			button.appendChild(span);
			td3.appendChild(button);
			tr.append(td3);
			

			tbody.appendChild(tr);
		}
		document.getElementById("scoretable").appendChild(tbody);
	}
</script>
</html>
