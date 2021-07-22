package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.business.ItemBusinessService;
import com.example.demo.model.Item;

@RestController
public class ItemController {

	@Autowired
	private ItemBusinessService businessService;

	@GetMapping("/dummy-item")
	public Item dummyItem() {
		return new Item(1, "Ball", 10, 100);
	}

	@GetMapping("/item-from-business-service")
	public Item itemFromBusinessService() {
		Item item = businessService.retreiveHardcodedItem();

		return item;
	}

	@GetMapping("/all-items-from-database")
	public List<Item> retrieveAllItems() {
		return businessService.retrieveAllItems();
	}
	
	@GetMapping("/insert-items")
	public List<Item> insertItems(){
		// insert into item(id, name, price, quantity) values(10001,'Item1',10,20);
		// insert into item(id, name, price, quantity) values(10002,'Item2',5,10);
		// insert into item(id, name, price, quantity) values(10003,'Item3',15,2);
		List<Item> items = Arrays.asList(new Item(10001,"Item1",10,20), new Item(10002,"Item2",5,10), new Item(10003,"Item3",15,2));
		businessService.insertItems(items);
		return items;
	}

}
