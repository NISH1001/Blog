package com.codingparadox;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;

import com.codingparadox.repositories.PostRepository;

import org.hamcrest.Matchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import com.codingparadox.models.Post;

public class FunctionalTest extends BaseTest {
	
	
	@Autowired
	private PostRepository postRepository;
	
	private String token;

	private Post post;
	
	@BeforeClass
	public void databaseSetup(){
		System.out.println("******************** databaseSetup() ************************");
		postRepository.deleteAll();
		postRepository.insert(new Post("Nishan Pantha", "I saw a dream.") );
	}
	
	public void test(){
	}
	
	@Test(enabled = false, groups = "get")
	public void getPostAll(){
		System.out.println("******************** getPost() **********************");

		given().contentType("application/json").when().get("/").then().statusCode(200);

		Response response = given().contentType("application/json").when().get("/");

		List<Post> posts = (List<Post>) Arrays.asList(response.getBody().as(Post[].class));
		Assert.assertEquals(posts, posts);
	}
	
	@Test(enabled=true, groups = "post")
	public void insertNewPost(){
		Map<String, String> post = new HashMap<String, String>();
		post.put("author", "Nishan");
		post.put("content", "I am the pit");
		token = given().
				contentType("application/json").
				body(post).
				when().
				post("/").
				then().
				extract().
				response().
				path("_links.self.href");

		System.out.println("********************" + token);
	}
	
	@Test(enabled=false, groups="delete")
	public void deletePost(){
		given().
			when().
			delete("/5829aa9e77851860d791052b").
			then().
			statusCode(200);
	}
}




