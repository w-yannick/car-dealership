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
        url +=(minPrice != '') ? "&minYear="+minPrice : '';
        url +=(maxPrice != '') ? "&maxYear="+maxPrice : '';
            
         
        
        console.log(minPrice);
        console.log(maxPrice);
        console.log(minYear);
        console.log(maxYear);
        console.log(url);
        
        $.ajax({
            type: 'GET',
            url: url,
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

