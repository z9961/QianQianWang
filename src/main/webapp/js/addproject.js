function checkaddproject() {
    var PName = document.getElementById("PName").value;
    var PDesc = document.getElementById("PDesc").value;
    var PTarget = document.getElementById("PTarget").value;
    var PMilestone = document.getElementById("PMilestone").value;
    var PTeam = document.getElementById("PTeam").value;
    var PPlan = document.getElementById("PPlan").value;
    //去除空格


    //验证模块
    if (PName.length < 2 || PName.length > 20) {
        alert("项目名长度应在2-20之间");
        return false;
    }
    if (PDesc.length < 5 || PDesc.length > 200) {
        alert("项目描述长度应在5-200之间");
        return false;
    }

    if (PTarget < 5 || PDesc > 99999999) {
        alert("目标金额应在5-99999999之间");
        return false;
    }

    if (PMilestone.length < 5 || PMilestone.length > 200) {
        alert("投资前景长度应在5-200之间");
        return false;
    }
    if (PTeam.length < 5 || PTeam.length > 500) {
        alert("项目团队介绍长度应在5-200之间");
        return false;
    }
    if (PPlan.length < 5 || PPlan.length > 500) {
        alert("项目开发计划长度应在5-500之间");
        return false;
    }


    console.log("检查完毕,提交数据");

    $("#addproform").submit();

}