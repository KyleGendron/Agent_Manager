package com.voice.app.Agent_Manager.dao.factory;

import com.voice.app.Agent_Manager.dao.concrete.LeadRecordDAOHibernate;
import com.voice.app.Agent_Manager.dao.concrete.StatsRecordDAOHibernate;
import com.voice.app.Agent_Manager.dao.interfaces.ILeadRecordDAO;
import com.voice.app.Agent_Manager.dao.interfaces.IStatsRecordDAO;
import com.voice.app.Agent_Manager.domain.interfaces.LeadRecord;
import com.voice.app.Agent_Manager.domain.interfaces.StatsRecord;

/**
 * Singleton class intended for maintaining singleton
 * Hibernate DAOs of all types
 * 
 * @author Kyle Gendron
 *
 */

public final class DAOFactoryHibernate extends DAOFactory{

	/**
	 * Default Constructor
	 */
	public DAOFactoryHibernate(){}

	@Override
	public ILeadRecordDAO<LeadRecord> getLeadDAO() {
		if(leadDAO != null)
			return leadDAO;
		else{
			leadDAO = new LeadRecordDAOHibernate();
			return leadDAO;
		}
	}

	@Override
	public IStatsRecordDAO<StatsRecord> getStatsDAO() {
		if(statsDAO != null)
			return statsDAO;
		else{
			statsDAO = new StatsRecordDAOHibernate();
			return statsDAO;
		}
	}

}
