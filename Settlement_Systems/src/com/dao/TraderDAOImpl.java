package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TraderDAOImpl implements TraderDAO {

	@Override
	public int getNumOfEquity(String tickerSymbol, String TraderId) {
		// TODO Auto-generated method stub
//		List<Trade> trades=new ArrayList<>();
		String FIND_EQTY_NO_BYTRADER = "select quantity from traderequitydetails where tickersymbol=? and traderid=? ";
		int quantity = 0;
		try {

			// open conn
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("driver loaded successfully");

			// jdbc:data_base:install_server:post/databse
			// 2.connection
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			// hr is username
			// hr is portname
			System.out.println("Connection obtained");

			PreparedStatement ps = con.prepareStatement(FIND_EQTY_NO_BYTRADER);
			//

			ps.setString(1, tickerSymbol);
			ps.setString(2, TraderId);

			ResultSet set = ps.executeQuery();

			// once got sudent add to list
			// fetching is column wise

			while (set.next()) {// till data ends

				quantity = set.getInt("QUANTITY");

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		System.out.println(trades.toString());

		return quantity;

	}

}
