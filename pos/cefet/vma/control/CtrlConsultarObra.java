/*
 * Criado em 25/06/2007
 *
 */
package pos.cefet.vma.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JInternalFrame;

import pos.cefet.vma.model.Obra;
import pos.cefet.vma.utility.BIBMessage;
import pos.cefet.vma.view.IntBibliotecaria;
import pos.cefet.vma.view.IntObraConsulta;
import pos.cefet.vma.view.IntObraConsultaResultado;

/**
 * @author Vanderlei Matos Andre
 *
 */
public class CtrlConsultarObra implements ActionListener {
	
	private CtrlBiblioteca ctrlBiblioteca;
	private IntBibliotecaria intBibliotecaria;
	private IntObraConsultaResultado obraConsultaResultado;
	private IntObraConsulta obraConsulta;
	
	public CtrlConsultarObra() {
	}
	
	public CtrlConsultarObra(CtrlBiblioteca ctrlBiblioteca) {
		this.ctrlBiblioteca = ctrlBiblioteca;
	}

	public JInternalFrame exibirTelaConsulta() {
		obraConsulta = new IntObraConsulta(this);
		return new IntBibliotecaria().mostrarJanela(obraConsulta);
	}
	
	public JInternalFrame exibirTelaResultadoConsulta(Obra obraConsulta) {
		obraConsultaResultado = new IntObraConsultaResultado(this, obraConsulta);

		intBibliotecaria = new IntBibliotecaria();
		return intBibliotecaria.mostrarJanela(obraConsultaResultado);
	}	
	
	private void mostrarJanelaResultado(JInternalFrame fResult) {
		this.obraConsulta.dispose();
		this.obraConsulta.repaint();
		ctrlBiblioteca.getContentPane().add(fResult).setVisible(true);		
	}
	
	private void mostrarJanelaAlteracao(JInternalFrame fResult) {
		this.obraConsultaResultado.dispose();
		this.obraConsultaResultado.repaint();
		ctrlBiblioteca.getContentPane().add(fResult).setVisible(true);		
	}

	/* (n�o-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		String codigo = obraConsulta.getTxtCodigo().getText();
		try {

			if (((JButton) e.getSource())
				.getActionCommand()
				.equals("Alterar")) {

				//Recupera o valor da matr�cula para realizar a pesquisa para a tela de altera��o
				codigo = obraConsultaResultado.getTxtCodigo().getText();

				Obra obra = new Obra();

				Obra obra2 =
					obra.getObraById(Integer.parseInt(codigo));
				if (obra2 != null) {
					this.mostrarJanelaAlteracao(
						new CtrlAlterarObra(obra2).exibirTelaAlteracao());
				} else {
					BIBMessage.showError(
						"Ocorreu erro na pesquisa da obra "
							+ codigo
							+ " para altera��o!");
				}

			}

			if (((JButton) e.getSource())
				.getActionCommand()
				.equals("Excluir")) {
				int retorno = BIBMessage.showExcludeQuestion();

				//Usu�rio selecionou exclus�o
				if (retorno == 0) {
					//Recupera o valor da matr�cula para realizar a pesquisa para a tela de altera��o
					codigo =
						obraConsultaResultado.getTxtCodigo().getText();
					Obra obra = new Obra();
					obra.setId(Integer.parseInt(codigo));

					//Passa o usu�rio para o Control excluir
					CtrlExcluirObra ctrlExcluirObra =
						new CtrlExcluirObra();
					ctrlExcluirObra.excluirObra(obra);

					BIBMessage.showInfo("Obra exclu�da com sucesso!");
					this.obraConsulta.dispose();
					this.obraConsultaResultado.dispose();
					this.obraConsulta.repaint();
					this.obraConsultaResultado.repaint();

				}
			}

			if (((JButton) e.getSource())
				.getActionCommand()
				.equals("Consultar")) {
				//Valida��o do preenchimento dos campos	
				if (codigo.equals("")) {
					//Dois campos preenchidos
					BIBMessage.showError(
						"Digite o c�digo da obra para realizar a pesquisa!");
				} else {
					int idObra = 0;
					if (codigo.length() > 0) {
						try {
							idObra = Integer.parseInt(codigo);
						} catch (NumberFormatException nfe) {
							BIBMessage.showError("C�digo inv�lido!");
						}
					}

					Obra obra = new Obra();

					//Pesquisa obra pelo c�digo
					if (idObra != 0) {
						Obra obra2 = obra.getObraById(idObra);
						if (obra2 == null) {
							BIBMessage.showError("Obra n�o encontrada!");
						} else {
							obraConsultaResultado =
								new IntObraConsultaResultado(this, obra2);

							/*
							 * Passa o controle para o Frame Bibliteca mostrar o 
							 * JInternalFrame com o resultado da pesquisa.
							 * Para que isso ocorra
							 */
							this.mostrarJanelaResultado(
								new IntBibliotecaria().mostrarJanela(
									obraConsultaResultado));

						}
					}
				}
			}

		} catch (NumberFormatException e1) {
			BIBMessage.showError(e1.getMessage());
		} catch (ClassNotFoundException e1) {
			BIBMessage.showError(e1.getMessage());
		} catch (SQLException e1) {
			BIBMessage.showError(e1.getMessage());
		}
	}
}
