package com.revature.myfundingapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.revature.myfundingapp.exceptions.DBExeception;
import com.revature.myfundingapp.exceptions.ServiceException;
import com.revature.myfundingapp.model.Donor;
import com.revature.myfundingapp.service.DonorloginService;

/**
 * Servlet implementation class Donorloginservlet
 */
public class Donorloginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Donorloginservlet() {
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DonorloginService service = new DonorloginService();
		Donor donor = new Donor();
		Donor donorObj = new Donor();
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		donor.setName(name);
		donor.setPassword(password);
		try {
			donorObj = service.login(name,password);
		} catch (DBExeception e) {
			e.printStackTrace();
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		Gson gson = new Gson();
		String json = gson.toJson(donorObj);
		PrintWriter out = response.getWriter();
		out.write(json);
	}

}
