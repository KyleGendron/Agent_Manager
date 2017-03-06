package com.voice.app.Agent_Manager.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import org.jdesktop.swingx.JXDatePicker;

public class StatsForm extends JPanel{
	private JLabel dateLabel, agentLabel, campaignLabel, loggedHoursLabel,
	breakHoursLabel, followupHoursLabel, meetTrainHoursLabel,
	hoursMinusExcessBreakLabel, callsMadeLabel, callsPerHourLabel,
	contactsLabel, contactsPerHourLabel, leadsPerHourLabel,
	followupMinutesPerLeadLabel;
	
	private JXDatePicker datePicker;
	
	private JTextField agentField, campaignField;
	
	private JSpinner loggedHoursSpinner, breakHoursSpinner,
	followupHoursSpinner, meetTrainHoursSpinner,
	hoursMinusExcessBreakSpinner, callsMadeSpinner,
	callsPerHourSpinner, contactsSpinner, 
	contactsPerHourSpinner, leadsPerHourSpinner,
	followupMinutesPerLeadSpinner;
	
	/**
	 * Default Constructor
	 */
	public StatsForm(){
		initialize();
	}
	
	/**
	 * Helper method for initializing this GUI element.
	 */
	public void initialize(){
		setLayout(new GridLayout(3,5));
		SpinnerModel doubleModel = 
				new SpinnerNumberModel(0,0, Double.MAX_VALUE, .01);
		SpinnerModel intModel = 
				new SpinnerNumberModel(0,0, Integer.MAX_VALUE, 1);
		//date
		dateLabel = new JLabel("Date*: (MM/dd/yyyy)");
		dateLabel.setBackground( new Color(255,75,75));
		datePicker = new JXDatePicker();
		JPanel datePanel = new JPanel(new GridLayout(2,1));
		datePanel.add(dateLabel);
		datePanel.add(datePicker);
		
		//agent
		agentLabel = new JLabel("Agent*: (<= 100 chars)");
		agentLabel.setBackground( new Color(255,75,75));
		agentField = new JTextField();
		JPanel agentPanel = new JPanel(new GridLayout(2,1));
		agentPanel.add(agentLabel);
		agentPanel.add(agentField);
		
		//campaign
		campaignLabel = new JLabel("Campaign*: (<= 100 chars)");
		campaignLabel.setBackground( new Color(255,75,75));
		campaignField = new JTextField();
		JPanel campaignPanel = new JPanel(new GridLayout(2,1));
		campaignPanel.add(campaignLabel);
		campaignPanel.add(campaignField);
		
		//logged hours
		loggedHoursLabel = new JLabel("Logged Hours*: ");
		loggedHoursSpinner = new JSpinner(doubleModel);
		JPanel loggedHoursPanel = new JPanel(new GridLayout(2,1));
		loggedHoursPanel.add(loggedHoursLabel);
		loggedHoursPanel.add(loggedHoursSpinner);
		
		//break hours
		breakHoursLabel = new JLabel("Break Hours*: ");
		breakHoursSpinner = new JSpinner(doubleModel);
		JPanel breakHoursPanel = new JPanel(new GridLayout(2,1));
		breakHoursPanel.add(breakHoursLabel);
		breakHoursPanel.add(breakHoursSpinner);
		
		//follow-up hours
		followupHoursLabel = new JLabel("Follow-Up Hours*: ");
		followupHoursSpinner = new JSpinner(doubleModel);
		JPanel followupHoursPanel = new JPanel(new GridLayout(2,1));
		followupHoursPanel.add(followupHoursLabel);
		followupHoursPanel.add(followupHoursSpinner);
		
		//meeting/training hours
		meetTrainHoursLabel = new JLabel("Meeting + Training Hours*: ");
		meetTrainHoursSpinner = new JSpinner(doubleModel);
		JPanel meetTrainHoursPanel = new JPanel(new GridLayout(2,1));
		meetTrainHoursPanel.add(meetTrainHoursLabel);
		meetTrainHoursPanel.add(meetTrainHoursSpinner);
		
		//hours minus excess break
		hoursMinusExcessBreakLabel = new JLabel("Hours Minus Excess Break*: ");
		hoursMinusExcessBreakSpinner = new JSpinner(doubleModel);
		JPanel hoursMinusExcessBreakPanel = new JPanel(new GridLayout(2,1));
		hoursMinusExcessBreakPanel.add(hoursMinusExcessBreakLabel);
		hoursMinusExcessBreakPanel.add(hoursMinusExcessBreakSpinner);
		
		//calls made
		callsMadeLabel = new JLabel("Calls Made*: ");
		callsMadeSpinner = new JSpinner(intModel);
		JPanel callsMadePanel = new JPanel(new GridLayout(2,1));
		callsMadePanel.add(callsMadeLabel);
		callsMadePanel.add(callsMadeSpinner);
		
		//calls per hour
		callsPerHourLabel = new JLabel("Calls Per Hour*: ");
		callsPerHourSpinner = new JSpinner(doubleModel);
		JPanel callsPerHourPanel = new JPanel(new GridLayout(2,1));
		callsPerHourPanel.add(callsPerHourLabel);
		callsPerHourPanel.add(callsPerHourSpinner);
		
		//contacts
		contactsLabel = new JLabel("Contacts*: ");
		contactsSpinner = new JSpinner(intModel);
		JPanel contactsPanel = new JPanel(new GridLayout(2,1));
		contactsPanel.add(contactsLabel);
		contactsPanel.add(contactsSpinner);
		
		//contacts per hour
		contactsPerHourLabel = new JLabel("Contacts Per Hour*: ");
		contactsPerHourSpinner = new JSpinner(doubleModel);
		JPanel contactsPerHourPanel = new JPanel(new GridLayout(2,1));
		contactsPerHourPanel.add(contactsPerHourLabel);
		contactsPerHourPanel.add(contactsPerHourSpinner);
		
		//leads per hour
		leadsPerHourLabel = new JLabel("Leads Per Hour*: ");
		leadsPerHourSpinner = new JSpinner(doubleModel);
		JPanel leadsPerHourPanel = new JPanel(new GridLayout(2,1));
		leadsPerHourPanel.add(leadsPerHourLabel);
		leadsPerHourPanel.add(leadsPerHourSpinner);
		
		//follow-up minutes per lead
		followupMinutesPerLeadLabel = new JLabel("Follow-Up Minutes Per Lead*: ");
		followupMinutesPerLeadSpinner = new JSpinner(doubleModel);
		JPanel followupMinutesPerLeadPanel = new JPanel(new GridLayout(2,1));
		followupMinutesPerLeadPanel.add(followupMinutesPerLeadLabel);
		followupMinutesPerLeadPanel.add(followupMinutesPerLeadSpinner);
		
		//info
		JTextArea info = new JTextArea("Any field marked with a '*' is a required field, "
				+ "and must be filled out in order to be submitted.");
		Font font = info.getFont();
		info.setFont(font.deriveFont(Font.BOLD));
		info.setEditable(false);
		info.setLineWrap(true);
		
		add(datePanel);
		add(agentPanel);
		add(campaignPanel);
		add(loggedHoursPanel);
		add(breakHoursPanel);
		add(followupHoursPanel);
		add(meetTrainHoursPanel);
		add(hoursMinusExcessBreakPanel);
		add(callsMadePanel);
		add(callsPerHourPanel);
		add(contactsPanel);
		add(contactsPerHourPanel);
		add(leadsPerHourPanel);
		add(followupMinutesPerLeadPanel);
		add(info);
	}

