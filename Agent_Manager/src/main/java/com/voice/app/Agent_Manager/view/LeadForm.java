package com.voice.app.Agent_Manager.view;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
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
	phoneLabel, includedOnOFLabel, submittedAsLabel, 
	passedTypeLabel, incentiveValueLabel, coachingNotesLabel;
	
	private JTextField dialerField, agentField, 
	cOIDField, aIDField, campaignField, companyField, 
	phoneField, submittedAsField, passedTypeField, coachingNotesField;
	
	private JPanel includedOnOFButtons;
	
	private JRadioButton yesButton, noButton;
	
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
	 */
	public void initialize(){
		setLayout(new FlowLayout());
		//try just adding all the components in willy-nilly first
		//date
		dateLabel = new JLabel("Date: \n(MM/dd/yyyy)");
		datePicker = new JXDatePicker();
		JPanel datePanel = new JPanel();
		datePanel.add(dateLabel);
		datePanel.add(datePicker);
		
		//dialer
		dialerLabel = new JLabel("Dialer: \n(One char)");
		dialerField = new JTextField();
		JPanel dialerPanel = new JPanel();
		dialerPanel.add(dialerLabel);
		dialerPanel.add(dialerField);
		
		//agent
		agentLabel = new JLabel("Agent: \n(<= 100 chars)");
		agentField = new JTextField();
		JPanel agentPanel = new JPanel();
		agentPanel.add(agentLabel);
		agentPanel.add(agentField);
		
		//coid
		cOIDLabel = new JLabel("COID: \n(<= 100 chars)");
		cOIDField = new JTextField();
		JPanel cOIDPanel = new JPanel();
		cOIDPanel.add(cOIDLabel);
		cOIDPanel.add(cOIDField);
		
		//aid
		aIDLabel = new JLabel("AID: \n(<= 100 chars)");
		aIDField = new JTextField();
		JPanel aIDPanel = new JPanel();
		aIDPanel.add(aIDLabel);
		aIDPanel.add(aIDField);
		
		//campaign
		campaignLabel = new JLabel("Campaign: \n(<= 100 chars)");
		campaignField = new JTextField();
		JPanel campaignPanel = new JPanel();
		campaignPanel.add(campaignLabel);
		campaignPanel.add(campaignField);
		
		//company
		companyLabel = new JLabel("Company: \n(<= 100 chars)");
		companyField = new JTextField();
		JPanel companyPanel = new JPanel();
		companyPanel.add(companyLabel);
		companyPanel.add(companyField);
		
		//phone
		phoneLabel = new JLabel("Phone: \n(9-digits)");
		phoneField = new JTextField();
		JPanel phonePanel = new JPanel();
		phonePanel.add(phoneLabel);
		phonePanel.add(phoneField);
		
		//included on of
		includedOnOFLabel = new JLabel("Included on Output File: "
				+ "\n(Y for yes, N for No)");
		yesButton = new JRadioButton("Y");
		noButton = new JRadioButton("N");
		includedOnOFButtons = new JPanel(new GridLayout(2,1));
		includedOnOFButtons.add(yesButton);
		includedOnOFButtons.add(noButton);
		
		//submitted as
		submittedAsLabel = new JLabel("Submitted As: \n(<= 100 chars)");
		submittedAsField = new JTextField();
		JPanel submittedAsPanel = new JPanel();
		submittedAsPanel.add(submittedAsLabel);
		submittedAsPanel.add(submittedAsField);
		
		//passed type
		passedTypeLabel = new JLabel("Passed Type: \n(<= 100 chars)");
		passedTypeField = new JTextField();
		JPanel passedTypePanel = new JPanel();
		passedTypePanel.add(passedTypeLabel);
		passedTypePanel.add(passedTypeField);
		
		//incentive value
		incentiveValueLabel = new JLabel("Incentive Value: \n(In USD)");
		SpinnerModel model = 
				new SpinnerNumberModel(0,0, Double.MAX_VALUE, .01);
		incentiveValueSpinner = new JSpinner(model);
		JPanel incentiveValuePanel = new JPanel();
		incentiveValuePanel.add(incentiveValueLabel);
		incentiveValuePanel.add(incentiveValueSpinner);
		
		//coaching notes
		coachingNotesLabel = new JLabel("Coaching Notes: \n(<= 200 chars)");
		coachingNotesField = new JTextField();
		JPanel coachingNotesPanel = new JPanel();
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
		add(includedOnOFButtons);
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

	public JLabel getIncludedOnOFLabel() {
		return includedOnOFLabel;
	}

	public void setIncludedOnOFLabel(JLabel includedOnOFLabel) {
		this.includedOnOFLabel = includedOnOFLabel;
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

	public JPanel getIncludedOnOFButtons() {
		return includedOnOFButtons;
	}

	public void setIncludedOnOFButtons(JPanel includedOnOFButtons) {
		this.includedOnOFButtons = includedOnOFButtons;
	}

	public JRadioButton getYesButton() {
		return yesButton;
	}

	public void setYesButton(JRadioButton yesButton) {
		this.yesButton = yesButton;
	}

	public JRadioButton getNoButton() {
		return noButton;
	}

	public void setNoButton(JRadioButton noButton) {
		this.noButton = noButton;
	}

	public JSpinner getIncentiveValueSpinner() {
		return incentiveValueSpinner;
	}

	public void setIncentiveValueSpinner(JSpinner incentiveValueSpinner) {
		this.incentiveValueSpinner = incentiveValueSpinner;
	}
}
