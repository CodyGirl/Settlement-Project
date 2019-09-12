package com.rest;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.AdminDAO;
import com.dao.AdminDAOImpl;
import com.pojos.Trade;

/**
 * Servlet implementation class GenerateTradeList
 */
@WebServlet("/GenerateTradeList")
public class GenerateTradeList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GenerateTradeList() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//Call Random Function
		AdminDAO a = new AdminDAOImpl();
		a.generateRandomTrades();
		List<Trade> tList = a.findAllTrades();
		System.out.println(tList.get(0));
		String jstring = new String("[ ");

		Iterator<Trade> itr = tList.listIterator();
		Trade t = new Trade();
		for (Trade trade : tList) {
			t = trade;
//			System.out.println(t);
			jstring = jstring.concat(t.toString().concat(","));
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
