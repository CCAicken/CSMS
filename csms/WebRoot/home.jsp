<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Document</title>
<link rel="stylesheet" type="text/css" href="layui/css/layui.css">

</head>
</head>

<body>
	<div class="layui-row">
		<div class="layui-col-md3 layui-col-lg3">
			<div class="layui-fluid layui-col-md12 layui-col-lg12">
				<div class="layui-card">
					<div class="layui-card-header">
						<b><span style="font-size:18px;">运动会公告</span></b>
					</div>
					<div class="layui-card-body">
						<table class="layui-table" id="table-title" lay-skin="nob">
						</table>
					</div>
				</div>
				<!--运动会公告结束-->
			</div>
		</div>
		<div class="layui-col-md8 layui-col-lg8" style="width:74%">
			<div class="layui-carousel" id="lb">
				<div carousel-item>
					<img src="image/2.jpg"> <img src="image/10.jpg"> <img
						src="image/5.jpg"> <img src="image/6.jpg"> <img
						src="image/7.jpg">
				</div>
			</div>
			<!--轮播结束-->
		</div>
	</div>
	<div class="layui-row layui-col-space30">
		<div class="layui-fluid" style="width:95%">
			<div class="layui-col-md12 layui-col-lg12">
				<div class="layui-card">
					<div class="layui-card-header">
						<b><span style="font-size:18px;">运动会热讯</span></b>
					</div>
					<div class="layui-card-body">
						<div class="layui-row layui-col-space20">
							<div class="layui-card layui-col-md4 layui-col-lg4">
								<div class="layui-card-header">
									<b><span style="font-size:14px;">热点文章</span></b> <a
										href="forumList.jsp"><span style="float:right">更多>></span></a>
								</div>
								<div class="layui-card-body">
									<table class="layui-table" id="table-forum" lay-skin="nob"></table>
								</div>
							</div>
							<div class="layui-card layui-col-md4 layui-col-lg4">
								<div class="layui-card-header">
									<b><span style="font-size:14px;">项目报名情况</span></b> <a
										href="arrangeview.action?op=list"><span
										style="float:right">更多>></span></a>
								</div>
								<div class="layui-card-body">
									<table class="layui-table" id="table-application"
										lay-skin="nob"></table>

								</div>
							</div>
							<div class="layui-card layui-col-md4 layui-col-lg4">
								<div class="layui-card-header">
									<b><span style="font-size:14px;">学院成绩排名</span></b>
								</div>
								<div class="layui-card-body">
									<table class="layui-table" id="table-score" lay-skin="nob"></table>
								</div>
							</div>

							<div class="layui-card layui-col-md12 layui-col-lg12">
								<div class="layui-card-header">
									<b><span style="font-size:14px;">数据统计</span></b>
								</div>
								<div class="layui-card-body layui-col-space30">
									<div class="layui-col-md6 layui-col-lg6">
										<div id="main" style="height:500px"></div>
									</div>
									<div class="layui-col-md6 layui-col-lg6">
										<div id="z" style="height:500px"></div>
									</div>
								</div>
							</div>

							<div class="layui-card layui-col-md12 layui-col-lg12">
								<div class="layui-card-header">
									<b><span style="font-size:14px;">精彩瞬间</span></b>
								</div>
								<div class="layui-card-body">
									<div id="div-img">
										<ul>
											<li><img src="image/1.jpg" /></li>
											<li><img src="image/2.jpg" /></li>
											<li><img src="image/3.jpg" /></li>
											<li><img src="image/4.jpg" /></li>
										</ul>
									</div>
								</div>
							</div>
						</div>

					</div>
				</div>
				<!--运动会热讯end-->
			</div>
		</div>
	</div>
	<%@include file="footer.jsp"%>
</body>
<script src="layui/layui.js" charset="utf-8"></script>
<script src="js/jquery-2.1.1.min.js" charset="utf-8"></script>
<script src="js/home.js" charset="utf-8"></script>

