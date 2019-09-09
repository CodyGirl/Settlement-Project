package com.pojos;

public class TraderEquity {
	public String equityName;
	public int quantity;
	public TraderEquity(String equityName, int quantity) {
		super();
		this.equityName = equityName;
		this.quantity = quantity;
	}
	public String getEquityName() {
		return equityName;
	}
	public void setEquityName(String equityName) {
		this.equityName = equityName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return "[Equity Name =" + equityName + ", quantity=" + quantity + "]";
	}
	
}
