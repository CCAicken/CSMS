<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>文章内容</title>
    <link rel="stylesheet" href="layui/css/layui.css">
</head>

<body>
    <div class="layui-card">
        <div class="layui-card-header">
            <span class="layui-breadcrumb">
				<a href="home.jsp">首页</a>
				<a href="forumList.jsp">文章列表</a>
				<a><cite>文章内容</cite></a>
			</span>
        </div>
        <div class="layui-card-body">
            <table width="80%" style="border-bottom:1px solid #ccc;margin-bottom:15px;">
            	<tr>
                	<td id = "articletopic" ><h2>标题：${forum.title }</h2></td>
                    <td id = "articlereview"><h2>作者：${forum.author }</h2></td>
                    <td id = "articlecreate"><h2>时间：${forum.createtime }</h2></td>
                </tr>
            </table>
            <div id="content">
                <table>
                <c:forEach items="${listcontent }" var="content">
                    <tr>
                        <td><img src="${content.picpath }" width="80%"></td>
                    </tr>
                    <tr>
                        <td>${content.textcontent }</td>
                    </tr>
                 </c:forEach>
                </table>
            </div>
        </div>
    </div>
    <%@include file="footer.jsp" %>
</body>
<script src="layui/layui.js"></script>
<script>
layui.use(['form','element'], function() {
        var form = layui.form;
        var element = layui.element;
        });
</script>
</html>