package com.pojos.corporateActionChild;

import com.pojos.CorporateAction;

public class Split extends CorporateAction {

	public Split(String tickerSymbol, float faceValue, int ratioA,
			int ratioB) {
		super(tickerSymbol, faceValue, 0, ratioA, ratioB);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calculateReward(double initialSecurity) {
		// TODO Auto-generated method stub
		int result =(int) (initialSecurity/this.getRatioB())*this.getRatioA();
		this.setFaceValue(this.getFaceValue()*this.getRatioB()/(this.getRatioA()+this.getRatioB()));
		return result;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getTickerSymbol()+" "+getRatioA()+":"+getRatioB();
	}

}
