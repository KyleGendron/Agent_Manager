package com.voice.app.Agent_Manager.domain.concrete;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestStatsRecordHibernate {
	private static StatsRecordHibernate changedRecord;
	private static StatsRecordHibernate unchangedRecord;
	private static String[] input = {"2/1/2017","John Doe", "Sam's Club",
			"6.14888888888888","1.20722222222222", "0.390833333333333",
			"0.189999999999999", "5.44166666666666", "97", "15.7752078062884",
			"8", "1.30104806649801", "0.138856746123583", "4.48333333333333"};
	
	@BeforeClass
	//separate instances created in case tests are not executed in order
	   public static void setUpBeforeClass() throws Exception {
		changedRecord = new StatsRecordHibernate(input);
		unchangedRecord = new StatsRecordHibernate(input);
	}
	
	//Test getters
	
	@Test
	public void testGetDate(){
		assertEquals("Original date does not equal stored date.", "2/1/2017", unchangedRecord.getDate());
	}
	
	@Test
	public void testGetAgent(){
		assertEquals("Original agent does not equal stored agent.", "John Doe", unchangedRecord.getAgent());
	}
	
	@Test
	public void testGetCampaign(){
		assertEquals("Original campaign does not equal stored campaign.", "Sam's Club", unchangedRecord.getCampaign());
	}
	
	@Test
	public void testGetLoggedHours(){
		assertEquals("Original logged hours does not equal stored logged hours.", 6.14888888888888, unchangedRecord.getLoggedHours(),0);
	}
	
	@Test
	public void testGetBreakHours(){
		assertEquals("Original break hours does not equal stored break hours.", 1.20722222222222, unchangedRecord.getBreakHours(),0);
	}
	
	@Test
	public void testGetFollowUpHours(){
		assertEquals("Original follow-up hours does not equal stored follow-up hours.", 0.390833333333333, unchangedRecord.getFollowUpHours(),0);
	}
	
	@Test
	public void testGetMeetTrainHours(){
		assertEquals("Original meeting and training hours does not equal stored meeting and training hours.", 0.189999999999999, unchangedRecord.getMeetTrainHours(),0);
	}
	
	@Test
	public void testGetHoursMinusExcessBreak(){
		assertEquals("Original hours minus excess break does not equal stored hours minus excess break.", 5.44166666666666, unchangedRecord.getHoursMinusExcessBreak(),0);
	}
	
	@Test
	public void testGetCallsMade(){
		assertEquals("Original calls made does not equal stored calls made.", 97, unchangedRecord.getCallsMade());
	}
	
	@Test
	public void testGetCallsPerHour(){
		assertEquals("Original calls per hour does not equal stored calls per hour.", 15.7752078062884, unchangedRecord.getCallsPerHour(),0);
	}
	
	@Test
	public void testGetContacts(){
		assertEquals("Original contacts does not equal stored contacts.", 8, unchangedRecord.getContacts());
	}
	
	@Test
	public void testGetContactsPerHour(){
		assertEquals("Original contacts per hour does not equal stored contacts per hour.", 1.30104806649801, unchangedRecord.getContactsPerHour(),0);
	}
	
	@Test
	public void testGetLeadsPerHour(){
		assertEquals("Original leads per hour does not equal stored leads per hour.", 0.138856746123583, unchangedRecord.getLeadsPerHour(),0);
	}
	
	@Test
	public void testGetFollowUpMinutesPerLead(){
		assertEquals("Original follow-up minutes per lead does not equal stored follow-up minutes per lead.", 4.48333333333333, unchangedRecord.getFollowUpMinutesPerLead(),0);
	}
	
	//Test setters
	
	@Test
	public void testSetDate(){
		String date = "2/2/2017";
		changedRecord.setDate(date);
		assertEquals("Set date does not equal stored date.", date, changedRecord.getDate());
	}
	
	@Test
	public void testSetAgent(){
		String agent = "Jane Doe";
		changedRecord.setAgent(agent);
		assertEquals("Set agent does not equal stored agent.", agent, changedRecord.getAgent());
	}
	
	@Test
	public void testSetCampaign(){
		String campaign = "Bristol Pay";
		changedRecord.setCampaign(campaign);
		assertEquals("Set campaign does not equal stored campaign.", campaign, changedRecord.getCampaign());
	}
	
	@Test
	public void testSetLoggedHours(){
		double loggedHours = 6.5;
		changedRecord.setLoggedHours(loggedHours);
		assertEquals("Set logged hours does not equal stored logged hours.", loggedHours, changedRecord.getLoggedHours(),0);
	}
	
	@Test
	public void testSetBreakHours(){
		double breakHours = 0.25;
		changedRecord.setBreakHours(breakHours);
		assertEquals("Set break hours does not equal stored break hours.", breakHours, changedRecord.getBreakHours(),0);
	}
	
	@Test
	public void testSetFollowUpHours(){
		double followUpHours = 0.5;
		changedRecord.setFollowUpHours(followUpHours);
		assertEquals("Set follow-up hours does not equal stored follow-up hours.", followUpHours, changedRecord.getFollowUpHours(),0);
	}
	
	@Test
	public void testSetMeetTrainHours(){
		double meetTrainHours = 1.5;
		changedRecord.setMeetTrainHours(meetTrainHours);
		assertEquals("Set meeting and training hours does not equal stored meeting and training hours.", meetTrainHours, changedRecord.getMeetTrainHours(),0);
	}
	
	@Test
	public void testSetHoursMinusExcessBreak(){
		double hoursMinusExcessBreak = 6.5;
		changedRecord.setHoursMinusExcessBreak(hoursMinusExcessBreak);
		assertEquals("Set hours minus excess break does not equal stored hours minus excess break.", hoursMinusExcessBreak, changedRecord.getHoursMinusExcessBreak(),0);
	}
	
	@Test
	public void testSetCallsMade(){
		int callsMade = 150;
		changedRecord.setCallsMade(callsMade);
		assertEquals("Set calls made does not equal stored calls made.", callsMade, changedRecord.getCallsMade());
	}
	
	@Test
	public void testSetCallsPerHour(){
		double callsPerHour = 23.037;
		changedRecord.setCallsPerHour(callsPerHour);
		assertEquals("Set calls per hour does not equal stored calls per hour.", callsPerHour, changedRecord.getCallsPerHour(),0);
	}
	
	@Test
	public void testSetContacts(){
		int contacts = 25;
		changedRecord.setContacts(contacts);
		assertEquals("Set contacts does not equal stored contacts.", contacts, changedRecord.getContacts());
	}
	
	@Test
	public void testSetContactsPerHour(){
		double contactsPerHour = 3.846;
		changedRecord.setContactsPerHour(contactsPerHour);
		assertEquals("Set contacts per hour does not equal stored contacts per hour.", contactsPerHour, changedRecord.getContactsPerHour(),0);
	}
	
	@Test
	public void testSetLeadsPerHour(){
		double leadsPerHour = 0.158;
		changedRecord.setLeadsPerHour(leadsPerHour);
		assertEquals("Set leads per hour does not equal stored leads per hour.", leadsPerHour, changedRecord.getLeadsPerHour(),0);
	}
	
	@Test
	public void testSetFollowUpMinutesPerLead(){
		double followUpMinutesPerLead = 6.985;
		changedRecord.setFollowUpMinutesPerLead(followUpMinutesPerLead);
		assertEquals("Set follow-up minutes per lead does not equal stored follow-up minutes per lead.", followUpMinutesPerLead, changedRecord.getFollowUpMinutesPerLead(),0);
	}
}
