package com.voice.app.Agent_Manager.domain.concrete;

import static org.junit.Assert.assertEquals;
import org.junit.*;

public class TestLeadRecordHibernate {
	
	private static LeadRecordHibernate recordUnchanged, recordChanged;
	private static String[] input = {"1/31/2017","F","John Doe","003A000000fZJzxIAG",
			"001A000000W90b8IAB", "Q1 2017 Voice B2B Campaign",
			"Blood and Guts OB/GYN","5556278924","x","Registered",
			"Registered","$1.50","No notes in Five9."};
	
	@BeforeClass
	   public static void setUpBeforeClass() throws Exception {
		recordUnchanged = new LeadRecordHibernate(input);
		recordChanged = new LeadRecordHibernate(input);
	}
	
	//Test getters
	
	@Test
	public void testGetDate(){
		assertEquals("Original date does not equal stored date.", "1/31/2017", recordUnchanged.getDate());
	}
	
	@Test
	public void testGetDialer(){
		assertEquals("Original dialer does not equal stored dialer.", "F", recordUnchanged.getDialer());
	}
	
	@Test
	public void testGetAgent(){
		assertEquals("Original agent does not equal stored agent.", "John Doe", recordUnchanged.getAgent());
	}
	
	@Test
	public void testGetCOID(){
		assertEquals("Original COID does not equal stored COID.", "003A000000fZJzxIAG", recordUnchanged.getCOID());
	}
	
	@Test
	public void testGetAID(){
		assertEquals("Original AID does not equal stored AID.", "001A000000W90b8IAB", recordUnchanged.getAID());
	}
	
	@Test
	public void testGetCampaign(){
		assertEquals("Original campaign does not equal stored campaign.", "Q1 2017 Voice B2B Campaign", recordUnchanged.getCampaign());
	}
	
	@Test
	public void testGetCompany(){
		assertEquals("Original company does not equal stored company.", "Blood and Guts OB/GYN", recordUnchanged.getCompany());
	}
	
	@Test
	public void testGetPhone(){
		assertEquals("Original phone does not equal stored phone.", "5556278924", recordUnchanged.getPhone());
	}
	
	@Test
	public void testGetIncludedOnOF(){
		assertEquals("Original included on OF does not equal stored included on OF.", true, recordUnchanged.getIncludedOnOF());
	}
	
	@Test
	public void testGetSubmittedAs(){
		assertEquals("Original Submitted As does not equal stored Submitted As.", "Registered", recordUnchanged.getSubmittedAs());
	}
	
	@Test
	public void testGetPassedType(){
		assertEquals("Original Passed Type does not equal stored Passed Type.", "Registered", recordUnchanged.getPassedType());
	}
	
	@Test
	public void testGetIncentiveValue(){
		assertEquals("Original Incentive Value does not equal stored Incentive Value.", 1.5, recordUnchanged.getIncentiveValue(), 0);
	}
	
	@Test
	public void testGetCoachingNotes(){
		assertEquals("Original Coaching Notes does not equal stored Coaching Notes.", "No notes in Five9.", recordUnchanged.getCoachingNotes());
	}
	
	//Test setters
	
	@Test
	public void testSetDate(){
		String date = "1/30/2017";
		recordChanged.setDate(date);
		assertEquals("Original date does not equal stored date.", date, recordChanged.getDate());
	}
	
	@Test
	public void testSetDialer(){
		String dialer = "T";
		recordChanged.setDialer(dialer);
		assertEquals("Original dialer does not equal stored dialer.", dialer, recordChanged.getDialer());
	}
	
	@Test
	public void testSetAgent(){
		String agent = "Jane Doe";
		recordChanged.setAgent(agent);
		assertEquals("Original agent does not equal stored agent.", agent, recordChanged.getAgent());
	}
	
	@Test
	public void testSetCOID(){
		String cOID = "1234lkj536lkj3245";
		recordChanged.setCOID(cOID);
		assertEquals("Original COID does not equal stored COID.", cOID, recordChanged.getCOID());
	}
	
	@Test
	public void testSetAID(){
		String aID = "lk32546j48hk5kj";
		recordChanged.setAID(aID);
		assertEquals("Original AID does not equal stored AID.", aID, recordChanged.getAID());
	}
	
	@Test
	public void testSetCampaign(){
		String campaign = "Q1 2017 Bagel Sales";
		recordChanged.setCampaign(campaign);
		assertEquals("Original campaign does not equal stored campaign.", campaign, recordChanged.getCampaign());
	}
	
	@Test
	public void testSetCompany(){
		String company = "High Error Margin Analysis Consultants";
		recordChanged.setCompany(company);
		assertEquals("Original company does not equal stored company.", company, recordChanged.getCompany());
	}
	
	@Test
	public void testSetPhone(){
		String phone = "2078967272";
		recordChanged.setPhone(phone);
		assertEquals("Original phone does not equal stored phone.", phone, recordChanged.getPhone());
	}
	
	@Test
	public void testSetIncludedOnOF(){
		boolean includedOnOF = false;
		recordChanged.setIncludedOnOF(includedOnOF);
		assertEquals("Original included on OF does not equal stored included on OF.", includedOnOF, recordChanged.getIncludedOnOF());
	}
	
	@Test
	public void testSetSubmittedAs(){
		String submittedAs = "Booth Demo Booked";
		recordChanged.setSubmittedAs(submittedAs);
		assertEquals("Original Submitted As does not equal stored Submitted As.", submittedAs, recordChanged.getSubmittedAs());
	}
	
	@Test
	public void testSetPassedType(){
		String passedType = "Booth Demo Booked";
		recordChanged.setPassedType(passedType);
		assertEquals("Original Passed Type does not equal stored Passed Type.", passedType, recordChanged.getPassedType());
	}
	
	@Test
	public void testSetIncentiveValue(){
		double incentiveValue = 5.00;
		recordChanged.setIncentiveValue(incentiveValue);
		assertEquals("Original Incentive Value does not equal stored Incentive Value.", incentiveValue, recordChanged.getIncentiveValue(), 0);
	}
	
	@Test
	public void testSetCoachingNotes(){
		String coachingNotes = "Nevermind.";
		recordChanged.setCoachingNotes(coachingNotes);
		assertEquals("Original Coaching Notes does not equal stored Coaching Notes.", coachingNotes, recordChanged.getCoachingNotes());
	}
}
