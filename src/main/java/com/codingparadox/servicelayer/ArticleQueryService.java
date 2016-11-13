package com.codingparadox.servicelayer;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.codingparadox.repositories.ArticleRepository;
import com.codingparadox.models.Article;

@Repository
public class ArticleQueryService {
	
	@Autowired
	ArticleRepository articleRepository;
	
	/*
	 * get all the articles
	 */
	public List<Article> getAll(){
		return articleRepository.findAll();
	}
	
	/*
	 * get an article by id
	 */
	public Article getById(String id){
		return articleRepository.findOne(id);
	}
	
	/*
	 * insert a new article
	 */
	public Article create(Article article){
		return articleRepository.save(article);
	}
	
	public String delete(String id){
		articleRepository.delete(id);
		return "deleted";
	}
	
	public Article update(String id, Article article){
		Article update = this.articleRepository.findOne(id);
		update.setLastModifiedDate(article.getLastModifiedDate());
		update.setContent(article.getContent());
		update.setTitle(article.getTitle());
		update.setAuthor(article.getAuthor());
		return articleRepository.save(update);
	}
	
	public List<Article> getByYear(int year){
		return articleRepository.findAll();
	}

	public List<Article> getByYearMonth(String year){
		return articleRepository.findAll();
	}
}
