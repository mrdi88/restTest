var _votings;

$(window).load( function() {
    loadData()
});
    
function setList(votings) {
    _votings = votings;
    var table = document.getElementById("votings");
    //clean table
    for(var i = table.rows.length-1; i >= 0; i--){
        table.deleteRow(i);
    }
    var newrow;
    var cell;
    //set data in table
    for (var i = 0; i < votings.length; i++) { 
        newrow = table.insertRow(i);
        
        if (i%2>0) newrow.classList.add("even");
        else newrow.classList.add("odd");
        
        cell=newrow.insertCell(-1);
        cell.classList.add("topic");
        cell.innerHTML = '<a href="http://localhost:8080/v?id=' + votings[i].id + '">' + votings[i].tittle + "</a>";
        
        cell=newrow.insertCell(-1);
        cell.classList.add("state");
        cell.innerHTML = votings[i].state;
        
        cell=newrow.insertCell(-1);
        cell.innerHTML = '<a id ="' + i + '" href="#" onclick="setStart(this);">' + 'START' + '</a>';
        cell=newrow.insertCell(-1);
        
        cell=newrow.insertCell(-1);
        cell.innerHTML = '<a id ="' + i + '" href="#" onclick="setFinish(this);">' + 'FINISH' + '</a>';
        cell=newrow.insertCell(-1);
    }
}
function setStart(e) {
    
    _votings[e.id].state = "START";
    
    $.ajax({
            type     : "PUT",
            cache    : false,
            contentType: "application/json; charset=utf-8",
            url      : "http://localhost:8080/voting/",
            data     : JSON.stringify(_votings[e.id]),
            success  : function(data) {
                if (data){
                    //alert("OK");
                    loadData();
                }
                else{
                    alert("error");
                }
            }
        });
        
        

}
function setFinish(e) {
    
    _votings[e.id].state = "FINISHED";
    
    $.ajax({
            type     : "PUT",
            cache    : false,
            contentType: "application/json; charset=utf-8",
            url      : "http://localhost:8080/voting/",
            data     : JSON.stringify(_votings[e.id]),
            success  : function(data) {
                if (data){
                    //alert("OK");
                    loadData();
                }
                else{
                    //alert("error");
                }
            }
        });
}
function loadData() {
    $.ajax({
            type     : "GET",
            cache    : false,
            url      : "http://localhost:8080/voting/",
            data     : {},
            success  : function(data) {
                setList(data);
            }
        });
}