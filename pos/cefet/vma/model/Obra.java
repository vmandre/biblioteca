/*
 * Criado em 24/06/2007
 */
package pos.cefet.vma.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import pos.cefet.vma.component.IntPostgreSQL;
import pos.cefet.vma.interfaces.InterfaceObra;
import pos.cefet.vma.view.IntObraAlteracao;
import pos.cefet.vma.view.IntObraInclusao;

/**
 * @author Vanderlei
 */
public class Obra {
	
	private IntPostgreSQL postgreSQL;
	private int id;
	private String descricao;
	private int genero;
	private String autor;
	private String editora;
	private Date dataPublicacao;
	private Date dataAtivacao;
	private Date dataDesativacao;
	private int motivoDesativacao;
	private double valor;

	public Obra(){
	}
	
	public Obra(int id, String descricao, int genero, String autor, String editora, Date dataPublicacao, Date dataAtivacao, Date dataDesativacao, int motivoDesativacao, double valor) {
		this.id = id;
		this.descricao = descricao;
		this.genero = genero;
		this.autor = autor;
		this.editora = editora;
		this.dataPublicacao = dataPublicacao;
		this.dataAtivacao = dataAtivacao;
		this.dataDesativacao = dataDesativacao;
		this.motivoDesativacao = motivoDesativacao;
		this.valor = valor;
	}

	public Obra getObraById(int id) throws ClassNotFoundException, SQLException {
		postgreSQL = new IntPostgreSQL();

		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * FROM obra_930652 WHERE id = ");
		sql.append(id);
		
		ResultSet resultSet = postgreSQL.getDados(sql.toString());
		
		while (resultSet.next()) {

			int id2 = resultSet.getInt("id");
			String descricao = resultSet.getString("descricao");
			int genero = resultSet.getInt("genero");
			String autor = resultSet.getString("autor");
			String editora = resultSet.getString("editora");
			Date dtPublicacao = resultSet.getDate("data_publicacao");
			Date dtAtivacao = resultSet.getDate("data_ativacao");
			Date dtDesativacao = resultSet.getDate("data_desativacao");;
			int motivoDesativacao = resultSet.getInt("motivo_desativacao");
			double valor = resultSet.getDouble("valor");
					
			return this.createObra(id2, descricao, genero, autor, editora, dtPublicacao, dtAtivacao, dtDesativacao, motivoDesativacao, valor);
		}		
		return null;
	}

	/**
	 * @return
	 */
	public String getAutor() {
		return autor;
	}

	/**
	 * @return
	 */
	public Date getDataAtivacao() {
		return dataAtivacao;
	}

	/**
	 * @return
	 */
	public Date getDataDesativacao() {
		return dataDesativacao;
	}

