package com.codingparadox;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

import io.restassured.RestAssured;

@ContextConfiguration(classes = BlogApplication.class)
@Test
public class BaseTest extends AbstractTestNGSpringContextTests {
	
	@BeforeClass
	public void setup(){
		System.out.println("*********************** BaseTest ****");
		System.out.println("*********************** setup() ****");

		String port = System.getProperty("server.port");
		
		if(port == null){
			RestAssured.port = 8080;
		}
		else{
			RestAssured.port = Integer.valueOf(port);
		}
		
		String basePath = System.getProperty("server.base");
		if(basePath == null){
			basePath = "/posts";
		}
		
		RestAssured.basePath = basePath;
		
		String baseHost = System.getProperty("server.host");
		if(baseHost == null){
			baseHost = "http://localhost";
		}

		RestAssured.baseURI = baseHost;
	}
	
/*	@Test
	public void test(){
		System.out.println("******************** test() *******");
	}
*/}



