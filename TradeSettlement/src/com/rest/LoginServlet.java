package com.rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.dao.LoginDAO;
import com.session.SessionDetails;

/**
 * Servlet implementation class MServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	String username;
	String password;
	String loginFlag;		//ADMIN TRADER INVALID
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		System.out.println("Welcome to doGet ");
//		// URL on which service is mapped
//		StringBuffer url = request.getRequestURL();
//		System.out.println("\nURL : " + url);
//
//		// Send JSON Object to angular i.e. send "RESPONSE" to Angular and angular
//		// receives it
//		response.setContentType("application/json");
//		response.setHeader("Access-Control-Allow-Origin", "*");
//		String responseString = "{\"loginFlag\":\"" + loginFlag + "\"}";
//		System.out.println(loginFlag);
//		response.getWriter().write(responseString);
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
		
		SessionDetails.setTID(username);
		SessionDetails.setTPASS(password);

		// check Login Credentials : true/false
		loginFlag = (new LoginDAO()).checkUserCreds(username, password);
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
// {"admin":"admin"}
//{"traderid":"traderid","tickersymbol":"app","buyer":"buyer","seller":"seller","quantity":"quantity","price":"price","status":"status"}
//https://alligator.io/js/json-parse-stringify/