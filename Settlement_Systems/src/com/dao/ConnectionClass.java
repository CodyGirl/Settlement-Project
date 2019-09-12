package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionClass {

	
	
	public  static Connection openConnection(){
		Connection connection= null;
		try {
			
			//open connection
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("driver loaded successfully");
			
			//jdbc:data_base:install_server:post/databse
			//2.connection
			 connection= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
			//hr is username
			//hr is portname
			System.out.println("Connection obtained");
		} catch (ClassNotFoundException  |  SQLException e ) {
			// TODO Auto-generated catch block
			//System.out.println("oye hoye");
			e.printStackTrace();
		}
		//System.out.println("oye oye");
		return connection;
	}
	
	
	
	
	
	
	
}
