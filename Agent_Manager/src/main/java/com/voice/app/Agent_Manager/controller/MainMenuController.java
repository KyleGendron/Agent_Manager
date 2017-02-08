package com.voice.app.Agent_Manager.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.voice.app.Agent_Manager.view.MainMenuView;

/**
 * Controller for main menu frame
 * @author Kyle Gendron
 *
 */
public class MainMenuController implements ActionListener{
	private MainMenuView view;
	
	/**
	 * Default constructor
	 */
	public MainMenuController(){
		this.view = new MainMenuView(this);
	}
	
	/**
	 * Helper method used by App to initialize GUI in thread-safe manner.
	 * @see {@link App}, {@link MainMenuView} 
	 */
	public void initializeGUI(){
		this.view.initialize();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()){
		case "Add Leads From File":
			System.out.println("Adding Leads from file.");
			break;
		case "Add Leads Manually":
			System.out.println("Adding Leads manually.");
			break;
		case "Add Stats From File":
			System.out.println("Adding Stats from file.");
			break;
		case "Add Stats Manually":
			System.out.println("Adding Stats manually.");
			break;
		case "Display All Lead Records":
			System.out.println("Displaying all Lead Records.");
			break;
		case "Display All Stats Records":
			System.out.println("Displaying all Stats Records.");
			break;
		case "Search All Lead Records":
			System.out.println("Searching all Leads Records.");
			break;
		case "Search All Stats Records":
			System.out.println("Searching all Stats Records.");
			break;
		case "Exit":
			System.exit(0);
			break;
		}
	}
}
