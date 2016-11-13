package com.codingparadox.models;

import java.util.Date;

import com.codingparadox.models.User;

public class Comment {
	private String id;
	private String content;
	private String timestamp;
	private User commenter;
	
	public Comment(){}
	
	public Comment(String id, String content, String timestamp, User commenter){
		this.id = id;
		this.content = content;
		this.timestamp = timestamp;
		this.commenter = commenter;
	}
	
	public String getId(){
		return this.id;
	}
	
	public String getContent(){
		return this.content;
	}
	
	public String getTimestamp(){
		return this.timestamp;
	}
	
	public User getCommenter(){
		return this.commenter;
	}
	
	public void setId(String id){
		this.id = id;
	}
	
	public void setContent(String content){
		this.content = content;
	}
	
	public void setTimestamp(String timestamp){
		this.timestamp = timestamp;
	}
	
	public void setCommenter(User commenter){
		this.commenter = commenter;
	}
}




