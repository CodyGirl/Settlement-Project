package com.pojos;

import java.util.List;

public class Trader {

	private String traderId;
	private String traderName;
	private String traderPassword;
	private float traderFundBal;
	private List<Equity> equityBal;
	
	
	
	public Trader() {
		traderId="invalid";
		traderName="invalid";
		traderPassword="inavlid";
		traderFundBal=(float) 0.00;
		
	}
	
	public Trader(String traderId, String traderName, String traderPassword, float traderFundBal,
			List<Equity> equityBal) {
		this.traderId = traderId;
		this.traderName = traderName;
		this.traderPassword = traderPassword;
		this.traderFundBal = traderFundBal;
		this.equityBal = equityBal;
	}

	public String getTraderName() {
		return traderName;
	}

	public void setTraderName(String traderName) {
		this.traderName = traderName;
	}

	public String getTraderId() {
		return traderId;
	}
	public void setTraderId(String traderId) {
		this.traderId = traderId;
	}
	public String getTraderPassword() {
		return traderPassword;
	}
	public void setTraderPassword(String traderPassword) {
		this.traderPassword = traderPassword;
	}
	public float getTraderFundBal() {
		return traderFundBal;
	}
	public void setTraderFundBal(float traderFundBal) {
		this.traderFundBal = traderFundBal;
	}
	public List<Equity> getEquityBal() {
		return equityBal;
	}
	public void setEquityBal(List<Equity> equityBal) {
		this.equityBal = equityBal;
	}
	public double getNumOfEquityByName() {
		// TODO Auto-generated method stub
		return 0;
	}
	public void setNumOfEquityByName(double d) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		return "Trader [traderId=" + traderId + ", traderName=" + traderName + ", traderPassword=" + traderPassword
				+ ", traderFundBal=" + traderFundBal + ", equityBal=" + equityBal + "]";
	}
	
	
	

	
	
	
}
