package view;
import model.Loja;

import javax.swing.*;
import java.awt.*;

/**
 * Classe com o dialog de criação de Clientes. Usa a classe ClienteDetails como base.
 * @author Tiago
 * @version 1.0
 */
public class ClienteDialog extends JDialog {
  private final ClienteDetails details;

  /**
   * Cria o dialog de criação de clientes. Usa a classe ClienteDetails como base.
   * @param parent JFrame da classe pai.
   */
  public ClienteDialog(JFrame parent) {
    super(parent, "Cliente");
    setModalityType(ModalityType.APPLICATION_MODAL);

    details = new ClienteDetails();
    add(details);

    details.getId().setText(String.valueOf(Loja.getInstance().showProximoIdCliente()));

    setMinimumSize(new Dimension(600, 200));
    pack();
    setResizable(false);
    setVisible(true);
  }

  /**
   * Getter dos painel de detalhes central.
   * @return detalhes do cliente.
   */
  public ClienteDetails getDetails() {
    return details;
  }
}
