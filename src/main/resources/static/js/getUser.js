$(document).ready(function(){
    console.log(localStorage.getItem("email"));
    $('#userEmail').html(localStorage.getItem("email"));
    $('#userEmail').val(localStorage.getItem("email"));
    console.log(localStorage.getItem("role"));
////    window.location.href('/index'); 
//    $(location).attr('href',"/index");
});