package com.codingparadox.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "article")
public class Article {

	@Id
	private String id;
	
	@CreatedDate
	private Date createdDate = new Date();
	@LastModifiedDate
	private Date lastModifiedDate = new Date();

	private String title;
	private String content;
	private String author;
	private List<String> tags;
	//private ArrayList<User> comments;
	
	public Article(){}

	public Article(String id, Date createdDate, Date lastModifiedDate, 
				String title, String content,
				String author, List<String> tags){
		this.id = id;
		this.createdDate = createdDate;
		this.lastModifiedDate = lastModifiedDate;
		this.content = content;
		this.author = author;
		this.tags = tags;
	}
	
	public String getId(){
		return this.id;
	}
	
	public void setId(String id){
		this.id = id;
	}
	
	public Date getCreatedDate(){
		return this.createdDate;
	}
	
	public void setCreatedDate(Date createdDate){
		this.createdDate = createdDate;
	}
	
	public Date getLastModifiedDate(){
		return this.lastModifiedDate;
	}
	
	public void setLastModifiedDate(Date lastModifiedDate){
		this.lastModifiedDate = lastModifiedDate;
	}
	
	public String getTitle(){
		return this.title;
	}
	
	public void setTitle(String title){
		this.title = title;
	}
	
	public String getContent(){
		return this.content;
	}
	
	public void setContent(String content){
		this.content = content;
	}
	
	public String getAuthor(){
		return this.author;
	}
	
	public void setAuthor(String author){
		this.author = author;
	}
	
	public List<String> getTags(){
		return this.tags;
	}
	
	public void setTags(List<String> tags){
		this.tags = tags;
	}
}



