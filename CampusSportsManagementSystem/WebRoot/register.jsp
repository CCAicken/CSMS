<%@page import="model.Major"%>
    <%@page import="java.util.List"%>
        <%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
            <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
                <!DOCTYPE html>

                <html xmlns="http://www.w3.org/1999/xhtml">

                <head runat="server">
                    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
                    <title>学生注册</title>
                    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
                    <link rel="stylesheet" type="text/css" href="css/zwh.css" />
                    <link rel="stylesheet" type="text/css" href="css/xcConfirm.css" />
                </head>

                <body id="regBody">
                    <div class="container col-xs-8 col-sm-8 col-md-6 col-lg-4 col-xs-push-2 col-sm-push-2 col-md-push-3 col-lg-push-4" id="bigbox">
                        <div class="container-fluid" id="regmain">
                            <div class="container-style">
                                <form class="form-horizontal" role="form" id="regform" method="post" action="login.aspx">

                                    <table class="table table-hover">
                                        <thead>
                                            <h1 class="col-xs-10 col-sm-10 col-md-6 col-lg-6 col-xs-push-4 col-sm-push-4 col-md-push-4 col-lg-push-4">账号注册</h1>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td id="regLable">
                                                    <label for="" class="control-label">学院:</label>
                                                </td>
                                                <td>
                                                    <select class="form-control input-sm select-drop" id="college">
                                        <option value="0">--请选择学院--</option>
                                        <c:if test="${collegeid==null }">
                                        ${collegeid.trim() }
	                                        <c:forEach items="${collegelist }" var="obj">
	                                        	<option value="${obj.collegeid }">${obj.collegename }</option>
	                                        </c:forEach>
                                        </c:if>
                                        <c:if test="${collegeid!=null }">
	                                        <c:forEach items="${collegelist }" var="obj">
                                        <option value="${collegeid.equals(obj.collegeid) }">${obj.collegename}</option>
	                                        	<c:if test="${collegeid.equals(obj.collegeid) }">
	                                        		<option value="${obj.collegeid }" selected="selected">${obj.collegename }</option>
	                                        	</c:if>
	                                        	<c:if test="${!collegeid.equals(obj.collegeid) }">
	                                        		<option value="${obj.collegeid }">${obj.collegename }</option>
	                                        	</c:if>
	                                        </c:forEach>
                                        </c:if>
                                    </select>
                                                    <span id="validateColl"></span>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td id="regLable">
                                                    <label class="control-label">专业:</label>
                                                </td>
                                                <td>
                                                    <select class="form-control input-sm select-drop" id="major">
                                        <option value="0">--请选择专业--</option>
                                        <c:if test="${majorid==null }">
                                            <c:forEach items="${majorlist }" var="obj">
                                                <option value="${obj.majorid }">${obj.majorname }</option>
                                            </c:forEach>
                                        </c:if>
                                        <c:if test="${majorid!=null }">
                                            <c:forEach items="${majorlist }" var="obj">
                                                <c:if test="${majorid.equals(obj.majorid) }">
                                                    <option value="${obj.majorid }" selected="selected">${obj.majorname }</option>
                                                </c:if>
                                                <c:if test="${!majorid.equals(obj.majorid) }">
                                                    <option value="${obj.majorid }">${obj.majorname }</option>
                                                </c:if>
                                            </c:forEach>
                                        </c:if>
                                    </select>
                                                    <span id="validatePro"></span>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td id="regLable">
                                                    <label class="control-label">班级:</label>
                                                </td>
                                                <td>
                                                    <select class="form-control input-sm select-drop" id="classes">
                                        <option value="0">--请选择班级--</option>
                                        <c:if test="${majorid!=null }">
	                                        <c:forEach items="${classlist }" var="obj">
	                                        	<option value="${obj.classid }">${obj.classname }</option>
	                                        </c:forEach>
                                        </c:if>
                                    </select>
                                                    <span id="validatePro"></span>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td id="regLable">
                                                    <label class="control-label">账号:</label>
                                                </td>
                                                <td>
                                                    <input type="text" class="form-control input-sm input" id="userid" name="usercount" placeholder="请输入学号" />
                                                    <span id="validateAccount"></span>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td id="regLable">
                                                    <label class="control-label">姓名:</label>
                                                </td>
                                                <td>
                                                    <input type="text" class="form-control input-sm input" id="username" name="username" placeholder="请输入姓名" />
                                                    <span id="validateName"></span>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td id="regLable">
                                                    <label class="control-label">性别:</label>
                                                </td>
                                                <td>
                                                    <label>
                                        <input type="radio" name="agend" value="男" checked="checked" />
                                        男
                                    </label>
                                                    <label>
                                        <input type="radio" name="agend" value="女" />
                                        女
                                    </label>
                                                    <span id="validateSex"></span>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td id="regLable">
                                                    <label class="control-label">密码:</label>
                                                </td>
                                                <td>
                                                    <input type="password" class="form-control input-sm input" id="pwd" name="regPwd" placeholder="请输入密码" />
                                                    <span id="validatePwd"></span></td>
                                            </tr>
                                            <tr>
                                                <td id="regLable">
                                                    <label class="control-label">确认密码:</label></td>
                                                <td>
                                                    <input type="password" class="form-control input-sm input" id="confirmpwd" name="confirmPwd" placeholder="请再次输入密码" />
                                                    <span id="validateConfirmPwd"></span></td>
                                            </tr>
                                            <tr>
                                                <td id="regLable">
                                                    <label class="control-label">联系电话:</label></td>
                                                <td>
                                                    <input type="text" class="form-control input-sm input" id="mobile" name="usertel" placeholder="请输入电话号码" />
                                                    <span id="validateTelNum"></span></td>
                                            </tr>
                                            <!--<tr>
                                <td id="regLable">
                                    <label class="control-label">验证码:</label></td>
                                <td>
                                    <input type="text" class="input-sm" id="regCode" name="telverify" placeholder="请输入验证码" />
                                    <button class="btn-primary btn-sm" type="button" id="getCode">获取验证码</button>
                                    <span id="validateCode"></span></td>
                            </tr>-->
                                        </tbody>
                                    </table>
                                    <div class="form-group">
                                        <div class="col-sm-offset-2">
                                            <button type="button" class="btn btn-info col-xs-9 col-sm-9 col-md-10 col-lg-10 col-xs-push-2 col-sm-push-1 col-md-push-1" id="btnAdd" onclick="cmdEncrypt();">立即注册</button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </body>
                <script src="js/jquery-3.3.1.min.js"></script>
                <script src="js/bootstrap.min.js"></script>
                <script src="js/xcConfirm.js"></script>
                <script src="js/register.js"></script>
                <script src="js/jsencrypt.min.js"></script>

                </html>