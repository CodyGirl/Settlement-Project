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

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.dao.AdminDAOImpl;
import com.pojos.Trade;
import com.pojos.Trader;

/**
 * Servlet implementation class EditTrade
 */
@WebServlet("/EditTrade")
public class EditTrade extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditTrade() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Edit Trade Post Method");
		// Request is sent from angular to Java
		String jsonString = request.getReader().readLine();
		System.out.println("\nJSON data : " + jsonString);

		// Convert string to JSON object
		JSONParser parser = new JSONParser();
		JSONObject json = null;
		try {
			json = (JSONObject) parser.parse(jsonString);
			System.out.println(json);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//*****Call Update Trade data Here and send trade response
		Trade tradeOld=new Trade();
		tradeOld.setTradeId((String) json.get("tradeId"));
		int newEquityQty = Integer.parseInt((String) json.get("equityQty"));
		System.out.println(newEquityQty);
		(new AdminDAOImpl()).modifyTrade(tradeOld, newEquityQty);
		System.out.println(": t "+tradeOld.toString());

		
		
		//Updated List getting shown
		List<Trade> tList = (new AdminDAOImpl()).findAllTrades();
		System.out.println(tList.get(0));
		String jstring = new String("[ ");

		Iterator<Trade> itr = tList.listIterator();
		Trade t = new Trade();
		for (Trade trade : tList) {
			t = trade;
			jstring = jstring.concat(t.toString().concat(","));
		}

		jstring = jstring.substring(0, jstring.length() - 1);
		jstring = jstring.concat("]");

		//System.out.println(jstring);
		// System.out.println("JSON STRING : \n" + JSONString);
		response.getWriter().write(jstring);

	}

}
