<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>钱钱网</title>
    <script src="js/jquery.js" type="text/javascript"></script>
    <script src="js/footer.js" type="text/javascript"></script>
    <script src="js/index.js" type="text/javascript"></script>
    <link rel="stylesheet" type="text/css" href="css/footer.css"/>
    <link rel="stylesheet" type="text/css" href="css/header.css"/>


</head>

<body>

<!--引入头部-->
<div id="head_div"></div>
<!--总体div-->
<div id="all">

    <!--模块1-->
    <div>
        <div id="left">
            <img id="product" src="${imglist[0].imgPath}"/>
        </div>
        <div id="right">
            <form>
                <p>${showproject.pName}</p>
                <p>已筹到</p>
                <p>${showproject.pnm}</p>
                <div>
                    <div>
                        <%--此地放进度条--%>
                    </div>
                    <div>
                        <p>当前进度${percentage}</p>
                        <p>${showproject.pnp}名支持者</p>
                    </div>
                </div>
                <p>此项目必须在${showproject.ped}前得到${showproject.pTarget}的支持才可成功！剩余
                <p><input class="ped" name="ped" value="${showproject.ped}" disabled></p>
                </p>
                <form action="AddOrder.mvc" method="post">
                    <table>
                        <tr>
                            <td>
                                支持额：
                            </td>
                            <td>
                                <input type="number" name="ordernum"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                是否需要回报:
                            </td>
                            <td>
                                <input name="oexpect" type="radio" checked="checked" value="1" onclick="showdiv()">是
                                <input name="oexpect" type="radio" value="0" onclick="notshowdiv()">否
                            </td>
                        </tr>
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
                                <input type="text" name="oexpectOther">
                            </td>
                        </tr>
                    </table>
                    <input type="submit" value="确认支持"/>
                </form>

            </form>
        </div>
    </div>

    <!--模块2-->
    <div id="menu_main" style="margin-top: 510px;">
        <ul id="menu">
            <li><p onclick="showintroducation()">产品介绍</p></li>
            <li><p>&nbsp;&nbsp;|&nbsp;&nbsp;</p></li>
            <li><p onclick="showcomments()">留言</p></li>
        </ul>
    </div>
    <br/>
    <div id="introducation">
        <%--显示产品介绍--%>
    </div>
    <div id="commentsDiv">

        <c:if test="${comlist!=null}">
            test
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
                <input type="text" id="newcom" name="newcom" style="row-span: 3;column-span: 100" required>
                <br/>
                <input value="提交" type="submit"/>
            </form>
        </div>
        </form>


    </div>
</div>

<!--撑出页脚-->
<div id="blank" style="height:1100px"></div>

<script type="text/javascript">
    window.onload = cheangetime();

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


</script>
</body>
