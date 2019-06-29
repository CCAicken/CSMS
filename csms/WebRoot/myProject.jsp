<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>比赛项目</title>
<link rel="stylesheet" href="layui/css/layui.css">
<style>
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
				<span class="layui-breadcrumb"> <a href="home.jsp">首页</a> <a><cite>报名详情查看</cite></a></span>
			</div>
		</div>
		<div class="layui-card-header text-center">
			<div class="layui-row text-center">
				<h1 align="center">报名详情查看</h1>
			</div>
		</div>
		<div class="layui-card-body">
			<div class="layui-row layui-form">
				<div class="layui-input-inline">
					<input type="text" name="text" id="userid" placeholder="请输入学号/工号"
						autocomplete="off" class="layui-input">
				</div>
					<div class="layui-input-inline">
						<select name="college" id="college" lay-filter="college"
							lay-verify="required" lay-search="">
						</select>
					</div>
					<div class="layui-input-inline search">
						<select name="major" id="major" lay-filter="major">
							<option value="">请选择或输入专业名称</option>
						</select>
					</div>
					<div class="layui-input-inline search">
						<select name="classes" id="classes" lay-filter="class">
							<option value="">请选择或输入班级名称</option>
						</select>
					</div>
					<div class="layui-input-inline" style="margin-left: -10px;">
						<button type="button" class="layui-btn layui-btn" lay-submit
							lay-filter="search" id="search">查询</button>
					</div>
					<div class="layui-input-inline">
						<label class="layui-form-label">查询角色</label>
						<div class="layui-input-block">
					      <input type="radio" lay-filter="erweima" name="sex" value="学生" title="学生" id="btnradio">
					      <input type="radio" lay-filter="erweima" name="sex" value="教职工" title="教职工">
					      <input type="radio" lay-filter="erweima" name="sex" value="all" title="全部" checked>
					    </div>
					</div>
					<div class="layui-row">
						<table class="layui-table" id="scoretable" lay-filter="demo"></table>
					</div>
				</div>
			<table class="layui-table" id="project" lay-filter="test"
				width="100%"></table>
		</div>
	</div>
	<%@include file="footer.jsp"%>
