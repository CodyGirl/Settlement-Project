package com.UnitTesting;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.dao.CorporateActionDAOImpl;
import com.pojos.corporateActionChild.Bonus;
import com.pojos.corporateActionChild.Dividend;
import com.pojos.corporateActionChild.Split;

public class TestCorpAction {

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
	public void testGetDividendCorporateActions() {
		List<Dividend> l = new ArrayList<>();
		assertEquals(0, (new CorporateActionDAOImpl().getDividendCorporateActions()).size());
	}

	@Test
	public void testGetSplitCorporateActions() {
		List<Split> l = new ArrayList<>();
		assertEquals(0, (new CorporateActionDAOImpl().getSplitCorporateActions()).size());
	}

	@Test
	public void testGetBonusCorporateActions() {
		List<Bonus> l = new ArrayList<>();
		assertEquals(0, (new CorporateActionDAOImpl().getBonusCorporateActions()).size());
	}

	@Test
	public void testAddDividendCorporateAction() {
		String tickerSymbol = "MSFT";
		float percentageDividend = 70 ;
		assertEquals(true, new CorporateActionDAOImpl().addDividendCorporateAction(tickerSymbol, percentageDividend));
	}

	@Test
	public void testAddSplitCorporateAction() {
		String tickerSymbol = "MSFT";
		int ratioA =2 ;
		int ratioB = 7;
		assertEquals(true, new CorporateActionDAOImpl().addSplitCorporateAction(tickerSymbol, ratioA, ratioB));
	}

	@Test
	public void testAddBonusCorporateAction() {
		String tickerSymbol = "MSFT";
		int ratioA =2 ;
		int ratioB = 8;
		assertEquals(true, new CorporateActionDAOImpl().addBonusCorporateAction(tickerSymbol, ratioA, ratioB));
	}

	@Test
	public void testDeleteDividendCorporateActions() {
		assertEquals(true, new CorporateActionDAOImpl().deleteDividendCorporateActions());
	}

	@Test
	public void testDeleteSplitCorporateActions() {
		assertEquals(true, new CorporateActionDAOImpl().deleteSplitCorporateActions());
	}

	@Test
	public void testDeleteBonusCorporateActionss() {
		assertEquals(true, new CorporateActionDAOImpl().deleteBonusCorporateActions());
	}

}
