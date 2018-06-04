<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";

    String typestr = request.getParameter("type");
    request.setAttribute("msgtype2", typestr);

%>


<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>会员登录</title>

    <!--引入jquery-->
    <script src="js/jquery.js" type="text/javascript"></script>
    <!--引入登陆组成忘记密码-->
    <script src="js/lrf.js" type="text/javascript"></script>
    <!--插入页脚-->
    <script src="js/footer.js" type="text/javascript"></script>
    <!--LRF样式 -->
    <link rel="stylesheet" type="text/css" href="css/lrf.css"/>
    <!--页脚样式-->
    <link rel="stylesheet" type="text/css" href="css/footer.css"/>

</head>

<body>
<img id="logo" src="images/logo.png"/>

<div id="bg"></div>

<div id="LRF">
    <input type="button" value="登陆" onclick="showlogin();">
    <input type="button" value="注册" onclick="showregister();">
</div>

<!--登陆部分-->
<form id="loginpart" action="Login.mvc" method="POST">
    <table name="table">
        <caption>会员登录</caption>
        <tr>
            <td class="word">手机号</td>
            <td><input id="phone" name="phone" type="text" size="20" value="15610053553"/></td>
        </tr>
        <tr>
            <td class="word">密码</td>
            <td><input id="password" name="password" type="password" value="234"/></td>
        </tr>

        <tr>

            <td>

            </td>
            <td>
                <input type="button" value="验证码登录" onclick="showloginbysms();"/>
            </td>
        </tr>


        <tr>
            <td></td>
            <td>
                <br>
                <input id="savepwd" name="savepwd" value="savepwd" checked type="checkbox"/> 记住登陆状态
            </td>
        </tr>

        <tr>
            <td>

            </td>
            <td>
                <input type="submit" value="点击登陆"/>
            </td>
        </tr>

        <tr>
            <td>

            </td>
            <td>
                <input type="button" value="新用户注册" onclick="showregister();"/>

            </td>
        </tr>

        <tr>
            <td>

            </td>
            <td>
                <input type="button" value="返回首页" onclick="BackIndex();"/>

            </td>
        </tr>

    </table>
</form>


<!--验证码登陆部分-->
<form id="loginpartbysms" action="LoginBySms.mvc" method="POST">
    <table name="table">
        <caption>会员登录</caption>
        <tr>
            <td class="word">手机号</td>
            <td><input id="phone2" name="phone" type="text" size="20"/></td>
        </tr>
        <tr>
            <td class="word">验证码</td>
            <td><input id="sms2" name="sms" type="text"/></td>
        </tr>
        <tr>
            <td></td>
            <td>
                <input id="getsms2" name="getsms" type="button" value="获取验证码" onclick="getSms2()" style="width: 220px"/>
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <input type="submit" value="点击登陆"/>
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <input type="button" value="密码登录" onclick="showloginbypwd();"/>
            </td>
        </tr>
        <tr>
            <td>
            </td>
            <td>
                <input type="button" value="新用户注册" onclick="showregister();"/>

            </td>
        </tr>
        <tr>
            <td>
            </td>
            <td>
                <input type="button" value="返回首页" onclick="BackIndex();"/>
            </td>
        </tr>

    </table>
</form>


<!--注册部分-->
<form id="register" action="Register.mvc" method="POST">
    <table name="table">
        <caption>新用户注册</caption>
        <tr>
            <td class="word">昵称</td>
            <td><input id="UName" name="UName" type="text" value="123" onblur="checkUName()"/></td>
            <%--<td id="warn1">昵称长度应在8-20之间</td>--%>
        </tr>
        <tr>
            <td class="word">密码</td>
            <td><input id="newpassword" name="newpassword" type="password" value="234" onblur="checkPwd()"/></td>

        </tr>
        <tr>
            <td class="word">确认密码</td>
            <td><input id="newpassword2" name="password" type="password" value="234" onblur="checkPwd2()"/></td>

        </tr>

        <tr>
            <td class="word">手机号</td>
            <td><input id="REphone" name="phone" type="tel" value="15610053553" onblur="checkPhone()"/></td>

        </tr>
        <tr>
            <td></td>
            <td class="word" style="width: 400px">
                <input id="getsms" name="getsms" type="button" value="获取验证码" onclick="getSms()"/>
            </td>
        </tr>
        <tr>
            <td class="word">验证码</td>
            <td><input id="sms" name="sms" type="text"/></td>

        </tr>
        <tr>
            <td>
            </td>
            <td>
                <input name="UType" type="radio" checked="checked" value="1">我是买家
                <input name="UType" type="radio" value="2">我是卖家
            </td>

        </tr>
        <tr>
            <td></td>
            <td>
                <br>
                <input id="cb" name="cb" value="" checked type="checkbox"/> 我已阅读并同意相关服务条款
            </td>
        </tr>


        <tr>
            <td></td>
            <td>
                <input id="subbtn" type="button" value="提交注册" onClick="userRegister()"/>
            </td>
        </tr>

        <tr>
            <td>

            </td>
            <td>
                <input type="button" value="返回登陆" onclick="showlogin()"/>

            </td>
        </tr>
        <tr>
            <td>

            </td>
            <td>
                <input type="button" value="返回首页" onclick="BackIndex();"/>

            </td>
        </tr>
    </table>
</form>

<!--撑出页脚-->
<div id="blank"></div>
<script type="text/javascript">
    window.onunload = msgtype();

    function msgtype() {
        var msgtype = "${msgtype}";
        var msgtype2 = "${msgtype2}";
        var msg = "${msg}";
        if (msgtype == "register") {
            showregister();
            alert(msg);
        }
        if (msgtype == "login") {
            showlogin();
            alert(msg);
        }
        if (msgtype2 == "registerh") {
            showregister();
        }
        if (msgtype2 == "loginh") {
            showlogin();
        }
    }

</script>
</body>

</html>