package view;

import main.Main;
import model.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Classe de detalhes para a venda. Mostra todas as informações da venda selecionada. Usa a classe DetailsPanel como template.
 * @author Tiago
 * @version 1.0
 */
public class VendaDetails extends DetailsPanel {
  private final JTextField id;
  private final JTextField valor;
  private final JTextField data;
  private final JComboBox<Cliente> cliente;
  private final JComboBox<Funcionario> funcionario;
  private final ArrayList<JComboBox<Chocolate>> listaChocolates;
  private final ArrayList<JSpinner> listaQuantidades;
  private final JButton adicionarNovoChocolate;


  /**
   * Cria os JLabels e os JTextFields dos detalhes das vendas.
   */
  public VendaDetails() {
    super("Detalhes da venda:");

    adicionarNovoChocolate = new JButton("Adicionar novo chocolate:");
    add(adicionarNovoChocolate, BorderLayout.BEFORE_FIRST_LINE);
    adicionarNovoChocolate.addActionListener(e -> new AdicionarChocolateVendaDialog(Main.getFrame()));

    listaChocolates = new ArrayList<>();
    listaQuantidades = new ArrayList<>();

    GridBagConstraints left = super.getLeft();
    GridBagConstraints right = super.getRight();

    id = new JTextField();
    id.setEditable(false);
    valor = new JTextField();
    valor.setEditable(false);
    data = new JTextField();
    data.setEditable(false);

    cliente = new JComboBox<>();
    funcionario = new JComboBox<>();


    getInnerDetailsPanel().add(new JLabel("Id:"), left);
    getInnerDetailsPanel().add(id, right);
    getInnerDetailsPanel().add(new JLabel("Valor:"), left);
    getInnerDetailsPanel().add(valor, right);
    getInnerDetailsPanel().add(new JLabel("Data:"), left);
    getInnerDetailsPanel().add(data, right);
    getInnerDetailsPanel().add(new JLabel("Cliente:"), left);
    getInnerDetailsPanel().add(cliente, right);
    getInnerDetailsPanel().add(new JLabel("Funcionário:"), left);
    getInnerDetailsPanel().add(funcionario, right);


    popularDados(Loja.getInstance().getVendaPorId(1));
  }

  /**
   * Desabilita os inputs do painel de detalhes. Usado quando não existem mais vendas na lista de vendas.
   */
  public void popularDados() {
    for (JComboBox<Chocolate> label : listaChocolates) {
      getInnerDetailsPanel().remove(label);
    }
    for (JSpinner spinner : listaQuantidades) {
      getInnerDetailsPanel().remove(spinner);
    }
    listaChocolates.clear();
    listaQuantidades.clear();

    adicionarNovoChocolate.setEnabled(false);

    getInnerDetailsPanel().validate();
    getInnerDetailsPanel().repaint();

    Loja loja = Loja.getInstance();
    cliente.setModel(new DefaultComboBoxModel<>(loja.getClientes()));
    funcionario.setModel(new DefaultComboBoxModel<>(loja.getFuncionarios()));
    cliente.setEnabled(false);
    funcionario.setEnabled(false);

    id.setText("");
    valor.setText("");
    data.setText("");
  }

  /**
   * Popula os JTextFields do metodo VendaDetails() com os detalhes da venda requerida.
   * @param venda objeto da Venda.
   */
  public void popularDados(Venda venda) {
    // Retirando as boxes e spinners antigos
    for (JComboBox<Chocolate> label : listaChocolates) {
      getInnerDetailsPanel().remove(label);
    }
    for (JSpinner spinner : listaQuantidades) {
      getInnerDetailsPanel().remove(spinner);
    }
    listaChocolates.clear();
    listaQuantidades.clear();

    // Atualizando a tela.
    getInnerDetailsPanel().validate();
    getInnerDetailsPanel().repaint();

    Loja loja = Loja.getInstance();
    cliente.setModel(new DefaultComboBoxModel<>(loja.getClientes()));
    cliente.setSelectedItem(venda.getCliente());
    cliente.setEnabled(true);

    funcionario.setModel(new DefaultComboBoxModel<>(loja.getFuncionarios()));
    funcionario.setSelectedItem(venda.getFuncionario());
    funcionario.setEnabled(true);

    adicionarNovoChocolate.setEnabled(true);

    id.setText(String.valueOf(venda.getId()));
    valor.setText(String.valueOf(venda.getValor()));
    data.setText(venda.getData().toString());

    // Adicionando os Chocolates
    for (Map.Entry<Chocolate, Integer> entry : venda.getChocolateVendidos().entrySet()) {
      Chocolate chocolate = entry.getKey();
      int quantidade = entry.getValue();

      int maxQuantidade = Loja.getInstance().getEstoque().getQuantidadeEmEstoque(chocolate);


      listaQuantidades.add(new JSpinner(new SpinnerNumberModel(quantidade, quantidade,
              quantidade + maxQuantidade, 1)));

      DefaultComboBoxModel<Chocolate> model =
              new DefaultComboBoxModel<>(loja.getEstoque().getChocolates().toArray(new Chocolate[0]));

      JComboBox<Chocolate> opcoes = new JComboBox<>(model);
      opcoes.setSelectedItem(chocolate);

      listaChocolates.add(opcoes);
    }

    for (int i = 0; i < listaQuantidades.size(); i++) {
      getInnerDetailsPanel().add(listaChocolates.get(i), getLeft());
      getInnerDetailsPanel().add(listaQuantidades.get(i), getRight());
    }
  }

  /**
   * Getter do id da venda.
   * @return JTextField do id da venda.
   */
  public JTextField getId() {
    return id;
  }

  /**
   * Getter do cliente que fez a venda.
   * @return JComboBox do cliente que fez a venda.
   */
  public JComboBox<Cliente> getCliente() {
    return cliente;
  }

  /**
   * Getter do funcionario que fez a venda.
   * @return JComboBox do funcionario que fez a venda.
   */
  public JComboBox<Funcionario> getFuncionario() {
    return funcionario;
  }

  /**
   * Getter da lista de chocolates.
   * @return Lista de JComboBox de chocolates.
   */
  public List<JComboBox<Chocolate>> getListaChocolates() {
    return listaChocolates;
  }

  /**
   * Getter da lista de quantidades de chocolate da venda.
   * @return Lista de JSpinner das quantidades de chocolate.
   */
  public List<JSpinner> getListaQuantidades() {
    return listaQuantidades;
  }
}
