<%--
  Created by IntelliJ IDEA.
  User: ZDER
  Date: 2018/5/12
  Time: 20:19
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Facelet Title</title>


    <script type="text/javascript" src="js/jquery.js"></script>

    <script type="text/javascript" src="js/lrf.js"></script>
    <script type="text/javascript" src="js/tolrf.js"></script>


    <link rel="stylesheet" type="text/css" href="css/menu.css"/>
    <link rel="stylesheet" type="text/css" href="css/logo.css"/>

</head>
<body>
<!--登录注册-->
<div style="background-color: #f5f5f5;height: 40px;widt 100%">
    <div id="LRF">
        <c:if test="${sessionScope.user==null}">
            <div onclick="toRegister();" class="top_nav">
                <img src="images/register.png">
                用户注册
            </div>
            <div onclick="toLogin();" class="top_nav">

                <img src="images/login.png">
                登陆
            </div>
        </c:if>
        <c:if test="${sessionScope.user!=null}">
            <div onclick="toUser();" class="top_nav">
                <img src="images/register.png">
                    ${sessionScope.user.uname}的个人中心
            </div>
            <div onclick="toExit();" class="top_nav">
                <img src="images/login.png">
                注销
            </div>
        </c:if>
    </div>
</div>
<!--导航栏-->
<div class="menu_class">
    <div class="nav">
        <!--导航栏顶部-->
        <!--菜单栏-->
        <div class="nav_main">
            <ul id="nav_all">
                <li>
                    <img src="images/logo.png" id="logo">
                </li>
                <li>
                    <a href="index.jsp" target="_top">首页</a>
                </li>

                <li>
                    <a href="ProductsList.xhtml?param=new">最新闲置</a>

                </li>

                <li>
                    <a href="ProductsList.xhtml?param=isbid">闲置拍卖</a>

                </li>

                <li>
                    <a href="ProductsList.xhtml?param=recommend">闲置推荐</a>
                </li>

                <li>
                    <a href="addinfo.xhtml" target="_top">发布闲置</a>
                </li>

                <li>
                    <a href="manageproduct.xhtml" target="_top">我的闲置</a>
                </li>
                <li>
                    <form id="searchform">
                        <img src="images/search.jpg" id="searchimg" onclick="search();"/>
                        <input type="text" id="inputsearch"/>
                    </form>
                </li>
            </ul>
        </div>
    </div>
</div>

<!--修改导航栏-->

<script type="text/javascript" src="js/nav.js"></script>

<script type="text/javascript">
    function search() {
        var param = document.getElementById("inputsearch").value;
        location.href = "ProductsSearch/" + param;
    }
</script>
</body>
</html>
