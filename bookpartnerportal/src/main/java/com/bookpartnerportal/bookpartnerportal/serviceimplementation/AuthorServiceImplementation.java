package com.bookpartnerportal.bookpartnerportal.serviceimplementation;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.bookpartnerportal.bookpartnerportal.bean.Author;
import com.bookpartnerportal.bookpartnerportal.exception.AuthorAddException;
import com.bookpartnerportal.bookpartnerportal.repository.AuthorRepository;
import com.bookpartnerportal.bookpartnerportal.repository.TitleAuthorRepository;
import com.bookpartnerportal.bookpartnerportal.service.AuthorService;

import jakarta.transaction.Transactional;

@Service
//@Transactional
public class AuthorServiceImplementation implements AuthorService {
	@Autowired
	private AuthorRepository authorRepository;
	@Autowired
	private TitleAuthorRepository titleauthorRepository;

	public AuthorServiceImplementation(AuthorRepository authorRepository, TitleAuthorRepository titleauthorRepository) {
		super();
		this.authorRepository = authorRepository;
		this.titleauthorRepository = titleauthorRepository;
	}

	public AuthorServiceImplementation() {
		super();
	}

	// get all authors................
	@Override
	public List<Author> getAllAuthors() {
		List<Author> authors = authorRepository.findAll();
		return authors;
	}

	// get authors by city................
	public List<Author> getAuthorsByCity(String city) {
		List<Author> authors = authorRepository.findByCity(city);
		return authors;
	}

	// get authors by state....................
	@Override
	public List<Author> getAuthorsByState(String state) {
		List<Author> authors = authorRepository.findByState(state);

		return authors;
	}

	// get authors by zipcode.......................
	@Override
	public List<Author> getAuthorsByZip(String zip) {
		List<Author> authors = authorRepository.findByZip(zip);

		return authors;
	}

	// get authors by first name.........................
	@Override
	public List<Author> getAuthorsByFname(String au_fname) {

		List<Author> authors = authorRepository.findByAuFname(au_fname);

		return authors;
	}

	// get authors by phone no.................
	@Override
	public List<Author> getAuthorsByPhone(String phone) {
		List<Author> authors = authorRepository.findByPhone(phone);

		return authors;
	}

	// get authors by last name.................

	@Override
	public List<Author> getAuthorsByLname(String au_lname) {
		List<Author> authors = authorRepository.findByAuLname(au_lname);

		return authors;
	}

	// get authors by authorId..............
	@Override
	public Author getAuthorsByAuid(String auId) {
		Author authors = authorRepository.findByAuId(auId);

		return authors;
	}

	// POST method
	@Override
	public Author addAuthor(Author author) {
		String au = author.getAuId();
		Integer contract = author.getContract();
		if (authorRepository.findByAuId(au) == null && author.getAuFname() != null && author.getAuLname() != null
				&& contract != null) {
			if (author.getPhone() == null) {
				author.setPhone("UNKNOWN");
			}
			if (au.matches("^[0-9][0-9][0-9]-[0-9][0-9]-[0-9][0-9][0-9][0-9]$")
					&& author.getZip().matches("^[0-9][0-9][0-9][0-9][0-9]$")) {

				return authorRepository.save(author);
			}

		}
		return null;

	}

	// DELETE method
	@Override
	@Transactional
	public Integer deleteAuthor(String au_id) {

		Author author = authorRepository.getById(au_id);
		if (author != null) {
			titleauthorRepository.deleteByAuthor(author);
			authorRepository.delete(author);
			return 1;
		}

		return 0;
	}

	// PUT method
	@Override
	public Author updateAuthor(String au_id, Author author) {
		if ((authorRepository.existsById(au_id))) {
			String au = author.getAuId();
			if (author.getPhone() == null) {
				author.setPhone("UNKNOWN");
			}
			Integer contract = author.getContract();
			if (contract != null && author.getZip().matches("^[0-9][0-9][0-9][0-9][0-9]$")
					&& author.getAuFname() != null && author.getAuLname() != null) {

				// author.setAuId(au_id);

				return authorRepository.save(author);
			}
		}
		return null;

	}
}