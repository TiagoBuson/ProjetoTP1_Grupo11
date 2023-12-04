package model;

/**
 * Representa um endereço. <br>
 *
 * Essa classe é usada na classe {@link Pessoa}.
 * @author Tiago
 * @version 1.0
 */
public class Endereco {
  private String bairro;
  private String rua;
  private String numero;
  private String cep;

  /**
   * @param bairro representa o bairro do endereço da pessoa.
   * @param rua representa a rua do endereço da pessoa.
   * @param numero representa o numero do endereço da pessoa.
   * @param cep representa o cep do endereço da pessoa.
   */
  public Endereco(String bairro, String rua, String numero, String cep) {
    this.bairro = bairro;
    this.rua = rua;
    this.numero = numero;
    this.cep = cep;
  }

  public String getBairro() {
    return bairro;
  }

  public void setBairro(String bairro) {
    this.bairro = bairro;
  }

  public String getRua() {
    return rua;
  }

  public void setRua(String rua) {
    this.rua = rua;
  }

  public String getNumero() {
    return numero;
  }

  public void setNumero(String numero) {
    this.numero = numero;
  }

  public String getCep() {
    return cep;
  }

  public void setCep(String cep) {
    this.cep = cep;
  }
}
