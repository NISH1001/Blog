package com.codingparadox.controllers;

// java in-built imports
import java.util.List;

// spring framework imports
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import static org.springframework.data.mongodb.core.query.Query.*;


// my imports
import com.codingparadox.repositories.PostRepository;
import com.codingparadox.models.Post;
import com.codingparadox.urls.PostURL;



@RestController
public class PostController {
	
	@Autowired
	PostRepository postRepository;
	
	@RequestMapping("/")
	public String indexer(@RequestParam(value="author", defaultValue="paradox") String author){
		return "hello " + author;
	}
	
	@RequestMapping(value=PostURL.GET_POST_ALL, method=RequestMethod.GET)
	public List<Post> getPostAll(){
		return (List<Post>) postRepository.findAll();
	}
	
	@RequestMapping(value=PostURL.GET_POST_CONTENT, method=RequestMethod.GET)
	public String getPostByContent(@PathVariable("content") String content){
		return content;
		//return (List<Post>) postRepository.findAll();
	}
	
	@RequestMapping(value=PostURL.CREATE_POST, method=RequestMethod.POST)
	public String createPost(@ModelAttribute Post post){
		postRepository.save(post);
		return "200";
	}

	@RequestMapping(value=PostURL.DELETE_POST, method=RequestMethod.POST)
	public String deletePost(@PathVariable("id") String id){
		return "200";
	}
}

