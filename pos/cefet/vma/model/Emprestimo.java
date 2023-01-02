/*
 * Criado em 24/06/2007
 */
package pos.cefet.vma.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import pos.cefet.vma.component.IntPostgreSQL;
import pos.cefet.vma.constants.BIBConstants;

/**
 * @author Vanderlei
 */
public class Emprestimo {
	
	private ArrayList emprestimosAbertosByUsuario;
	private IntPostgreSQL postgreSQL;
	private int idUsuario;
	private int idObra;
	private Date dtEmprestimo;
	private Date dtDevolucao;
	
	private ArrayList emprestimosAtrasados;
	
	public Emprestimo() {}
	
	public Emprestimo(int idUsuario, int idObra, Date dtEmprestimo, Date dtDevolucao) {
		this.idUsuario = idUsuario;
		this.idObra = idObra;
		this.dtEmprestimo = dtEmprestimo;
		this.dtDevolucao = dtDevolucao;
	}
	
	public int registrarEmprestimo() throws ClassNotFoundException, SQLException {
		postgreSQL = new IntPostgreSQL();
		
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO emprestimo_930652 ");
		sql.append("(id_usuario, id_obra, data_emprestimo) ");
		sql.append("VALUES (");
		sql.append(this.getIdUsuario());
		sql.append(", ");
		sql.append(this.getIdObra());
		sql.append(", ");
		sql.append("'");		

		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sql.append(dateFormat.format(calendar.getTime()));
		sql.append("'");
		sql.append(")");
		
		return postgreSQL.insert(sql.toString());	
	}
	
	public int registrarDevolucao() throws ClassNotFoundException, SQLException {
		postgreSQL = new IntPostgreSQL();
		
		StringBuffer sql = new StringBuffer();
		sql.append("UPDATE emprestimo_930652 ");
		sql.append("SET data_devolucao = ");

		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sql.append("'");
		sql.append(dateFormat.format(calendar.getTime()));
		sql.append("'");
		sql.append(" WHERE id_obra = ");
		sql.append(this.getIdObra());
		
		return postgreSQL.update(sql.toString());
	}
	
	public Emprestimo getEmprestimoAberto(int idObra) throws ClassNotFoundException, SQLException {
		
		Calendar data = Calendar.getInstance();
		data.set(Calendar.DAY_OF_MONTH, (data.get(Calendar.DAY_OF_MONTH) - BIBConstants.LIMITE_DIAS_EMPRESTIMO));
		data.set(Calendar.HOUR_OF_DAY, 23);
		data.set(Calendar.MINUTE, 59);
		data.set(Calendar.SECOND, 59);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * FROM emprestimo_930652 WHERE id_obra = " );
		sql.append(idObra);
		sql.append(" AND ");
		sql.append("data_devolucao IS NULL"); 
		
		postgreSQL = new IntPostgreSQL();
		ResultSet resultSet = postgreSQL.getDados(sql.toString());

		while (resultSet.next()) {

			int idUsuario = resultSet.getInt("id_usuario");
			int idObra2 = resultSet.getInt("id_obra");
			Date dtEmprestimo = resultSet.getDate("data_emprestimo");
			
			return this.createEmprestimo(idUsuario, idObra2, dtEmprestimo, null);
		}
		
		return null;
	}
	
	public ArrayList getEmprestimosAbertoByUsuario(int idUsuario) throws ClassNotFoundException, SQLException {
		emprestimosAbertosByUsuario = new ArrayList();
		
		Calendar data = Calendar.getInstance();
		data.set(Calendar.DAY_OF_MONTH, (data.get(Calendar.DAY_OF_MONTH) - BIBConstants.LIMITE_DIAS_EMPRESTIMO));
		data.set(Calendar.HOUR_OF_DAY, 23);
		data.set(Calendar.MINUTE, 59);
		data.set(Calendar.SECOND, 59);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		StringBuffer sql = new StringBuffer();

		sql.append("SELECT * FROM emprestimo_930652 WHERE id_usuario = " );
		sql.append(idUsuario);
		sql.append(" AND ");
		sql.append("data_devolucao IS NULL"); 
		
		postgreSQL = new IntPostgreSQL();
		ResultSet resultSet = postgreSQL.getDados(sql.toString());

		while (resultSet.next()) {

			int idUsuario2 = resultSet.getInt("id_usuario");
			int idObra2 = resultSet.getInt("id_obra");
			Date dtEmprestimo = resultSet.getDate("data_emprestimo");
			
			emprestimosAbertosByUsuario.add(this.createEmprestimo(idUsuario2, idObra2, dtEmprestimo, null));
		}
		
		return emprestimosAbertosByUsuario;
	}
	
	public ArrayList getEmprestimosAtrasadosByUsuario(int id) throws ClassNotFoundException, SQLException {
		emprestimosAtrasados = new ArrayList();
		
		Calendar data = Calendar.getInstance();
		data.set(Calendar.DAY_OF_MONTH, (data.get(Calendar.DAY_OF_MONTH) - BIBConstants.LIMITE_DIAS_EMPRESTIMO));
		data.set(Calendar.HOUR_OF_DAY, 23);
		data.set(Calendar.MINUTE, 59);
		data.set(Calendar.SECOND, 59);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		StringBuffer sql = new StringBuffer();

		sql.append("SELECT * FROM emprestimo_930652 WHERE id_usuario = " );
		sql.append(id);
		sql.append(" AND data_emprestimo < ");
		//hoje - limite dias emprestimo
		sql.append("'");
		sql.append(dateFormat.format(data.getTime()));
		sql.append("'");
		sql.append(" AND ");
		sql.append("data_devolucao IS NULL"); 
		
		postgreSQL = new IntPostgreSQL();
		ResultSet resultSet = postgreSQL.getDados(sql.toString());

		while (resultSet.next()) {

			int idUsuario = resultSet.getInt("id_usuario");
			int idObra = resultSet.getInt("id_obra");
			Date dtEmprestimo = resultSet.getDate("data_emprestimo");
			
			emprestimosAtrasados.add(this.createEmprestimo(idUsuario, idObra, dtEmprestimo, null));
		}
		
		return emprestimosAtrasados;
	}
	
	public Emprestimo createEmprestimo(int idUsuario, int idObra, Date dtEmprestimo, Date dtDevolucao) {
		return new Emprestimo(idUsuario, idObra, dtEmprestimo, dtDevolucao);
	}
	

	/**
	 * @return
	 */
	public Date getDtDevolucao() {
		return dtDevolucao;
	}

	/**
	 * @return
	 */
	public Date getDtEmprestimo() {
		return dtEmprestimo;
	}

	/**
	 * @return
	 */
	public ArrayList getEmprestimosAtrasados() {
		return emprestimosAtrasados;
	}

	/**
	 * @return
	 */
	public int getIdObra() {
		return idObra;
	}

	/**
	 * @return
	 */
	public int getIdUsuario() {
		return idUsuario;
	}

	/**
	 * @param date
	 */
	public void setDtDevolucao(Date date) {
		dtDevolucao = date;
	}

	/**
	 * @param date
	 */
	public void setDtEmprestimo(Date date) {
		dtEmprestimo = date;
	}

	/**
	 * @param list
	 */
	public void setEmprestimosAtrasados(ArrayList list) {
		emprestimosAtrasados = list;
	}

	/**
	 * @param i
	 */
	public void setIdObra(int i) {
		idObra = i;
	}

	/**
	 * @param i
	 */
	public void setIdUsuario(int i) {
		idUsuario = i;
	}

}
