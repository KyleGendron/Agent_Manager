package com.voice.app.Agent_Manager.utils;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;

import org.junit.Test;

import com.voice.app.Agent_Manager.domain.concrete.LeadRecord;

public class TestLeadConverterCSV {
	private static final File file = new File(System.getProperty("user.dir")
			+ "\\testfiles\\2017_Leads.csv");
	
	@Test
	public void testProcess(){
		LeadConverterCSV converter = new LeadConverterCSV(file);
		ArrayList<LeadRecord> result = converter.process();
		System.out.println(result.size());
		assertEquals("The converter did not process all the records.", 1728, result.size());
	}
	
	@Test
	public void testClean(){
		LeadConverterCSV converter = new LeadConverterCSV(file);
		String result = converter.cleanInput("2/14/2017,F,Tsinat Efrem,,,Q1 2017 Voice B2B Campaign,\"Treace Medical Concepts, Inc.\","
				+ "9043735940,x,Sent Info - In Market,Sent Info - In Market,$5.00 ,");
		assertEquals("The converter did not clean the hazardous .csv elements properly", result, "2/14/2017,F,Tsinat Efrem,,,Q1 2017 Voice B2B Campaign,Treace Medical Concepts Inc.,9043735940,x,Sent Info - In Market,Sent Info - In Market,$5.00 ,");
	}
}
