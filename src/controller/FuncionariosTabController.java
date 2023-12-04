package controller;

import model.Funcionario;
import view.FuncionarioDetails;
import view.FuncionariosTab;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Classe controller da tab de funcionarios. Implementa ActionListeners e ListSelectionListeners à tab.
 * @author Tiago
 * @version 1.0
 */
public class FuncionariosTabController implements ListSelectionListener, ActionListener {
  FuncionariosTab funcionariosTab;

  /** Constrói um novo controller associado à aba de Funcionários.
   * @param funcionariosTab aba de Funcionários.
   */
  public FuncionariosTabController(FuncionariosTab funcionariosTab) {
    this.funcionariosTab = funcionariosTab;
  }

  /**
   * Atualiza o painel de detalhes para corresponder com os dados do Funcionário selecionado na lista.
   * @param e evento recebido da lista de Funcionários.
   */
  @Override
  public void valueChanged(ListSelectionEvent e) {
    if (!e.getValueIsAdjusting()) {
      Funcionario funcionario =
              (Funcionario) funcionariosTab.getListaFuncionarios().getLista().getSelectedValue();
      funcionariosTab.getDetails().popularDados(funcionario);
      funcionariosTab.getDetails().getSubmit().setEnabled(true);
    }
  }

  /**
   * Altera os dados do Funcionário selecionado com base nos elementos do painel de detalhes.
   * @param e evento recebido.
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource().equals(funcionariosTab.getDetails().getSubmit())) {
      Funcionario funcionario =
              (Funcionario) funcionariosTab.getListaFuncionarios().getLista().getSelectedValue();

      FuncionarioDetails details = funcionariosTab.getDetails();
      int idadeInt;
      try {
        idadeInt = Integer.parseInt(details.getIdade().getText());
      } catch (NumberFormatException ignored) {
        idadeInt = 0;
      }

      double salario;
      try {
        salario = Double.parseDouble(details.getSalario().getText());
      } catch (NumberFormatException ignored) {
        salario = 0.0;
      }

      funcionario.setNome(details.getNome().getText());
      funcionario.setCpf(details.getCpf().getText());
      funcionario.setTelefone(details.getTelefone().getText());
      funcionario.setIdade(idadeInt);
      funcionario.setEmail(details.getEmail().getText());
      funcionario.getEndereco().setBairro(details.getBairro().getText());
      funcionario.getEndereco().setCep(details.getCep().getText());
      funcionario.getEndereco().setRua(details.getRua().getText());
      funcionario.getEndereco().setNumero(details.getNumero().getText());
      funcionario.setSalario(salario);
      funcionario.setCargo(details.getCargo().getText());
    }
  }
}
