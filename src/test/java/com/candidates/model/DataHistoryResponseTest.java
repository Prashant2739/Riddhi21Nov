package com.candidates.model;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class DataHistoryResponseTest {
	
	DataHistoryResponse dataHistoryResponse = new DataHistoryResponse();
	@Before
    public void setUp()  {
	
		dataHistoryResponse.setStatusDataAccess(true);
		dataHistoryResponse.setStatusPortability(false);
    }
	
	@Test
	public void statusDataAccessTest() {
		assertTrue(dataHistoryResponse.isStatusDataAccess() == true);
	}
	
	@Test
	public void statusPortabilityTest() {
		assertTrue(dataHistoryResponse.isStatusPortability() == false);
	}

}
