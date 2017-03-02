package com.voice.app.Agent_Manager.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import org.jdesktop.swingx.JXDatePicker;

/**
 * Represents the form filled out to 
 * populate a lead with data points.
 * @author Kyle Gendron
 *
 */
@SuppressWarnings("serial")
public class LeadForm extends JPanel{
	private JLabel dateLabel, dialerLabel, agentLabel, 
	cOIDLabel, aIDLabel, campaignLabel, companyLabel, 
	phoneLabel, submittedAsLabel, passedTypeLabel, 
	incentiveValueLabel, coachingNotesLabel;
	
	private JTextField dialerField, agentField, 
	cOIDField, aIDField, campaignField, companyField, 
	phoneField, submittedAsField, passedTypeField, coachingNotesField;
	
	private JCheckBox includedOnOFCheckBox;
	
	private JSpinner incentiveValueSpinner;
	
	private JXDatePicker datePicker;
	
	/**
	 * Default Constructor
	 */
	public LeadForm(){
		initialize();
	}

	/**
	 * Helper method that initializes GUI Components.
	 * All backgrounds are set to red, but not made opaque
	 * until highlightError method is called, at which point,
	 * components will be called and highlighted based on the
	 * results of the validate method in the controller.
	 * 
	 * @See AddSingleLeadController
	 */
	public void initialize(){
		setLayout(new GridLayout(4,4));
		//try just adding all the components in willy-nilly first
		//date
		dateLabel = new JLabel("Date: (MM/dd/yyyy)");
		dateLabel.setBackground( new Color(255,75,75));
		datePicker = new JXDatePicker();
		JPanel datePanel = new JPanel(new GridLayout(2,1));
		datePanel.add(dateLabel);
		datePanel.add(datePicker);
		
		//dialer
		dialerLabel = new JLabel("Dialer: (One char)");
		dialerLabel.setBackground( new Color(255,75,75));
		dialerField = new JTextField();
		JPanel dialerPanel = new JPanel(new GridLayout(2,1));
		dialerPanel.add(dialerLabel);
		dialerPanel.add(dialerField);
		
		//agent
		agentLabel = new JLabel("Agent: (<= 100 chars)");
		agentLabel.setBackground( new Color(255,75,75));
		agentField = new JTextField();
		JPanel agentPanel = new JPanel(new GridLayout(2,1));
		agentPanel.add(agentLabel);
		agentPanel.add(agentField);
		
		//coid
		cOIDLabel = new JLabel("COID: (<= 100 chars)");
		cOIDLabel.setBackground( new Color(255,75,75));
		cOIDField = new JTextField();
		JPanel cOIDPanel = new JPanel(new GridLayout(2,1));
		cOIDPanel.add(cOIDLabel);
		cOIDPanel.add(cOIDField);
		
		//aid
		aIDLabel = new JLabel("AID: (<= 100 chars)");
		aIDLabel.setBackground( new Color(255,75,75));
		aIDField = new JTextField();
		JPanel aIDPanel = new JPanel(new GridLayout(2,1));
		aIDPanel.add(aIDLabel);
		aIDPanel.add(aIDField);
		
		//campaign
		campaignLabel = new JLabel("Campaign: (<= 100 chars)");
		campaignLabel.setBackground( new Color(255,75,75));
		campaignField = new JTextField();
		JPanel campaignPanel = new JPanel(new GridLayout(2,1));
		campaignPanel.add(campaignLabel);
		campaignPanel.add(campaignField);
		
		//company
		companyLabel = new JLabel("Company: (<= 100 chars)");
		companyLabel.setBackground( new Color(255,75,75));
		companyField = new JTextField();
		JPanel companyPanel = new JPanel(new GridLayout(2,1));
		companyPanel.add(companyLabel);
		companyPanel.add(companyField);
		
		//phone
		phoneLabel = new JLabel("Phone: (9-digits)");
		phoneLabel.setBackground( new Color(255,75,75));
		phoneField = new JTextField();
		JPanel phonePanel = new JPanel(new GridLayout(2,1));
		phonePanel.add(phoneLabel);
		phonePanel.add(phoneField);
		
		//included on of
		includedOnOFCheckBox = new JCheckBox("Included on Output File: "
				+ "(Y for yes, N for No)");
		includedOnOFCheckBox.setBackground( new Color(255,75,75));
		
		//submitted as
		submittedAsLabel = new JLabel("Submitted As: (<= 100 chars)");
		submittedAsLabel.setBackground( new Color(255,75,75));
		submittedAsField = new JTextField();
		JPanel submittedAsPanel = new JPanel(new GridLayout(2,1));
		submittedAsPanel.add(submittedAsLabel);
		submittedAsPanel.add(submittedAsField);
		
		//passed type
		passedTypeLabel = new JLabel("Passed Type: (<= 100 chars)");
		passedTypeField = new JTextField();
		JPanel passedTypePanel = new JPanel(new GridLayout(2,1));
		passedTypePanel.add(passedTypeLabel);
		passedTypePanel.add(passedTypeField);
		
		//incentive value
		incentiveValueLabel = new JLabel("Incentive Value: (In USD)");
		SpinnerModel model = 
				new SpinnerNumberModel(0,0, Double.MAX_VALUE, .01);
		incentiveValueSpinner = new JSpinner(model);
		JPanel incentiveValuePanel = new JPanel(new GridLayout(2,1));
		incentiveValuePanel.add(incentiveValueLabel);
		incentiveValuePanel.add(incentiveValueSpinner);
		
		//coaching notes
		coachingNotesLabel = new JLabel("Coaching Notes: (<= 200 chars)");
		coachingNotesField = new JTextField();
		JPanel coachingNotesPanel = new JPanel(new GridLayout(2,1));
		coachingNotesPanel.add(coachingNotesLabel);
		coachingNotesPanel.add(coachingNotesField);
		
		//add each panel
		add(datePanel);
		add(dialerPanel);
		add(agentPanel);
		add(cOIDPanel);
		add(aIDPanel);
		add(campaignPanel);
		add(companyPanel);
		add(phonePanel);
		add(includedOnOFCheckBox);
		add(submittedAsPanel);
		add(passedTypePanel);
		add(incentiveValuePanel);
		add(coachingNotesPanel);
		
		
	}
	
