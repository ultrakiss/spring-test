package com.pandaspark.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.hibernate.envers.DefaultRevisionEntity;
import org.hibernate.envers.RevisionType;
import org.hibernate.envers.query.AuditEntity;
import org.hibernate.envers.query.AuditQuery;
import org.springframework.stereotype.Service;

import com.pandaspark.model.Item;
import com.pandaspark.model.ItemHist;
import com.pandaspark.repository.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService {
	private ItemRepository itemRepo;
	
	@PersistenceContext
	private EntityManager em;
	
	private AuditReader auditReader;
	
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

	@Override
	public List<Item> getItemHistory(Item item) {
		auditReader = AuditReaderFactory.get(em);
		AuditQuery aq = auditReader.createQuery().forRevisionsOfEntity(Item.class, true, true);
		aq.add(AuditEntity.id().eq(item.getId()));
		List<Item> res = aq.getResultList();
		
		return res;
	}

	@Override
	public List<ItemHist> getItemHistory2(Item item) {
		auditReader = AuditReaderFactory.get(em);
		AuditQuery aq = auditReader.createQuery().forRevisionsOfEntity(Item.class, false, true);
		aq.add(AuditEntity.id().eq(item.getId()));
		List<Object[]> resx = aq.getResultList();
		//[0]Item,[1]DefaultRevisionEntity,[2]RevisionType
		List<ItemHist> res = resx.stream().map(f -> {
			Item i = (Item)f[0];
			DefaultRevisionEntity dre = (DefaultRevisionEntity)f[1];
			RevisionType rt = (RevisionType)f[2];
			
			ItemHist ih = new ItemHist(i);
			ih.setRevDate(dre.getRevisionDate());
			ih.setRevTimestamp(dre.getTimestamp());
			ih.setRevId(dre.getId());
			
			ih.setRt((RevisionType)f[2]);
			
			return ih;
		}).collect(Collectors.toList());
		
		
		
		return res;
	}

	@Override
	public List<Item> getHistoryAtRevision(String code, int revision) {
		auditReader = AuditReaderFactory.get(em);
		AuditQuery aq = auditReader.createQuery().forEntitiesAtRevision(Item.class, revision);
		aq.add(AuditEntity.property("code").eq(code));
		aq.addOrder(AuditEntity.property("code").asc());
		List<Item> res = aq.getResultList();
		
		return res;
	}

}
