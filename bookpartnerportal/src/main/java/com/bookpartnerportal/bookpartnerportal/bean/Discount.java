package com.bookpartnerportal.bookpartnerportal.bean;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name = "discounts")
public class Discount {
 
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
 
    @Column(name="discounttype",nullable=false,columnDefinition = "varchar(40)")
    private String discountType;
 
    @ManyToOne(cascade=CascadeType.ALL)
    @OnDelete(action=OnDeleteAction.CASCADE)
    @JoinColumn(name = "stor_id", referencedColumnName = "stor_id")
    private Stores store;
 
    @Column
    private short lowqty;
 
    @Column
    private short highqty;
 
    @Column(name = "discount", nullable = false, columnDefinition="DECIMAL(4,2)")
    private double discount;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public String getDiscountType() {
		return discountType;
	}

	public void setDiscountType(String discountType) {
		this.discountType = discountType;
	}

	public Discount(int id, String discountType, Stores store, short lowqty, short highqty, double discount) {
	
		this.id = id;
		this.discountType = discountType;
		this.store = store;
		this.lowqty = lowqty;
		this.highqty = highqty;
		this.discount = discount;
	}

	public Stores getStore() {
		return store;
	}

	public void setStore(Stores store) {
		this.store = store;
	}

	public short getLowqty() {
		return lowqty;
	}

	public void setLowqty(short lowqty) {
		this.lowqty = lowqty;
	}

	public short getHighqty() {
		return highqty;
	}

	public void setHighqty(short highqty) {
		this.highqty = highqty;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public Discount() {
		
	}
 
    
}