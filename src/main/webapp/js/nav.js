//实现二级菜单
$(function () {
    //上下滑用时
    var st = 180;
    //鼠标移入展开
    $('#nav_all>li').mouseenter(function () {
        //stop停止当前正在运行的动画，防止反复
        $(this).find('ul').stop(false, true).slideDown(st);
    });
    //鼠标移出缩回
    $('#nav_all>li').mouseleave(function () {
        $(this).find('ul').stop(false, true).slideUp(st);
    });
});