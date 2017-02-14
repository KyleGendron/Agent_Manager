package com.voice.app.Agent_Manager.dao.concrete;

import java.util.List;

import com.voice.app.Agent_Manager.dao.interfaces.ILeadRecordDAO;
import com.voice.app.Agent_Manager.domain.concrete.LeadRecordHibernate;
import com.voice.app.Agent_Manager.domain.interfaces.LeadRecord;

public class LeadRecordDAOHibernate implements ILeadRecordDAO<LeadRecord>{

	@Override
	public int add(String id, LeadRecord record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(String id, LeadRecord record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int remove(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public LeadRecordHibernate find(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LeadRecord> list() {
		// TODO Auto-generated method stub
		return null;
	}

}
