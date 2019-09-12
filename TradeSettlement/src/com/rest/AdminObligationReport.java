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
import com.dao.ReportDAOImpl;
import com.pojos.Report;
import com.pojos.Trade;

/**
 * Servlet implementation class AdminObligationReport
 */
@WebServlet("/AdminObligationReport")
public class AdminObligationReport extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminObligationReport() {
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
		System.out.println("In admin Obli");
		List<Report> tList = (new ReportDAOImpl()).getObligationReport();
		String jstring = new String("[ ");

		Iterator<Report> itr = tList.listIterator();
		Report t = new Report();
		for (Report report : tList) {
			t = report;
//			System.out.println(t);
			jstring += "{\"traderId\": \"" + report.getTraderid() + "\",\"Apple\": \"" + report.getAapl() + "\", \"Amazon\": \""
					+ report.getAmzn() + "\", \"Google\": \"" + report.getGoog() + "\", \"Microsoft\": \"" + report.getMsft() + "\", \"Facebook\": \""+ report.getFb() +"\" }";

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
