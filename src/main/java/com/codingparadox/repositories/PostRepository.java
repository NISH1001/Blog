package com.codingparadox.repositories;

import com.codingparadox.models.Post;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

//@RepositoryRestResource(collectionResourceRel = "post", path = "post")
public interface PostRepository extends MongoRepository<Post, String>{

	//List<Post> findByLastName(@Param("author") String author);
	List<Post> findByAuthorAndContentRegex(String author, String content);
	List<Post> findByAuthor(String author);
	List<Post> findByContentRegex(String content);
}