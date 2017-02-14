package com.voice.app.Agent_Manager.dao.interfaces;

import java.util.List;

/**
 * Interface designed for interacting with any DB,
 * performing CRUD operations with a Lead Record.
 * 
 * @author Kyle Gendron
 */
public interface ILeadRecordDAO<T> extends GenericDAO<String, T> {
  /**
   * Add a PregnancyVisit to the DAO repository
   *
   * @param record any PregnancyVisit object
   */
  @Override
  int add(String id, T record);

  /**
   * Update a PregnancyVisit in the DAO repository
   *
   * @param record any PregnancyVisit object
   */
  @Override
  int update(String id, T record);

  /**
   * Remove a PregnancyVisit in the DAO repository
   *
   * @param id of the PregnancyVisit object to remove
   */
  @Override
  int remove(String id);

  /**
   * Find a PregnancyVisit in the DAO repository
   *
   * @param key of the PregnancyVisit object to locate
   * @return the PregnancyVisit with id field equal to key
   */
  @Override
  T find(String key);

  /**
   * Generate a list of AntenatalVisits in the DAO repository
   *
   * @return List of AntenatalVisits
   */
  @Override
  List<T> list();
}