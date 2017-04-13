package com.voice.app.Agent_Manager.view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

import org.jdesktop.swingx.JXDatePicker;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import com.voice.app.Agent_Manager.controller.SearchLeadsController;
import com.voice.app.Agent_Manager.domain.concrete.LeadRecord;

/**
 * View corresponding to the search leads by criteria use case.
 * @author Kyle Gendron
 *
 */
@SuppressWarnings("serial")
public class SearchLeadsView extends JPanel{
	private SearchLeadsController controller;

	private JXDatePicker startDatePicker, endDatePicker;

	private JLabel startDateLabel, endDateLabel;

	private JComboBox<String> dialerBox, agentBox, cOIDBox, aIDBox,
	campaignBox, companyBox, phoneBox,
	submittedAsBox, passedTypeBox;

	private JSpinner incentiveLowSpinner, incentiveHighSpinner;

	private JCheckBox enableDateCheckBox, enableIncentiveCheckBox, includedOnOFCheckBox;


	/**
	 * Default Constructor
	 */
	public SearchLeadsView(SearchLeadsController controller){
		this.controller = controller;
		initialize();
	}

	/**
	 * Helper method that initializes all GUI components of this sub-view.
	 */
	public void initialize(){
		setLayout(new GridBagLayout());

		JButton closeButton = new JButton("Cancel");
		closeButton.addActionListener(controller);
		GridBagConstraints closeButtonConstraints = new GridBagConstraints();
		closeButtonConstraints.gridx = 0;
		closeButtonConstraints.gridy = 0;
		closeButtonConstraints.weightx = 0.25;
		closeButtonConstraints.weighty = 0.1;
		add(closeButton, closeButtonConstraints);

		JButton searchButton = new JButton("Search");
		searchButton.addActionListener(controller);
		GridBagConstraints searchButtonConstraints = new GridBagConstraints();
		searchButtonConstraints.gridx = 1;
		searchButtonConstraints.gridy = 0;
		searchButtonConstraints.weightx = 0.25;
		searchButtonConstraints.weighty = 0.1;
		add(searchButton, searchButtonConstraints);

		//add search criteria
		JPanel searchCritPanel = new JPanel(new GridLayout(31,1));

		//reset button
		JButton UpdateSearchOptionsButton = new JButton("Update Search Options");
		UpdateSearchOptionsButton.addActionListener(controller);

		//date enabler
		enableDateCheckBox = new JCheckBox("Enable Date Range Search: ");
		enableDateCheckBox.addChangeListener(controller);

		//date range
		startDateLabel = new JLabel("Start Date: ");
		startDateLabel.setBackground(new Color(255,75,75));
		endDateLabel = new JLabel("End Date: ");
		endDateLabel.setBackground(new Color(255,75,75));
		startDatePicker = new JXDatePicker();
		startDatePicker.setEnabled(false);
		endDatePicker = new JXDatePicker();
		endDatePicker.setEnabled(false);

		//dialer
		JLabel dialerLabel = new JLabel("Dialer: ");
		dialerBox = new JComboBox<String>(controller.getComboBoxElements("dialer"));
		AutoCompleteDecorator.decorate(dialerBox);

		//agent
		JLabel agentLabel = new JLabel("Agent: ");
		agentBox = new JComboBox<String>(controller.getComboBoxElements("agent"));
		AutoCompleteDecorator.decorate(agentBox);

		//coid
		JLabel cOIDLabel = new JLabel("COID: ");
		cOIDBox = new JComboBox<String>(controller.getComboBoxElements("cOID"));
		AutoCompleteDecorator.decorate(cOIDBox);

		//aid
		JLabel aIDLabel = new JLabel("AID: ");
		aIDBox = new JComboBox<String>(controller.getComboBoxElements("aID"));
		AutoCompleteDecorator.decorate(aIDBox);

		//campaign
		JLabel campaignLabel = new JLabel("Campaign: ");
		campaignBox = new JComboBox<String>(controller.getComboBoxElements("campaign"));
		AutoCompleteDecorator.decorate(campaignBox);

		//company
		JLabel companyLabel = new JLabel("Company: ");
		companyBox = new JComboBox<String>(controller.getComboBoxElements("company"));
		AutoCompleteDecorator.decorate(companyBox);

		//phone
		JLabel phoneLabel = new JLabel("Phone: ");
		phoneBox = new JComboBox<String>(controller.getComboBoxElements("phone"));
		AutoCompleteDecorator.decorate(phoneBox);

		//include on output file
		JLabel includedOnOFLabel = new JLabel("Included On Output File: ");
		includedOnOFCheckBox = new JCheckBox("Leave blank if no.");

		//submitted as
		JLabel submittedAsLabel = new JLabel("Submitted As: ");
		submittedAsBox = new JComboBox<String>(controller.getComboBoxElements("submittedAs"));
		AutoCompleteDecorator.decorate(submittedAsBox);

		//passed type
		JLabel passedTypeLabel = new JLabel("Passed Type: ");
		passedTypeBox = new JComboBox<String>(controller.getComboBoxElements("passedType"));
		AutoCompleteDecorator.decorate(passedTypeBox);

		//whether to search by incentive value
		enableIncentiveCheckBox = new JCheckBox("Enable Incentive Value Search Range: ");
		enableIncentiveCheckBox.addChangeListener(controller);

		//incentive low
		JLabel incentiveLowLabel = new JLabel("At Least: ");
		SpinnerModel lowModel = 
				new SpinnerNumberModel(0,0, 2000000000.0, .25);
		incentiveLowSpinner = new JSpinner(lowModel);
		incentiveLowSpinner.setEnabled(false);

		//incentive high
		JLabel incentiveHighLabel = new JLabel("At Most: ");
		SpinnerModel highModel = 
				new SpinnerNumberModel(0,0, 2000000000.0, .25);
		incentiveHighSpinner = new JSpinner(highModel);
		incentiveHighSpinner.setEnabled(false);

		//add remaining criteria components
		searchCritPanel.add(UpdateSearchOptionsButton);
		searchCritPanel.add(enableDateCheckBox);
		searchCritPanel.add(startDateLabel);
		searchCritPanel.add(startDatePicker);
		searchCritPanel.add(endDateLabel);
		searchCritPanel.add(endDatePicker);
		searchCritPanel.add(dialerLabel);
		searchCritPanel.add(dialerBox);
		searchCritPanel.add(agentLabel);
		searchCritPanel.add(agentBox);
		searchCritPanel.add(cOIDLabel);
		searchCritPanel.add(cOIDBox);
		searchCritPanel.add(aIDLabel);
		searchCritPanel.add(aIDBox);
		searchCritPanel.add(campaignLabel);
		searchCritPanel.add(campaignBox);
		searchCritPanel.add(companyLabel);
		searchCritPanel.add(companyBox);
		searchCritPanel.add(phoneLabel);
		searchCritPanel.add(phoneBox);
		searchCritPanel.add(includedOnOFLabel);
		searchCritPanel.add(includedOnOFCheckBox);
		searchCritPanel.add(submittedAsLabel);
		searchCritPanel.add(submittedAsBox);
		searchCritPanel.add(passedTypeLabel);
		searchCritPanel.add(passedTypeBox);
		searchCritPanel.add(enableIncentiveCheckBox);
		searchCritPanel.add(incentiveLowLabel);
		searchCritPanel.add(incentiveLowSpinner);
		searchCritPanel.add(incentiveHighLabel);
		searchCritPanel.add(incentiveHighSpinner);

		//create search criteria constraints
		GridBagConstraints searchCritConstraints = new GridBagConstraints();
		searchCritConstraints.gridx = 0;
		searchCritConstraints.gridy = 1;
		searchCritConstraints.weightx = 0.35;
		searchCritConstraints.weighty = 0.35;
		add(searchCritPanel, searchCritConstraints);

		//table
		String[] columnNames = {"Date", "Dialer", "Agent",
				"CoID", "AID", "Campaign", "Company",
				"Phone", "Included on Output File",
				"Submitted As", "Passed Type",
				"Incentive Value", "Coaching Notes"};
		//create table constraints
		GridBagConstraints tableConstraints = new GridBagConstraints();
		tableConstraints.gridx = 1;
		tableConstraints.gridy = 1;
		tableConstraints.weightx = 1;
		tableConstraints.weighty = 1;
		tableConstraints.fill = GridBagConstraints.BOTH;

		//create and add table
		DefaultTableModel model = new DefaultTableModel(5,columnNames.length);
		model.setColumnIdentifiers(columnNames);
		JTable table = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(table);
		table.setFillsViewportHeight(true);
		table.setAutoCreateRowSorter(true);
		add(scrollPane, tableConstraints);
	}

