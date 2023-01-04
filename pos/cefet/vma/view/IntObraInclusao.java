/*
 * Criado em 24/06/2007
 */
package pos.cefet.vma.view;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import pos.cefet.vma.constants.BIBConstants;
import pos.cefet.vma.interfaces.InterfaceObra;

/**
 * @author Vanderlei
 */
public class IntObraInclusao extends JInternalFrame implements InterfaceObra {

	private JPanel jContentPane = null;

	private JPanel jPanel = null;
	private JLabel lblMatricula = null;
	private JLabel lblNome = null;
	private JLabel lblSenha1 = null;
	private JLabel lblDataNasc = null;
	
	private JLabel lblLogradouro = null;
	private JLabel lblNumero = null;
	private JLabel lblBairro = null;
	private JLabel lblComplemento = null;
	private JLabel lblEmail = null;
	private JTextField txtCodigo = null;
	private JTextField txtDescricao = null;
	private JTextField txtAutor = null;
	private JTextField txtEditora = null;
	private JTextField txtDtPublicacao = null;
	private JTextField txtDtAtivacao = null;
	private JTextField txtDtDesativacao = null;
	private javax.swing.JButton btIncluir = null;
	
	private ActionListener ctrlListener = null;

	private javax.swing.JComboBox jboGenero = null;
	private javax.swing.JComboBox jCboDesativacao = null;
	private javax.swing.JLabel lblValor = null;
	private javax.swing.JTextField txtValor = null;
	/**
	 * 
	 */
	public IntObraInclusao(ActionListener ctrlListener) {
		super("Inclusão de Obra", false, true);
		
		this.ctrlListener = ctrlListener;
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(719, 526);
		this.setResizable(false);
		this.setContentPane(getJContentPane());
		this.setVisible(true);
	}
	/**
	 * This method initializes jContentPane
	 * 
	 * @return JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJPanel(), null);
		}
		return jContentPane;
	}
	/**
	 * This method initializes jPanel
	 * 
	 * @return JPanel
	 */
	private JPanel getJPanel() {
		if(jPanel == null) {
			jPanel = new JPanel();
			jPanel.setLayout(null);
			jPanel.add(getJLabel(), null);
			jPanel.add(getJLabel1(), null);
			jPanel.add(getJLabel2(), null);
			jPanel.add(getJLabel5(), null);
			jPanel.add(getJLabel6(), null);
			jPanel.add(getJLabel7(), null);
			jPanel.add(getJLabel8(), null);
			jPanel.add(getJLabel16(), null);
			jPanel.add(getJLabel17(), null);
			jPanel.add(getTxtCodigo(), null);
			jPanel.add(getTxtDesricao(), null);
			jPanel.add(getTxtAutor(), null);
			jPanel.add(getTxtEditora(), null);
			jPanel.add(getTxtDataPublicacao(), null);
			jPanel.add(getTxtDtAtivacao(), null);
			jPanel.add(getTxtDtDesativacao(), null);
			jPanel.add(getJButton(), null);
			jPanel.add(getJCboGenero(), null);
			jPanel.add(getJCboDesativavao(), null);
			jPanel.add(getJLabel3(), null);
			jPanel.add(getTxtValor(), null);
			jPanel.setBounds(25, 25, 629, 451);
			jPanel.setBorder(BorderFactory.createLineBorder(Color.black,1));
		}
		return jPanel;
	}
	/**
	 * This method initializes lblMatricula
	 * 
	 * @return JLabel
	 */
	private JLabel getJLabel() {
		if(lblMatricula == null) {
			lblMatricula = new JLabel();
			lblMatricula.setSize(100, 20);
			lblMatricula.setText("Código :");
			lblMatricula.setLocation(15, 15);
		}
		return lblMatricula;
	}
	/**
	 * This method initializes lblNome
	 * 
	 * @return JLabel
	 */
	private JLabel getJLabel1() {
		if(lblNome == null) {
			lblNome = new JLabel();
			lblNome.setSize(100, 20);
			lblNome.setText("Descrição :");
			lblNome.setLocation(15, 46);
		}
		return lblNome;
	}
	/**
	 * This method initializes lblSenha1
	 * 
	 * @return JLabel
	 */
	private JLabel getJLabel2() {
		if(lblSenha1 == null) {
			lblSenha1 = new JLabel();
			lblSenha1.setSize(100, 20);
			lblSenha1.setText("Genero :");
			lblSenha1.setLocation(15, 74);
		}
		return lblSenha1;
	}
	/**
	 * This method initializes lblDataNasc
	 * 
	 * @return JLabel
	 */
	private JLabel getJLabel5() {
		if(lblDataNasc == null) {
			lblDataNasc = new JLabel();
			lblDataNasc.setSize(100, 20);
			lblDataNasc.setText("Autor :");
			lblDataNasc.setLocation(15, 109);
		}
		return lblDataNasc;
	}
	/**
	 * This method initializes lblLogradouro
	 * 
	 * @return JLabel
	 */
	private JLabel getJLabel6() {
		if(lblLogradouro == null) {
			lblLogradouro = new JLabel();
			lblLogradouro.setSize(100, 20);
			lblLogradouro.setText("Editora :");
			lblLogradouro.setLocation(15, 142);
		}
		return lblLogradouro;
	}
	/**
	 * This method initializes lblNumero
	 * 
	 * @return JLabel
	 */
	private JLabel getJLabel7() {
		if(lblNumero == null) {
			lblNumero = new JLabel();
			lblNumero.setSize(103, 20);
			lblNumero.setText("Data Publicação :");
			lblNumero.setLocation(400, 143);
		}
		return lblNumero;
	}
	/**
	 * This method initializes lblBairro
	 * 
	 * @return JLabel
	 */
	private JLabel getJLabel8() {
		if(lblBairro == null) {
			lblBairro = new JLabel();
			lblBairro.setSize(141, 20);
			lblBairro.setText("Data Ativação da Obra :");
			lblBairro.setLocation(15, 178);
		}
		return lblBairro;
	}
	/**
	 * This method initializes lblComplemento
	 * 
	 * @return JLabel
	 */
	private JLabel getJLabel16() {
		if(lblComplemento == null) {
			lblComplemento = new JLabel();
			lblComplemento.setSize(158, 20);
			lblComplemento.setText("Data Desativação da Obra :");
			lblComplemento.setLocation(345, 178);
		}
		return lblComplemento;
	}
	/**
	 * This method initializes lblEmail
	 * 
	 * @return JLabel
	 */
	private JLabel getJLabel17() {
		if(lblEmail == null) {
			lblEmail = new JLabel();
			lblEmail.setSize(134, 20);
			lblEmail.setText("Motivo da desativação :");
			lblEmail.setLocation(15, 215);
		}
		return lblEmail;
	}
	/**
	 * This method initializes txtCodigo
	 * 
	 * @return JTextField
	 */
	public JTextField getTxtCodigo() {
		if(txtCodigo == null) {
			txtCodigo = new JTextField();
			txtCodigo.setSize(148, 20);
			txtCodigo.setLocation(130, 16);
		}
		return txtCodigo;
	}
	/**
	 * This method initializes txtDescricao
	 * 
	 * @return JTextField
	 */
	public JTextField getTxtDesricao() {
		if(txtDescricao == null) {
			txtDescricao = new JTextField();
			txtDescricao.setSize(367, 20);
			txtDescricao.setLocation(130, 45);
		}
		return txtDescricao;
	}
	/**
	 * This method initializes txtAutor
	 * 
	 * @return JTextField
	 */
	public JTextField getTxtAutor() {
		if(txtAutor == null) {
			txtAutor = new JTextField();
			txtAutor.setBounds(130, 109, 365, 20);
		}
		return txtAutor;
	}
	/**
	 * This method initializes txtEditora
	 * 
	 * @return JTextField
	 */
	public JTextField getTxtEditora() {
		if(txtEditora == null) {
			txtEditora = new JTextField();
			txtEditora.setSize(258, 20);
			txtEditora.setLocation(130, 142);
		}
		return txtEditora;
	}
	/**
	 * This method initializes txtDtPublicacao
	 * 
	 * @return JTextField
	 */
	public JTextField getTxtDataPublicacao() {
		if(txtDtPublicacao == null) {
			txtDtPublicacao = new JTextField();
			txtDtPublicacao.setSize(101, 20);
			txtDtPublicacao.setLocation(508, 144);
		}
		return txtDtPublicacao;
	}
	/**
	 * This method initializes txtDtAtivacao
	 * 
	 * @return JTextField
	 */
	public JTextField getTxtDtAtivacao() {
		if(txtDtAtivacao == null) {
			txtDtAtivacao = new JTextField();
			txtDtAtivacao.setSize(101, 20);
			txtDtAtivacao.setLocation(165, 179);
			
			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			txtDtAtivacao.setText(dateFormat.format(calendar.getTime()));
			
			txtDtAtivacao.setEnabled(false);
		}
		return txtDtAtivacao;
	}
	/**
	 * This method initializes txtDtDesativacao
	 * 
	 * @return JTextField
	 */
	public JTextField getTxtDtDesativacao() {
		if(txtDtDesativacao == null) {
			txtDtDesativacao = new JTextField();
			txtDtDesativacao.setSize(101, 20);
			txtDtDesativacao.setLocation(509, 179);
			txtDtDesativacao.setEnabled(false);
		}
		return txtDtDesativacao;
	}
	/**
	 * This method initializes jButton
	 * 
	 * @return javax.swing.JButton
	 */
	public JButton getJButton() {
		if(btIncluir == null) {
			btIncluir = new JButton();
			btIncluir.setBounds(251, 280, 139, 36);
			btIncluir.setText("Incluir");
			btIncluir.addActionListener(ctrlListener);
		}
		return btIncluir;
	}
	/**
	 * This method initializes jboGenero
	 * 
	 * @return javax.swing.JComboBox
	 */
	public JComboBox getJCboGenero() {
		if(jboGenero == null) {
			jboGenero = new JComboBox(BIBConstants.ITENS_GENERO);
			jboGenero.setBounds(131, 71, 155, 20);
		}
		return jboGenero;
	}
	
	/**
	 * This method initializes jCboDesativacao
	 * 
	 * @return javax.swing.JComboBox
	 */
	public JComboBox getJCboDesativavao() {
		if(jCboDesativacao == null) {
			jCboDesativacao = new JComboBox(BIBConstants.ITENS_MOTIVO);
			jCboDesativacao.setBounds(165, 215, 186, 21);
			jCboDesativacao.setEnabled(false);
		}
		return jCboDesativacao;
	}
	/**
	 * This method initializes lblValor
	 * 
	 * @return javax.swing.JLabel
	 */
	private javax.swing.JLabel getJLabel3() {
		if(lblValor == null) {
			lblValor = new javax.swing.JLabel();
			lblValor.setSize(101, 20);
			lblValor.setLocation(15, 250);
			lblValor.setText("Valor : ");
		}
		return lblValor;
	}
	/**
	 * This method initializes txtValor
	 * 
	 * @return javax.swing.JTextField
	 */
	public JTextField getTxtValor() {
		if(txtValor == null) {
			txtValor = new JTextField();
			txtValor.setSize(101, 20);
			txtValor.setLocation(130, 250);
		}
		return txtValor;
	}
}

