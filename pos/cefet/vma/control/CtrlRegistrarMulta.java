/*
 * Criado em 25/06/2007
 *
 */
package pos.cefet.vma.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import pos.cefet.vma.model.Emprestimo;
import pos.cefet.vma.model.Multa;
import pos.cefet.vma.model.Obra;

/**
 * @author Vanderlei Matos Andre
 *
 */
public class CtrlRegistrarMulta {
	
	private Emprestimo emprestimo;
	private Obra obra;
	private int diasAtraso;
	private int idUsuario;
	
	/**
	 * 
	 * @param emprestimo
	 * @param diasAtraso Se a quantidade de dias de atraso for ZERO, será emitida a multa por extravio
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws IOException
	 */
	public Multa registrarMulta(Emprestimo emprestimo, int diasAtraso) throws ClassNotFoundException, SQLException, IOException{
		this.emprestimo = emprestimo;
		this.diasAtraso = diasAtraso;
		
		Multa multa = new Multa(emprestimo, diasAtraso);
		multa.createMulta();
		
		return multa;		
	}		
}
