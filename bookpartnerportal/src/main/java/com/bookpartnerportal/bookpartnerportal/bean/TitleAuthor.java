package com.bookpartnerportal.bookpartnerportal.bean;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "titleauthor")
public class TitleAuthor {
 
   
    @Id
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "au_id", referencedColumnName = "au_id")
    private Author author;
    @Id
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "title_id", referencedColumnName = "title_id")
    private Titles title;
    @Column(name="au_ord")
    private byte auOrd;
    @Column(name="royaltyper")
    private Integer royalTyper;
 
    public TitleAuthor() {
    }
    

	public TitleAuthor(Author author, Titles title, byte auOrd, Integer royalTyper) {
		super();
		this.author = author;
		this.title = title;
		this.auOrd = auOrd;
		this.royalTyper = royalTyper;
	}


	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Titles getTitle() {
		return title;
	}

	public void setTitle(Titles title) {
		this.title = title;
	}


	public byte getAuOrd() {
		return auOrd;
	}


	public void setAuOrd(byte auOrd) {
		this.auOrd = auOrd;
	}


	public Integer getRoyalTyper() {
		return royalTyper;
	}


	public void setRoyalTyper(Integer royalTyper) {
		this.royalTyper = royalTyper;
	}

}