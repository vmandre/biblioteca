/*
 * Criado em 25/06/2007
 *
 */
package pos.cefet.vma.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JInternalFrame;

import pos.cefet.vma.model.Usuario;
import pos.cefet.vma.utility.BIBMessage;
import pos.cefet.vma.view.IntBibliotecaria;
import pos.cefet.vma.view.IntUsuarioAlteracao;

/**
 * @author Vanderlei Matos Andre
 *
 */
public class CtrlAlterarUsuario implements ActionListener {
	
	private IntUsuarioAlteracao alteracao;
	private ActionListener listener;
	private Usuario usuario;

	public CtrlAlterarUsuario(Usuario usuario) {
		this.usuario = usuario;		
	}
	
	//Recebe o listener do CtrlBiblioteca
	public CtrlAlterarUsuario(ActionListener listener) {		
		this.listener = listener;
	}
	
	public JInternalFrame exibirTelaAlteracao() {
		alteracao = new IntUsuarioAlteracao(this, usuario);
		return new IntBibliotecaria().mostrarJanela(alteracao);
	}

	/* (não-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {

		Object object = Usuario.validarDadosUsuario(alteracao);
		if (object instanceof String) {
			if (((String)object) != null) {
				BIBMessage.showError(object);
			}
		} else {
			Usuario usuarioAlteracao = (Usuario)object;
			try {
				usuarioAlteracao.alterar();
				usuarioAlteracao.getEndereco().alterar();				
				BIBMessage.showInfo("Usuásrio alterado com sucesso!");
								
			} catch (ClassNotFoundException e1) {
				BIBMessage.showError(e1);
			} catch (SQLException e1) {
				BIBMessage.showError(e1);
			}
		}						
	}
}
