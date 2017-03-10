package com.voice.app.Agent_Manager.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Calendar;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import com.voice.app.Agent_Manager.view.StatsForm;

public class TestAddSingleStatsController {
	static StatsForm goodForm, emptyForm, allBadForm;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		goodForm = new StatsForm();
		goodForm.getDatePicker().setDate(new Date());
		goodForm.getAgentField().setText("Some Guy");
		goodForm.getCampaignField().setText("Some Campaign");
		
		emptyForm = new StatsForm();
		
		allBadForm = new StatsForm();
		Date dt = new Date();
		Calendar c = Calendar.getInstance(); 
		c.setTime(dt); 
		c.add(Calendar.DATE, 1);
		dt = c.getTime();
		allBadForm.getDatePicker().setDate(dt); //set to future date
		allBadForm.getAgentField().setText("4 of these break your formatter"+
				"4 of these break your formatter"+
				"4 of these break your formatter"+
				"4 of these break your formatter");
		allBadForm.getCampaignField().setText("4 of these break your formatter"+
				"4 of these break your formatter"+
				"4 of these break your formatter"+
				"4 of these break your formatter");
	}
	
	@Test
	public void testValidateGoodForm(){
		assertNull("Did not validate good form correctly.", AddSingleStatsController.validate(goodForm));
	}
	
	@Test
	public void testValidateEmptyForm(){
		assertEquals("Did not properly detect empty fields.", "There were some issues with your submission: \n" +
				"-No Date was provided.\n" +
				"-No Agent name was provided.\n" +
				"-No Campaign was provided.\n",
				AddSingleStatsController.validate(emptyForm));
	}
	
	@Test
	public void testValidateAllBadForm(){
		assertEquals("Did not properly detect erroneous entries.",
				"There were some issues with your submission: \n" +
						"-Future Date Provided.\n" +
						"-Provided Agent name too long.\n" +
				"-Provided Campaign name too long.\n",
				AddSingleStatsController.validate(allBadForm));
	}
}
