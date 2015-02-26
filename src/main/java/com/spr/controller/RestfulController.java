package com.spr.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spr.model.Shop;

@RestController
public class RestfulController {
	
	@RequestMapping(value="rest", method=RequestMethod.GET)
	public Shop restful() {
		//@RequestBody String paramsJson, HttpServletResponse resp
		//resp.addHeader("Access-Control-Allow-Origin", "*"); 
		Shop shop = new Shop();
		shop.setName("sample");
		shop.setEmplNumber(34);
		return shop;
	}
	
	@RequestMapping(value="/createStore", method=RequestMethod.POST)
	public String createNewShop(@RequestBody Shop shop) {
		System.out.println("Shop name is ::: "+shop.getName());
		return "success";		
	}
}
