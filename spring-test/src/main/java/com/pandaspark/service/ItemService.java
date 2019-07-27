package com.pandaspark.service;

import java.util.List;

import com.pandaspark.model.Item;
import com.pandaspark.model.ItemHist;

public interface ItemService {
	List<Item> getAllItems();
	Item save(Item item);
	Boolean delete(Item item);
	
	//
	// Audit: https://thoughts-on-java.org/hibernate-envers-query-data-audit-log/
	
	//
	// Vertical query
	List<Item> getItemHistory(Item item);
	
	//
	// Vertical query
	List<ItemHist> getItemHistory2(Item item);

	//
	// Horizontal query
	List<Item> getHistoryAtRevision(String code, int revision);
}
