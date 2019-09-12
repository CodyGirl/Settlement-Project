package com.dao;

public class LoginDAO {

	public String checkUserCreds(String myUsername, String myPassword) {
		AdminLoginDAO adminLogin = new AdminLoginDAO();
		TraderLoginDAO traderLogin = new TraderLoginDAO();

		String username = adminLogin.doAdminLogin(myUsername, myPassword);
		System.out.println(username);
		if (username == null) {	//Not Admin
			username = traderLogin.doTrdaerLogin(myUsername, myPassword);
			if (username == null)//nothing
				return "INVALID";
			else
				return "TRADER";
		}
		return "ADMIN";

	}

}
