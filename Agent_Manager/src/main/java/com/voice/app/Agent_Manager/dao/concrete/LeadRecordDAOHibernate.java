package com.voice.app.Agent_Manager.dao.concrete;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.voice.app.Agent_Manager.dao.interfaces.ILeadRecordDAO;
import com.voice.app.Agent_Manager.domain.concrete.LeadRecord;
import com.voice.app.Agent_Manager.util.interfaces.Range;


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
			factory = new Configuration().configure("hibernate.cfg.xml").
					addAnnotatedClass(LeadRecord.class).buildSessionFactory();
		}catch(Throwable ex){
			System.err.println("Failed to create sessionFactory object." + ex);
			ex.printStackTrace();
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
			return id;
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}finally {
			session.close(); 
		}
		return -1;
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
			return id;
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}finally {
			session.close(); 
		}
		return -1;
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

	
	
	/**
	 * Returns all distinct string values of the given field in a list of that field's type.
	 * @param fieldName the field to retrieve all distinct string values from
	 * @return a list of string values that field refers to
	 */
	@Override
	public List<String> getDistinctValues(String fieldName){
		Session session = factory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			TypedQuery<String> query = session.createQuery("SELECT distinct L." + fieldName
															+ " FROM LeadRecord L");
			return query.getResultList();
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}finally {
			session.close(); 
		}
		return null;
	}
	
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

	@Override
	public List<LeadRecord> findCriteria(Map<String, String> values, Map<String, Range> ranges) {
		Session session = factory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}finally {
			session.close(); 
		}
		return null;
	}

}
