

package db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;




public class dBConnection {


	

	public static void main(String[] args) {
		Connection conn = null;
		try {
		  // db parameters
		    String url       = "jdbc:mysql://localhost:3306/speople";
		    String user      = "root";
		    String password  = "password";
		    
		    // create a connection to the database
		    conn = DriverManager.getConnection(url, user, password);
		   
		  //  processing here
		    
		    // Create Statment 
		    Statement myStat = conn.createStatement();
		
		    // Execute Query 
		    ResultSet myRs =  myStat.executeQuery("select * from tstaff");
		    
		    
	//	  myStat.executeUpdate("ALTER TABLE tstaff ADD col INT "); 
		    
		    ResultSetMetaData rsmd = myRs.getMetaData();
System.out.println(rsmd.getColumnName(1));
		    
//		    while(myRs.next()) {
//		    	System.out.println(myRs.getString(1) + "-" + myRs.getString(2) );
//		    }
		    
		
		
		} catch(SQLException e) {
		   System.out.println(e.getMessage());
		} finally {
		    try{
		           if(conn !=null)
		             conn.close();
		    }catch(SQLException ex){
		           System.out.println(ex.getMessage());
		    }
		}
	}
	
	
	
}

