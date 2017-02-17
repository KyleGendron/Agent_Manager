package com.voice.app.Agent_Manager.domain.concrete;


/**
 * Class that represents a lead record as submitted by an agent
 * on a given day and on a given campaign.  This version is implemented
 * to interact with a Hibernate DAO.
 * 
 * @author Kyle Gendron
 * @see LeadRecord
 */
public class LeadRecord{
	private String date, dialer, agent, cOID, aID, campaign,
		company, phone, submittedAs, passedType, coachingNotes;
	private boolean includedOnOF;
	private double incentiveValue; //in USD
	private int id; //id for easy unique identification in Hibernate

	//TODO: Implement any Hibernate-specific functionality
	
	/**
	 * Default constructor
	 */
	public LeadRecord(){}
	
	/**
	 * Constructor that takes in string array,
	 * used primarily for .csv inputs.
	 * 
	 * Expects that the input has already been validated.
	 * @param input string array containing data points
	 */
	public LeadRecord(String[] input){
		date = input[0];
		dialer = input[1];
		agent = input[2];
		cOID = input[3];
		aID = input[4];
		campaign = input[5];
		company = input[6];
		phone = input[7];
		if(input[8].equals("x"))
			includedOnOF = true;
		else
			includedOnOF = false;
		submittedAs = input[9];
		passedType = input[10];
		incentiveValue = Double.parseDouble(input[11].substring(1));
		coachingNotes = input[12];
	}
	
	/**
	 * Returns the date for this record.
	 * @return date the date associated with this record
	 */
	public String getDate() {
		return date;
	}

	/**
	 * Sets the date for this record.
	 * @param date the date to set this record to
	 */
	public void setDate(String date) {
		this.date = date;
		
	}

	/**
	 * Returns the dialer for this record.
	 * @return dialer the dialer for this record
	 */
	public String getDialer() {
		return dialer;
	}

	/**
	 * Sets the dialer for this record.
	 * @param dialer the dialer to set this record to
	 */
	public void setDialer(String dialer) {
		this.dialer = dialer;
	}

	/**
	 * Returns the agent for this record.
	 * @return agent the agent associated with this record
	 */
	public String getAgent() {
		return agent;
	}

	/**
	 * Sets the agent associated with this record.
	 * @param agent the agent to be associated with this record
	 */
	public void setAgent(String agent) {
		this.agent = agent;
	}

	/**
	 * Returns the COID of this record.
	 * @return cOId the COID associated with this record
	 */
	public String getcOID() {
		return cOID;
	}

	/**
	 * Sets the COID of this record.
	 * @param cOId the COId to set this record to.
	 */
	public void setcOID(String cOID) {
		this.cOID = cOID;
	}

	/**
	 * Returns the AID associated with this record.
	 * @return aID the AID associated with this record
	 */
	public String getaID() {
		return aID;
	}

	/**
	 * Sets the AID of this record.
	 * @param aID the AID to set this record to
	 */
	public void setaID(String aID) {
		this.aID = aID;
	}

	/**
	 * Returns the campaign this record is associated with.
	 * @return campaign the campaign this record is associated with
	 */
	public String getCampaign() {
		return campaign;
	}

	/**
	 * Sets the campaign of this record.
	 * @param campaign the campaign to associate this record with
	 */
	public void setCampaign(String campaign) {
		this.campaign = campaign;
	}

	/**
	 * Returns the company associated with this record.
	 * @return company the company associated with this record
	 */
	public String getCompany() {
		return company;
	}

	/**
	 * Sets the company of this record.
	 * @param company the company to associate with this record
	 */
	public void setCompany(String company) {
		this.company = company;
	}

	/**
	 * Returns the phone number associated with this record.
	 * @return phone the phone number associated with this record
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * Sets the phone number of this record.
	 * @param phone the phone number to associate this record with
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * Returns whether this record is included on an output file.
	 * @return includedOnOF whether this record is included on an output file
	 */
	public boolean getIncludedOnOF() {
		return includedOnOF;
	}

	/**
	 * Sets whether this record is included on an output file.
	 * @param includedOnOF whether this record is included on an output file
	 */
	public void setIncludedOnOF(boolean includedOnOF) {
		this.includedOnOF = includedOnOF;
	}

	/**
	 * Returns the type of lead this record was submitted as.
	 * @return submittedAs the type of lead this record was submitted as
	 */
	public String getSubmittedAs() {
		return submittedAs;
	}

	/**
	 * Sets the type of lead this record was submitted as.
	 * @param submittedAs the type of lead to set this record as submitted as
	 */
	public void setSubmittedAs(String submittedAs) {
		this.submittedAs = submittedAs;
	}

	/**
	 * Returns the type of lead this record passed as.
	 * @return passedType the type of lead this record passed as
	 */
	public String getPassedType() {
		return passedType;
	}

	/**
	 * Sets the type of lead this record passed as.
	 * @param passedType the type of lead to set this lead as passed as
	 */
	public void setPassedType(String passedType) {
		this.passedType = passedType;
	}

	/**
	 * Returns the incentive value of this lead.
	 * @return incentiveValue the incentive value of this lead
	 */
	public double getIncentiveValue() {
		return incentiveValue;
	}

	/**
	 * Sets the incentive value of this lead.
	 * @param incentiveValue the incentive value to set this lead to
	 */
	public void setIncentiveValue(double incentiveValue) {
		this.incentiveValue = incentiveValue;
	}

	/**
	 * Returns the coaching notes associated with this record.
	 * @return coachingNotes the coaching notes associated with this record
	 */
	public String getCoachingNotes() {
		return coachingNotes;
	}

	/**
	 * Sets the coaching notes associated with this record.
	 * @param coachingNotes the coaching notes to associate with this record
	 */
	public void setCoachingNotes(String coachingNotes) {
		this.coachingNotes = coachingNotes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
