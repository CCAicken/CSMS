$(document).ready(function () {
    //$("#regCode").width($("#telNum").width()-92);
    //正则表达式
    var txtAccount = /^[0-9]*$/; //数字的正则表达式
    var txtName = /^[a-zA-Z\u4e00-\u9fa5]+$/; //汉字、英文的正则表达式
    var txtpwd = /^[\x21-\x7E]{6,20}$/;//英文、数字或符号且长度在6-20之间
    //var txtEmail = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/; //邮箱的正则表达式
    var TelNum = /^1[3,5,4,7,8]\d{9}$/; //联系电话的正则表达式
    var txtPwd = /^[0-9a-zA-Z_]{1,}$/; //数字、英文、下划线的正则表达式
    var flag = false;
    //学院下拉框改变事件
    $("#college").change(function () {
        var collegeId = $("#college").val();
        window.location.href = "register.do?collegeid=" + collegeId + "&op=college";
//        $.ajax({
//            type: 'Post',
//            url: 'register.do',
//            data: {
//            	collegeid: collegeId,
//                op: "college"
//            },
//            dataType: 'text',
//            success: function (succ) {
//            	//window.location.reload();
//            }
//        });
    });
    //专业下拉框改变事件
    $("#major").change(function () {
        var majorid = $("#major").val();
        window.location.href = "register.do?majorid=" + majorid + "&op=major";
//        $.ajax({
//            type: 'Post',
//            url: 'register.do',
//            data: {
//            	majorid: majorid,
//                op: "major"
//            },
//            dataType: 'text',
//            success: function (succ) {
//            	//window.location.reload();
//            }
//        });
    });
    $("#btnAdd").click(function () {
        var pubKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCAnNXR7lHTpPH/97QOxIp+UusK9/RH5elvEPv6ssL37xGo8vQHh7CCsOonUWWVdi1iVegi7fRCkWeUVlta61EuX141+eKnZcdJe81NeUZ1h3N77JbzElbhhi8Wln6U27xpfkskKASLhQ4dS9DqoJQN/YUhBaBpER287Wjf3X6WmQIDAQAB";
        var encrypt = new JSEncrypt();
        encrypt.setPublicKey(pubKey);

        var collegeid = $("#college").val();
        var majorid = $("#major").val();
        var classid = $("#classes").val();
        var userid = $("#userid").val();
        var username = $("#username").val();
        var agend = $('input:radio:checked').val();
        var pwd = $("#pwd").val();
        var confirmpwd = $("#confirmpwd").val();
        var mobile = $("#mobile").val();
        //var code = $("#regCode").val();
        //alert(collegeId+":"+profession+":"+account+":"+name+":"+sex+":"+pwd+":"+confirmPwd+":"+email+":"+telNum+":"+code)
        if (collegeid === "0") {
            $("#validateColl").html("请选择学院！").css({ "color": "red", "font-size": "14px"});
        } else if (majorid === "0") {
            $("#validateColl").html("");
            $("#validatePro").html("请选择专业！").css({ "color": "red", "font-size": "14px" });
        } else if (classid === "0") {
            $("#validateColl").html("");
            $("#validatePro").html("请选择班级！").css({ "color": "red", "font-size": "14px" });
        } else if (userid === "") {
            $("#validatePro").html("");
            $("#validateAcoount").html("账号不能为空！").css({ "color": "red", "font-size": "14px" });
        } else if (!txtAccount.test(userid)) {
            $("#validateAccount").html("账号只能包括数字！").css({ "color": "red", "font-size": "14px" });
        } else if (username === "") {
            $("#validateAcoount").html("")
            $("#validateName").html("姓名不能为空！").css({ "color": "red", "font-size": "14px" });
        } else if (!txtName.test(username)) {
            $("#validateName").html("姓名只能包括汉子/英文字符！").css({ "color": "red", "font-size": "14px" });
        } else if (agend === "") {
            $("#validateName").html("")
            $("#validateSex").html("请选择性别！").css({ "color": "red", "font-size": "14px" });
        } else if (pwd === "") {
            $("#validateName").html("")
            $("#validatePwd").html("请输入密码！").css({ "color": "red", "font-size": "14px" });
        } else if (!txtpwd.test(pwd)) {
            $("#validateConfirmPwd").html("密码只能由字母、数字、下划线组成且长度为6-20位！").css({ "color": "red", "font-size": "14px" });
        } else if (confirmpwd === "") {
            $("#validatePwd").html("")
            $("#validateConfirmPwd").html("请输入确认密码！").css({ "color": "red", "font-size": "14px" });
        } else if (confirmpwd !== pwd) {
            $("#validateConfirmPwd").html("两次输入的密码不一致！").css({ "color": "red", "font-size": "14px" });
        } else if (mobile === "") {
            $("#validateEmail").html("")
            $("#validateTel").html("联系电话不能为空！").css({ "color": "red", "font-size": "14px" });
        } else if (!TelNum.test(mobile)) {
            $("#validateTel").html("联系电话不合法！").css({ "color": "red", "font-size": "14px" });
        }
        //else if (code === "") {
        //    $("#validateCode").html("验证码不能为空！").css({ "color": "red", "font-size": "14px" });
        //}
        //TODO 获取发送的验证码
        //else if (code !== "123") {
        //    $("#validateCode").html("验证码错误！").css("color", "red");
        //}
        else {
            $("#validateCode").html("");
            $.ajax({
                type: 'Post',
                url: 'register.do',
                data: {
                	collegeid: collegeid,
                	classid: classid,
                    userid: userid,
                    username: username,
                    agend: agend,
                    pwd: pwd,
                    mobile: mobile,
                    op: "add"
                },
                dataType: 'text',
                success: function (succ) {
                    if (succ === "注册成功") {
                        window.wxc.xcConfirm(succ, window.wxc.xcConfirm.typeEnum.success, {
                            onOk: function (v) {
                                window.location.href="login.jsp";
                            }
                        });
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