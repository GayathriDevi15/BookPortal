package com.bookpartnerportal.bookpartnerportal.serviceimplementation;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bookpartnerportal.bookpartnerportal.bean.Author;
import com.bookpartnerportal.bookpartnerportal.bean.Publisher;
import com.bookpartnerportal.bookpartnerportal.bean.Roysched;
import com.bookpartnerportal.bookpartnerportal.bean.Sales;
import com.bookpartnerportal.bookpartnerportal.bean.Stores;
import com.bookpartnerportal.bookpartnerportal.bean.TitleAuthor;
import com.bookpartnerportal.bookpartnerportal.bean.Titles;
import com.bookpartnerportal.bookpartnerportal.repository.AuthorRepository;
import com.bookpartnerportal.bookpartnerportal.repository.DiscountRepository;
import com.bookpartnerportal.bookpartnerportal.repository.PublisherRepository;
import com.bookpartnerportal.bookpartnerportal.repository.RoyschedRepository;
import com.bookpartnerportal.bookpartnerportal.repository.SalesRepository;
import com.bookpartnerportal.bookpartnerportal.repository.StoresRepository;
import com.bookpartnerportal.bookpartnerportal.repository.TitleAuthorRepository;
import com.bookpartnerportal.bookpartnerportal.repository.TitlesRepository;
import com.bookpartnerportal.bookpartnerportal.service.TitlesService;

@Service
public class TitlesServiceImplementation implements TitlesService{
    private TitlesRepository titlesRepository;
    private AuthorRepository authorRepository;
    private TitleAuthorRepository titleauRepository;
    private PublisherRepository publisherRepository;
    private RoyschedRepository royschedRepository;
    private SalesRepository salesRepository;
    
    public TitlesServiceImplementation(TitlesRepository titlesRepository, AuthorRepository authorRepository,
			TitleAuthorRepository titleauRepository, PublisherRepository publisherRepository,
			RoyschedRepository royschedRepository, SalesRepository salesRepository) {
		super();
		this.titlesRepository = titlesRepository;
		this.authorRepository = authorRepository;
		this.titleauRepository = titleauRepository;
		this.publisherRepository = publisherRepository;
		this.royschedRepository = royschedRepository;
		this.salesRepository = salesRepository;
	}
    
    //Endpoint 1
    
    @Override
   	public Titles addTitle(Titles title) {
   	    Titles savedTitle=titlesRepository.save(title);
   	    return savedTitle;
   	}
    
	//Endpoint 3
    @Override
	public List<Titles> getTitlesByAuthor(String auFname) {
		// TODO Auto-generated method stub
    	return titlesRepository.findByAuFname(auFname);
	}
    //Endpoint 6
    @Override
	public List<Titles> getTitleByType(String type) {
		// TODO Auto-generated method stub
		List<Titles> titles=titlesRepository.findByType(type);
		return titles;
	}

	@Override
	public List<Titles> getTitleByPubDate(LocalDate pubDate) {
		List<Titles> titles=titlesRepository.findByPubDate(pubDate);
		return titles;
	}
	
	@Override
	public List<Titles> getTitleByPubId(String pubId) {
		Publisher pub=publisherRepository.findByPubId(pubId);
		List<Titles> titlesList=titlesRepository.findByPub(pub);
		return titlesList;
	}

	@Override
	public Titles getTitleByTitle(String title) {
		Titles titleobject=titlesRepository.findByTitle(title);
		return titleobject;
	}
	@Override
	public Titles getTitleByTitleId(String titleId) {
		Titles title=titlesRepository.findByTitleId(titleId);
		return title;	
	}
	@Override
	public Titles updateTitles(String titleId,Titles title) {
		// TODO Auto-generated method stub
		Titles existingTitle=getTitleByTitleId(titleId);
		existingTitle.setAdvance(title.getAdvance());
		existingTitle.setNotes(title.getNotes());
		existingTitle.setPrice(title.getPrice());
		existingTitle.setPub(title.getPub());
		existingTitle.setPubDate(title.getPubDate());
		existingTitle.setRoyalty(title.getRoyalty());
		existingTitle.setTitle(title.getTitle());
		existingTitle.setType(title.getType());
		existingTitle.setYtdSales(title.getYtdSales());
		existingTitle=titlesRepository.save(existingTitle);
		
		return existingTitle;
	}
   
   @Override
	public void deleteTitle(String titleId) {
		// TODO Auto-generated method stub
	   
	    Titles title=titlesRepository.findByTitleId(titleId);
	    //Deleting in roysched
	   
	    List<Roysched> roys=royschedRepository.findByTitles(title);
	    for(Roysched roy:roys) {
	    royschedRepository.delete(roy);
	    }
	    
       //Deleting in title author
	    
	    List<TitleAuthor> titleaus=titleauRepository.findByTitle(title);
	    for(TitleAuthor titleau:titleaus) {
	    titleauRepository.delete(titleau);
	    }
	    
	    //Deleting in sales
	    
	    
	    List<Sales> sales=salesRepository.findByTitle(title);
	    for(Sales sale:sales) {
	    salesRepository.delete(sale);
	    }
	    
	   
	    
	    //Deleting in titles table;
		Titles deleteTitle=getTitleByTitleId(titleId);
		titlesRepository.delete(deleteTitle);
	}
   
     @Override
     public List<Titles> getTopFiveTitles() {
    	 
		return titlesRepository.findTopFiveTitles();
     }
	

}
