package com.pojos;

import java.util.Date;

public class Trade {

	private String tradeId;

	private Trader buyer;
	private Trader seller;
	private String tickerSymbol;
	private int equityQty;
	private float equityPrice;

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

	public int isSettled() {
		return isSettled;
	}

	public void setSettled(int isSettled) {
		this.isSettled = isSettled;
	}

	public Trade(String tradeId, Trader buyer, Trader seller, String tickerSymbol, int equityQty, float equityPrice,
			int isSettled) {
		super();
		this.tradeId = tradeId;
		this.buyer = buyer;
		this.seller = seller;
		this.tickerSymbol = tickerSymbol;
		this.equityQty = equityQty;
		this.equityPrice = equityPrice;
		this.isSettled = isSettled;
	}

	public Trade() {
		super();
		this.tradeId = "default";
		this.buyer = new Trader();
		this.seller = new Trader();
		this.tickerSymbol = "Default";
		this.equityQty = 0;
		this.equityPrice = 0;
		this.isSettled = 0;
	}

	@Override
	public String toString() {
//		System.out.println(tradeId);
//		System.out.println(buyer);
//		System.out.println(seller);
//		System.out.println(equityPrice);
//		System.out.println(tickerSymbol);
//		System.out.println(equityQty);
//		System.out.println(isSettled);

		return "{\"tradeId\": \"" + tradeId + "\", \"buyer\": \"" + buyer.getTraderId() + "\", \"seller\": \""
				+ seller.getTraderId() + "\", \"tickerSymbol\": \"" + tickerSymbol + "\",\"equityQty\": \"" + equityQty
				+ "\",\"equityPrice\": \"" + equityPrice + "\",\"isSettled\": \"" + isSettled + "\"}";
	}
//
//	public static void main(String[] args) {
//		Trader buyer=new Trader();
//		Trader seller=new Trader();
//		buyer.setTraderId("GS");
//		seller.setTraderId("CITI");
//		Trade trade=new Trade("123", buyer, seller, "AAPL", 200, (float)202.2, false);
//		System.out.println(trade.toString());
//	}
	// {"tradeId:" + tradeId + ", buyer:" + buyer + ", seller:" + seller + ",
	// tickerSymbol:"+ tickerSymbol + ", equityQty:" + equityQty + ", equityPrice:"
	// + equityPrice + ", settlementDate:"+ settlementDate + ", isSettled:" +
	// isSettled + "}

}
