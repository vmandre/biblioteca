/*
 * Criado em 22/06/2007
 *
 */
package pos.cefet.vma.component;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * @author Vanderlei Matos Andre
 *
 */
public class ConnectionFactory {
	
	private static final String URL = "jdbc:postgresql://localhost/aval_db";
	private static final String USER = "aval_user";	
	private static final String PWD = "aval_pwd";
	
	private static Connection conn;
	 
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		if (conn == null) {			
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(URL, USER, PWD);			
		}
		return conn;
	}
}