package com.voice.app.Agent_Manager.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.voice.app.Agent_Manager.controller.SearchLeadsController;
import com.voice.app.Agent_Manager.domain.concrete.LeadRecord;

/**
 * View corresponding to the search leads by criteria use case.
 * @author Kyle Gendron
 *
 */
@SuppressWarnings("serial")
public class SearchLeadsView extends JPanel{
	SearchLeadsController controller;
	
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
		closeButtonConstraints.weighty = 0.15;
		closeButtonConstraints.anchor = GridBagConstraints.FIRST_LINE_START;
		add(closeButton, closeButtonConstraints);
		
		JButton searchButton = new JButton("Search");
		searchButton.addActionListener(controller);
		GridBagConstraints searchButtonConstraints = new GridBagConstraints();
		searchButtonConstraints.gridx = 1;
		searchButtonConstraints.gridy = 0;
		searchButtonConstraints.weightx = 0.25;
		searchButtonConstraints.weighty = 0.15;
		searchButtonConstraints.anchor = GridBagConstraints.FIRST_LINE_END;
		add(searchButton, searchButtonConstraints);
		
		//add search criteria
		JPanel searchCritPanel = new JPanel(new GridLayout(12,1));
		String[] entries = {"Entry 1", "Second Entry", "A Third Entry"};
		JComboBox<String> firstCrit = new JComboBox<String>(entries);
		searchCritPanel.add(firstCrit);
		
		//create search criteria constraints
		GridBagConstraints searchCritConstraints = new GridBagConstraints();
		searchCritConstraints.gridx = 0;
		searchCritConstraints.gridy = 1;
		searchCritConstraints.weightx = 0.5;
		searchCritConstraints.weighty = 0.5;
		searchCritConstraints.anchor = GridBagConstraints.LAST_LINE_START;
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
		tableConstraints.anchor = GridBagConstraints.PAGE_END;

		//create and add table
		DefaultTableModel model = new DefaultTableModel(5,columnNames.length);
		model.setColumnIdentifiers(columnNames);
		JTable table = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(table);
		table.setFillsViewportHeight(true);
		table.setAutoCreateRowSorter(true);
		add(scrollPane, tableConstraints);
		}

	}
