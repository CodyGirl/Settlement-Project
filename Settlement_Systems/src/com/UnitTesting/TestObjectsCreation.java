package com.UnitTesting;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.dao.ObjectsCreation;
import com.pojos.Equity;
import com.pojos.Trader;

public class TestObjectsCreation {

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

	@Test
	public void testFindEquityDetailsOfTrader() {
		ObjectsCreation ob=new ObjectsCreation();
		List<Equity> equity=ob.findEquityDetailsOfTrader("CITI");
		Equity e=equity.get(3);
		
		assertEquals(5, equity.size());
		assertEquals(454332, e.getQuantity());
	}

	@Test
	public void testFindTrader() {
		ObjectsCreation ob=new ObjectsCreation();
		List<Trader> traders=ob.findTrader();
		Trader trader=traders.get(4);
		
		assertEquals(5, traders.size());
		assertEquals("CITI", trader.getTraderId());
	}

	@Test
	public void testFindTraderById() {
		
		ObjectsCreation ob=new ObjectsCreation();
		Trader t =ob.findTraderById("JPM");
		assertEquals(5322113.0f, t.getTraderFundBal(),0.001);
		
	}

	@Test
	public void testFindEquity() {
		ObjectsCreation ob=new ObjectsCreation();
		List<Equity> equities=ob.findEquity();
		
		Equity e=equities.get(1);
		
		assertEquals(0.05f, e.getFaceValue(),0.001);
		assertEquals(5, equities.size());
	}

}
