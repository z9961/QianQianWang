<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>


<!DOCTYPE HTML>
<html>
<head>
    <link href="css/manage.css" type="text/css" rel="stylesheet">
</head>

<body>
<div style="margin-top:8px;height: 60px;font-size: 40px;border-bottom: 1px solid #ddd;">
    <span style="margin-left: 10%"><img src="images/login.png">个人资料编辑</span>
</div>

<form action="Changeinfo.mvc" method="post">
    <table id="table">
        <tr>
            <td style="width: 300px">用户名</td>
            <td><input type="text" name="uName" value="${user.uName}" required/></td>
        </tr>
        <tr>
            <td style="width: 300px">手机号</td>
            <td><input type="text" name="uPhone" value="${user.uPhone}" required/></td>
        </tr>
        <c:if test="${user.uType==2}">
            <tr>
                <td>邮编</td>
                <td><input type="text" name="uZipCode" value="${user.usersInfoByUPhone.uZipCode}" required/></td>
            </tr>
            <tr>
                <td>邮箱</td>
                <td><input type="text" name="uEmail" value="${user.usersInfoByUPhone.uEmail}" required/></td>
            </tr>
        </c:if>
    </table>
    <input type="submit" value="确认修改">

</form>
</body>
</html>
