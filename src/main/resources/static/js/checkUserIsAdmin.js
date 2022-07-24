$(document).ready(function(){

    var role = localStorage.getItem("role");
    if(role !== "Admin")
        window.location.replace('/login'); 
    
});