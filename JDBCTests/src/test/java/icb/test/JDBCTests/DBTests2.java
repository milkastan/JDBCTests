package icb.test.JDBCTests;

import java.sql.ResultSet;

import org.junit.Test;



import icb.test.JDBCTests.JDBCFunc;

public class DBTests2 {
    String srvname="DEV-74";
    String dbname="CXC_DM_Test";
	String user="CXC";
	String pass="12345";
	ResultSet rs;
	String connurl="jdbc:sqlserver://;serverName=DEV-74;"
            +"databaseName=CXC_DM_Test; user=CXC; password=12345; integratedSecurity=false;";
	
	@Test  
	public void DBTest1() {
		JDBCFunc.con=JDBCFunc.ConnectToDB(user, pass, dbname, srvname);
		String sql="Select * from dbo.Country";
		rs = JDBCFunc.ExecuteSQLQuery(sql);
		JDBCFunc.PrintCountryNames(rs);
		JDBCFunc.CloseDBConnection(JDBCFunc.con);
	}
	
	
	@Test  
	public void DBTest2() {
		JDBCFunc.con=JDBCFunc.ConnectToDBbyURL(connurl);
		String sql="Select * from dbo.Country";
		rs = JDBCFunc.ExecuteSQLQuery(sql);
		JDBCFunc.PrintCountryNames(rs);
		JDBCFunc.CloseDBConnection(JDBCFunc.con);
	}
	
}
