var specials;
var specialIndex = 0;

function changeText(){
    $('#jumbotron-text').html(specials[specialIndex].description);
    specialIndex =(specialIndex<( specials.length - 1))? ++specialIndex : 0;
};
setInterval(changeText, 3000);

const userAction = async () => {
    const response = await fetch('http://localhost:8080/api/specials');
    specials = await response.json(); //extract JSON from the http response     
    changeText();
}


userAction();
 

