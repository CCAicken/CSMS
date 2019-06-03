function pagination(pageCount) {
            $('.paging').pagination({
                mode: 'fixed',
                pageCount: pageCount,
                coping: true,
                homePage: '首页',
                endPage: '末页',
                prevContent: '上页',
                nextContent: '下页',
                jump: true,
                callback: function (api) {
                    var data = {
                        page: api.getCurrent()
                    };
                    $.getJSON(
                        data,
                        function (json) {

                        });
                }
            });
        };

$(this).ready(function(){
	$("#table").delegate(".sure", "click", function () {
		var proid = $(this).parent().prev().text().trim();
//		var currentnum = $(this).parent().prev().prev().prev().find("nobr").text().trim();
//		alert(currentnum+proid);
		$.ajax({
			url : "projectregistrantionservlet.do",
			type : "POST",
			dataType : "json",
			data : {
				proid:proid,
				op : "add"
			},
			success: function (succ) {
	        	if(succ.flag == 10001){
	        		window.wxc.xcConfirm(succ.msg, window.wxc.xcConfirm.typeEnum.success, {
		                onOk: function (v) {
		                	window.location.reload();
		                }
		            });
	        	}else{
		            window.wxc.xcConfirm(succ.msg, window.wxc.xcConfirm.typeEnum.error);
	        	}
	        }
		})
	});
})