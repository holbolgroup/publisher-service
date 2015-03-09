package com.spr.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spr.model.Shop;
import com.spr.service.ShopService;

@RestController
@RequestMapping(value="/store")
public class StoreController {
	
	@Autowired
	private ShopService shopService;
	
	@RequestMapping(value="checkRestfullness", method=RequestMethod.GET)
	public Shop restful() {
		Shop shop = new Shop();
		shop.setName("sample");
		shop.setEmplNumber(34);
		return shop;
	}
	
	@RequestMapping(value="/createStore", method=RequestMethod.POST)
	public Shop createNewShop(@RequestBody Shop shop) {
		System.out.println("Shop name is ::: "+shop.getName());
		System.out.println("Shop name is ::: "+shop.getEmplNumber());
		Shop savedShop = shopService.create(shop);
		System.out.println("Shop id is ::: "+savedShop.getId());
		return savedShop;		
	}
	
	@RequestMapping(value="/load/{id}", method=RequestMethod.GET)
	public Shop load(@PathVariable Integer id) {
		Shop shop = shopService.findById(id);
		return shop;		
	}
}
