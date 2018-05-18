<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>钱钱网</title>
    <script src="js/jquery.js" type="text/javascript"></script>
    <script src="js/footer.js" type="text/javascript"></script>
    <script src="js/user.js" type="text/javascript"></script>
    <link rel="stylesheet" type="text/css" href="css/index.css"/>
    <link rel="stylesheet" type="text/css" href="css/footer.css"/>
    <link rel="stylesheet" type="text/css" href="css/header.css"/>
    <link rel="stylesheet" type="text/css" href="css/user.css"/>

</head>

<body>

<!--引入头部-->
<div id="head_div"></div>
<!--总体div-->

<script type="text/javascript" src="js/head_div.js"></script>
<!--插入页眉-->

<div style="margin: 0 auto; padding-top: 145px;">

    <div class="left" id="LeftBox">
        <div class="left01">
            <div class="left01_right"></div>
            <div class="left01_left"></div>
            <div class="left01_c">当前用户：${user.uName}</div>
        </div>
        <div class="left02">
            <div class="left02top">
                <div class="left02top_right"></div>
                <div class="left02top_left"></div>
                <div class="left02top_c">用户信息管理</div>
            </div>
            <div class="left02down">
                <div class="left02down01">
                    <a onclick="showperson()">
                        <div id="Bf080" class="left02down01_img"></div>
                        当前用户信息查询
                    </a>
                </div>

                <div class="left02down01">
                    <a onclick="showchangepwd()">
                        <div id="Bf081" class="left02down01_img"></div>
                        用户密码管理
                    </a>
                </div>
                <div class="left02down01">
                    <a onclick="changeinfo()">
                        <div id="Bf082" class="left02down01_img"></div>
                        个人资料编辑
                    </a>
                </div>

            </div>
        </div>

        <div class="left02">
            <div class="left02top">
                <div class="left02top_right"></div>
                <div class="left02top_left"></div>
                <div class="left02top_c">项目管理</div>
            </div>
            <div class="left02down">

                <div class="left02down01">
                    <a onclick="myorder()">
                        <div class="left02down01_img"></div>
                        我参与的项目
                    </a>
                </div>
                <div class="left02down01">
                    <a onclick="mycomment()">
                        <div class="left02down01_img"></div>
                        我的评论
                    </a>
                </div>
                <c:if test="${user.uType==2}">
                    <div class="left02down01">
                        <a onclick="myproject()">
                            <div class="left02down01_img"></div>
                            我发布的项目
                        </a>
                    </div>
                </c:if>
            </div>
        </div>
    </div>
    <div class="rrcc" id="RightBox">
        <iframe src="manage_welcom.jsp" id="iframe" style="width: 100%;background-color: white;height: 100%;"></iframe>
    </div>


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

</div>

<!--撑出页脚-->
<div id="blank" style="height:1100px"></div>

</body>
