package icb.test.JDBCTests;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import org.junit.Test;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

public class DBTests {

	@Test  
     public void main() {
		
		// Declare the JDBC objects.
		Connection con = null;
		ResultSet rs = null;
	    Statement stat;
		
		try {
			// Establish the connection. 
			SQLServerDataSource ds = new SQLServerDataSource();
			ds.setIntegratedSecurity(false);
			ds.setServerName("DEV-74");
			ds.setDatabaseName("CXC_DM_Test");
			ds.setUser("CXC");
			ds.setPassword("12345");
			con = ds.getConnection();	
			 if (con != null) {
			        System.out.println("Connected");
			 }
			 
        	// Execute SQL query that returns some data.

			String sql = "Select * from dbo.Country";
			stat = con.createStatement();
			rs = stat.executeQuery(sql);
			//int count=0;

	        	// Iterate through the data in the result set and display it.
	        	while (rs.next()) {
	        		System.out.println("Country: " + rs.getString("CountryName"));
	            	}
	        }
	        
		// Handle any errors that may have occurred.
	    	catch (Exception e) {
	    		e.printStackTrace();
	    	}

	   	finally {
	    		if (rs != null) try { rs.close(); } catch(Exception e) {}
	    		if (con != null) try { con.close(); } catch(Exception e) {}
	    	}
	}
	
}
