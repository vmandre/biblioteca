/*
 * Criado em 26/06/2007
 *
 */
package pos.cefet.vma.component;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import pos.cefet.vma.constants.BIBConstants;

/**
 * @author Vanderlei Matos Andre
 *
 */
public class MultaArquivoReciboPagamento extends JFrame implements BIBConstants {

	private JPanel jContentPane = null;

	private JPanel jPanel = null;
	private JLabel jLabel = null;
	private javax.swing.JLabel jLabel1 = null;
	private javax.swing.JLabel lblDataHoraEmissao = null;
	private javax.swing.JLabel lblUsuario = null;
	private javax.swing.JLabel lblObra = null;
	private javax.swing.JLabel lblNomeObra = null;
	private javax.swing.JLabel jLabel5 = null;
	private javax.swing.JLabel lblMulta = null;
	private javax.swing.JLabel lblValor = null;
	private javax.swing.JLabel lblReferencia = null;
//	private javax.swing.JLabel lblObservacao = null;
	private javax.swing.JLabel lblTexto1 = null;
	private javax.swing.JLabel lblText2 = null;
	private javax.swing.JPanel jPanel1 = null;
	private javax.swing.JLabel lblAutenticacao = null;
	private javax.swing.JButton jButton = null;

	private javax.swing.JLabel jLabel2 = null;
	private javax.swing.JLabel lblIdMulta = null;
	private javax.swing.JLabel jLabel3 = null;
	/**
	 * This is the default constructor
	 */
	public MultaArquivoReciboPagamento() {
		super("Multa - Recibo de Pagamento");
		initialize();
	}
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(770, 402);
		this.setContentPane(getJContentPane());
		this.setVisible(true);
	}
	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJPanel(), null);
//			jContentPane.add()
			jContentPane.add(getJButton(), null);
		}
		return jContentPane;
	}
	/**
	 * This method initializes jPanel
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel() {
		if(jPanel == null) {
			jPanel = new JPanel();
			jPanel.setLayout(null);
			jPanel.add(getJLabel(), null);
			jPanel.add(getJLblEmissao(), null);
			jPanel.add(getJLblDataHoraEmissao(), null);
//			jPanel.add(getJLblUsuario(), null);
//			jPanel.add(getJLblObra(), null);
//			jPanel.add(getJLblNomeObra(), null);
//			jPanel.add(getJLblNomeUsuario(), null);
//			jPanel.add(getJLblMulta(), null);
//			jPanel.add(getJLblValor(), null);
//			jPanel.add(getJLblReferencia(), null);
//			jPanel.add(getJLblObservacao(), null);
//			jPanel.add(getJLblTexto1(), null);
//			jPanel.add(getJLblTexto2(), null);
			jPanel.add(getJPanelAutenticacao(), null);
			jPanel.setBounds(16, 17, 724, 286);
			jPanel.setBackground(Color.white);
		}
		return jPanel;
	}
	/**
	 * This method initializes jLabel
	 * 
	 * @return javax.swing.JLabel
	 */
	private JLabel getJLabel() {
		if(jLabel == null) {
			jLabel = new JLabel();
			jLabel.setBounds(11, 9, 314, 33);
			jLabel.setText(LOGO_BIB);
			jLabel.setFont(new java.awt.Font("Dialog", Font.BOLD, 18));
		}
		return jLabel;
	}
	/**
	 * This method initializes jLabel1
	 * 
	 * @return javax.swing.JLabel
	 */
	private JLabel getJLblEmissao() {
		if(jLabel1 == null) {
			jLabel1 = new JLabel();
			jLabel1.setBounds(545, 12, 58, 20);
			jLabel1.setText("Emiss�o : ");
		}
		return jLabel1;
	}
	/**
	 * This method initializes lblDataHoraEmissao
	 * 
	 * @return javax.swing.JLabel
	 */
	public JLabel getJLblDataHoraEmissao() {
		if(lblDataHoraEmissao == null) {
			lblDataHoraEmissao = new JLabel();
			lblDataHoraEmissao.setBounds(610, 12, 112, 20);
		}
		return lblDataHoraEmissao;
	}
	/**
	 * This method initializes lblUsuario
	 * 
	 * @return javax.swing.JLabel
	 */
	private JLabel getJLblUsuario() {
		if(lblUsuario == null) {
			lblUsuario = new JLabel();
			lblUsuario.setBounds(9, 53, 72, 20);
			lblUsuario.setText("Usu�rio");
		}
		return lblUsuario;
	}
	/**
	 * This method initializes lblObra
	 * 
	 * @return javax.swing.JLabel
	 */
	private JLabel getJLblObra() {
		if(lblObra == null) {
			lblObra = new JLabel();
			lblObra.setBounds(391, 53, 58, 20);
			lblObra.setText("Obra");
		}
		return lblObra;
	}
	/**
	 * This method initializes lblNomeObra
	 * 
	 * @return javax.swing.JLabel
	 */
	public JLabel getJLblNomeObra() {
		if(lblNomeObra == null) {
			lblNomeObra = new JLabel();
			lblNomeObra.setBounds(390, 79, 298, 20);
		}
		return lblNomeObra;
	}
	/**
	 * This method initializes jLabel5
	 * 
	 * @return javax.swing.JLabel
	 */
	public JLabel getJLblNomeUsuario() {
		if(jLabel5 == null) {
			jLabel5 = new JLabel();
			jLabel5.setBounds(9, 79, 342, 20);
		}
		return jLabel5;
	}
	/**
	 * This method initializes lblMulta
	 * 
	 * @return javax.swing.JLabel
	 */
	private JLabel getJLblMulta() {
		if(lblMulta == null) {
			lblMulta = new JLabel();
			lblMulta.setBounds(11, 107, 50, 20);
			lblMulta.setText("Valor : ");
		}
		return lblMulta;
	}
	/**
	 * This method initializes lblValor
	 * 
	 * @return javax.swing.JLabel
	 */
	public JLabel getJLblValor() {
		if(lblValor == null) {
			lblValor = new JLabel();
			lblValor.setBounds(64, 108, 146, 20);
		}
		return lblValor;
	}
	/**
	 * This method initializes lblReferencia
	 * 
	 * @return javax.swing.JLabel
	 */
	public JLabel getJLblReferencia() {
		if(lblReferencia == null) {
			lblReferencia = new JLabel();
			lblReferencia.setBounds(260, 108, 424, 20);
		}
		return lblReferencia;
	}
	/**
	 * This method initializes lblObservacao
	 * 
	 * @return javax.swing.JLabel
	 */
