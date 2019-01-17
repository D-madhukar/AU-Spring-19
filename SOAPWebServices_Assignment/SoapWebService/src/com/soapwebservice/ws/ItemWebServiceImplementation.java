/**
 * 
 */
package com.soapwebservice.ws;

import java.util.List;

import javax.jws.WebService;

import com.soapwebservice.model.Item;
import com.soapwebservice.model.Utility;

/**
 * @author Madhukar
 *
 */
@WebService(endpointInterface = "com.soapwebservice.ws.ItemWebService")
public class ItemWebServiceImplementation implements ItemWebService {
	public Utility items;
	public ItemWebServiceImplementation (){
		this.items=new Utility();
		this.items.initialize();
	}
	@Override
	public String getItems() {
		// TODO Auto-generated method stub
		return this.items.getItems().toString();
	}
	@Override
	public String getItem(int id) {
		// TODO Auto-generated method stub
		return this.items.getItem(id).toString();
	}
	@Override
	public void insertItem(int id,String name,int price) {
		// TODO Auto-generated method stub
		this.items.insertItem(id,name,price);
	}
	@Override
	public void deleteItem(int id) {
		// TODO Auto-generated method stub
		this.items.deleteItem(id);
	}
	@Override
	public void updateItem(int id,String name,int price) {
		this.items.insertItem(id,name,price);
	}

}
