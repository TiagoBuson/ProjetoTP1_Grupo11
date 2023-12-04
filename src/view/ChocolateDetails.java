package view;

import model.*;

import javax.swing.*;
import java.awt.*;

/**
 * Classe de detalhes para o Chocolate. Mostra todas as informações do Chocolate selecionado. Usa a classe
 * {@link DetailsPanel} como template.
 * @author Tiago
 * @version 1.0
 */
public class ChocolateDetails extends DetailsPanel {

  /**
   * Constante que representa a {@link Barra}. Usado no método {@link #popularDados}, já que é necessário saber
   * qual o tipo de Chocolate sendo representado(Barra, Trufa ou Chocotone) para mostrar os campos correspondentes às
   * suas propriedades específicas.
   */
  public static final int BARRA = 0;
  /**
   * Constante que representa o {@link Chocotone}. Usado no método {@link #popularDados},
   * já que é necessário saber qual o tipo
   * de Chocolate sendo representado(Barra, Trufa ou Chocotone) para mostrar os campos correspondentes às suas
   * propriedades específicas.
   */
  public static final int CHOCOTONE = 1;
  /**
   * Constante que representa a {@link Trufa}. Usado no método {@link #popularDados}, já que é necessário saber
   * qual o tipo
   * de Chocolate sendo representado(Barra, Trufa ou Chocotone) para mostrar os campos correspondentes às suas
   * propriedades específicas.
   */
  public static final int TRUFA = 2;

  private final JTextField id;
  private final JTextField peso;
  private final JTextField nome;
  private final JTextField descricao;
  private final JTextField tipo;
  private final JTextField precoCompra;
  private final JTextField precoVenda;
  private final JTextField porcentagemCacau;
  private final JTextField dataCompra;
  private final JCheckBox contemGluten;
  private final JCheckBox contemLactose;
  private final JCheckBox artesanal;

  private final JTextField sabor;
  private final JTextField nibs;
  private final JTextField recheio;
  private final JTextField frutas;
  private final JCheckBox alcoolico;

  private final JLabel saborLabel;
  private final JLabel recheioLabel;
  private final JLabel nibsLabel;
  private final JLabel frutasLabel;
  private final JLabel alcoolicoLabel;

  private final JSpinner quantidade;
  private final JLabel quantidadeLabel;

  /**
   * Cria e adiciona os JLabels, e os JTextFields com setToolTipText do tipo de variavel aceito.
   */
  public ChocolateDetails() {
    super("Detalhes do chocolate");


    id = new JTextField();
    id.setEnabled(false);

    peso = new JTextField();
    peso.setToolTipText("Inteiro.");
    nome = new JTextField();
    descricao = new JTextField();
    tipo = new JTextField();
    precoCompra = new JTextField();
    precoCompra.setToolTipText("Double.");
    precoVenda = new JTextField();
    precoVenda.setToolTipText("Double.");
    porcentagemCacau = new JTextField();

    dataCompra = new JTextField();
    dataCompra.setEnabled(false);

    sabor = new JTextField();
    nibs = new JTextField();
    nibs.setToolTipText("No formato [nibs1, nibs2, nibs3, ...]");
    recheio = new JTextField();
    frutas = new JTextField();
    frutas.setToolTipText("No formato [fruta1, fruta2, fruta3, ...]");

    contemGluten = new JCheckBox();
    contemLactose = new JCheckBox();
    artesanal = new JCheckBox();

    alcoolico = new JCheckBox();

    GridBagConstraints left = getLeft();
    GridBagConstraints right = getRight();

    getInnerDetailsPanel().add(new JLabel("Id:"), left);
    getInnerDetailsPanel().add(id, right);
    getInnerDetailsPanel().add(new JLabel("Peso:"), left);
    getInnerDetailsPanel().add(peso, right);
    getInnerDetailsPanel().add(new JLabel("Nome:"), left);
    getInnerDetailsPanel().add(nome, right);
    getInnerDetailsPanel().add(new JLabel("Descrição:"), left);
    getInnerDetailsPanel().add(descricao, right);
    getInnerDetailsPanel().add(new JLabel("Tipo:"), left);
    getInnerDetailsPanel().add(tipo, right);
    getInnerDetailsPanel().add(new JLabel("Preço de Compra:"), left);
    getInnerDetailsPanel().add(precoCompra, right);
    getInnerDetailsPanel().add(new JLabel("Preço de Venda:"), left);
    getInnerDetailsPanel().add(precoVenda, right);
    getInnerDetailsPanel().add(new JLabel("Porcentagem de Cacau:"), left);
    getInnerDetailsPanel().add(porcentagemCacau, right);
    getInnerDetailsPanel().add(new JLabel("Data da compra:"), left);
    getInnerDetailsPanel().add(dataCompra, right);

    saborLabel = new JLabel("Sabor:");
    nibsLabel = new JLabel("Nibs:");
    recheioLabel = new JLabel("Recheio:");
    frutasLabel = new JLabel("Frutas:");
    alcoolicoLabel = new JLabel("Alcoólico");

    getInnerDetailsPanel().add(saborLabel, left);
    getInnerDetailsPanel().add(sabor, right);
    getInnerDetailsPanel().add(nibsLabel, left);
    getInnerDetailsPanel().add(nibs, right);
    getInnerDetailsPanel().add(recheioLabel, left);
    getInnerDetailsPanel().add(recheio, right);
    getInnerDetailsPanel().add(frutasLabel, left);
    getInnerDetailsPanel().add(frutas, right);
    getInnerDetailsPanel().add(alcoolicoLabel, left);
    getInnerDetailsPanel().add(alcoolico, right);

    getInnerDetailsPanel().add(new JLabel("Contém Gluten:"), left);
    getInnerDetailsPanel().add(contemGluten, right);
    getInnerDetailsPanel().add(new JLabel("Contém Lactose:"), left);
    getInnerDetailsPanel().add(contemLactose, right);
    getInnerDetailsPanel().add(new JLabel("Artesanal:"), left);
    getInnerDetailsPanel().add(artesanal, right);

    quantidade = new JSpinner();
    quantidadeLabel = new JLabel("Quantidade: ");

    getInnerDetailsPanel().add(quantidadeLabel, left);
    getInnerDetailsPanel().add(quantidade, right);

    setAllInvisible();
  }

