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
<table>
    <tr>

        <th>项目名称</th>
        <th>项目状态</th>
        <th>支持金额</th>
        <th>支持时间</th>
        <th>需要回报</th>
        <th>回报类型</th>
        <th>地址</th>
        <th>备注</th>
    </tr>
    <c:forEach items="${myprojects}" var="pro">
        <tr>
            <td>${pro.projectByPId.pName}</td>
            <td>
                <c:if test="${pro.projectByPId.pState == 1}">进行中</c:if>
                <c:if test="${pro.projectByPId.pState == 2}">已完成</c:if>
                <c:if test="${pro.projectByPId.pState == 1}">未成功</c:if>
            </td>

            <td>${pro.money}</td>
            <td>${pro.orderDate}</td>
            <td>
                <c:if test="${pro.expect==0}">
                    不需要回报
                </c:if>
                <c:if test="${pro.expect==1}">
                    需要回报
                </c:if>
            </td>


            <td>
                <c:if test="${pro.expectType==-1}">
                </c:if>
                <c:if test="${pro.expectType==1}">
                    投资产品享受折扣
                </c:if>
                <c:if test="${pro.expectType==2}">
                    购买产品享有更高折扣或附加服务
                </c:if>
                <c:if test="${pro.expectType==3}">
                    免费获得投资产品
                </c:if>
                <c:if test="${pro.expectType==4}">
                    其他
                </c:if>
            </td>
            <td>${pro.psd}</td>
            <td><a href="">查看详情</a></td>


        </tr>
    </c:forEach>
</table>

</body>

</html>