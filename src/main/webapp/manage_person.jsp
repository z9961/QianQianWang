<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE HTML>
<html>

<head>
    <title>个人信息</title>
    <%--<script src="js/jquery.js" type="text/javascript"></script>--%>
    <%--<script src="js/user.js" type="text/javascript"></script>--%>
    <%--<script type="text/javascript">--%>
    <%--var existmanagemsg = ${existmanagemsg};--%>
    <%--if (existmanagemsg) {--%>
    <%--var managemsg = '${managemsg}';--%>
    <%--${managepage}--%>
    <%--alert(managemsg);--%>
    <%--}--%>

    <%--</script>--%>
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

        #table tr td {
            border: 2px solid #000;
        }
    </style>
</head>

<body>

<table id="table">

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