	/**
	 * @return
	 */
	public Date getDataPublicacao() {
		return dataPublicacao;
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
	public String getEditora() {
		return editora;
	}

	/**
	 * @return
	 */
	public int getGenero() {
		return genero;
	}

	/**
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return
	 */
	public int getMotivoDesativacao() {
		return motivoDesativacao;
	}

	/**
	 * @param string
	 */
	public void setAutor(String string) {
		autor = string;
	}

	/**
	 * @param date
	 */
	public void setDataAtivacao(Date date) {
		dataAtivacao = date;
	}

	/**
	 * @param date
	 */
	public void setDataDesativacao(Date date) {
		dataDesativacao = date;
	}

	/**
	 * @param date
	 */
	public void setDataPublicacao(Date date) {
		dataPublicacao = date;
	}

	/**
	 * @param string
	 */
	public void setDescricao(String string) {
		descricao = string;
	}

	/**
	 * @param string
	 */
	public void setEditora(String string) {
		editora = string;
	}

	/**
	 * @param genero
	 */
	public void setGenero(int genero) {
		this.genero = genero;
	}

	/**
	 * @param i
	 */
	public void setId(int i) {
		id = i;
	}

	/**
	 * @param desativacao
	 */
	public void setMotivoDesativacao(int desativacao) {
		motivoDesativacao = desativacao;
	}
	
	public static Object validarDadosObra(Object intObra) {
		
		InterfaceObra interfaceObra = null;
	
		if (intObra instanceof IntObraAlteracao) {
			interfaceObra = (IntObraAlteracao)intObra;
		} else if (intObra instanceof IntObraInclusao) {
			interfaceObra = (IntObraInclusao)intObra;
		} 

		String codigo = interfaceObra.getTxtCodigo().getText();
		int id;
		try {
			id = Integer.parseInt(codigo);
		} catch(NumberFormatException nfe){ return "Código inválido!"; }
		
		String descricao = interfaceObra.getTxtDesricao().getText();
		if (descricao.equals("")) return "A descrição da obra deve ser preenchida!";
		
		int generoSelecionado = interfaceObra.getJCboGenero().getSelectedIndex();
		if (generoSelecionado == 0) return "Selecione um género para a obra!";
		
		String autor = interfaceObra.getTxtAutor().getText();
		if (autor.equals("")) return "O campo Autor deve ser preenchido!";
		
		String editora = interfaceObra.getTxtEditora().getText();
		if (editora.equals("")) return "O campo Editora deve ser preenchido!";
		
		String dtPub = interfaceObra.getTxtDataPublicacao().getText();
		if (dtPub.equals("")) return "O campo Data Publicação deve ser preenchido!";
		
		String dia = interfaceObra.getTxtDataPublicacao().getText().substring(0, 2);
		String mes = interfaceObra.getTxtDataPublicacao().getText().substring(3, 5);
		String ano = interfaceObra.getTxtDataPublicacao().getText().substring(6);
		Calendar dataPublicacao = Calendar.getInstance();
		dataPublicacao.set(Calendar.DAY_OF_MONTH, Integer.parseInt(dia));
		dataPublicacao.set(Calendar.MONTH, Integer.parseInt(mes)-1);
		dataPublicacao.set(Calendar.YEAR, Integer.parseInt(ano));
		dataPublicacao.set(Calendar.HOUR_OF_DAY, 0);
		dataPublicacao.set(Calendar.MINUTE, 0);
		dataPublicacao.set(Calendar.SECOND, 0);
		
		Calendar dataAtual = Calendar.getInstance();
		dataAtual.set(Calendar.HOUR_OF_DAY, 0);
		dataAtual.set(Calendar.MINUTE, 0);
		dataAtual.set(Calendar.SECOND, 0);
				
		if (dataAtual.getTime().before(dataPublicacao.getTime())) {return "Data de publicação inválida!";}
		
		String valor = interfaceObra.getTxtValor().getText();
		double valorObra;
		try {
			valorObra = Double.parseDouble(valor);
		} catch (NumberFormatException e) {
			return "Valor inválido. Se o valor tiver vírgula, substitua por ponto (.)!";
		}

		return new Obra(id, descricao, generoSelecionado, autor, editora, dataPublicacao.getTime(), dataAtual.getTime(), null, 0, valorObra);
	}
	
	public Obra createObra(int id, String descricao, int genero, String autor, String editora, Date dataPublicacao, 
		Date dataAtivacao, Date dataDesativacao, int motivoDesativacao, double valor) {
			
		return new Obra(id, descricao, genero, autor, editora, dataPublicacao, dataAtivacao, dataDesativacao, motivoDesativacao, valor);
	}
	
	public void inserir() throws ClassNotFoundException, SQLException {		
		postgreSQL = new IntPostgreSQL();
		
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO obra_930652 ");
		sql.append("(id, descricao, genero, autor, editora, data_publicacao, data_ativacao, valor) ");
		sql.append("VALUES (");
		sql.append(this.getId());
		sql.append(", ");
		sql.append("'");
		sql.append(this.getDescricao());
		sql.append("'");
		sql.append(", ");
		sql.append(this.getGenero());
		sql.append(", ");
		sql.append("'");
		sql.append(this.getAutor());
		sql.append("'");
		sql.append(", ");
		sql.append("'");
		sql.append(this.getEditora());
		sql.append("'");
		sql.append(", ");
		sql.append("'");

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(this.getDataPublicacao());
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sql.append(dateFormat.format(calendar.getTime()));
		sql.append("'");
		sql.append(", ");
		sql.append("'");
		sql.append(dateFormat.format(Calendar.getInstance().getTime())); //Data e hora da ativação
		sql.append("'");
		sql.append(", ");
		sql.append(this.getValor());
		sql.append(")");
		
		postgreSQL.insert(sql.toString());		
	}
	
	public void alterar() throws ClassNotFoundException, SQLException {		
		postgreSQL = new IntPostgreSQL();
		
		StringBuffer sql = new StringBuffer();
		sql.append("UPDATE obra_930652 SET ");
		sql.append("descricao = ");
		sql.append("'");
		sql.append(this.getDescricao());
		sql.append("'");
		sql.append(", ");
		sql.append("genero = ");
		sql.append(this.getGenero());
		sql.append(", ");
		sql.append("autor = ");
		sql.append("'");
		sql.append(this.getAutor());
		sql.append("'");
		sql.append(", ");
		sql.append("editora = ");
		sql.append("'");
		sql.append(this.getEditora());
		sql.append("'");
		sql.append(", ");
		sql.append("data_publicacao = ");
		sql.append("'");

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(this.getDataPublicacao());
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sql.append(dateFormat.format(calendar.getTime()));
		sql.append("'");
		sql.append(", ");

		sql.append("data_desativacao = ");
		sql.append("'");

		Calendar calendar2 = Calendar.getInstance();
		SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sql.append(dateFormat2.format(calendar2.getTime()));
		sql.append("'");
		sql.append(", ");
		sql.append("valor = ");
		sql.append(this.getValor());

		//Acrescenta ao update somente se a obra estiver sendo desativada (motivo != 0)		
		if (this.getMotivoDesativacao() != 0) {
			sql.append(", ");
			sql.append("motivo_desativacao = ");
			sql.append(this.getMotivoDesativacao());
		}

		sql.append(" WHERE id = ");
		sql.append(this.getId());
		
		postgreSQL.insert(sql.toString());		
	}
	
	public void excluir() throws ClassNotFoundException, SQLException {
		postgreSQL = new IntPostgreSQL();
		
		StringBuffer sql = new StringBuffer();
		sql.append("DELETE FROM obra_930652 ");
		sql.append("WHERE id = ");
		sql.append(this.getId());
		
		//postgreSQL.update(sql.toString());
		throw new SQLException("Por questões de auditoria, apenas será possível desabilitar a obra para empréstimo!");
	}

	/**
	 * @return
	 */
	public double getValor() {
		return valor;
	}

	/**
	 * @param d
	 */
	public void setValor(double d) {
		valor = d;
	}

}
