package com.soapwebservice.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.soapwebservice.model.Item;

@WebService
public interface ItemWebService {
	
	@WebMethod
	String getItems();
	@WebMethod
	String getItem(int id);
	@WebMethod
	void insertItem(int id,String name,int price);
	@WebMethod
	void deleteItem(int id);
	@WebMethod
	void updateItem(int id,String name,int price);
	
		
}
