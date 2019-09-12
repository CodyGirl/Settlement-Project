package com.dao;

import java.util.List;

import com.pojos.corporateActionChild.Bonus;
import com.pojos.corporateActionChild.Dividend;
import com.pojos.corporateActionChild.Split;

public interface CorporateActionDAO {
	
	public List<Dividend> getDividendCorporateActions();
	public List<Split> getSplitCorporateActions();
	public List<Bonus> getBonusCorporateActions();
	public boolean addDividendCorporateAction(String tickerSymbol, float percentageDividend);
	public boolean addSplitCorporateAction(String tickerSymbol, int ratioA, int ratioB);
	public boolean addBonusCorporateAction(String tickerSymbol, int ratioA, int ratioB);
	public boolean deleteDividendCorporateActions();
	public boolean deleteSplitCorporateActions();
	public boolean deleteBonusCorporateActionss();

}