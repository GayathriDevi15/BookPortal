//package com.bookpartnerportal.bookpartnerportal.controller;
//
//import java.time.LocalDate;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.format.annotation.DateTimeFormat;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.bookpartnerportal.bookpartnerportal.bean.Titles;
//import com.bookpartnerportal.bookpartnerportal.exception.TitlesNotFoundException;
//import com.bookpartnerportal.bookpartnerportal.exception.ValidationException;
//import com.bookpartnerportal.bookpartnerportal.service.TitlesService;
//import com.bookpartnerportal.bookpartnerportal.serviceimplementation.TitlesServiceImplementation;
//import com.bookpartnerportal.bookpartnerportal.success.SuccessResponse;
//
//@RestController
//@RequestMapping("/api/titles")
//public class TitlesController {
//	@Autowired
//	private TitlesServiceImplementation titlesService;
//	
//  
//
//    public TitlesController(TitlesServiceImplementation titlesService) {
//		super();
//		this.titlesService = titlesService;
//	}
//
////Post Titles-Endpoint 1
//
//@PostMapping
//public ResponseEntity<SuccessResponse> addTitle(@RequestBody Titles title) {
//	  Titles titlename=titlesService.addTitle(title);
//	  if(titlename==null)
//		  throw new ValidationException("Validation failed");
//	  SuccessResponse successResponse=new SuccessResponse(LocalDate.now(),"New title added successfully");
//	  return new ResponseEntity<>(successResponse,HttpStatus.OK);
//}
//
////Get Top 5 titles-EndPoint2
//
//@GetMapping("/top5titles")
//public ResponseEntity<List<Titles>> getTopFiveTitles(){
//	  List<Titles> titlesList=titlesService.getTopFiveTitles();
//	  if(titlesList==null)
//		  throw new TitlesNotFoundException("Titles not found");
//	  return new ResponseEntity<>(titlesList,HttpStatus.OK);	  
//}
//
//@GetMapping("/authorname/{name}")
//  public ResponseEntity<List<Titles>> getTitlesByAuthor(@PathVariable("name") String auFname){
//	  List<Titles> titlesList=titlesService.getTitlesByAuthor(auFname);
//	  return new ResponseEntity<>(titlesList,HttpStatus.OK);
//	  
//  }
//
////Get Titles By Title Type
//
//  @GetMapping("titletype/{type}")
//   public ResponseEntity<List<Titles>> getTitleByType(@PathVariable String type){
//	  List<Titles> titles=titlesService.getTitleByType(type);
//	  return new ResponseEntity<>(titles,HttpStatus.OK);
//  }
//  
//  
// //Get titles with given title
//  
//  @GetMapping("title/{title}")
//  public ResponseEntity<Titles> getTitleByTitle(@PathVariable String title){
//	  Titles titles=titlesService.getTitleByTitle(title);
//	  return new ResponseEntity<>(titles,HttpStatus.OK);
// }
//  
//  //Get titles with title id
//  
//  @GetMapping("{title_id}")
//  public ResponseEntity<Titles> getTitleByTitleId(@PathVariable("title_id") String titleId){
//	  Titles title=titlesService.getTitleByTitleId(titleId);
//	  return new ResponseEntity<>(title,HttpStatus.OK);
// }
//  
//  //Get titles published on given date
// 
//  @GetMapping("pubdate/{pubdate}")
//  public ResponseEntity<List<Titles>> getTitleByPubDate(@PathVariable("pubdate")  LocalDate pubDate){
//	  List<Titles> titles=titlesService.getTitleByPubDate(pubDate);
//	  return new ResponseEntity<>(titles,HttpStatus.OK);
//  }
//  
//  //Get titles by publisher id
//  
//
//  @GetMapping("pubid/{pubid}")
//  public ResponseEntity<List<Titles>> getTitleByPubId(@PathVariable("pubid") String pubId){
//	  List<Titles> titles=titlesService.getTitleByPubId(pubId);
//	  return new ResponseEntity<>(titles,HttpStatus.OK);
//  }
//  
//  //updating title with title id
//  
//  @RequestMapping(value="{title_id}",method=RequestMethod.PUT)
//  public ResponseEntity<SuccessResponse> updateTitle(@PathVariable("title_id") String titleId,@RequestBody Titles title) {
//	  Titles titlename=titlesService.updateTitles(titleId,title);
//	  SuccessResponse successResponse=new SuccessResponse(LocalDate.now(),"Title updated successfully");
//	  return new ResponseEntity<>(successResponse,HttpStatus.OK);
//  }
//  
//  //deleting title by title id
//  @DeleteMapping("{title_id}")
//  public ResponseEntity<SuccessResponse> deleteTitle(@PathVariable("title_id") String titleId) {
//	  titlesService.deleteTitle(titleId);
//	  SuccessResponse successResponse=new SuccessResponse(LocalDate.now(),"Title deleted successfully");
//	  return new ResponseEntity<>(successResponse,HttpStatus.OK);
//  }
//  
//}
//
