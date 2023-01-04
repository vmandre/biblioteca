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
public class IntObraConsulta extends JInternalFrame {

	private JPanel jContentPane = null;

	private JPanel jPanel = null;
	private JLabel lblCodigo = null;
	private JLabel lblNome = null;
	private JTextField txtCodigo = null;
	private JTextField txtNome = null;
	private javax.swing.JButton btConsultar = null;
	
	private ActionListener ctrlListener = null;

	/**
	 * 
	 */
	public IntObraConsulta(ActionListener ctrlListener) {
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
			jPanel.add(getTxtCodigo(), null);
			jPanel.add(getJButton(), null);
			jPanel.setBounds(25, 25, 629, 187);
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
			lblCodigo.setText("Código da Obra:");
			lblCodigo.setLocation(15, 15);
		}
		return lblCodigo;
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
	 * This method initializes jButton
	 * 
	 * @return javax.swing.JButton
	 */
	public JButton getJButton() {
		if(btConsultar == null) {
			btConsultar = new JButton();
			btConsultar.setBounds(251, 90, 139, 36);
			btConsultar.setText("Consultar");
			btConsultar.addActionListener(ctrlListener);
		}
		return btConsultar;
	}
}

