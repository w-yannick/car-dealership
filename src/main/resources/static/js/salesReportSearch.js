$(document).ready(function(){
    var type = $("#type").html();
    $("#button_1").click(function(){
        var userId = $("#userId").val();
        var fromDate = $("#fromDate").val();
        var toDate = $("#toDate").val();
        
        var url = "http://localhost:8080/api/salesReport?";
        
//        String type,String quickSearch, Integer minPrice, Integer maxPrice, Integer minYear,Integer maxYear, Model model
        
        url +=(userId != "all") ? "userId="+userId+"&" : '';
        url +=(fromDate != '') ? "&fromDate="+fromDate : '';
        url +=(toDate != '') ? "&toDate="+toDate : '';
            
         
        
        console.log(userId);
        console.log(fromDate);
        console.log(toDate);
        console.log(url);
        
        $.ajax({
            type: 'GET',
            url: url,
            success:function(salesArray) {
                var tbody = $('#tbodyId');
                
                tbody.replaceWith('<tbody id="tbodyId"> </tbody>');
                tbody = $('#tbodyId');
                $.each(salesArray, function(index, sale) {
                    var saleInfo = '<tr>';
                    saleInfo += '<td>'+ sale.name+ '</td>';
                    saleInfo += '<td>'+ sale.totalSales+ '</td>';
                    saleInfo += '<td>'+ sale.totalVehicules+ '</td>';
////
                    saleInfo += '</tr>';
                    tbody.append(saleInfo);
                });
            },
            error: function(result) {
                alert('error');
            } 
        });
    });
});


