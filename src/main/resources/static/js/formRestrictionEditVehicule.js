$(document).ready(function(){
    /*<![CDATA[*/

    var carModelId = /*[[${vehicule.carModel.carModelId}]]*/ 'default';
    console.log(carModelId);

    /*]]>*/
    var val = $("#makeId").val(); 
    console.log("makeId" +val);
     var url = "http://localhost:8080/api/models?makeId="+val;
    $.ajax({
            type: 'GET',
            url: url,
            success:function(modelArray) {
                $("#modelId").empty();
                $.each(modelArray, function(index, carModel) {
                    var selected = (carModel.carModelId == carModelId)? true : false ;
                    console.log(carModel.carModelId);
                    console.log(carModel.name);
                    $("#modelId").append('<option value=' +carModel.carModelId +' selected=' + selected + '>'+carModel.name+'</option>');
           
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
    }
    else{
        $("#mileage").attr("min",1001);
        $("#mileage").removeAttr("max");
        $("#mileage").val(1001);
    }
});

$("#file").change(function() {
  filename = this.files[0].name;
  console.log(filename);
});

$('#delete-button').on('click', function(){
    
    var response = confirm("Are you sure you want to delete this vehicule?");
    if (response == true){
        var vehiculeId = $('#vehiculeId').val();
        $.ajax({
            type: 'DELETE',
            url: "http://localhost:8080/api/admin/deleteVehicule/"+vehiculeId,
            success:function(modelArray) {
                $(location).attr('href',"/admin/vehicules/");
                alert("Vehicule deleted");

            },
            error: function(result) {
                alert('Unable to delete');
            } 

        });
    }
});
