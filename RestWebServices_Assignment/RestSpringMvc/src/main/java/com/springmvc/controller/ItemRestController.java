package com.springmvc.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springmvc.dao.ItemDao;
import com.springmvc.model.Item;

@RestController
public class ItemRestController {
	@Autowired
	ItemDao itemDao;
	@RequestMapping("/hello")
	public  String getString() {
		return "hello";
	}
	@RequestMapping(value="/items",method=RequestMethod.GET,
	produces= {MediaType.APPLICATION_JSON_VALUE})
	public List<Item> getItems(){
		return itemDao.getAllItems();
	}
	@RequestMapping(value="/items/item/{id}", method=RequestMethod.GET,
	produces= {MediaType.APPLICATION_JSON_VALUE})
	public Item getItem(@PathVariable("id") String id) {
		return itemDao.getItem(Integer.parseInt(id));
	}
	@RequestMapping(value = "/items/delete/{id}", method = RequestMethod.GET,
    produces = { MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public void deleteItem(@PathVariable("id") String id) {
	 itemDao.deleteItem(Integer.parseInt(id));
	}
	@RequestMapping(value = "/items/update", method = RequestMethod.POST,
		    produces = { MediaType.APPLICATION_JSON_VALUE},
			consumes= { MediaType.APPLICATION_JSON_VALUE})
	public Item updateItem(@RequestBody Item item) {
		itemDao.updateItem(item);
		return item;
	}
		
}

