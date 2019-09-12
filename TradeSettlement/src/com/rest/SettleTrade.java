package com.rest;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.AdminDAOImpl;
import com.dao.ObjectsCreation;
import com.dao.ObligationReportImpl;
import com.dao.SettlementReport;
import com.pojos.Equity;
import com.pojos.Trade;
import com.session.SessionDetails;

/**
 * Servlet implementation class SettleTrade
 */
@WebServlet("/SettleTrade")
public class SettleTrade extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SettleTrade() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// ************Call Settle Trade Function
		System.out.println(SessionDetails.getTID()+" "+SessionDetails.getTPASS());
		(new ObligationReportImpl()).generateObligation();
		(new SettlementReport()).generateSettlement(SessionDetails.getTID());
		System.out.println("Trade Settled");

		//Change the hardcoded value here
		List<Equity> eList = (new ObjectsCreation()).findEquityDetailsOfTrader(SessionDetails.getTID());
		System.out.println(eList.get(0));
		String jstring = new String("[ ");

		Iterator<Equity> itr = eList.listIterator();
		Equity e = new Equity();
		String jsonFormat = new String();
		for (Equity equity : eList) {
			e = equity;


			jsonFormat = "{\"companyname\": \""+e.getEquityName()+"\", \"tickersymbol\": \""+e.getTickerSymbol()+"\", \"quantity\": \""+e.getQuantity() +"\"}";
			jstring = jstring.concat(jsonFormat.concat(","));
		}

		jstring = jstring.substring(0, jstring.length() - 1);
		jstring = jstring.concat("]");

		System.out.println(jstring);
		// System.out.println("JSON STRING : \n" + JSONString);
		response.getWriter().write(jstring);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
