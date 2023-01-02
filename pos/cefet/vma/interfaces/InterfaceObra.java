/*
 * Criado em 27/06/2007
 *
 */
package pos.cefet.vma.interfaces;

import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 * @author Vanderlei Matos Andre
 *
 */
public interface InterfaceObra {
	
	public JTextField getTxtCodigo();
	public JTextField getTxtDesricao();
	public JTextField getTxtAutor();
	public JTextField getTxtEditora();
	public JTextField getTxtDataPublicacao();
	public JTextField getTxtDtAtivacao();
	public JComboBox getJCboGenero();
	public JTextField getTxtValor();

}
