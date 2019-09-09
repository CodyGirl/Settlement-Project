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

	
	public void  generateObligation()
	{
		
	
      List<Trader> traders= ObjectsCreation.findTrader() ;
      List<Equity> equities= ObjectsCreation.findEquity();
        for(Equity equity:equities)
        {
        	for(Trader trader:traders)
        	{
        		
        		int gross=0;
        		List<Trade> trade= new ArrayList<Trade>();
        		trade = (CLASSNAME).findCorrespTrade(equity.getEquityName(),trader.getTraderName());
        		if (trade.isEmpty()) continue;
        		for(Trade tradeIt:trade) 
        		{
        			if(tradeIt.getBuyer().getTraderName() == trader.getTraderName() )
        		    {
        			     gross+=tradeIt.getEquityQty();
        		    }
        		    if(tradeIt.getSeller().getTraderName()==trader.getTraderName())
        		    {
        			     gross-=tradeIt.getEquityQty()
        		    }
        		}
        		(CLASSNAME).setDataInReportTable(trader.getTraderName()	,equity.getEquityName());
        		(CLASSNAME).generateSettlement(trader,equity,gross);
        	}
        }
	}
	
}


