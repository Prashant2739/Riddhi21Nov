package com.candidates.model;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CandidateWorkExpResponseTest {

	
	 @Test
	    public void testId() {
		 CandidateWorkExpResponse workExp = new CandidateWorkExpResponse();
		 workExp.setId("089");
	        assertTrue(workExp.getId() == "089");
	    }
	 
	 @Test
	    public void testComanyName() {
		 CandidateWorkExpResponse workExp = new CandidateWorkExpResponse();
		 workExp.setCompanyName("Accenture");
	        assertTrue(workExp.getCompanyName() == "Accenture");
	    }
	 
	 @Test
	    public void testJobTitle() {
		 CandidateWorkExpResponse workExp = new CandidateWorkExpResponse();
		 workExp.setJobTitle("Developer");
	        assertTrue(workExp.getJobTitle() == "Developer");
	    }
	 
	 @Test
	    public void testLocation() {
		 CandidateWorkExpResponse workExp = new CandidateWorkExpResponse();
		 workExp.setLocation("USA");
	        assertTrue(workExp.getLocation() == "USA");
	    }
	 
	 @Test
	    public void testStartYear() {
		 CandidateWorkExpResponse workExp = new CandidateWorkExpResponse();
		 workExp.setStartDate("25-11-1989");
	        assertTrue(workExp.getStartDate() == "25-11-1989");
	    }
	 
	 @Test
	    public void testEndYear() {
		 CandidateWorkExpResponse workExp = new CandidateWorkExpResponse();
		 workExp.setEndDate("25-11-1989");
	        assertTrue(workExp.getEndDate() == "25-11-1989");
	    }
	 
	 @Test
	    public void testLanguage() {
		 CandidateWorkExpResponse workExp = new CandidateWorkExpResponse();
		 workExp.setJobDescription("Developer at Accenture");
	        assertTrue(workExp.getJobDescription() == "Developer at Accenture");
	    }
	 
	 
}
