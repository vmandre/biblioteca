/*
 * Criado em 26/06/2007
 *
 */
package pos.cefet.vma.control;

import java.sql.SQLException;

import pos.cefet.vma.model.Emprestimo;
import pos.cefet.vma.model.Obra;

/**
 * @author Vanderlei Matos Andre
 *
 */
public class CtrlExcluirObra {
	
	public void excluirObra(Obra obra) throws ClassNotFoundException, SQLException {

		//Valida se a obra está desativada para que possa ser excluida
		Emprestimo emprestimo = new Emprestimo();
		
		Obra obraExcluir = obra.getObraById(obra.getId());
		
		if (obraExcluir.getDataDesativacao() != null) {
			//Exclui a obra
			obraExcluir.excluir();

		} else {
			throw new SQLException("Esta obra somente pode ser excluída se estiver desativada!");
		}
	}
}
