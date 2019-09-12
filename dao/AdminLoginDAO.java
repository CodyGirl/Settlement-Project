package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class AdminLoginDAO {

	public String doAdminLogin(String adminId,String adminPassword) {
		String adminName=null;
		String SQL_ADMIN_LOGIN="select ADMINID,ADMINPASSWORD from ADMINLOGIN where "+"adminId=? and password=?";
		
		try (Connection connection=ConnectionClass.openConnection();
				PreparedStatement ps=connection.prepareStatement(SQL_ADMIN_LOGIN);){
			ps.setString(1, adminId);
			ps.setString(2, adminPassword);
			ResultSet set=ps.executeQuery();
			while(set.next()) {
				adminName=set.getString(1);
			}
		}
			catch(Exception e) {
				
		e.printStackTrace();		
				
				
			}
		return adminName;
		}
	
	
}


	
	
