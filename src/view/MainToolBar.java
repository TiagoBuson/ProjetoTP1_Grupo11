package view;

import javax.swing.*;
import java.awt.event.ActionListener;

/** ToolBar principal do programa.
 *
 * Possui botões de adicionar Cliente, Funcionario, Chocolate e Venda, alem do botão de remover e a barra de texto de
 * pesquisa.
 * @author Tiago
 * @version 1.0
 */
public class MainToolBar extends JToolBar {
  private final JButton adicionarCliente;
  private final JButton adicionarChocolate;
  private final JButton adicionarFuncionario;
  private final JButton adicionarVenda;
  private final JButton remover;

  private final JTextField pesquisar;

  /**
   * Cria e adiciona todos os botões necessarios e seus ActionListeners.
   */
  public MainToolBar() {
    adicionarCliente = new JButton("Adicionar Cliente");
    adicionarChocolate = new JButton("Adicionar Chocolate");
    adicionarFuncionario = new JButton("Adicionar Funcinario");
    adicionarVenda = new JButton("Adicionar Venda");

    remover = new JButton("Remover");

    JLabel pesquisaLabel = new JLabel("Pesquisar:");
    pesquisar = new JTextField();

    add(adicionarCliente);
    add(adicionarFuncionario);
    add(adicionarChocolate);
    add(adicionarVenda);
    add(remover);
    add(pesquisaLabel);
    add(pesquisar);

    pesquisaLabel.setToolTipText("Digite e aperte ENTER para pesquisar. Limpe a caixa de pesquisa" +
            " e aperte ENTER para limpar o filtro.");

    setFloatable(false);
  }

  /**
   * Getter do botão de adicionar cliente.
   * @return JButton de adicionar cliente.
   */
  public JButton getAdicionarCliente() {
    return adicionarCliente;
  }

  /**
   * Getter do botão de adicionar Chocolate.
   * @return JButton de adicionar Chocolate.
   */
  public JButton getAdicionarChocolate() {
    return adicionarChocolate;
  }

  /**
   * Getter do botão de adicionar funcionario.
   * @return JButton de adicionar funcionario.
   */
  public JButton getAdicionarFuncionario() {
    return adicionarFuncionario;
  }

  /**
   * Getter do botão de adicionar venda.
   * @return JButton de adicionar venda.
   */
  public JButton getAdicionarVenda() {
    return adicionarVenda;
  }

  /**
   * Getter do botão de remover elemento de uma lista.
   * @return JButton de remover elemento.
   */
  public JButton getRemover() {
    return remover;
  }

  /**
   * Getter do text field do sistema de pesquisa.
   * @return JTextField do sistema de pesquisa.
   */
  public JTextField getPesquisar() {return pesquisar;}
}
