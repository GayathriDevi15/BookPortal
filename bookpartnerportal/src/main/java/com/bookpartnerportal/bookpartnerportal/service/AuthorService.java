package com.bookpartnerportal.bookpartnerportal.service;

import java.util.List;

import com.bookpartnerportal.bookpartnerportal.bean.Author;

public interface AuthorService {
	List<Author> getAllAuthors();

	List<Author> getAuthorsByCity(String city);

	List<Author> getAuthorsByState(String state);

	List<Author> getAuthorsByZip(String zip);

	List<Author> getAuthorsByFname(String au_fname);

	List<Author> getAuthorsByLname(String au_lname);

	List<Author> getAuthorsByPhone(String phone);

	Author getAuthorsByAuid(String au_id);

	Author addAuthor(Author author);

	Integer deleteAuthor(String au_id);

	Author updateAuthor(String au_id, Author author);

}