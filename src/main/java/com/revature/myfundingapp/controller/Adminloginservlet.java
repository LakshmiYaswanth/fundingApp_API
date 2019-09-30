package com.revature.myfundingapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.revature.myfundingapp.exceptions.ServiceException;
import com.revature.myfundingapp.model.Admin;
import com.revature.myfundingapp.service.Adminloginservice;

public class Adminloginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Adminloginservlet() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  Adminloginservice service= new Adminloginservice();
			Admin admin = new Admin();
			Admin AdminObj = new Admin();
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			admin.setName(name);
			admin.setPassword(password);
			try {
				AdminObj = service.login(name,password);
			} catch (ServiceException e) {
				e.printStackTrace();
			}
			Gson gson = new Gson();
			String json = gson.toJson(AdminObj);
			PrintWriter out = response.getWriter();
			out.write(json);
		}
}
