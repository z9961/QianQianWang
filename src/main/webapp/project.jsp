<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>

<c:if test="${project==null}">
    <!-- JSP提供的 转发标签 -->
    <jsp:forward page="ShowProject.mvc.mvc"/>
</c:if>

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
            <img id="product" src="${productBean.product.pimagePath}"/>
        </div>
        <div id="right">
            <form>
                <p>${用于存放项目名}</p>
                <p>已筹到</p>
                <p>${用于存放现在金额}</p>
                <div>
                    <div>
                        <%--此地放进度条--%>
                    </div>
                    <div>
                        <p>当前进度...</p>
                        <p>...名支持者</p>
                    </div>
                </div>
                <p>此项目必须在${日期}前得到${目标金额}的支持才可成功！剩余${日期}天！</p>
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
            <c:forEach items="#{评论}" var="fb">
                <div>
                    <hr/>
                    <div>
                        <div>
                            <table>

                                <tr>
                                    <td>
                                        用户名： ${fb.usersByBuyuserId.uname}
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
