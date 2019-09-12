package com.rest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.dao.AdminDAOImpl;
import com.pojos.Trade;
import com.pojos.Trader;

/**
 * Servlet implementation class DeleteTrade
 */
@WebServlet("/DeleteTrade")
public class DeleteTrade extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteTrade() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Delete Trade");
		// Request is sent from angular to Java
		String jsonString = request.getReader().readLine();
		System.out.println("\nJSON data : " + jsonString);

		// Convert string to JSON object
		JSONParser parser = new JSONParser();
		JSONArray jsonArray = null;
		try {
			jsonArray = (JSONArray) parser.parse(jsonString);
			System.out.println(jsonArray);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Iterator<JSONObject> itr = jsonArray.listIterator();
		JSONObject json = new JSONObject();
		List<Trade> tList = new ArrayList<Trade>();
		Trade trade = new Trade();
		while(itr.hasNext()) {
			json = itr.next();
			trade = getTrade(json);
			tList.add(trade);
		}
		System.out.println(tList);
		(new AdminDAOImpl()).deleteTrade(tList);
		// System.out.println("JSON STRING : \n" + JSONString);

		System.out.println(json);
		// *****Call delete Trade data Here and send trade response
				//response.getWriter().write(jstring);

	}

	private Trade getTrade(JSONObject json) {
		// TODO Auto-generated method stub
		Trade t = new  Trade();
		t.setTradeId((String) json.get("tradeId"));
		Trader buyer = new Trader();
		Trader seller = new Trader();
		
		buyer.setTraderId((String) json.get("buyer"));
		t.setBuyer(buyer);
		
		seller.setTraderId((String) json.get("seller"));
		t.setSeller(seller);		
		
		t.setTickerSymbol((String) json.get("tickerSymbol"));
		t.setEquityQty(Integer.parseInt((String) json.get("equityQty")));
		t.setEquityPrice(Float.parseFloat((String) json.get("equityPrice")));
		t.setSettled(0);
		return t;
	}

}
