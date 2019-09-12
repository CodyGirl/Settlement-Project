package com.generic;

import java.util.ArrayList;
import java.util.List;

import com.dao.AdminDAOImpl;
import com.dao.CorporateActionDAOImpl;
import com.dao.ObjectsCreation;
import com.pojos.CorporateAction;
import com.pojos.Equity;
import com.pojos.Trader;
import com.pojos.corporateActionChild.Bonus;
import com.pojos.corporateActionChild.Dividend;
import com.pojos.corporateActionChild.Split;

public class DoCorporateAction {
	
	AdminDAOImpl adminDAOImpl = new AdminDAOImpl();
	
	public void runme() {
		List<Dividend> corporateactions = (new CorporateActionDAOImpl()).getDividendCorporateActions();
		System.out.println(corporateactions.size());
		corporateactions.forEach((cpa)->{
			System.out.println(cpa.toString());
			List<Trader> securityHolders = ObjectsCreation.findTradersBySecurity(cpa.getTickerSymbol());
			System.out.println(securityHolders.size());
			securityHolders.forEach((securityHolder)->{
				
				//stem.out.println(securityHolder.toString());
				double dividend = cpa.calculateReward((double)ObjectsCreation.getNumberOfEquityByName(cpa.getTickerSymbol(), securityHolder));
				securityHolder.setTraderFundBal((float)securityHolder.getTraderFundBal()+(float)dividend);
				securityHolder.toString();
				adminDAOImpl.setTraderFund(securityHolder);
			});
		});
		
		
		List<Split> corporateactions1 = (new CorporateActionDAOImpl()).getSplitCorporateActions();
		corporateactions1.forEach((cpa)->{
			List<Trader> securityHolders = ObjectsCreation.findTradersBySecurity(cpa.getTickerSymbol());
			System.out.println(cpa.toString());
			securityHolders.forEach((securityHolder)->{
				double initialShares = (double)ObjectsCreation.getNumberOfEquityByName(cpa.getTickerSymbol(), securityHolder);
				double shares = cpa.calculateReward(initialShares);
				Equity equity = new Equity();
				equity.setFaceValue(cpa.getFaceValue());
				equity.setTickerSymbol(cpa.getTickerSymbol());
				equity.setQuantity((int)(initialShares+shares));
				adminDAOImpl.setTraderEquity(securityHolder, equity);
				System.out.println(securityHolder.toString());
				System.out.println(cpa.toString());
				//updateTraderSecurityBal();
				//System.out.println("Face value initial");
				
			});
			
			double faceValue = (cpa.getFaceValue()*cpa.getRatioB())/(cpa.getRatioA()+cpa.getRatioB());
			System.out.println("face value initial "+ cpa.getFaceValue());
			System.out.println("face value final " + faceValue);
			ObjectsCreation.updateFaceValue(cpa,faceValue);
		});
//		
		List<Bonus> corporateactions11 = (new CorporateActionDAOImpl()).getBonusCorporateActions();
		corporateactions11.forEach((cpa)->{
			List<Trader> securityHolders = ObjectsCreation.findTradersBySecurity(cpa.getTickerSymbol());
			System.out.println(cpa.toString());
			securityHolders.forEach((securityHolder)->{
				
				double initialShares = (double)ObjectsCreation.getNumberOfEquityByName(cpa.getTickerSymbol(), securityHolder);
				double shares = cpa.calculateReward(initialShares);
				Equity equity = new Equity();
				equity.setFaceValue(cpa.getFaceValue());
				equity.setTickerSymbol(cpa.getTickerSymbol());
				equity.setQuantity((int)(initialShares+shares));
				adminDAOImpl.setTraderEquity(securityHolder, equity);
				
			});
		});
		

	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DoCorporateAction action = new DoCorporateAction();
		CorporateActionDAOImpl cpadaoimpl = new CorporateActionDAOImpl();
//		cpadaoimpl.addDividendCorporateAction("AAPL", 15);
//		cpadaoimpl.addBonusCorporateAction("FB", 2, 3);
//		cpadaoimpl.addSplitCorporateAction("MSFT", 4, 2);
//		action.runme();
		cpadaoimpl.deleteBonusCorporateActionss();
		cpadaoimpl.deleteDividendCorporateActions();
		cpadaoimpl.deleteSplitCorporateActions();
		
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
