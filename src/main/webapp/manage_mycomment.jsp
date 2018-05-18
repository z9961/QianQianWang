<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<!DOCTYPE HTML>
<html>

<head>
    <base href="<%=basePath%>">

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
<table>
    <tr>

        <th>标题</th>
        <th>作者</th>
        <th>类型</th>
        <th>日期</th>
        <th>内容</th>
        <!--<th>编辑</th>
        <th>删除</th>-->
    </tr>
    <c:forEach items="${requestScope.list}" var="info">
        <tr>
            <td>${info.title}</td>
            <td>${info.author}</td>
            <td>${info.type}</td>
            <td>${info.date}</td>
            <td>
                    ${info.content}
            </td>
            <!--<td>
                <a href="#">编辑</a>
            </td>
            <td>
                <a href="#">删除</a>
            </td>-->
        </tr>
    </c:forEach>
</table>

</body>

</html>