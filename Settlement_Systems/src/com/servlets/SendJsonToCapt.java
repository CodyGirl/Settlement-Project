package com.servlets;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SendJsonToCapt", urlPatterns = "/sendjson")
public class SendJsonToCapt extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		PrintWriter out = resp.getWriter();
		out = resp.getWriter();
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");

		if(username.equals("admin") && password.equals("admin")) {
			
			out.print("{user:'admin'}");
			out.flush();
		}
		else {
			out.print("{user:'false'}");
			out.flush();
		}
		
	}
}
