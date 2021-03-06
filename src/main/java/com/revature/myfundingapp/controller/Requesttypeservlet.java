package com.revature.myfundingapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.revature.myfundingapp.model.Request;
import com.revature.myfundingapp.service.RequestService;


public class Requesttypeservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Requesttypeservlet() {
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestService appdao = new RequestService();
		List<Request> req = new ArrayList<Request>();
		String fundType = request.getParameter("Fund_type");
	    req = appdao.FundType(fundType);
		Gson gson = new Gson();
		String json = gson.toJson(req);
	    PrintWriter out = response.getWriter();
		out.write(json);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	}

	
	