package com.voice.app.Agent_Manager.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.voice.app.Agent_Manager.controller.AddSingleStatsController;

/**
 * View Class representing the GUI elements
 * of the add single stats record use case.
 * @author Kyle Gendron
 *
 */
public class AddSingleStatsView extends JPanel{
	AddSingleStatsController controller;
	StatsForm form;
	
	/**
	 * 1-Param Constructor
	 * @param controller the controller associated with this view
	 */
	public AddSingleStatsView(AddSingleStatsController controller){
		this.controller = controller;
		initialize();
	}
	
	/**
	 * Helper method that initializes the window.
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
		closeButtonConstraints.gridheight = 1;
		closeButtonConstraints.gridwidth = 1;
		closeButtonConstraints.anchor = GridBagConstraints.FIRST_LINE_START;
		add(closeButton, closeButtonConstraints);
		
		JButton submitButton = new JButton("Submit");
		submitButton.addActionListener(controller);
		GridBagConstraints submitButtonConstraints = new GridBagConstraints();
		submitButtonConstraints.gridx = 1;
		submitButtonConstraints.gridy = 0;
		submitButtonConstraints.weightx = 0.25;
		submitButtonConstraints.weighty = 0.15;
		submitButtonConstraints.gridheight = 1;
		submitButtonConstraints.gridwidth = 1;
		submitButtonConstraints.anchor = GridBagConstraints.PAGE_START;
		add(submitButton, submitButtonConstraints);
		
		form = new StatsForm();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.add(form);
		GridBagConstraints formConstraints = new GridBagConstraints();
		formConstraints.gridx = 0;
		formConstraints.gridy = 1;
		formConstraints.weightx = 1;
		formConstraints.weighty = 1;
		formConstraints.gridheight = 1;
		formConstraints.gridwidth = 2;
		formConstraints.anchor = GridBagConstraints.CENTER;
		formConstraints.insets = new Insets(0, 60, 0, 60);
		add(form, formConstraints);
	}
	
	/**
	 * Returns the form within this panel.
	 * @return form the form nested within this panel
	 */
	public StatsForm getForm(){
		return form;
	}
}
