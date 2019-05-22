<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
    <title>Document</title>
</head>

<body>
    <div class="layui-container">
        <div calss="layui-card">
            <div class="layui-card-header layui-bg-gray text-center" style="height: 80px;">
                <div class="layui-row">
                    <h1>专业成绩查看页面</h1>
                </div>
            </div>
            <div class="layui-card-body">
                <div class="layui-row layui-form">
                    <div class="layui-inline">
                        <div class="layui-input-inline">
                            <select name="modules" lay-verify="required" lay-search>
                                    <option value="">选择或输入学院名称</option>
                                    <option value="1">信息工程学院</option>
                                    <option value="2">人文学院</option>
                                    <option value="3">建筑工程学院</option>
                                </select>
                        </div>
                    </div>
                    <div class="layui-inline">
                        <div class="layui-input-inline">
                            <select name="modules" lay-verify="required" lay-search>
                                    <option value="">选择或输入专业名称</option>
                                    <option value="1">计算机科学与技术</option>
                                    <option value="2">软件工程</option>
                                    <option value="3">计算机网络</option>
                                </select>
                        </div>
                    </div>
                </div>
                <div class="layui-row">
                    <table class="layui-table" id="scoretable">
                        <thead>
                            <!--<th class="text-center"><input type="checkbox"
								class="js-checkbox-all" /></th>-->
                            <th class="text-center">
                                <nobr>序号</nobr>
                            </th>
                            <th class="text-center">
                                <nobr>学院名称</nobr>
                            </th>
                            <th class="text-center">
                                <nobr>专业名称</nobr>
                            </th>
                            <th class="text-center">
                                <nobr>平均成绩</nobr>
                            </th>
                            <th class="text-center">
                                <nobr>操作</nobr>
                            </th>
                        </thead>
                        <tbody id="scoretable_tbody">
                            <c:forEach items="" var="obj" varStatus="xh">
                                <tr>
                                    <!-- <td class="text-center"><input type="checkbox" /></td> -->
                                    <td class="text-center">
                                        <nobr>1</nobr>
                                    </td>
                                    <td class="text-center">
                                        <nobr>信息工程学院</nobr>
                                    </td>
                                    <td class="text-center">
                                        <nobr>计算机科学与技术</nobr>
                                    </td>
                                    <td class="text-center">
                                        <nobr>99</nobr>
                                    </td>
                                    <td class="text-center">
                                        <button class="layui-btn  layui-btn-sm layui-bg-green">查看详情</button>
                                    </td>
                                </tr>
                                <tr>
                                    <!-- <td class="text-center"><input type="checkbox" /></td> -->
                                    <td class="text-center">
                                        <nobr>2</nobr>
                                    </td>
                                    <td class="text-center">
                                        <nobr>信息工程学院</nobr>
                                    </td>
                                    <td class="text-center">
                                        <nobr>计算机科学与技术</nobr>
                                    </td>
                                    <td class="text-center">
                                        <nobr>99</nobr>
                                    </td>
                                    <td class="text-center">
                                        <button class="layui-btn  layui-btn-sm layui-bg-green">查看详情</button>
                                    </td>
                                </tr>
                                <tr>
                                    <!-- <td class="text-center"><input type="checkbox" /></td> -->
                                    <td class="text-center">
                                        <nobr>2</nobr>
                                    </td>
                                    <td class="text-center">
                                        <nobr>信息工程学院</nobr>
                                    </td>
                                    <td class="text-center">
                                        <nobr>计算机科学与技术</nobr>
                                    </td>
                                    <td class="text-center">
                                        <nobr>99</nobr>
                                    </td>
                                    <td class="text-center">
                                        <button class="layui-btn  layui-btn-sm layui-bg-green">查看详情</button>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <%@include file="footer.jsp" %>
</body>
<script src="layui/layui.all.js"></script>
<script>
    layui.use(['form', 'layedit', 'laydate'], function() {
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
            title: function(value) {
                if (value.length < 5) {
                    return '标题至少得5个字符啊';
                }
            },
            pass: [
                /^[\S]{6,12}$/, '密码必须6到12位，且不能出现空格'
            ],
            content: function(value) {
                layedit.sync(editIndex);
            }
        });

        //监听指定开关
        form.on('switch(switchTest)', function(data) {
            layer.msg('开关checked：' + (this.checked ? 'true' : 'false'), {
                offset: '6px'
            });
            layer.tips('温馨提示：请注意开关状态的文字可以随意定义，而不仅仅是ON|OFF', data.othis)
        });

        //监听提交
        form.on('submit(demo1)', function(data) {
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