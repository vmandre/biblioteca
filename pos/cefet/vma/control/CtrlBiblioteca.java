/*
 * Criado em 22/06/2007
 *
 */
package pos.cefet.vma.control;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import pos.cefet.vma.utility.BIBCreateTables;
import pos.cefet.vma.view.IntBibliotecaria;

/**
 * @author Vanderlei Matos Andre
 *
 */
public class CtrlBiblioteca extends JFrame {
	
	private JMenuItem itemSobre;
	private JMenuItem itemCriarTables;
	private JMenuItem itemRegistrarPagamento;
	private JMenuItem itemEmitirMultas;
	private JMenuItem itemConsultarObra;
	private JMenuItem itemConsultarUser;
	private JMenuItem itemSair;
	private JMenuItem itemDevolucao;
	private JMenuItem itemSolicitarEmprestimo;
	private JMenuItem itemIncluirObra;
	private JDesktopPane desktopPane;
	private CtrlAutenticarUsuario ctrlAutenticarUsuario;
	private CtrlIncluirUsuario ctrlIncluirUsuario;
	private IntBibliotecaria intBibliotecaria;
	private JMenuBar menuBar;
	private JMenu menu;
	
	private JMenuBar jJMenuBar = null;
	private JMenu jMenuApp = null;
	private JMenu jMenuUser = null;
	private JMenuItem itemIncluir = null;
	private JMenu jMenuObra = null;
	private JMenu jMenuEmprestimo = null;
	private JMenu jMenuMulta = null;
	private JMenu jMenuAjuda = null;

	public CtrlBiblioteca() {
		this.setTitle("Biblioteca");
		
		this.setJMenuBar(this.getJJMenuBar());

		desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(60, 100, 150));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(desktopPane);
		
		ctrlAutenticarUsuario = new CtrlAutenticarUsuario();
//		this.getContentPane().add(ctrlAutenticarUsuario.getIntUsuario().mostrarJanelaAutenticacao());
		
		intBibliotecaria = new IntBibliotecaria();
		
	}
	/**
	 * This method initializes jJMenuBar
	 * 
	 * @return javax.swing.JMenuBar
	 */
	private JMenuBar getJJMenuBar() {
		if(jJMenuBar == null) {
			jJMenuBar = new JMenuBar();
			jJMenuBar.add(this.getMenuAplicacao());
			jJMenuBar.add(this.getMenuUser());
			jJMenuBar.add(this.getMenuObra());
			jJMenuBar.add(this.getMenuEmprestimo());
			jJMenuBar.add(this.getMenuMulta());
			jJMenuBar.add(this.getMenuAjuda());
		}
		return jJMenuBar;
	}
	/**
	 * This method initializes jMenu
	 * 
	 * @return javax.swing.JMenu
	 */
	private JMenu getMenuAplicacao() {
		if(jMenuApp == null) {
			jMenuApp = new JMenu("Aplicacao");
			JMenuItem itemCriarTables = new JMenuItem("Criar tabelas do Banco de Dados");
			itemCriarTables.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					BIBCreateTables.createAndPopulateTables();
				}});
			
			jMenuApp.add(itemCriarTables);
			itemSair = new JMenuItem("Sair");
			itemSair.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					fecharAplicacao();
				}});
			jMenuApp.add(itemSair);
		}
		return jMenuApp;
	}
	
	private JMenu getMenuUser() {
		if(jMenuUser == null) {
			jMenuUser = new JMenu("Usuário");
			itemIncluir = new JMenuItem("Incluir");
			itemIncluir.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					exibirTelaInclusaoUsuario();
				}});
			jMenuUser.add(itemIncluir);

			itemConsultarUser = new JMenuItem("Consultar");
			itemConsultarUser.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				exibirTelaConsultaUsuario();
			}});
			jMenuUser.add(itemConsultarUser);
			// A opções de alteração e exclusão do usuário só serão acessadas após a consulta			
