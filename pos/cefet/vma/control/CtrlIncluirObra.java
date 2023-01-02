/*
 * Criado em 24/06/2007
 */
package pos.cefet.vma.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

import pos.cefet.vma.model.Obra;
import pos.cefet.vma.utility.BIBMessage;
import pos.cefet.vma.view.IntBibliotecaria;
import pos.cefet.vma.view.IntObraInclusao;

/**
 * @author Vanderlei
 */
public class CtrlIncluirObra implements ActionListener {
	
	private IntObraInclusao inclusao;

	public JInternalFrame exibirTelaInclusao() {
		inclusao = new IntObraInclusao(this);
		return new IntBibliotecaria().mostrarJanela(inclusao);
	}

	/* (não-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {

		Object object = Obra.validarDadosObra(inclusao);
		if (object instanceof String) {
			if (((String)object) != null) {
				BIBMessage.showError(object);
			}
		} else {
			Obra obraInclusao = (Obra)object;
			try {
				obraInclusao.inserir();
				BIBMessage.showInfo("Obra inserida com sucesso!");
				
			} catch (ClassNotFoundException e1) {
				BIBMessage.showError(e1.getMessage());
			} catch (SQLException e1) {
				BIBMessage.showError(e1.getMessage());
			}
		}
	}
}
