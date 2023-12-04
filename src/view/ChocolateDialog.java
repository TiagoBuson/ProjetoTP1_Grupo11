package view;

import controller.ChocolateDialogController;
import model.Loja;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

/**
 * Classe com o dialog de criação de Chocolates. Usa a classe ChocolateDetails como base.
 * @author Tiago
 * @version 1.0
 */
public class ChocolateDialog extends JDialog {
  private final ChocolateDetails details;
  private final JComboBox<String> seletor;
  private final JSpinner quantidade;

  /**
   * Cria o dialog de criação de Chocolates. Varia dependendo da escolha de tipo de chocolate. Usa a classe
   * ChocolateDetails como base.
   * @param parent JFrame da classe pai.
   */
  public ChocolateDialog(JFrame parent) {
    super(parent, "Chocolate");
    setLayout(new BorderLayout());
    setModalityType(ModalityType.APPLICATION_MODAL);

    ChocolateDialogController controller = new ChocolateDialogController(this);

    JPanel topBar = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));

    String[] opcoes = {"Barra", "Chocotone", "Trufa"};
    seletor = new JComboBox<>(opcoes);
    seletor.setSelectedIndex(0);
    topBar.add(seletor);

    topBar.add(new JLabel("Quantidade:"));
    quantidade = new JSpinner(new SpinnerNumberModel(1, 1, null, 1) {});
    Component editor = quantidade.getEditor();
    JFormattedTextField textField = ((JSpinner.DefaultEditor) editor).getTextField();
    textField.setColumns(5);
    topBar.add(quantidade);

    seletor.addActionListener(controller);

    add(topBar, BorderLayout.BEFORE_FIRST_LINE);

    details = new ChocolateDetails();
    details.getQuantidade().setVisible(false);
    details.getQuantidadeLabel().setVisible(false);
    add(details, BorderLayout.CENTER);

    details.getId().setText(String.valueOf(Loja.getInstance().showProximoIdChocolate()));
    details.getDataCompra().setText(LocalDate.now().toString());

    details.getSubmit().addActionListener(controller);

    setMinimumSize(new Dimension(600, 400));
    pack();
    setResizable(false);
    setVisible(true);
  }

  /**
   * Getter dos detalhes do Chocolate.
   * @return detalhes do Chocolate.
   */
  public ChocolateDetails getDetails() {
    return details;
  }

  /*
   * Getter do seletor de tipo de Chocolate.
   * @return JComboBox do seletor de tipo de Chocolate.
   */
  public JComboBox<String> getSeletor() {
    return seletor;
  }

  /**
   * Getter da quantidade de Chocolates.
   * @return JSpinner da quantidade de Chocolate.
   */
  public JSpinner getQuantidade() {
    return quantidade;
  }
}
