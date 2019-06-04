/** t图片滚动 */
window.onload = function() {
	var odiv = document.getElementById('div-img');
	var oul = odiv.getElementsByTagName('ul')[0];
	var ali = oul.getElementsByTagName('li');
	var spa = -2;
	oul.innerHTML = oul.innerHTML + oul.innerHTML;
	oul.style.width = ali[0].offsetWidth * ali.length + 'px';

	function move() {
		if (oul.offsetLeft < -oul.offsetWidth / 2) {
			oul.style.left = '0';
		}
		if (oul.offsetLeft > 0) {
			oul.style.left = -oul.offsetWidth / 2 + 'px'
		}
		oul.style.left = oul.offsetLeft + spa + 'px';
	}
	var timer = setInterval(move, 30)

}

/** layui模块调取 */
layui.use(['element', 'carousel', 'table'], function() {
	var element = layui.element;
	var carousel = layui.carousel;
	var table = layui.table;
	// 轮播
	carousel.render({
		elem : '#lb',
		width : '100%' // 设置容器宽度
		,
		height : 600,
		arrow : 'always' // 始终显示箭头
			// ,anim: 'updown' //切换动画方式
		});
	// 标题表格
	table.render({
				elem : '#table-title',
				height : 513,
				url : "getnew.action?newsId=" // 数据接口
				,
				page : false // 开启分页
				,
				cols : [[ // 表头
				{
					field : '',
					title : '',
					templet : function(d) {
						return "<a href='getnew.action?newsId=" + d.newid + "'>"
								+ d.newstitle + "</a>"
					}
				}]],
				done : function(res, curr, count) {

					$('#table-title').next().find('.layui-table-header').css({
								"display" : "none"
							});
					// $('th').hide();// 表头隐藏的样式
					// $('.layui-table .layui-table-cell >
					// span').css({'font-weight' : 'bold'});// 表头字体样式
					/*
					 * $('th').css({'background-color': '#5792c6', 'color':
					 * '#fff','font-weight':'bold'}) 表头的样式
					 * $('.layui-table-page').css('margin-top', '40px');//
					 * 页码部分的高度调整
					 */
				}

			})

	// 热点文章表格
	table.render({
				elem : '#table-forum',
				height : 200,
				url : "getforum.action" // 数据接口
				,
				page : false // 开启分页
				,
				cols : [[ // 表头
				{
					field : '',
					title : '',
					templet : function(d) {
						return "<a href='getcontent.action?op=byforumid&titleid="
								+ d.forumid + "'>" + d.title + "</a>"
					}
				}]],
				done : function(res, curr, count) {
					$('#table-forum').next().find('.layui-table-header').css({
								"display" : "none"
							});
					// $('th').hide();// 表头隐藏的样式
					// $('.layui-table .layui-table-cell >
					// span').css({'font-weight' : 'bold'});// 表头字体样式
					/*
					 * $('th').css({'background-color': '#5792c6', 'color':
					 * '#fff','font-weight':'bold'}) 表头的样式
					 * $('.layui-table-page').css('margin-top', '40px');//
					 * 页码部分的高度调整
					 */
				}

			})
	// 项目报名情况表格
	table.render({
				elem : '#table-application',
				height : 200,
				url : "getapplication.action?op=app" // 数据接口
				,
				page : false // 开启分页
				,
				cols : [[ // 表头
				{
							field : '',
							title : '项目名称',
							templet : function(d) {
								if (d.protype == 0) {
									return d.proname + "(个人赛)"
								} else if (d.protype == 1) {
									return d.proname + "(学生团体赛)"
								} else {
									return d.proname + "(教师团体赛)"
								}

							},
							width:150
						}, {
							field : 'currentnum',
							title : '已报人数'
						}, {
							field : 'totallimit',
							title : '人数限制'
						}]],
				done : function(res, curr, count) {

					// $('th').hide();// 表头隐藏的样式
					// $('.layui-table .layui-table-cell >
					// span').css({'font-weight' : 'bold'});// 表头字体样式
					/*
					 * $('th').css({'background-color': '#5792c6', 'color':
					 * '#fff','font-weight':'bold'}) 表头的样式
					 * $('.layui-table-page').css('margin-top', '40px');//
					 * 页码部分的高度调整
					 */
				}

			})
	// 报名排行
	table.render({
				elem : '#table-score',
				height : 200,
				url : "getapplication.action?op=score" // 数据接口
				,
				page : false // 开启分页
				,
				cols : [[ // 表头
				{
							field : '',
							title : '排名',
							type:'numbers'
						},
				{
							field : 'collegename',
							title : '学院名称'
						}, {
							field : 'scorenumber',
							title : '学院分数',
							sort:true
						}]],
				done : function(res, curr, count) {

					// $('th').hide();// 表头隐藏的样式
					// $('.layui-table .layui-table-cell >
					// span').css({'font-weight' : 'bold'});// 表头字体样式
					/*
					 * $('th').css({'background-color': '#5792c6', 'color':
					 * '#fff','font-weight':'bold'}) 表头的样式
					 * $('.layui-table-page').css('margin-top', '40px');//
					 * 页码部分的高度调整
					 */
				}

			})

});