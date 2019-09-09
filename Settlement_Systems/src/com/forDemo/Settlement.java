package com.forDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.pojos.Trade;
import com.pojos.Trader;
import com.pojos.TraderEquity;

public class Settlement {
	public static boolean found=false;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Enter Trade info");

		CustomTrade trade;
		trade = takeTrade();
		System.out.println(trade);
		
		Trader buyer, seller;
		System.out.println("Enter Buyer info");
		buyer = takeBuyer();
		System.out.println(buyer);

		System.out.println("Enter Seller info");
		seller = takeBuyer();
		System.out.println(seller);
		
		obligationReport(buyer, seller,trade);
		settlementReport(buyer, seller, trade);

	}
	
	public static void obligationReport(Trader buyer, Trader seller, CustomTrade trade) {
		
		if(trade.getBuyer().equals(buyer.getTraderId())&& trade.getSeller().equals(seller.getTraderId()) ) {
			System.out.println(buyer.getTraderId()+" has bought "+trade.getTickerSymbol()+" for the value of Rs" + trade.getEquityPrice()*trade.getEquityQty());
			System.out.println(seller.getTraderId()+" has sold "+trade.getTickerSymbol()+" for the value of Rs" + trade.getEquityPrice()*trade.getEquityQty());
		}
		else
			System.out.println("not enough information");
		
	}
	
	public static void settlementReport(Trader buyer, Trader seller, CustomTrade trade) {
		if(trade.getBuyer().equals(buyer.getTraderId())&& trade.getSeller().equals(seller.getTraderId()) ) {
//			System.out.println(buyer.getTraderId()+" has bought "+trade.getTickerSymbol()+" for the value of Rs" + trade.getEquityPrice()*trade.getEquityQty());
//			System.out.println(seller.getTraderId()+" has sold "+trade.getTickerSymbol()+" for the value of Rs" + trade.getEquityPrice()*trade.getEquityQty());
			buyer.setTraderFundBal(buyer.getTraderFundBal()- trade.getEquityPrice()*trade.getEquityQty()); 
			found = false;
			buyer.equityBal.forEach((equity)->{
				if(equity.getEquityName().equals(trade.getTickerSymbol())) {
					equity.setQuantity(equity.getQuantity()+trade.getEquityQty());
					found = true;
				}
			});
			if(!found) {
				buyer.equityBal.add(new TraderEquity(trade.getTickerSymbol(), trade.getEquityQty()));
			}
			System.out.println(buyer);

			seller.setTraderFundBal(seller.getTraderFundBal()+trade.getEquityPrice()*trade.getEquityQty());
			found = false;
			seller.equityBal.forEach((equity)->{
				if(equity.getEquityName().equals(trade.getTickerSymbol())) {
					equity.setQuantity(equity.getQuantity()-trade.getEquityQty());
					found = true;
				}
			});
			if(!found) {
				seller.equityBal.add(new TraderEquity(trade.getTickerSymbol(), -1*trade.getEquityQty()));
			}
			System.out.println(seller);

		}
		else
			System.out.println("not enough information");
	}
	
	public static CustomTrade takeTrade() {
		String buyer, seller; 
		String tickerSymbol;
		int equityQty;
		float equityPrice;
		boolean isSettled;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter name of buyer");
		buyer= scanner.next();
		System.out.println("Enter name of seller");
		seller = scanner.next();
		System.out.println("Enter name of Security");
		tickerSymbol  = scanner.next();
		System.out.println("Enter quantity of equity Traded");
		equityQty = scanner.nextInt();
		System.out.println("Enter price  of  each equity Traded");
		equityPrice=scanner.nextFloat();
		isSettled = false;
		CustomTrade trade = new CustomTrade(buyer,seller,tickerSymbol,equityQty,equityPrice,isSettled);
		return trade;
	}
	
	public static Trader takeBuyer() {
		String id;
		float fundBal;
		List<TraderEquity> equityBal;
		System.out.println("Enter Trader name");
		Scanner scanner = new Scanner(System.in);
		id = scanner.next();
		System.out.println("Enter his fund balance");
		fundBal = scanner.nextFloat();
		System.out.println("Enter number of equities he has");
		int numEquity = scanner.nextInt();
		List<TraderEquity> traderEquity = new ArrayList<TraderEquity>();
		for(int i=0; i<numEquity; i++) {
			System.out.println("Enter name of Equity " + (i+1));
			String name = scanner.next();
			System.out.println("Enter quantity of " + name +" he has");
			int quantity = scanner.nextInt();
			traderEquity.add(new TraderEquity(name,quantity));
		}
		Trader buyer = new Trader(id,fundBal,traderEquity);
		return buyer;

	}

}
