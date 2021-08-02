package com.ptit.getConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;




public class GetConnection {
	
	String url ="jdbc:mysql://localhost:3306/applicationdomain";
	
	
	String username= "root";
	
	
	String password= "sang123";

	
	
	
	public Connection getConnection() {

		
		
		
		
		Connection conn=null; 
		try {
			 conn = DriverManager.getConnection(url, username, password);
			if(conn!=null) {
				System.out.println("Connect succeeded");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Connect failed!");
		}
		return conn; 
		
	}
}
