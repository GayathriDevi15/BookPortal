package com.bookpartnerportal.bookpartnerportal.bean;
 
import java.io.Serializable;
 
public class TitleAuthorId implements Serializable {
	private Author author;
	private Titles title;
	public TitleAuthorId(Author author, Titles title) {
		super();
		this.author = author;
		this.title = title;
	}
	public TitleAuthorId() {
		super();
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
}