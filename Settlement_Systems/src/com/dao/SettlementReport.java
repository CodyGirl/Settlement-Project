package com.dao;

import java.util.List;

import com.pojos.Equity;
import com.pojos.Trader;

public class SettlementReport {
	
	

	public static void generateSettlement(Trader trader)
	{
		String traderId= trader.getTraderId();
		List<Equity> equities=  ObjectsCreation.findEquityDetailsOfTrader(traderId);
		 for(Equity equity:equities)
		 {
			 int correspShare = (CLASSNAME).getDataFromReportTable(trader.getTraderName(),equity.getEquityName());
			 float fundBal= trader.getTraderFundBal();
			 int equityBal= equity.getQuantity();
			 if(correspShare >0)
			 {
				 equity.setQuantity(correspShare);
			 }
			 else {
				 if(equityBal >= Math.abs(correspShare))
				 {
					 equity.setQuantity(equityBal-Math.abs(correspShare));
				 }
				 else {
					 int shareShortgae= Math.abs(correspShare)-equityBal;
					 float rate= (CLASSNAME).getBorrowRate(equity.getTickerSymbol());
					 float shareCost= Math.multiplyExact(shareShortgae, rate);
					 if(fundBal >= shareCost )
					 {
						 trader.setTraderFundBal(fundBal-shareCost);
					 }
					 else {
						 float dueCost= shareCost-fundBal;
						 trader.setTraderFundBal(0);
						 //fund balance se bhi jyada hone pr apan ko bass show krna hai ki itta ka shortage rh gya hai
						 //idk how to do that.
					 }
				 }
			 }
			 
		 }
		
		
	}
}
