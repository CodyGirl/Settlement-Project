package com.pojos;

public class Equity {

	private String tickerSymbol;
	private String equityName;
	private float faceValue;
	private int quantity;
	
	
	public Equity(String tickerSymbol, String equityName, float faceValue, int quantity) {
		this.tickerSymbol = tickerSymbol;
		this.equityName = equityName;
		this.faceValue = faceValue;
		this.quantity = quantity;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
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
	public float getFaceValue() {
		return faceValue;
	}
	public void setFaceValue(float price) {
		this.faceValue = price;
	}
	
	public Equity() {
		tickerSymbol="invalid";
		equityName= "invalid";
		faceValue= 0;
		quantity=0;
	}
	@Override
	public String toString() {
		return "Equity [tickerSymbol=" + tickerSymbol + ", equityName=" + equityName + ", faceValue=" + faceValue
				+ ", quantity=" + quantity + "]";
	}
	
	
}
