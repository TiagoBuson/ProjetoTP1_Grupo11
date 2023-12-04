package view;

import model.Cliente;
import model.Pessoa;

import javax.swing.*;
import java.text.ParseException;

/**
 * Classe de detalhes para o cliente. Mostra todas as informações do cliente selecionado.
 * Usa a classe DetailsPanel como template e extende a classe PessoaDetails.
 * @author Tiago
 * @version 1.0
 */
public class ClienteDetails extends PessoaDetails {
  private final JTextField categoria;

  /**
   * Cria os JLabels e os JTextFields dos detalhes dos clientes.
   */
  public ClienteDetails() throws ParseException {
    super("Detalhes do Cliente.");

    JLabel labelCategoria = new JLabel("Categoria:");
    categoria = new JTextField();

    getInnerDetailsPanel().add(labelCategoria, getLeft());
    getInnerDetailsPanel().add(categoria, getRight());
  }

  /**
   * Popula os JTextFields do metodo ClienteDetails() com os detalhes do cliente requerido.
   * @param pessoa objeto da Pessoa, com os dados do cliente.
   */
  @Override
  public void popularDados(Pessoa pessoa) {
    Cliente cliente = (Cliente) pessoa;
    super.popularDados(cliente);

    categoria.setEnabled(true);
    categoria.setText(cliente.getCategoria());
  }

  /**
   * Desabilita e retira o texto dos componentes. Usado quando não há nenhum cliente cadastrado.
   */
  @Override
  public void popularDados() {
    super.popularDados();
    categoria.setEnabled(false);
    categoria.setText("");
  }

  /**
   * Getter da categoria do cliente.
   * @return JTextField com a categoria do cliente.
   */
  public JTextField getCategoria() {
    return categoria;
  }

}
