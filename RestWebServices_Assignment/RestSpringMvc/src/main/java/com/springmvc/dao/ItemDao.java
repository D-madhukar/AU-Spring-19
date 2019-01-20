package com.springmvc.dao;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.springmvc.model.Item;

@Repository
public class ItemDao {
	static Map<Integer,Item> itemsMap=new HashMap<Integer,Item>();
	static {
		initMap();
	}
	public static void initMap() {
		Item item1=new Item(1,"Dal",20);
		Item item2=new Item(2,"fry",30);
		Item item3=new Item(3,"sambar",20);
		Item item4=new Item(4,"curd",15);
		Item item5=new Item(5,"curry",25);
		
		itemsMap.put(item1.getId(),item1);
		itemsMap.put(item2.getId(),item2);
		itemsMap.put(item3.getId(),item3);
		itemsMap.put(item4.getId(),item4);
		itemsMap.put(item5.getId(),item5);
	}
	public Item getItem(int id) {
        return itemsMap.get(id);
    }
 
    public Item addItem(Item item) {
        itemsMap.put(item.getId(), item);
        return item;
    }
 
    public Item updateItem(Item item) {
        itemsMap.put(item.getId(), item);
        return item;
    }
 
    public void deleteItem(int id) {
        itemsMap.remove(id);
    }
 
    public List<Item> getAllItems() {
        Collection<Item> c = itemsMap.values();
        List<Item> list = new ArrayList<Item>();
        list.addAll(c);
        return list;
    }
	
	
}
