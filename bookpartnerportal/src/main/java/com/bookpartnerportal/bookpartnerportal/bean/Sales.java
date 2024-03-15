package com.bookpartnerportal.bookpartnerportal.bean;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@IdClass(SalesId.class)
@Table(name="sales")
public class Sales {
	@Id
	@ManyToOne(cascade=CascadeType.ALL)
	@OnDelete(action=OnDeleteAction.CASCADE)
    @JoinColumn(name = "stor_id", referencedColumnName = "stor_id")
	private Stores store;
	@Id
	@ManyToOne(cascade=CascadeType.ALL)
	//@OnDelete(action=OnDeleteAction.CASCADE)
    @JoinColumn(name = "title_id", referencedColumnName = "title_id")
    private Titles title;
	
	@Id
    @Column(name="ord_num",nullable=false,columnDefinition="varchar(20)")
	private String ordNum;
    
    @Column(name="ord_date",nullable=false,columnDefinition="TIMESTAMP")
	private LocalDateTime ordDate;
    
	@Column(nullable=false)
	private short qty;
    @Column(name="payterms",nullable=false,columnDefinition="varchar(12)")
	private String payTerms; 
    
	public Sales() {
		
	}

	public Sales(Stores store, Titles title, String ordNum, LocalDateTime ordDate, short qty, String payTerms) {
		super();
		this.store = store;
		this.title = title;
		this.ordNum = ordNum;
		this.ordDate = ordDate;
		this.qty = qty;
		this.payTerms = payTerms;
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

	public LocalDateTime getOrdDate() {
		return ordDate;
	}

	public void setOrdDate(LocalDateTime ordDate) {
		this.ordDate = ordDate;
	}

	public short getQty() {
		return qty;
	}

	public void setQty(short qty) {
		this.qty = qty;
	}

	public String getPayTerms() {
		return payTerms;
	}

	public void setPayTerms(String payTerms) {
		this.payTerms = payTerms;
	}
}
