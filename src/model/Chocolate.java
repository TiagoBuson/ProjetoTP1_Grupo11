package model;

import java.time.LocalDate;

/**
 * Classe abstrata que representa um chocolate, pode virar uma Barra, uma Trufa ou um Chocotone.
 * @author Tiago
 * @version 1.0
 * @see Barra
 * @see Trufa
 * @see Chocotone
 */
public abstract class Chocolate {
  private int id;
  private int peso;
  private String nome;
  private String descricao;
  private String tipo;
  private LocalDate dataCompra;
  private double precoCompra;
  private double precoVenda;
  private double porcentagemCacau;
  private boolean contemGluten;
  private boolean contemLactose;
  private boolean artesanal;

  /**
   * Representa uma unidade de chocolate. <br>
   *
   * O id do chocolate é gerado automaticamente pelo método {@link Loja#getProximoIdChocolate()}
   *
   * @param id representa o id do chocolate.
   * @param peso representa o peso do chocolate.
   * @param nome representa o nome do chocolate.
   * @param descricao representa a descrição do chocolate.
   * @param tipo representa o tipo do chocolate.
   * @param dataCompra representa a data da compra do chocolate.
   * @param precoCompra representa o preço de compra do chocolate.
   * @param precoVenda representa o preço de venda do chocolate.
   * @param porcentagemCacau representa a porcentagem de cacau do chocolate.
   * @param contemGluten representa a opção de glutem do chocolate.
   * @param contemLactose representa a opção de lactose do chocolate.
   * @param artesanal representa a opção artesanal do chocolate.
   */
  protected Chocolate(int id, int peso, String nome, String descricao, String tipo,
                   LocalDate dataCompra, double precoCompra, double precoVenda,
                   double porcentagemCacau, boolean contemGluten, boolean contemLactose,
                   boolean artesanal) {
    this.id = id;
    this.peso = peso;
    this.nome = nome;
    this.descricao = descricao;
    this.tipo = tipo;
    this.dataCompra = dataCompra;
    this.precoCompra = precoCompra;
    this.precoVenda = precoVenda;
    this.porcentagemCacau = porcentagemCacau;
    this.contemGluten = contemGluten;
    this.contemLactose = contemLactose;
    this.artesanal = artesanal;
  }


  public String toString() {
    return String.format("%d - %s", id, nome);
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getPeso() {
    return peso;
  }

  public void setPeso(int peso) {
    this.peso = peso;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  public LocalDate getDataCompra() {
    return dataCompra;
  }

  public void setDataCompra(LocalDate dataCompra) {
    this.dataCompra = dataCompra;
  }

  public double getPrecoCompra() {
    return precoCompra;
  }

  public void setPrecoCompra(double precoCompra) {
    this.precoCompra = precoCompra;
  }

  public double getPrecoVenda() {
    return precoVenda;
  }

  public void setPrecoVenda(double precoVenda) {
    this.precoVenda = precoVenda;
  }

  public double getPorcentagemCacau() {
    return porcentagemCacau;
  }

  public void setPorcentagemCacau(double porcentagemCacau) {
    this.porcentagemCacau = porcentagemCacau;
  }

  public boolean isContemGluten() {
    return contemGluten;
  }

  public void setContemGluten(boolean contemGluten) {
    this.contemGluten = contemGluten;
  }

  public boolean isContemLactose() {
    return contemLactose;
  }

  public void setContemLactose(boolean contemLactose) {
    this.contemLactose = contemLactose;
  }

  public boolean isArtesanal() {
    return artesanal;
  }

  public void setArtesanal(boolean artesanal) {
    this.artesanal = artesanal;
  }
}