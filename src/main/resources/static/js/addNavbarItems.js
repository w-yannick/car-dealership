$(document).ready(function(){
    
    var role = localStorage.getItem("role");
    switch(role){
       
        case "Sales":
            $('#navbar').append(
                '<li class="nav-item" th:class="${activePage == "sales"} ? "nav-item active" : "nav-item"><a class="nav-link" href="/sales">Sales</a></li>'
            );
            $('#logout').append(
                '<li class="nav-item" th:class="${activePage == "login"} ? "nav-item active" : "nav-item" ><a class="nav-link" href="/login">logout</a></li>'
            );
            break;
        case "Admin":
            $('#navbar').append(
                '<li class="nav-item" th:class="${activePage == "sales"} ? "nav-item active" : "nav-item"><a class="nav-link" href="/sales">Sales</a></li>'
//                + '<li class="nav-item" th:class="${activePage == "admin"} ? "nav-item active" : "nav-item" ><a class="nav-link" href="/admin">Admin</a></li>'
            
                +'<li class="nav-item dropdown" th:class="${activePage == "admin"} ? "nav-item active" : "nav-item" >'
                +'<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown">'
                +    'Admin'
                +'</a>'
                +'<div class="dropdown-menu" aria-labelledby="navbarDropdown">'
                +  '<a class="dropdown-item" href="/admin/vehicules">vehicules</a>'
                +  '<div class="dropdown-divider"></div>'
                +  '<a class="dropdown-item" href="/admin/users">users</a>' 
                +  '<div class="dropdown-divider"></div>'
                +  '<a class="dropdown-item" href="/admin/makes">makes</a>' 
                +  '<div class="dropdown-divider"></div>'
                +  '<a class="dropdown-item" href="/admin/models">models</a>' 
                +  '<div class="dropdown-divider"></div>'
                +  '<a class="dropdown-item" href="/admin/specials">specials</a>' 
                +  '<div class="dropdown-divider"></div>'
                +  '<a class="dropdown-item" href="/reports/index">reports</a>' 
                +  '</div>'
                + '</li>'   
                
                    );
            $('#logout').append(
                '<li class="nav-item" th:class="${activePage == "login"} ? "nav-item active" : "nav-item" ><a class="nav-link" href="/login">logout</a></li>'
            );
            
        
    }
     
});