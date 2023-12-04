package view;

import controller.VendasTabController;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Aba de vendas. Contém a representação da lista de vendas cadastradas, além de mostrar os detalhes de um venda
 * específica no painel central.
 */
public class VendasTab extends JPanel {
  private final ListaPanel listaVendas;
  private final VendaDetails details;

  /**
   * Cria o painel da lista de vendas, usando o template da classe ListaPanel.
   */
  public VendasTab() {
    setLayout(new BorderLayout(0, 0));

    listaVendas = new ListaPanel(ListaPanel.VENDA);
    add(listaVendas, BorderLayout.LINE_START);

    details = new VendaDetails();
    add(details, BorderLayout.CENTER);

    VendasTabController controller = new VendasTabController(this);

    details.getSubmit().addActionListener(controller);
    listaVendas.getLista().addListSelectionListener(controller);
    listaVendas.getLista().setSelectedIndex(0);
  }

  /**
   * Reseta o controller de seleção da lista, para aplicar as mudanças feitas.
   */
  public void resetListSelectionController() {
    for (ListSelectionListener l : listaVendas.getLista().getListSelectionListeners()) {
      listaVendas.getLista().removeListSelectionListener(l);
    }

    for (ActionListener l : details.getSubmit().getActionListeners()) {
      details.getSubmit().removeActionListener(l);
    }

    VendasTabController controller = new VendasTabController(this);
    details.getSubmit().addActionListener(controller);
    listaVendas.getLista().addListSelectionListener(controller);
  }

  /**
   * Getter da lista de vendas
   * @return Painel da lista de vendas.
   */
  public ListaPanel getListaVendas() {
    return listaVendas;
  }

  /**
   * Getter dos detalhes da venda.
   * @return detalhes da venda.
   */
  public VendaDetails getDetails() {
    return details;
  }
}
