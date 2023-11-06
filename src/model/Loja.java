package model;

import java.time.LocalDate;
import java.util.*;

/**
 * Classe que representa a Loja. Guarda e configura os clientes, funcionarios, vendas e estoque. <br>
 *
 * Essa classe é a principal do programa, já que armazena todas as informações. Como ela tem que ser acessada em
 * diversas outras classes, passá-la como parâmetro em todos os construtores seria uma tarefa repetitiva. Por isso,
 * optamos em seguir o padrão singleton, onde só existe uma instância da classe. Essa instância é estática e pode ser
 * acessada por meio de um método estático, possibilitando que qualquer outra classe modifique a instância por meio
 * do método {@link #getInstance()}. <br>
 *
 * O parão de design simpleton não é considerado boa prática pela maioria dos profissionais, mas para um projeto de
 * pequeno porte como esse ele pode ser usado se tomarmos as devidas precauções. Uma dessas precauções é relacionada
 * aos testes unitários. Como a instância é estática, os valores não são perdidos quando o escopo do teste acaba,
 * então temos que resetar a instância para seu estado inicial, usando {@link #reset()}.
 * @author Tiago
 * @version 1.0
 */
public class Loja {
  private static final Loja instance = new Loja();

  private final Estoque estoque;
  private final ArrayList<Funcionario> funcionarios;
  private final ArrayList<Cliente> clientes;
  private final ArrayList<Venda> vendas;

  private int clienteId = 0;
  private int funcionarioId = 0;
  private int chocolateId = 0;
  private int vendaId = 0;

  /**
   * Constrói uma nova instância da Loja. Importante notar que o construtor é privado, já que a classe é um singleton.
   */
  private Loja() {
    this.estoque = new Estoque();
    this.funcionarios = new ArrayList<>();
    this.clientes = new ArrayList<>();
    this.vendas = new ArrayList<>();
  }

  /**
   * Retorna a classe para ser estado inicial, sem clientes, funcionários, chocolates nem vendas cadastradas. Útil
   * para testes.
   */
  public void reset() {
    clientes.clear();
    funcionarios.clear();
    vendas.clear();
    estoque.clear();

    clienteId = 0;
    funcionarioId = 0;
    chocolateId = 0;
    vendaId = 0;
  }

  /**
   * Acessa a instância global da classe. Esse é o metodo característico de um singleton.
   *
   * @return a instância global da Loja.
   */
  public static Loja getInstance() {
    return instance;
  }

  /**
   * Cadastra um novo cliente na lista de clientes
   * @param id representa o id do cliente.
   * @param idade representa a idade do cliente.
   * @param nome representa o nome do cliente.
   * @param cpf representa o cpf do cliente.
   * @param telefone representa o telefone do cliente.
   * @param email representa o email do cliente.
   * @param endereco representa o endereço do cliente.
   * @param categoria representa a categoria do cliente.
   */
  public void cadastrarCliente(int id, int idade, String nome, String cpf, String telefone,
                               String email, Endereco endereco, String categoria) {
    clientes.add(new Cliente(id, idade, nome, cpf, telefone, email, endereco, categoria));
  }

  /**
   * Cadastra um novo funcionário na lista de funcionários
   * @param id representa o id do funcionario.
   * @param idade representa a idade do funcionario.
   * @param nome representa o nome do funcionario.
   * @param cpf representa o cpf do funcionario.
   * @param telefone representa o telefone do funcionario.
   * @param email representa o email do funcionario.
   * @param endereco representa o endereço do funcionario.
   * @param salario representa o salario do funcionario.
   * @param cargo representa o cargo do funcionario.
   */
  public void cadastrarFuncionario(int id, int idade, String nome, String cpf, String telefone,
                                   String email, Endereco endereco, double salario, String cargo) {
    funcionarios.add(new Funcionario(id, idade, nome, cpf, telefone, email, endereco, salario,
            cargo));
  }

