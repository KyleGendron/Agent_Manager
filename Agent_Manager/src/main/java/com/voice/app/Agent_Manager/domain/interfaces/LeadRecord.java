package com.voice.app.Agent_Manager.domain.interfaces;

/**
 * Interface designed to make abstract the essential
 * elements of a lead record, as submitted by an agent
 * on a given day, on a given campaign.  
 * 
 * Layer of abstraction included to allow for change 
 * in the database platform moving forward.
 * @author Kyle Gendron
 *
 */
public interface LeadRecord {
	//getters and setters
	public int getId();
	public void setId(int id);
	public String getDate();
	public void setDate(String date);
	public String getDialer();
	public void setDialer(String dialer);
	public String getAgent();
	public void setAgent(String agent);
	public String getCOID();
	public void setCOID(String cOID);
	public String getAID();
	public void setAID(String aID);
	public String getCampaign();
	public void setCampaign(String campaign);
	public String getCompany();
	public void setCompany(String company);
	public String getPhone();
	public void setPhone(String phone);
	public boolean getIncludedOnOF();
	public void setIncludedOnOF(boolean includedOnOF);
	public String getSubmittedAs();
	public void setSubmittedAs(String submittedAs);
	public String getPassedType();
	public void setPassedType(String passedType);
	public double getIncentiveValue();
	public void setIncentiveValue(double incentiveValue);
	public String getCoachingNotes();
	public void setCoachingNotes(String coachingNotes);
}
