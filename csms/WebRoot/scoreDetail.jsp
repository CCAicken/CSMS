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
                    <h1>信息工程学院成绩详情页面</h1>
                </div>
            </div>
            <div class="layui-card-body">
                <div class="layui-row">
                    <table class="layui-table" id="scoretable">
                        <thead>
                            <!--<th class="text-center"><input type="checkbox"
                                class="js-checkbox-all" /></th>-->
                            <tr>
                                <th class="text-center">
                                    <nobr>项目名称</nobr>
                                </th>
                                <th class="text-center">
                                    <nobr>成绩</nobr>
                                </th>
                            </tr>
                        </thead>
                        <tbody id="scoretable_tbody">
                            <c:forEach items="scorelist" var="obj">
                                <tr>
                                    <!-- <td class="text-center"><input type="checkbox" /></td> -->
                                    <td class="text-center">
                                        <nobr>${obj.proname }</nobr>
                                    </td>
                                    <td class="text-center">
                                        <nobr>${obj.scorenumber }</nobr>
                                    </td>
                                </tr>
                            </c:forEach>
                                <tr class="layui-bg-green">
                                    <!-- <td class="text-center"><input type="checkbox" /></td> -->
                                    <td class="text-center">
                                        <nobr>总成绩：264</nobr>
                                    </td>
                                    <td class="text-center">
                                        <nobr>平均成绩：88</nobr>
                                    </td>
                                </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <%@include file="footer.jsp" %>
</body>
<script src="layui/layui.all.js"></script>

</html>