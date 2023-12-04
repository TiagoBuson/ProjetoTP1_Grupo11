package model;

import java.time.LocalDate;
import java.util.HashMap;

/**
 * Classe que representa uma venda. <br>
 *
 * Essa classe armazena todas as informações de uma venda: Cliente, Funcionário, Chocolates vendidos, data e valor.
 * O id da venda é gerado automaticamente.
 * @author Tiago e Marina
 * @version 1.0
 */
public class Venda {
  private final int id;
  private final LocalDate data;
  private double valor;
  private Cliente cliente;
  private Funcionario funcionario;
  private HashMap<Chocolate, Integer> chocolateVendidos;

  /** Constrói uma nova Venda. A classe nunca é instanciada diretamente, sempre pelo método {@link Loja#fazerVenda},
   * ja que ele trata de remover a quantidade vendida do {@link Estoque}.
   *
   * @param id representa o id da venda.
   * @param cliente representa o cliente que fez a venda.
   * @param funcionario representa o funcionario que fez a venda.
   * @param data representa a data da venda.
   */
  public Venda(int id, Cliente cliente, Funcionario funcionario, LocalDate data) {
    this.id = id;
    this.cliente = cliente;
    this.funcionario = funcionario;
    this.data = data;
    chocolateVendidos = new HashMap<>();
  }

  /**
   * Constrói a representação em string de uma venda. A representação em string é usada para mostrar o cliene e o id
   * da venda na lista de vendas.
   * @return String do id e do nome.
   */
  @Override
  public String toString() {
    return String.format("%d - %s", this.id, this.cliente.getNome());
  }

  /**
   * Adiciona um chocolate na venda. Se o chocolate já estiver na venda, adicionamos a quantidade passada como
   * argumento. Caso contrário, a quantidade passada é o total daquele chocolate.
   *
   * @param chocolate chocolate que será adicionado.
   * @param quantidade quantidade de chocolates que serão adicionados.
   */
  public void adicionarChocolate(Chocolate chocolate, int quantidade) {
    chocolateVendidos.put(chocolate, chocolateVendidos.getOrDefault(chocolate, 0) + quantidade);
  }

  /**
   * Calcula o valor da venda. Esse método é usado toda vez que a venda é atualizada, já que o valor pode mudar com
   * alterações de chocolates e quantidades.
   */
  public void calcularValor() {
    double valorVenda = 0;

    for (Chocolate chocolate : chocolateVendidos.keySet()) {
      valorVenda += chocolate.getPrecoVenda() * chocolateVendidos.get(chocolate);
    }

    switch (cliente.getCategoria()) {
      case "Silver" -> valorVenda = valorVenda * 0.9;
      case "Gold" -> valorVenda = valorVenda * 0.85;
      case "Platinum" -> valorVenda = valorVenda * 0.75;
      default -> {
      }
    }

    valor = valorVenda;
  }

  public double getValor() {
    return valor;
  }

  public int getId() {
    return id;
  }

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  public Funcionario getFuncionario() {
    return funcionario;
  }

  public void setFuncionario(Funcionario funcionario) {
    this.funcionario = funcionario;
  }

  public LocalDate getData() {
    return data;
  }

  public HashMap<Chocolate, Integer> getChocolateVendidos() {
    return chocolateVendidos;
  }

  public void setChocolateVendidos(HashMap<Chocolate, Integer> vendidos) {
      chocolateVendidos = vendidos;
  }
}
