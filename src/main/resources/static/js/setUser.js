$(document).ready(function(){
    var role = $('#role').val();
    var userId = $('#userId').val();
    localStorage.setItem("userId",userId);
    localStorage.setItem("role",role);
    console.log(userId);
    console.log(role);
//    window.location.href('/index'); 
    $(location).attr('href',"/index");
});