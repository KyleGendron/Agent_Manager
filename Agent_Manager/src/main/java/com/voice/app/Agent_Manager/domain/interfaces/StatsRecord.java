package com.voice.app.Agent_Manager.domain.interfaces;

public interface StatsRecord {
	//getters and setters
	public int getId();
	public void setId(int id);
	public String getDate();
	public void setDate(String date);
	public String getAgent();
	public void setAgent(String agent);
	public String getCampaign();
	public void setCampaign(String campaign);
	public double getLoggedHours();
	public void setLoggedHours(double loggedHours);
	public double getBreakHours();
	public void setBreakHours(double breakHours);
	public double getFollowUpHours();
	public void setFollowUpHours(double followUpHours);
	public double getMeetTrainHours();
	public void setMeetTrainHours(double meetTrainHours);
	public double getHoursMinusExcessBreak();
	public void setHoursMinusExcessBreak(double hoursMinusExcessBreak);
	public int getCallsMade();
	public void setCallsMade(int callsMade);
	public double getCallsPerHour();
	public void setCallsPerHour(double callsPerHour);
	public int getContacts();
	public void setContacts(int contacts);
	public double getContactsPerHour();
	public void setContactsPerHour(double contactsPerHour);
	public double getLeadsPerHour();
	public void setLeadsPerHour(double leadsPerHour);
	public double getFollowUpMinutesPerLead();
	public void setFollowUpMinutesPerLead(double followUpMinutesPerLead);
}
