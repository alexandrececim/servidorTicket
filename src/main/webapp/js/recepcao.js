$(document).ready(function(){

    $("#bt_normalFila").click(function(){

        $.get("../model/callMsn.jsp?msnCliente=Normal", function(retornoDoServidor){
        $("#lb_atendimentoFila").html(retornoDoServidor);

        });
        
    });

    $("#bt_preferencialFila").click(function(){

        $.get("../model/callMsn.jsp?msnCliente=Preferencial", function(retornoDoServidor){
        $("#lb_atendimentoFila").html(retornoDoServidor);

        });
    });

   

   

}); 