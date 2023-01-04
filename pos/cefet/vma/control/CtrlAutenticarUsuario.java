/*
 * Criado em 22/06/2007
 *
 */
package pos.cefet.vma.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JInternalFrame;

import pos.cefet.vma.model.Usuario;
import pos.cefet.vma.utility.BIBMessage;
import pos.cefet.vma.view.IntUsuario;

/**
 * @author Vanderlei Matos Andre
 *
 */
public class CtrlAutenticarUsuario implements ActionListener {
	
	private Usuario usuario;
	private IntUsuario intUsuario; 
	private JInternalFrame frmAutenticacao;
	
	public CtrlAutenticarUsuario() {
		intUsuario = new IntUsuario("Autenticação do Usuario", false, true, this);		
		usuario = new Usuario();
		
		frmAutenticacao = intUsuario.mostrarJanelaAutenticacao();
		
	}

	/**
	 * @return
	 */
	public IntUsuario getIntUsuario() {
		return intUsuario;
	}

	/**
	 * @return
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario
	 */
	public void setIntUsuario(IntUsuario usuario) {
		intUsuario = usuario;
	}

	/**
	 * @param usuario
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/* (não-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() instanceof JButton) {
			JButton botao = (JButton)e.getSource();
			
			if (botao.getActionCommand().equals("Confirmar")) {
				try {
					int id = Integer.parseInt(this.getIntUsuario().getLogin().getText());
					String pwd = new String(this.getIntUsuario().getPassword().getPassword());
					
					Usuario userLogado = this.getUsuario().getUsuarioByIdAndPwd(id, pwd);
					
					if (userLogado == null) {
						BIBMessage.showError("Usuario não autenticado!");
					}
						
				} catch (NumberFormatException e1) {
					BIBMessage.showError("Usuario invãlido!");
				} catch (ClassNotFoundException e2) {					
					BIBMessage.showError(e2);
				} catch (SQLException e3) {
					BIBMessage.showError(e3);
				}
			}
		}
		
	}



}
