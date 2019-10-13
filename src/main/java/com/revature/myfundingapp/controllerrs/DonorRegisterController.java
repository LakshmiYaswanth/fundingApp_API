package com.revature.myfundingapp.controllerrs;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.revature.myfundingapp.exceptions.ServiceException;
import com.revature.myfundingapp.model.Donor;
import com.revature.myfundingapp.service.DonorService;

public class DonorRegisterController {
	public String donorRegister(Donor donor) {
	
		DonorService service = new DonorService();
		int rows=0;
		try {
			rows = service.donorInsert(donor);
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
