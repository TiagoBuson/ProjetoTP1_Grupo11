package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Classe que representa uma unidade de Chocotone. <br>
 * 
 * Essa classe nunca é instanciada diretamente. Para adicionar um novo chocotone, usamos o método
 *
 * {@link model.Loja#cadastrarChocotone Loja.cadastrarTrufa()}
 *
 * @author Tiago
 * @version 1.0
 */
public class Chocotone extends Chocolate {
  private final ArrayList<String> frutas = new ArrayList<>();
  private String recheio;

  /**
   * Cria um novo Chocotone.
   * @param id representa o id do Chocotone. Gerado automaticamente.
   * @param peso representa o peso do Chocotone.
   * @param nome representa o nome do Chocotone.
   * @param descricao representa a descrição do Chocotone.
   * @param tipo representa o tipo do Chocotone.
   * @param dataCompra representa a data da compra do Chocotone.
   * @param precoCompra representa o preço de venda do Chocotone.
   * @param precoVenda representa o preço de venda do Chocotone.
   * @param porcentagemCacau representa a porcentagem de cacau do Chocotone.
   * @param contemGluten representa a opção de glutem do Chocotone.
   * @param contemLactose representa a opção de lactose do Chocotone.
   * @param artesanal representa a opção artesanal do Chocotone.
   * @param recheio representa o recheio do Chocotone
   * @param frutas representa as frutas do Chocotone
   */
  public Chocotone(int id, int peso, String nome, String descricao, String tipo,
                   LocalDate dataCompra, double precoCompra, double precoVenda,
                   double porcentagemCacau, boolean contemGluten, boolean contemLactose,
                   boolean artesanal, String recheio, String[] frutas) {
    super(id, peso, nome, descricao, tipo, dataCompra, precoCompra, precoVenda, porcentagemCacau,
            contemGluten, contemLactose, artesanal);

    this.recheio = recheio;
    Collections.addAll(this.frutas, frutas);
  }

  public String getRecheio() {
    return recheio;
  }

  public void setRecheio(String recheio) {
    this.recheio = recheio;
  }

  public String getFrutas() {
    return frutas.toString();
  }


  public void setFrutas(String[] frutas) {
    this.frutas.clear();
    Collections.addAll(this.frutas, frutas);
  }
}