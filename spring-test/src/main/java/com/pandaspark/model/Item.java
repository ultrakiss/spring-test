package com.pandaspark.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

@Entity
@Table(name="Item", schema="Test0")
@Audited
@AuditTable(schema="Audit", value = "Item_Aud")
public class Item implements Serializable {
	@Column(name="Id", nullable=false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;
	
	@Column(name="code", length=10)
	private String code;
	
	@Column(name="description", length=50)
	private String description;
	
	@Column(name="version", nullable=false)
	@Version
	private int version;
	
	@Column(name="modified")
	private LocalDateTime modified;
	
	@Column(name="modifiedby", length=10)
	private String modifiedby;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public LocalDateTime getModified() {
		return modified;
	}

	public void setModified(LocalDateTime modified) {
		this.modified = modified;
	}

	public String getModifiedby() {
		return modifiedby;
	}

	public void setModifiedby(String modifiedby) {
		this.modifiedby = modifiedby;
	}

	
}
