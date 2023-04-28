package com.service.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.service.spring.domain.Item;

public interface ItemCatalog {
	
	
	
	List<Item> getItemList() throws Exception;
	Item getItem(int itemId) throws Exception;
}
