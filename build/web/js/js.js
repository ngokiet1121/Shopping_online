/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//$('#myModal').modal({
//    backdrop: 'static',
//    keyboard: false
//})


function myFunction1() {
    var priceFrom1 = document.getElementById("test1").value;
    document.getElementById("sizeInput").value = priceFrom1;
}
function myFunction2() {
    var priceFrom2 = document.getElementById("test2").value;
    document.getElementById("sizeInput").value = priceFrom2;
}
function myFunction3() {
    var priceFrom3 = document.getElementById("test3").value;
    document.getElementById("sizeInput").value = priceFrom3;
}
function myFunction4() {
    var priceFrom4 = document.getElementById("test4").value;
    document.getElementById("sizeInput").value = priceFrom4;
}
function myFunction5() {
    var priceFrom5 = document.getElementById("test5").value;
    document.getElementById("sizeInput").value = priceFrom5;
}
function myFunction6() {
    var priceFrom6 = document.getElementById("test6").value;
    document.getElementById("sizeInput").value = priceFrom6;
}

window.onload = function () {
    setTimeout("switchImage()", 3000);
}
var current = 1;
var numIMG = 3;
function switchImage() {
    current++;
    // Thay thế hình
    document.images['myimage'].src = 'img/banner' + current + '.jpg';
    // Gọi lại hàm nếu thõa đk
    if (current == numIMG) {
        current = 0;
    }
    setTimeout("switchImage()", 3000);
}
