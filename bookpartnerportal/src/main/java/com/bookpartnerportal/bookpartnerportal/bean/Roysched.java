package com.bookpartnerportal.bookpartnerportal.bean;
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
@Table(name="roysched")
public class Roysched {
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   @Column(name="roysched_id")
   private int royschedId;
   @Column(name="lorange")
   private int loRange;
   @Column(name="hirange")
   private int hiRange;
   private int royalty;
   @ManyToOne(cascade=CascadeType.ALL)
   @JoinColumn(name="title_id",referencedColumnName="title_id")
   private Titles titles;
   
public Roysched(int royschedId, int loRange, int hiRange, int royalty, Titles titles) {
	
	this.royschedId = royschedId;
	this.loRange = loRange;
	this.hiRange = hiRange;
	this.royalty = royalty;
	this.titles = titles;
}

public Roysched() {
	
}

public int getRoyschedId() {
	return royschedId;
}

public void setRoyschedId(int royschedId) {
	this.royschedId = royschedId;
}

public int getLoRange() {
	return loRange;
}

public void setLoRange(int loRange) {
	this.loRange = loRange;
}

public int getHiRange() {
	return hiRange;
}

public void setHiRange(int hiRange) {
	this.hiRange = hiRange;
}

public int getRoyalty() {
	return royalty;
}

public void setRoyalty(int royalty) {
	this.royalty = royalty;
}

public Titles getTitles() {
	return titles;
}

public void setTitles(Titles titles) {
	this.titles = titles;
}
}