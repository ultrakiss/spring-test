package com.pandaspark.service;

import java.util.List;

import com.pandaspark.model.Item;

public interface ItemService {
	List<Item> getAllItems();
	Item save(Item item);
	Boolean delete(Item item);
}
