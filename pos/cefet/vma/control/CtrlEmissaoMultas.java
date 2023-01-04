/*
 * Criado em 27/06/2007
 *
 */
package pos.cefet.vma.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JInternalFrame;

import pos.cefet.vma.component.MultaArquivo;
import pos.cefet.vma.component.MultaArquivoReciboPagamento;
import pos.cefet.vma.constants.BIBConstants;
import pos.cefet.vma.model.Multa;
import pos.cefet.vma.model.Obra;
import pos.cefet.vma.model.Usuario;
import pos.cefet.vma.utility.BIBMessage;
import pos.cefet.vma.utility.BIBUtility;
import pos.cefet.vma.view.IntBibliotecaria;
import pos.cefet.vma.view.IntMultaConsulta;

/**
 * @author Vanderlei Matos Andre
 *
 */
public class CtrlEmissaoMultas implements ActionListener {
	
	private IntMultaConsulta multaConsulta;

	private CtrlBiblioteca ctrlBiblioteca;
	
	public CtrlEmissaoMultas(CtrlBiblioteca ctrlBiblioteca) {
		this.ctrlBiblioteca = ctrlBiblioteca;
	}
	
	public JInternalFrame exibirTelaConsultaMultas() {
		multaConsulta = new IntMultaConsulta(this);
		return new IntBibliotecaria().mostrarJanela(multaConsulta);
	}

	/* (não-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Imprimir")) {
			String matricula = this.multaConsulta.getTxtMatricula().getText();
			int idUser;
						
			try {
				idUser = Integer.parseInt(matricula);
				
				Usuario usuario = new Usuario();
				Usuario usuario2 = usuario.getUsuarioById(idUser);
				if (usuario2 == null) {
					throw new SQLException("Usuário não cadastrado!");
				}
							
				Multa multas = new Multa();				
				ArrayList arrayList = multas.getMultasByUsuario(idUser);
				if (arrayList.size() == 0) { 
					throw new SQLException("Não existe multas para este usuário!");
				} else {
					int qtdeMultas = arrayList.size();
					//Aviso da quantidade de multas do usuário
					BIBMessage.showWarning("Serão emitidas " + qtdeMultas + " multas pendentes para este usuário!");
					
					for (int i = 0; i  < qtdeMultas; i++) {
						
						Multa multa = (Multa) arrayList.get(i);						
						CtrlEmissaoMultas.imprimirMulta(multa);
					}
				}
				
			} catch (NumberFormatException e2) {
				BIBMessage.showError("Matrícula inválida!");
			} catch (ClassNotFoundException e1) {
				BIBMessage.showError(e1.getMessage());
			} catch (SQLException e1) {
				BIBMessage.showError(e1.getMessage());
			}
			
		}
		
	}
	
	public static void imprimirMulta(Multa multa) {
		try {
			MultaArquivo multaArquivo = new MultaArquivo();
			Calendar dataHoraEmissao = Calendar.getInstance();
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy - HH:mm");
			
			Obra obra1 = new Obra();
			Obra obra = obra1.getObraById(multa.getIdObra());
						
			//Busca informações do Usuario
			Usuario usuario1 = new Usuario();
			Usuario usuario2 = usuario1.getUsuarioById(multa.getIdUsuario());
								
			//Seta os parâmetros para a impressão da multa
			multaArquivo.getJLblIdMulta().setText(""+multa.getIdMulta());
			multaArquivo.getJLblDataHoraEmissao().setText(dateFormat.format(dataHoraEmissao.getTime()).trim());
			multaArquivo.getJLblNomeUsuario().setText(usuario2.getId() + " - " + usuario2.getNome().trim());
			multaArquivo.getJLblNomeObra().setText(obra.getId() + " - " + obra.getDescricao().trim());
			multaArquivo.getJLblValor().setText(BIBUtility.converterDoubleToMoeda(multa.getValor()));
			
			if (multa.getMotivo() == 'A') {
				String msg = BIBConstants.MSG_ATRASO;					
				multaArquivo.getJLblReferencia().setText(msg.replaceFirst("XX" , ""+multa.getDiasAtraso()));
			} else {
				multaArquivo.getJLblReferencia().setText(BIBConstants.MSG_EXTRAVIO);
			}			
														
			multaArquivo.setVisible(true);	
		} catch (ClassNotFoundException e) {
			BIBMessage.showError(e.getMessage());
		} catch (SQLException e) {
			BIBMessage.showError(e.getMessage());
		}
	}
	
	public static void imprimirReciboPagamento(Multa multa) {
		MultaArquivoReciboPagamento multaArquivoRecibo = new MultaArquivoReciboPagamento();
		Calendar dataHoraEmissao = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy - HH:mm");
			
		try {
			Obra obra1 = new Obra();
			Obra obra = obra1.getObraById(multa.getIdObra());
							
			//Busca informações do Usuario
			Usuario usuario1 = new Usuario();
			Usuario usuario2 = usuario1.getUsuarioById(multa.getIdUsuario());
									
			//Seta os parâmetros para a impressão da multa
			multaArquivoRecibo.getJLblIdMulta().setText(""+multa.getIdMulta());
			//multaArquivo.getJLblDataHoraEmissao().setText(dateFormat.format(dataHoraEmissao.getTime()).trim());
			multaArquivoRecibo.getJLblDataHoraEmissao().setText(dateFormat.format(dataHoraEmissao.getTime()).trim());
			multaArquivoRecibo.getJLblNomeUsuario().setText(usuario2.getId() + " - " + usuario2.getNome().trim());
			multaArquivoRecibo.getJLblNomeObra().setText(obra.getId() + " - " + obra.getDescricao().trim());
			multaArquivoRecibo.getJLblValor().setText(BIBUtility.converterDoubleToMoeda(multa.getValor()));
				
			if (multa.getMotivo() == 'A') {
				String msg = BIBConstants.MSG_ATRASO;					
				multaArquivoRecibo.getJLblReferencia().setText(msg.replaceFirst("XX" , ""+multa.getDiasAtraso()));
			} else {
				multaArquivoRecibo.getJLblReferencia().setText(BIBConstants.MSG_EXTRAVIO);
			}			
															
			multaArquivoRecibo.setVisible(true);	

		} catch (ClassNotFoundException e) {
			BIBMessage.showError(e.getMessage());
		} catch (SQLException e) {
			BIBMessage.showError(e.getMessage());
		}
	}
	
}
