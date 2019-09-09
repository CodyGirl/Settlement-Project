package com.forDemo;
import java.util.Date;

public class CustomTrade {

	private String tradeId;
	
	private String buyer;
	private String seller;
	private String tickerSymbol;
	private int equityQty;
	private float equityPrice;
	private Date settlementDate;
	private boolean isSettled;
	
	
	
	public String getTradeId() {
		return tradeId;
	}



	public void setTradeId(String tradeId) {
		this.tradeId = tradeId;
	}



	public String getBuyer() {
		return buyer;
	}



	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}



	public String getSeller() {
		return seller;
	}



	public void setSeller(String seller) {
		this.seller = seller;
	}



	public String getTickerSymbol() {
		return tickerSymbol;
	}



	public void setTickerSymbol(String tickerSymbol) {
		this.tickerSymbol = tickerSymbol;
	}



	public int getEquityQty() {
		return equityQty;
	}



	public void setEquityQty(int equityQty) {
		this.equityQty = equityQty;
	}



	public float getEquityPrice() {
		return equityPrice;
	}



	public void setEquityPrice(float equityPrice) {
		this.equityPrice = equityPrice;
	}



	public Date getSettlementDate() {
		return settlementDate;
	}



	public void setSettlementDate(Date settlementDate) {
		this.settlementDate = settlementDate;
	}



	public boolean isSettled() {
		return isSettled;
	}



	public void setSettled(boolean isSettled) {
		this.isSettled = isSettled;
	}



	public CustomTrade(String buyer, String seller, String tickerSymbol, int equityQty, float equityPrice, boolean isSettled) {
		super();
		this.tradeId = tradeId;
		this.buyer = buyer;
		this.seller = seller;
		this.tickerSymbol = tickerSymbol;
		this.equityQty = equityQty;
		this.equityPrice = equityPrice;
		//this.settlementDate = settlementDate;
		this.isSettled = isSettled;
	}
	
	
	
	
}

