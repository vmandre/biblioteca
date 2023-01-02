/*
 * Criado em 24/06/2007
 */
package pos.cefet.vma.model;

import java.util.ArrayList;

/**
 * @author Vanderlei
 */
public class Genero {

	private int id;
	private String descricao;
	private ArrayList generos;
	
	public ArrayList getGeneros(){
		return generos;
	}

	/**
	 * @return
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param string
	 */
	public void setDescricao(String string) {
		descricao = string;
	}

	/**
	 * @param i
	 */
	public void setId(int i) {
		id = i;
	}
}
