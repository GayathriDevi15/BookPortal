package com.bookpartnerportal.bookpartnerportal.bean;
import java.time.LocalDate;
import java.time.LocalDateTime;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="titles")
  public class Titles {
	@Id
	@Column(name="title_id",nullable=false,unique=true,columnDefinition="varchar(10)")

      private String titleId;
      @Column(nullable=false,columnDefinition="varchar(80)")
      private String title;
      @Column(nullable=false,columnDefinition = "char(12) default 'UNDECIDED'")
      private String type;
      private double price;
      private double advance;
      private int royalty;
      @Column(name="ytd_sales")
      private int ytdSales;
      @Column(columnDefinition="varchar(200)")
      private String notes;
      @Column(name="pubdate",nullable=false)
      private LocalDate pubDate;
      @ManyToOne(cascade=CascadeType.ALL)
      @JoinColumn(name="pub_id",referencedColumnName="pub_id")
      private Publisher pub;
      
	  public Titles() {
	  }

	public Titles(String titleId, String title, String type, double price, double advance, int royalty, int ytdSales,
			String notes, LocalDate pubDate, Publisher pub) {
		super();
		this.titleId = titleId;
		this.title = title;
		this.type = type;
		this.price = price;
		this.advance = advance;
		this.royalty = royalty;
		this.ytdSales = ytdSales;
		this.notes = notes;
		this.pubDate = pubDate;
		this.pub = pub;
	}

	public String getTitleId() {
		return titleId;
	}

	public void setTitleId(String titleId) {
		this.titleId = titleId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getAdvance() {
		return advance;
	}

	public void setAdvance(double advance) {
		this.advance = advance;
	}

	public int getRoyalty() {
		return royalty;
	}

	public void setRoyalty(int royalty) {
		this.royalty = royalty;
	}

	public int getYtdSales() {
		return ytdSales;
	}

	public void setYtdSales(int ytdSales) {
		this.ytdSales = ytdSales;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public LocalDate getPubDate() {
		return pubDate;
	}

	public void setPubDate(LocalDate pubDate) {
		this.pubDate = pubDate;
	}

	public Publisher getPub() {
		return pub;
	}

	public void setPub(Publisher pub) {
		this.pub = pub;
	}
	
}
