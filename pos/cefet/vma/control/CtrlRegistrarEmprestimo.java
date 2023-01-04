/*
 * Criado em 24/06/2007
 */
package pos.cefet.vma.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import pos.cefet.vma.model.Emprestimo;

/**
 * @author Vanderlei
 */
public class CtrlRegistrarEmprestimo implements ActionListener {
	
	public void registrarEmprestimo(int idUsuario, int idObra) throws ClassNotFoundException, SQLException {
		Emprestimo emprestimo = new Emprestimo();
		emprestimo.setIdUsuario(idUsuario);
		emprestimo.setIdObra(idObra);
		emprestimo.registrarEmprestimo();
	}

	/* (não-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		
	}

}
