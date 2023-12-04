package view;

import controller.FuncionarioDialogController;
import model.Loja;

import javax.swing.*;
import java.awt.*;
import java.text.ParseException;

/**
 * Classe com o dialog de criação de Funcionarios. Usa a classe FuncionarioDetails como base.
 * @author Tiago
 * @version 1.0
 */
public class FuncionarioDialog extends JDialog {
  private final FuncionarioDetails details;

  /**
   * Cria o dialog de criação de funcionarios. Usa a classe FuncionarioDetails como base.
   * @param parent JFrame da classe pai
   */
  public FuncionarioDialog(JFrame parent) throws ParseException {
    super(parent, "Funcionário");
    setModalityType(ModalityType.APPLICATION_MODAL);

    details = new FuncionarioDetails();
    add(details);

    details.getId().setText(String.valueOf(Loja.getInstance().showProximoIdFuncionario()));

    details.getSubmit().addActionListener(new FuncionarioDialogController(this));

    setMinimumSize(new Dimension(600, 200));
    pack();
    setResizable(false);
    setVisible(true);
  }

  /**
   * Getter dos detalhes do funcionario.
   * @return detalhes do cliente.
   */
  public FuncionarioDetails getDetails() {
    return details;
  }
}
