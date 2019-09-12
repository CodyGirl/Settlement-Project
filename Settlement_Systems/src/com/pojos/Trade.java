package com.pojos;

import java.util.Date;

public class Trade {

	private String tradeId;
	
	private Trader buyer;
	private Trader seller;
	private String tickerSymbol;
	private int equityQty;
	private float equityPrice;
	//private Date settlementDate;
	private int isSettled;
	
	
	
	public String getTradeId() {
		return tradeId;
	}

	public void setTradeId(String tradeId) {
		this.tradeId = tradeId;
	}

	public Trader getBuyer() {
		return buyer;
	}

	public void setBuyer(Trader buyer) {
		this.buyer = buyer;
	}

	public Trader getSeller() {
		return seller;
	}

	public void setSeller(Trader seller) {
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
	
	public int getIsSettled() {
		return isSettled;
	}
	public void setSettled(int isSettled) {
		this.isSettled = isSettled;
	}
	public Trade(String tradeId,Trader buyer, Trader seller, String tickerSymbol, int equityQty, float equityPrice,
			int isSettled) {
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
	public Trade() {
		tradeId= "inavlid";
		buyer =null;
		seller= null;
		tickerSymbol="inavlid";
		equityQty= 0;
		equityPrice=0;
		isSettled= 0;
	}

	@Override
	public String toString() {
		return "Trade [tradeId=" + tradeId + ", buyer=" + buyer + ", seller=" + seller + ", tickerSymbol="
				+ tickerSymbol + ", equityQty=" + equityQty + ", equityPrice=" + equityPrice + ", isSettled="
				+ isSettled + "]";
	}
	
	
	
	
	
}
