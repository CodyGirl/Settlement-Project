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
import java.util.Random;

import com.*;
import com.pojos.Equity;
import com.pojos.Trade;
import com.pojos.Trader;

public class AdminDAOImpl implements AdminDAO {
	Connection connection = ConnectionClass.openConnection();

	@Override
	public boolean inputTrade(List<Trade> trades) {
		// TODO Auto-generated method stub

		Iterator<Trade> iter = trades.iterator();

		try {
			String newsql = "INSERT INTO TRADELIST VALUES(?,?,?,?,?,?,?)";			
			PreparedStatement ps = connection.prepareStatement(newsql);		
			while (iter.hasNext()) {

				Trade t = iter.next();

				System.out.println(t.toString());
				String tradeid = t.getTradeId();
				String buyerid = t.getBuyer().getTraderId();
				String sellerid = t.getSeller().getTraderId();
				String tickerSymbol = t.getTickerSymbol();
				int equityQty = t.getEquityQty();
				float equityPrice = t.getEquityPrice();
				// Date settlementDate;
				boolean isSettled = false;

				System.out.println("Inserting records into table:");

				// Statement st = openConnection().createStatement();

				ps.setString(1, tradeid);
				ps.setString(2, tickerSymbol);
				ps.setInt(3, equityQty);
				ps.setFloat(4, equityPrice);
				ps.setString(5, buyerid);
				ps.setString(6, sellerid);
				ps.setString(7, "admin");

				ps.executeUpdate();
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


		try {
			
			Statement st = connection.createStatement();
			ResultSet set = st.executeQuery(FIND_ALL_TRADES);
			while (set.next()) {// till data ends
				Trade trade = new Trade();
				Trader buyer = new Trader();
				Trader seller = new Trader();

				String tradeId = set.getString("TRADEID");
				buyer.setTraderId(set.getString("BUYER"));
				seller.setTraderId(set.getString("SELLER"));
				String tickerSymbol = set.getString("TICKERSYMBOL");
				int equityQty = set.getInt("QUANTITY");
				float equityPrice = set.getFloat("PRICE");

				// Date settlementDate;
				// boolean isSettled;
				// String adminUsername=set.getString("ADMINUSERNAME");
				
			trade = new Trade(tradeId, buyer, seller, tickerSymbol, equityQty, equityPrice, false);
			trades.add(trade);
				
				// System.out.println(trade.toString());

			}
			// after list ends log
			System.out.println("list size:" + trades.size());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

//			System.out.println(trades.toString());

		return trades;
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
				Trade trade = new Trade(tradeId, buyer, seller,  tickerSymbol, equityQty, equityPrice,
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
	public boolean setDataInReportTable(Trader trader, Equity equity, int gross) {
		// TODO Auto-generated method stub

		try {

			System.out.println("Inserting records into table:");
			String sql = " UPDATE REPORT SET " + equity.getTickerSymbol() + "=?  WHERE TRADERID =? ";
			PreparedStatement ps = connection.prepareStatement(sql);
			System.out.println("gross : " + gross + ", trader id : " + trader.getTraderId());
			ps.setInt(1, gross);
			ps.setString(2, trader.getTraderId());
			System.out.println(sql);
			int xi = ps.executeUpdate();
			ps.clearBatch();
			ps.close();
			System.out.println(xi);
			// st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
//		return false;
		}
        return true;
		// add exception

	}

	
	@Override
	public int getDataFromReportTable(Trader trader, Equity equity) {
		// TODO Auto-generated method stub
         int shareAmount=0;
		try {

			System.out.println("taking records from table:");
			String sql = " select " +  equity.getTickerSymbol() + " from report WHERE TRADERID =? ";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, trader.getTraderId());
			System.out.println(sql);
			ResultSet set= ps.executeQuery();
			while(set.next())
			{
				shareAmount = set.getInt(equity.getTickerSymbol());
			}
			System.out.println("amount is: "+ shareAmount);
			ps.clearBatch();
			ps.close();
			// st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return shareAmount;
	}
	
	
	
	@Override
	public boolean modifyTrade(Trade trade, int quantity) {

		try{
			System.out.println("Inserting records into table:");
			//String sql = "UPDATE TRADELIST SET QUANTITY = " + quantity + " WHERE TRADEID = " + trade.getTradeId();

			String sql="UPDATE TRADELIST SET QUANTITY = ? WHERE TRADEID = ?";

			PreparedStatement ps=connection.prepareStatement(sql);
			
			ps.setInt(1, quantity);
			ps.setString(2, trade.getTradeId());
			
			System.out.println(sql);
			
			ps.executeUpdate(sql);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		// add exception

		return true;
	}

	@Override
	public int getNumOfEquity(String tickerSymbol, Trader trader) {
		// TODO Auto-generated method stub

//		List<Trade> trades=new ArrayList<>();
		String FIND_EQTY_NO_BYTRADER = "select quantity from traderequitydetails where tickersymbol=? and traderid=? ";
		int quantity = 0;
		try {
			PreparedStatement ps = connection.prepareStatement(FIND_EQTY_NO_BYTRADER);
			//
			ps.setString(1, tickerSymbol);
			ps.setString(2, trader.getTraderId());

			ResultSet set = ps.executeQuery();


			while (set.next()) {// till data ends

				quantity = set.getInt("QUANTITY");

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return quantity;

	}
	@Override
	public boolean setNumOfEquityByName(Trader trader, String tickerSymbol, int quantity) {
		// TODO Auto-generated method stub

		try {
			System.out.println("Inserting records into table:");
			String sql = "UPDATE TRADEREQUITYDETAILS SET QUANTITY = ? WHERE TRADERID = ? AND TICKERSYMBOL= ?";

			System.out.println(sql);
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, quantity);
			ps.setString(2, trader.getTraderId());
			ps.setString(3, tickerSymbol);
			ps.executeUpdate(sql);
			// }
			// once got sudent add to list
			// fetching is column wise

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
//		return false;
		}

		// add exception
       return true;
	}

	@Override
	public boolean declareAction() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setTraderEquity(Trader trader, Equity equity) {
		// TODO Auto-generated method stub
		try {

			connection.setAutoCommit(false);
			String sql = "UPDATE TRADEREQUITYDETAILS SET QUANTITY=? WHERE TRADERID=? AND TICKERSYMBOL=?";

			System.out.println(sql);
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, equity.getQuantity());
			ps.setString(2, trader.getTraderId());
			ps.setString(3, equity.getTickerSymbol());
			int row = ps.executeUpdate();
			ps.execute();
			connection.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean setTraderFund(Trader trader) {
		// TODO Auto-generated method stub
		try {

			connection.setAutoCommit(false);
			String sql = "update tradercashdetails SET FUNDSAVAILABLE =? where traderid=?";

			System.out.println(sql);
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setFloat(1, trader.getTraderFundBal());
			ps.setString(2, trader.getTraderId());
			int row = ps.executeUpdate();
			ps.execute();
			connection.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	@Override
	public boolean generateRandomTrades() {
		// TODO Auto-generated method stub
		try(Connection conn=ConnectionClass.openConnection()) {
			String del="delete from tradelist";
			Statement st=conn.createStatement();
			st.executeUpdate(del);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		List<Trade> trades = new ArrayList<>();
		int id = 0;
		String[] traderlist = { "GS", "JPM", "BCS", "DB", "CITI" };
		String[] equitylist = { "MSFT", "AAPL", "AMZN", "GOOG", "FB" };
		int[] equitynearcostlist = { 140, 210, 1800, 1200, 190 };
		// String[] users = { "admin", "sneha", "rutuja", "nishtha" };
		Trade[] tradelist = new Trade[50];
		Random rand = new Random();

		for (int i = 1; i < 51; i++) {
			// System.out.println(""+i);

			Trade t1 = new Trade();
			String tradecount = "SELECT COUNT(*) FROM TRADELIST";
			Statement stmt = null;
			ResultSet rs = null;

			try(Connection conn=ConnectionClass.openConnection()) {
				stmt = conn.createStatement();
				rs = stmt.executeQuery(tradecount);
				rs.next();
				t1.setTradeId("" + (rs.getInt(1) + 1));

			} catch (SQLException e1) {
// TODO Auto-generated catch block
				e1.printStackTrace();
				return false;
			}

			String tradeid = "" + i;
			String buyerid = traderlist[rand.nextInt(traderlist.length)];
			String sellerid = traderlist[rand.nextInt(traderlist.length)];
			if (buyerid.equals(sellerid)) {
				while (!(buyerid.equals(sellerid))) {
					sellerid = traderlist[rand.nextInt(traderlist.length)];

				}
			}
			int index = rand.nextInt(equitylist.length);
			String tickersymbol = equitylist[index];
			int price = equitynearcostlist[index];
			int quantity = 100 + rand.nextInt(99901);
			String username = "admin";

			Trader buyer = new Trader();
			buyer.setTraderId(buyerid);

			Trader seller = new Trader();
			seller.setTraderId(sellerid);

			Trade t = new Trade(tradeid, buyer, seller, tickersymbol, quantity, price, false);

			trades.add(t);

			System.out.println(tradeid + tickersymbol + buyerid + sellerid + quantity + price + username);
			System.out.println(t.toString());
		}
		//add trades to table
		AdminDAO dao = new AdminDAOImpl();
		dao.inputTrade(trades);
		return true;
	}
	
	
	@Override
	public boolean deleteTrade(List<Trade> list) {
		// TODO Auto-generated method stub
		try {
		for(Trade trade:list) {
			System.out.println("Deleting records from table:");
			String sql="DELETE FROM TRADELIST WHERE TRADEID = ?";
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setString(1, trade.getTradeId());
			int rows=ps.executeUpdate();
		}
		}catch(Exception e)		{
			e.printStackTrace();
			return false;
		}
		return true;
	}


	@Override
	public float getBorrowEquityRate(Equity equity)
	{
		float rate=(float) 0.0;
		try {
			System.out.println("getting borrow rate");
			String sql = " select borrowingrate from EQUITYBORROWINGRATE where tickersymbol=? ";
			PreparedStatement ps= connection.prepareStatement(sql);
			ps.setString(1, equity.getTickerSymbol());
			System.out.println(sql);
			ResultSet set = ps.executeQuery();
			while(set.next())
			{
				rate= set.getFloat("borrowingrate");
			}
			System.out.println("borrow equity rate is : "+ rate);
			ps.clearBatch();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rate;
	}
	@Override
	public float getBorrowFundRate(String currency)
	{
		float rate=(float) 0.0;
		try {
			System.out.println("getting borrow FundRate");
			String sql = " select borrowingrate from FUNDBORROWINGRATE where currency=? ";
			PreparedStatement ps= connection.prepareStatement(sql);
			ps.setString(1, currency);
			System.out.println(sql);
			ResultSet set = ps.executeQuery();
			while(set.next())
			{
				rate= set.getFloat("borrowingrate");
			}
			System.out.println("borrow fund rate is : "+ rate);
			ps.clearBatch();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rate;
	}

}
