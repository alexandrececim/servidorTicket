import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

@WebServlet("/ServidorMsn")
public class ServidorMsn extends HttpServlet implements ServletContextListener {
  
  private static final long serialVersionUID = 1L;
  private static String consultaChamada = "";
  
  private static void operando(int porta, ArrayList<Ticket> fila, ArrayList<String> foiChamado) {

    try {
      // Instancia o ServerSocket ouvindo a porta 12345
      ServerSocket servidor = new ServerSocket(porta);
      while (true) {

        Socket cliente = servidor.accept();
        System.out.println("Cliente conectado: " + cliente.getInetAddress().getHostAddress());
        Scanner entrada = new Scanner(cliente.getInputStream());
        String msnCliente = entrada.nextLine();
        System.out.println("Msn: " + msnCliente);

        protocoloMsn(msnCliente, fila, foiChamado);

        // resposta
        if (consultaChamada.isEmpty()) {
          PrintStream saida = new PrintStream(cliente.getOutputStream());

          saida.println("Servidor respondendo !");

          if (msnCliente.equals("-")) {
            cliente.close();
            entrada.close();
            servidor.close();
          }

        } else {
          PrintStream saida = new PrintStream(cliente.getOutputStream());

          saida.println(consultaChamada);
        }
        cliente.close();
        entrada.close();

      }
    } catch (Exception e) {
      System.out.println("Erro - ao iniciar: " + e.getMessage());
    }
  }

  /*
   * Metodo que le a mensagem e compara a permisão e o tipo gtk - cabeçalho de
   * Permição de conexão tipo - Comando para: 
   * 1) c1 - Zera a lista de Atendimento(renicia a contagem dos ticket's). 
   * 2) c2 - Cria um ticket normal.
   * 3) c3 - Cria um ticket preferencial. 
   * 4) c4 - Altera status de atendimento
   * (chamada para proximo ticket). 
   * 5) c5 - Retorna o ticket em atendimento.
   */
  private static void protocoloMsn(String msn, ArrayList<Ticket> fila, ArrayList<String> foiChamado) {
    System.out.println("Chegou na leitura do protocolo.");
    Ticket ticket = new Ticket();
    String[] protocoloMsn = msn.split("-");

    String msnHead = protocoloMsn[0];
    String msnParm = protocoloMsn[1];

    System.out.println("Protocolo[0] = " + msnHead);
    System.out.println("Protocolo[1] = " + msnParm);

    if (msnHead.equals("gtk")) {

      if (msnParm.equals("c1")) {
        fila.clear();
        foiChamado.clear();
      }

      if (msnParm.equals("c2")) {

        ticket.addFilaNormal(fila);
        consultaChamada = fila.get(fila.size() -1).getTicketNormal();
      }

      if (msnParm.equals("c3")) {

        ticket.addFilaPreferencial(fila);
        consultaChamada = fila.get(fila.size() -1).getTicketPreferencial();
      }

      if (msnParm.equals("c4")) {
        ticket.atendeFila(fila, foiChamado);

      }

      if (msnParm.equals("c5")) {
        String callTicket = emAtendimento(foiChamado);
        consultaChamada = callTicket;

      }
     

    } else {
      System.out.println("Conexão não autorizada");
    }

  }

  // Metodo que mostra o ticket chamado da lista de atendimento
  private static String emAtendimento(ArrayList<String> foiChamado) {
    int xt = foiChamado.size() - 1;
    String chamandoDaFila;
    if (xt > -1) {
      chamandoDaFila = foiChamado.get(xt);
    } else {
      chamandoDaFila = "Atendimento não inicializado";
    }
    return chamandoDaFila;

  }

  public class Thredando implements Runnable {
    ArrayList<Ticket> fila = new ArrayList<Ticket>();
    ArrayList<String> foiChamado = new ArrayList<String>();
    String msn = "";

    public Thredando(String msn) {
      this.msn = msn;
    }

    public void run() {
      int ct = 0;
      try {
        while (true) {

          operando(12345, fila, foiChamado);

          if (msn.equals("-"))
            break;
        }

      } catch (Exception ex) {
        System.out.println(ex);
      }

    }
  }

  @Override
  public void contextInitialized(ServletContextEvent sce) {
    try {

      Thredando t = new Thredando("teste");
      Thread th = new Thread(t);
      th.start();
      

    } catch (Exception e) {
      System.out.println("### Erro: " + e);
    }

  }

  @Override
  public void contextDestroyed(ServletContextEvent sce) {
    // TODO Auto-generated method stub

  }
}
