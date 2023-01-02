/*
 * Criado em 24/06/2007
 */
package pos.cefet.vma.view;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import pos.cefet.vma.model.Usuario;

/**
 * @author Vanderlei
 */
public class IntUsuarioConsultaResultado extends JInternalFrame {

	private JLabel jLblAtivo;

	private JCheckBox jCheckBox;

	private JButton btExcluir;

	private JPanel jContentPane = null;

	private JPanel jPanel = null;
	private JLabel lblMatricula = null;
	private JLabel lblNome = null;
	private JLabel lblSenha1 = null;
	private JLabel lblSenha2 = null;
	private JLabel lblCPF = null;
	private JLabel lblDataNasc = null;
	
	private JLabel lblLogradouro = null;
	private JLabel lblNumero = null;
	private JLabel lblBairro = null;
	private JLabel lblCidade = null;
	private JLabel lblUF = null;
	private JLabel lblCEP = null;
	private JLabel lblDDD = null;
	private JLabel lblTelCont = null;
	private JLabel lblTelCel = null;
	private JLabel lblTelCom = null;
	private JLabel lblComplemento = null;
	private JLabel lblEmail = null;
	private JTextField txtMatricula = null;
	private JTextField txtNome = null;
	private JTextField txtCPF = null;
	private JPasswordField pwdSenha1 = null;
	private JPasswordField pwdSenha2 = null;
	private JTextField txtDataNasc = null;
	private JTextField txtLogradouro = null;
	private JTextField txtNumero = null;
	private JTextField txtBairro = null;
	private JTextField txtComplemento = null;
	private JTextField txtEmail = null;
	private JTextField txtCEP = null;
	private JTextField txtUF = null;
	private JTextField txtCidade = null;
	private JTextField txtDDD = null;
	private JTextField txtTelCont = null;
	private JTextField txtTelCel = null;
	private JTextField txtTelCom = null;
	private JButton btAlterar = null;
	
	private ActionListener ctrlListener = null;
	
	private Usuario usuario;

