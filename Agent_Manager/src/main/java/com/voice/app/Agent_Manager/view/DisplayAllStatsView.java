package com.voice.app.Agent_Manager.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.voice.app.Agent_Manager.controller.DisplayAllStatsController;
import com.voice.app.Agent_Manager.domain.concrete.StatsRecord;

public class DisplayAllStatsView extends JPanel{
	DisplayAllStatsController controller;
	
	/**
	 * 1-Param constructor
	 * @param list the list of all lead records
	 */
	public DisplayAllStatsView(List<StatsRecord> list, DisplayAllStatsController controller){
		this.controller = controller;
		initializeGUI(list);
	}
	
	/**
	 * Helper method that initializes this view
	 * @param list the list of lead records to put in table
	 */
	public void initializeGUI(List<StatsRecord> list){
		setLayout(new GridBagLayout());
		
		JButton closeButton = new JButton("Close");
		closeButton.addActionListener(controller);
		GridBagConstraints closeButtonConstraints = new GridBagConstraints();
		closeButtonConstraints.gridx = 0;
		closeButtonConstraints.gridy = 0;
		closeButtonConstraints.weightx = 0.25;
		closeButtonConstraints.weighty = 0.15;
		closeButtonConstraints.anchor = GridBagConstraints.FIRST_LINE_START;
		add(closeButton, closeButtonConstraints);
		
		//add table
		String[] columnNames = {"Date", "Agent", "Campaign",
				"Logged Hours", "Break Hours", "Follow-Up Hours",
				"Meeting Plus Training Hours", "Hours Minus Excess Break",
				"Calls Made", "Calls Per Hour", "Contacts",
				"Contacts Per Hour", "Leads Per Hour",
				"Follow-Up Minutes Per Lead"};
		//create table constraints
		GridBagConstraints tableConstraints = new GridBagConstraints();
		tableConstraints.gridx = 0;
		tableConstraints.gridy = 1;
		tableConstraints.weightx = 1;
		tableConstraints.weighty = 1;
		tableConstraints.fill = GridBagConstraints.BOTH;
		tableConstraints.anchor = GridBagConstraints.PAGE_END;
		
		//if list has entries, populate it
		if(!list.isEmpty()){
			DefaultTableModel model = new DefaultTableModel();
			model.setColumnIdentifiers(columnNames);
			for(StatsRecord s: list){
				Object[] data = new Object[14];
				data[0] = s.getDate();
				data[1] = s.getAgent();
				data[2] = s.getCampaign();
				data[3] = s.getLoggedHours();
				data[4] = s.getBreakHours();
				data[5] = s.getFollowUpHours();
				data[6] = s.getMeetTrainHours();
				data[7] = s.getHoursMinusExcessBreak();
				data[8] = s.getCallsMade();
				data[9] = s.getCallsPerHour();
				data[10] = s.getContacts();
				data[11] = s.getContactsPerHour();
				data[12] = s.getLeadsPerHour();
				data[13] = s.getFollowUpMinutesPerLead();
				model.addRow(data);
			}
			JTable table = new JTable(model);
			JScrollPane scrollPane = new JScrollPane(table);
			table.setFillsViewportHeight(true);
			table.setAutoCreateRowSorter(true);
			add(scrollPane, tableConstraints);
		}else{ //otherwise, create a small, empty table
			DefaultTableModel model = new DefaultTableModel(5,columnNames.length);
			model.setColumnIdentifiers(columnNames);
			JTable table = new JTable(model);
			JScrollPane scrollPane = new JScrollPane(table);
			table.setFillsViewportHeight(true);
			table.setAutoCreateRowSorter(true);
			add(scrollPane, tableConstraints);
		}
	}
}