	public SearchLeadsController getController() {
		return controller;
	}

	public void setController(SearchLeadsController controller) {
		this.controller = controller;
	}

	public JXDatePicker getStartDatePicker() {
		return startDatePicker;
	}

	public void setStartDatePicker(JXDatePicker startDatePicker) {
		this.startDatePicker = startDatePicker;
	}

	public JXDatePicker getEndDatePicker() {
		return endDatePicker;
	}

	public void setEndDatePicker(JXDatePicker endDatePicker) {
		this.endDatePicker = endDatePicker;
	}

	public JLabel getStartDateLabel() {
		return startDateLabel;
	}

	public void setStartDateLabel(JLabel startDateLabel) {
		this.startDateLabel = startDateLabel;
	}

	public JLabel getEndDateLabel() {
		return endDateLabel;
	}

	public void setEndDateLabel(JLabel endDateLabel) {
		this.endDateLabel = endDateLabel;
	}

	public JComboBox<String> getDialerBox() {
		return dialerBox;
	}

	public void setDialerBox(JComboBox<String> dialerBox) {
		this.dialerBox = dialerBox;
	}

	public JComboBox<String> getAgentBox() {
		return agentBox;
	}

	public void setAgentBox(JComboBox<String> agentBox) {
		this.agentBox = agentBox;
	}

