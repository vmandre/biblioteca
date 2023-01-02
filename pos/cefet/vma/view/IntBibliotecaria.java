/*
 * Criado em 24/06/2007
 */
package pos.cefet.vma.view;

import java.awt.event.ActionListener;

import javax.swing.JInternalFrame;

/**
 * @author Vanderlei
 */
public class IntBibliotecaria {
	
	private ActionListener listenerControl;

	/**
	 * 
	 */
	public IntBibliotecaria(String title, boolean resizable, boolean closable, ActionListener listenerControl) {
		this.listenerControl = listenerControl;
	}

	public IntBibliotecaria(ActionListener listenerControl) {
		this.listenerControl = listenerControl;
	}

	public IntBibliotecaria() {
	}
	
	public JInternalFrame mostrarJanela(JInternalFrame frame) {
		return frame;
	}	
}
