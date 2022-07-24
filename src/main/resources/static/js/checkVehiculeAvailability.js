$(document).ready(function(){
    /*<![CDATA[*/

    var available = $('#available').val();

    /*]]>*/
    if (available == "false"){
        console.log("replacing");
        var html = '<button type="button" name="unavailable-sold" class="btn btn-danger" disabled> Unavailable-Sold </button>';
        $('#contact-link').replaceWith(html);
    }
});



