package model;

import java.time.LocalDate;

/**
 * Classe que representa uma unidade de Trufa. <br>
 * 
 * Essa classe nunca é instanciada diretamente. Para adicionar um novo chocolate, usamos o método
 * {@link model.Loja#cadastrarTrufa Loja.cadastrarTrufa()}
 */
public class Trufa extends Chocolate {
  private String recheio;
  private boolean alcoolico;

  /**
   * Representa uma unidade de Trufa.
   * @param id representa o id da trufa.
   * @param peso representa o peso da trufa.
   * @param nome representa o nome da trufa.
   * @param descricao representa a descrição da trufa.
   * @param tipo representa o tipo da trufa.
   * @param dataCompra representa a data da compra da trufa.
   * @param precoCompra representa o preço de venda da trufa.
   * @param precoVenda representa o preço de venda da trufa.
   * @param porcentagemCacau representa a porcentagem de cacau da trufa.
   * @param contemGluten representa a opção de glutem da trufa.
   * @param contemLactose representa a opção de lactose da trufa.
   * @param artesanal representa a opção artesanal da trufa.
   * @param recheio representa o recheio da trufa.
   * @param alcoolico representa a opção alcoolica da trufa.
   */
  public Trufa(int id, int peso, String nome, String descricao, String tipo, LocalDate dataCompra
          , double precoCompra, double precoVenda, double porcentagemCacau, boolean contemGluten,
               boolean contemLactose, boolean artesanal, String recheio, boolean alcoolico) {
    super(id, peso, nome, descricao, tipo, dataCompra, precoCompra, precoVenda, porcentagemCacau,
            contemGluten, contemLactose, artesanal);
    this.recheio = recheio;
    this.alcoolico = alcoolico;
  }

  public String getRecheio() {
    return recheio;
  }

  public void setRecheio(String recheio) {
    this.recheio = recheio;
  }

  public boolean isAlcoolico() {
    return alcoolico;
  }

  public void setAlcoolico(boolean alcoolico) {
    this.alcoolico = alcoolico;
  }
}