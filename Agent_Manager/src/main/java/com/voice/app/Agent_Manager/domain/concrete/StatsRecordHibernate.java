package com.voice.app.Agent_Manager.domain.concrete;

import com.voice.app.Agent_Manager.domain.interfaces.StatsRecord;

public class StatsRecordHibernate implements StatsRecord{
	private String date, agent, campaign;
	double loggedHours, breakHours, followUpHours, meetTrainHours,
		hoursMinusExcessBreak, callsPerHour, contactsPerHour, leadsPerHour, 
		followUpMinutesPerLead;
	int callsMade, contacts;
	
	/**
	 * Default Constructor
	 */
	public StatsRecordHibernate(){}
	
	/**
	 * 1-Param Constructor takes in a string array
	 * containing the data points stored by this 
	 * class.  To be used with .csv input format.
	 * @param input string array of input data points
	 */
	public StatsRecordHibernate(String[] input){
		date = input[0];
		agent = input[1];
		campaign = input[2];
		loggedHours = Double.parseDouble(input[3]);
		breakHours = Double.parseDouble(input[4]);
		followUpHours = Double.parseDouble(input[5]);
		meetTrainHours = Double.parseDouble(input[6]);
		hoursMinusExcessBreak = Double.parseDouble(input[7]);
		callsMade = Integer.parseInt(input[8]);
		callsPerHour = Double.parseDouble(input[9]);
		contacts = Integer.parseInt(input[10]);
		contactsPerHour = Double.parseDouble(input[11]);
		leadsPerHour = Double.parseDouble(input[12]);
		followUpMinutesPerLead = Double.parseDouble(input[13]);
	}
	
	@Override
	/**
	 * Returns date associated with this stats record.
	 * @return date the date this record refers to
	 */
	public String getDate() {
		return date;
	}

	@Override
	/**
	 * Sets the date associated with this stats record.
	 * @param date the date to set this record to
	 */
	public void setDate(String date) {
		this.date = date;
	}

	@Override
	/**
	 * Returns the agent associated with this stats record.
	 * @return agent the agent associated with this record
	 */
	public String getAgent() {
		return agent;
	}

	@Override
	/**
	 * Sets the agent associated with this record.
	 * @param agent the agent to associate with this record
	 */
	public void setAgent(String agent) {
		this.agent = agent;
	}

	@Override
	/**
	 * Returns the campaign associated with this record.
	 * @return campaign the campaign associated with this record
	 */
	public String getCampaign() {
		return campaign;
	}

	@Override
	/**
	 * Sets the campaign associated with this record.
	 * @param campaign the campaign to associate this record with
	 */
	public void setCampaign(String campaign) {
		this.campaign = campaign;
	}

	@Override
	/**
	 * Returns the total logged hours on this record.
	 * @return loggedHours the total logged hours on this record
	 */
	public double getLoggedHours() {
		return loggedHours;
	}

	@Override
	/**
	 * Sets the total logged hours on this record.
	 * @param loggedHours the total logged hours to set this record to
	 */
	public void setLoggedHours(double loggedHours) {
		this.loggedHours = loggedHours;
	}

	@Override
	/**
	 * Returns the total break hours on this record.
	 * @return breakHours the total break hours on this record
	 */
	public double getBreakHours() {
		return breakHours;
	}

	@Override
	/**
	 * Sets the total break hours on this record.
	 * @param breakHours the total break hours to set this record to
	 */
	public void setBreakHours(double breakHours) {
		this.breakHours = breakHours;
	}

	@Override
	/**
	 * Returns the total Follow Up hours on this record.
	 * @return followUpHours the total Follow Up hours on this record
	 */
	public double getFollowUpHours() {
		return followUpHours;
	}

	@Override
	/**
	 * Sets the total Follow Up hours on this record.
	 * @param followUpHours the total Follow Up hours to set this record to
	 */
	public void setFollowUpHours(double followUpHours) {
		this.followUpHours = followUpHours;
	}

