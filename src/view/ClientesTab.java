package view;

import controller.ClientesTabController;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionListener;
import java.text.ParseException;

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
  public ClientesTab() throws ParseException {
    setLayout(new BorderLayout(0, 0));

    listaClientes = new ListaPanel(ListaPanel.CLIENTE);
    add(listaClientes, BorderLayout.LINE_START);

    details = new ClienteDetails();
    add(details, BorderLayout.CENTER);

    ClientesTabController controller = new ClientesTabController(this);

    listaClientes.getLista().addListSelectionListener(controller);
    details.getSubmit().addActionListener(controller);
    listaClientes.getLista().setSelectedIndex(0);
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

    ClientesTabController controller = new ClientesTabController(this);

    details.getSubmit().addActionListener(controller);
    listaClientes.getLista().addListSelectionListener(controller);
  }
}
