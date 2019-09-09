package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.*;
import com.pojos.Equity;
import com.pojos.Trade;
import com.pojos.Trader;

public class AdminDAOImpl implements AdminDAO {
	Connection connection = ConnectionClass.openConnection();

	@Override
	public boolean inputTrade(List<Trade> trades) {
		// TODO Auto-generated method stub

		// todo
		Iterator<Trade> iter = trades.iterator();
		// String FIND_ALL_TRADES="select * from TRADELIST";

		try {

			while (iter.hasNext()) {
				Trade t = iter.next();

				String tradeid = t.getTradeId();
				String buyerid = t.getBuyer().getTraderId();
				String sellerid = t.getSeller().getTraderId();
				String tickerSymbol = t.getTickerSymbol();
				int equityQty = t.getEquityQty();
				float equityPrice = t.getEquityPrice();
				Date settlementDate;
				boolean isSettled;

				System.out.println("Inserting records into table:");
				String sql = "Insert into TRADELIST VALUES('" + tradeid + "','" + tickerSymbol + "'," + equityQty + ","
						+ equityPrice + ",'" + buyerid + "','" + sellerid + "'," + null + "," + null + ")";
				System.out.println(sql);
//				Statement st = con.createStatement();
//				st.executeUpdate(sql);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		// add exception

		return true;
	}

	@Override
	public boolean settleTrade() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Trade> findAllTrades() {
		// TODO Auto-generated method stub

		List<Trade> trades = new ArrayList<>();
		String FIND_ALL_TRADES = "select * from TRADELIST";

		Trade trade = new Trade();
		Trader buyer = new Trader();

		Trader seller = new Trader();
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

			Statement st = con.createStatement();
			ResultSet set = st.executeQuery(FIND_ALL_TRADES);

			// once got sudent add to list
			// fetching is column wise

			while (set.next()) {// till data ends

				String tradeId = set.getString("TRADEID");

				buyer.setTraderId(set.getString("BUYER"));
				seller.setTraderId(set.getString("SELLER"));
				String tickerSymbol = set.getString("TICKERSYMBOL");
				;
				int equityQty = set.getInt("QUANTITY");
				float equityPrice = set.getFloat("PRICE");
				// Date settlementDate;
				// boolean isSettled;
				// String adminUsername=set.getString("ADMINUSERNAME");

				// DAO has no display hence have to pass ahead
				// dont display in DAO
//				trade = new Trade(tradeId, buyer, seller, tickerSymbol, equityQty, equityPrice, null, false);
//				trades.add(trade);
				// System.out.println(trade.toString());

			}
			// after list ends log
			System.out.println("list size:" + trades.size());
			// for developer not client

			// if want to change layer, only business, dabo layer has to be changed
			// make separate so no dependency of sql anfd java

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//			System.out.println(trades.toString());

		return trades;
		// }

		// return null;
	}

	@Override
	public List<Trade> findCorrespTrade(Equity equityName, Trader trader) {
		// TODO Auto-generated method stub

		String anyTickerSymbol = equityName.getTickerSymbol();
		String anyTrader = trader.getTraderId();

		List<Trade> trades = new ArrayList<>();
		// String FIND_ALL_TRADES="select * from TRADELIST";
		String FIND_ALL_TRADES_BY_TS = "select * from tradelist where tickersymbol=? and (buyer=? or seller=?) ";

		try {

//			Statement st=con.createStatement();
			// ResultSet set=st.executeQuery(FIND_ALL_TRADES);

			PreparedStatement ps = connection.prepareStatement(FIND_ALL_TRADES_BY_TS);
			//
			ps.setString(1, anyTickerSymbol);
			ps.setString(2, anyTrader);
			ps.setString(3, anyTrader);

			ResultSet set = ps.executeQuery();

			while (set.next()) {// till data ends

				String tradeId = set.getString("TRADEID");
				String buyerTraderId = set.getString("BUYER");

				Trader buyer = new Trader();
				buyer = ObjectsCreation.findTraderById(buyerTraderId);
				String sellerTraderId = set.getString("seller");
				Trader seller = new Trader();
				seller = ObjectsCreation.findTraderById(sellerTraderId);
				// buyer.setTraderId(set.getString("BUYER"));

				// seller.setTraderId(set.getString("SELLER"));
				String tickerSymbol = set.getString("TICKERSYMBOL");
				;
				int equityQty = set.getInt("QUANTITY");
				float equityPrice = set.getFloat("PRICE");
				// Date settlementDate;
				// boolean isSettled;
				// String adminUsername=set.getString("ADMINUSERNAME");

				// DAO has no display hence have to pass ahead
				// dont display in DAO
				Trade trade = new Trade(tradeId, buyer, seller, tickerSymbol, tickerSymbol, equityQty, equityPrice,
						false);
				trades.add(trade);

			}
			// after list ends log
			System.out.println("list size:" + trades.size());

			// for developer not client

			// if want to change layer, only business, dabo layer has to be changed
			// make separate so no dependency of sql anfd java
			// ps.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return trades;

		// return null;
	}

	@Override
	public void setDataInReportTable(Trader trader, Equity equity, int gross) {
		// TODO Auto-generated method stub

		try  {

			System.out.println("Inserting records into table:");

			
			//
			
			/*
			String FIND_EQUITY = "select equitydetails.tickersymbol, equitydetails.companyname, equitydetails.facevalue, traderequitydetails.quantity from equitydetails INNER JOIN traderequitydetails on traderequitydetails.tickersymbol=equitydetails.tickersymbol and traderequitydetails.traderid=?";

			try {
				PreparedStatement ps = connection.prepareStatement(FIND_EQUITY);
				ps.setString(1, trader.getTraderId());
				ResultSet set = ps.executeQuery();
				while (set.next()) {
					String tickerSymbol = set.getString("tickersymbol");
					String equityName = set.getString("companyname");
					float faceValue = set.getFloat("facevalue");
					int quantity = set.getInt("quantity");
				}
			
			
			*/
			//
			
			
			
			//String sql = " UPDATE REPORT SET " + equity.getTickerSymbol() + "=?  WHERE TRADERID =? ";
			String sql = " UPDATE REPORT SET " + equity.getTickerSymbol() + "=?  WHERE TRADERID =? ";

			PreparedStatement ps = connection.prepareStatement(sql);
			// ps.setString(1, );
			System.out.println("gross : "+gross+", trader id : "+trader.getTraderId());
			ps.setInt(1, gross);
			ps.setString(2, trader.getTraderId());
			System.out.println(sql);
			int xi = ps.executeUpdate();
			ps.clearBatch();
			//UPDATE REPORT SET MSFT=-7906  WHERE TRADERID =GS
			ps.close();
			System.out.println(xi);
			// st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
//		return false;
		}

		// add exception

	}

	@Override
	public void modifyTrade(Trade trade, int quantity) {

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

			System.out.println("Inserting records into table:");
			String sql = "UPDATE TRADELIST SET QUANTITY = " + quantity + " WHERE TRADEID = " + trade.getTradeId();

			System.out.println(sql);
			Statement st = con.createStatement();
			st.executeUpdate(sql);
			// }
			// once got sudent add to list
			// fetching is column wise

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
//	return false;
		}

		// add exception

	}

	@Override
	public int getNumOfEquity(String tickerSymbol, Trader trader) {
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
			ps.setString(2, trader.getTraderId());

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

	@Override
	public void setNumOfEquityByName(Trader trader, String tickerSymbol, int quantity) {
		// TODO Auto-generated method stub

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

			System.out.println("Inserting records into table:");
			String sql = "UPDATE TRADEREQUITYDETAILS SET QUANTITY = " + quantity + " WHERE TRADERID = "
					+ trader.getTraderId() + " AND TICKERSYMBOL= " + tickerSymbol;

			System.out.println(sql);
			Statement st = con.createStatement();
			st.executeUpdate(sql);
			// }
			// once got sudent add to list
			// fetching is column wise

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
//		return false;
		}

		// add exception

	}

	@Override
	public boolean declareAction() {
		// TODO Auto-generated method stub
		return false;
	}

}
