/**
 * 
 */
package com.soapwebservice.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Madhukar
 *
 */
public class Utility {
	HashMap<Integer,Item> hm;
	List<Item> items;
	public Utility(){
		hm=new HashMap<>();
		items=new ArrayList<>();
	}
	public void initialize() {
		Item item1=new Item(1,"Dal",20);
		Item item2=new Item(2,"fry",30);
		Item item3=new Item(3,"sambar",20);
		Item item4=new Item(4,"curd",15);
		Item item5=new Item(5,"curry",25);
		
		hm.put(item1.getId(),item1);
		hm.put(item2.getId(),item2);
		hm.put(item3.getId(),item3);
		hm.put(item4.getId(),item4);
		hm.put(item5.getId(),item5);
	}
	
	public List<Item> getItems(){
		ArrayList<Item> items=new ArrayList<>();
		for(int i:hm.keySet()) {
			items.add(hm.get(i));
		}
		return items;
	
	}
	public Item getItem(int id) {
		Item item=null;
		if(hm.containsKey(id))
			item=hm.get(id);
		return item;
	}
	public void insertItem(int id,String name,int price) {
		Item item=new Item(id,name,price);
		if(!hm.containsKey(item.getId()))
			hm.put(item.getId(), item);
		items.add(item);
	}
	public void deleteItem(int id) {
		if(hm.containsKey(id)) {
			hm.remove(id);
		}
	}

}
