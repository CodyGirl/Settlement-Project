package com.test;

import java.util.List;

import com.dao.ObjectsCreation;
import com.dao.ObligationReportImpl;
import com.dao.SettlementReport;
import com.dao.SettlementReport_old;
import com.pojos.Equity;
import com.pojos.Trader;

public class TestObjectsCreation {
	public static void main(String[] args) {
		List<Trader> traders=ObjectsCreation.findTrader();
//		trader.forEach((s)->
//		{
//			System.out.println(s);
//		});
////		
		ObligationReportImpl o1= new ObligationReportImpl();
		o1.generateObligation();
//		
		//Trader trader = traders.get(2);
		SettlementReport s1= new SettlementReport();
		
		   s1.generateSettlement("GS");
		
	}
	

}
//alter system set open_cursors = 1000 scope=both;
