import java.util.ArrayList;

/**
 * Classe para gerar Objeto Ticket Está ainda é uma versão de teste, onde os
 * metodos get() e set() de vada variavel está publica para uso do Teste
 * Unitário.
 * 
 * @version 1.0
 * @author Carlos Alexandre de Souza Cecim
 */
public class Ticket {

  private String ticketNormal;
  private String ticketPreferencial;
  private int statusAtendimento;
  private int ticketChamado;

  public String getTicketNormal() {
    return ticketNormal;
  }

  private void setTicketNormal(String newTicket) {
    ticketNormal = newTicket;
  }

  public String getTicketPreferencial() {
    return ticketNormal;
  }

  private void setTicketPreferencial(String newTicket) {
    ticketNormal = newTicket;
  }

  public int getStatusAtendimento() {
    return statusAtendimento;
  }

  private void setStatusAtendimento(int x) {
    statusAtendimento = x;
  }

  public int getTicketChamado() {
    return ticketChamado;
  }

  public void setTicketChamado(int x) {
    ticketChamado = x;
  }

  /**
   * Metodo que adiciona o ticket na fila Normal gerar uma senha(ticket) no
   * formato 'NXXXX' para usuario normal (Onde cada 'X' é um digito numérico).
   */
  public void addFilaNormal(ArrayList<Ticket> fila) {
    Ticket ticket = new Ticket();
    int totalFila = fila.size() + 1;// Adicionado evitando o 'N0000'
    String str = String.format("%04d", totalFila);
    ticket.setTicketNormal("N" + str);
    ticket.setStatusAtendimento(0);
    ticket.setTicketChamado(0);
    fila.add(ticket);
  }

  /**
   * Metodo que adiciona o ticket na fila Preferencial gerar uma senha(ticket) no
   * formato 'PXXXX' para usuario Preferencial (Onde cada 'X' é um digito
   * numérico).
   */
  public void addFilaPreferencial(ArrayList<Ticket> fila) {
    Ticket ticket = new Ticket();
    int totalFila = fila.size() + 1;// Adicionado evitando $
    String str = String.format("%04d", totalFila);
    ticket.setTicketPreferencial("P" + str);
    ticket.setStatusAtendimento(0);
    ticket.setTicketChamado(0);
    fila.add(ticket);
  }

  /**
   * Esse metodo é onde se aplica a regra de negocio: O sistema terá que atender
   * somente uma senha de usuario normal depois que todos os usuarios
   * Preferenciais estiverem sido atendidos.
   */
  public void atendeFila(ArrayList<Ticket> fila, ArrayList<String> emAtendimento) {
    int tamanhoFila = fila.size();
    int contaFila = 0;
    int regraPreferencial = 0;
    // for(int i = 0; xt > i; i++){
    do {
      int status = fila.get(contaFila).getStatusAtendimento();
      String tipoTicket = fila.get(contaFila).getTicketPreferencial().substring(0, 1);
      if (status == 0 && tipoTicket.equals("P")) {
        fila.get(contaFila).setStatusAtendimento(1);
        fila.get(contaFila).setTicketChamado(1);
        // contabiliza o atendimento
        emAtendimento.add(fila.get(contaFila).getTicketPreferencial());
        regraPreferencial = 1;
        break;
      }
      contaFila++;
    } while (tamanhoFila > contaFila);
    if (regraPreferencial == 0) {

      for (int i = 0; tamanhoFila > i; i++) {
        int status = fila.get(i).getStatusAtendimento();
        String tipoTicket = fila.get(i).getTicketNormal().substring(0, 1);
        if (status == 0 && tipoTicket.equals("N")) {
          fila.get(i).setStatusAtendimento(1);
          fila.get(i).setTicketChamado(1);
          // contabiliza o atendimento
          emAtendimento.add(fila.get(i).getTicketPreferencial());
          break;
        }
      }
    }

  }

}
