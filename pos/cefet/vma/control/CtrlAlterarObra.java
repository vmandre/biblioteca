/*
 * Criado em 25/06/2007
 *
 */
package pos.cefet.vma.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JInternalFrame;

import pos.cefet.vma.constants.BIBConstants;
import pos.cefet.vma.model.Emprestimo;
import pos.cefet.vma.model.Multa;
import pos.cefet.vma.model.Obra;
import pos.cefet.vma.utility.BIBMessage;
import pos.cefet.vma.view.IntBibliotecaria;
import pos.cefet.vma.view.IntObraAlteracao;

/**
 * @author Vanderlei Matos Andre
 *
 */
public class CtrlAlterarObra implements ActionListener {
	
	private IntObraAlteracao alteracao;
	private ActionListener listener;
	private Obra obra;

	public CtrlAlterarObra(Obra obra) {
		this.obra = obra;		
	}
	
	//Recebe o listener do CtrlBiblioteca
	public CtrlAlterarObra(ActionListener listener) {		
		this.listener = listener;
	}
	
	public JInternalFrame exibirTelaAlteracao() {
		alteracao = new IntObraAlteracao(this, obra);
		return new IntBibliotecaria().mostrarJanela(alteracao);
	}

	/* (não-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("Confirmar")) {

			if (obra.getDataDesativacao() != null) {
				BIBMessage.showError(
					"Esta obra já está desativada e não pode ser alterada!");
			} else {
				Object object = Obra.validarDadosObra(alteracao);
				if (object instanceof String) {
					if (((String) object) != null) {
						BIBMessage.showError(object);
					}
				} else {
					Obra obraAlteracao = (Obra) object;

					//Recupera os valores selecionados pelo usuário na tela
					obraAlteracao.setMotivoDesativacao(
						this.alteracao.getJCboDesativavao().getSelectedIndex());
					obraAlteracao.setGenero(
						this.alteracao.getJCboGenero().getSelectedIndex());

					try {

						//Se o motivo da desativação da obra for Extravio, será gerada a multa para o usuário
						if (obraAlteracao.getMotivoDesativacao() == BIBConstants.CODIGO_EXTRAVIO) {
							BIBMessage.showWarning(
								"A desativação desta obra por Extravio irá gerar a multa para o usuário \n" +								"que a emprestou caso haja um empréstimo registrado para a obra!");							 

							Emprestimo emprestimo = new Emprestimo();
							Emprestimo emprestimo2 = emprestimo.getEmprestimoAberto(obraAlteracao.getId());

							if (emprestimo2 != null) {

							CtrlRegistrarMulta ctrlRegistrarMulta = new CtrlRegistrarMulta();

								Multa multa =
									ctrlRegistrarMulta.registrarMulta(
										emprestimo2,
										0);

								CtrlEmissaoMultas.imprimirMulta(multa);																					
							}					
						}
						
						obraAlteracao.alterar();
						BIBMessage.showInfo("Obra alterada com sucesso!");
						this.alteracao.dispose();
						this.alteracao.repaint();
						
					} catch (ClassNotFoundException e1) {
						BIBMessage.showError(e1.getMessage());
					} catch (SQLException e1) {
						BIBMessage.showError(e1.getMessage());
					} catch (IOException e2) {
						BIBMessage.showError(e2.getMessage());
					}
				}
			}
		}
	}
}
