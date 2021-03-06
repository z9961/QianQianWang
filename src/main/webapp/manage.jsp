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

    <c:if test="${empty user}">
        <script>
            top.location.href = "lrf.jsp";
        </script>
    </c:if>

</head>

<body style="font-family: '微软雅黑 Light'">

<!--引入头部-->
<div id="head_div">
    <jsp:include page="h.jsp"></jsp:include>
</div>
<!--总体div-->

<%--<script type="text/javascript" src="js/head_div.js"></script>--%>
<!--插入页眉-->

<div style="margin-left: 5%; padding-top: 145px;">

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
                    <a onclick="showperson(this)" id="lf1">
                        <div id="Bf080" class="left02down01_img"></div>
                        当前用户信息查询
                    </a>
                </div>

                <div class="left02down01">
                    <a onclick="showchangepwd(this)" id="lf2">
                        <div id="Bf081" class="left02down01_img"></div>
                        用户密码管理
                    </a>
                </div>
                <div class="left02down01">
                    <a onclick="changeinfo(this)" id="lf3">
                        <div id="Bf082" class="left02down01_img"></div>
                        个人资料编辑
                    </a>
                </div>
                <div class="left02down01">
                    <a onclick="manageaddr(this)" id="lf4">
                        <div id="Bf083" class="left02down01_img"></div>
                        地址管理
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
                    <a onclick="myorder(this)" id="lf5">
                        <div class="left02down01_img"></div>
                        我参与的项目
                    </a>
                </div>
                <div class="left02down01">
                    <a onclick="mycomment(this)" id="lf6">
                        <div class="left02down01_img"></div>
                        我的评论
                    </a>
                </div>
                <c:if test="${user.uType==2}">
                    <div class="left02down01">
                        <a onclick="myproject(this)" id="lf7">
                            <div class="left02down01_img"></div>
                            我发布的项目
                        </a>
                    </div>
                </c:if>
            </div>
        </div>
    </div>
    <div class="rrcc" id="RightBox">
        <iframe src="manage_welcom.jsp" id="iframe" style="width: 100%;background-color: white;height: 100%;"
                frameborder="0"></iframe>
    </div>


</div>

<%
    String mangetype = request.getParameter("mangetype");
    session.setAttribute("mangetype", mangetype + "()");
    System.out.println("mangetype = " + mangetype);
%>

<script type="text/javascript">
    ${sessionScope.mangetype};
</script>

</body>
