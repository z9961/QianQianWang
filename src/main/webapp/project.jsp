<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>

<%--<%--%>
<%--String pid = request.getParameter("pid");--%>
<%--session.setAttribute("projectpagepid", pid);--%>
<%--%>--%>

<%--<c:if test="${empty imglist}">--%>
<%--<!-- JSP提供的 转发标签 -->--%>
<%--<jsp:forward page="ShowProject.mvc?pid=${projectpagepid}"/>--%>
<%--</c:if>--%>

<html>
<head>
    <title>钱钱网</title>
    <script src="js/jquery.js" type="text/javascript"></script>
    <%--<script src="js/footer.js" type="text/javascript"></script>--%>
    <script src="js/index.js" type="text/javascript"></script>
    <script src="js/product.js" type="text/javascript"></script>
    <script src="js/jquery-ui.min.js" type="text/javascript"></script>
    <link rel="stylesheet" type="text/css" href="css/jquery-ui.min.css"/>
    <%--<link rel="stylesheet" type="text/css" href="css/footer.css"/>--%>
    <link rel="stylesheet" type="text/css" href="css/header.css"/>
    <link rel="stylesheet" type="text/css" href="css/project.css"/>


</head>

<body>

<!--引入头部-->
<div id="head_div">
    <jsp:include page="h.jsp"></jsp:include>
</div>
<!--总体div-->
<div id="all">
    <!--插入页眉-->
    <%--<script type="text/javascript" src="js/head_div.js"></script>--%>
    <!--模块1-->
    <div id="m1">
        <div id="left">
            <c:forEach items="${imglist}" var="il" begin="0" end="0">
                <img id="product" src="${il.imgPath}">
            </c:forEach>
            <%--<img id="product" src="${imglist[0].imgPath}"/>--%>
        </div>
        <div id="right">
            <div id="rightTop">
                <p id="title">${showproject.pName}</p>
                <p>已筹到</p>
                <p id="got">
                    ${showproject.pnm}
                    <c:if test="${typestr!='USD'}">
                        ${typestr}
                        (${cpnm} $)
                    </c:if>
                </p>
                <div>
                    <div>

                        <div id="progressbar"></div>

                        <script>
                            $("#progressbar").progressbar({
                                value: ${percentage}
                            });
                            progressbar = $("#progressbar");
                            progressbarValue = progressbar.find(".ui-progressbar-value");
                            progressbarValue.css("background", "green");
                        </script>
                    </div>
                    <div>
                        <p id="now">当前进度${percentage}%&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${showproject.pnp}名支持者</p>
                    </div>
                </div>
                <p>此项目必须在
                    <span class="time">&nbsp;
                        <input id="pedt" name="pedC" value="${showproject.ped}" disabled>
                    </span>
                    &nbsp;
                    前得到
                    &nbsp;
                    <span class="time">
                        ${showproject.pTarget}
                            <c:if test="${typestr!='USD'}">
                                ${typestr}
                                (${cpt} $)
                            </c:if>

                    </span>
                    &nbsp;的支持才可成功！
                <p><input class="ped" name="ped" value="${showproject.ped}" disabled></p>
                </p>

            </div>

            <form action="AddOrder.mvc" method="post" id="orderform">
                <table>
                    <tr>
                        <td>

                            支持额：
                        </td>
                        <td>
                            <input class="input" type="number" name="ordernum" required/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            是否需要回报:
                            <input name="oexpect" type="radio" checked="checked" value="1" onclick="showdiv()">是
                            <input name="oexpect" type="radio" value="0" onclick="notshowdiv()">否
                        </td>
                        <td>

                        </td>
                    </tr>
                </table>
                <table>
                    <tr name="cdiv">
                        <td>
                            期许的回报:
                        </td>
                        <td>
                            <input name="oexpectType" type="radio" checked="checked" value="1">投资产品享受折扣
                        </td>
                    </tr>
                    <tr name="cdiv">
                        <td>

                        </td>
                        <td>
                            <input name="oexpectType" type="radio" value="2">购买产品享有更高折扣或附加服务
                        </td>
                    </tr>
                    <tr name="cdiv">
                        <td>

                        </td>
                        <td>
                            <input name="oexpectType" type="radio" value="3">免费获得投资产品
                        </td>
                    </tr>
                    <tr name="cdiv">
                        <td>

                        </td>
                        <td>
                            <input name="oexpectType" type="radio" value="4">其他
                            <br>
                            <input class="input" type="text" name="oexpectOther">
                        </td>
                    </tr>

                    <%--<c:if test="${empty addr}">--%>
                    <%--<script type="text/javascript">--%>
                    <%--window.location.href = "manage.jsp?mangetype=manageaddr";--%>
                    <%--</script>--%>
                    <%--</c:if>--%>


                    <tr name="cdiv">
                        <td>
                            地址:
                        </td>
                        <td>
                            <c:forEach items="${addr}" var="uad">
                                <input name="oaid" type="radio" value="${uad.aId}">
                                ${uad.address}
                            </c:forEach>
                        </td>
                    </tr>


                    <%--结束地址--%>
                </table>
                <input id="sbtn" class="but" type="submit" value="确认支持"/>
            </form>

        </div>
    </div>

    <!--模块2-->
    <div id="left2">
        <div id="menu_main" style="margin-top: 30px;">
            <ul id="menu">
                <li><p onclick="showintroducation()">产品介绍</p></li>
                <li><p>&nbsp;&nbsp;|&nbsp;&nbsp;</p></li>
                <li><p onclick="showcomments()">留言</p></li>
            </ul>
        </div>
        <br/>
        <div id="introducation">
            <c:forEach items="${imglist}" var="il">
                <img src="${il.imgPath}">
            </c:forEach>
            <%--显示产品介绍--%>
        </div>
        <div id="commentsDiv">

            <c:if test="${comlist!=null}">
                <c:forEach items="${comlist}" var="fb">
                    <div>
                        <hr/>
                        <div>
                            <div>
                                <table>

                                    <tr>
                                        <td>
                                            用户名： ${fb.usersByUPhone.uName}
                                        </td>
                                        <td id="commentsinfo">
                                            评论时间： ${fb.pcTime}
                                        </td>
                                    </tr>

                                </table>

                            </div>
                            <br/>
                            <div>
                                <p id="comment">${fb.pComment}</p>
                            </div>
                        </div>

                        <br/>

                        <hr/>
                    </div>

                </c:forEach>


            </c:if>

            <div id="inputComment">
                <form action="AddComment.mvc?pid=%{showproject.pId}" method="post">
                    <br/>
                    <p>请说出您对该商品的看法：</p>
                    <br/>
                    <input type="text" id="newcom" name="newcom" required>
                    <br/>
                    <input id="subbtn" value="提交" type="submit"/>
                </form>
            </div>
            </form>
        </div>
    </div>

    <div id="right2">
        <div id="desc">

            <a href="tencent://message/?uin=1043720879&Site=&Menu=yes" id="qbtn">咨询客服</a>
            <br>
            <br>
            项目介绍:${showproject.pDesc}
            <br/>
            投资前景:${showproject.pMilestone}
            <br/>
            项目团队介绍:${showproject.pTeam}
            <br/>
            项目开发计划:${showproject.pPlan}
        </div>

        <div id="hot">
            <img class="imgtitle" src="images/热门推荐.png"/>
            <div name="projectdiv">
                <ul name="menu">
                    <c:forEach items="${hot}" var="pro" begin="0" end="3">
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
        </br>
        </br>
    </div>
