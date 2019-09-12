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
import com.dao.CorporateActionDAOImpl;
import com.pojos.Trade;
import com.pojos.corporateActionChild.Bonus;
import com.pojos.corporateActionChild.Dividend;
import com.pojos.corporateActionChild.Split;

/**
 * Servlet implementation class CorporateAction
 */
@WebServlet("/CorporateAction")
public class CorporateAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CorporateAction() {
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
		String jstring = new String("[ ");
		
		List<Dividend> dList = (new CorporateActionDAOImpl()).getDividendCorporateActions();
		Iterator<Dividend> itr = dList.listIterator();
		Dividend d = null;
		for (Dividend dividend : dList) {
			d = dividend;
			jstring += "{\"action\": \"" + "dividend" + "\",\"tickersymbol\": \"" + dividend.getTickerSymbol()
					+ "\", \"price\": \"" + dividend.getPercentageDividend() + "\"}";
			jstring = jstring.concat(",");
		}

		List<Split> sList = (new CorporateActionDAOImpl()).getSplitCorporateActions();
		Iterator<Split> itrs = sList.listIterator();
		Split s = null;
		for (Split split : sList) {
			s = split;
			jstring += "{\"action\": \"" + "split" + "\",\"tickersymbol\": \"" + split.getTickerSymbol()
			+ "\", \"price\": \"" + split.getRatioA() + ":" + split.getRatioB() + "\"}";
			jstring = jstring.concat(",");
		}

		List<Bonus> bList = (new CorporateActionDAOImpl()).getBonusCorporateActions();
		Iterator<Bonus> itrb = bList.listIterator();
		Bonus b = null;
		for (Bonus bonus : bList) {
			b = bonus;
			jstring += "{\"action\": \"" + "bonus" + "\",\"tickersymbol\": \"" + bonus.getTickerSymbol()
			+ "\", \"price\": \"" + bonus.getRatioA() + ":" + bonus.getRatioB() + "\"}";
			jstring = jstring.concat(",");
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
