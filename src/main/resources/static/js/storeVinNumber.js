$(document).ready(function(){
    
    $("#contact-button").click(function(){
    var vinNumber = $('#vinNumber').text();
        console.log(vinNumber);
        localStorage.setItem("vinNumber",vinNumber);
    });
});

