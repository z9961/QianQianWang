<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>

<head>
    <title>钱钱网</title>
    <script src="js/jquery.js" type="text/javascript"></script>
    <script src="js/footer.js" type="text/javascript"></script>
    <script src="js/index.js" type="text/javascript"></script>
    <link rel="stylesheet" type="text/css" href="css/index.css"/>
    <link rel="stylesheet" type="text/css" href="css/footer.css"/>
    <link rel="stylesheet" type="text/css" href="css/header.css"/>

    <script type="text/javascript">
        window.onload = cheangetime();

        var existpagemsg = ${existpagemsg};
        if (existpagemsg) {
            var msg = '${pagemsg}';
            alert(msg);
        }

        function topage(jpage) {
            window.location.href = "Projectlistpage.mvc?page=" + jpage;
        }

    </script>

</head>

<body>

<!--引入头部-->
<div id="head_div">
    <jsp:include page="h.jsp"></jsp:include>
</div>
<!--总体div-->
<div id="all">

    <%--<script type="text/javascript" src="js/head_div.js"></script>--%>
    <!--插入页眉-->

    <br/>

    <br>
    <br>

    <div id="b2" style="margin-top: -10px">
        <c:if test="${typestrtype==0}">
            <img class="imgtitle2" src="${typestr}"/>
        </c:if>
        <c:if test="${typestrtype==1}">
            ${typestr}
        </c:if>


        <div name="projectdiv">
            <ul name="menu">
                <c:forEach items="${projectlist}" var="pro">
                    <li>
                        <div>
                            <p class="picture">
                                <a href="ShowProject.mvc?pid=${pro.pId}">
                                    <img class="pimg" src="images/${pro.pId}/0.jpg"/>
                                </a>
                            </p>

                            <p class="pname">
                                <a href="ShowProject.mvc?pid=${pro.pId}"">
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
                                                ${pro.pnp}人次

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


    </div>

    <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>

    <div style="text-align: right;">
        <%--分页--%>

        共${countlist}条记录，当前显示第${nowpage}页 / 共${pages}页


        <form action="Projectlistpage.mvc" method="post">
            跳转
            <input type="text" name="page" style="width: 40px;height: 20px"/> 页
            <input type="submit" value="确认跳转">
        </form>


        <p>

            <input type="button" value="首页"
                    <c:if test="${nowpage > 1 }">
                        onclick="topage(1)"
                    </c:if>
            />
            &nbsp;
            <c:if test="${nowpage > 1 }">
                <input type="button" onclick="topage(${nowpage-1})" value="上一页"/>
            </c:if>
            &nbsp;
            <c:if test="${nowpage < pages}">
                <input type="button" onclick="topage(${nowpage+1})" value="下一页"/>
            </c:if>
            &nbsp;
            <input type="button" value="末页"
                    <c:if test="${nowpage < pages}">
                        onclick="topage(${pages})"
                    </c:if>
            />

        </p>
    </div>

</div>


<!--撑出页脚-->
<div id="blank" style="height:3px"></div>

</body>

