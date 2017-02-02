package com.voice.app.Agent_Manager.domain.concrete;

import static org.junit.Assert.assertEquals;
import org.junit.*;

public class TestLeadRecordHibernate {
	
	private static LeadRecordHibernate record;
	private static String[] input = {"1/31/2017","F","John Doe","003A000000fZJzxIAG",
			"001A000000W90b8IAB", "Q1 2017 Voice B2B Campaign",
			"Blood and Guts OB/GYN","5556278924","x","Registered",
			"Registered","$1.50","No notes in Five9."};
	
	@Before
	public void setUp(){
		//just in case tests aren't executed in a specific order
		record = new LeadRecordHibernate(input);
	}
	
	//Test getters
	
	@Test
	public void testGetDate(){
		assertEquals("Original date does not equal stored date.", "1/31/2017", record.getDate());
	}
	
	@Test
	public void testGetDialer(){
		assertEquals("Original dialer does not equal stored dialer.", "F", record.getDialer());
	}
	
	@Test
	public void testGetAgent(){
		assertEquals("Original agent does not equal stored agent.", "John Doe", record.getAgent());
	}
	
	@Test
	public void testGetCOID(){
		assertEquals("Original COID does not equal stored COID.", "003A000000fZJzxIAG", record.getCOID());
	}
	
	@Test
	public void testGetAID(){
		assertEquals("Original AID does not equal stored AID.", "001A000000W90b8IAB", record.getAID());
	}
	
	@Test
	public void testGetCampaign(){
		assertEquals("Original campaign does not equal stored campaign.", "Q1 2017 Voice B2B Campaign", record.getCampaign());
	}
	
	@Test
	public void testGetCompany(){
		assertEquals("Original company does not equal stored company.", "Blood and Guts OB/GYN", record.getCompany());
	}
	
	@Test
	public void testGetPhone(){
		assertEquals("Original phone does not equal stored phone.", "5556278924", record.getPhone());
	}
	
	@Test
	public void testGetIncludedOnOF(){
		assertEquals("Original included on OF does not equal stored included on OF.", true, record.getIncludedOnOF());
	}
	
	@Test
	public void testGetSubmittedAs(){
		assertEquals("Original Submitted As does not equal stored Submitted As.", "Registered", record.getSubmittedAs());
	}
	
	@Test
	public void testGetPassedType(){
		assertEquals("Original Passed Type does not equal stored Passed Type.", "Registered", record.getPassedType());
	}
	
	@Test
	public void testGetIncentiveValue(){
		assertEquals("Original Incentive Value does not equal stored Incentive Value.", 1.5, record.getIncentiveValue(), 0);
	}
	
	@Test
	public void testGetCoachingNotes(){
		assertEquals("Original Coaching Notes does not equal stored Coaching Notes.", "No notes in Five9.", record.getCoachingNotes());
	}
	
	//Test setters
	
	@Test
	public void testSetDate(){
		String date = "1/30/2017";
		record.setDate(date);
		assertEquals("Original date does not equal stored date.", date, record.getDate());
	}
	
	@Test
	public void testSetDialer(){
		String dialer = "T";
		record.setDialer(dialer);
		assertEquals("Original dialer does not equal stored dialer.", dialer, record.getDialer());
	}
	
	@Test
	public void testSetAgent(){
		String agent = "Jane Doe";
		record.setAgent(agent);
		assertEquals("Original agent does not equal stored agent.", agent, record.getAgent());
	}
	
	@Test
	public void testSetCOID(){
		String cOID = "1234lkj536lkj3245";
		record.setCOID(cOID);
		assertEquals("Original COID does not equal stored COID.", cOID, record.getCOID());
	}
	
	@Test
	public void testSetAID(){
		String aID = "lk32546j48hk5kj";
		record.setAID(aID);
		assertEquals("Original AID does not equal stored AID.", aID, record.getAID());
	}
	
	@Test
	public void testSetCampaign(){
		String campaign = "Q1 2017 Bagel Sales";
		record.setCampaign(campaign);
		assertEquals("Original campaign does not equal stored campaign.", campaign, record.getCampaign());
	}
	
	@Test
	public void testSetCompany(){
		String company = "High Error Margin Analysis Consultants";
		record.setCompany(company);
		assertEquals("Original company does not equal stored company.", company, record.getCompany());
	}
	
	@Test
	public void testSetPhone(){
		String phone = "2078967272";
		record.setPhone(phone);
		assertEquals("Original phone does not equal stored phone.", phone, record.getPhone());
	}
	
	@Test
	public void testSetIncludedOnOF(){
		boolean includedOnOF = false;
		record.setIncludedOnOF(includedOnOF);
		assertEquals("Original included on OF does not equal stored included on OF.", includedOnOF, record.getIncludedOnOF());
	}
	
	@Test
	public void testSetSubmittedAs(){
		String submittedAs = "Booth Demo Booked";
		record.setSubmittedAs(submittedAs);
		assertEquals("Original Submitted As does not equal stored Submitted As.", submittedAs, record.getSubmittedAs());
	}
	
	@Test
	public void testSetPassedType(){
		String passedType = "Booth Demo Booked";
		record.setPassedType(passedType);
		assertEquals("Original Passed Type does not equal stored Passed Type.", passedType, record.getPassedType());
	}
	
	@Test
	public void testSetIncentiveValue(){
		double incentiveValue = 5.00;
		record.setIncentiveValue(incentiveValue);
		assertEquals("Original Incentive Value does not equal stored Incentive Value.", incentiveValue, record.getIncentiveValue(), 0);
	}
	
	@Test
	public void testSetCoachingNotes(){
		String coachingNotes = "Nevermind.";
		record.setCoachingNotes(coachingNotes);
		assertEquals("Original Coaching Notes does not equal stored Coaching Notes.", coachingNotes, record.getCoachingNotes());
	}
}
