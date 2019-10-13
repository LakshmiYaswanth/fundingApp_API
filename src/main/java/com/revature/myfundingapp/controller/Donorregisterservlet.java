package com.revature.myfundingapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.revature.myfundingapp.exceptions.ServiceException;
import com.revature.myfundingapp.model.Donor;
import com.revature.myfundingapp.service.DonorService;


/**
 * Servlet implementation class Donorregisterservlet
 */
public class Donorregisterservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Donorregisterservlet() {
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DonorService service = new DonorService();
		String name = request.getParameter("name");
		String email =request.getParameter("email");
		String password =request.getParameter("password");
		String s = request.getParameter("Age");
	    Integer Age = Integer.parseInt(s);
		Donor donor = new Donor();
		donor.setName(name);
		donor.setEmail(email);
		donor.setPassword(password);
		donor.setAge(Age);
		Gson gson = new Gson();
		int rows=0;
		try {
			rows = service.donorInsert(donor);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		String json = gson.toJson(rows);
		PrintWriter out = response.getWriter();
		out.write(json);
	}
	}

	