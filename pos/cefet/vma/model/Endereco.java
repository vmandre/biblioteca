/*
 * Criado em 24/06/2007
 */
package pos.cefet.vma.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import pos.cefet.vma.component.IntPostgreSQL;

/**
 * @author Vanderlei
 */
public class Endereco {
	
	private IntPostgreSQL postgreSQL;
	private int idUsuario;
	private String logradouro;
	private int numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String uf;
	private long cep;


	public Endereco(){ 
	}
	
	public Endereco(int idUsuario, String logradouro, int numero, String bairro, String complemento, String cidade, long cep, String uf) {
		this.setIdUsuario(idUsuario);
		this.setLogradouro(logradouro);
		this.setNumero(numero);
		this.setBairro(bairro);
		this.setComplemento(complemento);
		this.setCidade(cidade);
		this.setCep(cep);
		this.setUf(uf);
	}
	
	public Endereco getEnderecoByUsuario(int idUsuario) throws ClassNotFoundException, SQLException {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * FROM endereco_930652 WHERE id = " );
		sql.append(idUsuario);
		
		postgreSQL = new IntPostgreSQL();
		ResultSet resultSet = postgreSQL.getDados(sql.toString());

		while (resultSet.next()) {

			int id = resultSet.getInt("id");
			String logradouro = resultSet.getString("logradouro");
			int numero = resultSet.getInt("numero");
			String bairro = resultSet.getString("bairro");
			String complemento = resultSet.getString("complemento");
			String cidade = resultSet.getString("cidade");
			long cep = resultSet.getLong("cep");
			String uf = resultSet.getString("uf");
			
			return new Endereco(id, logradouro, numero, bairro, complemento, cidade, cep, uf);
		}		
		return null;
	}	

	/**
	 * @return
	 */
	public String getBairro() {
		return bairro;
	}

	/**
	 * @return
	 */
	public long getCep() {
		return cep;
	}

	/**
	 * @return
	 */
	public String getCidade() {
		return cidade;
	}

	/**
	 * @return
	 */
	public String getComplemento() {
		return complemento;
	}

	/**
	 * @return
	 */
	public String getLogradouro() {
		return logradouro;
	}

	/**
	 * @return
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * @return
	 */
	public String getUf() {
		return uf;
	}

	/**
	 * @param string
	 */
	public void setBairro(String string) {
		bairro = string;
	}

	/**
	 * @param l
	 */
	public void setCep(long l) {
		cep = l;
	}

	/**
	 * @param string
	 */
	public void setCidade(String string) {
		cidade = string;
	}

	/**
	 * @param string
	 */
	public void setComplemento(String string) {
		complemento = string;
	}

	/**
	 * @param string
	 */
	public void setLogradouro(String string) {
		logradouro = string;
	}

	/**
	 * @param i
	 */
	public void setNumero(int i) {
		numero = i;
	}

	/**
	 * @param string
	 */
	public void setUf(String string) {
		uf = string;
	}

	/**
	 * @return
	 */
	public int getIdUsuario() {
		return idUsuario;
	}

	/**
	 * @param i
	 */
	public void setIdUsuario(int i) {
		idUsuario = i;
	}
	
	public void inserir() throws ClassNotFoundException, SQLException {		
		postgreSQL = new IntPostgreSQL();
		
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO endereco_930652 ");
		sql.append("(id, cep, logradouro, numero, complemento, bairro, cidade, uf) ");
		sql.append("VALUES (");
		sql.append(this.getIdUsuario());
		sql.append(",");
		sql.append(this.getCep());
		sql.append(",");
		sql.append("'");
		sql.append(this.getLogradouro());
		sql.append("'");
		sql.append(",");
		sql.append(this.getNumero());
		sql.append(",");
		sql.append("'");
		sql.append(this.getComplemento());
		sql.append("'");
		sql.append(",");
		sql.append("'");
		sql.append(this.getBairro());
		sql.append("'");
		sql.append(",");
		sql.append("'");
		sql.append(this.getCidade());
		sql.append("'");
		sql.append(",");
		sql.append("'");
		sql.append(this.getUf());
		sql.append("'");
		sql.append(")");
		
		postgreSQL.insert(sql.toString());		
	}
	
	public void excluir() throws ClassNotFoundException, SQLException {
		postgreSQL = new IntPostgreSQL();
		
		StringBuffer sql = new StringBuffer();
		sql.append("DELETE FROM endereco_930652 ");
		sql.append(" WHERE id = ");
		sql.append(this.getIdUsuario());
		
		postgreSQL.update(sql.toString());
	}
	
	public void alterar() throws ClassNotFoundException, SQLException {
		postgreSQL = new IntPostgreSQL();

		StringBuffer sql = new StringBuffer();
		sql.append("UPDATE endereco_930652 SET ");
		sql.append("cep = ");
		sql.append(this.getCep());
		sql.append(",");
		sql.append("logradouro = ");
		sql.append("'");
		sql.append(this.getLogradouro());
		sql.append("'");
		sql.append(",");
		sql.append("numero = ");
		sql.append(this.getNumero());
		sql.append(",");
		sql.append("complemento = ");
		sql.append("'");
		sql.append(this.getComplemento());
		sql.append("'");
		sql.append(",");
		sql.append("bairro = ");
		sql.append("'");
		sql.append(this.getBairro());
		sql.append("'");
		sql.append(",");
		sql.append("cidade = ");
		sql.append("'");
		sql.append(this.getCidade());
		sql.append("'");
		sql.append(",");
		sql.append("uf = ");
		sql.append("'");
		sql.append(this.getUf());
		sql.append("'");
		sql.append(" WHERE id = ");
		sql.append(this.getIdUsuario());

		postgreSQL.insert(sql.toString());
	}

}
