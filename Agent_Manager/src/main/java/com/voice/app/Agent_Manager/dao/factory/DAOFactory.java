package com.voice.app.Agent_Manager.dao.factory;

import com.voice.app.Agent_Manager.dao.interfaces.ILeadRecordDAO;
import com.voice.app.Agent_Manager.dao.interfaces.IStatsRecordDAO;
import com.voice.app.Agent_Manager.domain.concrete.LeadRecord;
import com.voice.app.Agent_Manager.domain.concrete.StatsRecord;

/**
 * Abstract class that creates all types of DAOs
 * @author Kyle Gendron
 *
 */
public abstract class DAOFactory {
	ILeadRecordDAO<LeadRecord> leadDAO;
	IStatsRecordDAO<StatsRecord> statsDAO;
	
	public abstract ILeadRecordDAO<LeadRecord> getLeadDAO();
	public abstract IStatsRecordDAO<StatsRecord> getStatsDAO();
}
