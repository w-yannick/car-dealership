var specials;
var specialIndex = 0;
var elem = $("#jumbotron-text");
function changeText(){
    $('#jumbotron-text').fadeOut(function(){
        $('#jumbotron-text').html(specials[specialIndex].description);
        specialIndex =(specialIndex<( specials.length - 1))? ++specialIndex : 0;
        $('#jumbotron-text').fadeIn();
    })
};
setInterval(changeText, 3000);

const userAction = async () => {
    const response = await fetch('http://localhost:8080/api/specials');
    specials = await response.json(); //extract JSON from the http response     
    changeText();
}


userAction();
 

