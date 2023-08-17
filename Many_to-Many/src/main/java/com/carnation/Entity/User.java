package com.carnation.Entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class User {
	
	@Id
	private int userId;
	private String name;
	private String address;
	
	@ManyToMany
	@JoinTable
	private List<Documents> Documents;
	
	
	
	public List<Documents> getDocuments() {
		return Documents;
	}
	public void setDocuments(List<Documents> documents) {
		this.Documents = documents;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", address=" + address + ", Documents=" + Documents + "]";
	}
	
	
	
	
}
