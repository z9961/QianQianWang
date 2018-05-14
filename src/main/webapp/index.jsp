<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>

<c:if test="${hot==null}">
    <!-- JSP提供的 转发标签 -->
    <jsp:forward page="Index.mvc"/>
</c:if>

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


        <div id="if">
            <iframe id="Carousel_figure" src="Carousel.xhtml"></iframe>
        </div>


    <!--设置轮播图的大小-->
    <%--<script type="text/javascript" src="js/Carousel_figure.js"/>--%>
    <!--插入页眉-->
    <script type="text/javascript" src="js/head_div.js"></script>

    <%--热门推荐 --%>
    <div id="project1">
        <c:forEach items="${hot}" var="pro">
            <div>
                <div>
                    <p class="picture">
                        <a href="Product.xhtml?param=${pro.pId}">
                            <c:if test="${empty pro.projectImgsByPId.get(0).imgPath}">
                                暂无图片
                            </c:if>
                            <c:if test="${not empty pro.projectImgsByPId.get(0).imgPath}">
                                <img src="${pro.projectImgsByPId.get(0).imgPath}"/>
                            </c:if>

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
                                        ${pro.pnp}
                                    </a>
                                </p>
                            </td>

                            <td>
                                <p class="ptype">
                                        ${pro.pnm}
                                    </a>
                                </p>
                            </td>

                            <td>
                                <p class="ptype">
                                        ${pro.ped}
                                    </a>
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
        </c:forEach>
    </div>
    <%--
        &lt;%&ndash;最新上架 &ndash;%&gt;
        <div id="project1">
            <c:forEach items="${indexBean.getPhone}" var="pro">
                <div>
                    <div>
                        <p class="picture">
                            <a href="Product.xhtml?param=${pro.pid}">
                                <img src="${pro.pimagePath}"/>
                            </a>
                        </p>

                        <p class="pname">
                            <a href="Product.xhtml?param=${pro.pid}">
                                    ${pro.pname}
                            </a>
                        </p>
                        <p class="ptype">
                            <a href="Product.xhtml?param=${pro.ptype}">
                                    ${pro.ptype}
                            </a>
                        </p>
                    </div>

                    <div>
                        <table>
                            <tr>
                                <td>
                                    <p class="ptype">
                                        <a href="Product.xhtml?param=${pro.ptype}">
                                                ${pro.ptype}
                                        </a>
                                    </p>
                                </td>

                                <td>
                                    <p class="ptype">
                                        <a href="Product.xhtml?param=${pro.ptype}">
                                                ${pro.ptype}
                                        </a>
                                    </p>
                                </td>

                                <td>
                                    <p class="ptype">
                                        <a href="Product.xhtml?param=${pro.ptype}">
                                                ${pro.ptype}
                                        </a>
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
            </c:forEach>
        </div>

        &lt;%&ndash;商品类型 1 &ndash;%&gt;
        <div id="project1">
            <c:forEach items="${indexBean.getPhone}" var="pro">
                <div>
                    <div>
                        <p class="picture">
                            <a href="Product.xhtml?param=${pro.pid}">
                                <img src="${pro.pimagePath}"/>
                            </a>
                        </p>

                        <p class="pname">
                            <a href="Product.xhtml?param=${pro.pid}">
                                    ${pro.pname}
                            </a>
                        </p>
                        <p class="ptype">
                            <a href="Product.xhtml?param=${pro.ptype}">
                                    ${pro.ptype}
                            </a>
                        </p>
                    </div>

                    <div>
                        <table>
                            <tr>
                                <td>
                                    <p class="ptype">
                                        <a href="Product.xhtml?param=${pro.ptype}">
                                                ${pro.ptype}
                                        </a>
                                    </p>
                                </td>

                                <td>
                                    <p class="ptype">
                                        <a href="Product.xhtml?param=${pro.ptype}">
                                                ${pro.ptype}
                                        </a>
                                    </p>
                                </td>

                                <td>
                                    <p class="ptype">
                                        <a href="Product.xhtml?param=${pro.ptype}">
                                                ${pro.ptype}
                                        </a>
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
            </c:forEach>
        </div>

        &lt;%&ndash;商品类型 2 &ndash;%&gt;
        <div id="project1">
            <c:forEach items="${indexBean.getPhone}" var="pro">
                <div>
                    <div>
                        <p class="picture">
                            <a href="Product.xhtml?param=${pro.pid}">
                                <img src="${pro.pimagePath}"/>
                            </a>
                        </p>

                        <p class="pname">
                            <a href="Product.xhtml?param=${pro.pid}">
                                    ${pro.pname}
                            </a>
                        </p>
                        <p class="ptype">
                            <a href="Product.xhtml?param=${pro.ptype}">
                                    ${pro.ptype}
                            </a>
                        </p>
                    </div>

                    <div>
                        <table>
                            <tr>
                                <td>
                                    <p class="ptype">
                                        <a href="Product.xhtml?param=${pro.ptype}">
                                                ${pro.ptype}
                                        </a>
                                    </p>
                                </td>

                                <td>
                                    <p class="ptype">
                                        <a href="Product.xhtml?param=${pro.ptype}">
                                                ${pro.ptype}
                                        </a>
                                    </p>
                                </td>

                                <td>
                                    <p class="ptype">
                                        <a href="Product.xhtml?param=${pro.ptype}">
                                                ${pro.ptype}
                                        </a>
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
            </c:forEach>
        </div>

        &lt;%&ndash;商品类型 3 &ndash;%&gt;
        <div id="project1">
            <c:forEach items="${indexBean.getPhone}" var="pro">
                <div>
                    <div>
                        <p class="picture">
                            <a href="Product.xhtml?param=${pro.pid}">
                                <img src="${pro.pimagePath}"/>
                            </a>
                        </p>

                        <p class="pname">
                            <a href="Product.xhtml?param=${pro.pid}">
                                    ${pro.pname}
                            </a>
                        </p>
                        <p class="ptype">
                            <a href="Product.xhtml?param=${pro.ptype}">
                                    ${pro.ptype}
                            </a>
                        </p>
                    </div>

                    <div>
                        <table>
                            <tr>
                                <td>
                                    <p class="ptype">
                                        <a href="Product.xhtml?param=${pro.ptype}">
                                                ${pro.ptype}
                                        </a>
                                    </p>
                                </td>

                                <td>
                                    <p class="ptype">
                                        <a href="Product.xhtml?param=${pro.ptype}">
                                                ${pro.ptype}
                                        </a>
                                    </p>
                                </td>

                                <td>
                                    <p class="ptype">
                                        <a href="Product.xhtml?param=${pro.ptype}">
                                                ${pro.ptype}
                                        </a>
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
            </c:forEach>
        </div>--%>

</div>


<!--撑出页脚-->
<div id="blank" style="height:900px"></div>


</body>
</html>

