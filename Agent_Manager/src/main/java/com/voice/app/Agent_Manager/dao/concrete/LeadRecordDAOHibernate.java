package com.voice.app.Agent_Manager.dao.concrete;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.voice.app.Agent_Manager.dao.interfaces.ILeadRecordDAO;
import com.voice.app.Agent_Manager.domain.interfaces.LeadRecord;

/**
 * Hibernate-specific DAO.  Since id-management is taken care of by
 * Hibernate/MySQL, the id is not necessary in this implementation,
 * but is kept to respect the interface this class implements.  Other
 * DAOs may need them, but for the purpose of this implementation, ID
 * will not be used.
 * @author Kyle Gendron
 *
 */
public class LeadRecordDAOHibernate implements ILeadRecordDAO<LeadRecord>{
	private static SessionFactory factory;

	/**
	 * Default Constructor
	 */
	public LeadRecordDAOHibernate(){
		try{
			factory = new Configuration().configure().buildSessionFactory();
		}catch(Throwable ex){
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex); 
		}
	}

	@Override
	public int add(Integer id, LeadRecord record) {
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
	public int update(Integer id, LeadRecord record) {
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
			LeadRecord record = 
					(LeadRecord) session.get(LeadRecord.class, id);
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
	public LeadRecord find(Integer key) {
		Session session = factory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			LeadRecord record = 
					(LeadRecord) session.get(LeadRecord.class, key);
			return record;
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}finally {
			session.close(); 
		}
		return null;
	}

	//TODO: Implement another find method that takes in a string for query-builder
	
	@Override
	public List<LeadRecord> list() {
		Session session = factory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			TypedQuery<LeadRecord> query = session.createQuery("FROM LeadRecord");
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
