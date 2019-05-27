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
            <table width="80%">
            	<tr>
                	<td id = "articletopic" >${forum.title }</td>
                    <td id = "articlereview">${forum.author }</td>
                    <td id = "articlecreate">${forum.createtime }</td>
                </tr>
            </table>
        </div>
        <div class="layui-card-body">
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

</html>