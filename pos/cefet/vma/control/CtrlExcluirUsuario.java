/*
 * Criado em 26/06/2007
 *
 */
package pos.cefet.vma.control;

import java.sql.SQLException;

import pos.cefet.vma.model.Emprestimo;
import pos.cefet.vma.model.Endereco;
import pos.cefet.vma.model.Multa;
import pos.cefet.vma.model.Usuario;

/**
 * @author Vanderlei Matos Andre
 *
 */
public class CtrlExcluirUsuario {
	
	public void excluirUsuario(Usuario usuario) throws ClassNotFoundException, SQLException {

		//Valida se o usuário não tem obra emprestrada para que possa ser excluido
		Emprestimo emprestimo = new Emprestimo();
		Multa multa = new Multa();

		if (usuario.getStatus().equals("I"))
			throw new SQLException("Usuário já está desativado!");

		if (emprestimo.getEmprestimosAbertoByUsuario(usuario.getId()).size() == 0) {
			
			if (multa.getMultasByUsuario(usuario.getId()).size() > 0) {
				throw new SQLException("Usuário possui multa(s) pendente(s). Não é possível desativá-lo!");	
			} else {
				//Desativar o usuário
				//usuario.excluir();
				usuario.desativar();
			}

		} else {
			throw new SQLException("Usuário possui obras emprestadas. Não é possível desativá-lo!");
		}
	}
}
