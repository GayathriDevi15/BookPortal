package com.bookpartnerportal.bookpartnerportal.bean;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="authors")
public class Author {
	@Id
    @Column(name="au_id",columnDefinition="char(11)")
	private String auId;
    @Column(name="au_lname",nullable=false,columnDefinition="varchar(40)")
	private String auLname;
    @Column(name="au_fname",nullable=false,columnDefinition="varchar(20)")
	private String auFname;
    @Column(nullable=false,columnDefinition = "char(12) default 'UNKNOWN'")
	private String phone;
    @Column(columnDefinition="varchar(40)")
	private String address;
    @Column(columnDefinition="varchar(20)")
	private String city;
    @Column(columnDefinition = "char(2)")
	private String state;
    @Column(columnDefinition = "char(5)")
	private String zip;
    @Column(nullable=false,columnDefinition = "int")
    private int contract;
    
	
	public Author(String auId, String auLname, String auFname, String phone, String address, String city, String state,
			String zip, int contract) {
		
		this.auId = auId;
		this.auLname = auLname;
		this.auFname = auFname;
		this.phone = phone;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.contract = contract;
	}
	
	public String getAuId() {
		return auId;
	}

	public void setAuId(String auId) {
		this.auId = auId;
	}

	public String getAuLname() {
		return auLname;
	}

	public void setAuLname(String auLname) {
		this.auLname = auLname;
	}

	public String getAuFname() {
		return auFname;
	}

	public void setAuFname(String auFname) {
		this.auFname = auFname;
	}

	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	public int getContract() {
		return contract;
	}
	public void setContract(int contract) {
		this.contract = contract;
	}
	public Author() {

	}

}
