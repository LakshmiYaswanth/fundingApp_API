package com.revature.myfundingapp.controllerrs;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.revature.myfundingapp.exceptions.ServiceException;
import com.revature.myfundingapp.model.Donor;
import com.revature.myfundingapp.service.DonorService;

public class DonorlistController {
	public String listDonor()
	{
		DonorService service = new DonorService();
		List<Donor> donorList = null;
		String errorMessage = null;
		try {
			donorList=new ArrayList<Donor>();
			donorList = service.list();
		} catch (ServiceException e) {
			errorMessage = e.getMessage();
		}
		String json = null;
		Gson gson = new Gson();
		if(errorMessage != null)
		{
			json = errorMessage;
		} else {
			json = gson.toJson(donorList);
		}
		return json;
	}

}
