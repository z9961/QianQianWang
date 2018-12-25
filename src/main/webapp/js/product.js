/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function showintroducation() {
    var introduce = document.getElementById("introducation");
    introduce.style.display = "block";
    var comments = document.getElementById("commentsDiv");
    comments.style.display = "none";
}

function showcomments() {
    var introduce = document.getElementById("introducation");
    introduce.style.display = "none";
    var comments = document.getElementById("commentsDiv");
    comments.style.display = "block";
}

