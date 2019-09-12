package com.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.pojos.Equity;
import com.pojos.Trade;
import com.pojos.Trader;

public class ObligationReportImpl {

	public void generateObligation() {

		AdminDAOImpl Dao = new AdminDAOImpl();
		List<Trader> traders = ObjectsCreation.findTrader();
		List<Equity> equities = ObjectsCreation.findEquity();
		for (Equity equity : equities) {
			for (Trader trader : traders) {

				int grossShare = 0;
				int grossAmount=0;
				List<Trade> trade = new ArrayList<Trade>();
				trade = Dao.findCorrespTrade(equity, trader);
				if (trade.isEmpty()) {
					System.out.println("FFFFFUUCKKK");
					Dao.setDataInReportTable(trader, equity, grossShare);
					Dao.setDataInFundReportTable(trader,equity,grossAmount);
					continue;
				} else {
					System.out.println("FFFFFUUCKKK share");
					trade.forEach((s1) -> {
						System.out.println(s1.getEquityQty());
					});

					for (Trade tradeIt : trade) {

						System.out.println(
								"details of that trader" + tradeIt.getBuyer().getTraderName() + trader.getTraderName());
						if (tradeIt.getBuyer().getTraderName().equals(trader.getTraderName())) {
							System.out.println("My trade quantity in if case is " + tradeIt.getEquityQty());

							System.out.println("details of that matched trader" + tradeIt.getBuyer().getTraderName()
									+ trader.getTraderName());

							grossShare += tradeIt.getEquityQty();
							grossAmount -= (tradeIt.getEquityQty()* tradeIt.getEquityPrice());
							
						}  if (tradeIt.getSeller().getTraderName().equals(trader.getTraderName())) {
							System.out.println("My trade quantity in else if case is " + tradeIt.getEquityQty());

							System.out.println("details of that matched trader" + tradeIt.getSeller().getTraderName()
									+ trader.getTraderName());

							grossShare -= tradeIt.getEquityQty();
							grossAmount += (tradeIt.getEquityQty()*tradeIt.getEquityPrice());
						}
					}
					System.out.println("share : amount  " + grossShare+ grossAmount);
					Dao.setDataInReportTable(trader, equity, grossShare);
					Dao.setDataInFundReportTable(trader,equity,grossAmount);
					System.out.println("back to obligation");
					// SettlementReport.generateSettlement(trader,equity,gross);
				}
			}
		}
	}

}
