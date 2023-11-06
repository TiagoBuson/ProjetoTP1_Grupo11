package model;

import java.util.HashMap;
import java.util.Set;

/**
 * Classe que representa o estoque de chocolates e seus metodos.
 *
 * Os Chocolates são armazenados em um HashMap, sendo a chave o Chocolate em si e o valor a quantidade em estoque.
 * @see Chocolate
 * @see HashMap
 */
public class Estoque {
  private final HashMap<Chocolate, Integer> chocolates;

  /**
   * Constrói um novo estoque para armazenar os Chocolates em um HashMap.
   */
  public Estoque() {
    chocolates = new HashMap<>();
  }

  /**
   * Retira todos os produtos do estoque. Útil para testes.
   */
  public void clear() {
    chocolates.clear();
  }

  /**
   * Adiciona o chocolate no mapa de chocolates.
   * @param chocolate chocolate que será adicionado no mapa de chocolates.
   * @param quantidade quantidade desse chocolate que será adicionado.
   */
  public void adicionarChocolate(Chocolate chocolate, int quantidade) {
    chocolates.put(chocolate, chocolates.getOrDefault(chocolate, 0) + quantidade);
  }

  /**
   * Retira certa quantidade de chocolate do HashMap. <br>
   *
   * Esse método checa se a quantidade pode ser retirada, ou seja, checa se o Chocolate passado como parâmetro existe
   * no HashMap e se a quantidade a ser retirada é válida {@code 0 < quantidad <= quantidade em estoque}.
   *
   * @param chocolate chocolate que será retirado do mapa.
   * @param quantidade quantidade desse chocolate que será retirado.
   * @throws IllegalArgumentException quando o Chocolate não esta no estoque, ou a quantidade for 0, ou a quantidade
   * for maior do que em estoque.
   */
  public void retirarQuantidade(Chocolate chocolate, int quantidade) throws IllegalArgumentException {
    if (!chocolates.containsKey(chocolate)) {
      throw new IllegalArgumentException("Chocolate não está no estoque");
    }

    if (quantidade == 0) {
      throw new IllegalArgumentException("Quantidade não pode ser 0");
    }

    if (quantidade > chocolates.get(chocolate)) {
      throw new IllegalArgumentException(String.format("Quantidade %d maior do que em estoque " +
              "(%d)", quantidade, chocolates.get(chocolate)));
    }

    chocolates.put(chocolate, chocolates.get(chocolate) - quantidade);
  }

  /**
   * Pesquisa um chocolate por Id.
   * @param id inteiro id do chocolate.
   * @return chocolate do id requerido.
   */
  public Chocolate getChocolatePorId(int id) {
    for (Chocolate chocolate : getChocolates()) {
      if (chocolate.getId() == id) {
        return chocolate;
      }
    }

    return null;
  }

  public Set<Chocolate> getChocolates() {
    return chocolates.keySet();
  }

  /** Checa quantas unidade de um Chocolate estão em estoque.
   *
   * @param chocolate o Chocolate a ser consultado
   * @return a quantidade em estoque
   */
  public int getQuantidadeEmEstoque(Chocolate chocolate) {
    return chocolates.get(chocolate);
  }

  /**
   * Remove o chocolate do estoque.
   * @param chocolate chocolate que será removido.
   */
  public void removerChocolate(Chocolate chocolate) {
    chocolates.remove(chocolate);
  }

  /**
   * Altera a quantidade em estoque de certo chocolate.
   * @param chocolate chocolate a ser editado.
   * @param quantidade nova quantidade em estoque.
   */
  public void setQuantidade(Chocolate chocolate, int quantidade) {
    chocolates.put(chocolate, quantidade);
  }
}