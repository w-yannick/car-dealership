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
 

$("#type").on('change', function(){
    console.log("list item selected");
    var val = $(this).val();
    if(val == "New"){
        $("#mileage").attr("min",0);
        $("#mileage").attr("max",1000);
        $("#mileage").val(0);
    }
    else{
        $("#mileage").attr("min",1001);
        $("#mileage").removeAttr("max");
        $("#mileage").val(1001);
    }
});

$("#MSRP").on('change', function(){
    var val = $(this).val();
        $("#salePrice").attr("min",0);
        $("#salePrice").attr("max",val);
        $("#salePrice").val(val);
    
});

$("#file").change(function() {
  filename = this.files[0].name;
  console.log(filename);
});