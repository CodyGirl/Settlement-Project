package com.dao;

import java.util.List;

import com.pojos.corporateActionChild.Bonus;
import com.pojos.corporateActionChild.Dividend;
import com.pojos.corporateActionChild.Split;

public interface CorporateActionDAO {
	
	public List<Dividend> getDividendCorporateActions();
	public List<Split> getSplitCorporateActions();
	public List<Bonus> getBonusCorporateActions();

}
