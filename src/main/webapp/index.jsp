<?xml version='1.0' encoding='UTF-8' ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:h="http://xmlns.jcp.org/jsf/html"
>
<h:head>
    <title>快买二手交易平台</title>
    <!--引入jquery-->
    <script src="js/jquery.js" type="text/javascript"></script>
    <!--插入页脚-->
    <script src="js/footer.js" type="text/javascript"></script>
    <!--Index样式-->
    <link rel="stylesheet" type="text/css" href="css/index.css.css"/>
    <!--页脚样式-->
    <link rel="stylesheet" type="text/css" href="css/footer.css"/>
    <!--页眉样式-->
    <link rel="stylesheet" type="text/css" href="css/header.css.css"/>


</h:head>

<h:body>
    <!--引入头部-->
    <div id="head_div"></div>
    <!--总体div-->
    <div id="all">

        <!--轮播图-->


        <div id="if">
            <!--<iframe id="Carousel_figure" src="Carousel_figure/index.html"></iframe>-->
            <iframe id="Carousel_figure" src="Carousel.xhtml"></iframe>
        </div>


        <!--设置轮播图的大小-->
        <h:outputScript library="js" name="Carousel_figure.js"/>
        <!--插入页眉-->
        <h:outputScript library="js" name="head_div.js"/>

    </div>

    <!--撑出页脚-->
    <div id="blank" style="height:900px"></div>


    <!--加载较慢-->

</h:body>
</html>

