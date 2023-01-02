/*
 * Criado em 26/06/2007
 *
 */
package pos.cefet.vma.control;

import java.sql.SQLException;

import pos.cefet.vma.model.Emprestimo;
import pos.cefet.vma.model.Multa;
import pos.cefet.vma.model.Usuario;

/**
 * @author Vanderlei Matos Andre
 *
 */
public class CtrlExcluirUsuario {
	
	public void excluirUsuario(Usuario usuario) throws ClassNotFoundException, SQLException {

		//Valida se o usu�rio n�o tem obra emprestrada para que possa ser excluido
		Emprestimo emprestimo = new Emprestimo();
		Multa multa = new Multa();

		if (usuario.getStatus().equals("I"))
			throw new SQLException("Usu�rio j� est� desativado!");

		if (emprestimo.getEmprestimosAbertoByUsuario(usuario.getId()).size() == 0) {
			
			if (multa.getMultasByUsuario(usuario.getId()).size() > 0) {
				throw new SQLException("Usu�rio possui multa(s) pendente(s). N�o � poss�vel desativ�-lo!");	
			} else {
				//Desativar o usu�rio
				//usuario.excluir();
				usuario.desativar();
			}

		} else {
			throw new SQLException("Usu�rio possui obras emprestadas. N�o � poss�vel desativ�-lo!");
		}
	}
}
