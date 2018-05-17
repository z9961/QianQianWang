<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>钱钱网</title>
    <script src="js/jquery.js" type="text/javascript"></script>
    <script src="js/footer.js" type="text/javascript"></script>
    <script src="js/index.js" type="text/javascript"></script>
    <link rel="stylesheet" type="text/css" href="css/footer.css"/>
    <link rel="stylesheet" type="text/css" href="css/header.css"/>


</head>

<body>

<!--引入头部-->
<div id="head_div"></div>
<!--总体div-->
<div id="all">

    <!--我支持的-->

    <p class="title">我参与的
    <p/>
    <div>

        <table>
            <tr>
                <td>商品名称</td>
                <td>状态</td>
                <td>发布时间</td>
                <td></td>
            </tr>
            <c:forEach items="${myprojects}" var="pro">
                <tr>
                    <td>${pro.pName}</td>
                    <td>
                        <c:if test="${pro.pState == 1}">进行中</c:if>
                        <c:if test="${pro.pState == 2}">已完成</c:if>
                        <c:if test="${pro.pState == 1}">未成功</c:if>
                    </td>
                    <td>${pro.psd}</td>
                    <td><a href="">查看详情</a></td>
                </tr>
            </c:forEach>
        </table>


    </div>

    <!--我发起的-->
    <p class="title">我发起的
    <p/>
    <div>

        <table>
            <tr>
                <td>商品名称</td>
                <td>状态</td>
                <td>发布时间</td>
                <td></td>
                <td></td>
                <td></td>
            </tr>
            <c:forEach items="${mynewprojects}" var="pro">
                <tr>
                    <td>${pro.pName}</td>
                    <td>
                        <c:if test="${pro.pState == 1}">进行中</c:if>
                        <c:if test="${pro.pState == 2}">已完成</c:if>
                        <c:if test="${pro.pState == 1}">未成功</c:if>
                    </td>
                    <td>${pro.psd}</td>
                    <td><a href="">查看详情</a></td>
                    <td><a href="">编辑项目</a></td>
                    <td><a href="">撤销项目</a></td>
                </tr>
            </c:forEach>
        </table>

    </div>

    <!--我的评论-->
    <p class="title">我的评论
    <p/>
    <div>

        <table>
            <tr>
                <td>项目名称</td>
                <td>评论内容</td>
            </tr>
            <c:forEach items="${mycomments}" var="com">
                <tr>
                    <td>${com.projectByCPid.pName}</td>
                    <td>${com.pComment}</td>
                </tr>
            </c:forEach>
        </table>

    </div>

    <!--撑出页脚-->
    <div id="blank" style="height:1100px"></div>
</div>
</body>
