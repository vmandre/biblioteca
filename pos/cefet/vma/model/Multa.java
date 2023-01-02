/*
 * Criado em 25/06/2007
 *
 */
package pos.cefet.vma.model;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import pos.cefet.vma.component.IntPostgreSQL;
import pos.cefet.vma.constants.BIBConstants;

/**
 * @author Vanderlei Matos Andre
 *
 */
public class Multa {
	
	private ArrayList multas;
	private IntPostgreSQL postgreSQL;
	private Date dataEmissao;
	private int idObra;
	private int idUsuario;
	private Date dataPagamento;
	private double valor;
	private char motivo; // Valores possíveis {A - Atraso e E - Extravio}
	private int diasAtraso;
	private long idMulta;
	
	public Multa(){
	}

	/**
	 * Construtor da classe
	 * @param emprestimo Dados do empréstimo
	 * @param diasAtraso Se o motivo da multa for por extravio, passar 0 (zero)
	 */
	public Multa(Emprestimo emprestimo, int diasAtraso){
		this.idObra = emprestimo.getIdObra();
		this.idUsuario = emprestimo.getIdUsuario();
		
		if (diasAtraso > 0) {
			this.valor = BIBConstants.VALOR_MULTA_DIARIO * diasAtraso;
			this.motivo = 'A';
			this.diasAtraso = diasAtraso;
			
		} else { //Multa por extravio
			Obra obra = new Obra();
			double valorObra = 0.0;
			try {
				valorObra = obra.getObraById(this.idObra).getValor();
			} catch (ClassNotFoundException e) {
			} catch (SQLException e) {}
			
			this.valor = valorObra;
			this.motivo = 'E';
			this.diasAtraso = 0;
		}				
	}
	
	public Multa(Date dtEmissao, int idObra, int idUsuario, Date dtPagamento, double valor, char motivo, int diasAtraso, long idMulta2) {
		this.dataEmissao = dtEmissao;
		this.idObra = idObra;
		this.idUsuario = idUsuario;
		this.dataPagamento = dtPagamento;
		this.valor = valor;
		this.motivo = motivo;
		this.diasAtraso = diasAtraso;
		this.idMulta = idMulta2;
	}
	
	public ArrayList getMultasByUsuario(int idUser) throws ClassNotFoundException, SQLException {
		multas = new ArrayList();
		
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * FROM multa_930652 WHERE id_usuario = " );
		sql.append(idUser);
		sql.append(" AND ");
		sql.append("data_pagamento IS NULL");
		
		postgreSQL = new IntPostgreSQL();
		ResultSet resultSet = postgreSQL.getDados(sql.toString());

		while (resultSet.next()) {

			Date dtEmissao = resultSet.getDate("data_emissao");
			int idObra2 = resultSet.getInt("id_obra");
			int idUsuario2 = resultSet.getInt("id_usuario");
			Date dtPagamento = resultSet.getDate("data_pagamento");
			double valor  = resultSet.getDouble("valor");
			char motivo = resultSet.getString("motivo").toCharArray()[0];
			int diasAtraso = resultSet.getInt("dias_atraso");
			long idMulta2 = resultSet.getLong("id_multa");
			
			multas.add(new Multa(dtEmissao, idObra2, idUsuario2, dtPagamento, valor, motivo, diasAtraso, idMulta2));
		}
		
		return multas; 		
	}
	
	public void createMulta() throws ClassNotFoundException, SQLException, IOException{
		postgreSQL = new IntPostgreSQL();
		
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO multa_930652 ");
		sql.append("(data_emissao, id_obra, id_usuario, valor, motivo, dias_atraso, id_multa) ");
		sql.append("VALUES (");
		sql.append("'");		

		Date dataAtual = Calendar.getInstance().getTime();
		this.setDataEmissao(dataAtual);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sql.append(dateFormat.format(dataAtual)); //Data e hora da multa
		sql.append("'");
		sql.append(", ");
		sql.append(this.getIdObra());
		sql.append(", ");
		sql.append(this.getIdUsuario());
		sql.append(", ");
		sql.append(this.getValor());
		sql.append(", ");
		sql.append("'");
		sql.append(this.getMotivo());
		sql.append("'");
		sql.append(", ");
		sql.append(this.diasAtraso);
		sql.append(", ");

		long idDaMulta = dataAtual.getTime() + this.idObra + this.idUsuario;
		this.setIdMulta(idDaMulta);
		sql.append(idDaMulta);
		sql.append(")");
				
		postgreSQL.insert(sql.toString());	
	}
	
	public void emitirMulta(){
	}
	
	public ArrayList getMultasPagasByUsuario() {
		return null;
	}
	
	public void imprimirRecibo(){
		
	}
	
	public void registrarPagamento() throws ClassNotFoundException, SQLException{
		postgreSQL = new IntPostgreSQL();
		
		StringBuffer sql = new StringBuffer();
		sql.append("UPDATE multa_930652 SET data_pagamento = " );
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sql.append("'");
		sql.append(dateFormat.format(Calendar.getInstance().getTime())); //Data e hora atual
		sql.append("'");
		sql.append(" WHERE id_multa = ");
		sql.append(this.getIdMulta());

		postgreSQL.update(sql.toString());
	}
	
	public Multa getMultaById(long id) throws ClassNotFoundException, SQLException {
		
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * FROM multa_930652 WHERE id_multa = " );
		sql.append(id);
		sql.append(" AND ");
		sql.append("data_pagamento IS NULL");
		
		postgreSQL = new IntPostgreSQL();
		ResultSet resultSet = postgreSQL.getDados(sql.toString());

		while (resultSet.next()) {

			Date dtEmissao = resultSet.getDate("data_emissao");
			int idObra2 = resultSet.getInt("id_obra");
			int idUsuario2 = resultSet.getInt("id_usuario");
			Date dtPagamento = resultSet.getDate("data_pagamento");
			double valor  = resultSet.getDouble("valor");
			char motivo = resultSet.getString("motivo").toCharArray()[0];
			int diasAtraso = resultSet.getInt("dias_atraso");
			long idMulta2 = resultSet.getLong("id_multa");
			
			return new Multa(dtEmissao, idObra2, idUsuario2, dtPagamento, valor, motivo, diasAtraso, idMulta2);
		}
		
		return null;
	}
	
	public int insert(){
		return 1;
	}

	/**
	 * @return
	 */
	public Date getDataEmissao() {
		return dataEmissao;
	}

	/**
	 * @return
	 */
	public Date getDataPagamento() {
		return dataPagamento;
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
	 * @return
	 */
	public char getMotivo() {
		return motivo;
	}

	/**
	 * @return
	 */
	public double getValor() {
		return valor;
	}

	/**
	 * @param date
	 */
	public void setDataEmissao(Date date) {
		dataEmissao = date;
	}

	/**
	 * @param date
	 */
	public void setDataPagamento(Date date) {
		dataPagamento = date;
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

	/**
	 * @param c
	 */
	public void setMotivo(char c) {
		motivo = c;
	}

	/**
	 * @param d
	 */
	public void setValor(double d) {
		valor = d;
	}

	/**
	 * @return
	 */
	public int getDiasAtraso() {
		return diasAtraso;
	}

	/**
	 * @param i
	 */
	public void setDiasAtraso(int i) {
		diasAtraso = i;
	}

	/**
	 * @return
	 */
	public long getIdMulta() {
		return idMulta;
	}

	/**
	 * @param l
	 */
	public void setIdMulta(long l) {
		idMulta = l;
	}

}
