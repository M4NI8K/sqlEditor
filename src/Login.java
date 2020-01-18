import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Login {

	private JFrame frame;
	private JTextField textUsername;
	private JPasswordField passwordField;
	private JLabel lblAddressLabel;
	private JButton btnLogin;
		
	private Connection conn = null;
	private ResultSet myRs; 
	ResultSetMetaData rsmd;
	
	boolean ifConectedBool; 
	
	String tabelArr [][];	
	
	
	
	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	 Login() {
		initialize();
		events(); // in loginBTn starts connection
		 		
	}
	
	
	private void Connection() {
	try {
	    String url       = lblAddressLabel.getText();
	    String user      = textUsername.getText();
	    String password  = String.valueOf(passwordField.getPassword());
	    
	    // create a connection to the database
	    conn = DriverManager.getConnection(url, user, password);
	   
	  //  processing here
	    
	    // Create Statment 
	    Statement myStat = conn.createStatement();
	
	    // Execute Query 
	     myRs =  myStat.executeQuery("select * from tstaff"); // ResultSet myRs
	    
	    
//	  myStat.executeUpdate("ALTER TABLE tstaff ADD col INT "); 
	    
	     rsmd = myRs.getMetaData(); // ResultSetMetaData
//	  System.out.println(rsmd.getColumnName(1));
	    
//	    while(myRs.next()) {
//	    	System.out.println(myRs.getString(1) + "-" + myRs.getString(2) );
//	    }
	    
//////////////////////////////////////////////////////////////////////	   
			int countColumn = rsmd.getColumnCount(); // number of collums
			int countRow  = 0 ;
						
			while(myRs.next()) {				
				countRow ++;			
			}	
			
			tabelArr = new String[countColumn][countRow];
			myRs.beforeFirst();
//		System.out.println(countColumn);	 dziala = 4	
			
						
//			String columnName[] = new String[countColumn]; //collumn names print to array TODO
//			for (int i = 1; i <= countColumn; i++)
//			{
//			   columnName[i-1] = rsmd.getColumnLabel(i);
////		System.out.println(columnName[i-1]);		   		
//			}
		
			
			int j= 1;
			 while (myRs.next()) {			  
	                for (int i = 0; i < countColumn; ++i) {	                		
	                	tabelArr[i][j] = myRs.getString(i+1) ;
	                	System.out.println(tabelArr[i][j]);
	                }                               
			 }
			

			 ifConectedBool = true;	 
			 
			 
			 
///////////////////////////////////////////////////////////////	
	
	} catch(SQLException e) {
	   System.out.println(e.getMessage());
	   System.out.println("SQLException1");
	   
	} finally {
	    try{
	           if(conn !=null)
	             conn.close();
	    }catch(SQLException ex){
	           System.out.println(ex.getMessage());
	           System.out.println("SQLException2");
	    }
	
	    
	}
		
	}
////////////Events////////////////////////////////////////////////////
	private void events() {
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {			
												
				Connection(); ////////////////////Connection Starts
							
			}
		});
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
////////////////////////////////////////////////////////////////////////////////////
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		lblAddressLabel = new JLabel("jdbc:mysql://localhost:3306/speople");
		
		textUsername = new JTextField();
		textUsername.setColumns(10);
		
		passwordField = new JPasswordField();
		
		btnLogin = new JButton("Login");
	
		
		
		
///////////////////////JFrame Group Layout////////////////////////////////////		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(textUsername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAddressLabel, GroupLayout.PREFERRED_SIZE, 331, GroupLayout.PREFERRED_SIZE)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(72, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(187, Short.MAX_VALUE)
					.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
					.addGap(164))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(27)
					.addComponent(lblAddressLabel)
					.addGap(26)
					.addComponent(textUsername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnLogin)
					.addContainerGap(124, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
////////////////////////////////////////////////////////////////////////////////////
	}
		

	public boolean ifConnected() {		
		return ifConectedBool;
	}
	
	public void makeVisable(boolean visable) {		
		frame.setVisible(visable);
				
	}
	
	

		
			
				
		
	
}
