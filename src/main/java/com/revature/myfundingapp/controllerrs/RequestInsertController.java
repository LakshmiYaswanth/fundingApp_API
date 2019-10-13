package com.revature.myfundingapp.controllerrs;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.revature.myfundingapp.exceptions.ServiceException;
import com.revature.myfundingapp.model.Request;
import com.revature.myfundingapp.service.RequestService;

public class RequestInsertController {
	public String insert(Request request) {
		RequestService service = new RequestService();
		int rows=0;
		try {
			rows = service.requestInsert(request);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		String json = null;
		Gson gson = new Gson();

		if (rows != 0) {
			json = gson.toJson(rows);
		} else {
			JsonObject jsonObj = new JsonObject();
			jsonObj.addProperty("errorMessage", rows);
			json = jsonObj.toString();
		}
		return json;
		
	}

}