//	private javax.swing.JLabel getJLblObservacao() {
//		if(lblObservacao == null) {
//			lblObservacao = new JLabel();
//			lblObservacao.setBounds(14, 280, 90, 20);
//			lblObservacao.setText("Observa��o : ");
//		}
//		return lblObservacao;
//	}
	/**
	 * This method initializes lblTexto1
	 * 
	 * @return javax.swing.JLabel
	 */
//	private JLabel getJLblTexto1() {
//		if(lblTexto1 == null) {
//			lblTexto1 = new JLabel();
//			lblTexto1.setBounds(116, 280, 570, 20);
//			lblTexto1.setText(MSG_TEXTO_1);
//		}
//		return lblTexto1;
//	}
	/**
	 * This method initializes lblText2
	 * 
	 * @return javax.swing.JLabel
	 */
//	private JLabel getJLblTexto2() {
//		if(lblText2 == null) {
//			lblText2 = new JLabel();
//			lblText2.setBounds(116, 300, 570, 20);
//			lblText2.setText(MSG_TEXTO_2);
//		}
//		return lblText2;
//	}
	/**
	 * This method initializes jPanel1
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanelAutenticacao() {
		if(jPanel1 == null) {
			jPanel1 = new JPanel();
			jPanel1.setLayout(null);
			jPanel1.add(getJLblAutenticacao(), null);
//			jPanel1.add(getJLblIdMulta(), null);
			jPanel1.add(getJLblIdMulta(), null);
			jPanel1.add(getJLabel2(), null);

			jPanel1.add(getJLblUsuario(), null);
			jPanel1.add(getJLblObra(), null);
			jPanel1.add(getJLblNomeObra(), null);
			jPanel1.add(getJLblNomeUsuario(), null);

			jPanel1.add(getJLblMulta(), null);			
			jPanel1.add(getJLblValor(), null);
			jPanel1.add(getJLblReferencia(), null);
			jPanel1.add(getJLabel3(), null);
			
			jPanel1.setBounds(9, 52, 698, 221);
			jPanel1.setBorder(BorderFactory.createLineBorder(Color.black,2));
			jPanel1.setBackground(Color.white);
		}
		return jPanel1;
	}
	/**
	 * This method initializes lblAutenticacao
	 * 
	 * @return javax.swing.JLabel
	 */
	private javax.swing.JLabel getJLblAutenticacao() {
		if(lblAutenticacao == null) {
			lblAutenticacao = new JLabel();
			lblAutenticacao.setBounds(3, 0, 149, 21);
			lblAutenticacao.setText("Recibo de Pagamento");
		}
		return lblAutenticacao;
	}
	/**
	 * This method initializes jButton
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButton() {
		if(jButton == null) {
			jButton = new JButton("Imprimir");
			jButton.setBounds(282, 315, 171, 26);
			jButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					fecharJanela();					
				}});
		}
		return jButton;
	}
	
	private void fecharJanela() {
		this.dispose();
		this.repaint();
	}
	/**
	 * This method initializes jLabel2
	 * 
	 * @return javax.swing.JLabel
	 */
	private javax.swing.JLabel getJLabel2() {
		if(jLabel2 == null) {
			jLabel2 = new JLabel();
			jLabel2.setBounds(10, 27, 63, 20);
			jLabel2.setText("ID Multa : ");
		}
		return jLabel2;
	}
	/**
	 * This method initializes lblIdMulta
	 * 
	 * @return javax.swing.JLabel
	 */
	public JLabel getJLblIdMulta() {
		if(lblIdMulta == null) {
			lblIdMulta = new JLabel();
			lblIdMulta.setBounds(78, 26, 354, 20);
			lblIdMulta.setText("0");
		}
		return lblIdMulta;
	}
	/**
	 * This method initializes jLabel3
	 * 
	 * @return javax.swing.JLabel
	 */
	private javax.swing.JLabel getJLabel3() {
		if(jLabel3 == null) {
			jLabel3 = new javax.swing.JLabel();
			jLabel3.setBounds(12, 140, 360, 29);
			jLabel3.setText("V�lido somente com o carimbo e assinatura da bibliotec�ria");
		}
		return jLabel3;
	}
}  
