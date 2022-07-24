$(document).ready(function(){
    var val = $("#makeId").val(); 
    console.log(val);
     var url = "http://localhost:8080/api/models?makeId="+val;
    $.ajax({
            type: 'GET',
            url: url,
            success:function(modelArray) {
                $("#modelId").empty();
                $.each(modelArray, function(index, carModel) {
                    console.log(carModel.carModelId);
                    console.log(carModel.name);
                    $("#modelId").append('<option value=' +carModel.carModelId + '>'+carModel.name+'</option>');
           
                });
            },
            error: function(result) {
                alert('error');
            } 

    });
   
    console.log($("#year").attr("min",2000));
    $("#year").attr("max",(new Date().getFullYear()+1));
});





$("#makeId").on('change', function(){
    console.log("list item selected");
    var val = $(this).val();    
    console.log(val);
    var url = "http://localhost:8080/api/models?makeId="+val;
    $.ajax({
            type: 'GET',
            url: url,
            success:function(modelArray) {
                $("#modelId").empty();
                $.each(modelArray, function(index, carModel) {
                    console.log(carModel.carModelId);
                    console.log(carModel.name);
                    $("#modelId").append('<option value=' +carModel.carModelId + '>'+carModel.name+'</option>');
           
                });
            },
            error: function(result) {
                alert('error');
            } 

    });
});
 

$()