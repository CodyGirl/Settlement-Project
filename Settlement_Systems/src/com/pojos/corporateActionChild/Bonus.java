package com.pojos.corporateActionChild;

import com.pojos.CorporateAction;

public class Bonus extends CorporateAction {

	public Bonus(String tickerSymbol, float faceValue, int ratioA,
			int ratioB) {
		super(tickerSymbol, faceValue, 0, ratioA, ratioB);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calculateReward(double initialSecurity) {
		int result =(int) (initialSecurity/this.getRatioB())*this.getRatioA();
		return result;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getTickerSymbol()+" "+getRatioA()+":"+getRatioB();
	}

}