/*
 * Criado em 27/06/2007
 *
 */
package pos.cefet.vma.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JInternalFrame;

import pos.cefet.vma.model.Multa;
import pos.cefet.vma.utility.BIBMessage;
import pos.cefet.vma.view.IntBibliotecaria;
import pos.cefet.vma.view.IntPagamentoMulta;

/**
 * @author Vanderlei Matos Andre
 *
 */
public class CtrlRegistrarPagamento implements ActionListener {
	
	
	private IntPagamentoMulta multaPagamento;
	private CtrlBiblioteca ctrlBiblioteca;
	public CtrlRegistrarPagamento(CtrlBiblioteca ctrlBiblioteca) {
		this.ctrlBiblioteca = ctrlBiblioteca;
	}
	
	public JInternalFrame exibirTelaPagamentoMulta() {
		multaPagamento = new IntPagamentoMulta(this);
		return new IntBibliotecaria().mostrarJanela(multaPagamento);
	}

	/* (n�o-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Registrar Pagamento")) {
			
			long idMulta = 0;
			try {
				idMulta = Long.parseLong(this.multaPagamento.getJTxtIdMulta().getText());
			}catch(NumberFormatException nfe){BIBMessage.showError("ID inv�lido!");}
						
			if (idMulta != 0) {
				try {

					Multa multa = new Multa();
					Multa multa2 = multa.getMultaById(idMulta);
					
					if (multa2 == null) {
						throw new SQLException("O ID n�o foi encontrado!\nVerifique se digitou corretamente!");
					} else {
						multa2.registrarPagamento();
						BIBMessage.showInfo(
							"Pagamento da multa \""
								+ multa2.getIdMulta()
								+ "\" efetuado com sucesso!");
								
						CtrlEmissaoMultas.imprimirReciboPagamento(multa2);
					}					

				} catch (ClassNotFoundException e1) {
					BIBMessage.showError(e1.getMessage());
				} catch (SQLException e1) {
					BIBMessage.showError(e1.getMessage());
				}
			}						
		}		
	}
}
