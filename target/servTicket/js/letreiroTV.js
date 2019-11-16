$(document).ready(function(){

    setInterval(() => mensagemAjax("chamado") , 3000);
   
      document.onkeyup=function(e){

        if(e.which == 17){
          window.location.href = "../control/gerente.jsp";
          return false;
        }

        if(e.which == 18){
          window.location.href = "../control/recepcao.jsp";
       return false;
     }
     
     }
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

