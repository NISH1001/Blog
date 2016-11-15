package com.codingparadox;
import java.util.List;

import org.springframework.test.annotation.DirtiesContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

import com.codingparadox.BlogApplication;
import com.codingparadox.models.Post;


@ContextConfiguration(classes = BlogApplication.class)
@Test
public class BlogApplicationTests extends AbstractTestNGSpringContextTests{
	
/*	@Autowired
	private TestRestTemplate restTemplate;
*/
/*	@Test
	public void contextLoads() {
	}
*/	
	@BeforeClass
	public void testAll() throws Exception{
		System.out.println("hello");

/*		ResponseEntity<String> entity = (ResponseEntity) this.restTemplate.getForEntity("/", List.class);
		Assert.assertEquals(entity.getStatusCode(), HttpStatus.OK);

*/	
		Assert.assertEquals("hello", "hello");
	}

}
