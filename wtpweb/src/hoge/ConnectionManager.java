package hoge;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * @author takynd
 *
 */
public class ConnectionManager {
	/**
	 * 
	 */
	final static String DRIVER = "com.mysql.jdbc.Driver";
	/**
	 * 
	 */
	final static String URL = "jdbc:mysql://localhost/mydb";
	/**
	 * 
	 */
	final static String USER = "root";
	/**
	 * 
	 */
	final static String PASS = "";
	
	/**
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		
		try {
			Class.forName(DRIVER);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new IllegalStateException("filed to load the class :" + e.getMessage());
		}
		
		Connection con = DriverManager.getConnection(URL, USER, PASS);
		
		return con;
	}
	
	/**
	 * 
	 * @param args
	 * @throws SQLException
	 */
	public static void main (String[] args) throws SQLException {
		Connection con = getConnection();
		Statement smt = con.createStatement();
		ResultSet rs = smt.executeQuery("select * from account");
		while (rs.next()) {
			String s = "NAME=" + rs.getString("NAME")
			+ ",MONEY=" + rs.getString("MONEY");
			System.out.println(s);
		}
		smt.close();
		con.close();
		System.out.println("END");
	}
	
}
