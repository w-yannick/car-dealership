$(document).ready(function(){
    
    var email = localStorage.getItem("role");
    var role = localStorage.getItem("role");
        console.log(localStorage.getItem("email"));
    switch(role){
        case "Sales":
            $('#navbar').append(
                '"<li class="nav-item" th:class="${activePage == "sales"} ? "nav-item active" : "nav-item"><a class="nav-link" href="/sales">Sales</a></li>'
            );
        case "Admin":
            $('#navbar').append(
                '<li class="nav-item" th:class="${activePage == "admin"} ? "nav-item active" : "nav-item" ><a class="nav-link" href="/admin">Admin</a></li>'
            );
    }
     
    });