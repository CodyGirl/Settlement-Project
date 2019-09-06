package com.servlets;


import com.dao.*;
import java.util.List;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet({ "/AdminLoginServlet", "/adminlogin" })
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String adminId=request.getParameter("adminId");
		String adminPassword=request.getParameter("adminPassword");
		System.out.println("Hello:" + adminId);

		AdminDAO admindao=new AdminDAO();
		String  adminname=admindao.doAdminLogin(adminId, adminPassword);
		System.out.println("Hello:"+ adminname);
		
		
		if (name.equals("no user")) {
			request.setAttribute("msg", "sorry wrong creds");
			RequestDispatcher d = request.getRequestDispatcher("login.jsp");
			d.forward(request, response);

		} else {
			String query = "select * from login where username = ?";
			PreparedStatement ps;
			System.out.println("Login failed 1 ************");

			try {
				ps = MyStudentDAOImpl.openConnection().prepareStatement(query);
				ps.setString(1, name);
				ResultSet set = ps.executeQuery();
				System.out.println("set : "+set);
				while(set.next()) {
					name=set.getString(1);
				}
				if (set.next()==false) {
					System.out.println("Login failed 2 ************");
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			HttpSession httpsession = request.getSession();
			System.out.println(httpsession.getId() + ":" + httpsession.getCreationTime());
			httpsession.setAttribute("username", name);

			StudentDAO studentdao = new MyStudentDAOImpl();
			List<Student> list = studentdao.findAllStudents();

			request.setAttribute("students", list);
			RequestDispatcher d = request.getRequestDispatcher("display.jsp");
			d.forward(request, response);

		}

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
