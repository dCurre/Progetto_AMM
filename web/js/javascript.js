function createElement(utente){

    var img = $("<img>")
            .attr("alt","Foto Profilo")
            .attr("src",utente.urlFotoProfilo);
    
    var link = $("<a>")
            .attr("href", "Bacheca?utenteBacheca="+utente.id)
            .html(img)
            .append(" " + utente.nome + " " + utente.cognome);
    
    return $("<div>")
            .attr("class","persona")
            .append(link);
}

function stateSuccess(data){
    var userListPage = $("#userList");
    
    $(userListPage).empty();
    var i=0;
    for(var instance in data){
        $(userListPage).append(createElement(data[instance]));
        i++;
    }
        if(i === 0)
            alert("Utente non trovato");
        
        
        alert("Risultati: " + i);
}

function stateFailure(data, state){
    console.log(state);
}

$(document).ready(function(){
    $("#searchButton").click(function(){
        
        var wantedUser = $("#searchInput")[0].value;
        
        $.ajax({
            url: "Filter",
            data:{
                cmd:"search",
                nomeUtenteCercato: wantedUser
            },
            dataType:"json",
            success: function(data, state){
                stateSuccess(data);
            },
            error: function(data, state){
                stateFailure(data, state);
            }
        });
    });
});