	public JLabel getDateLabel() {
		return dateLabel;
	}

	public void setDateLabel(JLabel dateLabel) {
		this.dateLabel = dateLabel;
	}

	public JLabel getAgentLabel() {
		return agentLabel;
	}

	public void setAgentLabel(JLabel agentLabel) {
		this.agentLabel = agentLabel;
	}

	public JLabel getCampaignLabel() {
		return campaignLabel;
	}

	public void setCampaignLabel(JLabel campaignLabel) {
		this.campaignLabel = campaignLabel;
	}

	public JLabel getLoggedHoursLabel() {
		return loggedHoursLabel;
	}

	public void setLoggedHoursLabel(JLabel loggedHoursLabel) {
		this.loggedHoursLabel = loggedHoursLabel;
	}

	public JLabel getBreakHoursLabel() {
		return breakHoursLabel;
	}

	public void setBreakHoursLabel(JLabel breakHoursLabel) {
		this.breakHoursLabel = breakHoursLabel;
	}

	public JLabel getFollowupHoursLabel() {
		return followupHoursLabel;
	}

	public void setFollowupHoursLabel(JLabel followupHoursLabel) {
		this.followupHoursLabel = followupHoursLabel;
	}

	public JLabel getMeetTrainHoursLabel() {
		return meetTrainHoursLabel;
	}

