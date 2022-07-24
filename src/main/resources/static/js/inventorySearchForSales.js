$(document).ready(function(){
    var type = $("#type").html();
    $("#button_1").click(function(){
        var quickSearch = $("#quick-search").val();
        var minPrice = $("#price-min").val();
        var maxPrice = $("#price-max").val();
        var minYear = $("#year-min").val();
        var maxYear = $("#year-max").val();
        var url = "http://localhost:8080/api/availableInventory?";
        

//        String type,String quickSearch, Integer minPrice, Integer maxPrice, Integer minYear,Integer maxYear, Model model
        
        url +=(quickSearch != '') ? "quickSearch="+quickSearch : '';
        url +=(minPrice != '') ? "&minPrice="+minPrice : '';
        url +=(maxPrice != '') ? "&maxPrice="+maxPrice : '';
        url +=(minYear != '') ? "&minYear="+minYear : '';
        url +=(maxYear != '') ? "&maxYear="+maxYear : '';
            
         
        
        console.log(minPrice);
        console.log(maxPrice);
        console.log(minYear);
        console.log(maxYear);
        console.log(url);
        
        $.ajax({
            type: 'GET',
            url: url,
            success:function(vehiculeArray) {
                //TO DO: CLEAN THIS
                var vehiculesDiv = $('#searchedVehicules');
                vehiculesDiv.replaceWith('<div id="searchedVehicules"></div>');
                vehiculesDiv = $('#searchedVehicules');
                $.each(vehiculeArray, function(index, vehicule) {
                    var vehiculeInfo = '<p>';
                    vehiculeInfo += "<img src=\"/images/inventory-" + vehicule.vehiculeId  + "\"  width=\"200\" height=\"200\" onerror=\"this.src=\'/images/placeholder.jpg\';\">" + '<br>';  

                    vehiculeInfo += 'id: ' + vehicule.vehiculeId + '<br>';
                    vehiculeInfo += 'id: ' + vehicule.year + '<br>';
                    vehiculeInfo += 'id: ' + vehicule.carModel.name + '<br>';
                    vehiculeInfo += 'id: ' + vehicule.carModel.make.name + '<br>';
                    vehiculeInfo += 'id: ' + vehicule.type + '<br>';
                    vehiculeInfo += 'id: ' + vehicule.bodyStyle + '<br>';
                    vehiculeInfo += 'id: ' + vehicule.transmission + '<br>';
                    vehiculeInfo += 'id: ' + vehicule.exteriorColor + '<br>';
                    vehiculeInfo += 'id: ' + vehicule.interiorColor + '<br>';
                    vehiculeInfo += 'id: ' + vehicule.mileage + '<br>';
                    vehiculeInfo += 'id: ' + vehicule.vinnumber + '<br>';
                    vehiculeInfo += 'id: ' + vehicule.msrp + '<br>';
                    vehiculeInfo += 'id: ' + vehicule.salePrice + '<br>';
                    vehiculeInfo += 'id: ' + vehicule.description + '<br>';
                    vehiculeInfo += 'id: ' + vehicule.featured + '<br>';
                    vehiculeInfo += 'id: ' + vehicule.available + '<br>';
                    vehiculeInfo += '</p>';

                    vehiculeInfo += '<a href="/sales/purchase/'+vehicule.vehiculeId+'"><button class="btn btn-primary" id="vehicule-details-button">Purchase</button></a>';
                    vehiculeInfo += '<hr>';
            vehiculesDiv.append(vehiculeInfo);
            });
            },
            error: function(result) {
                alert('error');
            } 
        });
    });
});