</div>

<!--撑出页脚-->
<div id="blank" style="height:2030px"></div>

<script type="text/javascript">
    //倒计时
    window.onload = cheangetime();

    //是否需要回报
    function showdiv() {
        var controls = document.getElementsByName("cdiv");
        for (var i = 0; i < controls.length; i++) {
            var c = controls[i];
            c.style.display = "table-row-group";
        }
    }

    function notshowdiv() {
        var controls = document.getElementsByName("cdiv");
        for (var i = 0; i < controls.length; i++) {
            var c = controls[i];
            c.style.display = "none";
        }
    }

    //判断项目是否已经超时
    var pcontrols = document.getElementById("pedt").value;
    nped = pcontrols.substr(0, pcontrols.length - 4);
    var npedfor = new Date(nped.replace(/-/g, "/"));
    var dateBegin = new Date(npedfor);
    var dateEnd = new Date();
    var dateDiff = dateBegin.getTime() - dateEnd.getTime();//时间差的毫秒数
    if (dateDiff <= 0) {
        document.getElementById("orderform").style.display = "none";
    }

</script>

</body>
<footer>
    <div id="footer">
        <br><br>
        Copyright ©2018 Made By
        <br>
        @境界的彼方 -许志伟 孟文杰 王坤.
        <br>-All rights reserved.
        <br><br>
    </div>
</footer>