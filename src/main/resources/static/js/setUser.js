$(document).ready(function(){
    var role = $('#role').val();
    var email = $('#email').val();
    localStorage.setItem("email",email);
    localStorage.setItem("role",role);
    console.log(email);
    console.log(role);
//    window.location.href('/index'); 
    $(location).attr('href',"/index");
});