$(document).ready(function(){
    console.log(localStorage.getItem("vinNumber"));
    $('#message').text(localStorage.getItem("vinNumber"));
    localStorage.removeItem("vinNumber");
//    var vinNumber = $('#vinNumber').text();
//        console.log(vinNumber);
//        localStorage.setItem("vinNumber",vinNumber);
//    });
});

