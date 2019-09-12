package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TraderLoginDAO {
	
	public String doTrdaerLogin(String traderId,String traderPassword) {
		String traderName=null;
		String SQL_ADMIN_LOGIN="select TRADERID,TRADERPASSWORD from TRADERLOGIN where traderId=? and traderpassword=?";
		
		try (Connection connection=ConnectionClass.openConnection();
				PreparedStatement ps=connection.prepareStatement(SQL_ADMIN_LOGIN);){
			ps.setString(1, traderId);
			ps.setString(2, traderPassword);
			ResultSet set=ps.executeQuery();
			while(set.next()) {
				traderName=set.getString(1);
			}
		}
			catch(Exception e) {
				
		e.printStackTrace();		
				
				
			}
		return traderName;
		}
	
	
}
