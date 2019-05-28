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
                <div class="layui-row" id="app">
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
                        <tbody id="scoretable_tbody" v-for="(data,index) in this.data">
                                <tr>
                                    <!-- <td class="text-center"><input type="checkbox" /></td> -->
                                    <td class="text-center">
                                        <nobr>{{data.proname }}</nobr>
                                    </td>
                                    <td class="text-center">
                                        <nobr>{{data.scorenumber }}</nobr>
                                    </td>
                                </tr>
                                <tr class="layui-bg-green">
                                    <!-- <td class="text-center"><input type="checkbox" /></td> -->
                                    <td class="text-center">
                                        <nobr>总成绩：{{data.totalScore }}</nobr>
                                    </td>
                                    <td class="text-center">
                                        <nobr>平均成绩：{{data.avgScore }}</nobr>
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
<script src="js/vue.js"></script>
<script type="text/javascript">
var vue = new Vue({
		el : "#app",
		data : {
			data : [],
		},
		created : function() {
			this.loadData(); //ҳ�����
		},
		methods : {
			loadData : function() {
				var _this = this;
				var partid = getUrlParms("keshi");
				$.ajax({
					type : 'Post',
					url : '/Outpatient/Depart',
					data : {
						partid : partid,
						op : "keshiys"
					},
					dataType : 'json',
					success : function(data) {
						_this.data = data;
					},
					error : function(XMLHttpRequest, textStatus) { //����ʧ��
						if (textStatus == 'timeout') {
							var xmlhttp = window.XMLHttpRequest ? new window.XMLHttpRequest() : new ActiveXObject("Microsoft.XMLHttp");
							xmlhttp.abort();
							alert("����ʱ");
						} else if (textStatus == "error") {
							alert("�������ڲ�����");
						} else if (textStatus == "parsererror") {
							alert("�������ʹ���");
						}
					}
				})
			}
		},
	});
</script>
</html>