  /**
   * Cadastra uma nova barra na lista de chocolates
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
   * @param quantidade representa a quantidade de barras que serão cadastradas.
   */
  public void cadastrarBarra(int id, int peso, String nome, String descricao, String tipo,
                             LocalDate dataCompra, double precoCompra, double precoVenda,
                             double porcentagemCacau, boolean contemGluten, boolean contemLactose
          , boolean artesanal, String sabor, String[] nibs, int quantidade) {
    estoque.adicionarChocolate(new Barra(id, peso, nome, descricao, tipo, dataCompra, precoCompra
            , precoVenda, porcentagemCacau, contemGluten, contemLactose, artesanal, sabor, nibs),
            quantidade);
  }

  /**
   * Cadastra uma nova trufa na lista de chocolates
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
   * @param quantidade representa a quantidade de trufas que serão cadastradas.
   */
  public void cadastrarTrufa(int id, int peso, String nome, String descricao, String tipo,
                             LocalDate dataCompra, double precoCompra, double precoVenda,
                             double porcentagemCacau, boolean contemGluten, boolean contemLactose
          , boolean artesanal, String recheio, boolean alcoolico, int quantidade) {
    estoque.adicionarChocolate(new Trufa(id, peso, nome, descricao, tipo, dataCompra, precoCompra
            , precoVenda, porcentagemCacau, contemGluten, contemLactose, artesanal, recheio,
            alcoolico), quantidade);
  }

  /**
   * Cadastra um novo chocotone na lista de chocolates
   * @param id representa o id do Chocotone.
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
   * @param quantidade representa a quantidade de chocotones que serão cadastrados.
   */
  public void cadastrarChocotone(int id, int peso, String nome, String descricao, String tipo,
                                 LocalDate dataCompra, double precoCompra, double precoVenda,
                                 double porcentagemCacau, boolean contemGluten,
                                 boolean contemLactose, boolean artesanal, String recheio,
                                 String[] frutas, int quantidade) {
    estoque.adicionarChocolate(new Chocotone(id, peso, nome, descricao, tipo, dataCompra,
            precoCompra, precoVenda, porcentagemCacau, contemGluten, contemLactose, artesanal,
            recheio, frutas), quantidade);
  }

  /**
   * Soma 1 ao id do cliente e o retorna. <br>
   *
   * Usado quando um novo cliente é adicionado.
   * @return Id do Cliente.
   */
  public int getProximoIdCliente() {
    clienteId++;
    return clienteId;
  }

  /**
   * Retorna o proximo id do cliente. <br>
   *
   * Usado para mostrar qual seria o Id do próximo cliente
   * @return Id do cliente + 1.
   */
  public int showProximoIdCliente() {
    return clienteId + 1;
  }

  /**
   * Soma 1 ao id do funcionario e o retorna. <br>
   *
   * Usado quando um novo Funcionário é adicionado.
   * @return Id do Funcionario.
   */
  public int getProximoIdFuncionario() {
    funcionarioId++;
    return funcionarioId;
  }

  /**
   * Retorna o proximo id do funcionario.
   *
   * Usado para mostrar qual seria o Id do próximo funcionário
   * @return Id do funcionario + 1.
   */
  public int showProximoIdFuncionario() {
    return funcionarioId + 1;
  }

  /**
   * Soma 1 ao id do chocolate e o retorna.
   *
   * Usado quando um novo chocolate é adicionado.
   * @return Id do chocolate.
   */
  public int getProximoIdChocolate() {
    chocolateId++;
    return chocolateId;
  }

  /**
   * Retorna o proximo id do chocolate.
   * @return Id do chocolate + 1.
   */
  public int showProximoIdChocolate() {
    return chocolateId + 1;
  }

  /**
   * Soma 1 ao id da venda e o retorna.
   * @return Id da venda.
   */
  public int getProximoIdVenda() {
    vendaId++;
    return vendaId;
  }

