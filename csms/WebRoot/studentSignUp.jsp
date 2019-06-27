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
		<div class="layui-card-body" id="body">
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
					<div class="layui-input-inline" style="margin-left: -10px;">
						<button type="button" id="btn_sign" class="layui-btn layui-btn">报名</button>
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
					<td>学号/工号</td>
					<td>姓名</td>
					<td>是否删除</td>
				</tr>
			</table>

		</div>
		<%@include file="footer.jsp"%>
</body>
<script src="layui/layui.js"></script>
<script src="js/jquery-2.1.1.min.js"></script>
<script type="text/javascript">
	
	layui.use([ 'table', 'form', 'jquery', 'layer' ],function() {
		var layer = layui.layer;
	    $(document).ready(function () {
	    	var $ = layui.jquery;
			//js获取传来的项目id
			var loc = location.href;
			var n1 = loc.length;//地址的总长度
			var n2 = loc.indexOf("=");//取得=号的位置
			var proid = decodeURI(loc.substr(n2 + 1, n1 - n2));//从=号后面的内容
			//alert(proid);
	    	//添加运动员按钮
	        $("#btn1").click(function () {
		        var userid = $("#userid").val();
		        var username = $("#username").val();
		        if(userid==null||userid==""){
		        	layer.msg("学号或工号不能为空");
		        }
		        else if(username==null||username==""){
		        	layer.msg("姓名不能为空");
		        }
		        else{
	        		addtable();
	        		$("#userid").val("");
	        		$("#username").val("");
	        	}
	    	});
	    	
	    	//报名按钮
	    	$("#btn_sign").click(function(){
	    		var data = getTableContent('tab');
	    		//alert(JSON.stringify(data));
	    		//alert(data);
	    		
	    		//数组转json数据
	    		var json = [];
	    		for (var i = 1; i < data.length; i++) {
				     var j = {};
				     j.userid = data[i][0];
				     j.username = data[i][1];
				      //这里还可以继续添加属性j.属性 = 值
				     json.push(j);
				}
				//layer.msg(JSON.stringify(json));
				$.ajax({
					type : "post",
					url : "stuAction.action",
					data : {
						userinfo:JSON.stringify(json),
						proid:proid,
						op:'add'
					},
					dataType : "json",
					success : function(succ) {
						if(succ=="报名成功"){
							layer.msg(
								data,
								{
								time : 0 //不自动关闭
								,btn : [ '确定' ],
								yes : function(index) {
									layer.close(index);
									window.location.reload();						
								}
							});
						}
						else{
							layer.msg(succ);
						}
					},
					error : function() {
						layer.msg('请求失败，稍后再试',{icon : 5});
					}
	
				});
	    	})
	    	
	    	function addtable(){
	    	//创建tr节点
	        	var $tr = $("<tr></tr>");
	           	//遍历获取输入的内容
	          	$("#info input:text").each(function (index,domEle) {
	              	//添加td节点
	               	var $td = $("<td></td>");
	              	//将内容循环添加到创建好的TD中
	              	$td.append($(domEle).val());
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
	    	}
	    	
	    	/** 
		     * 遍历表格内容返回数组
		     * @param  Int   id 表格id
		     * @return Array
		     */
		    function getTableContent(id){
		        var mytable = document.getElementById(id);
		        var data = [];
		        for(var i=0,rows=mytable.rows.length; i<rows; i++){
		            for(var j=0,cells=mytable.rows[i].cells.length-1; j<cells; j++){
		                if(!data[i]){
		                    data[i] = new Array();
		                }
		                data[i][j] = mytable.rows[i].cells[j].innerHTML;
		            }
		        }
		        return data;
		    }
			//function showTableContent(id){
		        //var data = getTableContent(id);
		        //var tmp = '';
		        //for(i=0,rows=data.length; i<rows; i++){
		            //for(j=0,cells=data[i].length; j<cells; j++){
		                //tmp += data[i][j] + ',';
		            //}
		            //tmp += '<br>';
		        //}
		        //aler(tmp);
		    //}
		});
	})
</script>
</html>