	public JComboBox<String> getcOIDBox() {
		return cOIDBox;
	}

	public void setcOIDBox(JComboBox<String> cOIDBox) {
		this.cOIDBox = cOIDBox;
	}

	public JComboBox<String> getaIDBox() {
		return aIDBox;
	}

	public void setaIDBox(JComboBox<String> aIDBox) {
		this.aIDBox = aIDBox;
	}

	public JComboBox<String> getCampaignBox() {
		return campaignBox;
	}

	public void setCampaignBox(JComboBox<String> campaignBox) {
		this.campaignBox = campaignBox;
	}

	public JComboBox<String> getCompanyBox() {
		return companyBox;
	}

	public void setCompanyBox(JComboBox<String> companyBox) {
		this.companyBox = companyBox;
	}

	public JComboBox<String> getPhoneBox() {
		return phoneBox;
	}

	public void setPhoneBox(JComboBox<String> phoneBox) {
		this.phoneBox = phoneBox;
	}

	public JCheckBox getIncludedOnOFBox() {
		return includedOnOFCheckBox;
	}

	public void setIncludedOnOFBox(JCheckBox includedOnOFCheckBox) {
		this.includedOnOFCheckBox = includedOnOFCheckBox;
	}

	public JComboBox<String> getSubmittedAsBox() {
		return submittedAsBox;
	}

	public void setSubmittedAsBox(JComboBox<String> submittedAsBox) {
		this.submittedAsBox = submittedAsBox;
	}

	public JComboBox<String> getPassedTypeBox() {
		return passedTypeBox;
	}

	public void setPassedTypeBox(JComboBox<String> passedTypeBox) {
		this.passedTypeBox = passedTypeBox;
	}

	public JSpinner getIncentiveLowSpinner() {
		return incentiveLowSpinner;
	}

	public void setIncentiveLowSpinner(JSpinner incentiveLowSpinner) {
		this.incentiveLowSpinner = incentiveLowSpinner;
	}

	public JSpinner getIncentiveHighSpinner() {
		return incentiveHighSpinner;
	}

	public void setIncentiveHighSpinner(JSpinner incentiveHighSpinner) {
		this.incentiveHighSpinner = incentiveHighSpinner;
	}

	public JCheckBox getEnableDateCheckBox() {
		return enableDateCheckBox;
	}

	public void setEnableDateCheckBox(JCheckBox enableDateCheckBox) {
		this.enableDateCheckBox = enableDateCheckBox;
	}

	public JCheckBox getEnableIncentiveCheckBox() {
		return enableIncentiveCheckBox;
	}

	public void setEnableIncentiveCheckBox(JCheckBox enableIncentiveCheckBox) {
		this.enableIncentiveCheckBox = enableIncentiveCheckBox;
	}

}
