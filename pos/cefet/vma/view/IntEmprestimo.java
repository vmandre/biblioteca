/*
 * Criado em 24/06/2007
 */
package pos.cefet.vma.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
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

/**
 * @author Vanderlei
 */
public class IntEmprestimo extends JInternalFrame {

	private JPanel jContentPane = null;

	private JPanel jPanel = null;
	private JLabel lblCodigo = null;
	private JLabel lblMatricula = null;
	private JLabel lblDtEmprestimo = null;
	private JTextField txtCodigo = null;
	private JTextField txtMatricula = null;
	private JTextField txtDtAtivacao = null;
	private javax.swing.JButton btIncluir = null;
	
	private ActionListener ctrlListener = null;

	private javax.swing.JComboBox jboGenero = null;
	private javax.swing.JComboBox jCboDesativacao = null;
	/**
	 * 
	 */
	public IntEmprestimo(ActionListener ctrlListener) {
		super("Empr�stimo de Obra", false, true);
		
		this.ctrlListener = ctrlListener;
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(719, 330);
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
			jPanel.add(getJLabel8(), null);
			jPanel.add(getTxtCodigo(), null);
			jPanel.add(getTxtMatricula(), null);
			jPanel.add(getTxtDtAtivacao(), null);
			jPanel.add(getJButton(), null);
			jPanel.setBounds(25, 25, 629, 196);
			jPanel.setBorder(BorderFactory.createLineBorder(Color.black,1));
		}
		return jPanel;
	}
	/**
	 * This method initializes lblCodigo
	 * 
	 * @return JLabel
	 */
	private JLabel getJLabel() {
		if(lblCodigo == null) {
			lblCodigo = new JLabel();
			lblCodigo.setSize(100, 20);
			lblCodigo.setText("C�digo da Obra :");
			lblCodigo.setLocation(15, 46);
		}
		return lblCodigo;
	}
	/**
	 * This method initializes lblMatricula
	 * 
	 * @return JLabel
	 */
	private JLabel getJLabel1() {
		if(lblMatricula == null) {
			lblMatricula = new JLabel();
			lblMatricula.setSize(100, 20);
			lblMatricula.setText("Matr. do Usu�rio :");
			lblMatricula.setLocation(15, 15);
		}
		return lblMatricula;
	}
	/**
	 * This method initializes lblDtEmprestimo
	 * 
	 * @return JLabel
	 */
	private JLabel getJLabel8() {
		if(lblDtEmprestimo == null) {
			lblDtEmprestimo = new JLabel();
			lblDtEmprestimo.setSize(129, 20);
			lblDtEmprestimo.setText("Data do Empr�stimo :");
			lblDtEmprestimo.setLocation(324, 46);
		}
		return lblDtEmprestimo;
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
			txtCodigo.setLocation(130, 45);
		}
		return txtCodigo;
	}
	/**
	 * This method initializes txtMatricula
	 * 
	 * @return JTextField
	 */
	public JTextField getTxtMatricula() {
		if(txtMatricula == null) {
			txtMatricula = new JTextField();
			txtMatricula.setSize(148, 20);
			txtMatricula.setLocation(130, 16);
		}
		return txtMatricula;
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
			txtDtAtivacao.setLocation(474, 46);
			
			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			txtDtAtivacao.setText(dateFormat.format(calendar.getTime()));
			
			txtDtAtivacao.setEnabled(false);
		}
		return txtDtAtivacao;
	}
	/**
	 * This method initializes jButton
	 * 
	 * @return javax.swing.JButton
	 */
	public JButton getJButton() {
		if(btIncluir == null) {
			btIncluir = new JButton();
			btIncluir.setBounds(245, 114, 155, 36);
			btIncluir.setText("Solicitar Empr�stimo");
			btIncluir.addActionListener(ctrlListener);
		}
		return btIncluir;
	}

}

