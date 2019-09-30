package com.revature.myfundingapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.revature.myfundingapp.daoimpl.TransactionDAOImpl;
import com.revature.myfundingapp.exceptions.DBExeception;
import com.revature.myfundingapp.model.Transaction;

/**
 * Servlet implementation class Transactionservlet
 */
public class Transactionservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
    public Transactionservlet() {

    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		TransactionDAOImpl transaction = new TransactionDAOImpl();
		Transaction trans = new Transaction();
		int Isinserted = 0;
		try {
			String s = request.getParameter("amountfunded");
		    Integer AmountFunded = Integer.parseInt(s);
		    String t = request.getParameter("request_Id");
		    Integer Id = Integer.parseInt(t);
		    String u = request.getParameter("donor_Id");
		    Integer donor_Id = Integer.parseInt(u);
		    trans.setRequestId(Id);
		    trans.setAmountfunded(AmountFunded);
		    trans.setDonorId(donor_Id);
		    Isinserted = transaction.insert(trans);
			} catch (DBExeception e) {
				e.printStackTrace();
			}
		    Gson gson = new Gson();
		    String json = gson.toJson(Isinserted);
		    PrintWriter out = response.getWriter();
		    out.write(json);
	}}
