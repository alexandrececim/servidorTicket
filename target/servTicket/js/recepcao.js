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
        evitarDuploClick();
        
    });
}

function evitarDuploClick(){
    $("#bt_normalFila").attr('disabled','disabled');
    $("#bt_preferencialFila").attr('disabled','disabled');
    setTimeout(function(){ 
        $(lb_atendimentoFila).html("xxxxx"); 
        $("#bt_normalFila").removeAttr('disabled');
        $("#bt_preferencialFila").removeAttr('disabled');
    },5000);
}

