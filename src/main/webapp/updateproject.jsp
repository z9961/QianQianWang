<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>添加项目</title>
    <script src="js/jquery.js" type="text/javascript"></script>
    <link rel="stylesheet" type="text/css" href="css/lrf.css"/>

</head>
<body>

<div id="bg" style="height: 100%"></div>

<form id="registerinfo" action="UpdateProject.mvc" method="POST" style="margin-top: 50px;">
    <table id="table">
        <caption style="color: white">项目信息</caption>
        <tr>
            <td class="word">项目名称</td>
            <td><input id="PName" name="PName" type="text" value="${updateproject.pName}" required maxlength="30"/></td>
        </tr>
        <tr>
            <td class="word">项目描述</td>
            <td><input id="PDesc" name="PDesc" type="text" value="${updateproject.pDesc}" required maxlength="200"/>
            </td>

        </tr>
        <tr>
            <td class="word">开始时间</td>
            <td><input id="PSD" name="PSD" type="datetime-local" value="${updateproject.psd}" required/></td>
        </tr>
        <tr>
            <td class="word">结束时间</td>
            <td><input id="PED" name="PED" type="datetime-local" value="${updateproject.ped}" required/></td>
        </tr>

        <tr>
            <td class="word">目标金额</td>
            <td><input id="PTarget" name="PTarget" type="text" value="${updateproject.pTarget}" required maxlength="9"/>
            </td>

        </tr>

        <tr>
            <td class="word">投资前景</td>
            <td><input id="PMilestone" name="PMilestone" type="text" value="${updateproject.pMilestone}" required
                       maxlength="200"/></td>

        </tr>


        <tr>
            <td class="word">项目类型</td>
            <td>
                <input name="PCategoryId" type="radio" checked="checked" value="1">数码
                <input name="PCategoryId" type="radio" value="2">生活
                <input name="PCategoryId" type="radio" value="3">艺术
            </td>
        </tr>
        <tr>
            <td class="word">备注</td>
            <td><input id="PRemark" name="PRemark" type="text" value="${updateproject.pRemark}" required
                       maxlength="200"/></td>

        </tr>
        <tr>
            <td class="word">货币币种标识</td>
            <td><input id="PMF" name="PMF" type="text" value="${updateproject.pmf}" required/></td>

        </tr>

        <tr>
            <td class="word">限制最大金额</td>
            <td>
                <input name="PLimit" type="radio" checked="checked" value="1">是
                <input name="PLimit" type="radio" value="0">否
            </td>
        </tr>

        <tr>
            <td class="word">项目团队介绍</td>
            <td><input id="PTeam" name="PTeam" type="text" value="${updateproject.pTeam}" required maxlength="200"/>
            </td>
        </tr>

        <tr>
            <td class="word">项目开发计划</td>
            <td><input id="PPlan" name="PPlan" type="text" value="${updateproject.pPlan}" required maxlength="100"/>
            </td>
        </tr>


        <tr>
            <td></td>
            <td>
                <input id="subbtn" type="submit" value="提交项目"/>
            </td>
        </tr>

    </table>
</form>

</body>
</html>
