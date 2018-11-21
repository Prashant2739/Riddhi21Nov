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

import com.candidates.dao.CandidatesDao;
import com.candidates.dao.CandidatesProfileDao;
import com.candidates.model.CandidatesSkillResponse;
import com.candidates.model.ConsentResponse;
import com.candidates.model.GetProfileResponse;
import com.candidates.service.impl.CandidatesProfileServiceImpl;
import com.candidates.service.impl.CandidatesServiceImpl;

@RunWith(SpringRunner.class)
public class CandidateServiceImplIntegrationTest {
	
	@TestConfiguration
    static class  CandidateProfileImplTestContextConfiguration {
  
        @Bean
        public CandidatesService candidatesProfileService() {
            return new CandidatesServiceImpl();
        }
    }

	@Autowired
    private CandidatesService candidatesService;
 
    @MockBean
    private CandidatesDao candidatesDao;
    
    @Before
    public void setUp() {
    	List<ConsentResponse> consentResponseList = new ArrayList();
    	ConsentResponse consentResponse = new ConsentResponse();
    	consentResponse.setContent("Marketing conditions content");
    	consentResponse.setTitle("Marketing");
    	consentResponseList.add(consentResponse);
        Mockito.when(candidatesDao.getConditions("France", "Adecco", "fr"))
          .thenReturn(consentResponseList);
        
        Mockito.when(candidatesDao.postCheckUnicity("test123@gmail.com", "Adecoo"))
        .thenReturn(true);
    }
    
    @Test
    public void testConditions() {
    	List<ConsentResponse> consentResponseList =  candidatesService.getConditions("France", "Adecco", "fr");
      
         assertEquals(1,consentResponseList.size());
     }
    
    @Test
    public void testCheckUnicity() {
        String email = "test123@gmail.com";
        boolean unicityFlag  = candidatesService.postCheckUnicity(email, "Adecoo");
      
         assertEquals(true,unicityFlag);
     }
}
