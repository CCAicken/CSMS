$(document).ready(function (){
	$("#btnSumbit").click(function (){
		var userid = $("#userid").val().trim();
		var oldpwd = $("#oldpwd").val().trim();
		var newpwd = $("#newpwd").val().trim();
		var confirmPwd = $("#confirmPwd").val().trim();
		
		if(oldpwd==""){
			window.wxc.xcConfirm("原密码不能为空", window.wxc.xcConfirm.typeEnum.error);
		}else if(newpwd == ""){
			window.wxc.xcConfirm("新密码不能为空", window.wxc.xcConfirm.typeEnum.error);
		}else if(confirmPwd == ""){
			window.wxc.xcConfirm("确认密码不能为空", window.wxc.xcConfirm.typeEnum.error);
		}else if(newpwd != confirmPwd){
			window.wxc.xcConfirm("两次密码不一致", window.wxc.xcConfirm.typeEnum.error);
		}else{
			$.ajax({
	            type: 'Post',
	            url: 'changepwd.do',
	            data: {
	            	userid:userid,
	            	oldpwd:oldpwd,
	            	newpwd: newpwd,
	                op: "change"
	            },
	            dataType: 'text',
	            success: function (succ) {
	                if (succ === "修改成功") {
	                    window.wxc.xcConfirm(succ, window.wxc.xcConfirm.typeEnum.success, {
	                        onOk: function (v) {
	                            window.location.href="singleCenter.jsp";
	                        }
	                    });
	                }else{
	                	window.wxc.xcConfirm(succ, window.wxc.xcConfirm.typeEnum.error);
	                }
	            }
	        });
		}
	})
})