<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>

<c:if test="${addr==null}">
    <!-- JSP提供的 转发标签 -->
    <jsp:forward page="GetAddress.mvc"/>
</c:if>

<head>
    <meta charset="UTF-8">
    <title>添加地址</title>

    <script src="js/jquery.js" type="text/javascript"></script>
    <script src="js/footer.js" type="text/javascript"></script>
    <link rel="stylesheet" type="text/css" href="css/footer.css"/>
    <link rel="stylesheet" type="text/css" href="css/address.css"/>

</head>

<body>

<img id="logo" src="images/logo.png"/>

<div id="addaddr">
    <form id="addrform" action="AddAddress.mvc" method="post">
        你好,${sessionScope.user.uPhone}
        <br/>
        <div style="right: 10%">
            <input id="address" name="address">
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
        </tr>
        <c:forEach items="${addr}" var="addr">
            <tr>
                <td>${addr.aId}</td>
                <td>${addr.address}</td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>

</html>