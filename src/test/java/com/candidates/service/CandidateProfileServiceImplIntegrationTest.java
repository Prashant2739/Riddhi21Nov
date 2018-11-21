package com.candidates.service;



import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.candidates.dao.CandidatesProfileDao;
import com.candidates.model.CandidateWorkExpResponse;
import com.candidates.model.CandidatesEducationResponse;
import com.candidates.model.CandidatesSkillResponse;
import com.candidates.model.DataHistoryResponse;
import com.candidates.model.DocumentResponse;
import com.candidates.model.Education;
import com.candidates.model.GetProfileResponse;
import com.candidates.model.PersonalDetails;
import com.candidates.model.Skills;
import com.candidates.model.UnreadNotificationResponse;
import com.candidates.model.WorkExperience;
import com.candidates.service.impl.CandidatesProfileServiceImpl;

@RunWith(SpringRunner.class)
public class CandidateProfileServiceImplIntegrationTest {

	@TestConfiguration
    static class  CandidateProfileImplTestContextConfiguration {
  
        @Bean
        public CandidatesProfileService candidatesProfileService() {
            return new CandidatesProfileServiceImpl();
        }
    }
	
	@Autowired
    private CandidatesProfileService candidatesProfileService;
 
    @MockBean
    private CandidatesProfileDao candidatesProfileDao;
    
    @Before
    public void setUp() {
    	CandidatesSkillResponse candidatesSkillResponse = new CandidatesSkillResponse();
    	candidatesSkillResponse.setId("123");
    	candidatesSkillResponse.setLanguage("Eng");
     
        Mockito.when(candidatesProfileDao.getCandidateSkills("test123@gmail.com"))
          .thenReturn(candidatesSkillResponse);
        
        List<CandidatesEducationResponse> educationList = new ArrayList();
        CandidatesEducationResponse candidatesEducationResponse = new CandidatesEducationResponse();
        candidatesEducationResponse.setId("123456");
        candidatesEducationResponse.setQualificationName("Btech");
        candidatesEducationResponse.setQualificationType("Graduate");
        candidatesEducationResponse.setStartYear("25-11-2000");
        candidatesEducationResponse.setEndYear("25-11-2004");
        educationList.add(candidatesEducationResponse);
        
        Mockito.when(candidatesProfileDao.getCandidateEducation("test123@gmail.com"))
        .thenReturn(educationList);
        
        List<CandidateWorkExpResponse> workExpList = new ArrayList();
        CandidateWorkExpResponse candidateWorkExpResponse = new CandidateWorkExpResponse();
        candidateWorkExpResponse.setCompanyName("Adecco");
        candidateWorkExpResponse.setId("123456");
        candidateWorkExpResponse.setJobDescription("Developer at Adecco");
        candidateWorkExpResponse.setJobTitle("Developer");
        candidateWorkExpResponse.setLocation("USA");
        candidateWorkExpResponse.setStartDate("25-11-2017");
        candidateWorkExpResponse.setEndDate("25-11-2018");
        workExpList.add(candidateWorkExpResponse);
        
        Mockito.when(candidatesProfileDao.getCandidateWorkExperiences("test123@gmail.com"))
        .thenReturn(workExpList);
        
        UnreadNotificationResponse unreadNotificationResponse = new UnreadNotificationResponse();
        unreadNotificationResponse.setCount("3");
        
        Mockito.when(candidatesProfileDao.getUnreadNotificationsCount("test123@gmail.com"))
        .thenReturn(unreadNotificationResponse);
        
        DocumentResponse documentResponse = new DocumentResponse();
        documentResponse.setDateAdded("23-Nov-2018");
        documentResponse.setId("123456");
        documentResponse.setName("Resume.docx");
        
        PersonalDetails personalDetails = new PersonalDetails();
        personalDetails.setId("1234");
        personalDetails.setName("Adecco Test User");
        
        Education education =new Education();
        education.setId("2345");
        education.setName("2345");
        
        Skills skills = new Skills();
        skills.setId("2344");
        skills.setName("Eng,French");
        
        WorkExperience workExperience = new WorkExperience ();
        
        
        GetProfileResponse getProfileResponse = new GetProfileResponse();
        getProfileResponse.setDocument(documentResponse);
        getProfileResponse.setEducation(education);
        getProfileResponse.setPersonalDetail(personalDetails);
        getProfileResponse.setSkills(skills);
        getProfileResponse.setWorkExperience(workExperience);
        
        Mockito.when(candidatesProfileDao.getProfile("test123@gmail.com"))
        .thenReturn(getProfileResponse);
        
        DataHistoryResponse dataHistoryResponse = new DataHistoryResponse();
        dataHistoryResponse.setStatusDataAccess(true);
        dataHistoryResponse.setStatusPortability(false);
        
        Mockito.when(candidatesProfileDao.getDataHistory("test123@gmail.com"))
        .thenReturn(dataHistoryResponse);
        
    }
    
    @Test
    public void testCandidateSkills() {
        String email = "test123@gmail.com";
        CandidatesSkillResponse candidatesSkillResponse = candidatesProfileService.getCandidateSkills(email);
      
         assertEquals("Eng",candidatesSkillResponse.getLanguage());
     }
    
    @Test
    public void testCandidateEducation() {
        String email = "test123@gmail.com";
        List<CandidatesEducationResponse> educationList = candidatesProfileService.getCandidateEducation(email);
      
         assertEquals(1,educationList.size());
     }
    
    @Test
    public void testCandidateWorkExp() {
        String email = "test123@gmail.com";
        List<CandidateWorkExpResponse> workExpList = candidatesProfileService.getCandidateWorkExperiences(email);
      
         assertEquals(1,workExpList.size());
     }
    
    @Test
    public void testNotification() {
        String email = "test123@gmail.com";
        UnreadNotificationResponse unreadNotificationResponse = candidatesProfileService.getUnreadNotificationsCount(email);
      
         assertEquals("3",unreadNotificationResponse.getCount());
     }
    
    @Test
    public void testCandidateProfile() {
        String email = "test123@gmail.com";
        GetProfileResponse getProfileResponse  = candidatesProfileService.getProfile(email);
      
         assertEquals("1234",getProfileResponse.getPersonalDetail().getId());
     }
    
    @Test
    public void testCandidateDataHistory() {
        String email = "test123@gmail.com";
        DataHistoryResponse dataHistoryResponse  = candidatesProfileService.getDataHistory(email);
      
         assertEquals(true,dataHistoryResponse.isStatusDataAccess());
         assertEquals(false,dataHistoryResponse.isStatusPortability());
     }
}
