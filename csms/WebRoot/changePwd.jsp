<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <link rel="stylesheet" type="text/css" href="layui/css/layui.css">
        <title>Insert title here</title>
    </head>

    <body>
        <div class="layui-container">
            <div style="margin:10px auto;width:800px;">
                <div class="layui-card">
                    <div class="layui-card-header" style="color: cornflowerblue;padding: 5px 0;">
                        <h1 style="margin-left:20px">修改密码</h1>
                    </div>
                    <div class="layui-card-body">
                        <form class="layui-form" action="">
                            <div class="layui-form-item">
                                <label class="layui-form-label">账号</label>
                                <div class="layui-input-block">
                                    <input type="text" disabled="disabled" name="user.userid" required lay-verify="required" placeholder="请输入账号" autocomplete="off" class="layui-input layui-bg-gray">
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <label class="layui-form-label">旧密码</label>
                                <div class="layui-input-block">
                                    <input type="text" name="user.pwd" required lay-verify="required" placeholder="请输入一个用于登录的密码" autocomplete="off" class="layui-input">
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <label class="layui-form-label">新密码</label>
                                <div class="layui-input-block">
                                    <input type="text" name="newpwd" required lay-verify="required" placeholder="请再次输入登录密码进行确认" autocomplete="off" class="layui-input">
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <label class="layui-form-label">密码确认</label>
                                <div class="layui-input-block">
                                    <input type="text" name="confirmpwd" required lay-verify="required" placeholder="请再次输入登录密码进行确认" autocomplete="off" class="layui-input">
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <div class="layui-input-block">
                                    <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
                                    <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="footer.jsp" %>
    </body>
    <script src="layui/layui.js" charset="utf-8"></script>
    <script>
	layui.use('form', function(){
	  var form = layui.form;
	});
	</script>
    </html>