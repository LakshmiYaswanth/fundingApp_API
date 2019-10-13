package com.revature.myfundingapp.controllerrs;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.revature.myfundingapp.exceptions.ServiceException;
import com.revature.myfundingapp.model.Request;
import com.revature.myfundingapp.service.RequestService;


public class RequestTypeController {
	public String fundlist(String fundType) throws ServiceException {
		RequestService service = new RequestService();
		 List<Request> request1=new ArrayList<Request>();
		request1 = service.FundType(fundType);
		String json=null;
		Gson gson = new Gson();
		json = gson.toJson(request1);
		return json;
	}
	public static void main(String args[]) throws ServiceException {
		RequestTypeController obj = new RequestTypeController();
		String json = obj.fundlist("food");
	    System.out.println(json);
	}
}
	

	

	
	
	

