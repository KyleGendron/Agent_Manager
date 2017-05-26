package com.voice.app.Agent_Manager.dao.interfaces;

import java.util.List;
import java.util.Map;

import com.voice.app.Agent_Manager.util.interfaces.Range;

/**
 * Interface designed for interacting with any DB,
 * performing CRUD operations with a Lead Record.
 * 
 * @author Kyle Gendron
 */
public interface ILeadRecordDAO<T> extends GenericDAO<Integer, T> {
  /**
   * Add an object of type T to the database
   *
   * @param record any object of type T
   */
  @Override
  int add(Integer id, T record);

  /**
   * Update an object of type T in the database
   *
   * @param record any object of type T
   */
  @Override
  int update(Integer id, T record);

  /**
   * Remove an object of type T in the database
   *
   * @param id of the object of type T to remove
   */
  @Override
  int remove(Integer id);

  /**
   * Find an object of type T in the database
   *
   * @param key of the object of type T to locate
   * @return the object of type T with ID key
   */
  @Override
  T find(Integer key);
  
  /**
   * Return a list of distinct values of a given field
   * @param fieldName the field to return distinct values for
   * @return a list of distinct values from the given field
   */
  public List<String> getDistinctValues(String fieldName);
  
  /**
   * Return a list of objects of type T based on a given set
   * of criteria composed of value ranges and particular values.
   * @return 
   */
  public List<T> findCriteria(Map<String, String> values, Map<String, Range> ranges);

  /**
   * Generate a list of objects of type T in the database
   *
   * @return List of objects of type T
   */
  @Override
  List<T> list();
}