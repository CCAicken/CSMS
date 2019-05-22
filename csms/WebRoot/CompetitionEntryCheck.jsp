<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>报名查询</title>
    <link rel="stylesheet" href="layui/css/layui.css">

    <style>
    </style>
</head>

<body>
    <div class="layui-card">
        <div class="layui-card-header">
            <h2>报名查询</h2>
        </div>
        <div class="layui-card-body">
            <div class="layui-row layui-form">
                <div class="layui-input-inline">
                    <input type="password" name="password" required lay-verify="required" placeholder="请输入查询条件"
                        autocomplete="off" class="layui-input">
                </div>
                <div class="layui-input-inline" style="margin-left: -10px;">
                    <button type="button" class="layui-btn layui-btn">查询</button>
                </div>
                <div class="layui-input-inline">
                    <select name="modules" lay-verify="required" lay-search>
                        <option value="">选择或输入学院名称</option>
                        <option value="1">信息工程学院</option>
                        <option value="2">人文学院</option>
                        <option value="3">建筑工程学院</option>
                    </select>
                </div>
                <div class="layui-input-inline">
                    <select name="modules" lay-verify="required" lay-search>
                        <option value="">请选择班级名称</option>
                        <option value="1">信息工程学院</option>
                        <option value="2">人文学院</option>
                        <option value="3">建筑工程学院</option>
                    </select>
                </div>
            </div>
            <div class="layui-row layui-form">
                <table class="layui-table">
                    <colgroup>
                        <col width="70">
                        <col width="100">
                        <col width="150">
                        <col width="150">
                        <col width="150">
                        <col width="150">
                        <col width="150">
                        <col width="150">
                        <col width="150">
                        <col width="150">
                        <col width="150">
                    </colgroup>
                    <thead>
                        <tr>
                            <th>学号</th>
                            <th>姓名</th>
                            <th>班级</th>
                            <th>院系</th>
                            <th>项目名称</th>
                            <th>场次</th>
                            <th>开始时间</th>
                            <th>结束时间</th>
                            <th>比赛地点</th>
                            <th>比赛级别</th>
                            <th>比赛状态</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>16612500036</td>
                            <td>慧慧</td>
                            <td>16级软件班</td>
                            <td>信息工程学院</td>
                            <td>1000米</td>
                            <td>第一次</td>
                            <td>2019-5-20 9:00</td>
                            <td>2019-5-20 9:20</td>
                            <td>田径场</td>
                            <td>半决赛</td>
                            <td>未比赛</td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <%@include file="footer.jsp" %>
</body>
<script src="layui/layui.all.js"></script>
<script>
    layui.use(['form', 'layedit', 'laydate'], function () {
        var form = layui.form,
            layer = layui.layer,
            layedit = layui.layedit,
            laydate = layui.laydate;

        //日期
        laydate.render({
            elem: '#date'
        });
        laydate.render({
            elem: '#date1'
        });

        //创建一个编辑器
        var editIndex = layedit.build('LAY_demo_editor');

        //自定义验证规则
        form.verify({
            title: function (value) {
                if (value.length < 5) {
                    return '标题至少得5个字符啊';
                }
            },
            pass: [
                /^[\S]{6,12}$/, '密码必须6到12位，且不能出现空格'
            ],
            content: function (value) {
                layedit.sync(editIndex);
            }
        });

        //监听指定开关
        form.on('switch(switchTest)', function (data) {
            layer.msg('开关checked：' + (this.checked ? 'true' : 'false'), {
                offset: '6px'
            });
            layer.tips('温馨提示：请注意开关状态的文字可以随意定义，而不仅仅是ON|OFF', data.othis)
        });

        //监听提交
        form.on('submit(demo1)', function (data) {
            layer.alert(JSON.stringify(data.field), {
                title: '最终的提交信息'
            })
            return false;
        });

        //表单初始赋值
        form.val('example', {
            "username": "贤心" // "name": "value"
            ,
            "password": "123456",
            "interest": 1,
            "like[write]": true //复选框选中状态
            ,
            "close": true //开关状态
            ,
            "sex": "女",
            "desc": "我爱 layui"
        })


    });
</script>

</html>