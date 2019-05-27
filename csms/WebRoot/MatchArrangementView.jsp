<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>比赛安排</title>
    <link rel="stylesheet" href="layui/css/layui.css">
    <style>
    </style>
</head>

<body>
    <div class="layui-card">
        <div class="layui-card-header">
            <h2>比赛安排</h2>
        </div>
        <div class="layui-card-body">
            <div class="layui-form-item">
                <div class="layui-input-inline">
                    <input type="password" name="password" required lay-verify="required" placeholder="请输入查询条件"
                        autocomplete="off" class="layui-input">
                </div>
                <div class="layui-input-inline" style="margin-left: -10px;">
                    <button type="button" class="layui-btn layui-btn">查询</button>
                </div>
            </div>
            <table class="layui-table" id="matchlist" lay-filter="test" width="100%"></table>
            <!-- <table class="layui-table">
                <colgroup>
                    <col width="70">
                    <col width="200">
                    <col width="150">
                    <col width="150">
                    <col width="150">
                    <col width="150">
                </colgroup>
                <thead>
                    <tr>
                        <th>序号</th>
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
                        <td>1</td>
                        <td>1000米</td>
                        <td>第一次</td>
                        <td>2019-5-20 9:00</td>
                        <td>2019-5-20 9:20</td>
                        <td>田径场</td>
                        <td>半决赛</td>
                        <td>未比赛</td>
                    </tr>
                </tbody>
            </table> -->
        </div>
    </div>
    <%@include file="footer.jsp" %>
</body>
<script src="layui/layui.js"></script>
<script src="js/jquery-2.1.1.min.js" charset="utf-8"></script>
<!-- <script id="barDemo" type="text/html">
  <button type="button" lay-event="add" class="layui-btn layui-btn-xs">前往报名</button>
</script> -->
<script>
layui.use(['element', 'carousel', 'table'], function() {
        var element = layui.element;
        var carousel = layui.carousel;
        //导航栏点击
        element.on('nav(filter)', function(elem) {
            console.log(elem); //得到当前点击的DOM对象
        });
        var table = layui.table;
        table.render({
            elem: '#matchlist',
            height: 500,
            url: 'getmacth.action', //数据接口
            cols: [
                [ //表头
                    {
                        field: '',
                        title: '序号',
                        width: 100,
                        type:'numbers'
                    }, {
                        field: 'proname',
                        title: '项目名称',
                        width: 200
                    },  {
                        field: '',
                        title: '项目类型',
                        width: 200,
						templet:function(data){
							if(data.protype == 1){
								return "学生个人赛"
							}else if(data.protype == 2){
								return "学生团体赛"
							}else if(data.protype == 3){
								return "教师个人赛"
							}else if(data.protype == 4){
								return "教师团体赛"
							}
						}
                    }, {
                        field: '',
                        title: '参赛者',
                        width: 150,
                        templet:function(data){
	                        if(data.protype==1||data.protype==2){
	                         	return data.username
	                        }else{
	                        	return data.teausername
	                        }
                        }
                    },{
                        field: '',
                        title: '性别',
                        width: 80,
                        templet:function(data){
	                        if(data.protype==1||data.protype==2){
	                         	return data.agend
	                        }else{
	                        	return data.teaagend
	                        }
                        }
                    },{
                        field: '',
                        title: '联系电话',
                        width: 150,
                        templet:function(data){
	                        if(data.protype==1||data.protype==2){
	                         	return data.mobile
	                        }else{
	                        	return data.teamobile
	                        }
                        }
                    },{
                        field: '',
                        title: '所属学院/部门',
                        width: 200,
                        templet:function(data){
	                        if(data.protype==1||data.protype==2){
	                         	return data.collegename
	                        }else{
	                        	return data.teacollegename
	                        }
                        }
                    },{
	                    field: '',
	                    title: '班级',
	                    width: 200,
	                    templet:function(data){
	                     if(data.protype==1||data.protype==2){
	                      	return data.classname
	                     }else{
	                     	return ""
	                     }
	                    }
                    }
                    /* , {
                        field: '',
                        title: '操作',
                        width: 140,
                        toolbar: '#barDemo'
                    } */
                ]
            ],
            page: true, //开启分页
            even: true, //每行颜色分隔
            skin: 'nob', //无边框
            limit: 10,
            limits: [5, 10, 15]
                /* first:true,
                last:true, */
        });
        //监听工具条
        table.on('tool(demo)', function(obj) {
            var data = obj.data;
            if (obj.event === 'add') {
                layer.alert('报名')
            }
        });
    });
</script>
</html>