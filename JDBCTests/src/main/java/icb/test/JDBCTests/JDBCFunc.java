package icb.test.JDBCTests;

import java.sql.*;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

public class JDBCFunc {

	public static Connection con = null;
	private static ResultSet rs = null;
    private static Statement stat;
        
	public JDBCFunc() {}
	
	public static Connection ConnectToDB(String user, String pass, String dbname, String srvname) {

		try {
			// Establish the connection. 
			SQLServerDataSource ds = new SQLServerDataSource();
			ds.setIntegratedSecurity(false);
			ds.setServerName(srvname);
			ds.setDatabaseName(dbname);
			ds.setUser(user);
			ds.setPassword(pass);
			con = ds.getConnection();			
			if (con != null) {
			        System.out.println("Connected to DB: "+dbname);
			 }
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return con;
	}
	
	public static Connection ConnectToDBbyURL(String connurl) {
		try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");	
		con = DriverManager.getConnection(connurl);
		if (con != null) {
	        System.out.println("Connected to database: ");
	 }	
		} 
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return con;
	}
	
	public static void CloseDBConnection(Connection con) {
   		if (con != null) try { con.close(); } catch(Exception e) {}
	}
	
	private static void CloseRS(ResultSet rs){
		if (rs != null) try { rs.close(); } catch(Exception e) {}
	}
	
	public static ResultSet ExecuteSQLQuery(String sql){
		try {
		stat = con.createStatement();
		rs = stat.executeQuery(sql);
		}
		catch (Exception e) {
    		e.printStackTrace();
    	}
		return rs;
	}
	
	public static void PrintCountryNames(ResultSet rs) {
    		try {
				while (rs.next()) {
				System.out.println("Country: " + rs.getString("CountryName"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		CloseRS(rs);
	}
}
