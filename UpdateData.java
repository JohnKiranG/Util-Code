import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateData {
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";  
	// static final String DB_URL = "jdbc:sqlserver://10.0.2.200:1434;databaseName=EZCONSENT_TEST";
	static final String DB_URL ="jdbc:sqlserver://10.0.5.200:1434;databaseName=EZCONSENT_PROD";

	//  Database credentials
	static final String USER = "acsctms";
	static final String PASS = "Ac$rui#12keknel99";

 	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try{
			//STEP 2: Register JDBC driver
			Class.forName(JDBC_DRIVER);

			//STEP 3: Open a connection
			System.out.println("Connecting to a selected database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connected database successfully...");
			
			//STEP 4: Execute a query
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sql = "UPDATE CONSENT_VERSION SET BUILD_STATUS = 'INPROGRESS' WHERE ID='CD17FE47-6BA9-49C7-8425-2DF0C504A8B1'";
			stmt.executeUpdate(sql);

			
		}catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();
		}catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
		}finally{
			//finally block used to close resources
			try{
				if(stmt!=null)
				conn.close();
			}catch(SQLException se){
			}// do nothing
			try{
				if(conn!=null)
				conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}//end finally try
		}//end try
	}//end main

}
