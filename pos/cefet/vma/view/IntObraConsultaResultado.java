/*
 * Criado em 24/06/2007
 */
package pos.cefet.vma.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import pos.cefet.vma.constants.BIBConstants;
import pos.cefet.vma.model.Obra;
import pos.cefet.vma.utility.BIBUtility;

/**
 * @author Vanderlei
 */
public class IntObraConsultaResultado extends JInternalFrame {

	private JComboBox cboDesativacao;
	private JComboBox cboGenero;
	private JButton btExcluir;
	private JPanel jContentPane = null;
	private JPanel jPanel = null;
	private JLabel lblMatricula = null;
	private JLabel lblNome = null;
	private JLabel lblSenha1 = null;
	private JLabel lblDataNasc = null;
	private JLabel lblLogradouro = null;
	private JLabel lblNumero = null;
	private JLabel lblBairro = null;
	private JLabel lblComplemento = null;
	private JLabel lblEmail = null;
	private JTextField txtCodigo = null;
	private JTextField txtDescricao = null;
	private JTextField txtAutor = null;
	private JTextField txtEditora = null;
	private JTextField txtDtPublicacao = null;
	private JTextField txtDtAtivacao = null;
	private JTextField txtDtDesativacao = null;
	private JButton btAlterar = null;	
	private JTextField txtGenero = null;
	private JTextField txtDesativacao = null;
	private JLabel lblValor = null;
	private JTextField txtValor = null;
	
