package database;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

public class Conexion {
	private static String db = "Vinateria";
	private static String user = "root";
	private static String pass = "";
	private static String host = "localhost";
	private static String server = "jdbc:mysql://"+host+"/"+db;
	
	
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(server, user, pass);
		} catch (Exception e) {
			System.out.println(String.valueOf(e));
		}
		return con;
	}
	
	public static ResultSet getTabla(String comando) {
		Connection con = getConnection();
		java.sql.Statement st;
		ResultSet datos=null;
		try {
			st = con.createStatement();
			datos = st.executeQuery(comando);
		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return datos;
	} 
	public static void insertar (String table_name,String fields,String values) throws SQLException{
		Connection con = getConnection();
		String insert = "INSERT INTO "+table_name+" ("+fields+")"+"VALUES ("+values+")";
		PreparedStatement preparandoSentencia = (PreparedStatement) con.prepareStatement(
				""+insert
				);
		System.out.println(preparandoSentencia.getPreparedSql());
		preparandoSentencia.execute();		
		System.out.println("Registro completo");
		con.close();
	}
	public static void update(String table_name, String set, String where) throws SQLException{
		Connection con = getConnection();
		String UPDATE = "UPDATE "+table_name+" SET "+set+" WHERE "+where;
		PreparedStatement preparandoSentencia = (PreparedStatement) con.prepareStatement(
				""+UPDATE
				);
		
		System.out.println(preparandoSentencia.getPreparedSql());
		preparandoSentencia.execute();
		System.out.println("Registro actualizado");
		con.close();
	}
	
	public static void delete(String table_name, String where) throws SQLException{
		Connection con = getConnection();
		String DELETE = "DELETE FROM "+table_name+" WHERE "+where;
		PreparedStatement preparandoSentencia = (PreparedStatement) con.prepareStatement(
				""+DELETE
				);
		
		System.out.println(preparandoSentencia.getPreparedSql());
		preparandoSentencia.execute();
		System.out.println("Registro borrado");
		con.close();
	}
	
	public static ResultSet select(String fields, String table_name) throws SQLException{
		Connection con = getConnection();
		String query = "SELECT "+fields+" FROM "+table_name;
		java.sql.Statement st;
		ResultSet rs = null;
		try {
			st = con.createStatement();
			rs = st.executeQuery(query);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return rs;
	}
	
	

}
