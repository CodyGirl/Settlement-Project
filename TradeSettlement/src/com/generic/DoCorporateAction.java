package com.generic;

import java.util.ArrayList;
import java.util.List;

import com.pojos.CorporateAction;
import com.pojos.Trader;

public class DoCorporateAction {
	
	public void runme() {
		List<CorporateAction> corporateactions = getDividendCorporateActions();
		corporateactions.forEach((cpa)->{
			List<Trader> securityHolders = findTradersBySecurity();
			securityHolders.forEach((securityHolder)->{
				
				double dividend = cpa.calculateReward((double)securityHolder.getTraderFundBal());
				securityHolder.setTraderFundBal((float)securityHolder.getTraderFundBal()+(float)dividend);
				updateTraderFundBal();
			});
		});
		
		
		corporateactions = getSplitCorporateActions();
		corporateactions.forEach((cpa)->{
			List<Trader> securityHolders = findTradersBySecurity();
			securityHolders.forEach((securityHolder)->{
				
				double shares = cpa.calculateReward((double)securityHolder.getNumOfEquityByName());
				securityHolder.setNumOfEquityByName(shares +(double)securityHolder.getNumOfEquityByName());
				updateTraderSecurityBal();
				updateCorporateActionFaceValue();
			});
		});
		
		corporateactions = getBonusCorporateActions();
		corporateactions.forEach((cpa)->{
			List<Trader> securityHolders = findTradersBySecurity();
			securityHolders.forEach((securityHolder)->{
				
				double shares = cpa.calculateReward((double)securityHolder.getNumOfEquityByName());
				securityHolder.setNumOfEquityByName(shares +(double)securityHolder.getNumOfEquityByName());
				updateTraderSecurityBal();
			});
		});
		

	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DoCorporateAction action = new DoCorporateAction();
		action.runme();
	}

	private static List<CorporateAction> getBonusCorporateActions() {
	// TODO Auto-generated method stub
	return new ArrayList<CorporateAction>();
}
private static void updateCorporateActionFaceValue() {
		// TODO Auto-generated method stub
		
	}

	private static void updateTraderSecurityBal() {
		// TODO Auto-generated method stub
		
	}

	private static List<CorporateAction> getSplitCorporateActions() {
		// TODO Auto-generated method stub
		return new ArrayList<CorporateAction>();
	}

	private static void updateTraderFundBal() {
		// TODO Auto-generated method stub
		
	}

	private static List<Trader> findTradersBySecurity() {
		// TODO Auto-generated method stub
		return new ArrayList<Trader>();
	}

	private static List<CorporateAction> getDividendCorporateActions() {
		// TODO Auto-generated method stub
		return new ArrayList<CorporateAction>();
	}
	
	

}
