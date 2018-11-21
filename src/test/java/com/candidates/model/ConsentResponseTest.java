package com.candidates.model;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ConsentResponseTest {

	@Test
	public void titleTest() {
		ConsentResponse consentResponse = new ConsentResponse();
		consentResponse.setTitle("Terms and Conditions");
		assertTrue(consentResponse.getTitle()=="Terms and Conditions");
	}
	
	@Test
	public void contentTest() {
		ConsentResponse consentResponse = new ConsentResponse();
		consentResponse.setContent("Markting content test");
		assertTrue(consentResponse.getContent() == "Markting content test");
	}
}
