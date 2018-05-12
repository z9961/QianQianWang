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


//添加验证码时间

var countdown = 0;

function invokeSettime(obj) {

    settime(obj);

    console.log("start")

    function settime(obj) {
        if (countdown == 0) {
            $(obj).attr("disabled", false);
            $(obj).val("获取验证码");
            countdown = 60;
            console.log("geted")
            return;
        } else {
            // console.log("time" + countdown)
            $(obj).attr("disabled", true);
            $(obj).val("(" + countdown + ") s 后重新发送");
            countdown--;
        }
        setTimeout(function () {
                settime(obj);
                console.log("end")
            }
            , 1000)
    }
}

new invokeSettime("#getsms");


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


    console.log("检查完毕,提交数据")

    alert('注册成功!');

    $("#register").submit();


}