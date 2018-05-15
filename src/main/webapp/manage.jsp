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
        <c:forEach items="${myprojects}" var="pro">
            <table>
                <tr>
                    <td>商品名称</td>
                    <td>状态</td>
                    <td>发布时间</td>
                    <td></td>
                </tr>

                <tr>
                    <td>${pro.getpName()}</td>
                    <td>${pro.getpState()}
                        <c:if test="${pro.getpState() == 1}">进行中</c:if>
                        <c:if test="${pro.getpState() == 2}">已完成</c:if>
                        <c:if test="${pro.getpState() == 1}">未成功</c:if>
                    </td>
                    <td>${pro.getPsd()}</td>
                    <td><a href="">查看详情</a></td>
                </tr>
            </table>
            >
        </c:forEach>
    </div>

    <!--我发起的-->
    <p class="title">我发起的
    <p/>
    <div>
        <c:forEach items="${projects}" var="pro">
            <table>
                <tr>
                    <td>商品名称</td>
                    <td>状态</td>
                    <td>发布时间</td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>

                <tr>
                    <td>${pro.getpName()}</td>
                    <td>${pro.getpState()}
                        <c:if test="${pro.getpState() == 1}">进行中</c:if>
                        <c:if test="${pro.getpState() == 2}">已完成</c:if>
                        <c:if test="${pro.getpState() == 1}">未成功</c:if>
                    </td>
                    <td>${pro.getPsd()}</td>
                    <td><a href="">查看详情</a></td>
                    <td><a href="">编辑项目</a></td>
                    <td><a href="">撤销项目</a></td>
                </tr>
            </table>
            >
        </c:forEach>
    </div>

    <!--我的评论-->
    <p class="title">我的评论
    <p/>
    <div>
        <c:forEach items="${mycomments}" var="com">
            <table>
                <tr>
                    <td>项目名称</td>
                    <td>评论内容</td>
                </tr>
                <tr>
                    <td>${com.getProjectByCPid().getpName()}</td>
                    <td>${com.getpComment()}</td>
                </tr>
            </table>
        </c:forEach>
    </div>

    <!--撑出页脚-->
    <div id="blank" style="height:1100px"></div>

    <script type="text/javascript">
        window.onload = cheangetime();
    </script>
</body>
