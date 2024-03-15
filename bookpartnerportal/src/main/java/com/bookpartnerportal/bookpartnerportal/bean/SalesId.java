package com.bookpartnerportal.bookpartnerportal.bean;

import java.io.Serializable;

public class SalesId implements Serializable{
	private Stores store;
	private Titles title;
	private String ordNum;
	public SalesId(Stores store, Titles title, String ordNum) {
		super();
		this.store = store;
		this.title = title;
		this.ordNum = ordNum;
	}
	public SalesId() {
		super();
	}
	public Stores getStore() {
		return store;
	}
	public void setStore(Stores store) {
		this.store = store;
	}
	public Titles getTitle() {
		return title;
	}
	public void setTitle(Titles title) {
		this.title = title;
	}
	public String getOrdNum() {
		return ordNum;
	}
	public void setOrdNum(String ordNum) {
		this.ordNum = ordNum;
	}
	
}
