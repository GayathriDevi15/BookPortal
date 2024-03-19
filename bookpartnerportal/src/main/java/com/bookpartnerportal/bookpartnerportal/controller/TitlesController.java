package com.bookpartnerportal.bookpartnerportal.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bookpartnerportal.bookpartnerportal.bean.Titles;
import com.bookpartnerportal.bookpartnerportal.service.TitlesService;
import com.bookpartnerportal.bookpartnerportal.serviceimplementation.TitlesServiceImplementation;
import com.bookpartnerportal.bookpartnerportal.success.SuccessResponse;
import com.bookpartnerportal.bookpartnerportal.titlesexceptions.TitleIdNotFoundException;
import com.bookpartnerportal.bookpartnerportal.titlesexceptions.TitlesNotFoundException;
import com.bookpartnerportal.bookpartnerportal.titlesexceptions.TitleswithPubdateNotFoundException;
import com.bookpartnerportal.bookpartnerportal.titlesexceptions.TitlewithAuthorNotFoundException;
import com.bookpartnerportal.bookpartnerportal.titlesexceptions.TitlewithPubIdNotFoundException;
import com.bookpartnerportal.bookpartnerportal.titlesexceptions.ValidationException;

@RestController
@RequestMapping("/api/titles")
public class TitlesController {
	@Autowired
	private TitlesServiceImplementation titlesService;

	public TitlesController(TitlesServiceImplementation titlesService) {
		super();
		this.titlesService = titlesService;
	}

	//Post Titles-Endpoint1

	@PostMapping
	public ResponseEntity<SuccessResponse> addTitle(@RequestBody Titles title) {
		Titles titlename = titlesService.addTitle(title);
		if (titlename == null)
			throw new ValidationException("Validation failed");
		SuccessResponse successResponse = new SuccessResponse(LocalDate.now(), "New title added successfully");
		return new ResponseEntity<>(successResponse, HttpStatus.OK);
	}

	//Get Top 5 titles-EndPoint2

	@GetMapping("/top5titles")
	public ResponseEntity<List<Titles>> getTopFiveTitles() {
		List<Titles> titlesList = titlesService.getTopFiveTitles();
		if (titlesList.isEmpty())
			throw new TitlesNotFoundException("Titles not found");
		return new ResponseEntity<>(titlesList, HttpStatus.OK);
	}

	//Get Titles By author firstname-Endpoint3

	@GetMapping("/authorname/{name}")
	public ResponseEntity<List<Titles>> getTitlesByAuthor(@PathVariable("name") String auFname) {
		List<Titles> titlesList = titlesService.getTitlesByAuthor(auFname);
		if (titlesList.isEmpty())
			throw new TitlewithAuthorNotFoundException("Titles with given author name not found");
		return new ResponseEntity<>(titlesList, HttpStatus.OK);
	}

	//Get titles published on given date-Endpoint4

	@GetMapping("pubdate/{pubdate}")
	public ResponseEntity<List<Titles>> getTitleByPubDate(@PathVariable("pubdate") LocalDate pubDate) {
		List<Titles> titles = titlesService.getTitleByPubDate(pubDate);
		if (titles.isEmpty())
			throw new TitleswithPubdateNotFoundException("Titles with this publisher pubdate not found");
		return new ResponseEntity<>(titles, HttpStatus.OK);
	}

	//Get titles by publisher id-Endpoint5

	@GetMapping("pubid/{pubid}")
	public ResponseEntity<List<Titles>> getTitleByPubId(@PathVariable("pubid") String pubId) {
		List<Titles> titles = titlesService.getTitleByPubId(pubId);
		if (titles.isEmpty())
			throw new TitlewithPubIdNotFoundException("Titles with this publisher id not found");
		return new ResponseEntity<>(titles, HttpStatus.OK);
	}

	//Get Titles By Title Type-Endpoint6

	@GetMapping("titletype/{type}")
	public ResponseEntity<List<Titles>> getTitleByType(@PathVariable String type) {
		List<Titles> titles = titlesService.getTitleByType(type);
		if (titles.isEmpty())
			throw new TitleIdNotFoundException("Titles with this title_id not found");
		return new ResponseEntity<>(titles, HttpStatus.OK);
	}

	// Get titles with given title-Endpoint7

	@GetMapping("title/{title}")
	public ResponseEntity<Titles> getTitleByTitle(@PathVariable String title) {
		Titles titles = titlesService.getTitleByTitle(title);
		if (titles == null)
			throw new TitleIdNotFoundException("Title with this title_id not found");
		return new ResponseEntity<>(titles, HttpStatus.OK);
	}

	// deleting title by title id-Endpoint8
	@DeleteMapping("{title_id}")
	public ResponseEntity<SuccessResponse> deleteTitle(@PathVariable("title_id") String titleId) {
		boolean response = titlesService.deleteTitle(titleId);
		if (response == false)
			throw new TitleIdNotFoundException("Title with this title_id not found");
		SuccessResponse successResponse = new SuccessResponse(LocalDate.now(), "Title deleted successfully");
		return new ResponseEntity<>(successResponse, HttpStatus.OK);
	}

	// Get titles with title id-Endpoint9

	@GetMapping("{title_id}")
	public ResponseEntity<Titles> getTitleByTitleId(@PathVariable("title_id") String titleId) {
		Titles title = titlesService.getTitleByTitleId(titleId);
		if (title == null)
			throw new TitleIdNotFoundException("Titles with this title_id not found");
		return new ResponseEntity<>(title, HttpStatus.OK);
	}

	// updating title with title id-Endpoint10

	@RequestMapping(value = "{title_id}", method = RequestMethod.PUT)
	public ResponseEntity<SuccessResponse> updateTitle(@PathVariable("title_id") String titleId,
			@RequestBody Titles title) {
		Titles titlename = titlesService.updateTitles(titleId, title);
		if (titlename == null)
			throw new ValidationException("Validation failed");
		SuccessResponse successResponse = new SuccessResponse(LocalDate.now(), "Title updated successfully");
		return new ResponseEntity<>(successResponse, HttpStatus.OK);
	}

}
