package com.codingparadox.controllers;

// java in-built imports
import java.util.List;
import java.util.HashMap;


// spring framework imports
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


// my imports
import com.codingparadox.models.Post;
import com.codingparadox.urls.PostURL;
import com.codingparadox.servicelayer.PostQueryService;


@RestController
@RequestMapping("/posts")
public class PostController {
	
	@Autowired
	PostQueryService postQueryService;
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String index(){
		return "index";
	}
	
	/*
	 * return all the posts
	 */
	@RequestMapping(value=PostURL.POSTS, method=RequestMethod.GET)
	public List<Post> getAll(){
		return postQueryService.getAll();
	}
	
	/*
	 * return a post with given id
	 */
	@RequestMapping(value=PostURL.POSTS_ID, method=RequestMethod.GET)
	public Post getById(@PathVariable String id){
		return postQueryService.getById(id);
	}
	
	/*
	 * create a post
	 */
	@RequestMapping(value=PostURL.POSTS, method=RequestMethod.POST)
	public Post create(@RequestBody Post post){
		return postQueryService.create(post);
	}
	
	/*
	 * delete a post
	 */
	@RequestMapping(value=PostURL.POSTS_ID, method=RequestMethod.DELETE)
	public String delete(@PathVariable String id){
		return postQueryService.delete(id);
	}
	
	/*
	 * update post
	 */
	@RequestMapping(value=PostURL.POSTS_ID, method=RequestMethod.PUT)
	public Post update(@PathVariable String id, @ModelAttribute Post post){
		return postQueryService.update(id, post);
	}
	
	/*
	 * search post by id, author, content -> any or all
	 * */
	@RequestMapping(value=PostURL.POSTS_SEARCH, method=RequestMethod.GET)
	public List<Post> search(@RequestParam HashMap<String, String> requestParams){
		return postQueryService.search(requestParams);
	}
	
}