	private ActionListener ctrlListener = null;
	private Obra obra;
	/**
	 * 
	 */
	public IntObraConsultaResultado(ActionListener ctrlListener, Obra obra) {
		super("Consulta Obra - Resultado", false, true);
		
		this.ctrlListener = ctrlListener;
		this.obra = obra;
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(719, 471);
		this.setResizable(false);
		this.setContentPane(getJContentPane());
		this.setVisible(true);
	}
	/**
	 * This method initializes jContentPane
	 * 
	 * @return JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJPanel(), null);
		}
		return jContentPane;
	}
	/**
	 * This method initializes jPanel
	 * 
	 * @return JPanel
	 */
	private JPanel getJPanel() {
		if(jPanel == null) {
			jPanel = new JPanel();
			jPanel.setLayout(null);
			jPanel.add(getJLabel(), null);
			jPanel.add(getJLabel1(), null);
			jPanel.add(getJLabel2(), null);
			jPanel.add(getJLabel5(), null);
			jPanel.add(getJLabel6(), null);
			jPanel.add(getJLabel7(), null);
			jPanel.add(getJLabel8(), null);
			jPanel.add(getJLabel16(), null);
			jPanel.add(getJLabel17(), null);
			jPanel.add(getTxtCodigo(), null);
			jPanel.add(getTxtDesricao(), null);
			jPanel.add(getTxtAutor(), null);
			jPanel.add(getTxtEditora(), null);
			jPanel.add(getTxtDataPublicacao(), null);
			jPanel.add(getTxtDtAtivacao(), null);
			jPanel.add(getTxtDtDesativacao(), null);
			jPanel.add(getJButtonAlterar(), null);
			jPanel.add(getJButtonExcluir(), null);
//			jPanel.add(getJTxtGenero(), null);
			jPanel.add(getJCboGenero(), null);
//			jPanel.add(getJTxtDesativavao(), null);
			jPanel.add(getJCboDesativacao(), null);
			jPanel.add(getJLabel3(), null);
			jPanel.add(getTxtValor(), null);
			jPanel.setBounds(25, 25, 629, 382);
			jPanel.setBorder(BorderFactory.createLineBorder(Color.black,1));
		}
		return jPanel;
	}
	/**
	 * This method initializes lblMatricula
	 * 
	 * @return JLabel
	 */
	private JLabel getJLabel() {
		if(lblMatricula == null) {
			lblMatricula = new JLabel();
			lblMatricula.setSize(100, 20);
			lblMatricula.setText("Código :");
			lblMatricula.setLocation(15, 15);
		}
		return lblMatricula;
	}
	/**
	 * This method initializes lblNome
	 * 
	 * @return JLabel
	 */
	private JLabel getJLabel1() {
		if(lblNome == null) {
			lblNome = new JLabel();
			lblNome.setSize(100, 20);
			lblNome.setText("Descrição :");
			lblNome.setLocation(15, 46);
		}
		return lblNome;
	}
	/**
	 * This method initializes lblSenha1
	 * 
	 * @return JLabel
	 */
	private JLabel getJLabel2() {
		if(lblSenha1 == null) {
			lblSenha1 = new JLabel();
			lblSenha1.setSize(100, 20);
			lblSenha1.setText("Genero :");
			lblSenha1.setLocation(15, 74);
		}
		return lblSenha1;
	}
	/**
	 * This method initializes lblDataNasc
	 * 
	 * @return JLabel
	 */
	private JLabel getJLabel5() {
		if(lblDataNasc == null) {
			lblDataNasc = new JLabel();
			lblDataNasc.setSize(100, 20);
			lblDataNasc.setText("Autor :");
			lblDataNasc.setLocation(15, 109);
		}
		return lblDataNasc;
	}
	/**
	 * This method initializes lblLogradouro
	 * 
	 * @return JLabel
	 */
	private JLabel getJLabel6() {
		if(lblLogradouro == null) {
			lblLogradouro = new JLabel();
			lblLogradouro.setSize(100, 20);
			lblLogradouro.setText("Editora :");
			lblLogradouro.setLocation(15, 142);
		}
		return lblLogradouro;
	}
	/**
	 * This method initializes lblNumero
	 * 
	 * @return JLabel
	 */
	private JLabel getJLabel7() {
		if(lblNumero == null) {
			lblNumero = new JLabel();
			lblNumero.setSize(103, 20);
			lblNumero.setText("Data Publicação :");
			lblNumero.setLocation(400, 143);
		}
		return lblNumero;
	}
	/**
	 * This method initializes lblBairro
	 * 
	 * @return JLabel
	 */
	private JLabel getJLabel8() {
		if(lblBairro == null) {
			lblBairro = new JLabel();
			lblBairro.setSize(141, 20);
			lblBairro.setText("Data Ativação da Obra :");
			lblBairro.setLocation(15, 178);
		}
		return lblBairro;
	}
	/**
	 * This method initializes lblComplemento
	 * 
	 * @return JLabel
	 */
	private JLabel getJLabel16() {
		if(lblComplemento == null) {
			lblComplemento = new JLabel();
			lblComplemento.setSize(158, 20);
			lblComplemento.setText("Data Desativação da Obra :");
			lblComplemento.setLocation(345, 178);
		}
		return lblComplemento;
	}
	/**
	 * This method initializes lblEmail
	 * 
	 * @return JLabel
	 */
	private JLabel getJLabel17() {
		if(lblEmail == null) {
			lblEmail = new JLabel();
			lblEmail.setSize(134, 20);
			lblEmail.setText("Motivo da desativação :");
			lblEmail.setLocation(15, 215);
		}
		return lblEmail;
	}
	/**
	 * This method initializes txtCodigo
	 * 
	 * @return JTextField
	 */
	public JTextField getTxtCodigo() {
		if(txtCodigo == null) {
			txtCodigo = new JTextField(String.valueOf(obra.getId()).trim());
			txtCodigo.setSize(148, 20);
			txtCodigo.setLocation(130, 16);
			txtCodigo.setEnabled(false);
		}
		return txtCodigo;
	}
	/**
	 * This method initializes txtDescricao
	 * 
	 * @return JTextField
	 */
	public JTextField getTxtDesricao() {
		if(txtDescricao == null) {
			txtDescricao = new JTextField(obra.getDescricao().trim());
			txtDescricao.setSize(367, 20);
			txtDescricao.setLocation(130, 45);
			txtDescricao.setEnabled(false);
		}
		return txtDescricao;
	}
	/**
	 * This method initializes txtAutor
	 * 
	 * @return JTextField
	 */
	public JTextField getTxtAutor() {
		if(txtAutor == null) {
			txtAutor = new JTextField(obra.getAutor().trim());
			txtAutor.setBounds(130, 109, 365, 20);
			txtAutor.setEnabled(false);
		}
		return txtAutor;
	}
	/**
	 * This method initializes txtEditora
	 * 
	 * @return JTextField
	 */
	public JTextField getTxtEditora() {
		if(txtEditora == null) {
			txtEditora = new JTextField(obra.getEditora().trim());
			txtEditora.setSize(258, 20);			
			txtEditora.setLocation(130, 142);
			txtEditora.setEnabled(false);
		}
		return txtEditora;
	}
	/**
	 * This method initializes txtDtPublicacao
	 * 
	 * @return JTextField
	 */
	public JTextField getTxtDataPublicacao() {
		if(txtDtPublicacao == null) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date dataPublicacao = obra.getDataPublicacao();
			if (dataPublicacao != null) {
				txtDtPublicacao = new JTextField(dateFormat.format(dataPublicacao));			
			} else {
				txtDtPublicacao = new JTextField();
			}			
			txtDtPublicacao.setSize(101, 20);
			txtDtPublicacao.setLocation(508, 144);
			txtDtPublicacao.setEnabled(false);
		}
		return txtDtPublicacao;
	}
	/**
	 * This method initializes txtDtAtivacao
	 * 
	 * @return JTextField
	 */
	public JTextField getTxtDtAtivacao() {
		if(txtDtAtivacao == null) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date dataAtivacao = obra.getDataAtivacao();
			if (dataAtivacao != null) {
				txtDtAtivacao = new JTextField(dateFormat.format(dataAtivacao));
			} else {
				txtDtAtivacao = new JTextField();
			}			
			txtDtAtivacao.setSize(101, 20);
			txtDtAtivacao.setLocation(165, 179);			
			txtDtAtivacao.setEnabled(false);
		}
		return txtDtAtivacao;
	}
	/**
	 * This method initializes txtDtDesativacao
	 * 
	 * @return JTextField
	 */
	public JTextField getTxtDtDesativacao() {
		if(txtDtDesativacao == null) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date dataDesativacao = obra.getDataDesativacao();
			if (dataDesativacao != null) {
				txtDtDesativacao = new JTextField(dateFormat.format(dataDesativacao));
			} else {
				txtDtDesativacao = new JTextField();
			}			
			txtDtDesativacao.setSize(101, 20);
			txtDtDesativacao.setLocation(509, 179);			
			txtDtDesativacao.setEnabled(false);
		}
		return txtDtDesativacao;
	}
	/**
	 * This method initializes jButton
	 * 
	 * @return javax.swing.JButton
	 */
	public JButton getJButtonAlterar() {
		if(btAlterar == null) {
			btAlterar = new JButton();
			btAlterar.setBounds(151, 300, 139, 36);
			btAlterar.setText("Alterar");
			btAlterar.addActionListener(ctrlListener);
		}
		return btAlterar;
	}
	
	public JButton getJButtonExcluir() {
		if(btExcluir == null) {
			btExcluir = new JButton();
			btExcluir.setBounds(320, 300, 139, 36);
			btExcluir.setText("Excluir");
			btExcluir.addActionListener(ctrlListener);
		}
		return btExcluir;
	}

	public JComboBox getJCboGenero() {
		if(txtGenero == null) {
			cboGenero = new JComboBox(BIBConstants.ITENS_GENERO);
			cboGenero.setSelectedIndex(obra.getGenero());
			cboGenero.setBounds(131, 71, 155, 20);
			cboGenero.setEnabled(false);
		}
		return cboGenero;
	}
	
	/**
	 * This method initializes jCboDesativacao
	 * 
	 * @return javax.swing.JComboBox
	 */
	public JComboBox getJCboDesativacao() {
		if(cboDesativacao == null) {
			cboDesativacao = new JComboBox(BIBConstants.ITENS_MOTIVO);
			int selected = 0;

			selected = obra.getMotivoDesativacao();
			cboDesativacao.setSelectedIndex(selected);
			cboDesativacao.setBounds(165, 215, 186, 21);
			cboDesativacao.setEnabled(false);
		}
		return cboDesativacao;
	}
	/**
	 * This method initializes lblValor
	 * 
	 * @return javax.swing.JLabel
	 */
	private javax.swing.JLabel getJLabel3() {
		if(lblValor == null) {
			lblValor = new javax.swing.JLabel();
			lblValor.setSize(101, 20);
			lblValor.setLocation(15, 250);
			lblValor.setText("Valor : ");
		}
		return lblValor;
	}
	/**
	 * This method initializes txtValor
	 * 
	 * @return javax.swing.JTextField
	 */
	public JTextField getTxtValor() {
		if(txtValor == null) {			
			String valor = BIBUtility.converterDoubleToMoeda(obra.getValor()).substring(3).replace(',', '.');
			txtValor = new JTextField(valor);
			txtValor.setSize(101, 20);
			txtValor.setLocation(130, 250);
			txtValor.setEnabled(false);
		}
		return txtValor;
	}
}  //  @jve:visual-info  decl-index=0 visual-constraint="10,10"

