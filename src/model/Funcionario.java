package model;

/**
 * Classe que representa um funcionario. <br>
 *
 * Essa classe nunca é instanciada diretamente. Para adicionar um Funcionário, usamos o método
 * {@link model.Loja#cadastrarFuncionario Loja.cadastrarFuncionário()}.
 *
 * @author Tiago
 * @version 1.0
 */
public class Funcionario extends Pessoa {
  private double salario;
  private String cargo;

  /**
   * Representa um funcionario.
   * @param id representa o id do funcionario. Gerado automaticamente.
   * @param idade representa a idade do funcionario.
   * @param nome representa o nome do funcionario.
   * @param cpf representa o cpf do funcionario.
   * @param telefone representa o telefone do funcionario.
   * @param email representa o email do funcionario.
   * @param endereco representa o endereço do funcionario.
   * @param salario representa o salario do funcionario.
   * @param cargo representa o cargo do funcionario.
   */
  public Funcionario(int id, int idade, String nome, String cpf, String telefone, String email,
                     Endereco endereco, double salario, String cargo) {
    super(id, idade, nome, cpf, telefone, email, endereco);
    this.salario = salario;
    this.cargo = cargo;
  }

  public double getSalario() {
    return salario;
  }

  public void setSalario(double salario) {
    this.salario = salario;
  }

  public String getCargo() {
    return cargo;
  }

  public void setCargo(String cargo) {
    this.cargo = cargo;
  }
}
