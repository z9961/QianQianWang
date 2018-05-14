<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>

<head>
    <title>Facelet Title</title>

    <script type="text/javascript" src="js/Carousel.js"></script>
    <link type="text/css" rel="stylesheet" href="css/carousel.css"/>

</head>
<body>

<div id="container">
    <div id="list" style="left: -1000px;">
        <c:forEach items="${hot}" var="ad" varStatus="vs">
            <img src="#" alt=""/>
        </c:forEach>
    </div>
    <div id="buttons">
        <span index="1" class="on"></span>
        <c:forEach items="${hot}" var="ad" varStatus="vs">
            <span index="${vs.count}"></span>
        </c:forEach>
    </div>
    <a href="javascript:;" id="prev" class="arrow">&lt;</a>
    <a href="javascript:;" id="next" class="arrow">&gt;</a>
</div>

</body>
</html>

