package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class AdminLoginDAO {

	public String doAdminLogin(String adminId,String adminPassword) {
		String adminName=null;
		String SQL_ADMIN_LOGIN="select ADMINUSERNAME,ADMINPASSWORD from ADMINLOGIN where adminusername=? and adminpassword=?";
		System.out.println("in admin");
		try (Connection connection=ConnectionClass.openConnection();
				PreparedStatement ps=connection.prepareStatement(SQL_ADMIN_LOGIN);){
			ps.setString(1, adminId);
			ps.setString(2, adminPassword);
			ResultSet set=ps.executeQuery();
			while(set.next()) {
				adminName=set.getString(1);
				System.out.println("aname : "+adminName);
				System.out.println("in while");
			}
		}
			catch(Exception e) {
				
		e.printStackTrace();		
				
				
			}
		return adminName;
		}
	
	
}


	
	
