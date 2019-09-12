package com.rest;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Servlet implementation class TraderServlet
 */
@WebServlet("/TraderServlet")
public class TraderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String username;
	String password;
	String loginFlag; // ADMIN TRADER INVALID

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TraderServlet() {
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
		System.out.println("\nWelcome to doPost ");

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

		// retrieve username password
		username = json.get("username").toString();
		password = json.get("password").toString();

		// check Login Credentials : true/false
		loginFlag = "INVALID";
		System.out.println(loginFlag);

		// Send JSON Object to angular i.e. send "RESPONSE" to Angular and angular
		// receives it
		response.setContentType("application/json");
		response.setHeader("Access-Control-Allow-Origin", "*");
		String responseString = "{\"loginFlag\":\"" + loginFlag + "\"}";
		System.out.println(loginFlag);
		response.getWriter().write(responseString);

	}

}
