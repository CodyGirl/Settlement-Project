package com.pojos;

public class Report {
	String traderid;
	double aapl,amzn,goog,msft,fb;
	public String getTraderid() {
		return traderid;
	}
	public void setTraderid(String traderid) {
		this.traderid = traderid;
	}
	public double getAapl() {
		return aapl;
	}
	public void setAapl(double aapl) {
		this.aapl = aapl;
	}
	public Report(String traderid, double aapl, double amzn, double goog, double msft, double fb) {
		super();
		this.traderid = traderid;
		this.aapl = aapl;
		this.amzn = amzn;
		this.goog = goog;
		this.msft = msft;
		this.fb = fb;
	}
	public double getAmzn() {
		return amzn;
	}
	public void setAmzn(double amzn) {
		this.amzn = amzn;
	}
	public double getGoog() {
		return goog;
	}
	public void setGoog(double goog) {
		this.goog = goog;
	}
	public double getMsft() {
		return msft;
	}
	public void setMsft(double msft) {
		this.msft = msft;
	}
	public double getFb() {
		return fb;
	}
	public void setFb(double fb) {
		this.fb = fb;
	}
	
}
