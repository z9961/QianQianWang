//添加验证码时间

var countdown = 0;
var countdown2 = 0;

function invokeSettime(obj, tc) {

    settime(obj);

    console.log("start")

    function settime(obj) {
        if (tc == 0) {
            $(obj).attr("disabled", false);
            $(obj).val("获取验证码");
            tc = 60;
            console.log("geted")
            return;
        } else {
            // console.log("time" + countdown)
            $(obj).attr("disabled", true);
            $(obj).val("(" + tc + ") s 后重新发送");
            tc--;
        }
        setTimeout(function () {
                settime(obj);
                console.log("end")
            }
            , 1000)
    }
}

new invokeSettime("#getsms", countdown);
new invokeSettime("#getsms2", countdown2);


function userRegister() {
    var inusername = document.getElementById("UName").value;
    var inpassword = document.getElementById("newpassword").value;
    var inpassword2 = document.getElementById("newpassword2").value;
    var phone = document.getElementById("REphone").value;

    //验证模块
    if (inusername == "") {
        alert("昵称不能为空");
        return false;
    }
    if (inpassword == "") {
        alert("密码不能为空");
        return false;
    }
    if (inpassword != inpassword2) {
        alert('两次密码不一致！');
        return false;
    }

    if (phone == "") {
        alert("电话不能为空");
        return false;
    } else {
        var re = /^1\d{10}$/
        if (re.test(phone)) {
            //格式正确
        } else {
            alert("手机号格式错误！");
            return false;
        }
    }
    if (document.getElementById("cb").checked) {

    } else {
        alert("未同意相关服务条款！");
        return false;
    }


    console.log("检查完毕,提交数据");

    $("#register").submit();


}

function userRegisterType2() {
    var UZipCode = document.getElementById("UZipCode").value;
    var UName = document.getElementById("UName").value;
    var UEmail = document.getElementById("UEmail").value;
    var UCardNumber = document.getElementById("UCardNumber").value;

    //验证模块
    if (UName == "" || UName.length < 2) {
        alert("真实姓名错误");
        return false;
    }
    if (UCardNumber == "") {
        alert("密码不能为空");
        return false;
    }
    if (UZipCode.length != 6) {
        alert('邮编长度错误！');
        return false;
    }
    if (UEmail == "") {
        alert("邮箱不能为空");
        return false;
    } else {
        var re = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/;
        if (re.test(UEmail)) {
            //格式正确
        } else {
            alert("邮箱格式错误！");
            return false;
        }
    }

    console.log("检查完毕,提交数据");

    $("#registerinfo").submit();


}

//跳转账户管理页
function LRF() {
    top.location = "lrf.jsp";
}

//返回首页
function BackIndex() {
    top.location = "index.jsp";
}

//显示隐藏
function showlogin() {
    var login = document.getElementById("loginpart");
    login.style.display = "block";
    var re = document.getElementById("register");
    re.style.display = "none";
    var lrf = document.getElementById("LRF");
    lrf.style.display = "none";
}

function showloginbypwd() {
    var login = document.getElementById("loginpart");
    login.style.display = "block";
    var login = document.getElementById("loginpartbysms");
    login.style.display = "none";

}

function showloginbysms() {
    var login = document.getElementById("loginpart");
    login.style.display = "none";
    var login = document.getElementById("loginpartbysms");
    login.style.display = "block";

}

function showregister() {
    var login = document.getElementById("loginpart");
    login.style.display = "none";
    var re = document.getElementById("register");
    re.style.display = "block";
    var lrf = document.getElementById("LRF");
    lrf.style.display = "none";
}

function getSms() {
    var phonenum = document.getElementById("REphone").value;
    var UName = document.getElementById("UName").value;
    if (UName == "") {
        alert("未输入账号!");
    } else {
        var myreg = /^[1][0-9]{10}$/;
        if (myreg.test(phonenum)) {
            $.ajax({
                method: "POST",
                async: true,
                url: "SendSms.mvc",
                contentType: "application/x-www-form-urlencoded",
                data: {
                    "Phonenum": phonenum,
                    "UName": UName,
                },
                success: function (data) {
                    if (data == "success") {
                        alert("短信验证码已发送");
                    } else {
                        alert("短信发送失败");
                    }
                }
            })
            //发送后计时60s
            countdown = 60;
            new invokeSettime("#getsms");
        } else {
            alert("手机号码不正确!");
        }
    }
}


function getSms2() {
    var phonenum = document.getElementById("phone2").value;
    if (phonenum == "") {
        alert("未输入手机号!");
    } else {
        var myreg = /^[1][0-9]{10}$/;
        if (myreg.test(phonenum)) {
            $.ajax({
                method: "POST",
                async: true,
                url: "SendSms.mvc",
                contentType: "application/x-www-form-urlencoded",
                data: {
                    "Phonenum": phonenum,
                    "UName": phonenum,
                },
                success: function (data) {
                    if (data == "success") {
                        alert("短信验证码已发送");
                    } else {
                        alert("短信发送失败");
                    }
                }
            })
            //发送后计时60s
            countdown2 = 60;
            new invokeSettime("#getsms2", countdown2);
        } else {
            alert("手机号码不正确!");
        }
    }
}
