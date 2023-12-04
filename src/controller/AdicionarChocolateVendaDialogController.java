package controller;

import main.Main;
import model.Chocolate;
import model.Loja;
import model.Venda;
import view.AdicionarChocolateVendaDialog;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Set;

/**
 * Classe controller para o dialog de adicionar um Chocolate novo a uma venda já criada.
 * @author Tiago
 * @version 1.0
 */
public class AdicionarChocolateVendaDialogController implements ActionListener {
  private final AdicionarChocolateVendaDialog view;

  /** Constrói um controller associado ao dialog de adicionar um Chocolate em uma Venda existente.
   *
   * O construtor popula o ComboBox no dialog com as opções de Chocolate disponíveis.
   * @param view dialogo de adicionar Chocolate em uma Venda.
   */
  public AdicionarChocolateVendaDialogController(AdicionarChocolateVendaDialog view) {
    this.view = view;
    Set<Chocolate> chocolatesVenda =
        ((Venda) Main.getFrame().getVendasTab().getListaVendas().getLista().getSelectedValue())
            .getChocolateVendidos()
            .keySet();

    ArrayList<Chocolate> chocolates = new ArrayList<>();

    for (Chocolate chocolate : Loja.getInstance().getEstoque().getChocolates()) {
      if (!chocolatesVenda.contains(chocolate) && Loja.getInstance().getEstoque().getQuantidadeEmEstoque(chocolate) > 0) {
        chocolates.add(chocolate);
      }
    }

    view.getChocolate().setModel(new DefaultComboBoxModel<>(chocolates.toArray(new Chocolate[0])));
  }

  /**
   * Cadastra um novo chocolate à venda selecionada.
   * @param e evento recebido.
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == view.getSubmit()) {
      Venda venda = (Venda) Main.getFrame().getVendasTab().getListaVendas().getLista().getSelectedValue();
      Chocolate chocolate = (Chocolate) view.getChocolate().getSelectedItem();
      venda.adicionarChocolate(chocolate, 1);
      Loja.getInstance().getEstoque().retirarQuantidade(chocolate, 1);
      Main.getFrame().getVendasTab().getDetails().popularDados(venda);
      view.dispose();
    }
  }
}
