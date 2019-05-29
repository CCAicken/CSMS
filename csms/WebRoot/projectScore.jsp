<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="layui/css/layui.css" rel="stylesheet" type="text/css" />
    <style>
        .text-center {
            text-align: center;
        }
    </style>
    <title>项目成绩查看页面</title>
</head>

<body>
    <div class="layui-container">
        <div calss="layui-card">
            <div class="layui-card-header layui-bg-gray text-center" style="height: 80px;">
                <div class="layui-row">
                    <h1>项目成绩查看页面</h1>
                </div>
            </div>
            <div class="layui-card-body">
                <div class="layui-row layui-form">
                    <div class="layui-input-inline">
                        <select name="college" id="college" lay-filter="college" lay-verify="required" lay-search="">
                            <option value="">请选择或输入学院名称</option>
                            <c:forEach items="${listcollege}" var="obj">
                            <option value="${obj.collegeid }">${obj.collegename }</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="layui-input-inline">
                        <select name="user" id="user" lay-filter="user" lay-verify="required" lay-search="">
                                <option value="student" selected="selected">学生</option>
                                <option value="teacher">教师</option>
                            </select>
                    </div>
                    <div class="layui-input-inline" style="margin-left: -10px;">
						<button type="button" class="layui-btn layui-btn" lay-submit
						lay-filter="search">查询</button>
					</div>
                </div>
                <div class="layui-row">
                    <table class="layui-table" id="scoretable" lay-filter="demo"></table>
                </div>
            </div>
        </div>
    </div>
    <%@include file="footer.jsp" %>
</body>
<script src="layui/layui.js"></script>
<script src="js/jquery-2.1.1.min.js" charset="utf-8"></script>
<script type="text/javascript">
    layui.use(['table', 'laydate', 'layer', 'jquery','form'], function() {
        var table = layui.table;
        var $ = layui.jquery;
        var laydate = layui.laydate;
        var layer = layui.layer;
        var form = layui.form;
        //页面加载获取动态表格数据
        table.render({
        	id : 'tableOne',
            elem: '#scoretable',
            height: '800px', //高度最大化减去差值,
            url: 'getprojectscore.action?user=student',
            page: true,
            even: true,
            limit:5,
            limits:[5,10,15],
            skin: "nob",
            cellMinWidth: 35, //全局定义常规单元格的最小宽度，layui 2.2.1 新增
                //,toolbar: '#toolbarDemo'
            title: '用户数据表',
            cols: [
                [{
                	align:'center',
                    field: '',
                    width: 100,
                    title: '序号',
                    type:'numbers'
                }, {
                	align:'center',
                    field: 'proname',
                    width: 150,
                    title: '项目名称',
                    sort:true
                }, {
                	align:'center',
                    field: '',
                    width: 150,
                    title: '参赛者',
                    templet:function(data){
	                    if(data.protype==1||ata.protype==1){
	                    	return data.username
	                    }else{
	                    	return data.teausername
	                    }
                    }
                }, {
                	align:'center',
                    field: '',
                    title: '学院名称',
                    width: 150,
                    sort:true,
                    templet:function(data){
	                    if(data.protype==1||ata.protype==1){
	                    	return data.collegename
	                    }else{
	                    	return data.teacollegename
	                    }
                    }
                },{
                	align:'center',
                    field: '',
                    title: '参赛者身份',
                    width: 100,
                    templet:function(data){
	                    if(data.protype==1||ata.protype==1){
	                    	return "学生"
	                    }else{
	                    	return "教师"
	                    }
                    }
                },{
                	align:'center',
                    field: 'scorenumber',
                    title: '成绩',
                    width: 120,
                    sort:true
                }]
            ]
        });
		//查询提交
		form.on('submit(search)', function(data) {
			table.reload('tableOne', {
				method : 'post',
				where : {
					'collegeid' : data.field.college,
					'user' : data.field.user
				},
				page : {
					curr : 1
				}
			});

			return false;
		});
	});
</script>
</html>