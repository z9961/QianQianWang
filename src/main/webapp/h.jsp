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
<div style="background-color: #f5f5f5;height: 40px;widt:100%">
    <div style="margin-left: 75%;padding-top: 8px">
        <c:if test="${sessionScope.user==null}">
            <div onclick="tolrfr();" class="top_nav">
                <img src="images/register.png">
                用户注册
            </div>
            <div onclick="tolrfl();" class="top_nav">

                <img src="images/login.png">
                登陆
            </div>
        </c:if>
        <c:if test="${sessionScope.user!=null}">
            <div onclick="toUser();" class="top_nav">
                <img src="images/register.png">
                    ${sessionScope.user.uName}的个人中心
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
                    <a href="Index.mvc" target="_top">首页</a>
                </li>

                <li>
                    <a href="Projectlist.mvc?type=1">最新项目</a>

                </li>

                <li>
                    <a href="Projectlist.mvc?type=0">最热项目</a>

                </li>

                <li>
                    <a href="Projectlist.mvc?type=2">最多支持</a>
                </li>

                <c:if test="${user.uType==2}">
                    <li>
                        <a href="addproject.jsp" target="_top">发布项目</a>
                    </li>
                    <li>
                        <a href="Manage.mvc" target="_top">我的项目</a>
                    </li>
                </c:if>


                <li>
                    <form id="searchform">
                        <img src="images/search.jpg" id="searchimg" onclick="search();"/>
                        <input type="text" id="inputsearch" required/>
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
        location.href = "Projectlist.mvc?type=6&searchstr=" + param;
    }
</script>
</body>
</html>
