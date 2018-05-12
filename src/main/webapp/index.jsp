<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>


<head>
    <title>钱钱网</title>
    <!--引入jquery-->
    <script src="js/jquery.js" type="text/javascript"></script>
    <!--插入页脚-->
    <script src="js/footer.js" type="text/javascript"></script>
    <!--Index样式-->
    <link rel="stylesheet" type="text/css" href="css/index.css"/>
    <!--页脚样式-->
    <link rel="stylesheet" type="text/css" href="css/footer.css"/>
    <!--页眉样式-->
    <link rel="stylesheet" type="text/css" href="css/header.css"/>


</head>

<body>

<!--引入头部-->
<div id="head_div"></div>
<!--总体div-->
<div id="all">

    <!--模块1-->
    <div>
        <div id="catalog">
            <div style="margin-top: 20px;">
                <a href="ProductsList.xhtml?param=1">手机/数码/运营商</a><br/>
                <a href="ProductsList.xhtml?param=2">电脑/办公</a><br/>
                <a href="ProductsList.xhtml?param=3">生活家具/家装/厨具</a><br/>
                <a href="ProductsList.xhtml?param=4">代步工具</a><br/>
                <a href="ProductsList.xhtml?param=5">礼品鲜花/农资绿植</a><br/>
                <a href="ProductsList.xhtml?param=6">男鞋/运动/户外</a><br/>
                <a href="ProductsList.xhtml?param=7">男装</a><br/>
                <a href="ProductsList.xhtml?param=8">女鞋/箱包/珠宝/钟表</a><br/>
                <a href="ProductsList.xhtml?param=9">女装/童装</a><br/>
                <a href="ProductsList.xhtml?param=10">图书/音像/电子书</a>
            </div>
        </div>
        <div id="if">
            <!--<iframe id="Carousel_figure" src="Carousel_figure/index.html"></iframe>-->
            <iframe id="Carousel_figure" src="Carousel.xhtml"></iframe>
        </div>
    </div>


    <!--设置轮播图的大小-->
    <h:outputScript library="js" name="Carousel_figure.js"/>
    <!--插入页眉-->
    <h:outputScript library="js" name="head_div.js"/>


    <!--模块2-->
    <div id="b2">
        <h2><span></span>手机数码</h2>
        <div class="body_box">

            <ul id="menu">
                <c:forEach items="#{indexBean.getPhone}" var="pro">

                    <li>
                        <p class="picture">
                            <a href="Product.xhtml?param=${pro.pid}">
                                <img src="${pro.pimagePath}"/>
                            </a>
                        </p>
                        <p class="title">
                                    <span class="kuaimai">
                                        快买
                                    </span>
                            <a href="Product.xhtml?param=${pro.pid}">
                                    ${pro.pname}
                            </a>
                        </p>
                        <p class="author">
                                ${pro.users.uname}
                        </p>
                        <p class="price"><span class="sale">¥</span><span class="sale_price">
                                ${pro.pprice}
                        </span>
                        </p>
                    </li>

                </c:forEach>
            </ul>

        </div>
        <br/>
        <h2><span></span>生活家具</h2>
        <div class="body_box">

            <ul id="menu">
                <c:forEach items="#{indexBean.getfitment}" var="pro">

                    <li>
                        <p class="picture">
                            <a href="Product.xhtml?param=${pro.pid}">
                                <img src="${pro.pimagePath}"/>
                            </a>
                        </p>
                        <p class="title">
                                    <span class="kuaimai">
                                        快买
                                    </span>
                            <a href="Product.xhtml?param=${pro.pid}">
                                    ${pro.users.uname}
                            </a>
                        </p>
                        <p class="author">

                                ${pro.pnum}
                        </p>
                        <p class="price"><span class="sale">¥</span><span class="sale_price">
                                ${pro.pprice}
                        </span>
                        </p>
                    </li>

                </c:forEach>
            </ul>

        </div>
        <br/>
        <h2><span></span>代步工具</h2>
        <div class="body_box">

            <ul id="menu">
                <c:forEach items="#{indexBean.gettool}" var="pro">

                    <li>
                        <p class="picture">
                            <a href="Product.xhtml?param=${pro.pid}">
                                <img src="${pro.pimagePath}"/>
                            </a>
                        </p>
                        <p class="title">
                                    <span class="kuaimai">
                                        快买
                                    </span>
                            <a href="Product.xhtml?param=${pro.pid}">
                                    ${pro.users.uname}
                            </a>
                        </p>
                        <p class="author">

                                ${pro.pnum}
                        </p>
                        <p class="price"><span class="sale">¥</span><span class="sale_price">
                                ${pro.pprice}
                        </span>
                        </p>
                    </li>

                </c:forEach>
            </ul>

        </div>

    </div>
</div>


<!--撑出页脚-->
<div id="blank" style="height:900px"></div>


</body>
</html>

