<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>


<!DOCTYPE HTML>
<html>
<head>
    <style>
        body {
            font-family: 幼圆;
        }

        #table {
            text-align: center;
            font-size: 200%;
            margin: 0 auto;
            margin-top: 10%;
        }

        #table td {
            border: 2px solid #000;
        }

        #table input {
            height: 40px;
            width: 300px;
            font-size: 30px;
        }

        input[type="submit"] {
            width: 150px;
            height: 40px;
            background-color: tomato;
            color: white;
            border-radius: 5px;
            font-size: 20px;
            font-family: youyuan;
            margin-top: 50px;
            margin-left: 40%;
        }
    </style>


</head>

<body>

<form action="Changeinfo.mvc" method="post">
    <table id="table">
        <tr>
            <td>用户名</td>
            <td><input type="text" name="uName" value="${user.uName}" required/></td>
        </tr>
        <c:if test="${user.uType==2}">
            <tr>
                <td>邮编</td>
                <td><input type="text" name="uZipCode" value="${user.uZipCode}" required/></td>
            </tr>
            <tr>
                <td>邮箱</td>
                <td><input type="text" name="uEmail" value="${user.uEmail}" required/></td>
            </tr>
        </c:if>
    </table>
    <input type="submit" value="确认修改">

</form>
</body>
</html>
