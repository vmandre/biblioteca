/*
 * Criado em 24/06/2007
 */
package pos.cefet.vma.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JInternalFrame;

import pos.cefet.vma.model.Usuario;
import pos.cefet.vma.utility.BIBMessage;
import pos.cefet.vma.view.IntBibliotecaria;
import pos.cefet.vma.view.IntUsuarioInclusao;

/**
 * @author Vanderlei
 */
public class CtrlIncluirUsuario implements ActionListener {
	
	private IntUsuarioInclusao inclusao = null;

	public JInternalFrame exibirTelaInclusao() {
		inclusao = new IntUsuarioInclusao(this);
		return new IntBibliotecaria().mostrarJanela(inclusao);
	}

	/* (não-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {

		Object object = Usuario.validarDadosUsuario(inclusao);
		if (object instanceof String) {
			if (((String)object) != null) {
				BIBMessage.showError(object);
			}
		} else {
			Usuario usuarioInclusao = (Usuario)object;
			try {
				usuarioInclusao.inserir();
				usuarioInclusao.getEndereco().inserir();
				
				BIBMessage.showInfo("Usuário inserido com sucesso!");
				
			} catch (ClassNotFoundException e1) {
				BIBMessage.showError(e1.getMessage());
			} catch (SQLException e1) {
				BIBMessage.showError(e1.getMessage());
			}
		}		
	}
}
