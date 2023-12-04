package view;

import main.Main;
import model.Cliente;
import model.Funcionario;
import model.Loja;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.HashMap;

/**
 * Classe com o dialog de criação de Venda. Usa a classe VendaDetails como base.
 * @author Tiago
 * @version 1.0
 */
public class VendaDialog extends JDialog {
  private final JComboBox<Cliente> cliente;
  private final JComboBox<Funcionario> funcionario;

  /**
   * Cria o dialog de criação de vendas. Usa a classe VendaDetails como base.
   * @param parent JFrame da classe pai.
   */
  public VendaDialog(JFrame parent) {
    super(parent, "Venda");
    setModalityType(ModalityType.APPLICATION_MODAL);

    JPanel details = new JPanel(new GridBagLayout());
    GridBagConstraints left = new GridBagConstraints();
    GridBagConstraints right = new GridBagConstraints();

    left.anchor = GridBagConstraints.EAST;
    right.weightx = 2.0;
    right.fill = GridBagConstraints.HORIZONTAL;
    right.gridwidth = GridBagConstraints.REMAINDER;

    cliente = new JComboBox<>(Loja.getInstance().getClientes());
    funcionario = new JComboBox<>(Loja.getInstance().getFuncionarios());

    cliente.setSelectedIndex(0);
    funcionario.setSelectedIndex(0);

    details.add(new JLabel("Cliente:"), left);
    details.add(cliente, right);
    details.add(new JLabel("Funcionário:"), left);
    details.add(funcionario, right);

    add(details, BorderLayout.CENTER);

    JButton submit = new JButton("Salvar");
    add(submit, BorderLayout.AFTER_LAST_LINE);

    // Action listener anônimo para adicionar a nova venda.
    submit.addActionListener(e -> {
     Loja.getInstance().fazerVenda(
             new HashMap<>(),
             Loja.getInstance().getProximoIdVenda(),
             (Cliente) cliente.getSelectedItem(),
             (Funcionario) funcionario.getSelectedItem(),
             LocalDate.now()
     );
     Main.getFrame().getVendasTab().getListaVendas().updateLista();
     Main.getFrame().getVendasTab().resetListSelectionController();
     dispose();
    });

    setMinimumSize(new Dimension(600, 200));
    pack();
    setResizable(false);
    setVisible(true);

  }


}
