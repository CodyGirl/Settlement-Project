package com.dao;

import java.util.List;

import com.pojos.Equity;
import com.pojos.Trader;

public class SettlementReport {

	public void generateSettlement(Trader trader) {
		AdminDAOImpl Dao = new AdminDAOImpl();
		String traderId = trader.getTraderId();
		List<Equity> equities = ObjectsCreation.findEquityDetailsOfTrader(traderId);
		for (Equity equity : equities) {
			
			int correspShare = Dao.getDataFromReportTable(trader, equity);
			float correspFund = Dao.getDataFromFundReportTable(trader, equity);
			float fundBal = trader.getTraderFundBal();
			int equityBal = equity.getQuantity();
			if (correspShare > 0) {
				correspShare += equityBal;
				equity.setQuantity(correspShare);
				Dao.setTraderEquity(trader, equity);
				if(fundBal >= Math.abs(correspFund))
				{
					trader.setTraderFundBal(fundBal-Math.abs(correspFund));
					Dao.setTraderFund(trader);
				}
				else
				{
					float fundShortage = Math.abs(correspFund)-fundBal;
					float fundRate = Dao.getBorrowFundRate("usd");
					float fundInterest = fundRate * (2 / 365);
					float fundCost = fundShortage * fundInterest;
					trader.setTraderFundBal(0 - fundCost);
					Dao.setTraderFund(trader);	
				}	
			} else {
				 fundBal +=correspFund;
				 trader.setTraderFundBal(fundBal);
				Dao.setTraderFund(trader);	
				if (equityBal >= Math.abs(correspShare)) {
					equity.setQuantity(equityBal - Math.abs(correspShare));
					Dao.setTraderEquity(trader, equity);
				} else {
					int shareShortage = Math.abs(correspShare) - equityBal;
					float equityRate = Dao.getBorrowEquityRate(equity);
					//float equityPrice= Dao.getBorrowEquityPrice(equity);
					float equityInterest = equityRate* (2/365);
					float shareCost = shareShortage *equityInterest;
					System.out.println("fundbal : ********** and sharecost"+ fundBal+shareCost);
						float remainingFunds= fundBal - shareCost;
						trader.setTraderFundBal(remainingFunds);
						Dao.setTraderFund(trader);
				}
			}

		}

	}
}
