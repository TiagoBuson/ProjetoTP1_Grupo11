package controller;

import model.*;
import view.ChocolateDetails;
import view.ChocolatesTab;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Classe controller da tab de Chocolates. Implementa ActionListeners e ListSelectionListeners à tab.
 * @author Tiago
 * @version 1.0
 */
public class ChocolatesTabController implements ListSelectionListener, ActionListener {
  private final ChocolatesTab chocolatesTab;

  /** Constrói um novo controller associado à aba de Chocolates.
   * @param chocolatesTab aba de chocolates
   */
  public ChocolatesTabController(ChocolatesTab chocolatesTab) {
    this.chocolatesTab = chocolatesTab;
  }

  /** Atualiza o painel de detalhes para corresponder com os dados do Chocolate selecionado na lista
   * @param e evento recebido da lista de Chocolates.
   */
  @Override
  public void valueChanged(ListSelectionEvent e) {
    if (!e.getValueIsAdjusting()) {
      Chocolate chocolate =
              (Chocolate) chocolatesTab.getListaChocolates().getLista().getSelectedValue();
      if (chocolate instanceof Barra) {
        chocolatesTab.getDetails().popularDados(ChocolateDetails.BARRA, chocolate);
      } else if (chocolate instanceof Chocotone) {
        chocolatesTab.getDetails().popularDados(ChocolateDetails.CHOCOTONE, chocolate);
      } else if (chocolate instanceof Trufa) {
        chocolatesTab.getDetails().popularDados(ChocolateDetails.TRUFA, chocolate);
      }
      chocolatesTab.getDetails().getSubmit().setEnabled(true);
    }
  }

  /** Altera os dados do Chocolate selecionado com base nos elementos do painel de detalhes.
   * @param e evento recebido.
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource().equals(chocolatesTab.getDetails().getSubmit())) {
      Chocolate chocolate =
              (Chocolate) chocolatesTab.getListaChocolates().getLista().getSelectedValue();

      int peso;
      double precoVenda;
      double precoCompra;
      double porcentagemCacau;
      ChocolateDetails details = chocolatesTab.getDetails();

      try {
        peso = Integer.parseInt(details.getPeso().getText());
        precoCompra = Double.parseDouble(details.getPrecoCompra().getText());
        precoVenda = Double.parseDouble(details.getPrecoVenda().getText());
        porcentagemCacau = Double.parseDouble(details.getPorcentagemCacau().getText());
      } catch (NumberFormatException ignored) {
        peso = 0;
        precoCompra = 0;
        precoVenda = 0;
        porcentagemCacau = 0;
      }

      chocolate.setPeso(peso);
      chocolate.setNome(details.getNome().getText());
      chocolate.setDescricao(details.getDescricao().getText());
      chocolate.setTipo(details.getTipo().getText());
      chocolate.setPrecoCompra(precoCompra);
      chocolate.setPrecoVenda(precoVenda);
      chocolate.setPorcentagemCacau(porcentagemCacau);
      chocolate.setContemGluten(details.getContemGluten().isSelected());
      chocolate.setContemLactose(details.getContemLactose().isSelected());
      chocolate.setArtesanal(details.getArtesanal().isSelected());

      Loja.getInstance().getEstoque().setQuantidade(chocolate, (int) details.getQuantidade().getValue());

      if (chocolate instanceof Barra barra) {
        barra.setSabor(details.getSabor().getText());

        String nibsStr = details.getNibs().getText();
        nibsStr = nibsStr.substring(1, nibsStr.length() - 1);
        String[] nibs = nibsStr.split("\\s*,\\s*");
        barra.setNibs(nibs);
      } else if (chocolate instanceof Chocotone chocotone) {
        chocotone.setRecheio(details.getRecheio().getText());

        String frutasStr = details.getFrutas().getText();
        frutasStr = frutasStr.substring(1, frutasStr.length() - 1);
        String[] frutas = frutasStr.split("\\s*,\\s*");
        chocotone.setFrutas(frutas);
      } else if (chocolate instanceof Trufa trufa) {
        trufa.setRecheio(details.getRecheio().getText());
        trufa.setAlcoolico(details.getAlcoolico().isSelected());
      }

    }
  }
}
