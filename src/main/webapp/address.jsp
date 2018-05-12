<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>

<c:if test="${sessionScope.addr==null}">
    <!-- JSP提供的 转发标签 -->
    <jsp:forward page="GetAddress.mvc"/>
</c:if>

<head>
    <meta charset="UTF-8">
    <title>添加地址</title>

    <script src="js/jquery.js" type="text/javascript"></script>
    <script src="js/lrf.js" type="text/javascript"></script>
    <script src="js/footer.js" type="text/javascript"></script>
    <link rel="stylesheet" type="text/css" href="css/lrf.css"/>
    <link rel="stylesheet" type="text/css" href="css/footer.css"/>

</head>

<body>

<img id="logo" src="images/logo.png"/>

<div>
    <form id="addrform" action="AddAdress.mvc" method="post">
        地址:<input id="address" name="address">
        <input type="submit" value="添加">
    </form>

</div>


<div>
    <table>
        <tr>
            <td>地址编号</td>
            <td>地址</td>
            <td>电话</td>
        </tr>
        <c:forEach items="${sessionScope.addr}" var="addr">
            <tr>
                <td>${addr.aId}</td>
                <td>${addr.address}</td>
                <td>${addr.usersByUPhone}</td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>

</html>