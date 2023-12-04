package controller;

import main.Main;
import model.Endereco;
import model.Loja;
import view.ClienteDetails;
import view.ClienteDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Classe controller do dialog de clientes. Implementa ActionListeners ao dialog.
 * @author Tiago
 * @version 1.0
 */
public class ClienteDialogController implements ActionListener {
  ClienteDialog view;

  /**
   * Constroi um novo controller associado ao dialog de adicionar cliente.
   * @param view dialogo de adicionar cliente.
   */
  public ClienteDialogController(ClienteDialog view) {
    this.view = view;
  }

  /**
   * Cadastra um novo cliente com os valores das caixas de texto.
   * @param e evento recebido.
   */
  @Override
  public void actionPerformed(ActionEvent e) {

    if (e.getSource().equals(view.getDetails().getSubmit())) {

      ClienteDetails details = view.getDetails();

      String idade = details.getIdade().getText();

      // Tenta converter a idade para Inteiro
      int idadeInt;
      try {
        idadeInt = Integer.parseInt(idade);
      } catch (NumberFormatException ignored) {
        idadeInt = 0;
      }

      Endereco endereco = new Endereco(details.getBairro().getText(), details.getRua().getText(),
              details.getNumero().getText(), details.getCep().getText());

      // Cadastra o cliente.
      Loja.getInstance().cadastrarCliente(Loja.getInstance().getProximoIdCliente(), idadeInt,
              details.getNome().getText(), details.getCpf().getText(),
              details.getTelefone().getText(), details.getEmail().getText(), endereco,
              details.getCategoria().getText());

      // Atualiza a lista de clientes que é mostrada.
      Main.getFrame().getClientesTab().getListaClientes().updateLista();
      Main.getFrame().getClientesTab().resetListSelectionController();

      view.dispose();
    }
  }
}
