/*
 * Criado em 26/06/2007
 *
 */
package pos.cefet.vma.interfaces;

import javax.swing.JCheckBox;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * @author Vanderlei Matos Andre
 *
 */
public interface InterfaceUsuario {
	
	public JTextField getTxtMatricula();
	public JTextField getTxtNome();
	public JTextField getTxtCPF();
	public JPasswordField getTxtSenha1();
	public JPasswordField getTxtSenha2();
	public JTextField getTxtDataNasc();
	public JTextField getTxtLogradouro();
	public JTextField getTxtNumero();
	public JTextField getTxtBairro();
	public JTextField getTxtComplemento();
	public JTextField getTxtEmail();
	public JTextField getTxtCEP();
	public JTextField getTxtUF();
	public JTextField getTxtCidade();
	public JTextField getTxtDDD();
	public JTextField getTxtTelCont();
	public JTextField getTxtTelCel();
	public JTextField getTxtTelCom();
	public JCheckBox getJChkAtivo();

}
