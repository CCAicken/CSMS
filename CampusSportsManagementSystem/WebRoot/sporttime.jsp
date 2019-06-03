<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%@ include file="importhead.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'sporttime.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <link rel="stylesheet" href="css/sportTime.css" />
  </head>
  <body>
 	<div id="img">
 		 <img id="images" alt="" src="images/main.jpg">
 		 <div class='text-reflect-base'>2019.4.15-4.20</div>
<div class='text-reflect'>校 园 运 动 会</div>
 	</div>
  </body>
</html>
