package com.UnitTesting;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.dao.AdminDAO;
import com.dao.AdminDAOImpl;
import com.pojos.Equity;
import com.pojos.Trade;
import com.pojos.Trader;

public class TestAdminDAOImpl {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

//	@Test
//	public void testInputTrade() {
//		
//List<Trade> trades=new ArrayList<>();
//		
//		Trader buyer=new Trader();
//		buyer.setTraderId("CITI");
//		
//		Trader seller=new Trader();
//		seller.setTraderId("CITI");
//		
//		Trade trade=new Trade();
//		
//		trade.setTradeId("51");
//		trade.setTickerSymbol("MSFT");
//		trade.setBuyer(buyer);
//		trade.setSeller(seller);
//		trade.setEquityQty(3000);
//		trade.setEquityPrice(123.5f);
//		trade.setSettled(0);
//		
//		trades.add(trade);
//		
//		AdminDAO ob=new AdminDAOImpl();		
//		assertEquals(true, ob.inputTrade(trades));
//		
//	}

//	@Test
//	public void testFindAllTrades() {
//		AdminDAO ob=new AdminDAOImpl();
//		List<Trade> list=ob.findAllTrades();
//		
//		Trade trade=list.get(1);
//		assertEquals(51, list.size());
//		assertEquals("4", trade.getTradeId());
//	}

//	@Test
//	public void testFindCorrespTrade() {
//		Trader trader=new Trader();
//		Equity equity=new Equity();
//		equity.setTickerSymbol("MSFT");
//		trader.setTraderId("CITI");
//		
//		AdminDAO ob=new AdminDAOImpl();
//		
//		List<Trade> list=ob.findCorrespTrade(equity, trader);
//		Trade trade = list.get(1);
//		
//		assertEquals("25", trade.getTradeId());
//		assertEquals(5,list.size() );
//	}

//	@Test
//	public void testSetDataInReportTable() {
//		AdminDAO ob=new AdminDAOImpl();
//		
//		Trader trader=new Trader();
//		trader.setTraderId("CITI");
//		
//		Equity equity=new Equity();
//		equity.setTickerSymbol("AAPL");
//		
//		int gross=200;
//		
//		assertEquals(true, ob.setDataInReportTable(trader, equity, gross));
//	}

//	@Test
//	public void testGetDataFromReportTable() {
//		Trader trader = new Trader();
//		trader.setTraderId("CITI");
//		
//		Equity equity=new Equity();
//		equity.setTickerSymbol("AAPL");
//		
//		AdminDAO ob=new AdminDAOImpl();
//		
//		assertEquals(200, ob.getDataFromReportTable(trader, equity));
//	}

//	@Test
//	public void testSetDataInFundReportTable() {
//		AdminDAO ob=new AdminDAOImpl();
//		
//		Trader trader =new Trader();
//		Equity equity =new Equity();
//		
//		equity.setTickerSymbol("AAPL");
//		trader.setTraderId("JPM");
//		
//		int gross=100;
//		
//		assertEquals(true, ob.setDataInFundReportTable(trader, equity, gross));
//	}

//	@Test
//	public void testGetDataFromFundReportTable() {
//		Trader trader =new Trader();
//		Equity equity =new Equity();
//		AdminDAO ob=new AdminDAOImpl();
//		equity.setTickerSymbol("AAPL");
//		trader.setTraderId("JPM");
//		
//		float value=ob.getDataFromReportTable(trader, equity);
//		assertEquals(100.0f, ob.getDataFromFundReportTable(trader, equity),0.000f);
//		
//	}

//	@Test
//	public void testSetDataInFundInterestTable() {
//		Trader trader =new Trader();
//		trader.setTraderId("JPM");
//		
//		double fundCost=5.3d;
//		AdminDAO ob=new AdminDAOImpl();
//		
//		assertEquals(true, ob.setDataInFundInterestTable(trader, fundCost));
//	}

//	@Test
//	public void testSetDataInEquityInterestTable() {
//		Trader trader=new Trader();
//		Equity equity=new Equity();
//		double fundCost=5.4D;
//		
//		trader.setTraderId("GS");
//		equity.setTickerSymbol("AAPL");
//		AdminDAO ob=new AdminDAOImpl();
//		assertEquals(true, ob.setDataInEquityInterestTable(trader, equity, fundCost));
//	}

//	@Test
//	public void testSetDataInEquityShortageTable() {
//		Trader trader=new Trader();
//		Equity equity=new Equity();
//		
//		trader.setTraderId("GS");
//		equity.setTickerSymbol("AAPL");
//		
//		int shareShortage=20;
//		AdminDAO ob=new AdminDAOImpl();
//		assertEquals(true, ob.setDataInEquityShortageTable(trader, equity, shareShortage));
//		
//
//	}

//	@Test
//	public void testModifyTrade() {
//		Trade trade=new Trade();
//		trade.setTradeId("1");
//		
//		int quantity=5000;
//		AdminDAO ob=new AdminDAOImpl();
//		 
//		assertEquals(true, ob.modifyTrade(trade, quantity));
//	}

//	@Test
//	public void testGetNumOfEquity() {
//		AdminDAO ob=new AdminDAOImpl();
//		Trader trader=new Trader();
//		trader.setTraderId("CITI");
//		String tickerSymbol="AAPL";
//		assertEquals(2432, ob.getNumOfEquity(tickerSymbol, trader));
//	}

//	@Test
//	public void testSetNumOfEquityByName() {
//		AdminDAO ob=new AdminDAOImpl();
//		Trader trader = new Trader();
//		trader.setTraderId("GS");
//		String tickerSymbol="FB";
//		int quantity=2600;
//		assertEquals(true, ob.setNumOfEquityByName(trader, tickerSymbol, quantity));
//	}

//	@Test
//	public void testSetTraderEquity() {
//		Trader trader=new Trader();
//		trader.setTraderId("CITI");
//		
//		Equity equity=new Equity();
//		equity.setQuantity(45000);
//		equity.setTickerSymbol("AMZN");
//		
//		AdminDAO ob=new AdminDAOImpl();
//		
//		assertEquals(true, ob.setTraderEquity(trader, equity));
//	}

//	@Test
//	public void testSetTraderFund() {
//		AdminDAO ob=new AdminDAOImpl();
//		
//		Trader trader = new Trader();
//		trader.setTraderId("GS");
//		trader.setTraderFundBal(250000);
//		
//		assertEquals(true, ob.setTraderFund(trader));
//	}

//	@Test
//	public void testGenerateRandomTrades() {
//		AdminDAO ob=new AdminDAOImpl();
//		assertEquals(true, ob.generateRandomTrades());
//	}

//	@Test
//	public void testDeleteTrade() {
//		Trade t=new Trade();
//		t.setTradeId("1");
//		
//		AdminDAO ob=new AdminDAOImpl();
//		
//		List<Trade> tradeList = new ArrayList<Trade>();
//		
//		tradeList.add(t);
//		
//		assertEquals(true, ob.deleteTrade(tradeList));
//	}

//	@Test
//	public void testGetBorrowEquityRate() {
//		AdminDAO ob=new AdminDAOImpl();
//		
//		Equity e=new Equity();
//		e.setTickerSymbol("MSFT");
//		
//		assertEquals(7.0f, ob.getBorrowEquityRate(e),0.001);
		
//	}

//	@Test
//	public void testGetBorrowEquityPrice() {
//		AdminDAO ob=new AdminDAOImpl();
//		
//		Equity equity=new Equity();
//		equity.setTickerSymbol("FB");
//		
//		assertEquals(78.0, ob.getBorrowEquityPrice(equity),0.001f);
//	}

//	@Test
//	public void testGetBorrowFundRate() {
//		AdminDAO ob=new AdminDAOImpl();
//		
//		assertEquals(1.25f, ob.getBorrowFundRate("usd"), 0.001);
//		assertEquals(1.1f, ob.getBorrowFundRate("inr"), 0.001);
//		assertEquals(1.15f, ob.getBorrowFundRate("jpy"), 0.001);
//	}

//	@Test
//	public void testGenerateCorpAction() {
//		fail("Not yet implemented");
//	}

}
