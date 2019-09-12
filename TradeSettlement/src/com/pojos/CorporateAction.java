package com.pojos;

import java.util.Date;

public abstract class CorporateAction {

	
	private String tickerSymbol;
	private float faceValue;
	//private Object action;
	//private Date actionDate;
	
	//private int numOfEquity;
	//private float fund;
//	private float initialFund;
//	private int initialSecurity;
//	private int initalFaceValue;
	
	private double percentageDividend;
	private int ratioA;
	private int ratioB;

	
	public double getPercentageDividend() {
		return percentageDividend;
	}


	public void setPercentageDividend(double percentageDivident) {
		this.percentageDividend = percentageDivident;
	}


	public CorporateAction(String tickerSymbol, float faceValue, double percentageDividend, int ratioA,
			int ratioB) {
		super();
		this.tickerSymbol = tickerSymbol;
		this.faceValue = faceValue;
		//this.numOfEquity = numOfEquity;
		this.percentageDividend = percentageDividend;
		this.ratioA = ratioA;
		this.ratioB = ratioB;
	}


	public int getRatioA() {
		return ratioA;
	}


	public void setRatioA(int ratioA) {
		this.ratioA = ratioA;
	}


	public int getRatioB() {
		return ratioB;
	}


	public void setRatioB(int ratioB) {
		this.ratioB = ratioB;
	}


	abstract public double calculateReward(double something);
	
	
//	public int getNumOfEquity() {
//		return numOfEquity;
//	}
//	public void setNumOfEquity(int numOfEquity) {
//		this.numOfEquity = numOfEquity;
//	}

	public String getTickerSymbol() {
		return tickerSymbol;
	}
	public void setTickerSymbol(String tickerSymbol) {
		this.tickerSymbol = tickerSymbol;
	}
	public float getFaceValue() {
		return faceValue;
	}
	public void setFaceValue(float faceValue) {
		this.faceValue = faceValue;
	}

}
