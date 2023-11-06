package view;

import model.Pessoa;

import javax.swing.*;
import java.awt.*;

/**
 * Classe abstrata de template para os Labels e TextFields dos clientes e funcionarios.
 * @author Tiago
 * @version 1.0
 */
public abstract class PessoaDetails extends DetailsPanel {
  private final JTextField id;
  private final JTextField idade;
  private final JTextField nome;
  private final JTextField cpf;
  private final JTextField telefone;
  private final JTextField email;
  private final JTextField bairro;
  private final JTextField rua;
  private final JTextField numero;
  private final JTextField cep;

  /**
   * Cria e adiciona os JLabels e os JTextFields base da classe Pessoa.
   * @param titulo String do titulo, varia dependendo de qual objeto é requerido.
   */
  protected PessoaDetails(String titulo) {
    super(titulo);

    JLabel labelId = new JLabel("Id:");
    JLabel labelIdade = new JLabel("Idade:");
    JLabel labelNome = new JLabel("Nome:");
    JLabel labelCpf = new JLabel("Cpf:");
    JLabel labelTelefone = new JLabel("Telefone:");
    JLabel labelEmail = new JLabel("Email:");
    JLabel labelBairro = new JLabel("Bairro:");
    JLabel labelRua = new JLabel("Rua:");
    JLabel labelNumero = new JLabel("Numero:");
    JLabel labelCep = new JLabel("Cep:");

    id = new JTextField();
    id.setEditable(false);
    idade = new JTextField();
    idade.setToolTipText("Inteiro.");
    nome = new JTextField();
    cpf = new JTextField();
    telefone = new JTextField();
    email = new JTextField();
    bairro = new JTextField();
    rua = new JTextField();
    numero = new JTextField();
    cep = new JTextField();

    GridBagConstraints left = getLeft();
    GridBagConstraints right = getRight();

    getInnerDetailsPanel().add(labelId, left);
    getInnerDetailsPanel().add(id, right);
    getInnerDetailsPanel().add(labelIdade, left);
    getInnerDetailsPanel().add(idade, right);
    getInnerDetailsPanel().add(labelNome, left);
    getInnerDetailsPanel().add(nome, right);
    getInnerDetailsPanel().add(labelCpf, left);
    getInnerDetailsPanel().add(cpf, right);
    getInnerDetailsPanel().add(labelTelefone, left);
    getInnerDetailsPanel().add(telefone, right);
    getInnerDetailsPanel().add(labelEmail, left);
    getInnerDetailsPanel().add(email, right);
    getInnerDetailsPanel().add(labelBairro, left);
    getInnerDetailsPanel().add(bairro, right);
    getInnerDetailsPanel().add(labelRua, left);
    getInnerDetailsPanel().add(rua, right);
    getInnerDetailsPanel().add(labelNumero, left);
    getInnerDetailsPanel().add(numero, right);
    getInnerDetailsPanel().add(labelCep, left);
    getInnerDetailsPanel().add(cep, right);
  }

  /**
   * Popula os JTextFields do metodo PessoaDetails() com os detalhes da pessoa requerida.
   * @param pessoa objeto da Pessoa, com as informações desta.
   */
  public void popularDados(Pessoa pessoa) {
    setAllEnabled(true);

    id.setText(String.valueOf(pessoa.getId()));
    idade.setText(String.valueOf(pessoa.getIdade()));
    nome.setText(pessoa.getNome());
    cpf.setText(pessoa.getCpf());
    telefone.setText(pessoa.getTelefone());
    email.setText(pessoa.getEmail());
    bairro.setText(pessoa.getEndereco().getBairro());
    rua.setText(pessoa.getEndereco().getRua());
    numero.setText(pessoa.getEndereco().getNumero());
    cep.setText(pessoa.getEndereco().getCep());
  }

  /**
   * Desabilita e retira o textp de todos os componentes. Usado quando não há nenhuma pessoa (Cliente ou Funcionário)
   * cadastrado.
   */
  public void popularDados() {
    setAllEnabled(false);

    id.setText("");
    idade.setText("");
    nome.setText("");
    cpf.setText("");
    telefone.setText("");
    email.setText("");
    bairro.setText("");
    rua.setText("");
    numero.setText("");
    cep.setText("");
  }

  /** Ativa ou desativa os componentes.
   * @param bool seletor se ativa ou desativa.
   */
  public void setAllEnabled(boolean bool) {
    id.setEnabled(bool);
    idade.setEnabled(bool);
    nome.setEnabled(bool);
    cpf.setEnabled(bool);
    telefone.setEnabled(bool);
    email.setEnabled(bool);
    bairro.setEnabled(bool);
    rua.setEnabled(bool);
    numero.setEnabled(bool);
    cep.setEnabled(bool);
  }

  /**
   * Getter do id da pessoa.
   * @return Jtextfield com o id da pessoa.
   */
  public JTextField getId() {
    return id;
  }

  /**
   * Getter da idade da pessoa.
   * @return Jtextfield com a idade da pessoa.
   */
  public JTextField getIdade() {
    return idade;
  }

  /**
   * Getter do nome da pessoa.
   * @return Jtextfield com o nome da pessoa.
   */
  public JTextField getNome() {
    return nome;
  }

  /**
   * Getter do cpf da pessoa.
   * @return Jtextfield com o cpf da pessoa.
   */
  public JTextField getCpf() {
    return cpf;
  }

  /**
   * Getter do telefone da pessoa.
   * @return Jtextfield com o telefone da pessoa.
   */
  public JTextField getTelefone() {
    return telefone;
  }

  /**
   * Getter do email da pessoa.
   * @return Jtextfield com o email da pessoa.
   */
  public JTextField getEmail() {
    return email;
  }

  /**
   * Getter do bairro da pessoa.
   * @return Jtextfield com o bairro da pessoa.
   */
  public JTextField getBairro() {
    return bairro;
  }

  /**
   * Getter da rua da pessoa.
   * @return Jtextfield com a rua da pessoa.
   */
  public JTextField getRua() {
    return rua;
  }

  /**
   * Getter do numero da pessoa.
   * @return Jtextfield com o numero da pessoa.
   */
  public JTextField getNumero() {
    return numero;
  }

  /**
   * Getter do cep da pessoa.
   * @return Jtextfield com o cep da pessoa.
   */
  public JTextField getCep() {
    return cep;
  }
}
