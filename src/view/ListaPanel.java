package view;

import model.Chocolate;
import model.Loja;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Classe que cria o painel de listagem que será usado nas abas de Cliente, Funcionário, Chocolate e Venda.
 */
public class ListaPanel extends JPanel {

  public static final int CLIENTE = 0;
  public static final int FUNCIONARIO = 1;
  public static final int CHOCOLATE = 2;
  public static final int VENDA = 3;

  private final int selection;
  private final JScrollPane listaScroller;
  private JList<?> lista;

  /**
   * Cria o JScrollPane de listagem.
   * @param selection inteiro para a seleção do objeto desejado. Usar os atributos estáticos CLIENTE, FUNCIONARIO,
   *                  CHOCOLATE e VENDA em vez de usar um int diretamente
   */
  public ListaPanel(int selection) {
    this.selection = selection;
    listaScroller = new JScrollPane();
    updateLista();


    listaScroller.setPreferredSize(new Dimension(200, 600));
    listaScroller.setMinimumSize(new Dimension(200, 600));

    add(listaScroller);
  }

  /**
   * Popula a lista com os dados da aplicação, levando em consideração o tipo de dados que foi selecionado no
   * construtor.
   */
  public void updateLista() {
    switch (selection) {
      case CLIENTE -> lista = new JList<>(Loja.getInstance().getClientes());
      case FUNCIONARIO -> lista = new JList<>(Loja.getInstance().getFuncionarios());
      case CHOCOLATE -> lista =
              new JList<>(Loja.getInstance().getEstoque().getChocolates().toArray(new Chocolate[0]));
      case VENDA -> lista = new JList<>(Loja.getInstance().getVendas());
    }

    lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    lista.setLayoutOrientation(JList.VERTICAL);
    lista.setVisibleRowCount(-1);

    listaScroller.setViewportView(lista);
  }

  /**
   * Atualiza a lista com base no texto passado como parâmetro. Os resultados mostrados são os que contem o texto como
   * substring.
   *
   * @param text Texto a ser filtrado
   */
  public void updateLista(String text) {
    List<?> filtrado = null;
    switch (selection) {
      case CLIENTE -> filtrado = Arrays.asList(Loja.getInstance().getClientes());
      case FUNCIONARIO -> filtrado = Arrays.asList(Loja.getInstance().getFuncionarios());
      case CHOCOLATE -> filtrado = Arrays.asList(Loja.getInstance().getEstoque().getChocolates().toArray(new Chocolate[0]));
      case VENDA -> filtrado = Arrays.asList(Loja.getInstance().getVendas());
    }

    // O assert checa se a variável foi inicializada corretamente dentro do switch.
    // Isso sempre deve acontecer, mas está aqui por redundância.

    assert filtrado != null;

    // Essa é a linha mais importante do método. Transforma o array em uma stream, depois usa o método filter com uma
    // função lambda para selecionar somente os elementos que contem text como substring. Depois, transforma a stream
    // em array com o método collect.
    filtrado = filtrado.stream().filter(p -> p.toString().contains(text)).collect(Collectors.toList());

    lista = new JList<>(filtrado.toArray());

    lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    lista.setLayoutOrientation(JList.VERTICAL);
    lista.setVisibleRowCount(-1);

    listaScroller.setViewportView(lista);
  }

  /**
   * Getter da lista
   * @return JList do modelo de lista
   */
  public JList<?> getLista() {
    return lista;
  }
}
