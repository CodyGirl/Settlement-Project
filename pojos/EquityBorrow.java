package com.pojos;

public class EquityBorrow {

	private String tickerSymbol;
	private float borrowRate;
	
	
	public String getTickerSymbol() {
		return tickerSymbol;
	}
	public void setTickerSymbol(String tickerSymbol) {
		this.tickerSymbol = tickerSymbol;
	}
	public float getBorrowRate() {
		return borrowRate;
	}
	public void setBorrowRate(float borrowRate) {
		this.borrowRate = borrowRate;
	}
	public EquityBorrow(String tickerSymbol, float borrowRate) {
		super();
		this.tickerSymbol = tickerSymbol;
		this.borrowRate = borrowRate;
	}
	public EquityBorrow() {
		super();
	}
	
	
}
