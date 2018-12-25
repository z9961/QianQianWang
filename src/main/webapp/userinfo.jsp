<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
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

<!--注册部分-->
<form id="registerinfo" action="RegisterType2.mvc" method="POST" style="clear: both;margin-left: 55%">
    <table id="table">
        <caption>融资者信息</caption>
        <tr>
            <td class="word">真实姓名</td>
            <td><input id="UName" name="UName" type="text" value="123"/></td>
        </tr>
        <tr>
            <td class="word">邮编</td>
            <td><input id="UZipCode" name="UZipCode" type="text" value="212334"/></td>

        </tr>
        <tr>
            <td class="word">邮箱</td>
            <td><input id="UEmail" name="UEmail" type="email" value="234@qq.cn"/></td>

        </tr>

        <tr>
            <td class="word">证件号码</td>
            <td><input id="UCardNumber" name="UCardNumber" type="text" value="123123123"/></td>

        </tr>

        <tr>
            <td></td>
            <td>
                <input id="subbtn" type="button" value="提交注册" onClick="userRegisterType2()"/>
            </td>
        </tr>

    </table>
</form>

<!--撑出页脚-->
<div id="blank"></div>

</body>

</html>