package com.pojos.corporateActionChild;

import com.pojos.CorporateAction;

public class Dividend extends CorporateAction {

	public Dividend(String tickerSymbol, float faceValue, double percentageDividend) {
		super(tickerSymbol, faceValue, percentageDividend, 0,0);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calculateReward(double numOfEquity) {
		// TODO Auto-generated method stub
		double result = (numOfEquity * this.getFaceValue()*this.getPercentageDividend())/100;
		return result;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getTickerSymbol()+" "+getPercentageDividend()+" "+getFaceValue();
	}

}