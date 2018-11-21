package com.candidates.model;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class DocumentResponseTest {
	
	DocumentResponse documentResponse = new DocumentResponse();
	@Before
    public void setUp()  {
	
		documentResponse.setId("123456");
		documentResponse.setName("Resume.txt");
		documentResponse.setDateAdded("25-12-2012");
    }
	
	@Test
	public void idTest() {
		assertTrue(documentResponse.getId() == "123456");
	}
	
	@Test
	public void nameTest() {
		assertTrue(documentResponse.getName() == "Resume.txt");
	}

	@Test
	public void dateAddedTest() {
		assertTrue(documentResponse.getDateAdded() == "25-12-2012");
	}


}
