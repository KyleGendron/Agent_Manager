package com.voice.app.Agent_Manager.dao.concrete;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.voice.app.Agent_Manager.dao.factory.DAOFactoryHibernate;
import com.voice.app.Agent_Manager.domain.concrete.StatsRecord;

public class TestStatsRecordDAOHibernate {
		//several copies created for use in different tests,
		//in case tests aren't executed in order
		private static StatsRecord addStats, findStats, removeStats,
			listStats, updateStats;
		private static String[] input = {"2/1/2017","John Doe", "Sam's Club",
				"6.14888888888888","1.20722222222222", "0.390833333333333",
				"0.189999999999999", "5.44166666666666", "97", "15.7752078062884",
				"8", "1.30104806649801", "0.138856746123583", "4.48333333333333"};
		private static DAOFactoryHibernate factory = new DAOFactoryHibernate();
		private static int addID, findID, listID, updateID;
		
		@BeforeClass
		public static void setUpBeforeClass() throws Exception {
			addStats = new StatsRecord(input);
			findStats = new StatsRecord(input);
			removeStats = new StatsRecord(input);
			listStats = new StatsRecord(input);
			updateStats = new StatsRecord(input);
		}
		
		@Test
		public void testAdd(){
			addID = factory.getStatsDAO().add(0, addStats);
			assertNotNull("Statsrecord was not added successfully.", addID);
		}
		
		@Test
		public void testFind(){
			findID = factory.getStatsDAO().add(0, findStats);
			assertNotNull("Statsrecord was not found successfully.", factory.getStatsDAO().find(findID));
		}
		
		@Test
		public void testRemove(){
			int removeID = factory.getStatsDAO().add(0, removeStats);
			factory.getStatsDAO().remove(removeID);
			assertNull("Statsrecord was not removed.", factory.getStatsDAO().find(removeID));
		}
		
		@Test
		public void testList(){
			listID = factory.getStatsDAO().add(0, listStats);
			List<StatsRecord> list = factory.getStatsDAO().list();
			assertTrue("The list was empty.", list.size() > 0);
		}
		
		@Test
		public void testUpdate(){
			updateID = factory.getStatsDAO().add(0, updateStats);
			StatsRecord updatedStats = 
					(StatsRecord) factory.getStatsDAO().find(updateID);
			updatedStats.setAgent("Jane Doe");
			factory.getStatsDAO().update(0, updatedStats);
			assertEquals("Statsrecord not updated.", "Jane Doe", factory.getStatsDAO().find(updateID).getAgent());
		}
		
		@AfterClass
		public static void tearDownAfterClass() throws Exception {
			factory.getStatsDAO().remove(addID);
			factory.getStatsDAO().remove(findID);
			factory.getStatsDAO().remove(listID);
			factory.getStatsDAO().remove(updateID);
		}
}
