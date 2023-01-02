/*
 * Criado em 24/06/2007
 */
package pos.cefet.vma.view;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * @author Vanderlei
 */
public class IntUsuarioConsulta extends JInternalFrame {

	private JPanel jContentPane = null;

	private JPanel jPanel = null;
	private JLabel lblMatricula = null;
	private JLabel lblNome = null;
	private JLabel lblCPF = null;
	private JTextField txtMatricula = null;
	private JTextField txtNome = null;
	private JTextField txtCPF = null;
	private javax.swing.JButton btConsultar = null;
	
	private ActionListener ctrlListener = null;

	/**
	 * 
	 */
	public IntUsuarioConsulta(ActionListener ctrlListener) {
		super("Consulta de Usuário", false, true);
		
		this.ctrlListener = ctrlListener;
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(719, 270);
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
			jPanel.add(getJLabel4(), null);
			jPanel.add(getTxtMatricula(), null);
			jPanel.add(getTxtCPF(), null);
			jPanel.add(getJButton(), null);
			jPanel.setBounds(25, 25, 629, 187);
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
			lblMatricula.setText("Matricula:");
			lblMatricula.setLocation(15, 15);
		}
		return lblMatricula;
	}

	/**
	 * This method initializes lblCPF
	 * 
	 * @return JLabel
	 */
	private JLabel getJLabel4() {
		if(lblCPF == null) {
			lblCPF = new JLabel();
			lblCPF.setSize(37, 20);
			lblCPF.setText("CPF:");
			lblCPF.setLocation(316, 16);
		}
		return lblCPF;
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
	 * This method initializes txtCPF
	 * 
	 * @return JTextField
	 */
	public JTextField getTxtCPF() {
		if(txtCPF == null) {
			txtCPF = new JTextField();
			txtCPF.setSize(191, 20);
			txtCPF.setLocation(360, 17);
		}
		return txtCPF;
	}
	/**
	 * This method initializes jButton
	 * 
	 * @return javax.swing.JButton
	 */
	public JButton getJButton() {
		if(btConsultar == null) {
			btConsultar = new JButton();
			btConsultar.setBounds(251, 108, 139, 36);
			btConsultar.setText("Consultar");
			btConsultar.addActionListener(ctrlListener);
		}
		return btConsultar;
	}
}

