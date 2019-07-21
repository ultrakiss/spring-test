package com.pandaspark;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pandaspark.model.Item;
import com.pandaspark.repository.ItemRepository;

// @RunWith(SpringRunner.class)
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SpringTestApplicationTests {
	@Autowired
	private ItemRepository repo;
	
//	@Test
//	public void contextLoads() {
//	}

	@Test
	public void repoTest() {
		List<Item> allItems = repo.findAll();
		
		System.out.println("Count:" + allItems.size());
	}
}