//			jMenuUser.add(new JMenuItem("Alterar"));
//			jMenuUser.add(new JMenuItem("Excluir"));
		}
		return jMenuUser;
	}
	
	private JMenu getMenuObra() {
		if(jMenuObra == null) {
			jMenuObra = new JMenu("Obra");
			
			itemIncluirObra = new JMenuItem("Incluir");
			jMenuObra.add(itemIncluirObra);
			itemIncluirObra.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					exibirTelaInclusaoObra();
				}});
			jMenuObra.add(itemIncluirObra);
			
			itemConsultarObra = new JMenuItem("Consultar");
			itemConsultarObra.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					exibirTelaConsultarObra();
				}});
			jMenuObra.add(itemConsultarObra);
			
			// A op��o de alterar, desativar e excluir s� ser� acessada ap�s consulta da obra
//			jMenuObra.add(new JMenuItem("Alterar"));
//			jMenuObra.add(new JMenuItem("Desativar"));
//			jMenuObra.add(new JMenuItem("Excluir"));
		}
		return jMenuObra;
	}
	
	private JMenu getMenuEmprestimo() {
		if(jMenuEmprestimo == null) {
			jMenuEmprestimo = new JMenu("Empréstimo");
			itemSolicitarEmprestimo = new JMenuItem("Solicitar Empréstimo");
			jMenuEmprestimo.add(itemSolicitarEmprestimo);
			itemSolicitarEmprestimo.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					exibirTelaEmprestimoObra();					
				}});
			itemDevolucao = new JMenuItem("Registrar Devolução");
			jMenuEmprestimo.add(itemDevolucao);
			itemDevolucao.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					exibirTelaDevolucaoObra();					
				}});
		}
		return jMenuEmprestimo;
	}
	
	private JMenu getMenuMulta() {
		if(jMenuMulta == null) {
			jMenuMulta = new JMenu("Multa");
			itemEmitirMultas = new JMenuItem("Emitir Multas");
			itemEmitirMultas.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					exibirTelaEmissaoMultas();
				}});
			jMenuMulta.add(itemEmitirMultas);
			
			itemRegistrarPagamento = new JMenuItem("Registrar Pagamento");
			itemRegistrarPagamento.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				exibirTelaPagamentoMulta();
			}});
			jMenuMulta.add(itemRegistrarPagamento);
		}
		return jMenuMulta;
	}
	
	private JMenu getMenuAjuda() {
		if(jMenuAjuda == null) {
			jMenuAjuda = new JMenu("Créditos");
			itemSobre = new JMenuItem("Sobre");
			itemSobre.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, 
					"Autor : Vanderlei Matos André \n"+
					"Descrição : Trabalho de conclusão do módulo JAVA \n"+
					"Data : 27/06/2007 \n"+
					"Professor: Robson Linhares", "Créditos", JOptionPane.NO_OPTION);

				}});
			jMenuAjuda.add(itemSobre);
		}
		return jMenuAjuda;
	}
	
	private void exibirTelaInclusaoUsuario() {
		this.getContentPane().add(new CtrlIncluirUsuario().exibirTelaInclusao());
	}
	
	private void exibirTelaConsultaUsuario() {
		this.getContentPane().add(new CtrlConsultarUsuario(this).exibirTelaConsulta());
	}
	
	private void exibirTelaInclusaoObra() {
		this.getContentPane().add(new CtrlIncluirObra().exibirTelaInclusao());
	}
	
	private void exibirTelaConsultarObra() {
		this.getContentPane().add(new CtrlConsultarObra(this).exibirTelaConsulta());
	}
	
	private void exibirTelaEmprestimoObra() {
		this.getContentPane().add(new CtrlSolicitarEmprestimo().exibirTelaEmprestimo());
	}
	
	private void exibirTelaDevolucaoObra() {
		this.getContentPane().add(new CtrlRegistarDevolucao().exibirTelaDevolucaoObra());
	}
	
	private void exibirTelaEmissaoMultas() {
		this.getContentPane().add(new CtrlEmissaoMultas(this).exibirTelaConsultaMultas());
	}
	
	private void exibirTelaPagamentoMulta() {
	this.getContentPane().add(new CtrlRegistrarPagamento(this).exibirTelaPagamentoMulta());
}
	
	private void fecharAplicacao() {
		this.dispose();
	}
}
