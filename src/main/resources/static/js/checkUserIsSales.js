$(document).ready(function(){

    var role = localStorage.getItem("role");
    if(role !== "Admin" && role !== "Sales" )
        window.location.replace('/login'); 
    
});