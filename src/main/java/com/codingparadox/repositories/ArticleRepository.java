package com.codingparadox.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.codingparadox.models.Article;


public interface ArticleRepository extends MongoRepository<Article, String> {
	
	List<Article> findByCreatedDate(Date createdDate);
}
