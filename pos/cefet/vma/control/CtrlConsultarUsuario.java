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

import pos.cefet.vma.model.Endereco;
import pos.cefet.vma.model.Usuario;
import pos.cefet.vma.utility.BIBMessage;
import pos.cefet.vma.view.IntBibliotecaria;
import pos.cefet.vma.view.IntUsuarioConsulta;
import pos.cefet.vma.view.IntUsuarioConsultaResultado;

/**
 * @author Vanderlei Matos Andre
 *
 */
public class CtrlConsultarUsuario implements ActionListener {
	
	private CtrlBiblioteca ctrlBiblioteca;
	private IntBibliotecaria intBibliotecaria;
	private IntUsuarioConsultaResultado userConsultaResultado;
	private IntUsuarioConsulta userConsulta;
	
	public CtrlConsultarUsuario() {
	}
	
	public CtrlConsultarUsuario(CtrlBiblioteca ctrlBiblioteca) {
		this.ctrlBiblioteca = ctrlBiblioteca;
	}

	public JInternalFrame exibirTelaConsulta() {
		userConsulta = new IntUsuarioConsulta(this);
		return new IntBibliotecaria().mostrarJanela(userConsulta);
	}
	
	public JInternalFrame exibirTelaResultadoConsulta(Usuario usuarioConsulta) {
		userConsultaResultado = new IntUsuarioConsultaResultado(this, usuarioConsulta);

		intBibliotecaria = new IntBibliotecaria();
		return intBibliotecaria.mostrarJanela(userConsultaResultado);
	}	
	
	private void mostrarJanelaResultado(JInternalFrame fResult) {
		this.userConsulta.dispose();
		this.userConsulta.repaint();
		ctrlBiblioteca.getContentPane().add(fResult).setVisible(true);		
	}
	
	private void mostrarJanelaAlteracao(JInternalFrame fResult) {
		this.userConsultaResultado.dispose();
		this.userConsultaResultado.repaint();
		ctrlBiblioteca.getContentPane().add(fResult).setVisible(true);		
	}

	/* (não-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		String matricula = userConsulta.getTxtMatricula().getText();
		String cpf = userConsulta.getTxtCPF().getText();
		try {

			if (((JButton) e.getSource())
				.getActionCommand()
				.equals("Alterar")) {

				//Recupera o valor da matrícula para realizar a pesquisa para a tela de alteração
				matricula = userConsultaResultado.getTxtMatricula().getText();

				Usuario usuario = new Usuario();

				Usuario usuario2 =
					usuario.getUsuarioById(Integer.parseInt(matricula));
				Endereco endereco = new Endereco();
				usuario2.setEndereco(
					endereco.getEnderecoByUsuario(usuario2.getId()));
				if (usuario2 != null) {
					this.mostrarJanelaAlteracao(
						new CtrlAlterarUsuario(usuario2).exibirTelaAlteracao());
				} else {
					BIBMessage.showError(
						"Ocorreu erro na pesquisa do usuário "
							+ matricula
							+ " para alteração!");
				}

			}

			if (((JButton) e.getSource())
				.getActionCommand()
//				.equals("Excluir")) {
				.equals("Desativar")) {
				//int retorno = BIBMessage.showExcludeQuestion();
				int retorno = BIBMessage.showDesativationQuestion();

				//Usuário selecionou exclusão
				if (retorno == 0) {
					//Recupera o valor da matrícula para realizar a pesquisa para a tela de alteração
					matricula =
						userConsultaResultado.getTxtMatricula().getText();
					Usuario usuario = new Usuario();
					usuario.setId(Integer.parseInt(matricula));

					if (userConsultaResultado.getJChkAtivo().isSelected()) {
						usuario.setStatus("A");
					} else {
						usuario.setStatus("I");
					}
					//Passa o usuário para o Control excluir
					CtrlExcluirUsuario ctrlExcluirUsuario =
						new CtrlExcluirUsuario();
					ctrlExcluirUsuario.excluirUsuario(usuario);

					//BIBMessage.showInfo("Usuário excluído com sucesso!");
					BIBMessage.showInfo("Usuário desativado com sucesso!");
					this.userConsulta.dispose();
					this.userConsultaResultado.dispose();
					this.userConsulta.repaint();
					this.userConsultaResultado.repaint();

				}
			}

			if (((JButton) e.getSource())
				.getActionCommand()
				.equals("Consultar")) {
				//Validação do preenchimento dos campos	
				if (!matricula.equals("") && !cpf.equals("")) {
					//Dois campos preenchidos
					BIBMessage.showError(
						"Preencha apenas um dos campos para realizar a pesquisa!");
				} else if (matricula.equals("") && cpf.equals("")) {
					//Nenhum campo preenchido
					BIBMessage.showError(
						"Preencha um dos campos para realizar a pesquisa!");
				} else {
					int idUser = 0;
					if (matricula.length() > 0) {
						try {
							idUser = Integer.parseInt(matricula);
						} catch (NumberFormatException nfe) {
							BIBMessage.showError("Matrícula inválida!");
						}
					}

					long cpfUser = 0;
					if (cpf.length() > 0) {
						try {
							cpfUser = Long.parseLong(cpf);
						} catch (NumberFormatException nfe) {
							BIBMessage.showError("CPF inválido!");
						}
					}

					Usuario usuario = new Usuario();
					Endereco endereco = new Endereco();

					//Pesquisa usuário pelo CPF
					if (cpfUser != 0) {
						Usuario usuario2 = usuario.getUsuarioByCpf(cpfUser);
						if (usuario2 == null) {
							BIBMessage.showError("Usuário não encontrado!");
						} else {
							usuario2.setEndereco(
								endereco.getEnderecoByUsuario(
									usuario2.getId()));

							userConsultaResultado =
								new IntUsuarioConsultaResultado(this, usuario2);

							/*
							 * Passa o controle para o Frame Bibliteca mostrar o 
							 * JInternalFrame com o resultado da pesquisa.
							 * Para que isso ocorra
							 */
							this.mostrarJanelaResultado(
								new IntBibliotecaria().mostrarJanela(
									userConsultaResultado));

						}
					}
					//Pesquisa usuário pela matrícula
					if (idUser != 0) {
						Usuario usuario2 = usuario.getUsuarioById(idUser);
						if (usuario2 == null) {
							BIBMessage.showError("Usuário não encontrado!");
						} else {
							usuario2.setEndereco(
								endereco.getEnderecoByUsuario(
									usuario2.getId()));

							userConsultaResultado =
								new IntUsuarioConsultaResultado(this, usuario2);

							/*
							 * Passa o controle para o Frame Bibliteca mostrar o 
							 * JInternalFrame com o resultado da pesquisa.
							 * Para que isso ocorra
							 */
							this.mostrarJanelaResultado(
								new IntBibliotecaria().mostrarJanela(
									userConsultaResultado));

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
