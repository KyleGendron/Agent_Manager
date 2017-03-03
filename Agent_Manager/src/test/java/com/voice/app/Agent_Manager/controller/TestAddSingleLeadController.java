package com.voice.app.Agent_Manager.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Calendar;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import com.voice.app.Agent_Manager.view.LeadForm;

public class TestAddSingleLeadController {
	static LeadForm goodForm;
	static LeadForm emptyForm;
	static LeadForm allBadForm;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		goodForm = new LeadForm();
		goodForm.getDatePicker().setDate(new Date());
		goodForm.getDialerField().setText("F");
		goodForm.getAgentField().setText("Dude McBro");
		goodForm.getcOIDField().setText("3245lk76000hjeeaD");
		goodForm.getaIDField().setText("sadf9845h9854hgfds9ee");
		goodForm.getCampaignField().setText("Q1 2017 Bumblebees Campaign");
		goodForm.getCompanyField().setText("Fight Bees with Fire BumbleBee Exterminators");
		goodForm.getPhoneField().setText("8002625233"); //Get it? BMBLBEE. Hilarious.
		goodForm.getSubmittedAsField().setText("Hot Lead - Confirmed Meeting");
		goodForm.getPassedTypeField().setText("Not a Good Target");
		goodForm.getCoachingNotesField().setText("Don't want their business.  Ever.");

		emptyForm = new LeadForm();

		allBadForm = new LeadForm();
		Date dt = new Date();
		Calendar c = Calendar.getInstance(); 
		c.setTime(dt); 
		c.add(Calendar.DATE, 1);
		dt = c.getTime();
		allBadForm.getDatePicker().setDate(dt); //set to future date
		allBadForm.getDialerField().setText("FU"); //So Clever.
		allBadForm.getAgentField().setText("4 of these break your formatter"+
				"4 of these break your formatter"+
				"4 of these break your formatter"+
				"4 of these break your formatter");
		allBadForm.getcOIDField().setText("4 of these break your formatter"+
				"4 of these break your formatter"+
				"4 of these break your formatter"+
				"4 of these break your formatter");
		allBadForm.getaIDField().setText("4 of these break your formatter"+
				"4 of these break your formatter"+
				"4 of these break your formatter"+
				"4 of these break your formatter");
		allBadForm.getCampaignField().setText("4 of these break your formatter"+
				"4 of these break your formatter"+
				"4 of these break your formatter"+
				"4 of these break your formatter");
		allBadForm.getCompanyField().setText("4 of these break your formatter"+
				"4 of these break your formatter"+
				"4 of these break your formatter"+
				"4 of these break your formatter");
		allBadForm.getPhoneField().setText("12348002625233");
		allBadForm.getSubmittedAsField().setText("4 of these break your formatter"+
				"4 of these break your formatter"+
				"4 of these break your formatter"+
				"4 of these break your formatter");
		allBadForm.getPassedTypeField().setText("4 of these break your formatter"+
				"4 of these break your formatter"+
				"4 of these break your formatter"+
				"4 of these break your formatter");
		allBadForm.getCoachingNotesField().setText("8 of these break your formatter"+
				"8 of these break your formatter"+
				"8 of these break your formatter"+
				"8 of these break your formatter"+
				"8 of these break your formatter"+
				"8 of these break your formatter"+
				"8 of these break your formatter"+
				"8 of these break your formatter");
	}

	@Test
	public void testValidateGoodForm(){
		assertNull("Did not validate good form correctly.", AddSingleLeadController.validate(goodForm));
	}

	@Test
	public void testValidateEmptyForm(){
		assertEquals("Did not catch all the missing fields.", "There were some issues with your submission: \n"+
				"-No Date was provided.\n"+
				"-No Dialer was provided.\n"+
				"-No Agent name was provided.\n"+
				"-No Campaign was provided.\n"+
				"-No Company was provided.\n"+
				"-No Phone number was provided.\n"+
				"-No Submitted As lead type was provided.\n"+
				"-No Passed Type for lead was provided.\n",
				AddSingleLeadController.validate(emptyForm));
	}

	@Test
	public void testValidateAllBadForm(){
		System.out.println(AddSingleLeadController.validate(allBadForm));
		assertEquals("Did not catch all the erroneous fields.", "There were some issues with your submission: \n"+ 
				"-Future Date Provided.\n"+
				"-Dialer was more than one character.\n"+
				"-Provided Agent name too long.\n"+
				"-Provided COID too long.\n"+
				"-Provided AID too long.\n"+
				"-Provided Campaign name too long.\n"+
				"-Provided Company name too long.\n"+
				"-Provided Phone number too long or short.\n"+
				"-Provided Submitted As lead type too long.\n"+
				"-Provided Passed Type for lead too long.\n"+
				"-Provided Coaching Notes too long.\n",
				AddSingleLeadController.validate(allBadForm));
	}
}