	public void setMeetTrainHoursLabel(JLabel meetTrainHoursLabel) {
		this.meetTrainHoursLabel = meetTrainHoursLabel;
	}

	public JLabel getHoursMinusExcessBreakLabel() {
		return hoursMinusExcessBreakLabel;
	}

	public void setHoursMinusExcessBreakLabel(JLabel hoursMinusExcessBreakLabel) {
		this.hoursMinusExcessBreakLabel = hoursMinusExcessBreakLabel;
	}

	public JLabel getCallsMadeLabel() {
		return callsMadeLabel;
	}

	public void setCallsMadeLabel(JLabel callsMadeLabel) {
		this.callsMadeLabel = callsMadeLabel;
	}

	public JLabel getCallsPerHourLabel() {
		return callsPerHourLabel;
	}

	public void setCallsPerHourLabel(JLabel callsPerHourLabel) {
		this.callsPerHourLabel = callsPerHourLabel;
	}

	public JLabel getContactsLabel() {
		return contactsLabel;
	}

	public void setContactsLabel(JLabel contactsLabel) {
		this.contactsLabel = contactsLabel;
	}

	public JLabel getContactsPerHourLabel() {
		return contactsPerHourLabel;
	}

	public void setContactsPerHourLabel(JLabel contactsPerHourLabel) {
		this.contactsPerHourLabel = contactsPerHourLabel;
	}

	public JLabel getLeadsPerHourLabel() {
		return leadsPerHourLabel;
	}

	public void setLeadsPerHourLabel(JLabel leadsPerHourLabel) {
		this.leadsPerHourLabel = leadsPerHourLabel;
	}

	public JLabel getFollowupMinutesPerLeadLabel() {
		return followupMinutesPerLeadLabel;
	}

	public void setFollowupMinutesPerLeadLabel(JLabel followupMinutesPerLeadLabel) {
		this.followupMinutesPerLeadLabel = followupMinutesPerLeadLabel;
	}

	public JXDatePicker getDatePicker() {
		return datePicker;
	}

	public void setDatePicker(JXDatePicker datePicker) {
		this.datePicker = datePicker;
	}

	public JTextField getAgentField() {
		return agentField;
	}

	public void setAgentField(JTextField agentField) {
		this.agentField = agentField;
	}

	public JTextField getCampaignField() {
		return campaignField;
	}

	public void setCampaignField(JTextField campaignField) {
		this.campaignField = campaignField;
	}

	public JSpinner getLoggedHoursSpinner() {
		return loggedHoursSpinner;
	}

	public void setLoggedHoursSpinner(JSpinner loggedHoursSpinner) {
		this.loggedHoursSpinner = loggedHoursSpinner;
	}

	public JSpinner getBreakHoursSpinner() {
		return breakHoursSpinner;
	}

	public void setBreakHoursSpinner(JSpinner breakHoursSpinner) {
		this.breakHoursSpinner = breakHoursSpinner;
	}

	public JSpinner getFollowupHoursSpinner() {
		return followupHoursSpinner;
	}

	public void setFollowupHoursSpinner(JSpinner followupHoursSpinner) {
		this.followupHoursSpinner = followupHoursSpinner;
	}

	public JSpinner getMeetTrainHoursSpinner() {
		return meetTrainHoursSpinner;
	}

	public void setMeetTrainHoursSpinner(JSpinner meetTrainHoursSpinner) {
		this.meetTrainHoursSpinner = meetTrainHoursSpinner;
	}

	public JSpinner getHoursMinusExcessBreakSpinner() {
		return hoursMinusExcessBreakSpinner;
	}

