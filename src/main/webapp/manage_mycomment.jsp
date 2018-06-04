<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE HTML>
<html>

<head>

    <title>所有内容</title>
    <style type="text/css">
        table {
            width: 100%;
            text-align: center;
            margin-top: 1%
        }

        table tr {
            font-size: 18px;
            font-family: "微软雅黑";
            height: 40px;
        }

        table tr:nth-child(2n-1) {
            background-color: white;
        }

        table tr:nth-child(2n) {
            background-color: #E7E7E7;
        }
    </style>

</head>

<body>
<div style="margin-top:20px;height: 50px;font-size: 40px;border-bottom: 1px solid #ddd;">
    <span style="margin-left: 10%"><img src="images/m2.png">我的评论</span>
</div>
<table>
    <tr>

        <th>评论项目</th>
        <th>评论内容</th>
        <th>评论时间</th>

    </tr>
    <c:forEach items="${mycomments}" var="mc">
        <tr>
            <td>${mc.projectByCPid.pName}</td>
            <td>${mc.pComment}</td>
            <td>${mc.pcTime}</td>
        </tr>
    </c:forEach>
</table>

</body>

</html>