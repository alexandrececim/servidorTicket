package dao;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
/** 
 * Classe responsavel por receber as requisiçoes 
 * do JSP e repassar para o servidor
 * 
 * @author Carlos Alexandre de Souza Cecim
*/
public class CallServer{
    /**
     * Metodo que recebe as mensagens em String da
     * pagina JSP abre um Socket cliente envia a 
     * mensagem captura a resposta e encerra o Socket.
     * @param msn (String)
     * @return espostaServidor (String)
     */
    public static String callServidor(String msn){
        String respostaServidor = null;
       try {
        Socket cliente = new Socket("localhost",12345);
         
        PrintStream saida = new PrintStream(cliente.getOutputStream());
        
        saida.println(msn);
             
        Scanner entrada = new Scanner(cliente.getInputStream());
        respostaServidor = entrada.nextLine();
        saida.close();
        cliente.close();
         
       }
       catch(Exception e) {
         System.out.println("Erro: " + e.getMessage());
       }
       return respostaServidor;
      }    

}