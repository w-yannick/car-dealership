$(document).ready(function(){
    console.log(localStorage.getItem("userId"));
    $('#userId').html(localStorage.getItem("userId"));
    $('#userId').val(localStorage.getItem("userId"));
    console.log(localStorage.getItem("role"));
////    window.location.href('/index'); 
//    $(location).attr('href',"/index");
});