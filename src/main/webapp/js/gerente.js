$(document).ready(function(){

    $("#bt_resetarFila").click(function(){

        $.get("../model/callMsn.jsp?msnCliente=Limpar", function(retornoDoServidor){
        $("#lb_atendimentoFila").html(retornoDoServidor);

        });
        setTimeout(function(){
            $.get("../model/callMsn.jsp?msnCliente=chamado", function(retornoDoServidor){
            $("#lb_atendimentoFila").html(retornoDoServidor);
            });
        }, 3000);
    });

    $("#bt_chamarFila").click(function(){

        $.get("../model/callMsn.jsp?msnCliente=Atender", function(retornoDoServidor){
        $("#lb_atendimentoFila").html(retornoDoServidor);
            
        });
    

    });

   

}); 

