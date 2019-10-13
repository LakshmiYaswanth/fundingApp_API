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
import com.revature.myfundingapp.exceptions.DBExeception;
import com.revature.myfundingapp.model.Donor;
import com.revature.myfundingapp.service.DonorService;



/**
 * Servlet implementation class DonorFundingList
 */
public class DonorFundingList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DonorFundingList() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DonorService appdao = new DonorService();
		List<Donor> req = new ArrayList<Donor>();
		String name = request.getParameter("name");
	    try {
			req = appdao.fundingList(name);
		} catch (DBExeception e) {
			e.printStackTrace();
		}
		Gson gson = new Gson();
		String json = gson.toJson(req);
	    PrintWriter out = response.getWriter();
		out.write(json);
	}
	}

	