<script src="https://cdn.bootcss.com/echarts/4.1.0.rc2/echarts.min.js"></script>
<script>
	z = echarts.init(document.getElementById("z"));
	option = {
		title : {
			text : '各分院分数统计',
			subtext : '数据未绑定'
		},
		tooltip : {
			trigger : 'axis'
		},
		legend : {
			data : [ '信息工程学院', '人文学院','护理学院' ]
		},
		toolbox : {
			show : true,
			feature : {
				mark : {
					show : true
				},
				dataView : {
					show : true,
					readOnly : false
				},
				magicType : {
					show : true,
					type : [ 'line', 'bar' ]
				},
				restore : {
					show : true
				},
				saveAsImage : {
					show : true
				}
			}
		},
		calculable : true,
		xAxis : [ {
			type : 'category',
			data : [ '跳高', '跳远', '100米', '200米', '400米', '1000米', '铅球']
		} ],
		yAxis : [ {
			type : 'value'
		} ],
		series : [
				{
					name : '信息工程学院',
					type : 'bar',
					data : [ 80.5,78,88,90,86,83,86],
					markPoint : {
						data : [ {
							type : 'max',
							name : '最大值'
						}, {
							type : 'min',
							name : '最小值'
						} ]
					},
					markLine : {
						data : [ {
							type : 'average',
							name : '平均值'
						} ]
					}
				},
				{
					name : '人文学院',
					type : 'bar',
					data : [82.5,79,78,91,86.5,82.1,85.6 ],
					markPoint : {
						data : [ {
							type : 'max',
							name : '最大值'
						}, {
							type : 'min',
							name : '最小值'
						} ]
					},
					markLine : {
						data : [ {
							type : 'average',
							name : '平均值'
						} ]
					}
				},{
					name : '护理学院',
					type : 'bar',
					data : [ 86.5,90,85.3,91.5,86.2,80.2,82.1],
					markPoint : {
						data : [ {
							type : 'max',
							name : '最大值'
						}, {
							type : 'min',
							name : '最小值'
						} ]
					},
					markLine : {
						data : [ {
							type : 'average',
							name : '平均值'
						} ]
					}
				}  ]
	};
	z.setOption(option);

	myChart = echarts.init(document.getElementById("main"));
	option = {
		title : {
			text : '项目人数统计',
			subtext:'数据未绑定'
		},
		tooltip : {
			trigger : 'axis',
			axisPointer : {
				type : 'cross',
				label : {
					backgroundColor : '#6a7985'
				}
			}
		},
		legend : {
			data : [ '跳高', '跳远', '100米', '200米', '400米', '1000米', '铅球' ]
		},
		toolbox : {
			feature : {
				saveAsImage : {}
			}
		},
		grid : {
			left : '3%',
			right : '4%',
			bottom : '3%',
			containLabel : true
		},
		xAxis : [ {
			type : 'category',
			boundaryGap : false,
			data : [ '信息工程学院', '人文学院', '护理学院', '交通机电学院', '汉语文学院' ]
		} ],
		yAxis : [ {
			type : 'value'
		} ],
		series : [ {
			name : '跳高',
			type : 'line',
			stack : '总量',
			areaStyle : {},
			data : [ 20, 11, 12, 21, 5, 6, 10 ]
		}, {
			name : '跳远',
			type : 'line',
			stack : '总量',
			areaStyle : {},
			data : [ 25, 8, 11, 12, 21, 22, 3 ]
		}, {
			name : '100米',
			type : 'line',
			stack : '总量',
			areaStyle : {},
			data : [ 10, 12, 21, 3, 8, 15, 18 ]
		}, {
			name : '200米',
			type : 'line',
			stack : '总量',
			areaStyle : {
				normal : {}
			},
			data : [ 2, 5, 9, 11, 10, 21, 11 ]
		}, {
			name : '400米',
			type : 'line',
			stack : '总量',
			label : {
				normal : {
					show : true,
					position : 'top'
				}
			},
			areaStyle : {
				normal : {}
			},
			data : [ 8, 6, 13, 11, 20, 21, 10 ]
		},{
			name : '1000米',
			type : 'line',
			stack : '总量',
			label : {
				normal : {
					show : true,
					position : 'top'
				}
			},
			areaStyle : {
				normal : {}
			},
			data : [ 13, 5, 7, 21, 14, 16, 20 ]
		},{
			name : '铅球',
			type : 'line',
			stack : '总量',
			label : {
				normal : {
					show : true,
					position : 'top'
				}
			},
			areaStyle : {
				normal : {}
			},
			data : [ 7, 11, 14, 20, 10, 18, 20	 ]
		} ]
	};
	myChart.setOption(option);
</script>

</html>