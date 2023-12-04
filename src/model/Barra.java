package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Classe que representa uma unidade da Barra. <br>
 *
 * Essa classe nunca é instanciada diretamente. Para adicionar uma nova Barra, usamos
 * o método
 * {@link Loja#cadastrarBarra Loja.cadastrarBarra()}
 *
 * @author Tiago
 * @version 1.0
 */
public class Barra extends Chocolate {
  private final ArrayList<String> nibs = new ArrayList<>();
  private String sabor;

  /**
   * Representa uma unidade da Barra.
   * @param id representa o id da barra.
   * @param peso representa o peso da barra.
   * @param nome representa o nome da barra.
   * @param descricao representa a descrição da barra.
   * @param tipo representa o tipo da barra.
   * @param dataCompra representa a data da compra da barra.
   * @param precoCompra representa o preço de compra da barra.
   * @param precoVenda representa o preço de venda da barra.
   * @param porcentagemCacau representa a porcentagem de cacau da barra.
   * @param contemGluten representa a opção de glutem da barra.
   * @param contemLactose representa a opção de lactose da barra.
   * @param artesanal representa a opção artesanal da barra.
   * @param sabor representa o sabor da barra.
   * @param nibs representa os nibs da barra.
   */
  public Barra(int id, int peso, String nome, String descricao, String tipo, LocalDate dataCompra
          , double precoCompra, double precoVenda, double porcentagemCacau, boolean contemGluten,
               boolean contemLactose, boolean artesanal, String sabor, String[] nibs) {
    super(id, peso, nome, descricao, tipo, dataCompra, precoCompra, precoVenda, porcentagemCacau,
            contemGluten, contemLactose, artesanal);

    this.sabor = sabor;
    Collections.addAll(this.nibs, nibs);
  }

  public String getSabor() {
    return sabor;
  }

  public void setSabor(String sabor) {
    this.sabor = sabor;
  }

  public String getNibs() {
    return nibs.toString();
  }

  public void setNibs(String[] nibs) {
    this.nibs.clear();
    Collections.addAll(this.nibs, nibs);
  }
}