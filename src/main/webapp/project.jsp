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
                <p>此项目必须在${showproject.ped}前得到${showproject.pTarget}的支持才可成功！剩余${timestr}！</p>
                支持额：<input type="number"/>
                <button type="submit"/>
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
        <form id="comments">
            <c:if test="{showproject.projectCommentsByPId!=null}">
                <c:forEach items="#{showproject.projectCommentsByPId}" var="fb">
                    <div>
                        <hr/>
                        <div>
                            <div>
                                <table>

                                    <tr>
                                        <td>
                                            用户名： ${fb.usersByBuyuserId.uName}
                                        </td>
                                        <td id="commentsinfo">
                                            评论时间： ${fb.id.time}
                                        </td>
                                    </tr>

                                </table>

                            </div>
                            <br/>
                            <div>
                                <p id="comment">${fb.comment}</p>
                            </div>
                        </div>

                        <br/>

                        <hr/>
                    </div>

                </c:forEach>


            </c:if>

            <div id="inputComment">
                <br/>
                <p>请说出您对该商品的看法：</p>
                <br/><h:inputTextarea id="commentsinput" rows="3" cols="100" value="#{productBean.comments}"/>
                <br/>
                <h:commandButton value="提交" type="submit" action="#{productBean.insertComment()}"/>
            </div>

        </form>
    </div>


    <!--撑出页脚-->
    <div id="blank" style="height:1100px"></div>

    <script type="text/javascript">
        window.onload = cheangetime();
    </script>
</body>
