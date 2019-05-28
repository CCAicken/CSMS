<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                    <h1>${title }成绩详情页面</h1>
                </div>
            </div>
            <div class="layui-card-body">
                <div class="layui-row">
                    <table class="layui-table" id="scoretable">
                        <thead>
                            <tr>
                                <th class="text-center">
                                    <nobr>项目名称</nobr>
                                </th>
                                <th class="text-center">
                                    <nobr>成绩</nobr>
                                </th>
                            </tr>
                        </thead>
                        <c:if test="${obj.protype==1||obj.protype==2}">
                        <tbody id="scoretable_tbody">
	                        <c:if test="${type=='college' }">
	                        <tr><td colspan="2">学生成绩</td></tr>
	                        </c:if>
                            <c:forEach items="${scorelist }" var="obj">
                                <tr>
                                <c:if test="${obj.protype==1}">
                                    <td class="text-center">
                                        <nobr>${obj.proname }(个人赛)</nobr>
                                    </td>
                                    </c:if>
                                    <c:if test="${obj.protype==2}">
                                    <td class="text-center">
                                        <nobr>${obj.proname }(团体赛)</nobr>
                                    </td>
                                    </c:if>
                                    <td class="text-center">
                                        <nobr>${obj.scorenumber }</nobr>
                                    </td>
                                </tr>
                            </c:forEach>
                                <tr class="layui-bg-green">
                                    <c:if test="${type!='college' }">
                                    <td class="text-center">
                                        <nobr>总成绩：${totalScore}</nobr>
                                    </td>
                                    <td class="text-center">
                                        <nobr>平均成绩：${avgScore }</nobr>
                                    </td>
                                    </c:if>
                                    <c:if test="${type=='college' }">
                                    <td class="text-center">
                                        <nobr>总成绩：${stuTotalScore}</nobr>
                                    </td>
                                    <td class="text-center">
                                        <nobr>平均成绩：${stuAvgScore }</nobr>
                                    </td>
                                    </c:if>
                                </tr>
                        </tbody>
						</c:if>
						<c:if test="${obj.protype==3||obj.protype==4}">
                        <tbody id="scoretable_tbody">
	                        <c:if test="${type=='college' }">
	                        <tr><td colspan="2">教师成绩</td></tr>
	                        </c:if>
                            <c:forEach items="${scorelist }" var="obj">
                                <tr>
                                <c:if test="${obj.protype==3}">
                                    <td class="text-center">
                                        <nobr>${obj.proname }(个人赛)</nobr>
                                    </td>
                                    </c:if>
                                    <c:if test="${obj.protype==4}">
                                    <td class="text-center">
                                        <nobr>${obj.proname }(团体赛)</nobr>
                                    </td>
                                    </c:if>
                                    <td class="text-center">
                                        <nobr>${obj.scorenumber }</nobr>
                                    </td>
                                </tr>
                            </c:forEach>
                                <tr class="layui-bg-green">
                                    <!-- <td class="text-center"><input type="checkbox" /></td> -->
                                    <td class="text-center">
                                        <nobr>总成绩：${teaTotalScore}</nobr>
                                    </td>
                                    <td class="text-center">
                                        <nobr>平均成绩：${teaAvgScore }</nobr>
                                    </td>
                                </tr>
                        </tbody>
						</c:if>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <%@include file="footer.jsp" %>
</body>
<script src="layui/layui.all.js"></script>

</html>