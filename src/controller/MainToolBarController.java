package controller;

import main.Main;
import model.*;
import view.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

/**
 * Classe controller da MainToolBar. Implementa ActionListeners à MainToolBar.
 * @author Tiago
 * @version 1.0
 */
public class MainToolBarController implements ActionListener {
  protected MainToolBar bar;
  protected JFrame parent;

  /** Constrói um controller associado à MainToolBar
   * @param bar toolbar principal
   */
  public MainToolBarController(MainToolBar bar) {
    this.bar = bar;
    parent = (JFrame) SwingUtilities.getWindowAncestor(bar);
  }

  /** Executa a ação do componente ativado.
   *
   * Quando um dos botões de adicionar é ativado, cria-se um novo Dialog para adicionar o elemento.
   * Quando o botão de remover é ativado, o elemento selecionado na aba ativa é removido.
   * Quando o usuário aperta ENTER na barra de pesquisa, a lista de todas as abas é filtrada com base no texto
   * inserido na barra de pesquisa.
   * @param e evento recebido.
   * @see ChocolateDialog
   * @see FuncionarioDialog
   * @see VendaDialog
   * @see ClienteDialog
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    // Diálogos de adicionar novo elemento.
    if (e.getSource() == bar.getAdicionarCliente()) {
      try {
        new ClienteDialog(parent);
      } catch (ParseException ex) {
        ex.printStackTrace();
      }
    } else if (e.getSource() == bar.getAdicionarChocolate()) {
      new ChocolateDialog(parent);
    } else if (e.getSource() == bar.getAdicionarFuncionario()) {
      try {
        new FuncionarioDialog(parent);
      } catch (ParseException ex) {
        ex.printStackTrace();
      }
    } else if (e.getSource() == bar.getAdicionarVenda()) {
      new VendaDialog(parent);

      // Lidando com o botão de remover.
    } else if (e.getSource() == bar.getRemover()) {

      MainFrame frame = Main.getFrame();
      JTabbedPane tabs = frame.getTabs();

      // Removendo o elemento selecionado da aba ativa.
      switch (tabs.getSelectedIndex()) {
        case 0 -> {
          Cliente r =
                  (Cliente) frame.getClientesTab().getListaClientes().getLista().getSelectedValue();
          Loja.getInstance().removerCliente(r);
          frame.getClientesTab().getListaClientes().updateLista();
          frame.getClientesTab().resetListSelectionController();
        }
        case 1 -> {
          Funcionario r =
                  (Funcionario) frame.getFuncionariosTab().getListaFuncionarios().getLista().getSelectedValue();
          Loja.getInstance().removerFuncionario(r);
          frame.getFuncionariosTab().getListaFuncionarios().updateLista();
          frame.getFuncionariosTab().resetListSelectionController();
        }
        case 2 -> {
          Chocolate r =
                  (Chocolate) frame.getChocolatesTab().getListaChocolates().getLista().getSelectedValue();
          Loja.getInstance().removerChocolate(r);
          frame.getChocolatesTab().getListaChocolates().updateLista();
          frame.getChocolatesTab().resetListSelectionController();
        }
      }

      Venda v = (Venda) frame.getVendasTab().getListaVendas().getLista().getSelectedValue();
      Chocolate c = (Chocolate) frame.getChocolatesTab().getListaChocolates().getLista().getSelectedValue();
      Cliente cl = (Cliente) frame.getClientesTab().getListaClientes().getLista().getSelectedValue();
      Funcionario f = (Funcionario) frame.getFuncionariosTab().getListaFuncionarios().getLista().getSelectedValue();

      int vQuant = Loja.getInstance().getVendas().length;
      int cQuant = Loja.getInstance().getEstoque().getChocolates().size();
      int clQuant = Loja.getInstance().getClientes().length;
      int fQuant = Loja.getInstance().getFuncionarios().length;


      // Teste para ver se ainda existe alguma lista na venda.
      if (vQuant > 0) {
        frame.getVendasTab().getDetails().popularDados(v);
      } else {
        // Caso não exista, deixar a tela de editar detalhes da venda desativada até outra venda
        // for adicionada.
        frame.getVendasTab().getDetails().popularDados();
        frame.getVendasTab().getDetails().getSubmit().setEnabled(false);
      }
      // Repetimos o mesmo processo acima para clientes, funcionários e chocolates
      if (cQuant > 0) {
        if (c instanceof Barra) {
          frame.getChocolatesTab().getDetails().popularDados(ChocolateDetails.BARRA, c);
        } else if (c instanceof Trufa) {
          frame.getChocolatesTab().getDetails().popularDados(ChocolateDetails.TRUFA, c);
        } else if (c instanceof Chocotone) {
          frame.getChocolatesTab().getDetails().popularDados(ChocolateDetails.CHOCOTONE, c);
        }
      } else {
        frame.getChocolatesTab().getDetails().popularDados();
        frame.getChocolatesTab().getDetails().getSubmit().setEnabled(false);
      }

      if (clQuant > 0) {
        frame.getClientesTab().getDetails().popularDados(cl);
      } else {
        frame.getClientesTab().getDetails().popularDados();
        frame.getClientesTab().getDetails().getSubmit().setEnabled(false);
      }

      if (fQuant > 0) {
        frame.getFuncionariosTab().getDetails().popularDados(f);
      } else {
        frame.getFuncionariosTab().getDetails().popularDados();
        frame.getFuncionariosTab().getDetails().getSubmit().setEnabled(false);
      }

      frame.getClientesTab().getListaClientes().updateLista();
      frame.getFuncionariosTab().getListaFuncionarios().updateLista();
      frame.getChocolatesTab().getListaChocolates().updateLista();
      frame.getVendasTab().getListaVendas().updateLista();

      frame.getVendasTab().resetListSelectionController();
      frame.getChocolatesTab().resetListSelectionController();
      frame.getClientesTab().resetListSelectionController();
      frame.getFuncionariosTab().resetListSelectionController();

    }
    // Barra de pesquisa
    else if (e.getSource() == bar.getPesquisar()) {
      MainFrame frame = Main.getFrame();
      if (bar.getPesquisar().getText().equals("")) {
        // Se o texto estiver vazio, atualiza todas as listas e restora todos os resultados.
        frame.getClientesTab().getListaClientes().updateLista();
        frame.getFuncionariosTab().getListaFuncionarios().updateLista();
        frame.getChocolatesTab().getListaChocolates().updateLista();
        frame.getVendasTab().getListaVendas().updateLista();
      } else {
        String text = bar.getPesquisar().getText();
        // Filtra as listas.
        frame.getClientesTab().getListaClientes().updateLista(text);
        frame.getFuncionariosTab().getListaFuncionarios().updateLista(text);
        frame.getChocolatesTab().getListaChocolates().updateLista(text);
        frame.getVendasTab().getListaVendas().updateLista(text);
        }
      }
      }
    }



