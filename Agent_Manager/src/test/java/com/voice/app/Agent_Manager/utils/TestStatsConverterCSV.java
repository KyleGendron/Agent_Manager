package com.voice.app.Agent_Manager.utils;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.ArrayList;

import org.junit.Test;

import com.voice.app.Agent_Manager.domain.concrete.StatsRecord;

public class TestStatsConverterCSV {
	private static final File file = new File(System.getProperty("user.dir")
			+ "\\testfiles\\2017_Stats.csv");
	
	@Test
	public void testProcess(){
		StatsConverterCSV converter = new StatsConverterCSV(file);
		ArrayList<StatsRecord> result = converter.process();
		assertEquals("The converter did not process all the records.", 703, result.size());
	}
	
	@Test
	//test with hazardous string
	public void testCleanHazard(){
		LeadConverterCSV converter = new LeadConverterCSV(file);
		String result = converter.cleanInput("1/3/2017,\"Anne, Peabody\",Athena,10.98,0.3,0.07,0.35,10.98,166,15.11839709,39,3.551912568,1.275045537,0.3");
		assertEquals("The converter did not clean the hazardous .csv elements properly", 
				result, "1/3/2017,Anne Peabody,Athena,10.98,0.3,0.07,0.35,10.98,166,15.11839709,39,3.551912568,1.275045537,0.3");
	}
	
	@Test
	//test with non-hazardous string
	public void testCleanRegular(){
		LeadConverterCSV converter = new LeadConverterCSV(file);
		String result = converter.cleanInput("1/3/2017,Anne Peabody,Athena,10.98,0.3,0.07,0.35,10.98,166,15.11839709,39,3.551912568,1.275045537,0.3");
		assertEquals("The converter did not clean the hazardous .csv elements properly", 
				result, "1/3/2017,Anne Peabody,Athena,10.98,0.3,0.07,0.35,10.98,166,15.11839709,39,3.551912568,1.275045537,0.3");
	}
}
