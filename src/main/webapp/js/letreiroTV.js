$(document).ready(function(){
    setInterval(() => monitotarndoChamada(), 3000);
   
      document.onkeyup=function(e){

        if(e.which == 17){
               //Pressionou CTRL, aqui vai a função para esta tecla.
               alert("Ba !");
               window.location.href = "../control/gerente.jsp";
          return false;
        }

        if(e.which == 18){
            //Pressionou ALT, aqui vai a função para esta tecla.
            alert("##############!");
            window.location.href = "../control/recepcao.jsp";

       return false;
     }
     
     }
});

function monitotarndoChamada(){
    $.get("../model/callMsn.jsp?msnCliente=chamado", function(retornoDoServidor){
        $("#lb_atendimentoFila").html(retornoDoServidor);
    });
}

