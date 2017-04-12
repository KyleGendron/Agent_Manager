package com.voice.app.Agent_Manager.dao.concrete;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.voice.app.Agent_Manager.dao.factory.DAOFactoryHibernate;
import com.voice.app.Agent_Manager.domain.concrete.LeadRecord;

public class TestLeadRecordDAOHibernate {
	//several copies created for use in different tests,
	//in case tests aren't executed in order
	private static LeadRecord addLead, findLead, removeLead,
		listLead, updateLead, distinctLead;
	private static String[] input = {"1/31/2017","F","John Doe","003A000000fZJzxIAG",
			"001A000000W90b8IAB", "Q1 2017 Voice B2B Campaign",
			"Blood and Guts OB/GYN","5556278924","x","Registered",
			"Registered","$1.50","No notes in Five9."};
	private static DAOFactoryHibernate factory = new DAOFactoryHibernate();
	private static int addID, findID, listID, updateID, distinctID;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		addLead = new LeadRecord(input);
		findLead = new LeadRecord(input);
		removeLead = new LeadRecord(input);
		listLead = new LeadRecord(input);
		updateLead = new LeadRecord(input);
		distinctLead = new LeadRecord(input);
	}
	
	@Test
	public void testAdd(){
		addID = factory.getLeadDAO().add(0, addLead);
		assertNotNull("Leadrecord was not added successfully.", addID);
	}
	
	@Test
	public void testFind(){
		findID = factory.getLeadDAO().add(0, findLead);
		assertNotNull("Leadrecord was not found successfully.", factory.getLeadDAO().find(findID));
	}
	
	@Test
	public void testRemove(){
		int removeID = factory.getLeadDAO().add(0, removeLead);
		factory.getLeadDAO().remove(removeID);
		assertNull("Leadrecord was not removed.", factory.getLeadDAO().find(removeID));
	}
	
	@Test
	public void testList(){
		listID = factory.getLeadDAO().add(0, listLead);
		List<LeadRecord> list = factory.getLeadDAO().list();
		assertTrue("The list was empty.", list.size() > 0);
	}
	
	@Test
	public void testUpdate(){
		updateID = factory.getLeadDAO().add(0, updateLead);
		LeadRecord updatedLead = 
				(LeadRecord) factory.getLeadDAO().find(updateID);
		updatedLead.setAgent("Jane Doe");
		factory.getLeadDAO().update(0, updatedLead);
		assertEquals("Leadrecord not updated.", "Jane Doe", factory.getLeadDAO().find(updateID).getAgent());
	}
	
	@Test
	public void testGetDistinctValues(){
		distinctID = factory.getLeadDAO().add(0, distinctLead);
		assertTrue("No values were found.", !(factory.getLeadDAO().getDistinctValues("agent")).isEmpty());
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		factory.getLeadDAO().remove(addID);
		factory.getLeadDAO().remove(findID);
		factory.getLeadDAO().remove(listID);
		factory.getLeadDAO().remove(updateID);
		factory.getLeadDAO().remove(distinctID);
	}
	
}
