package com.codingparadox.controllers;

// java in-built imports
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;


// spring framework imports
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.data.mongodb.core.query.Query.*;


// my imports
import com.codingparadox.repositories.PostRepository;
import com.codingparadox.models.Post;
import com.codingparadox.urls.PostURL;



@RestController
@RequestMapping("/posts")
public class PostController {
	
	@Autowired
	PostRepository postRepository;
	
	@RequestMapping("/")
	public String indexer(@RequestParam(value="author", defaultValue="paradox") String author){
		return "hello " + author;
	}
	
	/*
	 * return all the posts
	 */
	@RequestMapping(value=PostURL.POSTS, method=RequestMethod.GET)
	public List<Post> getAll(){
		return (List<Post>) postRepository.findAll();
	}
	
	/*
	 * return a post with given id
	 */
	@RequestMapping(value=PostURL.POSTS_ID, method=RequestMethod.GET)
	public Post getById(@PathVariable String id){
		return postRepository.findOne(id);
	}
	
	/*
	 * create a post
	 */
	@RequestMapping(value=PostURL.POSTS, method=RequestMethod.POST)
	public Post create(@ModelAttribute Post post){
		return  postRepository.save(post);
	}
	
	/*
	 * delete a post
	 */
	@RequestMapping(value=PostURL.POSTS_ID, method=RequestMethod.DELETE)
	public String delete(@PathVariable String id){
		postRepository.delete(id);
		return "deletePosts()";
	}
	
	@RequestMapping(value=PostURL.POSTS_ID, method=RequestMethod.PUT)
	public Post update(@PathVariable String id, @ModelAttribute Post post){
		Post update = postRepository.findOne(id);
		update.setAuthor(post.getAuthor());
		update.setContent(post.getContent());
		return postRepository.save(update);
	}
	
	@RequestMapping(value=PostURL.POSTS_SEARCH, method=RequestMethod.GET)
	public List<Post> search(@RequestParam HashMap<String, String> requestParams){
		List<Post> posts = new ArrayList<Post>();
		//return requestParams.get("id");
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