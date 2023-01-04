/*
 * Criado em 26/06/2007
 *
 */
package pos.cefet.vma.utility;

import javax.swing.JOptionPane;

/**
 * @author Vanderlei Matos Andre
 *
 */
public class BIBMessage {

	public static void showInfo(String message) {
		JOptionPane.showMessageDialog(
			null,
			message,
			"INFO",
			JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static void showError(Object obj) {
		JOptionPane.showMessageDialog(
			null,
			obj,
			"ERRO",
			JOptionPane.ERROR_MESSAGE);
	}
	
	public static void showWarning(String message) {
		JOptionPane.showMessageDialog(
			null,
			message,
			"AVISO",
			JOptionPane.WARNING_MESSAGE);
	}
	
	public static int showExcludeQuestion() {
		return JOptionPane.showConfirmDialog(
			null,
			"Deseja realmente excluir ?",
			"EXCLUIR",
			JOptionPane.YES_NO_OPTION); 
	}
	
	public static int showDesativationQuestion() {
		return JOptionPane.showConfirmDialog(
			null,
			"Deseja realmente desativar o usuário?",
			"DESATIVAR",
			JOptionPane.YES_NO_OPTION); 
	}
}
