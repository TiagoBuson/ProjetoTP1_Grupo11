package view;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Aba de Clientes. Contém a representação da lista de Clientes cadastrados, além de mostrar os detalhes do Cliente
 * selecionado no painel central.
 *
 * @author Tiago
 * @version 1.0
 */
public class ClientesTab extends JPanel {
  private final ListaPanel listaClientes;

  private final ClienteDetails details;

  /**
   * Cria o painel da lista de clientes, usando o template da classe ListaPanel.
   */
  public ClientesTab() {
    setLayout(new BorderLayout(0, 0));

    listaClientes = new ListaPanel(ListaPanel.CLIENTE);
    add(listaClientes, BorderLayout.LINE_START);

    details = new ClienteDetails();
    add(details, BorderLayout.CENTER);
  }

  /**
   * Getter da lista de clientes.
   * @return painel da lista de clientes.
   */
  public ListaPanel getListaClientes() {
    return listaClientes;
  }

  /**
   * Getter dos detalhes do cliente.
   * @return detalhes do cliente.
   */
  public ClienteDetails getDetails() {
    return details;
  }

  /**
   * Reseta o controller de seleção da lista, para aplicar as mudanças feitas.
   */
  public void resetListSelectionController() {
    for (ListSelectionListener l : listaClientes.getLista().getListSelectionListeners()) {
      listaClientes.getLista().removeListSelectionListener(l);
    }

    for (ActionListener l : details.getSubmit().getActionListeners()) {
      details.getSubmit().removeActionListener(l);
    }
  }
}
