package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pojos.Equity;
import com.pojos.Trader;

public class ObjectsCreation {
	static Connection connection = ConnectionClass.openConnection();

	public static List<Equity> findEquityDetailsOfTrader(String traderId) {
		List<Equity> equities = new ArrayList<Equity>();

		String FIND_EQUITY = "select equitydetails.tickersymbol, equitydetails.companyname, equitydetails.facevalue, traderequitydetails.quantity from equitydetails INNER JOIN traderequitydetails on traderequitydetails.tickersymbol=equitydetails.tickersymbol and traderequitydetails.traderid=?";

		try {
			PreparedStatement ps = connection.prepareStatement(FIND_EQUITY);
			ps.setString(1, traderId);
			ResultSet set = ps.executeQuery();
			while (set.next()) {
				String tickerSymbol = set.getString("tickersymbol");
				String equityName = set.getString("companyname");
				float faceValue = set.getFloat("facevalue");
				int quantity = set.getInt("quantity");

				Equity equity = new Equity(tickerSymbol, equityName, faceValue, quantity);
				equities.add(equity);
			}
			// ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return equities;

	}

	public static List<Trader> findTrader() {
		// TODO Auto-generated method stub
		List<Trader> traders = new ArrayList<Trader>();
		String FIND_ALL_TRADERS = "select tradercashdetails.traderid,tradercashdetails.tradername,tradercashdetails.fundsavailable   from tradercashdetails INNER JOIN traderlogin on  tradercashdetails.traderid=traderlogin.traderid";
		try {
			PreparedStatement ps = connection.prepareStatement(FIND_ALL_TRADERS);
			ResultSet set = ps.executeQuery();
			while (set.next()) {
				String traderId = set.getString("traderid");
				String traderName = set.getString("traderName");
				// String traderPassword= set.getString("traderpassword");
				int traderFundBal = set.getInt("fundsavailable");
				List<Equity> equityBal = findEquityDetailsOfTrader(traderId);

				Trader trader = new Trader(traderId, traderName, traderFundBal, equityBal);
				traders.add(trader);
			}
			// ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return traders;
	}

	public static Trader findTraderById(String traderid) {
		Trader trader = new Trader();
		String FIND_ALL_TRADERS = "select tradercashdetails.traderid,tradercashdetails.tradername,tradercashdetails.fundsavailable   from tradercashdetails INNER JOIN traderlogin on tradercashdetails.traderid=traderlogin.traderid and traderlogin.traderid=?";
		try {
			PreparedStatement ps = connection.prepareStatement(FIND_ALL_TRADERS);
			ps.setString(1, traderid);
			ResultSet set = ps.executeQuery();
			if (set.next()) {
				String traderId = set.getString("traderid");
				String traderName = set.getString("traderName");
				// String traderPassword= set.getString("traderpassword");
				int traderFundBal = set.getInt("fundsavailable");
				List<Equity> equityBal = findEquityDetailsOfTrader(traderId);
				trader = new Trader(traderId, traderName, traderFundBal, equityBal);
			}
			// ps.close();
			// traders.add(trader);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return trader;

	}

	public static List<Equity> findEquity() {
		List<Equity> equities = new ArrayList<Equity>();
		String FIND_ALL_EQUITIES = "select * from equitydetails";
		try {
			PreparedStatement ps = connection.prepareStatement(FIND_ALL_EQUITIES);
			ResultSet set = ps.executeQuery();
			while (set.next()) {
				String tickerSymbol = set.getString("tickersymbol");
				String equityName = set.getString("companyname");
				float faceValue = set.getFloat("facevalue");
				Equity equity = new Equity(tickerSymbol, equityName, faceValue, 0);
				equities.add(equity);
			}
			// ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return equities;

	}
}