  /**
   * Deixa todos os Labels e TextFields que não são comuns à todos os tipos de chocolate invisiveis.
   */
  private void setAllInvisible() {
    recheioLabel.setVisible(false);
    recheio.setVisible(false);
    frutasLabel.setVisible(false);
    frutas.setVisible(false);
    alcoolicoLabel.setVisible(false);
    alcoolico.setVisible(false);
    sabor.setVisible(false);
    saborLabel.setVisible(false);
    nibsLabel.setVisible(false);
    nibs.setVisible(false);
  }

  private void setAllEditable(boolean bool) {
    peso.setEnabled(bool);
    nome.setEnabled(bool);
    descricao.setEnabled(bool);
    precoCompra.setEnabled(bool);
    precoVenda.setEnabled(bool);
    quantidade.setEnabled(bool);
    contemGluten.setEnabled(bool);
    contemLactose.setEnabled(bool);
    artesanal.setEnabled(bool);
  }

  /**
   * Popula os JTextFields do metodo {@link ChocolateDetails()} com os detalhes do Chocolate.
   * @param selection inteiro que seleciona o tipo de chocolate.
   * @param chocolate objeto Chocolate.
   */
  public void popularDados(int selection, Chocolate chocolate) {
    id.setText(String.valueOf(chocolate.getId()));
    peso.setText(String.valueOf(chocolate.getPeso()));
    nome.setText(chocolate.getNome());
    descricao.setText(chocolate.getDescricao());
    tipo.setText(chocolate.getTipo());
    precoCompra.setText(String.valueOf(chocolate.getPrecoCompra()));
    precoVenda.setText(String.valueOf(chocolate.getPrecoVenda()));
    porcentagemCacau.setText(String.valueOf(chocolate.getPorcentagemCacau()));
    dataCompra.setText(chocolate.getDataCompra().toString());

    contemGluten.setSelected(chocolate.isContemGluten());
    contemLactose.setSelected(chocolate.isContemLactose());
    artesanal.setSelected(chocolate.isArtesanal());

    setAllInvisible();
    setAllEditable(true);

    switch (selection) {
      case BARRA -> {
        showBarra();

        Barra barra = (Barra) chocolate;
        sabor.setText(barra.getSabor());
        nibs.setText(String.join(",", barra.getNibs()));
      }
      case CHOCOTONE -> {
        showChocotone();

        Chocotone chocotone = (Chocotone) chocolate;
        recheio.setText(chocotone.getRecheio());
        frutas.setText(String.join(",", chocotone.getFrutas()));
      }
      case TRUFA -> {
        showTrufa();

        Trufa trufa = (Trufa) chocolate;
        recheio.setText(trufa.getRecheio());
        alcoolico.setSelected(trufa.isAlcoolico());
      }
    }

    int quantidadeAtual = Loja.getInstance().getEstoque().getQuantidadeEmEstoque(chocolate);
    quantidade.setModel(new SpinnerNumberModel(
            quantidadeAtual,
            quantidadeAtual,
            null,
            1
    ));
  }

