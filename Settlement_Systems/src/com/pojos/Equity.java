package com.pojos;

public class Equity {

	private String tickerSymbol;
	private String equityName;
	private float price;
	
	
	public String getTickerSymbol() {
		return tickerSymbol;
	}
	public void setTickerSymbol(String tickerSymbol) {
		this.tickerSymbol = tickerSymbol;
	}
	public String getEquityName() {
		return equityName;
	}
	public void setEquityName(String equityName) {
		this.equityName = equityName;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Equity(String tickerSymbol, String equityName, float price) {
		super();
		this.tickerSymbol = tickerSymbol;
		this.equityName = equityName;
		this.price = price;
	}
	public Equity() {
		super();
	}
	
}
