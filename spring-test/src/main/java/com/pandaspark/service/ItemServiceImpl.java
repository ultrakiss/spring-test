package com.pandaspark.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pandaspark.model.Item;
import com.pandaspark.repository.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService {
	private ItemRepository itemRepo;
	
	public ItemServiceImpl(ItemRepository itemRepo) {
		this.itemRepo = itemRepo;
	}
	
	@Override
	public List<Item> getAllItems() {
		List<Item> list = itemRepo.findAll();
		
		return list;
	}

	@Override
	public Item save(Item item) {
		item.setModifiedby("sa");
		item.setModified(LocalDateTime.now());
		Item res = itemRepo.save(item);
		
		return res;
	}

	@Override
	public Boolean delete(Item item) {
		item.setModifiedby("sa");
		item.setModified(LocalDateTime.now());
		itemRepo.delete(item);
		
		return Boolean.TRUE;
	}

}
