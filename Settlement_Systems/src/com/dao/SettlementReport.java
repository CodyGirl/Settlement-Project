package com.dao;

import java.util.List;

import com.pojos.Equity;
import com.pojos.Trader;

public class SettlementReport {

	public void generateSettlement(String traderId) {
		Trader trader = ObjectsCreation.findTraderById(traderId);
		AdminDAOImpl Dao = new AdminDAOImpl();
		 traderId = trader.getTraderId();
		List<Equity> equities = ObjectsCreation.findEquityDetailsOfTrader(traderId);
		float grossFund = 0;
		float fundBal = trader.getTraderFundBal();
		for (Equity equity : equities) {
			float correspFund = Dao.getDataFromFundReportTable(trader, equity);
			grossFund += correspFund;

		}
		System.out.println("*****traderwise fundreport ***** " + grossFund + "   " + trader.getTraderId());
		float netFund = grossFund + fundBal;

		if (netFund < 0) {
			float fundRate = Dao.getBorrowFundRate("usd");
			double fundInterest = (fundRate * (2.0 / 365.0)) / 100;
			double fundCost = netFund * fundInterest;
			Dao.setDataInFundInterestTable(trader, fundCost);
			netFund += fundCost;
			trader.setTraderFundBal(netFund);
			Dao.setTraderFund(trader);
		} else {
			Dao.setDataInFundInterestTable(trader, 0);
			trader.setTraderFundBal(netFund);
			Dao.setTraderFund(trader);
		}
	

		for (Equity equity : equities) {
			fundBal = trader.getTraderFundBal();
			System.out.println(" FUND BALANCEEEEEEEEEEE    " + fundBal + "  and trader .."+ trader.getTraderId());
			int correspShare = Dao.getDataFromReportTable(trader, equity);
			int equityBal = equity.getQuantity();
			if (correspShare >= 0) {
				equityBal += correspShare;
				equity.setQuantity(equityBal);
				Dao.setTraderEquity(trader, equity);
				Dao.setDataInEquityInterestTable(trader, equity, 0);
				Dao.setDataInEquityShortageTable(trader, equity, 0);
			} else {
				if (equityBal >= Math.abs(correspShare)) {
					equityBal += correspShare;
					equity.setQuantity(equityBal);
					Dao.setTraderEquity(trader, equity);
					Dao.setDataInEquityInterestTable(trader, equity, 0);
					Dao.setDataInEquityShortageTable(trader, equity, 0);
				} else {
					int shareShortage = equityBal - Math.abs(correspShare);
					Dao.setDataInEquityShortageTable(trader, equity, shareShortage);
					equityBal = 0;
					equity.setQuantity(equityBal);
					Dao.setTraderEquity(trader, equity);
                     
					float equityRate = Dao.getBorrowEquityRate(equity);
					float equityPrice = Dao.getBorrowEquityPrice(equity);
					double equityInterest = (equityPrice * equityRate * (2.0 / 365.0)) / 100;
					double shareCost = shareShortage * equityInterest;
					System.out.println("equity interest charge  ###### " + trader.getTraderId() + " "
							+ equity.getEquityName() + " " + equityInterest + " INTERSEST $$$$$ " + shareCost);
					Dao.setDataInEquityInterestTable(trader, equity, shareCost);
					float remainingFunds = (float) (fundBal + shareCost);
					System.out.println("after shortage FUND BALANCEEEEEEEEEEE    " + remainingFunds + "  and trader .."+ trader.getTraderId());
					trader.setTraderFundBal(remainingFunds);
					Dao.setTraderFund(trader);
				}

			}

		}

	}

}
