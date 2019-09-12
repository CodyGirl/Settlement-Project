package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pojos.CorporateAction;
import com.pojos.Trade;
import com.pojos.Trader;
import com.pojos.corporateActionChild.Bonus;
import com.pojos.corporateActionChild.Dividend;
import com.pojos.corporateActionChild.Split;

public class CorporateActionDAOImpl implements CorporateActionDAO {
	

	@Override
	public List<Dividend> getDividendCorporateActions() {
		// TODO Auto-generated method stub
		
		List<Dividend> cpas = new ArrayList<>();
		String FIND_ALL_TRADES = "select * from corporateactiondividend";
		Connection connection = ConnectionClass.openConnection();
		String tickerSymbol="";
		float dividendPercentage=0;
		float faceValue = 0;
		//System.out.println("in function");
		try {
			
			Statement st = connection.createStatement();
			ResultSet set = st.executeQuery(FIND_ALL_TRADES);
			
			while (set.next()) {// till data ends
				//System.out.println("in set");
				tickerSymbol = set.getString("tickersymbol");
				dividendPercentage = set.getFloat("dividendpercentage");
				//System.out.println(tickerSymbol+" "+dividendPercentage);
				try {
					FIND_ALL_TRADES = "select * from equitydetails where tickersymbol=?";
					PreparedStatement ps = connection.prepareStatement(FIND_ALL_TRADES);
					ps.setString(1, tickerSymbol);
					ResultSet set1 = ps.executeQuery();
					
					while (set1.next()) {// till data end
						faceValue = set1.getFloat("facevalue");
					}
					ps.close();
				} 
				catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				Dividend dividend = new Dividend(tickerSymbol,faceValue,dividendPercentage);
				//System.out.println(tickerSymbol+" "+faceValue+" "+dividendPercentage);
				cpas.add(dividend);

			}
			// after list ends log
			st.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cpas;
	}

	@Override
	public List<Split> getSplitCorporateActions() {
		// TODO Auto-generated method stub
		
		List<Split> cpas = new ArrayList<>();
		String FIND_ALL_TRADES = "select * from corporateactionsplit";
		Connection connection = ConnectionClass.openConnection();
		String tickerSymbol="";
		float dividendPercentage=0;
		float faceValue = 0;
		int ratioNumerator =0; 
		int ratioDenominator = 0;
		//System.out.println("in function");
		try {
			
			Statement st = connection.createStatement();
			ResultSet set = st.executeQuery(FIND_ALL_TRADES);
			
			while (set.next()) {// till data ends
				//System.out.println("in set");
				tickerSymbol = set.getString("tickersymbol");
				ratioNumerator = set.getInt("splitnumerator");
				ratioDenominator= set.getInt("splitdenominator");
				//System.out.println(tickerSymbol+" "+dividendPercentage);
				try {
					FIND_ALL_TRADES = "select * from equitydetails where tickersymbol=?";
					PreparedStatement ps = connection.prepareStatement(FIND_ALL_TRADES);
					ps.setString(1, tickerSymbol);
					ResultSet set1 = ps.executeQuery();
					
					while (set1.next()) {// till data end
						faceValue = set1.getFloat("facevalue");
					}
					ps.close();
				} 
				catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				Split split = new Split(tickerSymbol,faceValue,ratioNumerator,ratioDenominator);
				//System.out.println(tickerSymbol+" "+faceValue+" "+dividendPercentage);
				cpas.add(split);

			}
			// after list ends log
			st.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return cpas;
		
	}

	@Override
	public List<Bonus> getBonusCorporateActions() {
		// TODO Auto-generated method stub
		
		List<Bonus> cpas = new ArrayList<>();
		String FIND_ALL_TRADES = "select * from corporateactionbonus";
		Connection connection = ConnectionClass.openConnection();
		String tickerSymbol="";
		float dividendPercentage=0;
		float faceValue = 0;
		int ratioNumerator =0; 
		int ratioDenominator = 0;
		//System.out.println("in function");
		try {
			
			Statement st = connection.createStatement();
			ResultSet set = st.executeQuery(FIND_ALL_TRADES);
			
			while (set.next()) {// till data ends
				//System.out.println("in set");
				tickerSymbol = set.getString("tickersymbol");
				ratioNumerator = set.getInt("bonusnumerator");
				ratioDenominator= set.getInt("bonusdenominator");
				//System.out.println(tickerSymbol+" "+dividendPercentage);
				try {
					FIND_ALL_TRADES = "select * from equitydetails where tickersymbol=?";
					PreparedStatement ps = connection.prepareStatement(FIND_ALL_TRADES);
					ps.setString(1, tickerSymbol);
					ResultSet set1 = ps.executeQuery();
					
					while (set1.next()) {// till data end
						faceValue = set1.getFloat("facevalue");
					}
					ps.close();
				} 
				catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				Bonus split = new Bonus(tickerSymbol,faceValue,ratioNumerator,ratioDenominator);
				//System.out.println(tickerSymbol+" "+faceValue+" "+dividendPercentage);
				cpas.add(split);

			}
			// after list ends log
			st.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		return cpas;
	
	}

	@Override
	public boolean addDividendCorporateAction(String tickerSymbol, float percentageDividend) {
		// TODO Auto-generated method stub
		String query = "insert into corporateactiondividend values(?,?)";
		Connection connection = ConnectionClass.openConnection();
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, tickerSymbol);
			ps.setFloat(2, percentageDividend);
			int rows = ps.executeUpdate();
			if(rows>0)
				return true;
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean addSplitCorporateAction(String tickerSymbol, int ratioA, int ratioB) {
		// TODO Auto-generated method stub
		String query = "insert into corporateactionsplit values(?,?,?)";
		Connection connection = ConnectionClass.openConnection();
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, tickerSymbol);
			ps.setInt(2, ratioA);
			ps.setInt(3, ratioB);
			int rows = ps.executeUpdate();
			if(rows>0)
				return true;
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean addBonusCorporateAction(String tickerSymbol, int ratioA, int ratioB) {
		// TODO Auto-generated method stub
		String query = "insert into corporateactionbonus values(?,?,?)";
		Connection connection = ConnectionClass.openConnection();
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, tickerSymbol);
			ps.setInt(2, ratioA);
			ps.setInt(3, ratioB);
			int rows = ps.executeUpdate();
			if(rows>0)
				return true;
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteDividendCorporateActions() {
		// TODO Auto-generated method stub
		String query = "delete from corporateactiondividend";
		Connection connection = ConnectionClass.openConnection();
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			int rows = ps.executeUpdate();
			if(rows>0)
				return true;
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteSplitCorporateActions() {
		// TODO Auto-generated method stub
		String query = "delete from corporateactionsplit";
		Connection connection = ConnectionClass.openConnection();
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			int rows = ps.executeUpdate();
			if(rows>0)
				return true;
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;	}

	@Override
	public boolean deleteBonusCorporateActionss() {
		// TODO Auto-generated method stub
		String query = "delete from corporateactionbonus";
		Connection connection = ConnectionClass.openConnection();
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			int rows = ps.executeUpdate();
			if(rows>0)
				return true;
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;	}



}
