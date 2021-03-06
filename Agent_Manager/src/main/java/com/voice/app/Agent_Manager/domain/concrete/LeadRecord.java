package com.voice.app.Agent_Manager.domain.concrete;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.voice.app.Agent_Manager.view.LeadForm;

/**
 * Class that represents a lead record as submitted by an agent
 * on a given day and on a given campaign.  This version is implemented
 * to interact with a Hibernate DAO.
 * 
 * @author Kyle Gendron
 * @see LeadRecord
 */

@Entity
@Table(name = "leadrecord")
public class LeadRecord{
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id; //id for easy unique identification in Hibernate
	
	@Column(name = "date")
	private LocalDate date;
	
	@Column(name = "dialer")
	private String dialer;
	
	@Column(name = "agent")
	private String agent;
	
	@Column(name = "COID")
	private String cOID;
	
	@Column(name = "AID")
	private String aID;
	
	@Column(name = "campaign")
	private String campaign;
	
	@Column(name = "company")
	private String company;
	
	@Column(name = "phone")
	private String phone; 
	
	@Column(name = "included_on_output_file")
	private boolean includedOnOF;
	
	@Column(name = "submitted_as")
	private String submittedAs;
	
	@Column(name = "passed_type")
	private String passedType;
	
	@Column(name = "incentive_value")
	private double incentiveValue; //in USD
	
	@Column(name = "coaching_notes")
	private String coachingNotes;
	
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
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/y");
		date = LocalDate.parse(input[0], formatter);
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
		if(input.length == 13)
			coachingNotes = input[12];
		else
			coachingNotes = "";
	}
	
	/**
	 * Constructor that takes in LeadForm,
	 * used primarily for manual lead inputs.
	 * 
	 * Expects that input has already been validated.
	 * @param form the form to create the lead with
	 */
	public LeadRecord(LeadForm form){
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		String date = df.format(form.getDatePicker().getDate());
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/y");
		this.date = LocalDate.parse(date, formatter);
		this.dialer = form.getDialerField().getText();
		this.agent = form.getAgentField().getText();
		this.cOID = form.getcOIDField().getText();
		this.aID = form.getaIDField().getText();
		this.campaign = form.getCampaignField().getText();
		this.company = form.getCompanyField().getText();
		this.phone = form.getPhoneField().getText();
		if(form.getIncludedOnOFCheckBox().isSelected())
			includedOnOF = true;
		else
			includedOnOF = false;
		this.submittedAs = form.getSubmittedAsField().getText();
		this.passedType = form.getPassedTypeField().getText();
		this.incentiveValue = (Double) form.getIncentiveSpinner().getValue();
		this.coachingNotes = form.getCoachingNotesField().getText();
	}
	
	/**
	 * Returns the date for this record.
	 * @return date the date associated with this record
	 */
	public LocalDate getDate() {
		return date;
	}

	/**
	 * Sets the date for this record.
	 * @param date the date to set this record to
	 */
	public void setDate(LocalDate date) {
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
	
	@Override
	public String toString(){
		return "Date: " + date.toString() +
				"\nDialer: " + dialer +
				"\nAgent: " + agent + 
				"\nCOID: " + cOID +
				"\nAID: " + aID + 
				"\nCampaign: " + campaign +
				"\nCompany: " + company +
				"\nPhone: " + phone +
				"\nIncluded On Output File: " + includedOnOF +
				"\nSubmitted As: " + submittedAs + 
				"\nPassed Type: " + passedType +
				"\nIncentive Value: " + incentiveValue +
				"\nCoaching Notes: " + coachingNotes;
	}
}
