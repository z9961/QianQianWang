<%@ page language="java" pageEncoding="UTF-8" %>


<!DOCTYPE HTML>
<html>

<head>

    <title>修改密码</title>

    <style>
        body {
            font-family: 幼圆
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