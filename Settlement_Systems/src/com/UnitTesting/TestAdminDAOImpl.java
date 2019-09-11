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
import com.dao.AdminLoginDAO;
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
//		List<Trade> trades=new ArrayList<>();
//		
//		Trader buyer=new Trader();
//		buyer.setTraderId("CITI");
//		
//		Trader seller=new Trader();
//		seller.setTraderId("CITI");
//		
//		Trade trade=new Trade();
//		trade.setTradeId("52");
//		trade.setTickerSymbol("MSFT");
//		trade.setBuyer(buyer);
//		trade.setSeller(seller);
//		trade.setEquityQty(3000);
//		trade.setEquityPrice(123.5f);
//		
//		trades.add(trade);
//		
//		AdminDAO ob=new AdminDAOImpl();		
//		assertEquals(true, ob.inputTrade(trades));
//		
//		
//	}

	@Test
	public void testSettleTrade() {
		fail("Not yet implemented");
	}

//	@Test
//	public void testFindAllTrades() {
//		
//		AdminDAO ob=new AdminDAOImpl();
//		List<Trade> list=ob.findAllTrades();
//		
//		Trade trade=list.get(1);
//		assertEquals(52, list.size());
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
//		Trade trade = list.get(0);
//		
//		assertEquals("29", trade.getTradeId());
//		assertEquals(4,list.size() );
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
//		int gross=100;
//		
//		assertEquals(true, ob.setDataInReportTable(trader, equity, gross));
//		
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
//		assertEquals(100, ob.getDataFromReportTable(trader, equity));
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
//		
//		Trader trader=new Trader();
//		trader.setTraderId("CITI");
//		String tickerSymbol="AAPL";
//		assertEquals(2432, ob.getNumOfEquity(tickerSymbol, trader));
//	}

//	@Test
//	public void testSetNumOfEquityByName() {
//		AdminDAO ob=new AdminDAOImpl();
//		
//		Trader trader = new Trader();
//		trader.setTraderId("GS");
//		String tickerSymbol="FB";
//		int quantity=2500;
//		assertEquals(true, ob.setNumOfEquityByName(trader, tickerSymbol, quantity));
//	}

	@Test
	public void testDeclareAction() {
		fail("Not yet implemented");
	}

//	@Test
//	public void testSetTraderEquity() {
//		Trader trader=new Trader();
//		trader.setTraderId("1");
//		
//		Equity equity=new Equity();
//		equity.setQuantity(3333);
//		equity.setTickerSymbol("FB");
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
//		trader.setTraderId("1");
//		trader.setTraderFundBal(250000);
//		
//		assertEquals(true, ob.setTraderFund(trader));
//	}

	@Test
	public void testGenerateRandomTrades() {
		AdminDAO ob=new AdminDAOImpl();
		assertEquals(true, ob.generateRandomTrades());
	}

//	@Test
//	public void testDeleteTrade() {
//		Trade t=new Trade();
//		t.setTradeId("15");
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
//	public void testGetBorrowFundRate() {
//		AdminDAO ob=new AdminDAOImpl();
//		
//		assertEquals(1.25f, ob.getBorrowFundRate("usd"), 0.001);
//		assertEquals(1.1f, ob.getBorrowFundRate("inr"), 0.001);
//		assertEquals(1.15f, ob.getBorrowFundRate("jpy"), 0.001);
//	}

}
