package controller;

import model.*;
import view.VendaDetails;
import view.VendasTab;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 * Classe controller da tab de vendas. Implementa ActionListeners e ListSelectionListeners à tab.
 * @author Tiago
 * @version 1.0
 */
public class VendasTabController implements ActionListener, ListSelectionListener {
  private final VendasTab vendasTab;

  /** Constrói um novo controller associado à aba de Vendas.
   * @param vendasTab aba de Vendas.
   */
  public VendasTabController(VendasTab vendasTab) {
    this.vendasTab = vendasTab;
  }

  /** Atualiza o painel de detalhes com os dados da Venda selecionada na lista.
   * @param e evento recebido da lista de Vendas.
   */
  @Override
  public void valueChanged(ListSelectionEvent e) {
    if (!e.getValueIsAdjusting()) {
      Venda venda = (Venda) vendasTab.getListaVendas().getLista().getSelectedValue();
      vendasTab.getDetails().popularDados(venda);
      vendasTab.getDetails().getSubmit().setEnabled(true);
    }
  }

  /** Atualiza os dados da Venda selecionada com base nos elementos do painel de detalhes.
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource().equals(vendasTab.getDetails().getSubmit())) {
      Venda venda = (Venda) vendasTab.getListaVendas().getLista().getSelectedValue();
      VendaDetails details = vendasTab.getDetails();

      venda.setCliente((Cliente) details.getCliente().getSelectedItem());
      venda.setFuncionario((Funcionario) details.getFuncionario().getSelectedItem());

      HashMap<Chocolate, Integer> vendidos = new HashMap<>();
      List<JSpinner> chocolatesSpinner = details.getListaQuantidades();
      List<JComboBox<Chocolate>> boxes = details.getListaChocolates();

      for (int i = 0; i < chocolatesSpinner.size(); i++) {
        vendidos.put(
            (Chocolate) boxes.get(i).getSelectedItem(), (int) chocolatesSpinner.get(i).getValue());
      }

      HashMap<Chocolate, Integer> vendidosAntes = venda.getChocolateVendidos();
      venda.setChocolateVendidos(vendidos);

      for (Chocolate chocolate : vendidos.keySet()) {
        if (vendidosAntes.containsKey(chocolate)) {
          if (!Objects.equals(vendidosAntes.get(chocolate), vendidos.get(chocolate))) {
            Loja.getInstance()
                .getEstoque()
                .retirarQuantidade(
                    chocolate, vendidos.get(chocolate) - vendidosAntes.get(chocolate));
          }

        } else {
          Loja.getInstance().getEstoque().retirarQuantidade(chocolate, vendidos.get(chocolate));
        }
      }

      venda.calcularValor();
      int index = vendasTab.getListaVendas().getLista().getSelectedIndex();
      vendasTab.getListaVendas().updateLista();
      vendasTab.getListaVendas().getLista().setSelectedIndex(index);

      vendasTab.resetListSelectionController();
      details.popularDados(venda);
    }
  }
}
