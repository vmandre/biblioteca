/*
 * Criado em 23/06/2007
 *
 */
package pos.cefet.vma.component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Vanderlei
 *
 */
public class IntPostgreSQL {
	
	private ResultSet result;
	private Connection conn;
	private PreparedStatement pstmt;
	
	public IntPostgreSQL() throws ClassNotFoundException, SQLException {
		conn = ConnectionFactory.getConnection();						
	}
	
	public int insert(String sql) throws SQLException{	
		pstmt = conn.prepareStatement(sql);
		
		int result = pstmt.executeUpdate();
		
		return result;
	}
	
	public void delete(){
	}
	
	public int update(String sql) throws SQLException{
		pstmt = conn.prepareStatement(sql);
		
		int result = pstmt.executeUpdate();
		
		return result;
	}
	
	public ResultSet getDados(String sql) throws SQLException{
		
		pstmt = conn.prepareStatement(sql);
		
		this.setDados(pstmt.executeQuery());
		
		return result;
	}
	
	private void setDados(ResultSet result) {
		this.result = result;
	}
	
	public Connection getConnection() {
		return conn;
	}

}
