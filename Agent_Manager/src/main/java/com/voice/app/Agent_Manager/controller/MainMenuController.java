package com.voice.app.Agent_Manager.controller;

import com.voice.app.Agent_Manager.view.MainMenuView;

/**
 * Controller for main menu frame
 * @author Kyle Gendron
 *
 */
public class MainMenuController {
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
}
