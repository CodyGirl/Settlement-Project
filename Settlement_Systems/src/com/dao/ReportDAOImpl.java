package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.pojos.Report;

public class ReportDAOImpl {
	
	
	
	
	public Report getObligationReportByName(String traderid) {
		Report report = null;

		String query = "select * from report where traderid=?";
		Connection connection = ConnectionClass.openConnection();
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(query);
			ps.setString(1, traderid);
			ResultSet set = ps.executeQuery();
			while(set.next()) {
				report = new Report(set.getString("traderid"),set.getDouble("aapl"),set.getDouble("amzn"),set.getDouble("goog"),set.getDouble("msft"),set.getDouble("fb"));
			}
			set.close();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return report;
		
	}
	
	public Report getSecurityReportByName(String traderid) {
		Report report = null;

		String query = "select * from equityinterest where traderid=?";
		Connection connection = ConnectionClass.openConnection();
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(query);
			ps.setString(1, traderid);
			ResultSet set = ps.executeQuery();
			while(set.next()) {
				report = new Report(set.getString("traderid"),set.getDouble("aapl"),set.getDouble("amzn"),set.getDouble("goog"),set.getDouble("msft"),set.getDouble("fb"));
			}
			set.close();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return report;
		
	}
	
//	public Report getEquityShortage(String traderid) {
//		Report report = null;
//
//		String query = "select * from equityshortage where traderid=?";
//		Connection connection = ConnectionClass.openConnection();
//		PreparedStatement ps;
//		try {
//			ps = connection.prepareStatement(query);
//			ps.setString(1, traderid);
//			ResultSet set = ps.executeQuery();
//			while(set.next()) {
//				report = new Report(set.getString("traderid"),set.getDouble("aapl"),set.getDouble("amzn"),set.getDouble("goog"),set.getDouble("msft"),set.getDouble("fb"));
//			}
//			set.close();
//			ps.close();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		try {
//			connection.close();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return report;
//		
//	}
	
	public float getFundObligation(String traderid) {
		float fund=0;

		String query = "select * from fundreport where traderid=?";
		Connection connection = ConnectionClass.openConnection();
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(query);
			ps.setString(1, traderid);
			ResultSet set = ps.executeQuery();
			while(set.next()) {
				fund = (float) (set.getDouble("aapl")+set.getDouble("amzn")+set.getDouble("goog")+set.getDouble("msft")+set.getDouble("fb"));
			}
			set.close();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return fund;
		
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReportDAOImpl reportDAOImpl= new ReportDAOImpl();
		Report report = reportDAOImpl.getSecurityReportByName("CITI");
		System.out.println(report.getTraderid()+" "+ report.getAapl());
		//report = reportDAOImpl.getEquityShortage("CITI");
		//System.out.println(report.getTraderid()+" "+ report.getAapl());
		float ans= reportDAOImpl.getFundObligation("GS");
		System.out.println(ans);

	}

}
