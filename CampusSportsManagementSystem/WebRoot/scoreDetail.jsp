<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ include file="importhead.jsp"%>
<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>查看个人成绩</title>
    <link rel="stylesheet" href="css/bootstrap.min.css" />
    <link rel="stylesheet" href="css/style.css" />
    <link rel="stylesheet" href="css/lgd.css" />
</head>
<body class="viewScore-body">
    <div class="container viewscore-divbox">
        <h3 class="text-primary"></h3>
        <h3 class="text-primary"></h3>
        <div class="panel panel-heading text-center viewScore_panelhead">
            <h2>校运会成绩查询</h2>
        </div>
        <div class="panel panel-body text-center viewScore_panelbody">
<!--             <div> -->
<!--                 <table class="table table-studentInfo" style="border:0px;"> -->
<!--                     <tr> -->
<!--                         <td class="viewScoreStudentinfo text-right">姓名:</td> -->
<!--                         <td class="viewScoreStudentinfo text-left">张三</td> -->
<!--                         <td class="viewScoreStudentinfo text-right">学号:</td> -->
<!--                         <td class="viewScoreStudentinfo text-left">1321112321</td> -->
<!--                     </tr> -->
<!--                     <tr>
<!--                         <td class="viewScoreStudentinfo text-right">学号:</td> -->
<!--                         <td class="viewScoreStudentinfo text-left"></td> -->
<!--                     </tr> -->
<!--                 </table> -->
<!--             </div> -->
            <div class="table-score">
                <table class="table table-bordered table-scoreTable">
                    <thead>
	                    <c:if test="${op.equals('user') }">
	                        <tr style="background-color:#ccc;">
	                            <td class="viewScoreStudentinfo">账号：${user.userid }</td>
	                            <td class="viewScoreStudentinfo">姓名：${user.username }</td>
	                        </tr>
                        </c:if>
                        <c:if test="${op.equals('college') }">
	                        <tr style="background-color:#ccc;">
	                            <td class="viewScoreStudentinfo">学院：</td>
	                            <td class="viewScoreStudentinfo">${college.collegename }</td>
	                        </tr>
                        </c:if>
                        <c:if test="${op.equals('class') }">
	                        <tr style="background-color:#ccc;">
	                            <td class="viewScoreStudentinfo">班级：</td>
	                            <td class="viewScoreStudentinfo">${classes.classname }</td>
	                        </tr>
                        </c:if>
                        <tr>
                            <td class="viewScoreStudentinfo">项目名称</td>
                            <td class="viewScoreStudentinfo">得分</td>
                        </tr>
                    </thead>
                    <tbody>
	                    <c:forEach items="${scoreList }" var="obj">
	                        <tr>
		                        <c:if test="${obj.match.project.protype==1 }">
	                            	<td>${obj.match.project.proname }(学生个人赛)</td>
	                            </c:if> 
	                            <c:if test="${obj.match.project.protype==2 }">
	                            	<td>${obj.match.project.proname }(学生团体赛)</td>
	                            </c:if> 
	                            <c:if test="${obj.match.project.protype==3 }">
	                            	<td>${obj.match.project.proname }(教师个人赛)</td>
	                            </c:if> 
	                            <c:if test="${obj.match.project.protype==4 }">
	                            	<td>${obj.match.project.proname }(教师团体赛)</td>
	                            </c:if> 
	                            <td>${obj.scorenumber }</td>
	                        </tr>
	                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="panel panel-footer viewScore_panelfooter text-right">
            <button type="button" class="btn btn-success">返回</button>
        </div>
    </div>
</body>
<script src="js/jquery-3.3.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</html>
