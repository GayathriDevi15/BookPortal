package com.bookpartnerportal.bookpartnerportal.bean;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="publishers")
public class Publisher {
	@Id
    @Column(name="pub_id",nullable=false,unique=true,columnDefinition = "char(4) ")
	private String pubId;
    @Column(name="pub_name",columnDefinition="varchar(40)")
	private String pubName;
    @Column(columnDefinition="varchar(20)")
	private String city;
    @Column(columnDefinition = "char(2)")
	private String state;
    @Column(columnDefinition="varchar(30) default 'USA'")
	private String country;
	
	
	public Publisher(String pubId, String pubName, String city, String state, String country) {
		
		this.pubId = pubId;
		this.pubName = pubName;
		this.city = city;
		this.state = state;
		this.country = country;
	}
	public String getPubId() {
		return pubId;
	}
	public void setPubId(String pubId) {
		this.pubId = pubId;
	}
	public String getPubName() {
		return pubName;
	}
	public void setPubName(String pubName) {
		this.pubName = pubName;
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
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Publisher() {
		
	}
}
