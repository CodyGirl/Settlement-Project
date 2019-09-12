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
 * Servlet implementation class AddServlet
 */
@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddServlet() {
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
		
		
		//******** Data to be added in table
		Trade t=new Trade();
		t.setTradeId(((new AdminDAOImpl()).getMaxTradeId()+1)+"");
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
		List<Trade> l = new ArrayList<Trade>();
		l.add(t);
		(new AdminDAOImpl()).inputTrade(l);
		System.out.println(": t "+t.toString());

	}

}
