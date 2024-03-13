package com.bookpartnerportal.bookpartnerportal.bean;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="stores")
public class Stores {
	@Id
	@Column(name="stor_id",columnDefinition="char(4)")
	private String storId;
	@Column(name="stor_name",columnDefinition="varchar(40)")
	private String storName;
	@Column(name="stor_address",columnDefinition="varchar(40)")
	private String storAddress;
	@Column(columnDefinition="varchar(20)")
	private String city;
	@Column(columnDefinition="char(2)")
	private String state;
	@Column(columnDefinition="char(5)")
	private String zip;
	public Stores() {
	}
	public Stores(String storId, String storName, String storAddress, String city, String state, String zip) {
		this.storId = storId;
		this.storName = storName;
		this.storAddress = storAddress;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	public String getStorId() {
		return storId;
	}
	public void setStorId(String storId) {
		this.storId = storId;
	}
	public String getStorName() {
		return storName;
	}
	public void setStorName(String storName) {
		this.storName = storName;
	}
	public String getStorAddress() {
		return storAddress;
	}
	public void setStorAddress(String storAddress) {
		this.storAddress = storAddress;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
}