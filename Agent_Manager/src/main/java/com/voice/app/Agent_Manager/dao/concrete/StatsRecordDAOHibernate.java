package com.voice.app.Agent_Manager.dao.concrete;

import java.util.List;

import com.voice.app.Agent_Manager.dao.interfaces.IStatsRecordDAO;
import com.voice.app.Agent_Manager.domain.concrete.StatsRecordHibernate;
import com.voice.app.Agent_Manager.domain.interfaces.StatsRecord;

public class StatsRecordDAOHibernate implements IStatsRecordDAO<StatsRecord>{

	@Override
	public int add(String id, StatsRecord record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(String id, StatsRecord record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int remove(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public StatsRecordHibernate find(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StatsRecord> list() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
