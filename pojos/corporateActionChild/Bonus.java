package com.pojos.corporateActionChild;


import com.pojos.CorporateAction;

public class Bonus extends CorporateAction {

	public Bonus(String tickerSymbol, float faceValue, int numOfEquity, double percentageDividend, int ratioA,
			int ratioB) {
		super(tickerSymbol, faceValue, numOfEquity, percentageDividend, ratioA, ratioB);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calculateReward(double initialSecurity) {
		int result =(int) (initialSecurity/this.getRatioB())*this.getRatioA();
		return result;
	}

}




