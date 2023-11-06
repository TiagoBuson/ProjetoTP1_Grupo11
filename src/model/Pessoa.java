package model;

/**
 * Classe abstrata que representa uma pessoa, é a classe base de {@link model.Cliente} e {@link model.Funcionario}.
 * @author Tiago
 * @version 1.0
 */
public abstract class Pessoa {
  private int id;
  private int idade;
  private String nome;
  private String cpf;
  private String telefone;
  private String email;
  private Endereco endereco;

  /**
   * Representa uma pessoa.
   * @param id representa o id da pessoa.
   * @param idade representa a idade da pessoa.
   * @param nome representa o nome da pessoa.
   * @param cpf representa o cpf da pessoa.
   * @param telefone representa o telefone da pessoa.
   * @param email representa o email da pessoa.
   * @param endereco representa o endereço da pessoa.
   */
  protected Pessoa(int id, int idade, String nome, String cpf, String telefone, String email,
                Endereco endereco) {
    this.id = id;
    this.idade = idade;
    this.nome = nome;
    this.cpf = cpf;
    this.telefone = telefone;
    this.email = email;
    this.endereco = endereco;
  }

  /**
   * Faz a representação em string do Objeto. <br>
   *
   * Como estamos usando {@link javax.swing.JList}, o texto padrão que aparece nessas lista é a representação em
   * string do objeto. Assim, podemos controlar como ele aparece na lista fazendo Override no método {@code toString()}.
   * @return representação em string do objeto.
   */
  @Override
  public String toString() {
    return String.format("%d - %s", id, nome);
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getIdade() {
    return idade;
  }

  public void setIdade(int idade) {
    this.idade = idade;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getTelefone() {
    return telefone;
  }

  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Endereco getEndereco() {
    return endereco;
  }

  public void setEndereco(Endereco endereco) {
    this.endereco = endereco;
  }
}