package com.candidates.model;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CheckUnicityResponseTest {


	@Test
	public void successTest() {
		CheckUnicityResponse checkUnicityResponse = new CheckUnicityResponse();
		checkUnicityResponse.setSuccess(true);
		assertTrue(checkUnicityResponse.isSuccess() == true);
	}
}
