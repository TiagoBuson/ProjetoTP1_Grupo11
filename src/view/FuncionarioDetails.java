package view;

import model.Funcionario;
import model.Pessoa;

import javax.swing.*;
import java.text.ParseException;

/**
 * Classe de detalhes para o funcionario. Mostra todas as informações do funcionario selecionado.
 * Usa a classe DetailsPanel como template e extende a classe PessoaDetails.
 */
public class FuncionarioDetails extends PessoaDetails {

  private final JTextField salario;
  private final JTextField cargo;

  /**
   * Cria os JLabels e JTextFields dos detalhes dos funcionarios.
   */
  public FuncionarioDetails() throws ParseException {
    super("Detalhes do funcionário.");

    JLabel labelSalario = new JLabel("Salário");
    JLabel labelCargo = new JLabel("Cargo:");

    salario = new JTextField();
    salario.setToolTipText("Double.");
    cargo = new JTextField();

    getInnerDetailsPanel().add(labelSalario, getLeft());
    getInnerDetailsPanel().add(salario, getRight());
    getInnerDetailsPanel().add(labelCargo, getLeft());
    getInnerDetailsPanel().add(cargo, getRight());
  }

  /**
   * Popula os JTextFields do metodo FuncionarioDetails() com os detalhes do funcionario requerido.
   * @param pessoa objeto da Pessoa, com os dados do funcionario.
   */
  @Override
  public void popularDados(Pessoa pessoa) {
    Funcionario funcionario = (Funcionario) pessoa;
    super.popularDados(funcionario);
    salario.setEnabled(true);
    cargo.setEnabled(true);
    salario.setText(String.valueOf(funcionario.getSalario()));
    cargo.setText(funcionario.getCargo());
  }

  /**
   * Desabilita e remove o texto dos componentes. Usado quando não há nenhum funcionário cadastrado.
   */
  @Override
  public void popularDados() {
    super.popularDados();
    salario.setEnabled(false);
    cargo.setEnabled(false);

    salario.setText("");
    cargo.setText("");
  }

  /**
   * Getter do salario do funcionario.
   * @return JTextField com o salario do funcionario.
   */
  public JTextField getSalario() {
    return salario;
  }

  /**
   * Getter do JTextField com o cargo do funcionario.
   * @return JTextField com o cargo do funcionario.
   */
  public JTextField getCargo() {
    return cargo;
  }
}
