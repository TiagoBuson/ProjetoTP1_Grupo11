package view;

import controller.ChocolatesTabController;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Aba de Chocolates. Contém a representação da lista de Chocolates cadastrados, além de mostrar os detalhes do
 * Chocolate selecionado no painel central.
 */
public class ChocolatesTab extends JPanel {
  private final ListaPanel listaChocolates;

  private final ChocolateDetails details;

  /**
   * Cria o painel da lista de chocolates, usando o template da classe ListaPanel.
   */
  public ChocolatesTab() {
    setLayout(new BorderLayout());

    listaChocolates = new ListaPanel(ListaPanel.CHOCOLATE);
    add(listaChocolates, BorderLayout.LINE_START);

    details = new ChocolateDetails();
    add(details, BorderLayout.CENTER);

    ChocolatesTabController controller = new ChocolatesTabController(this);

    listaChocolates.getLista().addListSelectionListener(controller);
    details.getSubmit().addActionListener(controller);

    listaChocolates.getLista().setSelectedIndex(0);
  }

  /**
   * Getter da lista de chocolates.
   * @return painel da lista de chocolates.
   */
  public ListaPanel getListaChocolates() {
    return listaChocolates;
  }

  /**
   * Getter dos detalhes do chocolate.
   * @return detalhes do chocolate.
   */
  public ChocolateDetails getDetails() {
    return details;
  }

  /**
   * Reseta o controller de seleção da lista, para aplicar as mudanças feitas.
   */
  public void resetListSelectionController() {
    for (ListSelectionListener l : listaChocolates.getLista().getListSelectionListeners()) {
      listaChocolates.getLista().removeListSelectionListener(l);
    }

    for (ActionListener l : details.getSubmit().getActionListeners()) {
      details.getSubmit().removeActionListener(l);
    }

    ChocolatesTabController controller = new ChocolatesTabController(this);

    listaChocolates.getLista().addListSelectionListener(controller);
    details.getSubmit().addActionListener(controller);
  }
}
