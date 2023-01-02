/*
 * Criado em 24/06/2007
 */
package pos.cefet.vma.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JInternalFrame;

import pos.cefet.vma.utility.BIBMessage;
import pos.cefet.vma.view.IntBibliotecaria;
import pos.cefet.vma.view.IntEmprestimo;

/**
 * @author Vanderlei
 */
public class CtrlSolicitarEmprestimo implements ActionListener {
	
	private IntEmprestimo emprestimo;

	private IntBibliotecaria intBibliotecaria;

	public JInternalFrame exibirTelaEmprestimo() {
		emprestimo = new IntEmprestimo(this);
		return new IntBibliotecaria().mostrarJanela(emprestimo);
	}

	/* (n�o-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		
		boolean podeConsultar = false;
		String matricula = emprestimo.getTxtMatricula().getText();
		String codigo = emprestimo.getTxtCodigo().getText();	
			
		if (validarCampos(matricula, codigo)) {
			CtrlConsultarDevolucao ctrlConsultarDevolucao =
				new CtrlConsultarDevolucao();

			String msgRetConsulta = null;
			try {
				msgRetConsulta =
					ctrlConsultarDevolucao.consultarPendencia(
						Integer.parseInt(matricula),
						Integer.parseInt(codigo));
			} catch (NumberFormatException e1) {
				msgRetConsulta = "Matr�cula ou c�digo da Obra inv�lidos!";
			} catch (ClassNotFoundException e1) {
				msgRetConsulta = e1.toString();
			} catch (SQLException e1) {
				msgRetConsulta = e1.toString();
			}
			
			if (msgRetConsulta != null) {
				BIBMessage.showError(msgRetConsulta);				
			} else {
				CtrlRegistrarEmprestimo ctrlRegistrarEmprestimo =
					new CtrlRegistrarEmprestimo();
				try {
					ctrlRegistrarEmprestimo.registrarEmprestimo(
						Integer.parseInt(matricula),
						Integer.parseInt(codigo));
					BIBMessage.showInfo("Empr�stimo realizado com sucesso!");					
				} catch (NumberFormatException e2) {
					BIBMessage.showError(
						"Matr�cula ou c�digo da Obra inv�lidos!");
				} catch (ClassNotFoundException e2) {
					BIBMessage.showError(e2.getMessage());
				} catch (SQLException e2) {
					BIBMessage.showError(e2.getMessage());
				}
			}
		}		
	}
	
	private boolean validarCampos(String matricula, String codigo) {		

		if (matricula.equals("")) {	
			BIBMessage.showError("Preencha o campo Matr�cula do Usu�rio!");
			return false;
		} else if (codigo.equals("")) {
			BIBMessage.showError("Preencha o campo C�digo da Obra!");
			return false;
		}
			
		int matrUsuario;
		try {
			matrUsuario = Integer.parseInt(matricula);	
		} catch (NumberFormatException nfe) {
			BIBMessage.showError("A Matr�cula do Usu�rio deve ser somente n�meros!");
			return false;
		}

		int codObra;
		try {
			codObra = Integer.parseInt(codigo);	
		} catch (NumberFormatException nfe) {
			BIBMessage.showError("O c�digo da Obra deve ser somente n�meros!");
			return false;
		}		
		return true;
	}
}
