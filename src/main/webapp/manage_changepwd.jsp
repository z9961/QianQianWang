<%@ page language="java" pageEncoding="UTF-8" %>


<!DOCTYPE HTML>
<html>

<head>

    <title>修改密码</title>
    <link href="css/manage.css" type="text/css" rel="stylesheet">


</head>

<body>

<div style="margin-top:20px;height: 50px;font-size: 40px;border-bottom: 1px solid #ddd;">
    <span style="margin-left: 10%"><img src="images/login.png">用户密码管理</span>
</div>

<form action="Changepwd.mvc" method="post" id="form">
    <table id="table">
        <tr>
            <td style="width: 400px">请输入当前密码</td>
            <td><input type="password" name="nowpwd" id="nowpwd"/></td>
        </tr>
        <tr>
            <td>请输入新密码</td>
            <td><input type="password" name="newpwd" id="newpwd"/></td>
        </tr>
        <tr>
            <td>请再次输入新密码</td>
            <td><input type="password" name="newpwd2" id="newpwd2"/></td>
        </tr>

    </table>
    <input type="submit" value="修改密码"/>
</form>

</body>

</html>