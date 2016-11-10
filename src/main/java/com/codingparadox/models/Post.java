package com.codingparadox.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="post")
public class Post {
	
	@Id
	private String id;
	private String author;
	private String content;
	
	public Post(){}
	
	public Post(String id, String author, String content){
		this.id = id;
		this.author = author;
		this.content = content;
	}
	
	public String getId(){
		return this.id;
	}
	
	public void setId(String id){
		this.id  = id;
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
	
	/*
	public String toString(){
		
		return "Post{" +
	            	"id=" + this.id +
	                ", author ='" + this.author + '\'' +
	                ", content ='" + this.content+ '\'' +
	                '}';
				
	}
	*/
	@Override
	public String toString() {
		return String.format(
				"Post[id=%s, author='%s', content='%s']",
	              this.id, this.author, this.content);
	    }
	

}
