<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>上传图片</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="css/fileinput.css" media="all">
    <script src="js/jquery.js" type="text/javascript"></script>
    <script src="js/footer.js" type="text/javascript"></script>
    <link href="themes/explorer-fa/theme.css" media="all" rel="stylesheet" type="text/css"/>
    <script src="js/plugins/piexif.min.js" type="text/javascript"></script>
    <script src="js/plugins/sortable.min.js" type="text/javascript"></script>
    <script src="js/plugins/purify.min.js" type="text/javascript"></script>
    <script src="js/plugins/popper.min.js" type="text/javascript"></script>
    <script type="text/javascript" src="js/bootstrap.js"></script>
    <script type="text/javascript" src="js/fileinput.js"></script>
    <script type="text/javascript" src="themes/fa/theme.min.js"></script>
    <script type="text/javascript" src="js/zh.js"></script>
    <%--<link rel="stylesheet" type="text/css" href="css/lrf.css"/>--%>
    <%--<link rel="stylesheet" type="text/css" href="css/footer.css"/>--%>

    <style>
        #logo {
            /*position: absolute;*/
            height: 75px;
            margin: 20px 200px;
            z-index: 2;
        }

    </style>
</head>

<img id="logo" src="images/logo.png"/>
<div class="page-header">
    <h1>Bootstrap File Input Example
        <small><a href="https://github.com/kartik-v/bootstrap-fileinput-samples"><i
                class="glyphicon glyphicon-download"></i> Download Sample Files</a></small>
    </h1>
</div>
<form enctype="multipart/form-data">
    <div class="file-loading">
        <input id="kv-explorer" type="file" multiple>
    </div>
    <br>
    <div class="file-loading">
        <input id="file-0a" class="file" type="file" multiple data-min-file-count="1">
    </div>
    <br>
    <button type="submit" class="btn btn-primary">Submit</button>
    <button type="reset" class="btn btn-default">Reset</button>
</form>
<hr>
<%--<div id="bg"></div>--%>

<%--<div class="form-group" style="height: 500px;width: 1200px;margin: 0 auto">--%>
<%--<input id="itemImagers" name="itemImagers" type="file" multiple data-overwrite-initial="false"--%>
<%--data-min-file-count="2">--%>
<%--</div>--%>

<%--<form id="upform" action="Upload.mvc" method="POST" style="margin-top: 0;" enctype="multipart/form-data">--%>
<%--<table id="table">--%>
<%--<caption style="color: black">上传项目图片</caption>--%>

<%--<tr id="firstfile">--%>
<%--<td>--%>
<%--<input type="file" name="file" onchange="selectimg(this)"/>--%>
<%--<p class="selectimg">--%>
<%--<input type="button" value="选择图片"></input>--%>
<%--</p>--%>
<%--</td>--%>
<%--</tr>--%>
<%--<tr>--%>
<%--<td>--%>
<%--<input id="addfilenum" type="button" value="增加图片数量" onclick="adnum();"/>--%>
<%--</td>--%>
<%--</tr>--%>
<%--<tr>--%>
<%--<td>--%>
<%--<input id="subbtn" type="submit" value="提交项目"/>--%>
<%--</td>--%>
<%--</tr>--%>

<%--</table>--%>
<%--</form>--%>

<!--撑出页脚-->
<div id="blank" style="height: 200px"></div>
<script type="text/javascript">
    //初始化fileinput控件（第一次初始化）
    function initFileInput(ctrlName, uploadUrl) {
        var control = $('#' + ctrlName);
        control.fileinput({
            language: 'zh', //设置语言
            uploadUrl: uploadUrl, //上传的地址
            allowedFileExtensions: ['jpg', 'png', 'gif'],//接收的文件后缀
            //uploadAsync: false, //插件支持同步和异步
            //showUpload: false, //是否显示上传按钮
        }).on("fileuploaded", function (event, data) {
            //上传图片后的回调函数，可以在这做一些处理
        });
    }


    $(function () {
        //指定上传controller访问地址
        var path = 'Upload.mvc';
        //页面初始化加载initFileInput()方法传入ID名和上传地址
        initFileInput("itemImagers", path);
    })

</script>
</body>
</html>
