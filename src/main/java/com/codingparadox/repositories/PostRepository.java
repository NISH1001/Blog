package com.codingparadox.repositories;

import com.codingparadox.models.Post;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

//@RepositoryRestResource(collectionResourceRel = "post", path = "post")
public interface PostRepository extends MongoRepository<Post, String>{

	//List<Post> findByLastName(@Param("author") String author);
	List<Post> findByAuthorAndContentRegex(String author, String content);
	List<Post> findByAuthor(String author);
	List<Post> findByContentRegex(String content);
}