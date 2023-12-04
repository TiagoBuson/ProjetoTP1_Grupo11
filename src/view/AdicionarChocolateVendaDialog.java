package view;

import controller.AdicionarChocolateVendaDialogController;
import model.Chocolate;

import javax.swing.*;
import java.awt.*;

/**
 * Classe que cria um dialog para a adição de um Chocolate novo em uma venda já criada.
 * @author Tiago
 * @version 1.0 (Oct 2021
 */
public class AdicionarChocolateVendaDialog extends JDialog {
  private final JComboBox<Chocolate> chocolate;
  private final JButton submit;

  /**
   * Cria o dialog de adição de um chocolate novo em uma venda já criada.
   * @param parent JFrame da classe pai.
   */
  public AdicionarChocolateVendaDialog(JFrame parent) {
    super(parent, "Adicionar novo chocolate");
    setModalityType(ModalityType.APPLICATION_MODAL);

    setLayout(new BorderLayout(20, 20));

    chocolate = new JComboBox<>();
    submit = new JButton("Salvar");

    AdicionarChocolateVendaDialogController controller =
            new AdicionarChocolateVendaDialogController(this);

    chocolate.addActionListener(controller);
    submit.addActionListener(controller);

    add(chocolate, BorderLayout.CENTER);
    add(submit, BorderLayout.AFTER_LAST_LINE);


    setMinimumSize(new Dimension(300, 200));
    pack();
    setResizable(false);
    setVisible(true);
  }

  /**
   * Getter do chocolate selecionado..
   * @return JComboBox de Chocolate do chocolate da venda.
   */
  public JComboBox<Chocolate> getChocolate() {
    return chocolate;
  }

  /**
   * Getter do botão submit.
   * @return botão para salvar as mudanças feitas.
   */
  public JButton getSubmit() {
    return submit;
  }
}
