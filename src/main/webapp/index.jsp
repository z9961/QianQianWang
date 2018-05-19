<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>

<c:if test="${ihot==null}">
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

        <div id="if">
            <iframe id="Carousel_figure" src="carousel.jsp"></iframe>
        </div>
    </div>

    <!--插入页眉-->
    <script type="text/javascript" src="js/head_div.js"></script>


    <div id="b2">
        <%--热门推荐 --%>
        <img class="imgtitle" src="images/热门推荐.png"/>
        <div name="projectdiv">
            <ul name="menu">
                <c:forEach items="${ihot}" var="pro" begin="0" end="3">
                    <li>
                        <div>
                            <p class="picture">
                                <a href="ShowProject.mvc?pid=${pro.pId}">
                                    <img class="pimg" src="images/${pro.pId}/0.jpg"/>
                                </a>
                            </p>

                            <p class="pname">
                                <a href="ShowProject.mvc?pid=${pro.pId}">
                                        ${pro.pName}
                                </a>
                            </p>
                            <p class="ptype" style="width: 40px">
                                <a class="ptypea" href="ShowProject.mvc?pid=${pro.pId}">
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

                                    </td>
                                </tr>
                                <tr>
                                    <td width="100px">支持</td>
                                    <td width="140px">已筹</td>

                                </tr>
                                <tr>
                                    <td>剩余时间</td>
                                    <td>
                                        <p>
                                            <input style="display: none" name="pedC" value="${pro.ped}">
                                            <input class="ped" name="ped" value="${pro.ped}" disabled>
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
            <br/>
            <br/>
        <%--最新上架 --%>
        <img class="imgtitle" src="images/最新.png"/>
        <div name="projectdiv">
            <ul name="menu">

                <c:forEach items="${inewp}" var="pro" begin="0" end="3">
                    <li>
                        <div>
                            <p class="picture">
                                <a href="ShowProject.mvc?pid=${pro.pId}">
                                    <img class="pimg" src="images/${pro.pId}/0.jpg"/>
                                </a>
                            </p>

                            <p class="pname">
                                <a href="ShowProject.mvc?pid=${pro.pId}">
                                        ${pro.pName}
                                </a>
                            </p>
                            <p class="ptype" style="width: 40px">
                                <a class="ptypea"
                                   href="Projectlist.mvc?type=${pro.projectTypeByPCategoryId.projectTypeId+2}">
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

                                    </td>
                                </tr>
                                <tr>
                                    <td width="100px">支持</td>
                                    <td width="140px">已筹</td>

                                </tr>
                                <tr>
                                    <td>剩余时间</td>
                                    <td>
                                        <p>
                                            <input style="display: none" name="pedC" value="${pro.ped}">
                                            <input class="ped" name="ped" value="${pro.ped}" disabled>
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
            <br/>
            <br/>

        <%--商品类型 1 --%>
        <img class="imgtitle" src="images/数码.png"/>
        <div name="projectdiv">
            <ul name="menu">

                <c:forEach items="${ip1}" var="pro" begin="0" end="3">
                    <li>
                        <div>
                            <p class="picture">
                                <a href="ShowProject.mvc?pid=${pro.pId}">
                                    <img class="pimg" src="images/${pro.pId}/0.jpg"/>
                                </a>
                            </p>

                            <p class="pname">
                                <a href="ShowProject.mvc?pid=${pro.pId}">
                                        ${pro.pName}
                                </a>
                            </p>
                            <p class="ptype" style="width: 40px">
                                <a class="ptypea"
                                   href="Projectlist.mvc?type=${pro.projectTypeByPCategoryId.projectTypeId+2}">
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

                                    </td>
                                </tr>
                                <tr>
                                    <td width="100px">支持</td>
                                    <td width="140px">已筹</td>

                                </tr>
                                <tr>
                                    <td>剩余时间</td>
                                    <td>
                                        <p>
                                            <input style="display: none" name="pedC" value="${pro.ped}">
                                            <input class="ped" name="ped" value="${pro.ped}" disabled>
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
            <br/>
            <br/>
        <%--商品类型 2 --%>
        <img class="imgtitle" src="images/生活.png"/>
        <div name="projectdiv">
            <ul name="menu">
                <c:forEach items="${ip2}" var="pro" begin="0" end="3">
                    <li>
                        <div>
                            <p class="picture">
                                <a href="ShowProject.mvc?pid=${pro.pId}">
                                    <img class="pimg" src="images/${pro.pId}/0.jpg"/>
                                </a>
                            </p>

                            <p class="pname">
                                <a href="ShowProject.mvc?pid=${pro.pId}">
                                        ${pro.pName}
                                </a>
                            </p>
                            <p class="ptype" style="width: 40px">
                                <a class="ptypea"
                                   href="Projectlist.mvc?type=${pro.projectTypeByPCategoryId.projectTypeId+2}">
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

                                    </td>
                                </tr>
                                <tr>
                                    <td width="100px">支持</td>
                                    <td width="140px">已筹</td>

                                </tr>
                                <tr>
                                    <td>剩余时间</td>
                                    <td>
                                        <p>
                                            <input style="display: none" name="pedC" value="${pro.ped}">
                                            <input class="ped" name="ped" value="${pro.ped}" disabled>
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
            <br/>
        <br/>
        <%--商品类型 3 --%>
        <img class="imgtitle" src="images/艺术.png"/>
        <div name="projectdiv">
            <ul name="menu">
                <c:forEach items="${ip3}" var="pro" begin="0" end="3">
                    <li>
                        <div>
                            <p class="picture">
                                <a href="ShowProject.mvc?pid=${pro.pId}">
                                    <img class="pimg" src="images/${pro.pId}/0.jpg"/>
                                </a>
                            </p>

                            <p class="pname">
                                <a href="ShowProject.mvc?pid=${pro.pId}">
                                        ${pro.pName}
                                </a>
                            </p>
                            <p class="ptype" style="width: 40px">
                                <a class="ptypea"
                                   href="Projectlist.mvc?type=${pro.projectTypeByPCategoryId.projectTypeId+2}">
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

                                    </td>
                                </tr>
                                <tr>
                                    <td width="100px">支持</td>
                                    <td width="140px">已筹</td>

                                </tr>
                                <tr>
                                    <td>剩余时间</td>
                                    <td>
                                        <p>
                                            <input style="display: none" name="pedC" value="${pro.ped}">
                                            <input class="ped" name="ped" value="${pro.ped}" disabled>
                                        </p>
                                    </td>
                                </tr>
                            </table>
                        </div>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </div>
</div>


<!--撑出页脚-->
<div id="blank" style="height:2150px"></div>

<script type="text/javascript">
    window.onload = cheangetime();
</script>
</body>
</html>

