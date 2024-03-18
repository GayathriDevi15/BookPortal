package com.bookpartnerportal.bookpartnerportal.controller;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookpartnerportal.bookpartnerportal.authorexception.AuthorAddException;
import com.bookpartnerportal.bookpartnerportal.authorexception.AuthorDeleteException;
import com.bookpartnerportal.bookpartnerportal.authorexception.AuthorUpdateException;
import com.bookpartnerportal.bookpartnerportal.authorexception.AuthorsNotFoundByCityException;
import com.bookpartnerportal.bookpartnerportal.authorexception.AuthorsNotFoundByFnameException;
import com.bookpartnerportal.bookpartnerportal.authorexception.AuthorsNotFoundByIdException;
import com.bookpartnerportal.bookpartnerportal.authorexception.AuthorsNotFoundByLnameException;
import com.bookpartnerportal.bookpartnerportal.authorexception.AuthorsNotFoundByPhoneException;
import com.bookpartnerportal.bookpartnerportal.authorexception.AuthorsNotFoundByStateException;
import com.bookpartnerportal.bookpartnerportal.authorexception.AuthorsNotFoundByZipException;
import com.bookpartnerportal.bookpartnerportal.authorexception.AuthorsNotFoundException;
import com.bookpartnerportal.bookpartnerportal.bean.Author;
import com.bookpartnerportal.bookpartnerportal.repository.AuthorRepository;
import com.bookpartnerportal.bookpartnerportal.service.AuthorService;
import com.bookpartnerportal.bookpartnerportal.success.CustomResponse;

@RestController
@RequestMapping

public class AuthorController {
	@Autowired
	private AuthorService authorService;

	// 1.get all authors list......................................
	@GetMapping("/api/authors")
	public ResponseEntity<List<Author>> retrieveAll() {
		List<Author> author = authorService.getAllAuthors();
		if (author.isEmpty()) {
			throw new AuthorsNotFoundException("Authors not found");
		}
		return new ResponseEntity<>(author, HttpStatus.OK);
	}

	// 2.get all authors by city..................
	@GetMapping("/api/authors/city/{city}")
	public ResponseEntity<?> getAuthorsByCity(@PathVariable("city") String city) {
		List<Author> authors = authorService.getAuthorsByCity(city);
		if (authors.isEmpty()) {
			throw new AuthorsNotFoundByCityException("Authors not found by city");
		}
		return new ResponseEntity<>(authors, HttpStatus.OK);
	}

	// 3.get all authors by state.................

	@GetMapping("/api/authors/state/{state}")
	public ResponseEntity<?> getAuthorsByState(@PathVariable("state") String state) {
		List<Author> authors = authorService.getAuthorsByState(state);
		if (authors.isEmpty()) {
			throw new AuthorsNotFoundByStateException("Authors not found by state");
		}
		return new ResponseEntity<>(authors, HttpStatus.OK);
	}

	// 4.get all authors by zip......................
	@GetMapping("/api/authors/zip/{zip}")
	public ResponseEntity<List<Author>> getAuthorsByZip(@PathVariable("zip") String zip) {
		List<Author> authors = authorService.getAuthorsByZip(zip);
		if (authors.isEmpty()) {
			throw new AuthorsNotFoundByZipException("Authors not found by zip");
		}
		return new ResponseEntity<>(authors, HttpStatus.OK);
	}

	// 5.get all authors by phone......................

	@GetMapping("/api/authors/phone/{phone}")
	public ResponseEntity<List<Author>> getAuthorsByPhone(@PathVariable("phone") String phone) {
		List<Author> authors = authorService.getAuthorsByPhone(phone);
		if (authors.isEmpty()) {
			throw new AuthorsNotFoundByPhoneException("Authors not found by phone");
		}
		return new ResponseEntity<>(authors, HttpStatus.OK);
	}

	// 6.get all authors by firstname....................
	@GetMapping("/api/authors/fname/{au_fname}")
	public ResponseEntity<List<Author>> getAuthorsByFname(@PathVariable("au_fname") String auFname) {
		List<Author> authors = authorService.getAuthorsByFname(auFname);
		if (authors.isEmpty()) {
			throw new AuthorsNotFoundByFnameException("Authors not found by firstname");
		}
		return new ResponseEntity<>(authors, HttpStatus.OK);
	}

	// 7.get all authors by lastname.........................
	@GetMapping("/api/authors/lname/{au_lname}")
	public ResponseEntity<List<Author>> getAuthorsByLname(@PathVariable("au_lname") String auLname) {
		List<Author> authors = authorService.getAuthorsByLname(auLname);
		if (authors.isEmpty()) {
			throw new AuthorsNotFoundByLnameException("Authors not found by lastname");
		}
		return new ResponseEntity<>(authors, HttpStatus.OK);

	}

	// 8.get author by authorId

	@GetMapping("/api/authors/{au_id}")
	public ResponseEntity<Author> getAuthorsByAuid(@PathVariable("au_id") String auId) {
		Author authors = authorService.getAuthorsByAuid(auId);
		if (authors == null) {
			throw new AuthorsNotFoundByIdException("Authors not found by au_Id");
		}
		return new ResponseEntity<>(authors, HttpStatus.OK);
	}

	// 9.add new author post method
	@PostMapping("/api/authors")
	public ResponseEntity<CustomResponse> addAuthor(@RequestBody Author author) {
		Author author1 = authorService.addAuthor(author);
		if (author1 == null) {
			throw new AuthorAddException("Validation failed");
		}

		CustomResponse customeResponse = new CustomResponse(LocalDate.now(), "Author added Successfully");
		return new ResponseEntity<>(customeResponse, HttpStatus.OK);

	}

	// 10.Delete author with author id

	@DeleteMapping("/api/authors/{au_id}")

	public ResponseEntity<CustomResponse> deleteAuthor(@PathVariable("au_id") String au_id) {
		Author au = authorService.getAuthorsByAuid(au_id);
		if (au == null) {
			throw new AuthorDeleteException("Author with this author id not found");
		}

		authorService.deleteAuthor(au_id);
		CustomResponse customeResponse = new CustomResponse(LocalDate.now(), "Author with id deleted successfully");
		return new ResponseEntity<>(customeResponse, HttpStatus.OK);
	}

	// 11. Update author with author id....................
	@PutMapping("/api/authors/{au_id}")

	public ResponseEntity<CustomResponse> updateAuthor(@PathVariable("au_id") String au_id,
			@RequestBody Author author) {
		Author author1 = authorService.updateAuthor(au_id, author);
		if (author1 == null) {
			throw new AuthorUpdateException("Validation failed");
		}
		authorService.updateAuthor(au_id, author);
		CustomResponse customeResponse = new CustomResponse(LocalDate.now(), "Author with id updated successfully");
		return new ResponseEntity<>(customeResponse, HttpStatus.OK);

	}
}