	public JLabel getDateLabel() {
		return dateLabel;
	}

	public void setDateLabel(JLabel dateLabel) {
		this.dateLabel = dateLabel;
	}

	public JLabel getDialerLabel() {
		return dialerLabel;
	}

	public void setDialerLabel(JLabel dialerLabel) {
		this.dialerLabel = dialerLabel;
	}

	public JLabel getAgentLabel() {
		return agentLabel;
	}

	public void setAgentLabel(JLabel agentLabel) {
		this.agentLabel = agentLabel;
	}

	public JLabel getcOIDLabel() {
		return cOIDLabel;
	}

	public void setcOIDLabel(JLabel cOIDLabel) {
		this.cOIDLabel = cOIDLabel;
	}

	public JLabel getaIDLabel() {
		return aIDLabel;
	}

	public void setaIDLabel(JLabel aIDLabel) {
		this.aIDLabel = aIDLabel;
	}

	public JLabel getCampaignLabel() {
		return campaignLabel;
	}

	public void setCampaignLabel(JLabel campaignLabel) {
		this.campaignLabel = campaignLabel;
	}

	public JLabel getCompanyLabel() {
		return companyLabel;
	}

	public void setCompanyLabel(JLabel companyLabel) {
		this.companyLabel = companyLabel;
	}

	public JLabel getPhoneLabel() {
		return phoneLabel;
	}

	public void setPhoneLabel(JLabel phoneLabel) {
		this.phoneLabel = phoneLabel;
	}

	public JLabel getSubmittedAsLabel() {
		return submittedAsLabel;
	}

	public void setSubmittedAsLabel(JLabel submittedAsLabel) {
		this.submittedAsLabel = submittedAsLabel;
	}

	public JLabel getPassedTypeLabel() {
		return passedTypeLabel;
	}

	public void setPassedTypeLabel(JLabel passedTypeLabel) {
		this.passedTypeLabel = passedTypeLabel;
	}

	public JLabel getIncentiveValueLabel() {
		return incentiveValueLabel;
	}

	public void setIncentiveValueLabel(JLabel incentiveValueLabel) {
		this.incentiveValueLabel = incentiveValueLabel;
	}

	public JLabel getCoachingNotesLabel() {
		return coachingNotesLabel;
	}

	public void setCoachingNotesLabel(JLabel coachingNotesLabel) {
		this.coachingNotesLabel = coachingNotesLabel;
	}

	public JTextField getDialerfield() {
		return dialerField;
	}

	public void setDialerfield(JTextField dialerField) {
		this.dialerField = dialerField;
	}

	public JTextField getAgentField() {
		return agentField;
	}

	public void setAgentField(JTextField agentField) {
		this.agentField = agentField;
	}

	public JTextField getcOIDField() {
		return cOIDField;
	}

	public void setcOIDField(JTextField cOIDField) {
		this.cOIDField = cOIDField;
	}

	public JTextField getaIDField() {
		return aIDField;
	}

	public void setaIDField(JTextField aIDField) {
		this.aIDField = aIDField;
	}

	public JTextField getCampaignField() {
		return campaignField;
	}

	public void setCampaignField(JTextField campaignField) {
		this.campaignField = campaignField;
	}

	public JTextField getCompanyField() {
		return companyField;
	}

	public void setCompanyField(JTextField companyField) {
		this.companyField = companyField;
	}

	public JTextField getPhoneField() {
		return phoneField;
	}

	public void setPhoneField(JTextField phoneField) {
		this.phoneField = phoneField;
	}

	public JTextField getCoachingField() {
		return coachingNotesField;
	}

	public void setCoachingField(JTextField coachingField) {
		this.coachingNotesField = coachingField;
	}

	public JSpinner getIncentiveSpinner() {
		return incentiveValueSpinner;
	}

	public void setIncentiveSpinner(JSpinner incentiveSpinner) {
		this.incentiveValueSpinner = incentiveSpinner;
	}

	public JXDatePicker getDatePicker() {
		return datePicker;
	}

	public void setDatePicker(JXDatePicker datePicker) {
		this.datePicker = datePicker;
	}

	public JTextField getDialerField() {
		return dialerField;
	}

	public void setDialerField(JTextField dialerField) {
		this.dialerField = dialerField;
	}

	public JTextField getSubmittedAsField() {
		return submittedAsField;
	}

	public void setSubmittedAsField(JTextField submittedAsField) {
		this.submittedAsField = submittedAsField;
	}

	public JTextField getPassedTypeField() {
		return passedTypeField;
	}

	public void setPassedTypeField(JTextField passedTypeField) {
		this.passedTypeField = passedTypeField;
	}

	public JTextField getCoachingNotesField() {
		return coachingNotesField;
	}

	public void setCoachingNotesField(JTextField coachingNotesField) {
		this.coachingNotesField = coachingNotesField;
	}

	public JSpinner getIncentiveValueSpinner() {
		return incentiveValueSpinner;
	}

	public void setIncentiveValueSpinner(JSpinner incentiveValueSpinner) {
		this.incentiveValueSpinner = incentiveValueSpinner;
	}
}
