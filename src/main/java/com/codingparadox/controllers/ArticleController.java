package com.codingparadox.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.codingparadox.models.Article;
import com.codingparadox.servicelayer.ArticleQueryService;

@RestController
@RequestMapping("/articles")
public class ArticleController {
	
	@Autowired
	ArticleQueryService articleQueryService;
	
	/*
	 * get all the articles
	 */
	@RequestMapping(value="", method=RequestMethod.GET)
	public List<Article> getAll(){
		return articleQueryService.getAll();
	}
	
	/*
	 * get an article by id
	 */
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public Article getById(@PathVariable String id){
		return articleQueryService.getById(id);
	}

	@RequestMapping(value="/{year}/{month}/{day}", method=RequestMethod.GET)
	public List<Article> getByYMD(@PathVariable(value="year") String year, 
			@PathVariable(value="month") String month, 
			@PathVariable(value="day") String day){

		return articleQueryService.getAll();
	}
	
	@RequestMapping(value="/{year}/{month}", method=RequestMethod.GET)
	public List<Article> getByYM(@PathVariable(value="year") String year, 
			@PathVariable(value="month") String month){ 

		return articleQueryService.getAll();
	}

	/*
	@RequestMapping(value="/{year}", method=RequestMethod.GET)
	public List<Article> getByYear(@PathVariable(value="year") String year){ 
		return articleQueryService.getByYearMonth(year);
	}
	*/
	
	/*
	 * post a new article
	 */
	@RequestMapping(value="", method=RequestMethod.POST)
	public Article create(@RequestBody Article article){
		return articleQueryService.create(article);
	}
	
	/*
	 * delete an article by id
	 */
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public String delete(@PathVariable String id){
		return articleQueryService.delete(id);
	}
	
	/*
	 * update the article
	 */
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public Article update(@PathVariable String id, @RequestBody Article article){
		return articleQueryService.update(id, article);
	}

}
