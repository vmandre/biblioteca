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
public class IntPagamentoMulta extends JInternalFrame {

	private JPanel jContentPane = null;

	private JPanel jPanel = null;
	private JLabel lblDtPagamento = null;
	private JTextField txtDtPagamento = null;
	private javax.swing.JButton btIncluir = null;
	
	private ActionListener ctrlListener = null;

	private javax.swing.JComboBox jboGenero = null;
	private javax.swing.JComboBox jCboDesativacao = null;
	private javax.swing.JLabel jLabel = null;
	private javax.swing.JTextField txtIdMulta = null;
	/**
	 * 
	 */
	public IntPagamentoMulta(ActionListener ctrlListener) {
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
			jPanel.add(getJLabel8(), null);
			jPanel.add(getTxtDtPagamento(), null);
			jPanel.add(getJButton(), null);
			jPanel.add(getJLabel2(), null);
			jPanel.add(getJTxtIdMulta(), null);
			jPanel.setBounds(25, 25, 629, 225);
			jPanel.setBorder(BorderFactory.createLineBorder(Color.black,1));
		}
		return jPanel;
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
			lblDtPagamento.setLocation(15, 74);
		}
		return lblDtPagamento;
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
			txtDtPagamento.setLocation(160, 74);
			
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
			btIncluir.setBounds(243, 152, 155, 36);
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
	 * This method initializes txtIdMulta
	 * 
	 * @return javax.swing.JTextField
	 */
	public JTextField getJTxtIdMulta() {
		if(txtIdMulta == null) {
			txtIdMulta = new JTextField();
			txtIdMulta.setBounds(160, 40, 243, 20);
		}
		return txtIdMulta;
	}
}

