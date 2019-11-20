$(document).ready(function(){

    setInterval(() => mensagemAjax("chamado") , 3000);

    $("#bt_resetarFila").click(function(){
      
      mensagemAjax("Limpar");
      $(lb_atendimentoFila).html("xxxxx"); 
    });

    $("#bt_chamarFila").click(function(){
       
       mensagemAjax("Atender");
       evitarDuploClick();

    });

   

}); 

function mensagemAjax(msn){
    
    $.get("../model/callMsn.jsp?msnCliente="+msn, function(retornoDoServidor){
        $("#lb_atendimentoFila").html(retornoDoServidor);
    });
    
}

function evitarDuploClick(){
    $("#bt_chamarFila").attr('disabled','disabled');
    setTimeout(function(){ 
        $("#bt_chamarFila").removeAttr('disabled');
    },3000);
}
