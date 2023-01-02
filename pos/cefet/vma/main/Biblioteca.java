/*
 * Criado em 22/06/2007
 *
 */
package pos.cefet.vma.main;

import javax.swing.JFrame;

import pos.cefet.vma.control.CtrlBiblioteca;

/**
 * @author Vanderlei Matos Andre
 *
 */
public class Biblioteca {

	public static void main(String[] args) {
		
		CtrlBiblioteca ctrlBiblioteca = new CtrlBiblioteca();
		ctrlBiblioteca.setSize(800, 600);
		ctrlBiblioteca.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JFrame.setDefaultLookAndFeelDecorated(true);
		ctrlBiblioteca.setVisible(true);
		
	}
}
