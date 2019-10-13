package com.revature.myfundingapp.controllerrs;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.revature.myfundingapp.exceptions.ServiceException;
import com.revature.myfundingapp.model.Admin;
import com.revature.myfundingapp.service.AdminService;


public class AdminLoginController {
	public String adminLogin(String name,String password) {
		String errorMsg = null;
		AdminService service = new AdminService();
		Admin adminObj = null;
		try {
			adminObj = service.login(name,password);
		} catch (ServiceException e) {
			errorMsg = e.getMessage();
		}
		String json = null;
		Gson gson = new Gson();
		if (adminObj != null) {
			json = gson.toJson(adminObj);
		} else {
			JsonObject jsonObj = new JsonObject();
			jsonObj.addProperty("errorMessage", errorMsg);
			json = jsonObj.toString();
		}
		return json;
	}
}
