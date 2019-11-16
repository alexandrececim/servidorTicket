$(document).ready(function(){

    $("#bt_normalFila").click(function(){

        mensagemAjax("Normal");
               
    });

    $("#bt_preferencialFila").click(function(){

        mensagemAjax("Preferencial");
       
    });

   
}); 

function mensagemAjax(msn){
    
    $.get("../model/callMsn.jsp?msnCliente="+msn, function(retornoDoServidor){
        $("#lb_atendimentoFila").html(retornoDoServidor);
    });
    setTimeout(function(){
        $.get("../model/callMsn.jsp?msnCliente="+msn, function(retornoDoServidor){
            $("#lb_atendimentoFila").html(retornoDoServidor);
        });
    }, 3000);
}