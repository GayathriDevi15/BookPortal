package com.bookpartnerportal.bookpartnerportal.serviceimplementation;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bookpartnerportal.bookpartnerportal.bean.Author;
import com.bookpartnerportal.bookpartnerportal.bean.Discount;
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
	@Autowired
    private TitlesRepository titlesRepository;
	@Autowired
    private AuthorRepository authorRepository;
	@Autowired
    private TitleAuthorRepository titleauRepository;
	@Autowired
    private PublisherRepository publisherRepository;
	@Autowired
    private RoyschedRepository royschedRepository;
    @Autowired
    private SalesRepository salesRepository;
    @Autowired
    private DiscountRepository discountRepository;
    @Autowired
    private StoresRepository storesRepository;
    
    public TitlesServiceImplementation(TitlesRepository titlesRepository, AuthorRepository authorRepository,
			TitleAuthorRepository titleauRepository, PublisherRepository publisherRepository,
			RoyschedRepository royschedRepository, SalesRepository salesRepository,DiscountRepository discountRepository,
			StoresRepository storesRepository) {
		super();
		this.titlesRepository = titlesRepository;
		this.authorRepository = authorRepository;
		this.titleauRepository = titleauRepository;
		this.publisherRepository = publisherRepository;
		this.royschedRepository = royschedRepository;
		this.salesRepository = salesRepository;
		this.discountRepository=discountRepository;
		this.storesRepository=storesRepository;
	}
    
    //Endpoint 1
    
    @Override
   	public Titles addTitle(Titles title) {
    	String titleId=title.getTitleId();
    	if(titlesRepository.findByTitleId(titleId)==null &&title.getTitleId()!=null && title.getTitle()!=null&&title.getPubDate()!=null){
    	if(title.getType()==null) {
    		title.setType("UNDECIDED");
    	}
   	    Titles savedTitle=titlesRepository.save(title);
   	    return savedTitle;
   	    }
    	else {
    		return null;
    	}
   	}
    
    //Endpoint 2
    
    @Override
    public List<Titles> getTopFiveTitles() {
		return titlesRepository.findTopFiveTitles();
    }
    
	//Endpoint 3
    @Override
	public List<Titles> getTitlesByAuthor(String auFname) {
    	return titlesRepository.findByAuFname(auFname);
	}
    
    //Endpoint 4
    @Override
	public List<Titles> getTitleByPubDate(LocalDate pubDate) {
		List<Titles> titles=titlesRepository.findByPubDate(pubDate);
		return titles;
	}
    
    //Endpoint 5
	@Override
	public List<Titles> getTitleByPubId(String pubId) {
		Publisher pub=publisherRepository.findByPubId(pubId);
		List<Titles> titlesList=titlesRepository.findByPub(pub);
		return titlesList;
	}
	
    //Endpoint 6
    @Override
	public List<Titles> getTitleByType(String type) {
		// TODO Auto-generated method stub
		List<Titles> titles=titlesRepository.findByType(type);
		return titles;
	}

    //Endpoint 7
	@Override
	public Titles getTitleByTitle(String title) {
		Titles titleobject=titlesRepository.findByTitle(title);
		return titleobject;
	}
	
	//Endpoint 8
	
	@Override
	@Transactional
	public boolean deleteTitle(String titleId) {
		Titles title=titlesRepository.findByTitleId(titleId);
		if(title!=null) {
		salesRepository.deleteByTitleId(titleId);
        titleauRepository.deleteByTitleId(titleId);
     	royschedRepository.deleteByTitleId(titleId);
		titlesRepository.deleteByTitleId(titleId);
		return true;
		}
		return false;
	}
	
	//Endpoint 9
	@Override
	public Titles getTitleByTitleId(String titleId) {
		Titles title=titlesRepository.findByTitleId(titleId);
		return title;	
	}
	
	//Endpoint 10
	
	@Override
	public Titles updateTitles(String titleId,Titles title) {
		if(titlesRepository.existsById(titleId)&&title.getTitleId()!=null && title.getTitle()!=null&&title.getPubDate()!=null)
		{
			if(title.getType()==null) {
				title.setType("business");
			}
			title.setTitleId(titleId);
			return titlesRepository.save(title);
		}
		return null;
	}
	
   
}
