package com.codingparadox.servicelayer;

import com.codingparadox.repositories.PostRepository;
import com.codingparadox.models.Post;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.ArrayList;


@Repository
public class PostQueryService {

	@Autowired
	PostRepository postRepository;
	
	public List<Post> getAll(){
		return (List<Post>) postRepository.findAll();
	}
	
	public Post getById(String id){
		return postRepository.findOne(id);
	}
	
	public Post create(Post post){
		return  postRepository.save(post);
	}
	
	public String delete(String id){
		postRepository.delete(id);
		return "deleted";
	}
	
	public Post update(String id, Post post){
		Post update = postRepository.findOne(id);
		update.setAuthor(post.getAuthor());
		update.setContent(post.getContent());
		return postRepository.save(update);
	}
	
	public List<Post> search(HashMap<String, String> requestParams){
		List<Post> posts = new ArrayList<Post>();

		String id = requestParams.get("id");
		String author = requestParams.get("author");
		String content = requestParams.get("content");

		if(id!=null){
			posts.add(postRepository.findOne(requestParams.get("id")));
		}

		else if(author!= null && content!= null){
			posts.addAll(postRepository.findByAuthorAndContentRegex(author, content));
		}

		else if(author!=null){
			posts.addAll(postRepository.findByAuthor(author));
		}
		
		else if(content != null){
			posts.addAll(postRepository.findByContentRegex(content));
		}

		else{
			posts.clear();
			posts.addAll(postRepository.findAll());
			
		}

		return posts;
	}
	
}
