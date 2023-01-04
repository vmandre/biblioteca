/*
 * Criado em 24/06/2007
 */
package pos.cefet.vma.control;

import java.sql.SQLException;

import pos.cefet.vma.constants.BIBConstants;
import pos.cefet.vma.model.Emprestimo;
import pos.cefet.vma.model.Multa;
import pos.cefet.vma.model.Obra;
import pos.cefet.vma.model.Usuario;

/**
 * @author Vanderlei
 */
public class CtrlConsultarDevolucao {
	
	public String consultarPendencia(int idUsuario, int idObra) throws ClassNotFoundException, SQLException {	
		
		Usuario usuario = new Usuario();
		
		Usuario usuario2 = usuario.getUsuarioById(idUsuario);
		if (usuario2 == null )
			return "Usuário não está cadastrado!";
		
		if (usuario2.getStatus().equals("I"))
			return "Usuário está Inativo no sistema e não pode realizar empréstimo!";
			
		Multa multa = new Multa();
		if (multa.getMultasByUsuario(usuario2.getId()).size() > 0 ) {
			return "Usuário possui multa(s) pendente(s) e não fazer \n" +				"empréstimo até que efetue o pagamento!";	
		}
			
		Obra obra = new Obra();
		Obra obra2 = obra.getObraById(idObra);
		if (obra2 == null)
			return "Obra não está cadastrada!";
		else if (obra2.getDataDesativacao() != null) {
			return "Esta obra está desativada e não pode ser emprestada!";	
		}
			
		Emprestimo emprestimo = new Emprestimo();
		if (emprestimo.getEmprestimoAberto(idObra) != null)
			return "Esta obra já está emprestada!";
			
		if (emprestimo.getEmprestimosAbertoByUsuario(idUsuario).size() >= BIBConstants.LIMITE_EMPRESTIMO)
			return "Usuário já emprestou o limite permitido de obras : " + BIBConstants.LIMITE_EMPRESTIMO;		
			
		int emprestimosAtrasados = emprestimo.getEmprestimosAtrasadosByUsuario(usuario2.getId()).size();	
		if (emprestimosAtrasados == BIBConstants.LIMITE_EMPRESTIMO) {
			return "Usuário possui "+emprestimosAtrasados+" obras emprestadas com a devolução atrasada!";	
		}
		
		return null;
	}

}
