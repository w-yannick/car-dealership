$(document).ready(function(){
    var type = $("#type").html();
    $("#button_1").click(function(){
        var quickSearch = $("#quick-search").val();
        var minPrice = $("#price-min").val();
        var maxPrice = $("#price-max").val();
        var minYear = $("#year-min").val();
        var maxYear = $("#year-max").val();
        var url = "http://localhost:8080/api/inventory";
        
        url += "?type=" + type;
//        String type,String quickSearch, Integer minPrice, Integer maxPrice, Integer minYear,Integer maxYear, Model model
        
        url +=(quickSearch != '') ? "&quickSearch="+quickSearch : '';
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
                vehiculesDiv.replaceWith('<div id="searchedVehicules" style="align-items: center;"></div>');
                vehiculesDiv = $('#searchedVehicules');
                $.each(vehiculeArray, function(index, vehicule) {

                    var vehiculeInfo = '<div class="row" style="align-items: center;">';  
                    vehiculeInfo += '<div class="col-2" style="max-width: 220px;">';  
                    vehiculeInfo += '<Strong>' + vehicule.year + ' ' + vehicule.carModel.make.name + ' ' + vehicule.carModel.name + '</Strong><br/>' ;
                    
                    vehiculeInfo += "<img src=\"/images/inventory-" + vehicule.vehiculeId  + "\"  width=\"200\" height=\"200\" onerror=\"this.src=\'/images/placeholder.jpg\';\">" + "<br>";  
                    vehiculeInfo += '</div>';
                    vehiculeInfo += '<div class="col-3" style="display: inline-block; text-align: left;">';  

                    vehiculeInfo += 'bodyStyle: ' + vehicule.bodyStyle + '<br>';
                    vehiculeInfo += 'Trans: ' + vehicule.transmission + '<br>';
                    vehiculeInfo += 'Color: ' + vehicule.exteriorColor + '<br>';
                    
                    vehiculeInfo += '</div>';
                    
                    vehiculeInfo += '<div class="col-sm-3">';  
                    vehiculeInfo += 'Interior: ' + vehicule.interiorColor + '<br>';
                    vehiculeInfo += 'Mileage: ' + vehicule.mileage + '<br>';
                    vehiculeInfo += 'VIN #: ' + vehicule.vinnumber + '<br>';
                    vehiculeInfo += '</div>';
                    
                    vehiculeInfo += '<div class="col-sm-3" style="text-align: right;">';
                    vehiculeInfo += 'SalePrice: ' + vehicule.salePrice + '<br>';
                    vehiculeInfo += 'MSRP: ' + vehicule.msrp + '<br>';
//                    vehiculeInfo += 'id: ' + vehicule.type + '<br>';
//                    vehiculeInfo += 'id: ' + vehicule.description + '<br>';
//                    vehiculeInfo += 'id: ' + vehicule.featured + '<br>';
//                    vehiculeInfo += 'id: ' + vehicule.available + '<br>';
                    vehiculeInfo += '<a href="/inventory/details/'+vehicule.vehiculeId+'"><button class="btn btn-primary" id="vehicule-details-button">Details</button></a>';
                    vehiculeInfo += '</div>';
                    
                    vehiculeInfo += '</div>';
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

