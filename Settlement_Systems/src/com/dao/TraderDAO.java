package com.dao;

import com.pojos.Trader;

public interface TraderDAO {

// float addTraderBalance();	
	
	int getNumOfEquity(String tickerSymbol, String TraderId);
	
	
}
