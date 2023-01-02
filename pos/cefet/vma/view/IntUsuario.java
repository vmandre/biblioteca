/*
 * Criado em 22/06/2007
 *
 */
package pos.cefet.vma.view;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * @author Vanderlei Matos Andre
 *
 */
//public class IntUsuario extends JInternalFrame {
public class IntUsuario {

	private JInternalFrame frmAutenticacao;
	private JLabel lblLogin;
	private JTextField login;
	private JLabel lblPass;
	private JPasswordField password;
	private JButton btConfirmar;
	private JPanel panel;
	
	private ActionListener listenerControl;
	
	/**
	 * @param title
	 * @param resizable
	 * @param closable
	 */
	public IntUsuario(String title, boolean resizable, boolean closable, ActionListener listenerControl) {
		this.listenerControl = listenerControl;
	}

	public JInternalFrame mostrarJanelaAutenticacao() {
		frmAutenticacao = new JInternalFrame("Autenticação", false, true);
		frmAutenticacao.setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
		frmAutenticacao.setSize(250, 150);
		frmAutenticacao.setLocation(250, 150);

		panel = new JPanel();
		panel.setLayout(null);
		
		lblLogin = new JLabel("Login:");
		lblLogin.setBounds(10, 10, 50, 20);
		login = new JTextField(20);
		login.setBounds(80, 10, 100, 20);
		
		lblPass = new JLabel("Password:");
		lblPass.setBounds(10, 40, 70, 20);
		password = new JPasswordField(20);
		password.setBounds(80, 40, 120, 20);
		
		btConfirmar = new JButton("Confirmar");
		btConfirmar.setBounds(65, 80, 100, 25);
		btConfirmar.addActionListener(listenerControl);
		
		panel.add(lblLogin);
		panel.add(login);
		panel.add(lblPass);
		panel.add(password);
		panel.add(new JPanel().add(btConfirmar));
		
		frmAutenticacao.getContentPane().add(panel);
		frmAutenticacao.setVisible(true);
		
		return frmAutenticacao;
	}

	public void fecharJanela() {
		frmAutenticacao.setVisible(false);
	}

	/**
	 * @return
	 */
	public JTextField getLogin() {
		return login;
	}

	/**
	 * @return
	 */
	public JPasswordField getPassword() {
		return password;
	}

	/**
	 * @param field
	 */
	public void setLogin(JTextField field) {
		login = field;
	}

	/**
	 * @param field
	 */
	public void setPassword(JPasswordField field) {
		password = field;
	}

}
