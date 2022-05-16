package com.example.demo.controllers;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelloControllerTests {

	HelloController controller;

	@BeforeAll
	public static void init() {
		System.out.println("Before All init() method called. The tests are starts.");
	}

	@DisplayName("Test hello")
	@Test
	void hello() {
		controller = new HelloController(); // Arrange
		String response = controller.hello("World"); // Act

		assertEquals("Hello, World!", response); // Assert
	}

	@DisplayName("Test goodbye")
	@Test
	void goodbye() {
		controller = new HelloController(); // Arrange
		String response = controller.goodbye("World"); // Act

		assertEquals("Goodbye, World!", response); // Assert
	}

	@DisplayName("Test checkName")
	@Test
	void checkName() {
		controller = new HelloController(); // Arrange
		String response = controller.checkName("World"); // Act

		assertEquals("Your name is, World!", response); // Assert
	}

}
