package com.UnitTesting;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.dao.TraderDAO;
import com.dao.TraderDAOImpl;

public class TestTraderDAOImpl {

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
	public void testGetNumOfEquity() {
		
		TraderDAO ob=new TraderDAOImpl();
		String tickerSymbol="FB";
		String TraderId="BCS";
		
		assertEquals(242623, ob.getNumOfEquity(tickerSymbol, TraderId));
	}

}
