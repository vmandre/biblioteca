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
			return "Usu�rio n�o est� cadastrado!";
		
		if (usuario2.getStatus().equals("I"))
			return "Usu�rio est� Inativo no sistema e n�o pode realizar empr�stimo!";
			
		Multa multa = new Multa();
		if (multa.getMultasByUsuario(usuario2.getId()).size() > 0 ) {
			return "Usu�rio possui multa(s) pendente(s) e n�o fazer \n" +				"empr�stimo at� que efetue o pagamento!";	
		}
			
		Obra obra = new Obra();
		Obra obra2 = obra.getObraById(idObra);
		if (obra2 == null)
			return "Obra n�o est� cadastrada!";
		else if (obra2.getDataDesativacao() != null) {
			return "Esta obra est� desativada e n�o pode ser emprestada!";	
		}
			
		Emprestimo emprestimo = new Emprestimo();
		if (emprestimo.getEmprestimoAberto(idObra) != null)
			return "Esta obra j� est� emprestada!";
			
		if (emprestimo.getEmprestimosAbertoByUsuario(idUsuario).size() >= BIBConstants.LIMITE_EMPRESTIMO)
			return "Usu�rio j� emprestou o limite permitido de obras : " + BIBConstants.LIMITE_EMPRESTIMO;		
			
		int emprestimosAtrasados = emprestimo.getEmprestimosAtrasadosByUsuario(usuario2.getId()).size();	
		if (emprestimosAtrasados == BIBConstants.LIMITE_EMPRESTIMO) {
			return "Usu�rio possui "+emprestimosAtrasados+" obras emprestadas com a devolu��o atrasada!";	
		}
		
		return null;
	}

}