  /**
   * Realiza uma venda, retirando a quantidade de chocolates vendidos do estoque. <br>
   *
   * Como o método {@link model.Estoque#removerChocolate(Chocolate)} checa se a quantidade poder ser removida, esse
   * método trata dessa exceção. Mesmo assim, os Spinners que controlam a quantidade de produtos a serem adicionados
   * a uma venda só conseguem ir até a quantidade em estoque do chocolate, então essa medida é redundante.
   *
   * @param chocolatesQuantidades quantidades de chocolate vendido.
   * @param id id da venda.
   * @param cliente cliente que fez a venda.
   * @param funcionario funcionario que fez a venda.
   * @param data data da venda.
   */
  public void fazerVenda(Map<Chocolate, Integer> chocolatesQuantidades, int id,
                         Cliente cliente, Funcionario funcionario, LocalDate data) {
    Venda venda = new Venda(id, cliente, funcionario, data);

    for (Chocolate chocolate : chocolatesQuantidades.keySet()) {
      try {
        estoque.retirarQuantidade(chocolate, chocolatesQuantidades.get(chocolate));
        venda.adicionarChocolate(chocolate, chocolatesQuantidades.get(chocolate));
      } catch (Exception e) {
        System.out.println(e.getMessage()); // Printa o erro
        return;                             // Sai da função
      }
    }

    venda.calcularValor();
    vendas.add(venda);
  }

  /**
   * Pesquisa um cliente por id.
   * @param id id do cliente.
   * @return cliente.
   */
  public Cliente getClientePorId(int id) {
    for (Cliente cliente : clientes) {
      if (cliente.getId() == id) {
        return cliente;
      }
    }
    return null;
  }

  /**
   * Pesquisa um cliente pelo nome
   * @param nome nome do cliente.
   * @return cliente.
   */
  public Cliente getClientePorNome(String nome) {
    for (Cliente cliente : clientes) {
      if (Objects.equals(cliente.getNome(), nome)) {
        return cliente;
      }
    }
    return null;
  }

  /**
   * Pesquisa um funcionario por id.
   * @param id id do funcionario.
   * @return funcionario.
   */
  public Funcionario getFuncionarioPorId(int id) {
    for (Funcionario funcionario : funcionarios) {
      if (funcionario.getId() == id) {
        return funcionario;
      }
    }

    return null;
  }

  /**
   * Pesquisa um funcionario pelo nome.
   * @param nome nome do funcionario.
   * @return funcionario.
   */
  public Funcionario getFuncionarioPorNome(String nome) {
    for (Funcionario funcionario : funcionarios) {
      if (Objects.equals(funcionario.getNome(), nome)) {
        return funcionario;
      }
    }
    return null;
  }

  /**
   * Pesquisa uma venda por id.
   * @param id id da venda.
   * @return venda.
   */
  public Venda getVendaPorId(int id) {
    for (Venda venda : vendas) {
      if (venda.getId() == id) {
        return venda;
      }
    }

    return null;
  }

  /**
   * Remove um chocolate da lista. <br>
   *
   * Quando um chocolate é removido, esse método também remove qualquer venda que continha tal chocolate.
   * @param chocolate chocolate que sera removido da lista.
   */

  public void removerChocolate(Chocolate chocolate) {
    vendas.removeIf(venda -> venda.getChocolateVendidos().containsKey(chocolate));
    estoque.removerChocolate(chocolate);
  }

  /**
   * Remove um cliente da lista. <br>
   *
   * Quando um cliente é removido, esse método também remove qualquer venda que continha tal cliente.
   * @param cliente cliente que sera removivdo da lista.
   */
  public void removerCliente(Cliente cliente) {
    vendas.removeIf(venda -> venda.getCliente().equals(cliente));
    clientes.remove(cliente);
  }

  /**
   * Remove um funcionario da lista. <br>
   *
   * Quando um funcionário é removido, esse método também remove qualquer venda que continha tal funcionário.
   * @param funcionario funcionario que sera removido da lista.
   */
  public void removerFuncionario(Funcionario funcionario) {
    vendas.removeIf(venda -> venda.getFuncionario().equals(funcionario));
    funcionarios.remove(funcionario);
  }

  public Cliente[] getClientes() {
    return clientes.toArray(new Cliente[0]);
  }

  public Funcionario[] getFuncionarios() {
    return funcionarios.toArray(new Funcionario[0]);
  }

  public Venda[] getVendas() {
    return this.vendas.toArray(new Venda[0]);
  }

  public Estoque getEstoque() {
    return estoque;
  }
}