	public void setHoursMinusExcessBreakSpinner(JSpinner hoursMinusExcessBreakSpinner) {
		this.hoursMinusExcessBreakSpinner = hoursMinusExcessBreakSpinner;
	}

	public JSpinner getCallsMadeSpinner() {
		return callsMadeSpinner;
	}

	public void setCallsMadeSpinner(JSpinner callsMadeSpinner) {
		this.callsMadeSpinner = callsMadeSpinner;
	}

	public JSpinner getCallsPerHourSpinner() {
		return callsPerHourSpinner;
	}

	public void setCallsPerHourSpinner(JSpinner callsPerHourSpinner) {
		this.callsPerHourSpinner = callsPerHourSpinner;
	}

	public JSpinner getContactsSpinner() {
		return contactsSpinner;
	}

	public void setContactsSpinner(JSpinner contactsSpinner) {
		this.contactsSpinner = contactsSpinner;
	}

	public JSpinner getContactsPerHourSpinner() {
		return contactsPerHourSpinner;
	}

	public void setContactsPerHourSpinner(JSpinner contactsPerHourSpinner) {
		this.contactsPerHourSpinner = contactsPerHourSpinner;
	}

	public JSpinner getLeadsPerHourSpinner() {
		return leadsPerHourSpinner;
	}

	public void setLeadsPerHourSpinner(JSpinner leadsPerHourSpinner) {
		this.leadsPerHourSpinner = leadsPerHourSpinner;
	}

	public JSpinner getFollowupMinutesPerLeadSpinner() {
		return followupMinutesPerLeadSpinner;
	}

	public void setFollowupMinutesPerLeadSpinner(JSpinner followupMinutesPerLeadSpinner) {
		this.followupMinutesPerLeadSpinner = followupMinutesPerLeadSpinner;
	}
	
	/**
	 * Sets a components background to opaque,
	 * used to highlight an error in the form.
	 * @param component the component to highlight
	 */
	public void highlightError(JComponent component){
		component.setOpaque(true);
		repaint();
	}
	
	/**
	 * Sets all components' backgrounds to not opaque,
	 * used to un-highlight all errors in the form.
	 */
	public void unHighlightErrors(){
		dateLabel.setOpaque(false);
		agentLabel.setOpaque(false);
		campaignLabel.setOpaque(false);
		loggedHoursLabel.setOpaque(false);
		breakHoursLabel.setOpaque(false);
		followupHoursLabel.setOpaque(false);
		meetTrainHoursLabel.setOpaque(false);
		hoursMinusExcessBreakLabel.setOpaque(false);
		callsMadeLabel.setOpaque(false);
		callsPerHourLabel.setOpaque(false);
		contactsLabel.setOpaque(false);
		contactsPerHourLabel.setOpaque(false);
		leadsPerHourLabel.setOpaque(false);
		followupMinutesPerLeadLabel.setOpaque(false);
		repaint();
	}
	
	@Override
	public String toString(){
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		String formattedDate = format.format(datePicker.getDate());
		DecimalFormat df = new DecimalFormat( "#,###,###,##0.00" );
		return "Date: " + formattedDate + 
				"\nAgent: " + agentField.getText() +
				"\nCampaign: " + campaignField.getText() +
				"\nLogged Hours: " + df.format(loggedHoursSpinner.getValue()) +
				"\nBreak Hours: " + df.format(breakHoursSpinner.getValue()) +
				"\nFollow-Up Hours: " + df.format(followupHoursSpinner.getValue()) +
				"\nMeeting + Training Hours: " + df.format(meetTrainHoursSpinner.getValue()) +
				"\nHours Minus Excess Break: " + df.format(hoursMinusExcessBreakSpinner.getValue()) +
				"\nCalls Made: " + callsMadeSpinner.getValue() +
				"\nCalls Per Hour: " + df.format(callsPerHourSpinner.getValue()) +
				"\nContacts: " + contactsSpinner.getValue() + 
				"\nContacts Per Hour: " + df.format(contactsPerHourSpinner.getValue()) +
				"\nLeads Per Hour: " + df.format(leadsPerHourSpinner.getValue()) +
				"\nFollow-Up Minutes Per Lead: " + df.format(followupMinutesPerLeadSpinner.getValue());
	}
}
