package com.revature.myfundingapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.revature.myfundingapp.exceptions.ServiceException;
import com.revature.myfundingapp.model.Request;
import com.revature.myfundingapp.service.RequestService;

/**
 * Servlet implementation class Requestupdateservlet
 */
public class Requestupdateservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestService Service = new RequestService();
		int rows = 0;
		Request req = new Request();
		String fundType = request.getParameter("fundType");
		String targetAmount = request.getParameter("amount");
		Integer amount = Integer.parseInt(targetAmount);
		String expireDate = request.getParameter("date");
		LocalDate date = LocalDate.parse(expireDate);
		String RequestId = request.getParameter("requestId");
		Integer id=Integer.parseInt(RequestId);
		req.setFundType(fundType);
		req.setAmount(amount);
		req.setExpireDate(date);
		req.setRequestId(id);
		try {
			rows = Service.RequestUpdate(req);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		System.out.println(rows);
		Gson gson = new Gson();
		String json = gson.toJson(rows);
		PrintWriter out = response.getWriter();
		out.write(json);
	}
}
