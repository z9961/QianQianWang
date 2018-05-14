<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>

<c:if test="${hot==null}">
    <!-- JSP提供的 转发标签 -->
    <jsp:forward page="Index.mvc"/>
</c:if>

<head>
    <title>钱钱网</title>
    <script src="js/jquery.js" type="text/javascript"></script>
    <script src="js/footer.js" type="text/javascript"></script>
    <script src="js/index.js" type="text/javascript"></script>
    <link rel="stylesheet" type="text/css" href="css/index.css"/>
    <link rel="stylesheet" type="text/css" href="css/footer.css"/>
    <link rel="stylesheet" type="text/css" href="css/header.css"/>


</head>

<body>

<!--引入头部-->
<div id="head_div"></div>
<!--总体div-->
<div id="all">

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
            <iframe id="Carousel_figure" src="Carousel.jsp"></iframe>
        </div>
    </div>


    <!--设置轮播图的大小-->
    <script type="text/javascript" src="js/Carousel_figure.js"/>
    <!--插入页眉-->
    <script type="text/javascript" src="js/head_div.js"></script>

    <br/>

    <div id="b2">
        <%--热门推荐 --%>
        <div name="projectdiv">
            <ul name="menu">
                <c:forEach items="${hot}" var="pro">
                    <li>
                        <div>
                            <p class="picture">
                                <a href="Product.xhtml?param=${pro.pId}">
                                    <img src="images/${pro.pId}/0.jpg"/>
                                </a>
                            </p>

                            <p class="pname">
                                <a href="Product.xhtml?param=${pro.pId}">
                                        ${pro.pName}
                                </a>
                            </p>
                            <p class="ptype" style="width: 40px">
                                <a href="Product.xhtml?param=${pro.pId}">
                                        ${pro.projectTypeByPCategoryId.projectTypeName}
                                </a>
                            </p>
                        </div>

                        <div>
                            <table>
                                <tr>
                                    <td>
                                        <p class="ptype">
                                                ${pro.pTarget}人

                                        </p>
                                    </td>

                                    <td>
                                        <p class="ptype">
                                                ${pro.pnm}

                                        </p>
                                    </td>

                                    <td>

                                    </td>
                                </tr>
                                <tr>
                                    <td width="140px">目标</td>
                                    <td width="140px">已筹</td>

                                </tr>
                                <tr>
                                    <td>剩余时间</td>
                                    <td>
                                        <p>
                                            <input name="ped" value="${pro.ped}" disabled>
                                        </p>
                                    </td>
                                </tr>
                            </table>
                        </div>
                    </li>
                </c:forEach>
            </ul>
        </div>
        <br/>
        <%--最新上架 --%>
        <div name="projectdiv">
            <ul name="menu">

                <c:forEach items="${newp}" var="pro">
                    <li>
                        <div>
                            <div>
                                <p class="picture">
                                    <a href="Product.xhtml?param=${pro.pId}">
                                        <img src="images/${pro.pId}/0.jpg"/>
                                    </a>
                                </p>

                                <p class="pname">
                                    <a href="Product.xhtml?param=${pro.pId}">
                                            ${pro.pName}
                                    </a>
                                </p>
                                <p class="ptype">
                                    <a href="Product.xhtml?param=${pro.pId}">
                                            ${pro.projectTypeByPCategoryId.projectTypeName}
                                    </a>
                                </p>
                            </div>

                            <div>
                                <table>
                                    <tr>
                                        <td>
                                            <p class="ptype">
                                                    ${pro.pnp}人

                                            </p>
                                        </td>

                                        <td>
                                            <p class="ptype">
                                                    ${pro.pnm}

                                            </p>
                                        </td>

                                        <td>
                                            <p class="ptype">
                                                <input name="ped" value="${pro.ped}" disabled>
                                            </p>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>已达</td>
                                        <td>已筹</td>
                                        <td>剩余时间</td>
                                    </tr>
                                </table>
                            </div>
                        </div>
                    </li>
                </c:forEach>
            </ul>
        </div>
        <br/>
        <%--商品类型 1 --%>
        <div name="projectdiv">
            <ul name="menu">

                <c:forEach items="${p1}" var="pro">
                    <li>
                        <div>
                            <div>
                                <p class="picture">
                                    <a href="Product.xhtml?param=${pro.pId}">
                                        <img src="images/${pro.pId}/0.jpg"/>
                                    </a>
                                </p>

                                <p class="pname">
                                    <a href="Product.xhtml?param=${pro.pId}">
                                            ${pro.pName}
                                    </a>
                                </p>
                                <p class="ptype">
                                    <a href="Product.xhtml?param=${pro.pId}">
                                            ${pro.projectTypeByPCategoryId.projectTypeName}
                                    </a>
                                </p>
                            </div>

                            <div>
                                <table>
                                    <tr>
                                        <td>
                                            <p class="ptype">
                                                    ${pro.pnp}人

                                            </p>
                                        </td>

                                        <td>
                                            <p class="ptype">
                                                    ${pro.pnm}

                                            </p>
                                        </td>

                                        <td>
                                            <p class="ptype">
                                                <input name="ped" value="${pro.ped}" disabled>
                                            </p>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>已达</td>
                                        <td>已筹</td>
                                        <td>剩余时间</td>
                                    </tr>
                                </table>
                            </div>
                        </div>
                    </li>
                </c:forEach>
            </ul>
        </div>
        <br/>
        <%--商品类型 2 --%>
        <div name="projectdiv">
            <ul name="menu">
                <c:forEach items="${p2}" var="pro">
                    <li>
                        <div>
                            <div>
                                <p class="picture">
                                    <a href="Product.xhtml?param=${pro.pId}">
                                        <img src="images/${pro.pId}/0.jpg"/>
                                    </a>
                                </p>

                                <p class="pname">
                                    <a href="Product.xhtml?param=${pro.pId}">
                                            ${pro.pName}
                                    </a>
                                </p>
                                <p class="ptype">
                                    <a href="Product.xhtml?param=${pro.pId}">
                                            ${pro.projectTypeByPCategoryId.projectTypeName}
                                    </a>
                                </p>
                            </div>

                            <div>
                                <table>
                                    <tr>
                                        <td>
                                            <p class="ptype">
                                                    ${pro.pnp}人

                                            </p>
                                        </td>

                                        <td>
                                            <p class="ptype">
                                                    ${pro.pnm}

                                            </p>
                                        </td>

                                        <td>
                                            <p class="ptype">
                                                <input name="ped" value="${pro.ped}" disabled>
                                            </p>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>已达</td>
                                        <td>已筹</td>
                                        <td>剩余时间</td>
                                    </tr>
                                </table>
                            </div>
                        </div>
                    </li>
                </c:forEach>
            </ul>
        </div>
        <br/>
        <%--商品类型 3 --%>
        <div name="projectdiv">
            <ul name="menu">
                <c:forEach items="${p3}" var="pro">
                    <li>
                        <div>
                            <div>
                                <p class="picture">
                                    <a href="Product.xhtml?param=${pro.pId}">
                                        <img src="images/${pro.pId}/0.jpg"/>
                                    </a>
                                </p>

                                <p class="pname">
                                    <a href="Product.xhtml?param=${pro.pId}">
                                            ${pro.pName}
                                    </a>
                                </p>
                                <p class="ptype">
                                    <a href="Product.xhtml?param=${pro.pId}">
                                            ${pro.projectTypeByPCategoryId.projectTypeName}
                                    </a>
                                </p>
                            </div>

                            <div>
                                <table>
                                    <tr>
                                        <td>
                                            <p class="ptype">
                                                    ${pro.pnp}人

                                            </p>
                                        </td>

                                        <td>
                                            <p class="ptype">
                                                    ${pro.pnm}

                                            </p>
                                        </td>

                                        <td>
                                            <p class="ptype">
                                                <input name="ped" value="${pro.ped}" disabled>
                                            </p>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>已达</td>
                                        <td>已筹</td>
                                        <td>剩余时间</td>
                                    </tr>
                                </table>
                            </div>
                        </div>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </div>
</div>


<!--撑出页脚-->
<div id="blank" style="height:1100px"></div>

<script type="text/javascript">
    window.onload = cheangetime();
</script>
</body>
</html>

