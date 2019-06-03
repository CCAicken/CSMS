<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">

<head runat="server">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>个人中心</title>
    <link rel="stylesheet" href="css/bootstrap.min.css" />
    <link rel="stylesheet" href="css/xcConfirm.css" />
    <link rel="stylesheet" href="css/zwh.css" />
</head>

<body>
    <form id="form1">
        <div class="box">
            <div class="title">个人中心</div>
            <div class="center col-xs-8 col-xm-8 col-md-6 col-lg-6 col-xs-push-2 col-sm-push-2 col-md-push-3 col-lg-push-3">
                <table class="table table-hover">
                    <tbody>
                        <tr>
                            <td class="centerLable">账号：</td>
                            <td></td>
                            <td id="ID">${loginuser.userid }</td>
                        </tr>
                        <tr>
                            <td class="centerLable">姓名：</td>
                            <td></td>
                            <td id="name">${loginuser.username }</td>
                        </tr>
                        <tr>
                            <td class="centerLable">性别：</td>
                            <td></td>
                            <td id="gender">${loginuser.agend }</td>
                        </tr>
                        <c:if test="${usertype==1 }">
                        <tr>
                            <td class="centerLable">学院：</td>
                            <td></td>
                            <td id="college">${loginuser.classes.major.college.collegename }</td>
                        </tr>
                        <tr>
                            <td class="centerLable">专业：</td>
                            <td></td>
                            <td id="profession">${loginuser.classes.major.majorname }</td>
                        </tr>
                        <tr>
                            <td class="centerLable">班级：</td>
                            <td></td>
                            <td id="profession">${loginuser.classes.classname }</td>
                        </tr>
                        </c:if>
                        <c:if test="${usertype!=1 }">
	                        <tr>
	                            <td class="centerLable">学院：</td>
	                            <td></td>
	                            <td id="college">${loginuser.college.collegename }</td>
	                        </tr>
                        </c:if>
                        <tr>
                            <td class="centerLable">联系电话：</td>
                            <td></td>
                            <td id="telNum">${loginuser.mobile }</td>
                        </tr>
                        <tr>
	                        <td></td>
	                        <td></td>
                            <td>
                                <a href="changePwd.jsp">
                                    <button type="button" class="btn btn-info">修改密码</button></a>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </form>
</body>
<script src="js/jquery-3.3.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/xcConfirm.js"></script>
<script src="js/zwh.js"></script>
</html>
