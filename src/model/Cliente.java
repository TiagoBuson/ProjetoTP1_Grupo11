package model;

/**
 * Classe que representa um cliente. <br>
 * 
 * Para adicionar um Cliente, use o método {@link Loja#cadastrarCliente Loja.cadastrarCLiente()}
 * 
 * @author Tiago
 * @version 1.0
 */
public class Cliente extends Pessoa {
  private String categoria;

  /**
   * Representa um cliente.
   * @param id representa o id do cliente. Gerado automaticamente.
   * @param idade representa a idade do cliente.
   * @param nome representa o nome do cliente.
   * @param cpf representa o cpf do cliente.
   * @param telefone representa o telefone do cliente.
   * @param email representa o email do cliente.
   * @param endereco representa o endereço do cliente.
   * @param categoria representa a categoria do cliente.
   */
  public Cliente(int id, int idade, String nome, String cpf, String telefone, String email,
                 Endereco endereco, String categoria) {
    super(id, idade, nome, cpf, telefone, email, endereco);
    this.categoria = categoria;
  }

  public String getCategoria() {
    return categoria;
  }

  public void setCategoria(String categoria) {
    this.categoria = categoria;
  }
}
