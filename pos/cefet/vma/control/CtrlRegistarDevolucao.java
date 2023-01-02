/*
 * Criado em 24/06/2007
 */
package pos.cefet.vma.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

import pos.cefet.vma.component.MultaArquivo;
import pos.cefet.vma.constants.BIBConstants;
import pos.cefet.vma.model.Emprestimo;
import pos.cefet.vma.model.Multa;
import pos.cefet.vma.model.Obra;
import pos.cefet.vma.model.Usuario;
import pos.cefet.vma.utility.BIBMessage;
import pos.cefet.vma.utility.BIBUtility;
import pos.cefet.vma.view.IntBibliotecaria;
import pos.cefet.vma.view.IntDevolucao;

/**
 * @author Vanderlei
 */
public class CtrlRegistarDevolucao implements ActionListener {
	
	private IntDevolucao devolucao;
	
	public JInternalFrame exibirTelaDevolucaoObra() {
		devolucao = new IntDevolucao(this);
		return new IntBibliotecaria().mostrarJanela(devolucao);
	}
	
	/* (não-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		Emprestimo emprestimo = new Emprestimo();

		try {
			
			Obra obra = new Obra();
			if (obra.getObraById(Integer.parseInt(this.devolucao.getTxtCodigo().getText())) == null) {
				BIBMessage.showError("Obra não cadastrada!");
			} else {
				Emprestimo emprestimo2 =
					emprestimo.getEmprestimoAberto(
						Integer.parseInt(
							this.devolucao.getTxtCodigo().getText()));
				if (emprestimo2 == null) {
					BIBMessage.showError("Obra não está emprestrada!");
				} else {
					/*
					 * Verifica os emprestimos que estao em aberto e a data de 
					 * emprestimo. Se for a diferenca for maior que o 
					 * limite_dias_emprestimo, gera multa e mostrar na tela. 
					 */
					Calendar dataLimiteDevolucao = Calendar.getInstance();
					dataLimiteDevolucao.setTime(emprestimo2.getDtEmprestimo());
					dataLimiteDevolucao.set(Calendar.DAY_OF_MONTH, 
						dataLimiteDevolucao.get(Calendar.DAY_OF_MONTH) + BIBConstants.LIMITE_DIAS_EMPRESTIMO); //Acrescenta os dias de limite de emprestimo à data do emprestimo para comparar com a data da devolução
					
					Calendar dataAtual = Calendar.getInstance();
					dataAtual.set(Calendar.DAY_OF_MONTH, 
						dataAtual.get(Calendar.DAY_OF_MONTH) + 1); // Conta um dia a mais para registrar a multa. O usuario pode devolver o livro até o fechamento da biblioteca no dia do vencimento

					//Verifica se a devolução da obra está atrasada
					if (dataAtual.after(dataLimiteDevolucao)) {
						int diasDeAtraso = (dataAtual.get(Calendar.DAY_OF_MONTH) 
							- dataLimiteDevolucao.get(Calendar.DAY_OF_MONTH)) - 1;

						BIBMessage.showWarning(
							"A devolução desta obra está  "
								+ diasDeAtraso
								+ "  dia(s) atrasado(s)!\nSerá gerada a multa referente aos dias atrasados!");
							 

						CtrlRegistrarMulta ctrlRegistrarMulta = new CtrlRegistrarMulta();
						try {
							Multa multa =
								ctrlRegistrarMulta.registrarMulta(
									emprestimo2,
									diasDeAtraso);
							
							CtrlEmissaoMultas.imprimirMulta(multa);
															
						} catch (IOException e1) {
							BIBMessage.showError(e1.getMessage());
						}
					}
					
					//Registra a devolução da obra
					emprestimo2.registrarDevolucao();
					BIBMessage.showInfo("Devolução efetuada com sucesso!");
				}
			}

		} catch (NumberFormatException nfe){
			BIBMessage.showError("O código da Obra é inválido!");
		} catch (ClassNotFoundException e1) {
			BIBMessage.showError(e1.getMessage());
		} catch (SQLException e2) {
			BIBMessage.showError(e2.getMessage());
		}
	}
}
