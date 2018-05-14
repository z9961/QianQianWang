<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>上传图片</title>
    <script src="js/jquery.js" type="text/javascript"></script>
    <script src="js/addproject.js" type="text/javascript"></script>
    <script src="js/footer.js" type="text/javascript"></script>
    <link rel="stylesheet" type="text/css" href="css/lrf.css"/>
    <link rel="stylesheet" type="text/css" href="css/footer.css"/>

</head>
<body>

<img id="logo" src="images/logo.png"/>

<div id="bg"></div>

<!--注册部分-->
<form id="registerinfo" action="Upload.mvc" method="POST" style="margin-top: 0;" enctype="multipart/form-data">
    <table id="table">
        <caption style="color: white">上传项目图片</caption>

        <tr id="firstfile">
            <td>
                <input type="file" name="file"/>
            </td>
        </tr>
        <tr>
            <td>
                <input id="addfilenum" type="button" value="增加图片数量" onclick="addfilenum()"/>
            </td>
        </tr>
        <tr>
            <td>
                <input id="subbtn" type="submit" value="提交项目"/>
            </td>
        </tr>

    </table>
</form>

<!--撑出页脚-->
<div id="blank"></div>

</body>
</html>
