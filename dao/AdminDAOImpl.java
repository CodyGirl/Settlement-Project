package com.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import com.*;
import com.pojos.Equity;
import com.pojos.Trade;
import com.pojos.Trader;
import java.sql.*;

public class AdminDAOImpl implements AdminDAO {

	private static Connection openConnection() {
		Connection connection = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("driver loaded successfully");

			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "settlement", "settlement123");
			System.out.println("connection obtained");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	@Override
	public boolean inputTrade(List<Trade> trades) {
		// TODO Auto-generated method stub

		Iterator<Trade> iter = trades.iterator();

		int rows_updated=0;
		try (Connection conn = ConnectionClass.openConnection()) {

			String newsql = "INSERT INTO TRADELIST VALUES(?,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(newsql);
//delete table data			
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
				int isSettled = t.getIsSettled();

				System.out.println("Inserting records into table:");

				// Statement st = openConnection().createStatement();

				ps.setString(1, tradeid);
				ps.setString(2, tickerSymbol);
				ps.setInt(3, equityQty);
				ps.setFloat(4, equityPrice);
				ps.setString(5, buyerid);
				ps.setString(6, sellerid);
				ps.setString(7, "admin");
				ps.setInt(8, isSettled);

				rows_updated=ps.executeUpdate();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		// add exception
		if(rows_updated>0) {
			System.out.println("ROWS UPDATED");
			return true;
			
		}
		else {
			System.out.println("ROWS NOT UPDATED");
			return false;
		}

	}

	


	@Override
	public List<Trade> findAllTrades() {
		// TODO Auto-generated method stub

		List<Trade> trades = new ArrayList<>();
		String FIND_ALL_TRADES = "select * from TRADELIST";

		try (Connection conn = ConnectionClass.openConnection()) {

			Statement st = conn.createStatement();
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
				 int isSettled=set.getInt("ISSETTLED");
				// String adminUsername=set.getString("ADMINUSERNAME");

				trade = new Trade(tradeId, buyer, seller, tickerSymbol, equityQty, equityPrice, isSettled);
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

		try (Connection conn = ConnectionClass.openConnection()) {

//			Statement st=con.createStatement();
			// ResultSet set=st.executeQuery(FIND_ALL_TRADES);

			PreparedStatement ps = conn.prepareStatement(FIND_ALL_TRADES_BY_TS);

			ps.setString(1, anyTickerSymbol);
			ps.setString(2, anyTrader);
			ps.setString(3, anyTrader);

			ResultSet set = ps.executeQuery();

			while (set.next()) {

				String tradeId = set.getString("TRADEID");

				Trader buyer = new Trader();
				Trader seller = new Trader();

				buyer.setTraderId(set.getString("BUYER"));
				seller.setTraderId(set.getString("SELLER"));

				String tickerSymbol = set.getString("TICKERSYMBOL");
				int equityQty = set.getInt("QUANTITY");
				float equityPrice = set.getFloat("PRICE");
				// Date settlementDate;
				int isSettled=set.getInt("ISSETTLED");
				// String adminUsername=set.getString("ADMINUSERNAME");

				Trade trade = new Trade(tradeId, buyer, seller, tickerSymbol, equityQty, equityPrice, isSettled);
				trades.add(trade);

			}
			System.out.println("list size:" + trades.size());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return trades;

	}

	@Override
	public boolean setDataInReportTable(Trader trader, Equity equity, int gross) {
		// TODO Auto-generated method stub

		int rows_updated=0;
		try {

			System.out.println("Inserting records into table:");

//			String sql="UPDATE REPORT SET ? = ? WHERE TRADERID = ?";
			String sql = "UPDATE REPORT SET " + equity.getTickerSymbol() + " = ? WHERE TRADERID = ?";

			System.out.println(sql);

			PreparedStatement ps = openConnection().prepareStatement(sql);

			// ps.setString(1, equity.getTickerSymbol());
			ps.setInt(1, gross);
			//System.out.println("" + gross);
			ps.setString(2, trader.getTraderId());
			System.out.println(trader.getTraderId());

			rows_updated=ps.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
//		return false;
		}

		// add exception
		if(rows_updated>0) {
			System.out.println("ROWS UPDATED");
			return true;
			
		}
		else {
			System.out.println("ROWS NOT UPDATED");
			return false;
		}


	}

	@Override
	public boolean modifyTrade(Trade trade, int quantity) {

		int rows_updated=0;
		
		try (Connection conn = ConnectionClass.openConnection()) {

			System.out.println("Inserting records into table:");
			// String sql = "UPDATE TRADELIST SET QUANTITY = " + quantity + " WHERE TRADEID
			// = " + trade.getTradeId();

			String sql = "UPDATE TRADELIST SET QUANTITY = ? WHERE TRADEID = ?";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, quantity);
			ps.setString(2, trade.getTradeId());

			System.out.println(sql);

			rows_updated=ps.executeUpdate(sql);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		// add exception
		if(rows_updated>0) {
			System.out.println("ROWS UPDATED");
			return true;
			
		}
		else {
			System.out.println("ROWS NOT UPDATED");
			return false;
		}


	}

	@Override
	public int getNumOfEquity(String tickerSymbol, Trader trader) {
		// TODO Auto-generated method stub


		String FIND_EQTY_NO_BYTRADER = "select quantity from traderequitydetails where tickersymbol=? and traderid=? ";
		int quantity = 0;
		try {

			PreparedStatement ps = openConnection().prepareStatement(FIND_EQTY_NO_BYTRADER);
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
			return -1;
		}

		return quantity;

	}

	@Override
	public boolean setNumOfEquityByName(Trader trader, String tickerSymbol, int quantity) {
		// TODO Auto-generated method stub

		int rows_updated=0;
		try {

			System.out.println("Inserting records into table:");

			String sql = "UPDATE TRADEREQUITYDETAILS SET QUANTITY = ? WHERE TRADERID = ? AND TICKERSYMBOL= ?";

//			String sql = "UPDATE TRADEREQUITYDETAILS SET QUANTITY = " + quantity + " WHERE TRADERID = "
//					+ trader.getTraderId() + " AND TICKERSYMBOL= " + tickerSymbol;

			PreparedStatement ps = openConnection().prepareStatement(sql);

			ps.setInt(1, quantity);
			ps.setString(2, trader.getTraderId());
			ps.setString(3, tickerSymbol);
			System.out.println(sql);

			ps.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		// add exception
		if(rows_updated>0) {
			System.out.println("ROWS UPDATED");
			return true;
			
		}
		else {
			System.out.println("ROWS NOT UPDATED");
			return false;
		}


	}

	@Override
	public boolean declareAction() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getDataFromReportTable(Trader trader, Equity equity) {
		// TODO Auto-generated method stub


		String FIND_EQTY_NO_BYTRADER = "select "+equity.getTickerSymbol()+ " from report where traderid = ?";

//		String FIND_EQTY_NO_BYTRADER = "select " + equity.getTickerSymbol() + " from report where traderid = "
//				+ trader.getTraderId();

		System.out.println(FIND_EQTY_NO_BYTRADER);

		int quantity = 0;
		try (Connection conn = ConnectionClass.openConnection()) {

			PreparedStatement ps = conn.prepareStatement(FIND_EQTY_NO_BYTRADER);

		//	ps.setString(1, equity.getTickerSymbol());
			ps.setString(1, trader.getTraderId());


			ResultSet set = ps.executeQuery();

			while (set.next()) {// till data ends

				quantity = set.getInt(equity.getTickerSymbol());

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}


		return quantity;

	}


	@Override
	public void generateRandomTrades() {
		// TODO Auto-generated method stub

		try (Connection conn = ConnectionClass.openConnection()) {

			String del = "delete from tradelist";
			Statement st = conn.createStatement();
			st.executeUpdate(del);

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("TABLE NOT EMPTY");
			return;
		}

		List<Trade> trades = new ArrayList<>();
		int id = 0;
		String[] traderlist = { "GS", "JPM", "BCS", "DB", "CITI" };
		String[] equitylist = { "MSFT", "AAPL", "AMZN", "GOOG", "FB" };
		int[] equitynearcostlist = { 140, 210, 1800, 1200, 190 };
		// String[] users = { "admin", "sneha", "rutuja", "nishtha" };
		Trade[] tradelist = new Trade[50];
		Random rand = new Random();

		for (int i = 1; i < 21; i++) {
			// System.out.println(""+i);

			Trade t1 = new Trade();
			String tradecount = "SELECT COUNT(*) FROM TRADELIST";
			Statement stmt = null;
			ResultSet rs = null;

			try (Connection conn = ConnectionClass.openConnection()) {
				stmt = conn.createStatement();
				rs = stmt.executeQuery(tradecount);
				rs.next();
				t1.setTradeId("" + (rs.getInt(1) + 1));

			} catch (SQLException e1) {
// TODO Auto-generated catch block
				e1.printStackTrace();
				System.out.println("TRADE NOT INSERTED");
				return;
			}

			String tradeid = "" + i;
			String buyerid = traderlist[rand.nextInt(traderlist.length)];
			String sellerid = traderlist[rand.nextInt(traderlist.length)];

			//duplicate seller buyer condition
//			if (buyerid.equals(sellerid)) {
//				System.out.println("SAME");
//				while ((buyerid.equals(sellerid))) {
//					System.out.println("Same");
//					sellerid = traderlist[rand.nextInt(traderlist.length)];
//
//				}
//			}
//			

			int index = rand.nextInt(equitylist.length);
			String tickersymbol = equitylist[index];
			int price = equitynearcostlist[index] + rand.nextInt((int) (0.1 * equitynearcostlist[index]))
					- rand.nextInt((int) (0.1 * equitynearcostlist[index]));
			int quantity = 100 + rand.nextInt(9901);
			String username = "admin";
			int isSettled=0;

			Trader buyer = new Trader();
			buyer.setTraderId(buyerid);

			Trader seller = new Trader();
			seller.setTraderId(sellerid);

			Trade t = new Trade(tradeid, buyer, seller, tickersymbol, quantity, price, isSettled);

			trades.add(t);

			System.out.println(tradeid + tickersymbol + buyerid + sellerid + quantity + price + username);
			System.out.println(t.toString());
		

		}

		// add trades to table
		AdminDAO dao = new AdminDAOImpl();
		dao.inputTrade(trades);

	}

	@Override
	public boolean deleteTrade(List<Trade> list) {
		// TODO Auto-generated method stub

		int rows_updated=0;
		try (Connection conn = ConnectionClass.openConnection()) {

			for (Trade trade : list) {
				System.out.println("Deleting records from table:");

				String sql = "DELETE FROM TRADELIST WHERE TRADEID = ?";

				PreparedStatement ps = conn.prepareStatement(sql);

				ps.setString(1, trade.getTradeId());

				 rows_updated = ps.executeUpdate();

			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("DELETE NOT HAPPEN");
			return false;
		}

		if(rows_updated>0) {
			System.out.println("ROWS DELETED");
			return true;
			
		}
		else {
			System.out.println("ROWS NOT DELETED");
			return false;
		}


	}


	@Override
	public void generateCorpAction() {
		// TODO Auto-generated method stub

		Random rand = new Random();

		String corpactions[] = { "SPLIT", "DIVIDEND", "BONUS" };

		try (Connection conn = ConnectionClass.openConnection()) {

			for (String action : corpactions) {
				String sql = "DELETE FROM CORPORATEACTION" + action;

				Statement st = conn.createStatement();
				st.executeUpdate(sql);

			}

		} catch (Exception e) {
		}

		String corpaction = corpactions[rand.nextInt(corpactions.length)];

		String[] equitylist = { "MSFT", "AAPL", "AMZN", "GOOG", "FB" };

		String equity = equitylist[rand.nextInt(equitylist.length)];

		if (corpaction.equals("SPLIT")) {

			try (Connection conn = ConnectionClass.openConnection()) {
				int splitnumerator = 1 + rand.nextInt(9);
				int splitdenominator = 1 + rand.nextInt(9);

				for (int i = 9; i > 1; i--) {
					if (splitdenominator % i == 0 && splitnumerator % i == 0) {
						splitdenominator /= i;
						splitnumerator /= i;
					}
				}

				String add = "insert into corporateactionsplit values(?,?,?)";
				PreparedStatement ps = conn.prepareStatement(add);
				ps.setString(1, equity);
				ps.setInt(2, splitnumerator);
				ps.setInt(3, splitdenominator);
				ps.executeUpdate();

			} catch (Exception e) {
			}

		}

		if (corpaction.equals("BONUS")) {
			try (Connection conn = ConnectionClass.openConnection()) {
				int splitnumerator = 1 + rand.nextInt(9);
				int splitdenominator = 1 + rand.nextInt(9);

				for (int i = 9; i > 1; i--) {
					if (splitdenominator % i == 0 && splitnumerator % i == 0) {
						splitdenominator /= i;
						splitnumerator /= i;
					}
				}

				String add = "insert into corporateactionbonus values(?,?,?)";
				PreparedStatement ps = conn.prepareStatement(add);
				ps.setString(1, equity);
				ps.setInt(2, splitnumerator);
				ps.setInt(3, splitdenominator);
				ps.executeUpdate();

			} catch (Exception e) {
			}

		}

		if (corpaction.equals("DIVIDEND")) {
			try (Connection conn = ConnectionClass.openConnection()) {
				int dividendpercent = (1 + rand.nextInt(20)) * 5;

				String add = "insert into corporateactiondividend values(?,?)";
				PreparedStatement ps = conn.prepareStatement(add);
				ps.setString(1, equity);
				ps.setInt(2, dividendpercent);
				ps.executeUpdate();

			} catch (Exception e) {
			}

		}
	}

	@Override
	public boolean addTrade(String buyer) {
		// TODO Auto-generated method stub
		return false;
	}

}


