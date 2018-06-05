<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>


<!DOCTYPE html>
<head>
    <meta charset="UTF-8"/>
    <link href="css/bootstrap.css" rel="stylesheet">
    <link href="css/fileinput.css" media="all" rel="stylesheet" type="text/css"/>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" media="all"
          rel="stylesheet" type="text/css"/>
    <link href="themes/explorer-fa/theme.css" media="all" rel="stylesheet" type="text/css"/>
    <script src="js/jquery.js"></script>
    <script src="js/plugins/sortable.js" type="text/javascript"></script>
    <script src="js/fileinput.js" type="text/javascript"></script>

    <script src="themes/explorer-fa/theme.js" type="text/javascript"></script>
    <script src="themes/fa/theme.js" type="text/javascript"></script>
    <script src="js/zh.js" type="text/javascript"></script>
    <script src="js/plugins/popper.min.js" type="text/javascript"></script>
    <script src="js/bootstrap.js" type="text/javascript"></script>
    <script src="js/footer.js" type="text/javascript"></script>
    <link rel="stylesheet" type="text/css" href="css/footer.css"/>

    <style>
        #logo {
            /*position: absolute;*/
            height: 75px;
            margin: 20px 200px;
            z-index: 2;
        }

    </style>
</head>

<body>

<img id="logo" src="images/logo.png"/>

<div class="container kv-main">
    <form action="Upload.mvc" method="POST" enctype="multipart/form-data">
        <div class="file-loading">
            <input id="itemImagers" name="itemImagers" type="file" multiple>
        </div>
        <br>
        <button type="submit" class="btn btn-primary" onclick="submitimg()">提交</button>
    </form>
    <br>
</div>
<div id="blank" style="height: 350px"></div>
</body>
<script>
    // var path = 'Upload.mvc';
    $(document).ready(function () {
        $("#itemImagers").fileinput({
            language: 'zh', //设置语言
            'theme': 'explorer-fa',  //横排
            // 'uploadUrl': path,      //使用form提交不需要地址
            showUpload: false,
            // enctype : 'multipart/form-data',
            overwriteInitial: false,
            uploadAsync: false,
            initialPreviewAsData: true,
            allowedFileExtensions: ['jpg'],   //限制文件类型
            layoutTemplates: {
                // actionDelete:'', //去除上传预览的缩略图中的删除图标
                actionUpload: '',//去除上传预览缩略图中的上传图片；
                // actionZoom:''   //去除上传预览缩略图中的查看详情预览的缩略图标。
            },
        });
    });

    function submitimg() {
        $('#itemImagers').fileinput('upload');
    }
</script>
</html>