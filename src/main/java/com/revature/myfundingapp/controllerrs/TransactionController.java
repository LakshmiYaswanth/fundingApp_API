package com.revature.myfundingapp.controllerrs;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.revature.myfundingapp.daoimpl.TransactionDAOImpl;
import com.revature.myfundingapp.exceptions.ServiceException;
import com.revature.myfundingapp.model.Transaction;
import com.revature.myfundingapp.service.TransactionService;

public class TransactionController {
	public String transaction(Transaction transaction)
	{
		TransactionService trans = new TransactionService();
		int rows = 0;
			String error = null;
			try {
				rows = trans.insertservice(transaction);
			} catch (ServiceException e) {
				error = e.getMessage();
			}
			String json = null;
			Gson gson = new Gson();

			if (rows != 0) {
				json = gson.toJson(rows);
			} else {
				JsonObject jsonObj = new JsonObject();
				jsonObj.addProperty("errorMessage", error);
				json = jsonObj.toString();
			}
			return json;

	}
}