	@Override
	/**
	 * Returns the total meeting/training hours on this record.
	 * @return meetTrainHours the total meeting/training hours on this record
	 */
	public double getMeetTrainHours() {
		return meetTrainHours;
	}

	@Override
	/**
	 * Sets the total meeting/training hours on this record.
	 * @param meetTrainHours the total meeting/training hours to set this record to
	 */
	public void setMeetTrainHours(double meetTrainHours) {
		this.meetTrainHours = meetTrainHours;
	}

	@Override
	/**
	 * Returns the total hours minus excess break on this record.
	 * @return hoursMinusExcessBreak the total hours minus excess break on this record
	 */
	public double getHoursMinusExcessBreak() {
		return hoursMinusExcessBreak;
	}

	@Override
	/**
	 * Sets the total hours minus excess break on this record.
	 * @param hoursMinusExcessBreak the total hours minus excess break on this record
	 */
	public void setHoursMinusExcessBreak(double hoursMinusExcessBreak) {
		this.hoursMinusExcessBreak = hoursMinusExcessBreak;
	}

	@Override
	/**
	 * Returns the total calls made on this record.
	 * @return callsMade the total calls made on this record
	 */
	public int getCallsMade() {
		return callsMade;
	}

	@Override
	/**
	 * Sets the total calls made on this record.
	 * @param callsMade the total calls made to set this record to
	 */
	public void setCallsMade(int callsMade) {
		this.callsMade = callsMade;
	}

	@Override
	/**
	 * Returns the number of calls per hour as calculated:
	 * Calls made / Logged Hours.
	 * @return callsPerHour the number of calls per hour on this record
	 */
	public double getCallsPerHour() {
		return callsPerHour;
	}
	
	/**
	 * Sets the number of calls per hour as calculated:
	 * Calls made / Logged Hours.
	 * @param callPerHour the number of calls per hour to set to this record
	 */
	public void setCallsPerHour(double callsPerHour){
		this.callsPerHour = callsPerHour;
	}

	@Override
	/**
	 * Returns the total contacts made on this record.
	 * @return contacts the total contacts made on this record
	 */
	public int getContacts() {
		return contacts;
	}

	@Override
	/**
	 * Sets the total contacts made on this record.
	 * @param contacts the total contacts made to set this record to
	 */
	public void setContacts(int contacts) {
		this.contacts = contacts;
	}

	@Override
	/**
	 * Returns the number of contacts per hour as calculated:
	 * Contacts / Logged Hours.
	 * @return contactsPerHour the number of contacts per hour on this record
	 */
	public double getContactsPerHour() {
		return contactsPerHour;
	}
	
	/**
	 * Sets the number of contacts per hour on this record as calculated:
	 * Contacts / Logged Hours.
	 * @param contactsPerHour the number of contacts per hour to set this record to
	 */
	public void setContactsPerHour(double contactsPerHour){
		this.contactsPerHour = contactsPerHour;
	}

	@Override
	/**
	 * Returns the number of leads per hour on this record.
	 * @return leadsPerHour the number of leads per hour on this record
	 */
	public double getLeadsPerHour() {
		return leadsPerHour;
	}

	@Override
	/**
	 * Sets the number of leads per hour on this record.
	 * @param leadsPerHour the number of leads per hour to set this record to
	 */
	public void setLeadsPerHour(double leadsPerHour) {
		this.leadsPerHour = leadsPerHour;
	}

	@Override
	/**
	 * Returns the total follow up minutes per lead on this record.
	 * @return followUpMinutesPerLead the total follow up minutes per lead on this record
	 */
	public double getFollowUpMinutesPerLead() {
		return followUpMinutesPerLead;
	}

	@Override
	/**
	 * Sets the total follow up minutes per lead on this record.
	 * @param followUpMinutesPerLead the total follow up minutes per lead to set this record to
	 */
	public void setFollowUpMinutesPerLead(double followUpMinutesPerLead) {
		this.followUpMinutesPerLead = followUpMinutesPerLead;
	}
	
}
