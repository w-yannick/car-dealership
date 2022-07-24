
$('#password').on('change', function(){
    console.log("passe val: " + $('#password').val() + " | confirmPass val: "+$('#confirmPassword').val())

    if($('#password').val() == $('#confirmPassword').val()){
        console.log("on normal pass equal")
        $('#save-button').prop("disabled", false);
        $('#password-error').slideUp();
    }
    else{
        console.log("on normal pass not equal")
        $('#password-error').slideDown();
        
        $('#save-button').prop("disabled", true);
    }
               
});
 
 $('#confirmPassword').on('change', function(){
        console.log("passe val: " + $('#password').val() + " | confirmPass val: "+$('#confirmPassword').val())
    if($('#password').val() == $('#confirmPassword').val()){
        console.log("on coinfirm pass equal")
        $('#save-button').prop("disabled", false);
        $('#password-error').slideUp();
    }
    else{
        console.log("on confirm change pass not equal")

        $('#password-error').slideDown();

        $('#save-button').prop("disabled", true);
    }
});