  /**
   * Desativa todos os componentes. Usado quando não há Chocolates cadastrados.
   */
  public void popularDados() {
    setAllInvisible();
    setAllEditable(false);
  }

  /**
   * Deixa os elementos da Barra visiveis.
   */
  public void showBarra() {
    setAllInvisible();
    saborLabel.setVisible(true);
    sabor.setVisible(true);
    nibsLabel.setVisible(true);
    nibs.setVisible(true);
  }

  /**
   * Deixa os elementos do Chocotone visiveis.
   */
  public void showChocotone() {
    setAllInvisible();
    frutasLabel.setVisible(true);
    frutas.setVisible(true);
    recheioLabel.setVisible(true);
    recheio.setVisible(true);
  }

  /**
   * Deixa os elementos da Trufa visiveis.
   */
  public void showTrufa() {
    setAllInvisible();
    recheioLabel.setVisible(true);
    recheio.setVisible(true);
    alcoolicoLabel.setVisible(true);
    alcoolico.setVisible(true);
  }

  public JSpinner getQuantidade() {
    return quantidade;
  }

  public JLabel getQuantidadeLabel() {
    return quantidadeLabel;
  }

  /**
   * Getter do id do Chocolate.
   * @return JTextfield do id do Chocolate.
   */
  public JTextField getId() {
    return id;
  }

  /**
   * Getter do peso do Chocolate.
   * @return JTextfield do peso do Chocolate.
   */
  public JTextField getPeso() {
    return peso;
  }

  /**
   * Getter do nome do Chocolate.
   * @return JTextfield do nome do Chocolate.
   */
  public JTextField getNome() {
    return nome;
  }

  /**
   * Getter da descrição do Chocolate.
   * @return JTextfield da descrição do Chocolate.
   */
  public JTextField getDescricao() {
    return descricao;
  }

  /**
   * Getter do tipo do Chocolate.
   * @return JTextfield do tipo do Chocolate.
   */
  public JTextField getTipo() {
    return tipo;
  }

  /**
   * Getter do preço de compra do Chocolate.
   * @return JTextfield do preço de compra do Chocolate.
   */
  public JTextField getPrecoCompra() {
    return precoCompra;
  }

  /**
   * Getter do preço de venda do Chocolate.
   * @return JTextfield do preço de venda do Chocolate.
   */
  public JTextField getPrecoVenda() {
    return precoVenda;
  }

  /**
   * Getter da porcentagem de cacau do Chocolate.
   * @return JTextfield da porcentagem de cacau do Chocolate.
   */
  public JTextField getPorcentagemCacau() {
    return porcentagemCacau;
  }

  /**
   * Getter da opção de glutem do Chocolate.
   * @return JCheckBox da opção de glutem do Chocolate.
   */
  public JCheckBox getContemGluten() {
    return contemGluten;
  }

  /**
   * Getter da opção de lactose do Chocolate.
   * @return JCheckBox da opção de lactose do Chocolate.
   */
  public JCheckBox getContemLactose() {
    return contemLactose;
  }

  /**
   * Getter da opção artesanal do Chocolate.
   * @return JCheckBox da opção artesanal do Chocolate.
   */
  public JCheckBox getArtesanal() {
    return artesanal;
  }

  /**
   * Getter do sabor do Chocolate.
   * @return JTextfield do sabor do Chocolate.
   */
  public JTextField getSabor() {
    return sabor;
  }

  /**
   * Getter do(s) nib(s) do Chocolate.
   * @return JTextfield do(s) nib(s) do Chocolate.
   */
  public JTextField getNibs() {
    return nibs;
  }

  /**
   * Getter do recheio do Chocolate.
   * @return JTextfield do recheio do Chocolate.
   */
  public JTextField getRecheio() {
    return recheio;
  }

  /**
   * Getter das frutas do Chocolate.
   * @return JTextfield das frutas do Chocolate.
   */
  public JTextField getFrutas() {
    return frutas;
  }

  /**
   * Getter da opção alcoolica do Chocolate.
   * @return JCheckBox da opção alcoolica do Chocolate.
   */
  public JCheckBox getAlcoolico() {
    return alcoolico;
  }

  /**
   * Getter da data de compra do Chocolate.
   * @return JTextfield da data de compra do Chocolate.
   */
  public JTextField getDataCompra() {
    return dataCompra;
  }
}
