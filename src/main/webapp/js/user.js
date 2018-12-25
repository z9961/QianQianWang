//var $ = function(id) {
//	return document.getElementById(id);
//}

function changecolor(e) {
    var lfs = document.getElementsByClassName('left02down01');
    for (var i = 0; i < lfs.length; i++) {
        lfs[i].style.backgroundColor = '';
    }
    var cdiv = document.getElementById(e.id);
    cdiv = cdiv.parentNode;
    cdiv.style.backgroundColor = '#19A2D5';
}

function showperson(e) {
    document.getElementById("iframe").src = "manage_person.jsp";
    changecolor(e);
}


function showchangepwd(e) {
    document.getElementById("iframe").src = "manage_changepwd.jsp";
    changecolor(e);

}

function changeinfo(e) {
    document.getElementById("iframe").src = "manage_changeinfo.jsp";
    changecolor(e);
}

function manageaddr(e) {
    document.getElementById("iframe").src = "manage_address.jsp";
    changecolor(e);
}

function myorder(e) {
    document.getElementById("iframe").src = "manage_myorder.jsp";
    changecolor(e);
}

function mycomment(e) {
    document.getElementById("iframe").src = "manage_mycomment.jsp";
    changecolor(e);
}

function myproject(e) {
    document.getElementById("iframe").src = "manage_myproject.jsp";
    changecolor(e);
}

