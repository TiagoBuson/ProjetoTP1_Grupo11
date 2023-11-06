package main;

/*
* TP1 - Grupo 11
*
* Marina Silva Lyra - 222001313
*
* Samuel dos Santos - 222011605
*
* Tiago Leão Buson - 200034162
*
*
*
*/

import model.*;
import view.MainFrame;

import java.time.LocalDate;
import java.util.HashMap;

/**
 * Classe de entry-point do programa.
 */
public class Main {
  private static MainFrame frame;

  /**
   * Função principal do programa: carrega os valores iniciais na loja e inicia a interface.
   * @param args argumentos da linha de comando -- não utilizados.
   */
  public static void main(String[] args) {

    carregarInicial();

    frame = new MainFrame("Loja de Chocolates");
  }

  /**
   * Carrega os dados iniciais no programa.
   */
  public static void carregarInicial() {
    Loja loja = Loja.getInstance();
    loja.cadastrarCliente(loja.getProximoIdCliente(), 19, "Tiago", "000.000.000-00",
            "99999" + "-9999", "email@email.com", new Endereco("Asa Norte", "SQN", "307",
                    "00000" + "-00"), "diamante");
    loja.cadastrarCliente(loja.getProximoIdCliente(), 25, "Marcelo", "000.000.000-00", "99999" +
            "-9999", "email@email.com", new Endereco("Asa Sul", "SQS", "102", "00001-00"),
            "bronze");

    // Cadastro dos funcionários iniciais:
    loja.cadastrarFuncionario(loja.getProximoIdFuncionario(), 23, "Antonio", "000.000.000-00",
            "99999-9999", "email@email.com", new Endereco("Sudoeste", "SQNW", "302", "00002-00"),
            1000.00, "Caixa");
    loja.cadastrarFuncionario(loja.getProximoIdFuncionario(), 34, "Ana", "000.000.000-00", "99999"
            + "-9999", "email@email.com", new Endereco("Sudoeste", "SQNW", "302", "00002-00"),
            30000.00, "Gerente");

    // Cadastro dos chocolates iniciais:
    loja.cadastrarBarra(loja.getProximoIdChocolate(), 250, "Barra Incrível", "Uma incrível barra "
            + "de chocolate", "Meio-Amargo", LocalDate.of(2021, 9, 10), 10.0, 20.0, 70.0, true,
            true, true, "Chocolate", new String[]{"Amendoim", "Nozes"}, 25);
    loja.cadastrarBarra(loja.getProximoIdChocolate(), 250, "Barra Sensacional", "Barra " +
            "sensacional de chocolate", "Ao Leite", LocalDate.of(2021, 5, 10), 12.0, 33.2, 25.0,
            true, true, false, "Menta", new String[]{"Castanha"}, 30);

    loja.cadastrarChocotone(loja.getProximoIdChocolate(), 500, "Chocotone Delicioso",
            "O melhor " + "chocotone", "Gourmet", LocalDate.of(2021, 9, 10), 8.0, 20.0, 10, true,
            true, false, "Doce de leite", new String[]{"Morango"}, 20);

    loja.cadastrarTrufa(loja.getProximoIdChocolate(), 20, "Trufa Trufada", "Trufa de trufas", "Ao"
            + " leite", LocalDate.of(2021, 7, 10), 0.5, 2.0, 20, true, true, false, "Licor", true
            , 100);


    // Teste de vendas
    Chocolate chocolate1 = loja.getEstoque().getChocolatePorId(1);
    Chocolate chocolate2 = loja.getEstoque().getChocolatePorId(2);
    Cliente cliente = loja.getClientePorId(1);
    Funcionario funcionario = loja.getFuncionarioPorId(1);

    HashMap<Chocolate, Integer> chocolatesVendidos = new HashMap<>();
    chocolatesVendidos.put(chocolate1, 1);
    chocolatesVendidos.put(chocolate2, 1);

    loja.fazerVenda(chocolatesVendidos, loja.getProximoIdVenda(), cliente, funcionario,
            LocalDate.now());

    cliente = loja.getClientePorId(2);
    chocolatesVendidos = new HashMap<>();
    chocolatesVendidos.put(chocolate1, 5);

    loja.fazerVenda(chocolatesVendidos, loja.getProximoIdVenda(), cliente, funcionario,
            LocalDate.now());

  }

  public static MainFrame getFrame() {
    return frame;
  }
}
