package com.example.demo.controllers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@ExtendWith(SpringExtension.class)
@WebMvcTest(HelloController.class)
class HelloControllerIntTests {

	@Autowired
	private MockMvc mvc;

	@DisplayName("hello Test")
	@Test
	void hello() throws Exception {
		RequestBuilder requestBuilder = get("/hello");
		MvcResult result = mvc.perform(requestBuilder).andReturn();

		assertEquals("Hello, World!", result.getResponse().getContentAsString());
	}

	@DisplayName("testHelloWithName Test")
	@Test
	void testHelloWithName() throws Exception {
		mvc.perform(get("/hello?name=Dan"))
				.andExpect(content().string("Hello, Dan!"));
	}

	@DisplayName("testHelloWithName2 Test")
	@Test
	void testHelloWithName2() throws Exception {
		RequestBuilder requestBuilder = get("/hello?name=Dan");
		MvcResult result = mvc.perform(requestBuilder).andReturn();

		assertEquals("Hello, Dan!", result.getResponse().getContentAsString());
	}

	@DisplayName("goodbye Test")
	@Test
	void goodbye() throws Exception {
		RequestBuilder requestBuilder = get("/goodbye");
		MvcResult result = mvc.perform(requestBuilder).andReturn();

		assertEquals("Goodbye, World!", result.getResponse().getContentAsString());
	}

	@DisplayName("checkName Test")
	@Test
	void checkName() throws Exception {
		RequestBuilder requestBuilder = get("/checkname");
		MvcResult result = mvc.perform(requestBuilder).andReturn();

		assertEquals("Your name is, World!", result.getResponse().getContentAsString());
	}

	@DisplayName("root Test")
	@Test
	void home() throws Exception {
		RequestBuilder requestBuilder = get("/");
		MvcResult result = mvc.perform(requestBuilder).andReturn();

		assertEquals("Welcome at home, Nobody!", result.getResponse().getContentAsString());
	}

}
