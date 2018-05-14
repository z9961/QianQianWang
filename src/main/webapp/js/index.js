function cheangetime() {


    var controls = document.getElementsByName("ped");
    for (var i = 0; i < controls.length; i++)//这里是length还是count记不清了
    {
        var ped = controls[i].value;

        ped = ped.substr(0, ped.length - 4);

        var pedfor = new Date(ped.replace(/-/g, "/"));
        var dateBegin = new Date(pedfor);
        var dateEnd = new Date();
        var dateDiff = dateBegin.getTime() - dateEnd.getTime();//时间差的毫秒数
        if (dateDiff <= 0) {
            controls[i].value = '已超过时间';
        } else {
            var dayDiff = Math.floor(dateDiff / (24 * 3600 * 1000));//计算出相差天数
            var leave1 = dateDiff % (24 * 3600 * 1000)    //计算天数后剩余的毫秒数
            var hours = Math.floor(leave1 / (3600 * 1000))//计算出小时数
            //计算相差分钟数
            var leave2 = leave1 % (3600 * 1000)    //计算小时数后剩余的毫秒数
            var minutes = Math.floor(leave2 / (60 * 1000))//计算相差分钟数
            //计算相差秒数
            var leave3 = leave2 % (60 * 1000)      //计算分钟数后剩余的毫秒数
            var seconds = Math.round(leave3 / 1000)
            var timestr = "剩余" + dayDiff + "天 " + hours + "小时 " + minutes + " 分钟" + seconds + " 秒";

            controls[i].value = timestr;
        }

    }
}