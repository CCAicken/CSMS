<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>学生报名</title>
    <link rel="stylesheet" href="layui/css/layui.css">
    <style>
        table {
            text-align: center;
        }
    </style>
</head>

<body>
    <div class="layui-card">
        <div class="layui-card-header">
            <h2>比赛报名</h2>
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
            <table class="layui-table" id="userlist" lay-filter="test" width="100%"></table>
            <button class="layui-btn" id="sure_btn">确认报名</button>
        </div>
    </div>
    <%@include file="footer.jsp" %>
</body>
<script src="layui/layui.js"></script>
<script src="js/jquery-2.1.1.min.js"></script>
<script type="text/html" id="toolbarDemo">
  <div class="layui-btn-container">
    <button class="layui-btn layui-btn-sm tr-data" lay-event="getCheckData">获取选中行数据</button>
    <button class="layui-btn layui-btn-sm" lay-event="getCheckLength">获取选中数目</button>
    <button class="layui-btn layui-btn-sm" lay-event="isAll">验证是否全选</button>
  </div>
</script>
<script>
	var loc=location.href;
	var n1=loc.length;//地址的总长度
	var n2=loc.indexOf("=");//取得=号的位置
	var proid=decodeURI(loc.substr(n2+1, n1-n2));//从=号后面的内容
	alert(proid);
	
    layui.use(['element', 'carousel', 'table'], function() {
        var element = layui.element;
        var carousel = layui.carousel;
        //导航栏点击
        element.on('nav(filter)', function(elem) {
            console.log(elem); //得到当前点击的DOM对象
        });
        var table = layui.table;
        table.render({
            elem: '#userlist',
            height: 500,
            toolbar: '#toolbarDemo',
            url: 'entry.action', //数据接口
            cols: [
                [ //表头
                	{ type: 'checkbox' },
                    {
                        field: 'userid',
                        title: '学号/工号',
                        align:'center'
                    },{
                    	field: 'username',
                        title: '姓名',
                        align:'center'
                    },
                     {
                        field: 'agend',
                        title: '性别',
                        align:'center'
                    }, {
                        field: 'collegename',
                        title: '学院',
                        align:'center'
                        //sort: true //是否排序
                    }, {
                        field: '',
                        title: '班级',
                        align:'center',
						templet:function(data){
							if(data.classname == ""||data.classname==null){
								return "教职工没有班级";
							}else{
								return data.classname;
							}
						}
                    }
                ]
            ],
            page: true, //开启分页
            even: false, //每行颜色分隔
            //skin: 'nob', //无边框
            limit: 10,
            limits: [1, 10, 15,20],
                /* first:true,
                last:true, */
        });
        //头工具栏事件
	  table.on('toolbar(test)', function(obj){
		   var checkStatus = table.checkStatus(obj.config.id);
		   switch(obj.event){
		   	case 'getCheckData':
		       var data = checkStatus.data;
		       var str="";
		       for(var i=0;i<data.length;i++){
		       str+=data[i].userid+",";
		       }
		        //layer.alert(str);
		        $.ajax({
		        	type: "POST",
        			url: "entry.action",
			        data: {datastr:str,op:"add",proid:proid},  
			        dataType:"text",  
			        success: function(data){  
			        	alert(data);    
			        },  
			        error: function(json){  
			           alert("请刷新后重试...");  
			        }  
		        });
		      break;
		      case 'getCheckLength':
		        var data = checkStatus.data;
		        layer.msg('选中了：'+ data.length + ' 个');
		      break;
		      case 'isAll':
		        layer.msg(checkStatus.isAll ? '全选': '未全选');
		      break;
		    };
	  });
    });
    $("#sure_btn").click(function(){
    	alert($(".tr-data").val());
    })
</script>
</html>