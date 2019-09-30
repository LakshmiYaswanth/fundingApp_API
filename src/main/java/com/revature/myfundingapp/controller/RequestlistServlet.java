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
import com.revature.myfundingapp.exceptions.ServiceException;
import com.revature.myfundingapp.model.Request;
import com.revature.myfundingapp.service.RequestService;

/**
 * Servlet implementation class RequestlistServlet
 */
public class RequestlistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public RequestlistServlet() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestService service = new RequestService();
		List<Request> request1 = null;
		
		try {
			request1=new ArrayList<Request>();
			request1 = service.list();
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		Gson gson = new Gson();
		String json = gson.toJson(request1);
		PrintWriter out = response.getWriter();
		out.write(json);
	
	}

}
