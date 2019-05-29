<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>文章内容</title>
    <link rel="stylesheet" href="layui/css/layui.css">
    <style>
        /* table{
            text-align: center;
        } */
    </style>
</head>

<body>
    <div class="layui-card">
        <div class="layui-card-header">
            <h2>标题</h2>
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
            <table class="layui-table" id="forumlist" lay-filter="test" width="100%"></table>
        </div>
    </div>
    <%@include file="footer.jsp" %>
</body>
<script src="layui/layui.js"></script>
<script src="js/jquery-2.1.1.min.js" charset="utf-8"></script>
<script id="barDemo" type="text/html">
  <button type="button" lay-event="add" class="layui-btn layui-btn-xs baom">报名</button>
</script>
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
            elem: '#forumlist',
            height: 500,
            url: 'getproject.action', //数据接口
            cols: [
                [ //表头
                    {
                        field: '',
                        title: '序号',
                        width: 40,
                        type:'numbers'
                    },{
                    	field: 'proid',
                        title: '序号',
                        width: 40,
                        hide:true,
                    },
                     {
                        field: 'proname',
                        title: '项目名称',
                        width: 200
                    }, {
                        field: 'currentnum',
                        title: '当前报名人数',
                        width: 200
                        //sort: true //是否排序
                    }, {
                        field: 'totallimit',
                        title: '人数限制',
                        width: 200
                    }, {
                        field: '',
                        title: '项目类型',
                        width: 200,
						templet:function(data){
							if(data.protype == 1){
								return "<a href=''>学生个人赛</a>"
							}else if(data.protype == 2){
								return "<a href=''>学生团体赛</a>"
							}else if(data.protype == 3){
								return "<a href=''>教师个人赛</a>"
							}else if(data.protype == 4){
								return "<a href=''>教师团体赛</a>"
							}
						}
                    }, {
                        field: '',
                        title: '操作',
                        width: 200,
                        toolbar: '#barDemo'
                    }
                ]
            ],
            page: true, //开启分页
            even: false, //每行颜色分隔
            //skin: 'nob', //无边框
            limit: 10,
            limits: [1, 10, 15,20]
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
    $(document).on('click', ".baom", function() {
    	var currentnum = $(this).parent().parent().prev().prev().prev().find("div").text().trim();
   	 	var totalnum = $(this).parent().parent().prev().prev().find("div").text().trim();
   	 	if(parseInt(currentnum)>=parseInt(totalnum)){
   	 		layer.msg("该项目报名人数已达上限，请另外选择其他项目");
   	 	}
   	 	else{
		    var proid = $(this).parent().parent().prev().prev().prev().prev().prev().find("div").text().trim();
		    //layer.msg(proid);
		    window.location.href="studentSignUp.jsp?proid="+proid;
	    }
	});
</script>
</html>