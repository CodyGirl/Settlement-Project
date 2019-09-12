package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.pojos.Equity;
import com.pojos.Trade;
import com.pojos.Trader;

public interface AdminDAO {

	void generateCorpAction();
	
	void generateRandomTrades();
	
	boolean inputTrade(List<Trade> trades) ;
	
	List<Trade> findAllTrades();
	
	List<Trade> findCorrespTrade(Equity equityName,Trader trader);
	
	boolean setDataInReportTable(Trader trader,Equity equity,int gross);
	
	int getDataFromReportTable(Trader trader, Equity equity);
	
	int getNumOfEquity(String tickerSymbol,Trader trader);
	
	boolean setNumOfEquityByName(Trader trader,String tickerSymbol,int quantity);
	
	boolean declareAction() ;//todo

	//int getNumOfEquity(String tickerSymbol);
	
	boolean modifyTrade(Trade trade,int quantity);
	
	boolean deleteTrade(List<Trade> list);
	
	//boolean settleTrade() ;//todo
	
	boolean addTrade(String buyer);
	
}
