package com.candidates.model;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CheckUnicityRequestTest {

	@Test
	public void testEmail() {
		CheckUnicityRequest checkUnicityRequest = new CheckUnicityRequest();
		checkUnicityRequest.setEmail("test@gmail.com");
		assertTrue(checkUnicityRequest.getEmail() == "test@gmail.com");
	}

}
