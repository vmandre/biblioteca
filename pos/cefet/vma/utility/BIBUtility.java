/*
 * Criado em 25/06/2007
 *
 */
package pos.cefet.vma.utility;

import java.util.Date;

/**
 * @author Vanderlei Matos Andre
 *
 */
public class BIBUtility {
	
	public static String converterDoubleToMoeda(double valor) {
		String valorConvertido = "";
		
		String aux = String.valueOf(valor);
		int idxPonto = aux.indexOf('.');
		
		if (idxPonto != -1) {			
			valorConvertido = 
				aux.substring(0, idxPonto)
				+ "," 
				+ aux.substring(idxPonto+1, aux.length());
		}
				
		return "R$ " + valorConvertido + "0";
	}

}
