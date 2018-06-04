<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>

<c:if test="${getaddrok!=1}">
    <!-- JSP提供的 转发标签 -->
    <jsp:forward page="GetAddress.mvc"/>
</c:if>

<head>
    <meta charset="UTF-8">
    <title>添加地址</title>

    <script src="js/jquery.js" type="text/javascript"></script>
    <link rel="stylesheet" type="text/css" href="css/address.css"/>
    <link rel="stylesheet" type="text/css" href="css/header.css"/>
    <script type="text/javascript">
        var existaddrmsg = ${existaddrmsg};
        if (existaddrmsg) {
            var msg = '${addrmsg}';
            alert(msg);
        }

    </script>
</head>

<body>
<div style="margin-top:20px;height: 50px;font-size: 40px;border-bottom: 1px solid #ddd;">
    <span style="margin-left: 10%"><img src="images/login.png">地址管理</span>
</div>
<div id="addaddr" style="padding-top: 100px">
    <form id="addrform" action="AddAddress.mvc" method="post">
        你好,${sessionScope.user.uPhone}
        <br/>
        <div style="right: 10%">
            <input id="address" name="address" required>
            &nbsp;
            <input type="submit" value="添加地址">
        </div>

    </form>

</div>

<br/>

<div id="addr">
    <table id="addrtable">
        <tr>
            <td style="width: 10%;">地址编号</td>
            <td style="width: 40%;">地址</td>
            <td style="width: 10%;">删除</td>

        </tr>
        <c:forEach items="${addr}" var="addr">
            <tr>
                <td>${addr.aId}</td>
                <td>${addr.address}</td>
                <td>
                    <a href="DeleteAddress.mvc?aid=${addr.aId}">删除</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>

</html>