	/**
	 * 
	 */
	public IntUsuarioConsultaResultado(ActionListener ctrlListener, Usuario usuario) {
		super("Consulta de Usuário - Resultado", false, true);
		
		this.ctrlListener = ctrlListener;
		this.usuario = usuario;
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(719, 526);
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
			jPanel.add(getJLabel3(), null);
			jPanel.add(getJLabel4(), null);
			jPanel.add(getJLabel5(), null);
			jPanel.add(getJLabel6(), null);
			jPanel.add(getJLabel7(), null);
			jPanel.add(getJLabel8(), null);
			jPanel.add(getJLabel9(), null);
			jPanel.add(getJLabel10(), null);
			jPanel.add(getJLabel11(), null);
			jPanel.add(getJLabel12(), null);
			jPanel.add(getJLabel13(), null);
			jPanel.add(getJLabel14(), null);
			jPanel.add(getJLabel15(), null);
			jPanel.add(getJLabel16(), null);
			jPanel.add(getJLabel17(), null);
			jPanel.add(getJLblAtivo(), null);
			jPanel.add(getTxtMatricula(), null);
			jPanel.add(getTxtNome(), null);
			jPanel.add(getTxtCPF(), null);
			jPanel.add(getTxtSenha1(), null);
			jPanel.add(getTxtSenha2(), null);
			jPanel.add(getTxtDataNasc(), null);
			jPanel.add(getTxtLogradouro(), null);
			jPanel.add(getTxtNumero(), null);
			jPanel.add(getTxtBairro(), null);
			jPanel.add(getTxtComplemento(), null);
			jPanel.add(getTxtEmail(), null);
			jPanel.add(getTxtCEP(), null);
			jPanel.add(getTxtUF(), null);
			jPanel.add(getTxtCidade(), null);
			jPanel.add(getTxtDDD(), null);
			jPanel.add(getTxtTelCont(), null);
			jPanel.add(getTxtTelCel(), null);
			jPanel.add(getTxtTelCom(), null);
			jPanel.add(getJChkAtivo(), null);
			jPanel.add(getJButtonAlterar(), null);
			jPanel.add(getJButtonExcluir(), null);
			jPanel.setBounds(25, 25, 629, 451);
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
			lblMatricula.setText("Matricula:");
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
			lblNome.setText("Nome:");
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
			lblSenha1.setText("Senha:");
			lblSenha1.setLocation(15, 74);
		}
		return lblSenha1;
	}
	/**
	 * This method initializes lblSenha2
	 * 
	 * @return JLabel
	 */
	private JLabel getJLabel3() {
		if(lblSenha2 == null) {
			lblSenha2 = new JLabel();
			lblSenha2.setSize(106, 20);
			lblSenha2.setText("Confirmar Senha:");
			lblSenha2.setLocation(309, 71);
		}
		return lblSenha2;
	}
	/**
	 * This method initializes lblCPF
	 * 
	 * @return JLabel
	 */
	private JLabel getJLabel4() {
		if(lblCPF == null) {
			lblCPF = new JLabel();
			lblCPF.setSize(37, 20);
			lblCPF.setText("CPF:");
			lblCPF.setLocation(316, 16);
		}
		return lblCPF;
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
			lblDataNasc.setText("Data Nasc. :");
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
			lblLogradouro.setText("Logradouro:");
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
			lblNumero.setSize(55, 20);
			lblNumero.setText("Numero:");
			lblNumero.setLocation(455, 143);
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
			lblBairro.setSize(100, 20);
			lblBairro.setText("Bairro:");
			lblBairro.setLocation(15, 178);
		}
		return lblBairro;
	}
	/**
	 * This method initializes lblCidade
	 * 
	 * @return JLabel
	 */
	private JLabel getJLabel9() {
		if(lblCidade == null) {
			lblCidade = new JLabel();
			lblCidade.setSize(100, 20);
			lblCidade.setText("Cidade:");
			lblCidade.setLocation(15, 254);
		}
		return lblCidade;
	}
	/**
	 * This method initializes lblUF
	 * 
	 * @return JLabel
	 */
	private JLabel getJLabel10() {
		if(lblUF == null) {
			lblUF = new JLabel();
			lblUF.setSize(28, 20);
			lblUF.setText("UF:");
			lblUF.setLocation(346, 250);
		}
		return lblUF;
	}
	/**
	 * This method initializes lblCEP
	 * 
	 * @return JLabel
	 */
	private JLabel getJLabel11() {
		if(lblCEP == null) {
			lblCEP = new JLabel();
			lblCEP.setSize(35, 20);
			lblCEP.setText("CEP:");
			lblCEP.setLocation(453, 249);
		}
		return lblCEP;
	}
	/**
	 * This method initializes lblDDD
	 * 
	 * @return JLabel
	 */
	private JLabel getJLabel12() {
		if(lblDDD == null) {
			lblDDD = new JLabel();
			lblDDD.setSize(100, 20);
			lblDDD.setText("DDD:");
			lblDDD.setLocation(15, 291);
		}
		return lblDDD;
	}
	/**
	 * This method initializes lblTelCont
	 * 
	 * @return JLabel
	 */
	private JLabel getJLabel13() {
		if(lblTelCont == null) {
			lblTelCont = new JLabel();
			lblTelCont.setSize(124, 20);
			lblTelCont.setText("Telefone p/ Contato:");
			lblTelCont.setLocation(293, 293);
		}
		return lblTelCont;
	}
	/**
	 * This method initializes lblTelCel
	 * 
	 * @return JLabel
	 */
	private JLabel getJLabel14() {
		if(lblTelCel == null) {
			lblTelCel = new JLabel();
			lblTelCel.setSize(100, 20);
			lblTelCel.setText("Telefone Celular:");
			lblTelCel.setLocation(15, 331);
		}
		return lblTelCel;
	}
	/**
	 * This method initializes lblTelCom
	 * 
	 * @return JLabel
	 */
	private JLabel getJLabel15() {
		if(lblTelCom == null) {
			lblTelCom = new JLabel();
			lblTelCom.setSize(124, 20);
			lblTelCom.setText("Telefone Comercial:");
			lblTelCom.setLocation(294, 329);
		}
		return lblTelCom;
	}
	/**
	 * This method initializes lblComplemento
	 * 
	 * @return JLabel
	 */
	private JLabel getJLabel16() {
		if(lblComplemento == null) {
			lblComplemento = new JLabel();
			lblComplemento.setSize(100, 20);
			lblComplemento.setText("Complemento:");
			lblComplemento.setLocation(376, 176);
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
			lblEmail.setSize(100, 20);
			lblEmail.setText("E-Mail:");
			lblEmail.setLocation(15, 215);
		}
		return lblEmail;
	}
	/**
	 * This method initializes txtMatricula
	 * 
	 * @return JTextField
	 */
	public JTextField getTxtMatricula() {
		if(txtMatricula == null) {
			txtMatricula = new JTextField(String.valueOf(usuario.getId()).trim());
			txtMatricula.setSize(148, 20);
			txtMatricula.setLocation(130, 16);
			txtMatricula.setEnabled(false);
		}
		return txtMatricula;
	}
	/**
	 * This method initializes txtNome
	 * 
	 * @return JTextField
	 */
	public JTextField getTxtNome() {
		if(txtNome == null) {
			txtNome = new JTextField(usuario.getNome().trim());
			txtNome.setSize(367, 20);
			txtNome.setLocation(130, 45);
			txtNome.setEnabled(false);
		}
		return txtNome;
	}
	/**
	 * This method initializes txtCPF
	 * 
	 * @return JTextField
	 */
	public JTextField getTxtCPF() {
		if(txtCPF == null) {
			txtCPF = new JTextField(String.valueOf(usuario.getCpf()).trim());
			txtCPF.setSize(191, 20);
			txtCPF.setLocation(360, 17);
			txtCPF.setEnabled(false);
		}
		return txtCPF;
	}
	/**
	 * This method initializes pwdSenha1
	 * 
	 * @return JPasswordField
	 */
	public JPasswordField getTxtSenha1() {
		if(pwdSenha1 == null) {
			pwdSenha1 = new JPasswordField(usuario.getPwd().trim());
			pwdSenha1.setSize(164, 20);
			pwdSenha1.setLocation(130, 73);
			pwdSenha1.setEnabled(false);
		}
		return pwdSenha1;
	}
	/**
	 * This method initializes pwdSenha2
	 * 
	 * @return JPasswordField
	 */
	public JPasswordField getTxtSenha2() {
		if(pwdSenha2 == null) {
			pwdSenha2 = new JPasswordField(usuario.getPwd().trim());
			pwdSenha2.setBounds(425, 72, 155, 20);
			pwdSenha2.setEnabled(false);
		}
		return pwdSenha2;
	}
	/**
	 * This method initializes txtDataNasc
	 * 
	 * @return JTextField
	 */
	public JTextField getTxtDataNasc() {
		if(txtDataNasc == null) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			txtDataNasc = new JTextField(dateFormat.format(usuario.getDataNascimento()).trim());
			txtDataNasc.setBounds(130, 109, 150, 20);
			txtDataNasc.setEnabled(false);
		}
		return txtDataNasc;
	}
	/**
	 * This method initializes txtLogradouro
	 * 
	 * @return JTextField
	 */
	public JTextField getTxtLogradouro() {
		if(txtLogradouro == null) {
			txtLogradouro = new JTextField(""+usuario.getEndereco().getLogradouro().trim());
			txtLogradouro.setSize(293, 20);
			txtLogradouro.setLocation(130, 142);
			txtLogradouro.setEnabled(false);
		}
		return txtLogradouro;
	}
	/**
	 * This method initializes txtNumero
	 * 
	 * @return JTextField
	 */
	public JTextField getTxtNumero() {
		if(txtNumero == null) {
			txtNumero = new JTextField(String.valueOf(usuario.getEndereco().getNumero()).trim());
			txtNumero.setSize(69, 20);
			txtNumero.setLocation(521, 143);
			txtNumero.setEnabled(false);
		}
		return txtNumero;
	}
	/**
	 * This method initializes txtBairro
	 * 
	 * @return JTextField
	 */
	public JTextField getTxtBairro() {
		if(txtBairro == null) {
			txtBairro = new JTextField(usuario.getEndereco().getBairro().trim());
			txtBairro.setSize(239, 20);
			txtBairro.setLocation(130, 179);
			txtBairro.setEnabled(false);
		}
		return txtBairro;
	}
	/**
	 * This method initializes txtComplemento
	 * 
	 * @return JTextField
	 */
	public JTextField getTxtComplemento() {
		if(txtComplemento == null) {
			txtComplemento = new JTextField(usuario.getEndereco().getComplemento().trim());
			txtComplemento.setSize(125, 20);
			txtComplemento.setLocation(487, 178);
			txtComplemento.setEnabled(false);
		}
		return txtComplemento;
	}
	/**
	 * This method initializes txtEmail
	 * 
	 * @return JTextField
	 */
	public JTextField getTxtEmail() {
		if(txtEmail == null) {
			txtEmail = new JTextField(usuario.getEmail().trim());
			txtEmail.setSize(334, 20);
			txtEmail.setLocation(130, 215);
			txtEmail.setEnabled(false);
		}
		return txtEmail;
	}
	/**
	 * This method initializes txtCEP
	 * 
	 * @return JTextField
	 */
	public JTextField getTxtCEP() {
		if(txtCEP == null) {
			txtCEP = new JTextField(String.valueOf(usuario.getEndereco().getCep()).trim());
			txtCEP.setBounds(495, 248, 117, 20);
			txtCEP.setEnabled(false);
		}
		return txtCEP;
	}
	/**
	 * This method initializes txtUF
	 * 
	 * @return JTextField
	 */
	public JTextField getTxtUF() {
		if(txtUF == null) {
			txtUF = new JTextField(usuario.getEndereco().getUf().trim());
			txtUF.setBounds(391, 250, 49, 20);
			txtUF.setEnabled(false);
		}
		return txtUF;
	}
	/**
	 * This method initializes txtCidade
	 * 
	 * @return JTextField
	 */
	public JTextField getTxtCidade() {
		if(txtCidade == null) {
			txtCidade = new JTextField(usuario.getEndereco().getCidade().trim());
			txtCidade.setSize(202, 20);
			txtCidade.setLocation(130, 253);
			txtCidade.setEnabled(false);
		}
		return txtCidade;
	}
	/**
	 * This method initializes txtDDD
	 * 
	 * @return JTextField
	 */
	public JTextField getTxtDDD() {
		if(txtDDD == null) {
			txtDDD = new JTextField(String.valueOf(usuario.getDdd()).trim());
			txtDDD.setSize(76, 20);
			txtDDD.setLocation(130, 290);
			txtDDD.setEnabled(false);
		}
		return txtDDD;
	}
	/**
	 * This method initializes txtTelCont
	 * 
	 * @return JTextField
	 */
	public JTextField getTxtTelCont() {
		if(txtTelCont == null) {
			txtTelCont = new JTextField(String.valueOf(usuario.getTelContato()).trim());
			txtTelCont.setSize(151, 20);
			txtTelCont.setLocation(429, 291);
			txtTelCont.setEnabled(false);
		}
		return txtTelCont;
	}
	/**
	 * This method initializes txtTelCel
	 * 
	 * @return JTextField
	 */
	public JTextField getTxtTelCel() {
		if(txtTelCel == null) {
			txtTelCel = new JTextField(String.valueOf(usuario.getTelCelular()).trim());
			txtTelCel.setSize(144, 20);
			txtTelCel.setLocation(130, 330);
			txtTelCel.setEnabled(false);
		}
		return txtTelCel;
	}
	/**
	 * This method initializes txtTelCom
	 * 
	 * @return JTextField
	 */
	public JTextField getTxtTelCom() {
		if(txtTelCom == null) {
			txtTelCom = new JTextField(String.valueOf(usuario.getTelComercial()).trim());
			txtTelCom.setSize(151, 20);
			txtTelCom.setLocation(429, 327);
			txtTelCom.setEnabled(false);
		}
		return txtTelCom;
	}
	/**
	 * This method initializes jButton
	 * 
	 * @return javax.swing.JButton
	 */
	public JButton getJButtonAlterar() {
		if(btAlterar == null) {
			btAlterar = new JButton();
			btAlterar.setBounds(151, 392, 139, 36);
			btAlterar.setText("Alterar");
			btAlterar.addActionListener(ctrlListener);
		}
		return btAlterar;
	}
	
	public JButton getJButtonExcluir() {
		if(btExcluir == null) {
			btExcluir = new JButton();
			btExcluir.setBounds(320, 392, 139, 36);
//			btExcluir.setText("Excluir");
			btExcluir.setText("Desativar");
			btExcluir.addActionListener(ctrlListener);
		}
		return btExcluir;
	}
	
	/**
	 * This method initializes jLabel
	 * 
	 * @return javax.swing.JLabel
	 */
	private JLabel getJLblAtivo() {
		if(jLblAtivo == null) {
			jLblAtivo = new JLabel();			
			jLblAtivo.setBounds(16, 360, 100, 20);
			jLblAtivo.setText("Ativo:");
		}
		return jLblAtivo;
	}
	/**
	 * This method initializes jCheckBox
	 * 
	 * @return javax.swing.JCheckBox
	 */
	public  JCheckBox getJChkAtivo() {
		if(jCheckBox == null) {
			jCheckBox = new JCheckBox();
			jCheckBox.setEnabled(false);
			jCheckBox.setBounds(131, 362, 24, 19);
			if (usuario.getStatus().equals("A")){
				jCheckBox.setSelected(true);
			}
			
		}
		return jCheckBox;
	}
}

