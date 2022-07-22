$(document).ready(function(){
    var type = $("#type").html();
    $("#button_1").click(function(){
        var quickSearch = $("#quick-search").val();
        var priceMin = $("#price-min").val();
        var priceMax = $("#price-max").val();
        var yearMin = $("#year-min").val();
        var yearMax = $("#year-max").val();
        var url = (type === "New") ? "http://localhost:8080/api/newInventory" : "http://localhost:8080/api/usedInventory";
        console.log(type);
        console.log(priceMin);
        console.log(priceMax);
        console.log(yearMin);
        console.log(yearMax);
        $.ajax({
            type: 'GET',
            url: url,
//            url: "http://contactlist.us-east-1.elasticbeanstalk.com/contacts",
            success:function(vehiculeArray) {
                var contactsDiv = $('#allContacts');
                $.each(vehiculeArray, function(index, vehicule) {
                    var vehiculeInfo = '<p>';
                    vehiculeInfo += 'id: ' + vehicule.vehiculeId + '<br>';
                    vehiculeInfo += 'id: ' + vehicule.year + '<br>';
                    vehiculeInfo += 'id: ' + vehicule.carModel.name + '<br>';
                    vehiculeInfo += 'id: ' + vehicule.carModel.make.name + '<br>';
                    vehiculeInfo += 'id: ' + vehicule.type + '<br>';
                    vehiculeInfo += 'id: ' + vehicule.bodyStyle + '<br>';
                    vehiculeInfo += 'id: ' + vehicule.automatic + '<br>';
                    vehiculeInfo += 'id: ' + vehicule.exteriorColor + '<br>';
                    vehiculeInfo += 'id: ' + vehicule.interiorColor + '<br>';
                    vehiculeInfo += 'id: ' + vehicule.mileage + '<br>';
                    vehiculeInfo += 'id: ' + vehicule.VINNumber + '<br>';
                    vehiculeInfo += 'id: ' + vehicule.MSRP + '<br>';
                    vehiculeInfo += 'id: ' + vehicule.salePrice + '<br>';
                    vehiculeInfo += 'id: ' + vehicule.description + '<br>';
                    vehiculeInfo += 'id: ' + vehicule.featured + '<br>';
                    vehiculeInfo += 'id: ' + vehicule.available + '<br>';
                    vehiculeInfo += '</p>';

                    vehiculeInfo += '<a href="/inventory/details?id='+vehicule.vehiculeId+'"><button class="btn btn-primary" id="vehicule-details-button">Details</button></a>';
                    vehiculeInfo += '<hr>';
            contactsDiv.append(vehiculeInfo);
            })
            },
            error: function(result) {
                alert('error');
            } 
        });
    });
});

