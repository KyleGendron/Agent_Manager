package com.voice.app.Agent_Manager.dao.concrete;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.voice.app.Agent_Manager.dao.interfaces.IStatsRecordDAO;
import com.voice.app.Agent_Manager.domain.concrete.StatsRecordHibernate;
import com.voice.app.Agent_Manager.domain.interfaces.LeadRecord;
import com.voice.app.Agent_Manager.domain.interfaces.StatsRecord;

public class StatsRecordDAOHibernate implements IStatsRecordDAO<StatsRecord>{
	private static SessionFactory factory;

	/**
	 * Default Constructor
	 */
	public StatsRecordDAOHibernate(){
		try{
			factory = new Configuration().configure().buildSessionFactory();
		}catch(Throwable ex){
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex); 
		}
	}
	
	@Override
	public int add(Integer id, StatsRecord record) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer iD = null;
		try{
			tx = session.beginTransaction();
			iD = (Integer) session.save(record);
		}catch(HibernateException e){
			if (tx!=null) tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		return iD;
	}

	@Override
	public int update(Integer id, StatsRecord record) {
		Session session = factory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.update(record);
			tx.commit();
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}finally {
			session.close(); 
		}
		return 0;
	}

	@Override
	public int remove(Integer id) {
		Session session = factory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			StatsRecord record = 
					(StatsRecord) session.get(StatsRecord.class, id);
			session.delete(record);
			tx.commit();
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}finally {
			session.close(); 
		}
		return 0;
	}

	@Override
	public StatsRecord find(Integer key) {
		Session session = factory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			StatsRecord record = 
					(StatsRecord) session.get(LeadRecord.class, key);
			return record;
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}finally {
			session.close(); 
		}
		return null;
	}

	@Override
	public List<StatsRecord> list() {
		Session session = factory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			TypedQuery<StatsRecord> query = session.createQuery("FROM StatsRecord");
			return query.getResultList();
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}finally {
			session.close(); 
		}
		return null;
	}

	

}
