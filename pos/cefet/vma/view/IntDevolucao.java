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
public class IntDevolucao extends JInternalFrame {

	private JPanel jContentPane = null;

	private JPanel jPanel = null;
	private JLabel lblCodigo = null;
	private JLabel lblDtEmprestimo = null;
	private JTextField txtCodigo = null;
	private JTextField txtMatricula = null;
	private JTextField txtDtAtivacao = null;
	private javax.swing.JButton btDevolver = null;
	
	private ActionListener ctrlListener = null;

	private javax.swing.JComboBox jboGenero = null;
	private javax.swing.JComboBox jCboDesativacao = null;
	/**
	 * 
	 */
	public IntDevolucao(ActionListener ctrlListener) {
		super("Devolução de Obra", false, true);
		
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
			jPanel.add(getJLabel8(), null);
			jPanel.add(getTxtCodigo(), null);
			jPanel.add(getTxtDtDevolucao(), null);
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
			lblCodigo.setText("Código da Obra :");
			lblCodigo.setLocation(15, 15);
		}
		return lblCodigo;
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
			lblDtEmprestimo.setText("Data do Devolução :");
			lblDtEmprestimo.setLocation(324, 15);
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
			txtCodigo.setLocation(130, 16);
		}
		return txtCodigo;
	}

	/**
	 * This method initializes txtDtAtivacao
	 * 
	 * @return JTextField
	 */
	public JTextField getTxtDtDevolucao() {
		if(txtDtAtivacao == null) {
			txtDtAtivacao = new JTextField();
			txtDtAtivacao.setSize(101, 20);
			txtDtAtivacao.setLocation(474, 15);
			
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
		if(btDevolver == null) {
			btDevolver = new JButton();
			btDevolver.setBounds(244, 88, 155, 36);
			btDevolver.setText("Registrar Devolução");
			btDevolver.addActionListener(ctrlListener);
		}
		return btDevolver;
	}

}

