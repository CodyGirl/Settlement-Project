package com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pojo.Student;
import com.pojos.Equity;
import com.pojos.Trader;

public class ObjectsCreation {
	
	public static List<Equity> findEquityDetailsOfTrader(String traderId)
	{
		List<Equity> equities= new ArrayList<Equity>();
		
		String FIND_EQUITY= "select equitydetails.tickersymbol, equitydetails.companyname, equitydetails.facevalue, traderequitydetails.quantity from equitydetails INNER JOIN traderequitydetails on tickersymbol where traderequitydetails.traderid=?";
				
				try {
					PreparedStatement ps = ConnectionClass.openConnection().prepareStatement(FIND_EQUITY);
				    ps.setString(1, traderId);
					ResultSet set= ps.executeQuery();
					 while(set.next())
						{
							String tickerSymbol=set.getString("tickersymbol");
							String  equityName = set.getString("companyname");
							float faceValue = set.getInt("facevalue");
							int quantity= set.getInt("quantity");
							
							Equity equity= new Equity(tickerSymbol,equityName,faceValue,quantity);
							equities.add(equity);
						}	
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		       
		        return equities;
		
	}
	
	
	
	public static List<Trader> findTrader() {
		// TODO Auto-generated method stub
		List<Trader> traders= new ArrayList<Trader>();
		String FIND_ALL_TRADERS= "select tradercashdetails.traderid,tradercashdetails.tradername,tradercashdetails.fundsavailable,traderlogin.traderpassword,    from tradercashdetails INNER JOIN traderlogin on traderid";
		try {
			PreparedStatement ps= ConnectionClass.openConnection().prepareStatement(FIND_ALL_TRADERS);
			ResultSet set= ps.executeQuery();
			while(set.next())
			{
				String traderId= set.getString("traderid");
				String traderName= set.getString("traderName");
				String traderPassword= set.getString("traderpassword");
				int traderFundBal=set.getInt("fundsavailable");
				List<Equity> equityBal=  findEquityDetailsOfTrader(traderId);
				
				Trader trader= new Trader(traderId,traderName,traderPassword,traderFundBal,equityBal);
				traders.add(trader);
			}	
		} catch ( SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return traders;
	}
	
    public static List<Equity> findEquity()
    {
    	List<Equity> equities= new ArrayList<Equity>();
		String FIND_ALL_EQUITIES= "select * from equitydetails ";
		try {
			PreparedStatement ps= ConnectionClass.openConnection().prepareStatement(FIND_ALL_EQUITIES);
			ResultSet set= ps.executeQuery();
			while(set.next())
			{
				String tickerSymbol=set.getString("tickersymbol");
				String  equityName = set.getString("companyname");
				float faceValue = set.getInt("facevalue");
				Equity equity= new Equity(tickerSymbol,equityName,faceValue,0);
				equities.add(equity);
			}	
		} catch ( SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return equities;
    }
	
	
}
