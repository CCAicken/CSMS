<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<style>
body {
    background-color: rgb(209, 207, 207);
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
	        text: '分院积分排行图'
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
	        data:['平均成绩','总成绩']
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
	            name:'平均成绩',
	            type:'line',
	            stack: '总量',
	            areaStyle: {normal: {}},
	            data:[]
	        },
	        {
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
	        }
	    ]
	};
	myChart.setOption(option);
	$(document).ready(function(){
		getxAxis();
		getdata();
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
						var xCollege = new Array();
						var xid = new Array();
						var avgScore = new Array();
						var sumScore = new Array();
						for(var i=0;i<succ.data.length;i++){
							xCollege.push(succ.data[i].collegename);
							xid.push(succ.data[i].collegeid);
							avgScore.push(0);
							sumScore.push(0);
						}
						var optionjson = option;
						optionjson.xAxis[0].data = xCollege;
						optionjson.xAxis[0].id = xid;
						optionjson.series[0].data = avgScore;
						optionjson.series[1].data = sumScore;
						myChart.setOption(optionjson);
					}
				},
				error : function() {
					layer.msg('请求失败，稍后再试',{icon : 5});
				}
			});
		}
		function getdata(){
			//获取数据
			$.ajax({
				type : "post",
				url : "getscore.action?op=allcollege",
				data : {},
				dataType : "json",
				success : function(succ2) {
					if (succ2.code == 1) {
						layer.msg('请求失败，稍后再试',{icon : 5});
					} else {
						var optionjson = option;
						var xid = option.xAxis[0].id;
						var avgScore = optionjson.series[0].data;
						var sumScore = optionjson.series[1].data;
						for(var i=0;i<xid.length;i++){
							for(var j=0;j<succ2.data.length;j++){
								if(xid[i] == succ2.data[j].collegeid){
									avgScore[i] = succ2.data[j].scorenumber;
									sumScore[i] = succ2.data[j].allscore;
								}
							}
						}
						optionjson.series[0].data = avgScore;
						optionjson.series[1].data = sumScore;
						myChart.setOption(optionjson);
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