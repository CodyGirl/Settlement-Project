package com.pojos.corporateActionChild;
import com.pojos.CorporateAction;

public class Dividend extends CorporateAction {

	public Dividend(String tickerSymbol, float faceValue, int numOfEquity, double percentageDividend, int ratioA,
			int ratioB) {
		super(tickerSymbol, faceValue, numOfEquity, percentageDividend, ratioA, ratioB);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calculateReward(double initialFund) {
		// TODO Auto-generated method stub
		double result = (initialFund * this.getPercentageDividend())/100;
		return result;
	}

}
