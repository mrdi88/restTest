var options;
var params;

$(window).load( function() {
    $("#voting").css("display","none");
    $("#results").css("display","none");
    
    var currentURL = document.URL;
    params = currentURL.extract();
    
    $.ajax({
            type     : "GET",
            cache    : false,
            url      : "http://localhost:8080/voting/"+params.id,
            data     : {},
            success  : function(data) {
                setVoting(data);
            }
        });
    
    $( "#voting" ).submit(function( event ) {
        event.preventDefault();
        var i = $( "#voting option:selected" ).val();
        
        console.log('Sending request to ' + 'http://localhost:8080/voting/' + params.id + ' with data: '+JSON.stringify(options[i]));
        
        $.ajax({
            type     : "PUT",
            cache    : false,
            contentType: "application/json; charset=utf-8",
            url      : "http://localhost:8080/voting/"+params.id,
            data     : JSON.stringify(options[i]),
            success  : function(data) {
                if (data){
                    //alert("got your voice");
                }
                else{
                    alert("error");
                }
            }
        });
    });
});
    
function setVoting(voting) {
    if (voting.state == "START") {
        $("#voting").css("display","block");
        $("#voting .topic").val(voting.tittle);
        options=voting.options;

        $.each(options, function (i, item) {
            $('#voting .options').append($('<option>', { 
                value: i,
                text : item.tittle 
            }));
        });
    }
    if (voting.state == "FINISHED" ) {
        $("#results").css("display","block");
        $("#results .topic").val(voting.tittle);
        options=voting.options;
        $('#results').append("<br>");
        $('#results').append("<p>results</p>");
        $.each(options, function (i, item) {
            $('#results').append("<input type='text' value='"+ item.tittle + " : " + item.voices +"' /><br>");
        });
    }
    
}