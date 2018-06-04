<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE HTML>
<html>

<head>
    <title>个人信息</title>

    <link href="css/manage.css" type="text/css" rel="stylesheet">
</head>

<body>

<div style="margin-top:20px;height: 50px;font-size: 40px;border-bottom: 1px solid #ddd;">
    <span style="margin-left: 10%"><img src="images/login.png">当前用户信息</span>
</div>

<table id="table" style="width: 60%">

    <tr>
        <td style="min-width: 300px">用户名</td>
        <td style="min-width: 300px">
            ${user.uName}
        </td>
    </tr>
    <tr>
        <td>电话号码</td>
        <td>
            ${user.uPhone}
        </td>
    </tr>
    <tr>
        <td>用户类型:</td>
        <td>
            <c:if test="${user.uType==1}">
                投资者
            </c:if>
            <c:if test="${user.uType==2}">
                融资者
            </c:if>
        </td>
    </tr>
    <c:if test="${user.uType==2}">
        <tr>
            <td>
                真实姓名:
            </td>
            <td>
                    ${user.usersInfoByUPhone.uName}
            </td>
        </tr>
        <tr>
            <td>
                邮编:
            </td>
            <td>
                    ${user.usersInfoByUPhone.uZipCode}
            </td>
        </tr>
        <tr>
            <td>
                邮箱:
            </td>
            <td>
                    ${user.usersInfoByUPhone.uEmail}
            </td>
        </tr>
        <tr>
            <td>
                证件号码:
            </td>
            <td>
                    ${user.usersInfoByUPhone.uCardNumber}
            </td>
        </tr>

    </c:if>


</table>
</body>

</html>