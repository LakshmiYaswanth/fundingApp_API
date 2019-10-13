package com.revature.myfundingapp.controllerrs;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.revature.myfundingapp.exceptions.ServiceException;
import com.revature.myfundingapp.model.Donor;
import com.revature.myfundingapp.service.DonorService;

public class DonorloginController {
	public String donorLogin(String name,String password) {
		DonorService service = new DonorService();
		Donor donorObj = null;
		String errorMsg = null;
		try {
			donorObj = service.login(name,password);
		} catch (ServiceException e) {
			errorMsg = e.getMessage();
		}
		String json = null;
		Gson gson = new Gson();

		if (donorObj != null) {
			json = gson.toJson(donorObj);
		} else {
			JsonObject jsonObj = new JsonObject();
			jsonObj.addProperty("errorMessage", errorMsg);
			json = jsonObj.toString();
		}
		return json;
	}

}
