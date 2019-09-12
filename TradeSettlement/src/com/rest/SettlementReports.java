package com.rest;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ObjectsCreation;
import com.dao.ReportDAOImpl;
import com.pojos.Equity;
import com.pojos.Report;
import com.session.SessionDetails;

/**
 * Servlet implementation class SettlementReports
 */
@WebServlet("/SettlementReports")
public class SettlementReports extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SettlementReports() {
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
		System.out.println("Settlement Report");

		// Change the hardcoded value here
		Report report = (new ReportDAOImpl()).getEquityShortage(SessionDetails.getTID());
		String jstring = new String("");
		jstring = jstring.concat("[");

		jstring += "{\"Apple\": \"" + report.getAapl() + "\", \"Amazon\": \""
				+ report.getAmzn() + "\", \"Google\": \"" + report.getGoog() + "\", \"Microsoft\": \"" + report.getMsft() + "\", \"Facebook\": \""+ report.getFb() +"\" }";

		jstring = jstring.concat("]");

		System.out.println(jstring);
		// System.out.println("JSON STRING : \n" + JSONString);
		response.getWriter().write(jstring);	}

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
