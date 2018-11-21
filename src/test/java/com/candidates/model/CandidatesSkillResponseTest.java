package com.candidates.model;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CandidatesSkillResponseTest {
	

	 @Test
	    public void testId() {
		 CandidatesSkillResponse skills = new CandidatesSkillResponse();
		 skills.setId("089");
	        assertTrue(skills.getId() == "089");
	    }
	 
	 @Test
	    public void testLanguage() {
		 CandidatesSkillResponse skills = new CandidatesSkillResponse();
		 skills.setLanguage("Eng;French");
	        assertTrue(skills.getLanguage() == "Eng;French");
	    }
	 
	
}
