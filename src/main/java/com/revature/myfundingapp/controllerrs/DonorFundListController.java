package com.revature.myfundingapp.controllerrs;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.revature.myfundingapp.exceptions.DBExeception;
import com.revature.myfundingapp.model.Donor;
import com.revature.myfundingapp.service.DonorService;

public class DonorFundListController {
	DonorService service = new DonorService();
		public String fundlist(String name)  {
			List<Donor> list = new ArrayList<Donor>();
				try {
					list = service.fundingList(name);
				} catch (DBExeception e) {
					e.printStackTrace();
				}
			String json=null;
			Gson gson = new Gson();
			json = gson.toJson(list);
			return json;
		}
		public static void main(String args[]) {
			DonorFundListController obj = new DonorFundListController();
				String json = obj.fundlist("yaswanth");
		    System.out.println(json);
		}
	}
		
