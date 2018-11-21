package com.candidates.model;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CandidatesEducationResponseTest {

	 @Test
	    public void testSetId() {
		 CandidatesEducationResponse card = new CandidatesEducationResponse();
	        card.setId("089");
	        assertTrue(card.getId() == "089");
	    }
	 
	 @Test
	    public void testQualificationType() {
		 CandidatesEducationResponse card = new CandidatesEducationResponse();
	        card.setQualificationType("Masters");
	        assertTrue(card.getQualificationType() == "Masters");
	    }
	 
	 @Test
	    public void testSetQualificationName() {
		 CandidatesEducationResponse card = new CandidatesEducationResponse();
	        card.setQualificationName("MS");
	        assertTrue(card.getQualificationName()== "MS");
	    }
	 
	 @Test
	    public void testStartYear() {
		 CandidatesEducationResponse card = new CandidatesEducationResponse();
	        card.setStartYear("25-11-1989");
	        assertTrue(card.getStartYear() == "25-11-1989");
	    }
	 
	 @Test
	    public void testEndYear() {
		 CandidatesEducationResponse card = new CandidatesEducationResponse();
	        card.setEndYear("25-11-1989");
	        assertTrue(card.getEndYear() == "25-11-1989");
	    }
}
