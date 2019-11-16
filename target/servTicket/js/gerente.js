$(document).ready(function(){

    $("#bt_resetarFila").click(function(){
      
      mensagemAjax("Limpar");
        
    });

    $("#bt_chamarFila").click(function(){
       
       mensagemAjax("Atender");
       

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
