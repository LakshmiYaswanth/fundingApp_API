package com.revature.myfundingapp.controllerrs;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.revature.myfundingapp.exceptions.ServiceException;
import com.revature.myfundingapp.model.Request;
import com.revature.myfundingapp.service.RequestService;

public class Requestlist {
	public String list() {
		RequestService service = new RequestService();
		List<Request> request1 = null;
		try {
			request1=new ArrayList<Request>();
			request1 = service.list();
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		String json=null;
		Gson gson = new Gson();
		json = gson.toJson(request1);
		return json;
	}
	
	}