</body>
<script src="layui/layui.js"></script>
<script src="js/jquery-2.1.1.min.js" charset="utf-8"></script>
<script>
	layui.use([ 'element', 'carousel', 'table', 'form', 'layer', 'laydate', 'laytpl' ], function() {
		var carousel = layui.carousel;
		var table = layui.table, form = layui.form, 
			layer = layui.layer, $ = layui.jquery,
			laydate = layui.laydate, laytpl = layui.laytpl,
			element = layui.element;
		//导航栏点击
		element.on('nav(filter)', function(elem) {
			console.log(elem); //得到当前点击的DOM对象
		});
		var table = layui.table;
		table.render({
			elem : '#project',
			id : 'tableOne',
			height : 'full-200',
			url : 'myproject.action', //数据接口
			//data:{roletype:$('input:radio[name="sex"]:checked').val()},
			skin : "nob",
			cols : [ [ //表头
			{
				align : 'center',
				field : '',
				title : '序号',
				type : 'numbers',
				width : 100
			}, {
				field : 'proname',
				title : '项目名称',
				align : 'center'
			}, {
				field : 'userid',
				title : '学号/工号',
				align : 'center'
			//sort: true //是否排序
			}, {
				field : 'username',
				title : '姓名',
				align : 'center'
			},{
				field : 'classname',
				title : '班级',
				align : 'center'
			}, {
				field : 'collegename',
				title : '学院',
				align : 'center'
			},{
				field : '',
				title : '项目类型',
				align : 'center',
				templet : function(data) {
					if (data.protype == 1) {
						return "学生个人赛"
					} else if (data.protype == 2) {
						return "学生团体赛"
					} else if (data.protype == 3) {
						return "教师个人赛"
					} else if (data.protype == 4) {
						return "教师团体赛"
					}
				}
			} ] ],
			page : true,
			even : true,
			limit : 10,
			limits : [ 5,10, 15 ],
			skin : "nob",
		});
		//单选框点击事件
		form.on('radio(erweima)', function (data) {
            //alert(data.elem);
            //console.log(data.elem);
            //alert(data.value);//判断单选框的选中值
            //console.log(data.value);
            //alert(data.othis);
            //layer.tips('开关checked：' + (this.checked ? 'true' : 'false'), data.othis);
            //layer.alert('响应点击事件');
            if(data.value=="学生"){
            	$(".search").show();
            }
            if(data.value=="教职工"){
            	$(".search").hide();
            	//alert($("#major").val()+","+$("#classes").val());
				$("#major").val("");
				$("#classes").val("")
            }
            if(data.value=="all"){
            	$(".search").show();
				$("#major").val("");
				$("#classes").val("")
            }
            table.reload('tableOne', {
				method : 'post',
				where : {
					collegeid:$("#college").val(),
					majorid:$("#major").val(),
					classid:$("#classes").val(),
					roletype:data.value,
					userid:$("#userid").val(),
				},
				page : {
					curr : 1
				}
			});
        });
		$(function() {
			//$(".search").hide();
			$.ajax({
				url : "getcollege.action?op=histogram",
				type : "POST",
				data : null,
				dataType : 'json',
				contentType : 'application/json;charset=UTF-8',//contentType 很重要
				success : function(e) {
					//alert(e.data[0].collegeid);
					var s = $("#college").html();
					var str = "<option value='0'>请选择学院</option>";
					for(var i=0;i<e.data.length;i++){
						str += "<option value="+e.data[i].collegeid+">"+e.data[i].collegename+"</option>"
					}
					$("#college").append(str);
					form.render("select");
				},
				error : function(e) {
					layer.alert("error:"+e.msg);
				}
	
			})
		});
		/* 点击查询对网站用户进行筛选 */
		$("#search").click(function() {
			//alert($("#major").val()+","+$("#classes").val());
			//alert($("#btnradio").val());
			var roletype=$('input:radio[name="sex"]:checked').val();
			//alert(roletype);
			table.reload('tableOne', {
				method : 'post',
				where : {
					collegeid:$("#college").val(),
					majorid:$("#major").val(),
					classid:$("#classes").val(),
					roletype:roletype,
					userid:$("#userid").val()
				},
				page : {
					curr : 1
				}
			});
		});
		
		/* 下拉框三级联动 */
		var $ = layui.jquery;
		form.render('select');
		form.on('select(college)',function(data) {
			var hosid = data.value;
			$.ajax({
				type : "post",
				url : "getmajor.action",
				data : {
					collegeid : hosid
				},
				dataType : "json",
				success : function(succ) {
					if (succ == "失败") {
						layer
								.msg("请刷新后重试");
					} else {
						var tmp = '<option value="0">请选择专业</option>';
						for ( var i in succ.data) {
							tmp += '<option value="' + succ.data[i].majorid +  '">'
									+ succ.data[i].majorname
									+ '</option>';
						}
						$("#major").html(tmp);
						var tmp2 = '<option value="0">请选择班级</option>';
						$("#class").html(tmp2);
						form.render();
					}
				},
				error : function() {
					layer.msg('请求失败，稍后再试',{icon : 5});
				}
			});
		});
		form.on('select(major)',function(data) {
			var hosid = data.value;
			$.ajax({
				type : "post",
				url : "getclass.action",
				data : {
					majorid : hosid
				},
				dataType : "json",
				success : function(succ) {
					if (succ == "失败") {
						layer.msg("请刷新后重试");
					} else {
						var tmp = '<option value="0">请选择或输入班级名称</option>';
						for ( var i in succ.data) {
							tmp += '<option value="' + succ.data[i].classid +  '">'
									+ succ.data[i].classname
									+ '</option>';
						}
						$("#classes").html(tmp);
						form.render();
					}
				},
				error : function() {
					layer.msg('请求失败，稍后再试',{icon : 5});
				}
			});
		});
	})
</script>
</html>