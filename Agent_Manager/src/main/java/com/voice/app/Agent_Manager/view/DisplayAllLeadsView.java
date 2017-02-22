package com.voice.app.Agent_Manager.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.voice.app.Agent_Manager.controller.DisplayAllLeadsController;
import com.voice.app.Agent_Manager.domain.concrete.LeadRecord;

@SuppressWarnings("serial")
public class DisplayAllLeadsView extends JPanel{
	DisplayAllLeadsController controller;
	
	/**
	 * 1-Param constructor
	 * @param list the list of all lead records
	 */
	public DisplayAllLeadsView(List<LeadRecord> list, DisplayAllLeadsController controller){
		this.controller = controller;
		initializeGUI(list);
	}
	
	/**
	 * Helper method that initializes this view
	 * @param list the list of lead records to put in table
	 */
	public void initializeGUI(List<LeadRecord> list){
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
		String[] columnNames = {"Date", "Dialer", "Agent",
				"CoID", "AID", "Campaign", "Company",
				"Phone", "Included on Output File",
				"Submitted As", "Passed Type",
				"Incentive Value", "Coaching Notes"};
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
			for(LeadRecord l: list){
				Object[] data = new Object[13];
				data[0] = l.getDate();
				data[1] = l.getDialer();
				data[2] = l.getAgent();
				data[3] = l.getcOID();
				data[4] = l.getaID();
				data[5] = l.getCampaign();
				data[6] = l.getCompany();
				data[7] = l.getPhone();
				if(l.getIncludedOnOF())
					data[8] = "Yes";
				else
					data[8] = "No";
				data[9] = l.getSubmittedAs();
				data[10] = l.getPassedType();
				data[11] = Double.toString(l.getIncentiveValue());
				data[12] = l.getCoachingNotes();
				model.addRow(data);
			}
			JTable table = new JTable(model);
			JScrollPane scrollPane = new JScrollPane(table);
			table.setFillsViewportHeight(true);
			add(scrollPane, tableConstraints);
		}else{ //otherwise, create a small, empty table
			DefaultTableModel model = new DefaultTableModel(5,columnNames.length);
			model.setColumnIdentifiers(columnNames);
			JTable table = new JTable(model);
			JScrollPane scrollPane = new JScrollPane(table);
			table.setFillsViewportHeight(true);
			add(scrollPane, tableConstraints);
		}
	}
}
