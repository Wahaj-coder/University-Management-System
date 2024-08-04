package com.tech.blog.helper;
import java.sql.*;
public class ConnectionProvider {

	private static Connection con;
	public static Connection getConnection() {
		
		try {
			
			if(con==null) {
				
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","SYS as SYSDBA","12345678")	;	
				
			}
			
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(e.getMessage());		        
	        
		}
		return con;
	}
}
