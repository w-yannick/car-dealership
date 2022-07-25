$(document).ready(function(){
    var salePrice = $("#salePrice").text();
    var MSRP = $("#MSRP").text();
    console.log("salePrice:"+salePrice);
    console.log("MSRP:"+MSRP);
    
    var minPurchasePrice = (95/100) * salePrice;
    var maxPurchasePrice = MSRP;
    $("#purchasePrice").attr("min",minPurchasePrice);
    $("#purchasePrice").attr("max",maxPurchasePrice);
});




$('#email').on('change', function(){
    if($('#email').val() !== ""){
        $('#phone').removeAttr("required");
        console.log("email changed");
    }
    else{
        $('#phone').attr("required",true)
    }
               
});
 
 $('#phone').on('change', function(){
    if($('#phone').val() !== ""){
        $('#email').removeAttr("required");
        console.log("phone changed");
    }
    else{
        $('#email').attr("required",true)
    }
});
