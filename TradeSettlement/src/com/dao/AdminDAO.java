package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.pojos.Equity;
import com.pojos.Trade;
import com.pojos.Trader;

public interface AdminDAO {

	
	boolean inputTrade(List<Trade> trades) ;
		
	List<Trade> findAllTrades();
	
	List<Trade> findCorrespTrade(Equity equityName,Trader trader);
	
	boolean setDataInReportTable(Trader trader,Equity equity,int gross);
	
	int getNumOfEquity(String tickerSymbol,Trader trader);
	
	boolean setNumOfEquityByName(Trader trader,String tickerSymbol,int quantity);
	
	//int getNumOfEquity(String tickerSymbol);
	
	boolean modifyTrade(Trade trade,int quantity);

	boolean setTraderEquity(Trader trader, Equity equity);

	boolean deleteTrade(List<Trade> list);

	boolean setTraderFund(Trader trader);

	float getBorrowEquityRate(Equity equity);

	float getBorrowFundRate(String currency);

	int getDataFromReportTable(Trader trader, Equity equity);

	boolean generateRandomTrades();

	boolean setDataInEquityShortageTable(Trader trader, Equity equity, int shareShortage);

	boolean setDataInEquityInterestTable(Trader trader, Equity equity, double fundCost);

	boolean setDataInFundInterestTable(Trader trader, double fundCost);

	float getDataFromFundReportTable(Trader trader, Equity equity);

	boolean setDataInFundReportTable(Trader trader, Equity equity, int gross);

	float getBorrowEquityPrice(Equity equity);

	void generateCorpAction();
	
}
