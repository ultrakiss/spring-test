package com.pandaspark.model;

import java.util.Date;

import org.hibernate.envers.RevisionType;

public class ItemHist extends Item {
	RevisionType rt;
	
	private int revId;
	private Date revDate;
	private long revTimestamp;
	
	
	public ItemHist() {}
	public ItemHist(Item item) {
		super(item);
	}
	
	public RevisionType getRt() {
		return rt;
	}
	public void setRt(RevisionType rt) {
		this.rt = rt;
	}
	public int getRevId() {
		return revId;
	}
	public void setRevId(int revId) {
		this.revId = revId;
	}
	public Date getRevDate() {
		return revDate;
	}
	public void setRevDate(Date revDate) {
		this.revDate = revDate;
	}
	public long getRevTimestamp() {
		return revTimestamp;
	}
	public void setRevTimestamp(long revTimestamp) {
		this.revTimestamp = revTimestamp;
	}



}
