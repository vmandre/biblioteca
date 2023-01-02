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
import javax.swing.JTextField;

/**
 * @author Vanderlei
 */
public class IntMultaConsulta extends JInternalFrame {

	private JPanel jContentPane = null;

	private JPanel jPanel = null;
	private JLabel lblMatricula = null;
	private JLabel lblNome = null;
	private JTextField txtMatricula = null;
	private JTextField txtNome = null;
	private javax.swing.JButton btImprimir = null;
	
	private ActionListener ctrlListener = null;

	/**
	 * 
	 */
	public IntMultaConsulta(ActionListener ctrlListener) {
		super("Emiss�o de Multas por Usu�rio", false, true);
		
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
			jPanel.add(getTxtMatricula(), null);
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
			lblMatricula.setSize(126, 20);
			lblMatricula.setText("Matr�cula do Usu�rio : ");
			lblMatricula.setLocation(15, 15);
		}
		return lblMatricula;
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
			txtMatricula.setLocation(150, 16);
		}
		return txtMatricula;
	}
	
	/**
	 * This method initializes jButton
	 * 
	 * @return javax.swing.JButton
	 */
	public JButton getJButton() {
		if(btImprimir == null) {
			btImprimir = new JButton();
			btImprimir.setBounds(251, 90, 139, 36);
			btImprimir.setText("Imprimir");
			btImprimir.addActionListener(ctrlListener);
		}
		return btImprimir;
	}
}

