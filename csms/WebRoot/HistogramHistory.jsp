<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<style>
body {
    background-color: #fff;
    overflow: hidden;
      overflow-y: scroll;
    
}
body::-webkit-scrollbar {
        display: none;
    }
</style>
</head>
<body>
	<div class="layui-container">
		<div id="main" style="width:750px;height:450px;margin:0 auto"></div>
	</div>
</body>
<script src="js/echarts.common.min.js"></script>
<script src="js/jquery-2.1.1.min.js"></script>
<script src="layui/layui.js" charset="utf-8"></script>
<script>
layui.use(['element','layer', 'carousel', 'table','jquery'], function(){
	var element = layui.element;
	var carousel = layui.carousel;
	var table = layui.table;
	var jquery = layui.jquery;
	var layer = layui.layer;
	
	var myChart = echarts.init(document.getElementById('main'));
	option = {
	    title: {
	        text: '各届分院总积分图'
	    },
	    tooltip : {
	        trigger: 'axis',
	        axisPointer: {
	            type: 'cross',
	            label: {
	                backgroundColor: '#6a7985'
	            }
	        }
	    },
	    legend: {/* 分组类型 */
	        data:[]
	    },
	    toolbox: {
	        feature: {
	            saveAsImage: {}
	        }
	    },
	    grid: {
	        left: '3%',
	        right: '4%',
	        bottom: '3%',
	        containLabel: true
	    },
	    xAxis : [
	        {
            	position: 'bottom',
	            type : 'category',
	            boundaryGap : false,
	            id:[],
	            data : []
	        }
	    ],
	    yAxis : [
	        {
	            type : 'value'
	        }
	    ],
	    series : [
	        {
	            name:'',
	            type:'line',
	            stack: '总量',
	            areaStyle: {normal: {}},
	            data:[]
	        }
	        /* {
	            name:'总成绩',
	            type:'line',
	            stack: '总量',
	            label: {
	                normal: {
	                    show: true,
	                    position: 'top'
	                }
	            },
	            areaStyle: {normal: {}},
	            data:[]
	        } */
	    ]
	};
	myChart.setOption(option);
	$(document).ready(function(){
		getxAxis();
		function getxAxis(){
			$.ajax({
				type : "post",
				url : "getcollege.action?op=histogram",
				data : {},
				dataType : "json",
				success : function(succ) {
					if (succ.code == 1) {
						layer.msg('请求失败，稍后再试',{icon : 5});
					} else {
						/* 横坐标 */
						var xCollege = new Array();
						var xid = new Array();
						/* 接收数据 */
						var newseries = new Array();
						/* 数据初始化为空*/
						var newScore = new Array();
						for(var i=0;i<succ.data.length;i++){
							xCollege.push(succ.data[i].collegename);
							xid.push(succ.data[i].collegeid);
						}
						/* 折线类型 */
						var legends = new Array();
						for(var i=0;i<succ.data1.length;i++){
							/* 添加数据数量对应折线类型数量 */
							legends.push(succ.data1[i].sportname);
							/* 获取数据类型模板 */
							var serie = {
					            name:succ.data1[i].sportname,
					            type:'line',
					            stack: '总量',
					            areaStyle: {normal: {}},
					            data:[]
					        };
							newseries.push(serie);
						}
						var optionjson = option;
						optionjson.xAxis[0].data = xCollege;
						optionjson.xAxis[0].id = xid;
						optionjson.legend.data = legends;
						optionjson.series = newseries;
						//myChart.setOption(optionjson);
						//获取数据
						$.ajax({
							type : "post",
							url : "getscore.action?op=getallscore",
							data : {},
							dataType : "json",
							success : function(succ2) {
								if (succ2.code == 1) {
									layer.msg('请求失败，稍后再试',{icon : 5});
								} else {
									//var optionjson = option;
									var xid = option.xAxis[0].id;
									for(var i=0;i<optionjson.series.length;i++){
										optionjson.series[i].data = succ2.data[i];
									}
									myChart.setOption(optionjson);
								}
							},
							error : function() {
								layer.msg('请求失败，稍后再试',{icon : 5});
							}
						});
					}
				},
				error : function() {
					layer.msg('请求失败，稍后再试',{icon : 5});
				}
			});
		}
	});
});
	
</script>
</html>