$(document).ready(function () {
	$("#safecode").click(function(){
		var myDate = new Date();
		$("img").attr("src", "safecode.do?"+myDate.getMilliseconds())
	})
	$("#btnSubmit").click(function(){
		var userName = $("#userName").val();
		var pwd = $("#pwd").val();
		var captcha = $("#captcha").val();
		//var usertype = $('input:radio:checked').val();
		if(userName == ""){
			window.wxc.xcConfirm("用户名不能为空", window.wxc.xcConfirm.typeEnum.error)
		}else if(pwd == ""){
			window.wxc.xcConfirm("密码不能为空", window.wxc.xcConfirm.typeEnum.error)
		}else if(captcha == ""){
			window.wxc.xcConfirm("验证码不能为空", window.wxc.xcConfirm.typeEnum.error)
		}else{
			$.ajax({
                type: 'Post',
                url: 'login.do',
                data: {
                	userName: userName,
                	pwd: pwd,
                	//usertype: usertype,
                	captcha:captcha,
                    op: "login"
                },
                dataType: 'text',
                success: function (succ) {
                	if(succ == "登录成功"){
                        window.location.href="main.jsp";
//                		window.wxc.xcConfirm(succ, window.wxc.xcConfirm.typeEnum.success, {
//	                        onOk: function (v) {
//	                        }
//	                    });
                	}else{
	                    window.wxc.xcConfirm(succ, window.wxc.xcConfirm.typeEnum.error, {
	                        onOk: function (v) {
	                            window.location.reload();
	                        }
	                    });
                	}
                }
            });
		}
	})
})