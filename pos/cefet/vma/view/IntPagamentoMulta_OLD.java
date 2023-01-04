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
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author Vanderlei
 */
public class IntPagamentoMulta_OLD extends JInternalFrame {

	private JPanel jContentPane = null;

	private JPanel jPanel = null;
	private JLabel lblCodigo = null;
	private JLabel lblMatricula = null;
	private JLabel lblDtPagamento = null;
	private JTextField txtCodigo = null;
	private JTextField txtMatricula = null;
	private JTextField txtDtPagamento = null;
	private javax.swing.JButton btIncluir = null;
	
	private ActionListener ctrlListener = null;

	private javax.swing.JComboBox jboGenero = null;
	private javax.swing.JComboBox jCboDesativacao = null;
	private javax.swing.JLabel jLabel = null;
	private javax.swing.JTextField jTextField = null;
	/**
	 * 
	 */
	public IntPagamentoMulta_OLD(ActionListener ctrlListener) {
		super("Pagamento de Multa", false, true);
		
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
			jPanel.add(getTxtDtPagamento(), null);
			jPanel.add(getJButton(), null);
			jPanel.add(getJLabel2(), null);
			jPanel.add(getJTextField(), null);
			jPanel.setBounds(25, 25, 629, 239);
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
			lblCodigo.setText("Código da Obra :");
			lblCodigo.setLocation(15, 106);
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
			lblMatricula.setText("Matr. do Usuário :");
			lblMatricula.setLocation(15, 75);
		}
		return lblMatricula;
	}
	/**
	 * This method initializes lblDtPagamento
	 * 
	 * @return JLabel
	 */
	private JLabel getJLabel8() {
		if(lblDtPagamento == null) {
			lblDtPagamento = new JLabel();
			lblDtPagamento.setSize(129, 20);
			lblDtPagamento.setText("Data do Pagamento :");
			lblDtPagamento.setLocation(324, 106);
		}
		return lblDtPagamento;
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
			txtCodigo.setLocation(130, 105);
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
			txtMatricula.setLocation(130, 76);
		}
		return txtMatricula;
	}
	/**
	 * This method initializes txtDtPagamento
	 * 
	 * @return JTextField
	 */
	public JTextField getTxtDtPagamento() {
		if(txtDtPagamento == null) {
			txtDtPagamento = new JTextField();
			txtDtPagamento.setSize(101, 20);
			txtDtPagamento.setLocation(474, 106);
			
			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			txtDtPagamento.setText(dateFormat.format(calendar.getTime()));
			
			txtDtPagamento.setEnabled(false);
		}
		return txtDtPagamento;
	}
	/**
	 * This method initializes jButton
	 * 
	 * @return javax.swing.JButton
	 */
	public JButton getJButton() {
		if(btIncluir == null) {
			btIncluir = new JButton();
			btIncluir.setBounds(245, 174, 155, 36);
			btIncluir.setText("Registrar Pagamento");
			btIncluir.addActionListener(ctrlListener);
		}
		return btIncluir;
	}

	/**
	 * This method initializes jLabel
	 * 
	 * @return javax.swing.JLabel
	 */
	private JLabel getJLabel2() {
		if(jLabel == null) {
			jLabel = new JLabel();
			jLabel.setBounds(15, 40, 100, 20);
			jLabel.setText("ID Multa : ");
		}
		return jLabel;
	}
	/**
	 * This method initializes jTextField
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextField() {
		if(jTextField == null) {
			jTextField = new JTextField();
			jTextField.setBounds(130, 40, 243, 20);
		}
		return jTextField;
	}
}

