<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">

<head runat="server">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="renderer" content="webkit" />
    <title>登录界面</title>
    <link rel="stylesheet" href="css/bootstrap.min.css" />
    <link rel="stylesheet" href="css/login.css" />
    <link rel="stylesheet" href="css/xcConfirm.css" />
</head>

<body class="body" id="mydiv">
    <div class="container" id="login">
        <div class="panel-heading" id="heading">
            <span>校园运动会管理系统</span>
        </div>
        <hr />
        <div class="panel-body">
            <div class="input-group" id="content">
                <span class="input-group-addon">
                        <span class="glyphicon glyphicon-user"></span>
                </span>
                <input type="text" class="form-control ordinaryUser" id="userName" placeholder="用户名" autofocus="autofocus" />
            </div>

            <div class="input-group" id="content">
                <span class="input-group-addon">
                        <span class="glyphicon glyphicon-lock"></span>
                </span>
                <input type="password" class="form-control ordinaryUserPwd" id="pwd" placeholder="密码" />
            </div>

            <div class="input-group" id="content">
                <span class="input-group-addon">
                        <span class="glyphicon glyphicon-briefcase"></span>
                </span>
                <input type="text" class="form-control" id="captcha" placeholder="验证码" />
                <!-- <img src="checkCode.aspx" id="code" onclick="refreshCode()" />-->
                <div class="row">
<!--                 <div id="photo"><img src="images/varify.png" width="22px" height="22px"/></div> -->
                <span id="varify"> 
                <img id="safecode" src="safecode.do" style="width:120px; height:33px;margin-left:10px;"/>
                </span>
                </div>
            </div>
            <div class="form-group">
                <!-- <div class="radio">
                    <label>
                            <input type="radio" name="user" value="teacher" checked="" />
                            教师
                        </label>
                    <label>
                            <input type="radio" name="user" value="student" checked="checked" />
                            学生
                        </label>
                </div> -->
                <div id="btn">
                    <button type="button" class="btn btn-default col-xs-3 col-sm-3 col-md-3 col-lg-3 col-xs-push-2 col-sm-push-2 col-md-push-2 col-lg-push-2" onclick="formReset()">重置</button>
                    <button type="button" class="btn btn-info col-xs-3 col-sm-3 col-md-3 col-lg-3 col-xs-push-4 col-sm-push-4 col-md-push-4 col-lg-push-4" id="btnSubmit">
                            登录
                        </button>
                </div>
            </div>
        </div>
        <!-- <div class="panel-heading text-right" id="heading">
            <span><a href="register.do">注册>></a></span>
        </div> -->
    </div>
</body>
<script src="js/jquery-3.3.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/xcConfirm.js"></script>
<script src="js/jsencrypt.min.js"></script>
<script src="js/zwh.js"></script>
<script src="js/login.js"></script>

</html>