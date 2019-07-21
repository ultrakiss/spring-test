package com.pandaspark.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pandaspark.model.Item;
import com.pandaspark.service.ItemService;

@RestController
public class ItemController {
	private ItemService service;
	
	public ItemController(ItemService service) {
		this.service = service;
	}
	
	/**
	 * Get the table information
	 * CURL:
	 *			curl --request GET --url http://localhost:8080/get
	 * @return
	 */
	@GetMapping("/get")
	public ResponseEntity<List<Item>> get() {
		List<Item> res = service.getAllItems();
		
		return new ResponseEntity<>(res, HttpStatus.OK);
	}
	
	/**
	 * Insert or Update the data
	 * CURL:
	 * 		curl --request PUT --url http://localhost:8080/put --header 'Content-Type: application/json' \
  --data '{"code": "codeA", "description": "descriptionA"}'
	 * @param item
	 * @return
	 */
	@PutMapping("/put")
	public ResponseEntity<Item> save(@RequestBody Item item) {
		Item res = service.save(item);
		
		return new ResponseEntity<>(res, HttpStatus.OK);
	}
	
	/**
	 * Delete the data
	 * CURL:
	 * 		curl --request DELETE --url http://localhost:8080/delete --header 'Content-Type: application/json' \
  --data '{"id": 2, "code": "codeBxx", "description": "descriptionBxx", "version": 1, "modified": "2019-07-19T17:39:58.07261", "modifiedby": "sa"}'
	 * @param item
	 * @return
	 */
	@DeleteMapping("/delete")
	public ResponseEntity<Boolean> delete(@RequestBody Item item) {
		Boolean res = service.delete(item);
		
		return new ResponseEntity<>(res, HttpStatus.OK);
	}
}
