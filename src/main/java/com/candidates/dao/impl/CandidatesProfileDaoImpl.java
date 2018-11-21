package com.candidates.dao.impl;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
/**
* @author riddhi.dilip.vyas
* @date 10/24/2018
*
* @group Accounts
* @group-content 
*
* @description: CandidatesProfileDaoImpl is a doa impl class which connect to the database and fetches records
* 
* 
*/
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

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
import com.candidates.util.CandidatesConstants;
import com.candidates.util.QueryConstants;

@Repository
public class CandidatesProfileDaoImpl extends JdbcDaoSupport implements CandidatesProfileDao{
	
	@Autowired
	DataSource dataSource;

	@PostConstruct
	private void initialize() {
		setDataSource(dataSource);
	}
	
	public CandidatesSkillResponse getCandidateSkills(String email){
		
		
		String sql = QueryConstants.GET_SKILLS;
		CandidatesSkillResponse candidatesSkillResponse = new CandidatesSkillResponse();
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql,email.toUpperCase());
		if (null != rows && !rows.isEmpty() ) {
			for (Map<String, Object> row : rows) {
				if(null != row){
					candidatesSkillResponse.setId((null == row.get(QueryConstants.COLUMN_SF_ID) ? "": (String) row.get(QueryConstants.COLUMN_SF_ID)));
					candidatesSkillResponse.setLanguage(null == row.get(QueryConstants.COLUMN_LANGUAGE) ? "": (String) row.get(QueryConstants.COLUMN_LANGUAGE));
					
				}
				
			}
		}
		return candidatesSkillResponse;
	}
	
	public List<CandidatesEducationResponse> getCandidateEducation(String email){
		String sql = QueryConstants.GET_CANDIDATES_EDUCATION;
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql,email.toUpperCase());
		List<CandidatesEducationResponse> result = new ArrayList();
		if (null != rows && !rows.isEmpty()) {
			for (Map<String, Object> row : rows) {
				if(null != row){
					CandidatesEducationResponse candidatesEducationResponse = new CandidatesEducationResponse();
					candidatesEducationResponse.setId((null == row.get(QueryConstants.COLUMN_SF_ID) ? "": (String) row.get(QueryConstants.COLUMN_SF_ID)));
					candidatesEducationResponse.setQualificationName((null == row.get(QueryConstants.COLUMN_QUALIFICATION_NAME) ? "": (String) row.get(QueryConstants.COLUMN_QUALIFICATION_NAME)));
					candidatesEducationResponse.setQualificationType((null == row.get(QueryConstants.COLUMN_QUALIFICATION_TYPE)? "": (String) row.get(QueryConstants.COLUMN_QUALIFICATION_TYPE)));
					candidatesEducationResponse.setStartYear((null == row.get(QueryConstants.COLUMN_START_DATE)? "": (String) row.get(QueryConstants.COLUMN_START_DATE)));
					candidatesEducationResponse.setEndYear((null == row.get(QueryConstants.COLUMN_END_DATE)? "": (String) row.get(QueryConstants.COLUMN_END_DATE)));
					result.add(candidatesEducationResponse);
				}
			}
		}
		return result;
	}
	
	public List<CandidateWorkExpResponse> getCandidateWorkExperiences(String email){
		
		String sql = QueryConstants.GET_WORK_EXP;
		logger.info("Email id used while fetching the records- "+email);
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql,email.toUpperCase());
		List<CandidateWorkExpResponse> result = new ArrayList();
		if (null != rows && !rows.isEmpty()) {
			for (Map<String, Object> row : rows) {
				if(null != row){
					CandidateWorkExpResponse candidateWorkExpResponse = new CandidateWorkExpResponse();
					candidateWorkExpResponse.setId((null == row.get(QueryConstants.COLUMN_SF_ID) ? "": (String) row.get(QueryConstants.COLUMN_SF_ID)));
					candidateWorkExpResponse.setCompanyName((null == row.get(QueryConstants.COLUMN_COMPANY_NAME) ? "": (String) row.get(QueryConstants.COLUMN_COMPANY_NAME)));
					candidateWorkExpResponse.setJobDescription((null == row.get(QueryConstants.COLUMN_WORK_EXP_DESC)? "": (String) row.get(QueryConstants.COLUMN_WORK_EXP_DESC)));
					candidateWorkExpResponse.setJobTitle((null == row.get(QueryConstants.COLUMN_WORK_EXP_TITLE)? "": (String) row.get(QueryConstants.COLUMN_WORK_EXP_TITLE)));
					candidateWorkExpResponse.setLocation((null == row.get(QueryConstants.COLUMN_COMPANY_LOCATION)? "": (String) row.get(QueryConstants.COLUMN_COMPANY_LOCATION)));
					candidateWorkExpResponse.setStartDate((null == row.get(QueryConstants.COLUMN_START_DATE)? "": (String) row.get(QueryConstants.COLUMN_START_DATE)));
					candidateWorkExpResponse.setEndDate((null == row.get(QueryConstants.COLUMN_END_DATE)? "": (String) row.get(QueryConstants.COLUMN_END_DATE)));
					result.add(candidateWorkExpResponse);
				}
				
			}
		}
		logger.info("------get work experiences result- "+result);
		return result;
		
	}
	
	public DataHistoryResponse getDataHistory(String email){
		
		String sql = QueryConstants.GET_DATA_HISTORY;
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql,email.toUpperCase());
		String reason = "";
		String status = "";
		DataHistoryResponse dataHistoryResponse = new DataHistoryResponse();
		if (null != rows && !rows.isEmpty()) {
			for (Map<String, Object> row : rows) {
				if(null != row){
					
					 reason = (null == row.get(QueryConstants.COLUMN_REASON) ? "": (String) row.get(QueryConstants.COLUMN_REASON));
					 status = (null == row.get(QueryConstants.COLUMN_STATUS)? "": (String) row.get(QueryConstants.COLUMN_STATUS));
					
					 logger.info("Reason - > "+reason+" status - > "+status);
					 if(reason.equalsIgnoreCase(CandidatesConstants.PORTABILITY)) {
						 dataHistoryResponse.setStatusPortability(setBooleanValue(status));
					 }else if(reason.equalsIgnoreCase(CandidatesConstants.DATA_ACCESS)){
						 dataHistoryResponse.setStatusDataAccess(setBooleanValue(status));
					 }
					
					
				}
				
			}
		}
		return dataHistoryResponse;
		
	}
	
	public GetProfileResponse getProfile(String emailId){
		
		GetProfileResponse getProfileResponse = new GetProfileResponse();
		Education education = new Education();
		WorkExperience workExperience = new WorkExperience();
		PersonalDetails personalDetails = new PersonalDetails();
		Skills skills = new Skills();
		DocumentResponse document= new DocumentResponse();
		Date utilDate;
		DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
		
		
		String sql = QueryConstants.GET_PROFILE;
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql,emailId.toUpperCase(),emailId.toUpperCase(),emailId.toUpperCase(),emailId.toUpperCase());
		logger.info(String.format("GetProfile fetched%n"));
		if (null != rows && !rows.isEmpty()) {
			for (Map<String, Object> row : rows) {
				if(null != row){
					
					document.setId((null == row.get(QueryConstants.COLUMN_DOCUMENT_ID) ? "": (String) row.get(QueryConstants.COLUMN_DOCUMENT_ID)));
					document.setName((null == row.get(QueryConstants.COLUMN_DOCUMENT_NAME) ? "": (String) row.get(QueryConstants.COLUMN_DOCUMENT_NAME)));
					utilDate = null==row.get(QueryConstants.COLUMN_DATE_ADDED) ? null: (Date) row.get(QueryConstants.COLUMN_DATE_ADDED);
					
					logger.info("Document Date added - "+utilDate);
					if(null != utilDate) {
						document.setDateAdded(df.format(utilDate));
					}else {
						document.setDateAdded("");
					}
					
					getProfileResponse.setDocument(document);
					
					education.setId((null == row.get(QueryConstants.COLUMN_EDUCATION_ID) ? "": (String) row.get(QueryConstants.COLUMN_EDUCATION_ID)));
					education.setName((null == row.get(QueryConstants.COLUMN_EDUCATION_NAME) ? "": (String) row.get(QueryConstants.COLUMN_EDUCATION_NAME)));
					
					getProfileResponse.setEducation(education);
					
					workExperience.setId((null == row.get(QueryConstants.COLUMN_EMPLOYMENT_ID) ? "": (String) row.get(QueryConstants.COLUMN_EMPLOYMENT_ID)));
					workExperience.setName((null == row.get(QueryConstants.COLUMN_EMPLOYMENT_NAME) ? "": (String) row.get(QueryConstants.COLUMN_EMPLOYMENT_NAME)));
					
					getProfileResponse.setWorkExperience(workExperience);
					
					skills.setId(null == row.get(QueryConstants.COLUMN_CONTACT_ID) ? "": (String) row.get(QueryConstants.COLUMN_CONTACT_ID));
					skills.setName(null == row.get(QueryConstants.COLUMN_CONTACT_SKILL) ? "": (String) row.get(QueryConstants.COLUMN_CONTACT_SKILL));
					
					personalDetails.setId(null == row.get(QueryConstants.COLUMN_CONTACT_ID) ? "": (String) row.get(QueryConstants.COLUMN_CONTACT_ID));
					personalDetails.setName(null == row.get(QueryConstants.COLUMN_CONTACT_NAME) ? "": (String) row.get(QueryConstants.COLUMN_CONTACT_NAME));
					
					getProfileResponse.setPersonalDetail(personalDetails);
					getProfileResponse.setSkills(skills);
					
				}
			}
		}
		
		return getProfileResponse;
	}
	
	public UnreadNotificationResponse getUnreadNotificationsCount(String email){
		
		String sql = QueryConstants.GET_OPEN_NOTIFICATIONS;
		Integer count = getJdbcTemplate().queryForObject(
                sql, new Object[] { email.toUpperCase() }, Integer.class);

		UnreadNotificationResponse unreadNotificationResponse = new UnreadNotificationResponse();
		unreadNotificationResponse.setCount(String.valueOf(count));
        return  unreadNotificationResponse;
		
	}

	private boolean setBooleanValue(String value){
		boolean result=false;
		if(!value.equals("") && value.equalsIgnoreCase(CandidatesConstants.OPEN) ){
				result = true;
		}
		return result;
	}
}
