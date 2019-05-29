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
    <title>个人成绩查看页面</title>
</head>

<body>
    <div class="layui-container">
        <div calss="layui-card">
            <div class="layui-card-header layui-bg-gray text-center" style="height: 80px;">
                <div class="layui-row">
                    <h1>个人成绩查看页面</h1>
                </div>
            </div>
            <div class="layui-card-body">
                <div class="layui-row layui-form">
                    <div class="layui-inline">
                        <div class="layui-input-inline">
                            <select name="college" id="college" lay-filter="college" lay-verify="required" lay-search="">
                                            <option value="0">选择或输入学院名称</option>
                                            <c:forEach items="${listcollege}" var="obj">
                                            <option value="${obj.collegeid }">${obj.collegename }</option>
                                            </c:forEach>
                                        </select>
                        </div>
                    </div>
                    <div class="layui-inline">
                        <div class="layui-input-inline">
                            <select name="major" id="major" lay-filter="major" lay-verify="required" lay-search="">
                                    <option value="">选择或输入专业名称</option>
                                </select>
                        </div>
                    </div>
                    <div class="layui-inline">
                        <div class="layui-input-inline">
                            <select name="class" id="class" lay-filter="class" lay-verify="required" lay-search="">
                                    <option value="">选择或输入班级名称</option>
                                </select>
                        </div>
                    </div>
                </div>
                <div class="layui-row">
                    <table class="layui-table" id="scoretable" lay-filter="demo"></table>
                </div>
            </div>
        </div>
    </div>
    <%@include file="footer.jsp" %>
</body>
<script src="layui/layui.all.js"></script>
<script src="js/jquery-2.1.1.min.js" charset="utf-8"></script>
<script id="barDemo" type="text/html">
    <button class="layui-btn layui-btn-sm layui-bg-green query">查看详情</button>
</script>
<script type="text/javascript">
    layui.use(['table', 'form','jquery'], function() {
		/* 动态表格绑定数据 */
        var table = layui.table;
        table.render({
            elem: '#scoretable',
            height: '800px', //高度最大化减去差值,
            url: 'getscore.action?op=single',
            page: true,
            even: true,
            limit:10,
            limits:[5,10,15],
            skin: "nob",
            cellMinWidth: 35, //全局定义常规单元格的最小宽度，layui 2.2.1 新增
                //,toolbar: '#toolbarDemo'
            title: '用户数据表',
            cols: [
                [{
                	align:'center',
                    field: '',
                    width: 80,
                    title: '序号',
                    type:'numbers'
                },{
                	align:'center',
                    field: 'userid',
                    title: '学号/工号',
                    width: 130
                },{
                	align:'center',
                    field: '',
                    title: '姓名',
                    width: 100,
                    templet:function(data){
                    	if(data.protype == 1 || data.protype == 2){
                    		return data.username;
                    	}else{
                    		return data.teausername;
                    	}
                    }
                },{
                	align:'center',
                    field: 'scorenumber',
                    title: '平均成绩',
                    width: 100
                }, {
                	align:'center',
                    field: '',
                    width: 130,
                    title: '学院名称',
                    templet:function(data){
                    	if(data.protype == 1 || data.protype == 2){
                    		return data.collegename;
                    	}else{
                    		return data.teacollegename;
                    	}
                    }
                }, {
                	align:'center',
                    field: '',
                    width: 200,
                    title: '专业名称',
                    templet:function(data){
                    	if(data.protype == 1 || data.protype == 2){
                    		return data.majorname;
                    	}else{
                    		return "";
                    	}
                    }
                }, {
                	align:'center',
                    field: '',
                    title: '班级名称',
                    width: 250,
                    templet:function(data){
                    	if(data.protype == 1 || data.protype == 2){
                    		return data.classname;
                    	}else{
                    		return "";
                    	}
                    }
                },{
                	align:'center',
                    field: '',
                    title: '操作',
                    width: 120,
					toolbar:'#barDemo'
                },{
                    field: '',
                    title: '用户角色id',
                    hide:true,
                    templet:function(data){
                    	if(data.protype == 1 || data.protype == 2){
                    		return 1;
                    	}else{
                    		return 2;
                    	}
                    }
                }]
            ]
        });
       	/* 下拉框三级联动 */
		var form = layui.form;
		var $ = layui.jquery;
		form.render('select');
 
		//医院下拉选事件,获取科室下拉选
		form.on('select(college)', function(data) {
			var hosid = data.value;
			//alert(hosid);
			$.ajax({
				type : "post",
				url : "${pageContext.request.contextPath}/userManger/getDivision1",
				data : {hosid:hosid},
				dataType : "json",
				success : function(d) {
					 var tmp = '<option value="">--请选择--</option>';
					 //改变医院时第三级下拉框回复原样
					 $("#division2").html(tmp);
					 for ( var i in d) {
						 tmp += '<option value="' + d[i].id +  '">' + d[i].divisionName + '</option>';
					}
					 $("#division1").html(tmp);					
					 form.render(); 
				},
				error:function(){
					layer.alert('请求失败，稍后再试', {icon: 5});
				}
 
			});
		});
    });
    //查看详情点击事件
    $(document).on('click', ".query", function() {
	    var userid = $(this).parent().parent().prev().prev().prev().prev().prev().prev().children().text().trim();
	    var usertype = $(this).parent().parent().next().children().text().trim();
		window.location.href="getscore.action?op=singledetail&userid="+userid+"&usertype="+usertype;
	});
</script>
</html>